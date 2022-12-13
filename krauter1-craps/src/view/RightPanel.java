package view;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {

    private static JPanel myBackgroundPanel;
    private static JPanel myRightPanel;
    private static GridBagConstraints myConstraints;
    private static JFrame myJFrame;
    private static JLabel myWalletLabel;
    private static JTextField myTextField5;

    private static JButton myBetButton;
    private static JButton myBetAmount1;
    private static JButton myBetAmount2;
    private static JButton myBetAmount3;
    private static JButton myBetAmount4;
    private static JButton myBetAmount5;
    private static JButton myBetAmount6;
    // TODO - Rename buttons
    // TODO - make buttons same sized...
    // TODO - UPDATE use ipadx and ipady or use setsize...

    public RightPanel(GridBagLayout theGridBagLayout, JPanel theBackgroundPanel,
                      JPanel theRightPanel, GridBagConstraints theConstraints,
                      JFrame theJFrame, JLabel theWalletLabel, JTextField theTextField5, JButton theBetButton,
                     JButton theBetAmount1, JButton theBetAmount2, JButton theBetAmount3,
                     JButton theBetAmount4, JButton theBetAmount5, JButton theBetAmount6) {

        super(theGridBagLayout);

        myBackgroundPanel = theBackgroundPanel;
        myRightPanel = theRightPanel;
        myConstraints = theConstraints;
        myJFrame = theJFrame;
        myWalletLabel = theWalletLabel;
        myTextField5 = theTextField5;
        myBetButton = theBetButton;
        myBetAmount1 = theBetAmount1;
        myBetAmount2 = theBetAmount2;
        myBetAmount3 = theBetAmount3;
        myBetAmount4 = theBetAmount4;
        myBetAmount5 = theBetAmount5;
        myBetAmount6 = theBetAmount6;

        rightPanel();
        walletLabel();
        textFields();
        betButtons();
    }

    private void rightPanel() {
        // Right panel
        myConstraints.ipadx = myJFrame.getWidth()/3;
        myConstraints.ipady = myJFrame.getHeight();
        myConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
        myConstraints.gridx = 2;
        myConstraints.gridy = 0;
        myConstraints.gridheight = 2;
        myConstraints.gridwidth = 0;
        myConstraints.weightx = 1;
        myConstraints.weighty = 1;
        myConstraints.insets = new Insets(125, 0, 0, 0);
        myBackgroundPanel.add(myRightPanel, myConstraints);
    }

    private void walletLabel() {
        // Wallet label
        myConstraints.ipadx = 20;
        myConstraints.ipady = 10;
        myConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
        myConstraints.gridx = 2;
        myConstraints.gridy = 1;
        myConstraints.gridheight = 0;
        myConstraints.gridwidth = 0;
        myConstraints.weightx = 1;
        myConstraints.weighty = 1;
        myConstraints.insets = new Insets(75, 0, 0, 50);
        myRightPanel.add(myWalletLabel, myConstraints);
    }

    private void textFields() {
        // Wallet textfield
        myConstraints.ipadx = 100;
        myConstraints.ipady = 10;
        myConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
        myConstraints.gridx = 2;
        myConstraints.gridy = 1;
        myConstraints.gridheight = 0;
        myConstraints.gridwidth = 0;
        myConstraints.weightx = 1;
        myConstraints.weighty = 1;
        myConstraints.insets = new Insets(100, 0, 0, 50);
        myRightPanel.add(myTextField5, myConstraints);


    }

    private void betButtons() {

        // Bet button amount 1
        myConstraints.ipadx = 40;
        myConstraints.ipady = 20;
        myConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
        myConstraints.gridx = 2;
        myConstraints.gridy = 1;
        myConstraints.gridheight = 0;
        myConstraints.gridwidth = 0;
        myConstraints.weightx = 1;
        myConstraints.weighty = 1;
        myConstraints.insets = new Insets(200, 0, 0, 50);
        myRightPanel.add(myBetAmount1, myConstraints);

        // Bet button amount 2
        myBetAmount2.setSize(new Dimension(20, 10));

        myConstraints.insets = new Insets(250, 0, 0, 50);
        myRightPanel.add(myBetAmount2, myConstraints);

        // Bet button amount 3
        myBetAmount3.setSize(new Dimension(20, 10));

        myConstraints.insets = new Insets(300, 0, 0, 50);
        myRightPanel.add(myBetAmount3, myConstraints);

        // Bet button amount 4
        myBetAmount4.setSize(new Dimension(20, 10));

        myConstraints.insets = new Insets(350, 0, 0, 50);
        myRightPanel.add(myBetAmount4, myConstraints);

        // Bet amount button 5
        myBetAmount5.setSize(new Dimension(20, 10));

        myConstraints.insets = new Insets(400, 0, 0, 50);
        myRightPanel.add(myBetAmount5, myConstraints);

        // Bet amount button 6
        myBetAmount6.setSize(new Dimension(20, 10));

        myConstraints.insets = new Insets(450, 0, 0, 50);
        myRightPanel.add(myBetAmount6, myConstraints);
    }

}
