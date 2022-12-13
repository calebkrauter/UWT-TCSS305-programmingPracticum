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

// TODO - https://stackoverflow.com/questions/26562162/attempt-to-invoke-virtual-method-int-java-util-random-nextintint-on-a-null-o
    // TODO - fix when pressing roll, doesn't get random value. Random values should be set and update values for
    // the side of the dice and the total and the game gui should update when roll is pressed.
    public GameLogic() {
//        setPlayerWins();
//        setHouseWins();
////        setPlayerScore(0);

//
//        setMyRandomRoll1();
//        setMyRandomRoll2();
    }

    public void rollDice() {

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
//        mySum = myRandomRoll1 + myRandomRoll2;


//        setMyTotal(myRandomRoll1 + myRandomRoll2);

//        crapsController = new CrapsController(myRandomRoll1, myRandomRoll2,
//                mySum, myPlayerWins, myHouseWins, myPlayerScore);
        if (luckyNumbers.contains(mySum)) {
            setPlayerWins();
            System.out.println(getPlayerWins());
        }
        if (unLuckyNumbers.contains(mySum)) {
            setHouseWins();
            System.out.println(getHouseWins());

        }
        if (awardPointNumbers.contains(mySum)) {
            setPlayerScore(mySum);
            System.out.println(getPlayerScore());

        }
    }
    private void setPlayerWins() {
        myPlayerWins++;
    }
    private void setHouseWins() {
        myHouseWins++;
    }
    public static void setPlayerScore(int theValue) {
        myPlayerScore = theValue + myPlayerScore;
    }
    private void setMyTotal(int theValue) {
        mySum = theValue;
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