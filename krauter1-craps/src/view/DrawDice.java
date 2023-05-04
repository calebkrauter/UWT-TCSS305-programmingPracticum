package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;

/**
 * DrawDice draws the dice squares and the dots depending
 * on the roll values.
 *
 * @author Caleb Krauter
 * @version 1.1
 */
public class DrawDice extends JPanel {

    /**
     * An x coordinate used to determine the location of
     * painting.
     */
    private final int myX = 0;

    /**
     * A y coordinate used to determine the location of
     * painting.
     */
    private final int myY1 = 50;

    /**
     * A y coordinate used to determine the location of
     * painting.
     */
    private final int myY2 = 200;

    /**
     * The length of any die side.
     */
    private static final int DIE_SIDE = 100;

    /**
     * The diameter of any dot on any die.
     */
    private static final int DOT_DIAMETER = 10;

    /**
     * A random number result from a rolled die.
     */
    private int myRandNum1;

    /**
     * A random number result from a rolled die.
     */
    private int myRandNum2;

    /**
     * Graphics used for painting.
     */
    private Graphics myGraphics;

    /**
     * 2D Graphics used for painting.
     */
    private Graphics2D g2D;


    /**
     * DrawDice constructor.
     *
     * @param theGridBagLayout layout manager.
     * @param randomRoll1 a random die roll value.
     * @param randomRoll2 a random die roll value.
     */
    public DrawDice(LayoutManager theGridBagLayout,
                    int randomRoll1,
                    int randomRoll2) {

        super(theGridBagLayout);

        setRandomNum1(randomRoll1);
        setRandomNum2(randomRoll2);
    }

    /**
     * Sets a random number value from a rolled die.
     * @param theRandNum1 random die value.
     */
    public void setRandomNum1(int theRandNum1) {
        myRandNum1 = theRandNum1;
    }

    /**
     * Sets a random number value from a rolled die.
     * @param theRandNum2 random die value.
     */
    public void setRandomNum2(int theRandNum2) {
        myRandNum2 = theRandNum2;
    }

    /**
     * Gets a random number value from a rolled die.
     */
    private int getRandomNum1() {
        return myRandNum1;
    }

    /**
     * Gets a random number value from a rolled die.
     */
    private int getRandomNum2() {
        return myRandNum2;
    }

    /**
     * Paints dice squares and calls methods to choose and then draw dots
     * for each side of the dice.
     * @param theGraphics the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(Graphics theGraphics) {
        super.paintComponent(theGraphics);
        myGraphics = theGraphics;
        g2D = (Graphics2D) myGraphics;

        g2D.setPaint(Color.WHITE);
        g2D.fill3DRect(myX, myY1, DIE_SIDE, DIE_SIDE, true);

        g2D.setPaint(Color.WHITE);
        g2D.fill3DRect(myX, myY2, DIE_SIDE, DIE_SIDE, true);

        chooseSideDie1();
        chooseSideDie2();
    }

    /**
     * chooseSideDie1 chooses which side of the
     * die 1 to paint.
     */
    public void chooseSideDie1() {
        final int num1 = getRandomNum1();
        if (num1 == 1) drawSide1Die1();
        if (num1 == 2) drawSide2Die1();
        if (num1 == 3) drawSide3Die1();
        if (num1 == 4) drawSide4Die1();
        if (num1 == 5) drawSide5Die1();
        if (num1 == 6) drawSide6Die1();
    }

    /**
     * chooseSideDie2 chooses which side of the
     * die 2 to paint.
     */
    public void chooseSideDie2() {
        final int num2 = getRandomNum2();
        if (num2 == 1) drawSide1Die2();
        if (num2 == 2) drawSide2Die2();
        if (num2 == 3) drawSide3Die2();
        if (num2 == 4) drawSide4Die2();
        if (num2 == 5) drawSide5Die2();
        if (num2 == 6) drawSide6Die2();
    }

    /**
     * Paints side with 1 dot on die 1.
     */
    private void drawSide1Die1(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(45, myY1 + 45, DOT_DIAMETER, DOT_DIAMETER);
    }

    /**
     * Paints side with 2 dots on die 1.
     */
    private void drawSide2Die1(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY1 + 15, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY1 + 75, DOT_DIAMETER, DOT_DIAMETER);
    }

    /**
     * Paints side with 3 dots on die 1.
     */
    private void drawSide3Die1(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY1 + 15, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY1 + 75, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(45, myY1 + 45, DOT_DIAMETER, DOT_DIAMETER);
    }

    /**
     * Paints side with 4 dots on die 1.
     */
    private void drawSide4Die1(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY1 + 15, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY1 + 75, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY1 + 15, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY1 + 75, DOT_DIAMETER, DOT_DIAMETER);
    }

    /**
     * Paints side with 5 dots on die 1.
     */
    private void drawSide5Die1(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(45, myY1 + 45, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY1 + 15, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY1 + 75, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY1 + 15, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY1 + 75, DOT_DIAMETER, DOT_DIAMETER);
    }

    /**
     * Paints side with 6 dots on die 1.
     */
    private void drawSide6Die1(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY1 + 15, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY1 + 75, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY1 + 15, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY1 + 75, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY1 + 45, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY1 + 45, DOT_DIAMETER, DOT_DIAMETER);
    }

    /**
     * Paints side with 1 dots on die 2.
     */
    private void drawSide1Die2(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(45, myY2 + 45, DOT_DIAMETER, DOT_DIAMETER);
    }

    /**
     * Paints side with 2 dots on die 2.
     */
    private void drawSide2Die2(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY2 + 15, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY2 + 75, DOT_DIAMETER, DOT_DIAMETER);
    }

    /**
     * Paints side with 3 dots on die 2.
     */
    private void drawSide3Die2(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY2 + 15, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY2 + 75, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(45, myY2 + 45, DOT_DIAMETER, DOT_DIAMETER);
    }

    /**
     * Paints side with 4 dots on die 2.
     */
    private void drawSide4Die2(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY2 + 15, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY2 + 75, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY2 + 15, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY2 + 75, DOT_DIAMETER, DOT_DIAMETER);
    }

    /**
     * Paints side with 5 dots on die 2.
     */
    private void drawSide5Die2(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(45, myY2 + 45, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY2 + 15, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY2 + 75, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY2 + 15, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY2 + 75, DOT_DIAMETER, DOT_DIAMETER);
    }

    /**
     * Paints side with 6 dots on die 2.
     */
    private void drawSide6Die2(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY2 + 15, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY2 + 75, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY2 + 15, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY2 + 75, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY2 + 45, DOT_DIAMETER, DOT_DIAMETER);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY2 + 45, DOT_DIAMETER, DOT_DIAMETER);
    }
}
