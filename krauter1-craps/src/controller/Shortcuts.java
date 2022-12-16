package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import static java.awt.event.KeyEvent.*;

public class Shortcuts {

    public Shortcuts(JMenuItem startItem,
                     JMenuItem resetItem,
                     JMenuItem exitItem,
                     JMenuItem rulesItem,
                     JMenuItem aboutItem,
                     JMenuItem thePlayAgainItem,
                     JButton theRollButton,
                     JButton theBetButton1,
                     JButton theBetButton2,
                     JButton theBetButton3,
                     JButton theBetButton4,
                     JButton theBetButton5,
                     JButton theBetButton6,
                     JButton thePlayAgainButton) {

        startItem.setToolTipText("press 'Alt/Option' + 'S'");
        startItem.setAccelerator(KeyStroke.getKeyStroke(VK_S, ActionEvent.ALT_MASK));
        resetItem.setToolTipText("press 'Alt/Option' + X'");
        resetItem.setAccelerator(KeyStroke.getKeyStroke(VK_X, ActionEvent.ALT_MASK));
        thePlayAgainItem.setToolTipText("press 'Alt/Option' + 'P'");
        thePlayAgainItem.setAccelerator(KeyStroke.getKeyStroke(VK_P, ActionEvent.ALT_MASK));
        exitItem.setToolTipText("press 'Alt/Option' + 'C'");
        exitItem.setAccelerator(KeyStroke.getKeyStroke(VK_C, ActionEvent.ALT_MASK));
        aboutItem.setToolTipText("press 'Alt/Option' + 'A'");
        aboutItem.setAccelerator(KeyStroke.getKeyStroke(VK_A, ActionEvent.ALT_MASK));
        rulesItem.setToolTipText("press 'Alt/Option' + 'I'");
        rulesItem.setAccelerator(KeyStroke.getKeyStroke(VK_I, ActionEvent.ALT_MASK));

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
