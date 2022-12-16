package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import static java.awt.event.KeyEvent.*;

public class Shortcuts {

    /**
     * The start item on the game menu.
     */
    private final JMenuItem myStartItem;

    /**
     * The reset item on the game menu.
     */
    private final JMenuItem myResetItem;

    /**
     * The exit item on the game menu.
     */
    private final JMenuItem myExitItem;

    /**
    * The rules item on the game menu.
    */
    private final JMenuItem myRulesItem;

    /**
     * The about item on the game menu.
     */
    private final JMenuItem myAboutItem;

    /**
     * The play again item on the game menu.
     */
    private final JMenuItem myPlayAgainItem;

    /**
     * The rules item on the game menu.
     */
    private final JButton myRollButton;

    /**
     * A bet button item on the game menu.
     */
    private final JButton myBetButton1;

    /**
     * A bet button item on the game menu.
     */
    private final JButton myBetButton2;

    /**
     * A bet button item on the game menu.
     */
    private final JButton myBetButton3;

    /**
     * A bet button item on the game menu.
     */
    private final JButton myBetButton4;

    /**
     * A bet button item on the game menu.
     */
    private final JButton myBetButton5;

    /**
     * A bet button item on the game menu.
     */
    private final JButton myBetButton6;

    /**
     * The play again button item on the game menu.
     */
    private final JButton myPlayAgainbutton;

    public Shortcuts(JMenuItem theStartItem,
                     JMenuItem theResetItem,
                     JMenuItem theExitItem,
                     JMenuItem theRulesItem,
                     JMenuItem theAboutItem,
                     JMenuItem thePlayAgainItem,
                     JButton theRollButton,
                     JButton theBetButton1,
                     JButton theBetButton2,
                     JButton theBetButton3,
                     JButton theBetButton4,
                     JButton theBetButton5,
                     JButton theBetButton6,
                     JButton thePlayAgainButton) {
        myStartItem = theStartItem;
        myResetItem = theResetItem;
        myExitItem = theExitItem;
        myRulesItem = theRulesItem;
        myAboutItem = theAboutItem;
        myPlayAgainItem = thePlayAgainItem;
        myRollButton = theRollButton;
        myBetButton1 = theBetButton1;
        myBetButton2 = theBetButton2;
        myBetButton3 = theBetButton3;
        myBetButton4 = theBetButton4;
        myBetButton5 = theBetButton5;
        myBetButton6 = theBetButton6;
        myPlayAgainbutton = thePlayAgainButton;

        myStartItem.setToolTipText("press 'Alt/Option' + 'S'");
        myStartItem.setAccelerator(KeyStroke.getKeyStroke(VK_S, ActionEvent.ALT_MASK));
        myResetItem.setToolTipText("press 'Alt/Option' + X'");
        myResetItem.setAccelerator(KeyStroke.getKeyStroke(VK_X, ActionEvent.ALT_MASK));
        myExitItem.setToolTipText("press 'Alt/Option' + 'C'");
        myExitItem.setAccelerator(KeyStroke.getKeyStroke(VK_C, ActionEvent.ALT_MASK));
        myRulesItem.setToolTipText("press 'Alt/Option' + 'I'");
        myRulesItem.setAccelerator(KeyStroke.getKeyStroke(VK_I, ActionEvent.ALT_MASK));
        myAboutItem.setToolTipText("press 'Alt/Option' + 'A'");
        myAboutItem.setAccelerator(KeyStroke.getKeyStroke(VK_A, ActionEvent.ALT_MASK));
        myPlayAgainItem.setToolTipText("press 'Alt/Option' + 'P'");
        myPlayAgainItem.setAccelerator(KeyStroke.getKeyStroke(VK_P, ActionEvent.ALT_MASK));

        myRollButton.setToolTipText("press 'Alt/Option+Control' + 'D'");
        myRollButton.setMnemonic(VK_D);
        myBetButton1.setToolTipText("press 'Alt/Option+Control' + '1'");
        myBetButton1.setMnemonic(VK_1);
        myBetButton2.setToolTipText("press 'Alt/Option+Control' + '2'");
        myBetButton2.setMnemonic(VK_2);
        myBetButton3.setToolTipText("press 'Alt/Option+Control' + '3'");
        myBetButton3.setMnemonic(VK_3);
        myBetButton4.setToolTipText("press 'Alt/Option+Control' + '4'");
        myBetButton4.setMnemonic(VK_4);
        myBetButton5.setToolTipText("press 'Alt/Option+Control' + '5'");
        myBetButton5.setMnemonic(VK_5);
        myBetButton6.setToolTipText("press 'Alt/Option+Control' + '6'");
        myBetButton6.setMnemonic(VK_6);
        myPlayAgainbutton.setToolTipText("press 'Alt/Option' + 'O'");
        myPlayAgainbutton.setMnemonic(VK_O);
    }
}
