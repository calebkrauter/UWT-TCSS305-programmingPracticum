package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 * RightPanel holds location and
 * size info for that it holds components.
 *
 * @author Caleb Krauter
 * @version 1.1
 */
public class RightPanel extends JPanel {

    /**
     * The background panel.
     */
    private static JPanel myBackgroundPanel;

    /**
     * The right panel.
     */
    private static JPanel myRightPanel;

    /**
     * The GridBagConstraints used in this panel.
     */
    private static GridBagConstraints myRightPanelConstraints;

    /**
     * The label used for the wallet.
     */
    private static JLabel myWalletLabel;

    /**
     * The text field used to display the contents
     * of the wallet.
     */
    private static JTextField myWalletField;

    /**
     * A bet button associated with a particular
     * bet value.
     */
    private static JButton myBetButton1;

    /**
     * A bet button associated with a particular
     * bet value.
     */
    private static JButton myBetButton2;

    /**
     * A bet button associated with a particular
     * bet value.
     */
    private static JButton myBetButton3;

    /**
     * A bet button associated with a particular
     * bet value.
     */
    private static JButton myBetButton4;

    /**
     * A bet button associated with a particular
     * bet value.
     */
    private static JButton myBetButton5;

    /**
     * A bet button associated with a particular
     * bet value.
     */
    private static JButton myBetButton6;

    /**
     * A dimension of the screen size.
     */
    private static Dimension myScreenSize;

    /**
     * The RightPanel constructor.
     *
     * @param theGridBagLayout layout manager.
     * @param theBackgroundPanel the background panel.
     * @param theRightPanel the Right Panel.
     * @param theRightPanelConstraints  GridBagConstraints of the right panel.
     * @param theWalletLabel label associated with the wallet.
     * @param theWalletField text field that displays wallet's contents.
     * @param theBetButton1 a bet button associated with a particular bet value.
     * @param theBetButton2 a bet button associated with a particular bet value.
     * @param theBetButton3 a bet button associated with a particular bet value.
     * @param theBetButton4 a bet button associated with a particular bet value.
     * @param theBetButton5 a bet button associated with a particular bet value.
     * @param theBetButton6 a bet button associated with a particular bet value.
     * @param theScreenSize a dimension of screen size.
     */
    public RightPanel(GridBagLayout theGridBagLayout,
                      JPanel theBackgroundPanel,
                      JPanel theRightPanel,
                      GridBagConstraints theRightPanelConstraints,
                      JLabel theWalletLabel,
                      JTextField theWalletField,
                      JButton theBetButton1,
                      JButton theBetButton2,
                      JButton theBetButton3,
                      JButton theBetButton4,
                      JButton theBetButton5,
                      JButton theBetButton6,
                      Dimension theScreenSize) {

        super(theGridBagLayout);

        myBackgroundPanel = theBackgroundPanel;
        myRightPanel = theRightPanel;
        myRightPanelConstraints = theRightPanelConstraints;
        myWalletLabel = theWalletLabel;
        myWalletField = theWalletField;
        myBetButton1 = theBetButton1;
        myBetButton2 = theBetButton2;
        myBetButton3 = theBetButton3;
        myBetButton4 = theBetButton4;
        myBetButton5 = theBetButton5;
        myBetButton6 = theBetButton6;
        myScreenSize = theScreenSize;

        rightPanel();
        walletLabel();
        walletTextField();
        betButtons();
    }

    /**
     * Location and sizing of the right panel.
     */
    private void rightPanel() {
        // Right panel
        myRightPanelConstraints.ipady = (int) myScreenSize.getHeight();
        myRightPanelConstraints.ipadx = 115;
        myRightPanelConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
        myRightPanelConstraints.gridx = 2;
        myRightPanelConstraints.gridy = 0;
        myRightPanelConstraints.gridheight = 2;
        myRightPanelConstraints.gridwidth = 0;
        myRightPanelConstraints.weightx = 1;
        myRightPanelConstraints.weighty = 1;
        myRightPanelConstraints.insets = new Insets(160, 0, 0, 0);
        myBackgroundPanel.add(myRightPanel, myRightPanelConstraints);
    }

    /**
     * Location and sizing of the wallet label.
     */
    private void walletLabel() {
        // Wallet label
        myRightPanelConstraints.ipadx = 20;
        myRightPanelConstraints.ipady = 10;
        myRightPanelConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
        myRightPanelConstraints.gridx = 2;
        myRightPanelConstraints.gridy = 1;
        myRightPanelConstraints.gridheight = 0;
        myRightPanelConstraints.gridwidth = 0;
        myRightPanelConstraints.weightx = 1;
        myRightPanelConstraints.weighty = 1;
        myRightPanelConstraints.insets = new Insets(75, 0, 0, 50);
        myRightPanel.add(myWalletLabel, myRightPanelConstraints);
    }

    /**
     * Location and sizing of wallet text field.
     */
    private void walletTextField() {
        // Wallet textfield
        myRightPanelConstraints.ipadx = 100;
        myRightPanelConstraints.ipady = 10;
        myRightPanelConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
        myRightPanelConstraints.gridx = 2;
        myRightPanelConstraints.gridy = 1;
        myRightPanelConstraints.gridheight = 0;
        myRightPanelConstraints.gridwidth = 0;
        myRightPanelConstraints.weightx = 1;
        myRightPanelConstraints.weighty = 1;
        myRightPanelConstraints.insets = new Insets(100, 0, 0, 50);
        myRightPanel.add(myWalletField, myRightPanelConstraints);
    }

    /**
     * Location and sizing of the bet buttons.
     */
    private void betButtons() {
        // Bet button amount 1
        myRightPanelConstraints.ipadx = 40;
        myRightPanelConstraints.ipady = 20;
        myRightPanelConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
        myRightPanelConstraints.gridx = 2;
        myRightPanelConstraints.gridy = 1;
        myRightPanelConstraints.gridheight = 0;
        myRightPanelConstraints.gridwidth = 0;
        myRightPanelConstraints.weightx = 1;
        myRightPanelConstraints.weighty = 1;
        myRightPanelConstraints.insets = new Insets(200, 0, 0, 50);
        myRightPanel.add(myBetButton1, myRightPanelConstraints);

        // Bet button amount 2
        myBetButton2.setSize(new Dimension(20, 10));

        myRightPanelConstraints.insets = new Insets(250, 0, 0, 50);
        myRightPanel.add(myBetButton2, myRightPanelConstraints);

        // Bet button amount 3
        myBetButton3.setSize(new Dimension(20, 10));

        myRightPanelConstraints.insets = new Insets(300, 0, 0, 50);
        myRightPanel.add(myBetButton3, myRightPanelConstraints);

        // Bet button amount 4
        myBetButton4.setSize(new Dimension(20, 10));

        myRightPanelConstraints.insets = new Insets(350, 0, 0, 50);
        myRightPanel.add(myBetButton4, myRightPanelConstraints);

        // Bet amount button 5
        myBetButton5.setSize(new Dimension(20, 10));

        myRightPanelConstraints.insets = new Insets(400, 0, 0, 50);
        myRightPanel.add(myBetButton5, myRightPanelConstraints);

        // Bet amount button 6
        myBetButton6.setSize(new Dimension(20, 10));

        myRightPanelConstraints.insets = new Insets(450, 0, 0, 50);
        myRightPanel.add(myBetButton6, myRightPanelConstraints);
    }

}
