package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * GameLogic does the heavy lifting for updating data according to the game rules.
 *
 * @author Caleb Krauter
 * @version 1.1
 */
public class GameLogic {

    /**
     * Player score initialized at 0.
     */
    private static int myPlayerScore = 0;

    /**
     * Player wins initialized at 0.
     */
    private static int myPlayerWins = 0;

    /**
     * House wins initialized at 0.
     */
    private static int myHouseWins = 0;

    /**
     * An instance of the random object referenced for
     * the randomness in a die roll.
     */
    private Random random = new Random();

    /**
     * An arraylist containing values that are
     * responsible for a player win on the first round.
     */
    private static ArrayList<Integer> luckyNumbers;

    /**
     * An arraylist containing values that are
     * responsible for a player loss on the first round.
     */
    private static ArrayList<Integer> unLuckyNumbers;

    /**
     * An arraylist containing values that are
     * responsible for a player loss and for choosing a
     * score on the first round.
     */
    private static ArrayList<Integer> awardPointNumbers;

    /**
     * A reference to the value of a random die roll.
     */
    private int myRandomRoll1;

    /**
     * A reference to the value of a random die roll.
     */
    private int myRandomRoll2;

    /**
     *  A reference to the sum of the points from two dies being rolled
     */
    private int mySum;

    /**
     * Counts how many times the scoreLogic() function has been called.
     * This value gets reset at specific times and is used to help
     * determine when the first roll of a game/round is so that
     * the correct game logic is used.
     */
    private static int myRollCounter = 0;

    /**
     * A value initialized at zero used to help the program determine
     * when the first roll is of any game/round in reference to myRollCounter.
     */
    private int myFirstRoll = 0;

    /**
     * A value that is used as a parameter to set win/loss.
     */
    private static boolean myWin = false;

    /**
     * A pool of money initialized at zero used to refer to
     * the amount of money that has been bet and multiplied by 2
     * in case the player wins so that they get their pool of money
     * back plus their winnings.
     */
    private static int myPool = 0;

    /**
     * Value representing if the player won or loss.
     */
    private static boolean myPlayerWon = false;

    /**
     * Value representing if the house won or loss.
     */
    private static boolean myHouseWon = false;

    /**
     * The current amount of money held.
     */
    private static int myCurrentCash = 0;

    /**
     * The constructor for GameLogic.
     */
    public GameLogic() {
        mySum = getRollTotal();
    }

    /**
     * A method containing logic ensuring that the
     * game rules can be followed.
     */
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

    /**
     * Updates the pool of money with the passed bet and
     * updates the wallet.
     * @param theBet current bet value passed in.
     * @param theBetButtonsEnabled boolean value.
     */
    public void updateWalletAfterBet(int theBet, boolean theBetButtonsEnabled) {
        myPool += theBet;
        if (theBetButtonsEnabled == false) {
            setPool(myPool);
        }

        setWallet(getWallet() - theBet);
    }

    /**
     * Sets the wallet with passed value.
     * @param theCurrentCash int value passed.
     */
    public void setWallet(int theCurrentCash) {
        myCurrentCash = theCurrentCash;
    }

    /**
     * Sets the pool of money used to determine
     * the amount of money should be given back
     * to the player should they win. The pool
     * is multiplied by two and put in the wallet
     * if the player wins.
     * @param thePool
     */
    private void setPool(int thePool) {
        myPool = thePool;
    }

    /**
     * Set boolean value stating that the player won or lost.
     * @param thePlayerWon boolean value.
     */
    private void setPlayerWon(boolean thePlayerWon) {
        myPlayerWon = thePlayerWon;
    }

    /**
     * Set boolean value stating that the player won or lost.
     * @param theHouseWon boolean value.
     */
    private void setHouseWon(boolean theHouseWon) {
        myHouseWon = theHouseWon;
    }

    /**
     * Set player wins.
     * Updates important information
     * for the next round.
     */
    private void setPlayerWins() {
        myRollCounter = 0;
        setPlayerScore(0);
        myPlayerWins++;

        if (getPlayerWon()) {
            myCurrentCash += getPool()*2;
            setWallet(myCurrentCash);
            setPool(0);
        }
    }

    /**
     * Set House wins.
     * Updates important information
     * for the next round.
     */
    private void setHouseWins() {
        myRollCounter = 0;
        myHouseWins++;
        setPlayerScore(0);
        setPool(0);

    }

    /**
     * Set win boolean value.
     * @param theValue boolean value.
     */
    public void setWinValue(boolean theValue) {
        myWin = theValue;
    }

    /**
     * Sets the player's current score to roll.
     * @param theValue int value.
     */
    public void setPlayerScore(int theValue) {
        myPlayerScore = theValue;
    }

    /**
     * Sets the total of the two rolled dice.
     */
    public void setRollTotal() {
        mySum = getRandomRoll1() + getRandomRoll2();
    }

    /**
     * Sets the random roll of die 1.
     */
    public void setMyRandomRoll1() {
        myRandomRoll1 = random.nextInt(1, 7);
    }

    /**
     * Sets the random roll of die 1.
     */
    public void setMyRandomRoll2() {
        myRandomRoll2 = random.nextInt(1, 7);
    }

    /**
     * Gets current cash amount.
     * @return myCurrentCash int value.
     */
    public int getWallet() {
        return myCurrentCash;
    }

    /**
     * Gets the pool of money.
     * @return myPool int value.
     */
    private int getPool() {
        return myPool;
    }

    /**
     * Gets boolean value stating that the player won or lost.
     * @return myPlayerWon boolean value.
     */
    public boolean getPlayerWon() {
        return myPlayerWon;
    }
    /**
     * Gets boolean value stating that the house won or lost.
     * @return myHouseWon boolean value.
     */
    public boolean getHouseWon() {
        return myHouseWon;
    }

    /**
     * Gets boolean value stating that either the house
     * or the player has won.
     * @return boolean value.
     */
    public boolean getWinValue() {
        return myWin;
    }

    /**
     * Gets player's wins amount.
     * @return myPlayerWins int value.
     */
    public int getPlayerWins() {
        return myPlayerWins;
    }

    /**
     * Gets house's wins amount.
     * @return myPlayerWins int value.
     */
    public int getHouseWins() {
        return myHouseWins;
    }

    /**
     * Gets player score.
     * @return myPlayerScore int value.
     */
    public int getPlayerScore() {
        return myPlayerScore;
    }

    /**
     * Gets a random die roll value.
     * @return myRandomRoll1 int value.
     */
    public int getRandomRoll1() {
        return myRandomRoll1;
    }

    /**
     * Gets a random die roll value.
     * @return myRandomRoll2 int value.
     */
    public int getRandomRoll2() {
        return myRandomRoll2;
    }

    /**
     * Gets a random dice roll total value.
     * @return mySum int value.
     */
    public int getRollTotal() {
        return mySum;
    }

    /**
     * Sets player's wins with theWinCount.
     * @param theWinCount int value.
     */
    private void setPlayerWins(int theWinCount) {
        myPlayerWins = theWinCount;
    }

    /**
     * Sets house's wins with theWinCount.
     * @param theWinCount int value.
     */
    private void setHouseWins(int theWinCount) {
        myHouseWins = theWinCount;
    }

    /**\
     * Resets important game data for a new game
     * to be started again.
     */
    public void resetGameData() {
        setWallet(0);
        setPool(0);
        setPlayerWon(false);
        setWinValue(false);
        setPlayerWins(0);
        setHouseWins(0);
    }

}

