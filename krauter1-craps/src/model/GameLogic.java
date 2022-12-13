package model;

import controller.*;
import java.util.ArrayList;
import java.util.Random;

public class GameLogic {
    private static int myPlayerScore = 0;
    private static int myPlayerWins = 0;
    private static int myHouseWins = 0;
    private Random random = new Random();
//    private CrapsController crapsController;
    private static ArrayList<Integer> luckyNumbers;
    private static ArrayList<Integer> unLuckyNumbers;
    private static ArrayList<Integer> awardPointNumbers;
    private int myRandomRoll1;
    private int myRandomRoll2;
    private int mySum = 0;
    private static int myRollCounter = 0;
    private static int myRoundCounter = 0;
    private int myFirstRoll = 0;


    private boolean myScoreIsAwarded = false;
    private boolean myRollsSame = false;
    private static int myCash;
    private static boolean myWin = false;
    private static int myInitialWinCount = 0;
    private static int myLastRound = 0;
    private static boolean myRoundUpdate = false;

    // TODO - https://stackoverflow.com/questions/26562162/attempt-to-invoke-virtual-method-int-java-util-random-nextintint-on-a-null-o
    // TODO - fix when pressing roll, doesn't get random value. Random values should be set and update values for
    // the side of the dice and the total and the game gui should update when roll is pressed.
    public GameLogic() {
        mySum = getRollTotal();
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
                setPlayerWins();
                System.out.println("Player wins " + getPlayerWins());
            }
            if (unLuckyNumbers.contains(mySum)) {
                setHouseWins();
                System.out.println("House wins " + getHouseWins());

            } else if (awardPointNumbers.contains(mySum)) {
                setScoreIsAwarded(true);
                // Should only happen one time during the first roll
                myFirstRoll = getRollTotal();
                setPlayerScore(getRollTotal());
                System.out.println("Score " + getPlayerScore());
            }
        } else {
            // checks point if correct value sets score
            if (awardPointNumbers.contains(mySum)) {
                setScoreIsAwarded(true);
                setPlayerScore(myFirstRoll);
                System.out.println("Score " + getPlayerScore());
            }
            // true that -> prev roll and curr roll are same
            if (getRollTotal() == myFirstRoll) {
                System.out.println(" my first roll : " + myFirstRoll + " Roll TOTAL : " + getRollTotal());
                myRollsSame = true;
                System.out.println("PLAYER WINS");
                setPlayerWins();
            } else if (getRollTotal() == 7) {
                System.out.println(" my first roll : " + myFirstRoll + " Roll TOTAL : " + getRollTotal());
                System.out.println("HOUSE WINS");
                setHouseWins();
            } else {
                System.out.println("KEEP ROLLING -> my Previous roll : " + myFirstRoll + " Roll TOTAL : " + getRollTotal());
            }
        }


    }

    private void setScoreIsAwarded(boolean theValue) {
        myScoreIsAwarded = theValue;
    }
    private boolean getScoreIsAwarded() {
        return myScoreIsAwarded;
    }
    public void setPlayerWins() {
        myRollCounter = 0;
        myInitialWinCount = myPlayerWins;
        setPlayerScore(0);
        System.out.println("Round reset: " + myRoundCounter);
        setMyWinValue(true);
        myPlayerWins++;
        System.out.println("Wins " + myPlayerWins);
        if (myInitialWinCount < myPlayerWins) {
            myWin = true;
        }
    }

    public void setMyWinValue(boolean theValue) {
        myWin = theValue;
    }
    public boolean getWinValue() {
        return myWin;
    }
    public void setHouseWins() {
        myRollCounter = 0;
        myHouseWins++;
        setPlayerScore(0);
        setMyWinValue(false);
    }
    public void setPlayerScore(int theValue) {
        myPlayerScore = theValue;
        setMyWinValue(false);
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

}