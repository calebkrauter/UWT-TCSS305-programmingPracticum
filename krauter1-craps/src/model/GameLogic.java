package model;

import java.util.ArrayList;
import java.util.Random;

public class GameLogic {
    private static int myPlayerScore = 0;
    private static int myPlayerWins = 0;
    private static int myHouseWins = 0;
    private Random random = new Random();
    private static ArrayList<Integer> luckyNumbers;
    private static ArrayList<Integer> unLuckyNumbers;
    private static ArrayList<Integer> awardPointNumbers;
    private int myRandomRoll1;
    private int myRandomRoll2;
    private int mySum = 0;
    private static int myRollCounter = 0;
    private static int myCounter = -1;
    private int myFirstRoll = 0;


    private static boolean myWin = false;

    private static int myPool = 0;
    private static boolean myPlayerWon = false;
    private static boolean myHouseWon = false;
    private static int myCurrentCash = 0;

    public GameLogic() {
        mySum = getRollTotal();
        myCounter++;
    }

    public void scoreLogic() {
        myRollCounter++;
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
                setWinValue(true);
                setPlayerWon(true);
                setHouseWon(false);
                setPlayerWins();

            }
            if (unLuckyNumbers.contains(mySum)) {
                setWinValue(true);
                setPlayerWon(false);
                setHouseWon(true);
                setHouseWins();


            } else if (awardPointNumbers.contains(mySum)) {
                myFirstRoll = getRollTotal();
                setPlayerScore(getRollTotal());
                setWinValue(false);
                setPlayerWon(false);
                setHouseWon(false);
            }
        } else {
            if (awardPointNumbers.contains(mySum)) {
                setPlayerScore(myFirstRoll);
                setWinValue(false);
                setPlayerWon(false);
                setHouseWon(false);
            }
            if (getRollTotal() == myFirstRoll) {
                setWinValue(true);
                setPlayerWon(true);
                setHouseWon(false);
                setPlayerWins();

            } else if (getRollTotal() == 7) {
                setWinValue(true);
                setPlayerWon(false);
                setHouseWon(true);
                setHouseWins();
            } else {
                setWinValue(false);
                setPlayerWon(false);
                setHouseWon(false);
            }
        }

    }

public void updateWalletAfterBet(int theBet, boolean theBetButtonsEnabled) {
    myPool += theBet;
    if (theBetButtonsEnabled == false) {
        setPool(myPool);
    }

    setWallet(getWallet() - theBet);
}

public void setWallet(int theCurrentCash) {
    myCurrentCash = theCurrentCash;
}

public void setPool(int thePool) {
    myPool = thePool;
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
public void setHouseWon(boolean theHouseWon) {
        myHouseWon = theHouseWon;
    }
    public boolean getHouseWon() {
        return myHouseWon;
    }
public boolean getPlayerWon() {
    return myPlayerWon;
}
    public void setPlayerWins() {
        myRollCounter = 0;
        setPlayerScore(0);
        myPlayerWins++;

        if (getPlayerWon()) {
            myCurrentCash += getPool()*2;
            setWallet(myCurrentCash);
            setPool(0);
        }
    }

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
        setPool(0);

    }

    public void setPlayerScore(int theValue) {
        myPlayerScore = theValue;
    }
    public void setRollTotal() {
        mySum = getRandomRoll1() + getRandomRoll2();
    }
    public void setRollTotalZero() {
        mySum = 0;
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

    private void setPlayerWins(int theWinCount) {
        myPlayerWins = theWinCount;
    }
    private void setHouseWins(int theWinCount) {
        myHouseWins = theWinCount;
    }

    public void resetGameData() {
        setWallet(0);
        setPool(0);
        setPlayerWon(false);
        setWinValue(false);
        setPlayerWins(0);
        setHouseWins(0);
    }

}

