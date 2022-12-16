package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import static java.awt.event.KeyEvent.*;

public class Shortcuts {

    private final JMenuItem myStartItem;
    private final JMenuItem myResetItem;
    private final JMenuItem myExitItem;
    private final JMenuItem myRulesItem;
    private final JMenuItem myAboutItem;
    private final JMenuItem myPlayAgainItem;
    private final JButton myRollButton;
    private final JButton myBetButton1;
    private final JButton myBetButton2;
    private final JButton myBetButton3;
    private final JButton myBetButton4;
    private final JButton myBetButton5;
    private final JButton myBetButton6;
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

        theRollButton.setToolTipText("press 'Alt/Option+Control' + 'D'");
        theRollButton.setMnemonic(VK_D);
        theBetButton1.setToolTipText("press 'Alt/Option+Control' + '1'");
        theBetButton1.setMnemonic(VK_1);
        theBetButton2.setToolTipText("press 'Alt/Option+Control' + '2'");
        theBetButton2.setMnemonic(VK_2);
        theBetButton3.setToolTipText("press 'Alt/Option+Control' + '3'");
        theBetButton3.setMnemonic(VK_3);
        theBetButton4.setToolTipText("press 'Alt/Option+Control' + '4'");
        theBetButton4.setMnemonic(VK_4);
        theBetButton5.setToolTipText("press 'Alt/Option+Control' + '5'");
        theBetButton5.setMnemonic(VK_5);
        theBetButton6.setToolTipText("press 'Alt/Option+Control' + '6'");
        theBetButton6.setMnemonic(VK_6);
        thePlayAgainButton.setToolTipText("press 'Alt/Option' + 'O'");
        thePlayAgainButton.setMnemonic(VK_O);
    }
}
