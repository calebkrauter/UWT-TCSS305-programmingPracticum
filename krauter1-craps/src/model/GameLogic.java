package model;

import java.util.ArrayList;
import java.util.Random;

public class GameLogic {
    private static int myPlayerScore = 0;
    private static int myPlayerWins = 0;
    private static int myHouseWins = 0;
    private static int myStartingValue = 0;
    private Random random = new Random();
//    private CrapsController crapsController;
    private static ArrayList<Integer> luckyNumbers;
    private static ArrayList<Integer> unLuckyNumbers;
    private static ArrayList<Integer> awardPointNumbers;
    private int myRandomRoll1;
    private int myRandomRoll2;
    private int mySum = 0;
    private static int myRollCounter = 0;
    private static int myCounter = -1;
    private int myFirstRoll = 0;


    private boolean myScoreIsAwarded = false;
    private boolean myRollsSame = false;
    private static int myCash = 0;
    private static boolean myWin = false;
    private static int myInitialWinCount = 0;
    private static int myLastRound = 0;
    private static boolean myRoundUpdate = false;
    private static int myBet = 0;
    private static int myInitialCash = 0;
    private static int myTempCash = 0;

    // TODO - https://stackoverflow.com/questions/26562162/attempt-to-invoke-virtual-method-int-java-util-random-nextintint-on-a-null-o
    // TODO - fix when pressing roll, doesn't get random value. Random values should be set and update values for
    // the side of the dice and the total and the game gui should update when roll is pressed.
    public GameLogic() {
        mySum = getRollTotal();
//        setWallet(mySum);
//        myInitialCash = myCash;
        myCounter++;
    }

    public void scoreLogic() {
        myRollCounter++;
        System.out.println(myCounter);

        random = new Random();
        luckyNumbers = new ArrayList();
        luckyNumbers.add(7);
        luckyNumbers.add(11);

        unLuckyNumbers = new ArrayList();
        unLuckyNumbers.add(2);
        unLuckyNumbers.add(3);
        unLuckyNumbers.add(12);

        awardPointNumbers = new ArrayList();
        awardPointNumbers.add(4);
        awardPointNumbers.add(5);
        awardPointNumbers.add(6);
        awardPointNumbers.add(8);
        awardPointNumbers.add(9);
        awardPointNumbers.add(10);
        if (myRollCounter == 1) {
            if (luckyNumbers.contains(mySum)) {
                System.out.println("Player wins " + getPlayerWins());
                setWinValue(true);
                setPlayerWon(true);
                setPlayerWins();

//                setWonBet();
                myBet = 0;
                myTempCash = 0;
//                myInitialCash = getWallet();
//                myCounter = 0;
                    myInitialCash = myCash;

            }
            if (unLuckyNumbers.contains(mySum)) {
                System.out.println("House wins " + getHouseWins());
                setWinValue(true);
                setPlayerWon(false);
                setHouseWins();

                myBet = 0;
                myTempCash = 0;
//                myInitialCash = getWallet();
//                myCounter = 0;
                myInitialCash = myCash;


            } else if (awardPointNumbers.contains(mySum)) {
//                setScoreIsAwarded(true);
                // Should only happen one time during the first roll
                myFirstRoll = getRollTotal();
                setPlayerScore(getRollTotal());
                System.out.println("Score " + getPlayerScore());
                setWinValue(false);
                setPlayerWon(false);
            }
        } else {
            // checks point if correct value sets score
            if (awardPointNumbers.contains(mySum)) {
//                setScoreIsAwarded(true);
                setPlayerScore(myFirstRoll);
                System.out.println("Score " + getPlayerScore());
                setWinValue(false);
                setPlayerWon(false);
            }
            // true that -> prev roll and curr roll are same
            if (getRollTotal() == myFirstRoll) {
                System.out.println(" my first roll : " + myFirstRoll + " Roll TOTAL : " + getRollTotal());
                myRollsSame = true;
                System.out.println("PLAYER WINS");
                setWinValue(true);
                setPlayerWon(true);
                setPlayerWins();

//                setWonBet();
                myBet = 0;
                myTempCash = 0;
//                myInitialCash = getWallet();
//                myCounter = 0;
                myInitialCash = myCash;


            } else if (getRollTotal() == 7) {
                System.out.println(" my first roll : " + myFirstRoll + " Roll TOTAL : " + getRollTotal());
                System.out.println("HOUSE WINS");
                setWinValue(true);
                setPlayerWon(false);
                setHouseWins();
                myBet = 0;
                myTempCash = 0;
//                myInitialCash = getWallet();
//                myCounter = 0;
                myInitialCash = myCash;


            } else {
                System.out.println("KEEP ROLLING -> my Previous roll : " + myFirstRoll + " Roll TOTAL : " + getRollTotal());
                setWinValue(false);
                setPlayerWon(false);
            }
        }


    }

    private static int myPool = 0;
    private static boolean myPlayerWon = false;
    private static int myCurrentCash = 0;

public void updateWalletAfterBet(int theBet, boolean theBetButtonsEnabled) {
    myPool += theBet;
    System.out.println("My pool " + myPool);
    System.out.println("My current bet " + theBet);
    if (theBetButtonsEnabled == false) {
        setPool(myPool);
        System.out.println("My pool " + myPool);
    }

    setWallet(getWallet() - theBet);
}

public void setWallet(int theCurrentCash) {

    myCurrentCash = theCurrentCash;
    System.out.println("My current cash " + myCurrentCash);
}

public void setPool(int thePool) {
    myPool = thePool;
    System.out.println("My current pool " + myPool);
}
public int getWallet() {
    return myCurrentCash;
}
public int getPool() {
    return myPool;
}

public void setPlayerWon(boolean thePlayerWon) {
    myPlayerWon = thePlayerWon;
}
public boolean getPlayerWon() {
    return myPlayerWon;
}






//    private void setScoreIsAwarded(boolean theValue) {
//        myScoreIsAwarded = theValue;
//    }
//    private boolean getScoreIsAwarded() {
//        return myScoreIsAwarded;
//    }
    public void setPlayerWins() {
        myRollCounter = 0;
//        myInitialWinCount = myPlayerWins;
        setPlayerScore(0);
        myPlayerWins++;
        System.out.println("Wins " + myPlayerWins);
        System.out.println("Player won " + myPlayerWon);

        if (getPlayerWon()) {
            int tempval = getPool()*2;
            System.out.println("Cash after a win " + myCurrentCash + " + " + tempval);
            myCurrentCash += getPool()*2;
            setWallet(myCurrentCash);
            System.out.println("Equals " + myCurrentCash);
            setPlayerWon(false);
            setPool(0);
        }
    }
//    public void setCash(int theCash) {
//        myInitialCash = theCash;
//    }

    public void setWinValue(boolean theValue) {
        myWin = theValue;
    }
    public boolean getWinValue() {
        return myWin;
    }
    public void setHouseWins() {
        myRollCounter = 0;
        myHouseWins++;
        setPlayerScore(0);
        myBet = 0;
        setPool(0);

    }
    public void setPlayerScore(int theValue) {
        myPlayerScore = theValue;
    }
    public void setMyRollTotal() {
        mySum = getRandomRoll1() + getRandomRoll2();
    }

    public void setMyRandomRoll1() {
        myRandomRoll1 = random.nextInt(1, 7);
    }

    public void setMyRandomRoll2() {
        myRandomRoll2 = random.nextInt(1, 7);
    }

    public int getPlayerWins() {
        return myPlayerWins;
    }
    public int getHouseWins() {
        return myHouseWins;
    }
    public int getPlayerScore() {
        return myPlayerScore;
    }

    public int getRandomRoll1() {
        return myRandomRoll1;
    }
    public int getRandomRoll2() {
        return myRandomRoll2;
    }

    public int getRollTotal() {
        return mySum;
    }

//    private void setWonBet() {
//        if (getWinValue() == true) {
//            myCash = myTempCash*2 + myCash;
//            System.out.println("I won! "+ myTempCash + " total " + myCash);
//            setWallet(myCash);
//        }
//    }

//    public void updateWallet(int theBet) {
//
////        myCounter++;
//
//        myBet = theBet;
//        if (getWinValue() == false) {
////            myInitialCash = myCash;
//            System.out.println("My current cash " + myCash);
//
//            System.out.println("I started with " + getStartingValue() + " and I bet " + myBet);
//            myCash = getStartingValue() - myBet;
//            System.out.println("I currently have " + myCash);
//            myTempCash = getStartingValue() - myCash;
//            System.out.println("If I win, I get a total of " + myTempCash*2 + " + " + myCash);
//            setWallet(myCash);
//        }
//    }

//    public void setWallet(int theCash) {
//        myCash = theCash;
//        System.out.println(myCash);
//    }
//    public int getWallet() {
//        return myCash;
//    }
//
//    public int getStartingValue() {
//        return myStartingValue;
//    }
//
//    public void setStartingValue(int theValue) {
//        myStartingValue = theValue;
//    }
}

