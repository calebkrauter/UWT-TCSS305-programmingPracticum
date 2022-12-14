package view;

import javax.swing.*;
import java.awt.*;

// Todo remove unnecessary calculations for myx and myy from craps controller.
public class DrawDice extends JPanel {

    private int myX;
    private int myY;
    private int myX1 = 0;
    private int myY1 = 50;
    private int myY2 = 200;
    private static final int myDieSide = 100;
    private static final int myDotDiameter = 10;
    private int myRandNum1;
    private int myRandNum2;
    private Graphics myGraphics;
    private Graphics2D g2D;



    public DrawDice(LayoutManager theLayout, int randomRoll1, int randomRoll2) {
        super(theLayout);
        setRandomNum1(randomRoll1);
        setRandomNum2(randomRoll2);

    }
    public void setRandomNum1(int theRandNum1) {
        myRandNum1 = theRandNum1;
    }
    public int getRandomNum1() {
        return myRandNum1;
    }
    public void setRandomNum2(int theRandNum2) {
        myRandNum2 = theRandNum2;
    }
    public int getRandomNum2() {
        return myRandNum2;
    }

    @Override
    public void paintComponent(Graphics theGraphics) {
        super.paintComponent(theGraphics);
        myGraphics = theGraphics;
        g2D = (Graphics2D) myGraphics;

        g2D.setPaint(Color.WHITE);
        g2D.fill3DRect(myX, myY1, myDieSide, myDieSide, true);

        g2D.setPaint(Color.WHITE);
        g2D.fill3DRect(myX, myY2, myDieSide, myDieSide, true);

        chooseSideDie1();
        chooseSideDie2();
    }

    public void chooseSideDie1() {
        final int num1 = getRandomNum1();
        if (num1 == 1) drawSide1Die1();
        if (num1 == 2) drawSide2Die1();
        if (num1 == 3) drawSide3Die1();
        if (num1 == 4) drawSide4Die1();
        if (num1 == 5) drawSide5Die1();
        if (num1 == 6) drawSide6Die1();
    }
    public void chooseSideDie2() {
        final int num2 = getRandomNum2();
        if (num2 == 1) drawSide1Die2();
        if (num2 == 2) drawSide2Die2();
        if (num2 == 3) drawSide3Die2();
        if (num2 == 4) drawSide4Die2();
        if (num2 == 5) drawSide5Die2();
        if (num2 == 6) drawSide6Die2();
    }

    private void drawSide1Die1(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(45, myY1 + 45, myDotDiameter, myDotDiameter);
    }
    private void drawSide2Die1(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY1 + 15, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY1 + 75, myDotDiameter, myDotDiameter);
    }
    private void drawSide3Die1(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY1 + 15, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY1 + 75, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(45, myY1 + 45, myDotDiameter, myDotDiameter);
    }
    private void drawSide4Die1(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY1 + 15, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY1 + 75, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY1 + 15, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY1 + 75, myDotDiameter, myDotDiameter);
    }
    private void drawSide5Die1(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(45, myY1 + 45, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY1 + 15, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY1 + 75, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY1 + 15, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY1 + 75, myDotDiameter, myDotDiameter);
    }
    private void drawSide6Die1(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY1 + 15, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY1 + 75, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY1 + 15, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY1 + 75, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY1 + 45, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY1 + 45, myDotDiameter, myDotDiameter);
    }


    private void drawSide1Die2(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(45, myY2 + 45, myDotDiameter, myDotDiameter);
    }
    private void drawSide2Die2(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY2 + 15, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY2 + 75, myDotDiameter, myDotDiameter);
    }
    private void drawSide3Die2(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY2 + 15, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY2 + 75, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(45, myY2 + 45, myDotDiameter, myDotDiameter);
    }
    private void drawSide4Die2(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY2 + 15, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY2 + 75, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY2 + 15, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY2 + 75, myDotDiameter, myDotDiameter);
    }
    private void drawSide5Die2(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(45, myY2 + 45, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY2 + 15, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY2 + 75, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY2 + 15, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY2 + 75, myDotDiameter, myDotDiameter);
    }
    private void drawSide6Die2(){
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY2 + 15, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY2 + 75, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY2 + 15, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY2 + 75, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(15, myY2 + 45, myDotDiameter, myDotDiameter);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(75, myY2 + 45, myDotDiameter, myDotDiameter);
    }
}
