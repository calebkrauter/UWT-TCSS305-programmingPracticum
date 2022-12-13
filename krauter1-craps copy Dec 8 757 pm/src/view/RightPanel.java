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


    public RightPanel(GridBagLayout theGridBagLayout, JPanel theBackgroundPanel,
                      JPanel theRightPanel, GridBagConstraints theConstraints,
                      JFrame theJFrame, JLabel theWalletLabel, JTextField theTextField5) {

        super(theGridBagLayout);

        myBackgroundPanel = theBackgroundPanel;
        myRightPanel = theRightPanel;
        myConstraints = theConstraints;
        myJFrame = theJFrame;
        myWalletLabel = theWalletLabel;
        myTextField5 = theTextField5;

        rightPanel();
        walletLabel();
        walletTextField();
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
        myConstraints.ipadx = 30;
        myConstraints.ipady = 10;
        myConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
        myConstraints.gridx = 2;
        myConstraints.gridy = 1;
        myConstraints.gridheight = 0;
        myConstraints.gridwidth = 0;
        myConstraints.weightx = 1;
        myConstraints.weighty = 1;
        myConstraints.insets = new Insets(105, 0, 0, 100);
        myRightPanel.add(myWalletLabel, myConstraints);
    }

    private void walletTextField() {
        // Wallet textfield
        myConstraints.ipadx = 40;
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

}
