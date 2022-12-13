package model;

import java.util.ArrayList;
import java.util.Random;

public class GameLogic {
    private static int myPlayerTotal = 0;

    public GameLogic() {

    }

    public void rollDice() {
        Random random = new Random();
        ArrayList<Integer> luckyNumbers = new ArrayList();
        luckyNumbers.add(7);
        luckyNumbers.add(11);

        ArrayList<Integer> unLuckyNumbers = new ArrayList();
        unLuckyNumbers.add(2);
        unLuckyNumbers.add(3);
        unLuckyNumbers.add(12);

        ArrayList<Integer> awardPointNumbers = new ArrayList();
        awardPointNumbers.add(4);
        awardPointNumbers.add(5);
        awardPointNumbers.add(6);
        awardPointNumbers.add(8);
        awardPointNumbers.add(9);
        awardPointNumbers.add(10);

        int randomRoll1 = random.nextInt(1, 7);
        int randomRoll2 = random.nextInt(1, 7);

        System.out.println("Die 1 roll: " + randomRoll1);
        System.out.println("Die 2 roll: " + randomRoll2);
        int sum = randomRoll1 + randomRoll2;
        System.out.println("Sum rolls: " + sum);

        if (luckyNumbers.contains(sum)) {
            System.out.println("Player won this round! Roll: " + sum);
        }
        if (unLuckyNumbers.contains(sum)) {
            System.out.println("House won this round! Roll: " + sum);
        }
        if (awardPointNumbers.contains(sum)) {
            int initialPlayerTotal = myPlayerTotal;
            setPlayerTotal(sum);
            System.out.println(sum + " added to player point total of " + initialPlayerTotal + ". New total: " + myPlayerTotal);
        }
    }
    public static void setPlayerTotal(int theValue) {
        myPlayerTotal = theValue + myPlayerTotal;
    }
}