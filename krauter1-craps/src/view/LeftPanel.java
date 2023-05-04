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
 * LeftPanel holds location and
 * size info for that it holds components.
 *
 * @author Caleb Krauter
 * @version 1.1
 */
public class LeftPanel extends JPanel{

    /**
     * The background panel.
     */
    private static JPanel myBackgroundPanel;

    /**
     * The left panel.
     */
    private static JPanel myLeftPanel;

    /**
     * The GridBagConstraints used in this panel.
     */
    private static GridBagConstraints myLeftPanelConstraints;

    /**
     * The text field used for the player wins.
     */
    private static JTextField myPlayerWinsField;

    /**
     * The text field used for the house wins.
     */
    private static JTextField myHouseWinsField;

    /**
     * The text field used for the score.
     */
    private static JTextField myScoreField;

    /**
     * The JLabel used for the player wins.
     */
    private static JLabel myPlayerWins;

    /**
     * The JLabel used for the house wins.
     */
    private static JLabel myHouseWins;

    /**
     * The JLabel used for the score.
     */
    private static JLabel myPoints;

    /**
     * A dimension of the screen size.
     */
    private static Dimension myScreenSize;

    /**
     * Play again button.
     */
    private static JButton myPlayAgainButton;

    /**
     * The LeftPanel constructor.
     *
     * @param theGridBagLayout layout manager.
     * @param theBackgroundPanel the background panel.
     * @param theLeftPanel the left panel.
     * @param theLeftPanelConstraints GridBagConstraints of the left panel.
     * @param thePlayerWinsField text field to display player win total.
     * @param theHouseWinsField text field to display house win total.
     * @param theScoreField text field to display score total.
     * @param thePlayerWins label used for player wins.
     * @param theHouseWins label used for house wins.
     * @param thePoints label used for score.
     * @param theScreenSize a dimension of screen size.
     * @param thePlayAgainButton play again button.
     */
    public LeftPanel(GridBagLayout theGridBagLayout,
                     JPanel theBackgroundPanel,
                     JPanel theLeftPanel,
                     GridBagConstraints theLeftPanelConstraints,
                     JTextField thePlayerWinsField,
                     JTextField theHouseWinsField,
                     JTextField theScoreField,
                     JLabel thePlayerWins,
                     JLabel theHouseWins,
                     JLabel thePoints,
                     Dimension theScreenSize,
                     JButton thePlayAgainButton) {

        super(theGridBagLayout);

        myBackgroundPanel = theBackgroundPanel;
        myLeftPanel = theLeftPanel;
        myLeftPanelConstraints = theLeftPanelConstraints;
        myPlayerWinsField = thePlayerWinsField;
        myHouseWinsField = theHouseWinsField;
        myScoreField = theScoreField;
        myPlayerWins = thePlayerWins;
        myHouseWins = theHouseWins;
        myPoints = thePoints;
        myScreenSize = theScreenSize;
        myPlayAgainButton = thePlayAgainButton;
        leftPanel();
        labels();
        textFields();
        button();
    }

    /**
     * Location and sizing of the left panel.
     */
    private void leftPanel() {
        // Panel
        myLeftPanelConstraints.ipady = (int) myScreenSize.getHeight();
        myLeftPanelConstraints.ipadx = 115;
        myLeftPanelConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        myLeftPanelConstraints.gridx = 0;
        myLeftPanelConstraints.gridy = 0;
        myLeftPanelConstraints.gridheight = 2;
        myLeftPanelConstraints.gridwidth = 0;
        myLeftPanelConstraints.weightx = 1;
        myLeftPanelConstraints.weighty = 1;
        myLeftPanelConstraints.insets = new Insets(160, 0, 0, 0);
        myBackgroundPanel.add(myLeftPanel, myLeftPanelConstraints);

    }

    /**
     * Location and sizing of the text fields
     * displayed on the left panel.
     */
    private void textFields() {
        // Textfield 1
        myLeftPanelConstraints.ipadx = 40;
        myLeftPanelConstraints.ipady = 10;
        myLeftPanelConstraints.insets = new Insets(100, 100, 0, 30);
        myLeftPanelConstraints.weightx = 1;
        myLeftPanelConstraints.weighty = 1;
        myLeftPanelConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        myLeftPanelConstraints.gridx = 0;
        myLeftPanelConstraints.gridy = 0;
        myLeftPanelConstraints.gridwidth = 3;
        myLeftPanel.add(myPlayerWinsField, myLeftPanelConstraints);

        // Textfield 2
        myLeftPanelConstraints.insets = new Insets(200, 100, 0, 30);
        myLeftPanel.add(myHouseWinsField, myLeftPanelConstraints);

        // Textfield 3
        myLeftPanelConstraints.insets = new Insets(300, 100, 0, 0);
        myLeftPanel.add(myScoreField, myLeftPanelConstraints);
    }

    /**
     * Location and sizing of the labels
     * displayed on the left panel.
     */
    private void labels() {
        // PlayerWinsLabel
        myLeftPanelConstraints.ipadx = 30;
        myLeftPanelConstraints.ipady = 10;
        myLeftPanelConstraints.insets = new Insets(100, 10, 0, 30);
        myLeftPanel.add(myPlayerWins, myLeftPanelConstraints);

        // HouseWinsLabel
        myLeftPanelConstraints.insets = new Insets(200, 10, 0, 30);
        myLeftPanel.add(myHouseWins, myLeftPanelConstraints);

        // ScoreLabel
        myLeftPanelConstraints.insets = new Insets(300, 10, 0, 30);
        myLeftPanel.add(myPoints, myLeftPanelConstraints);
    }

    /**
     * Location and sizing of the play again button
     * displayed on the left panel.
     */
    private void button() {
        myLeftPanelConstraints.ipadx = 50;
        myLeftPanelConstraints.ipady = 10;
        myLeftPanelConstraints.insets = new Insets(400, 10, 0, 0);
        myLeftPanelConstraints.weightx = 1;
        myLeftPanelConstraints.weighty = 1;
        myLeftPanelConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        myLeftPanelConstraints.gridx = 0;
        myLeftPanelConstraints.gridy = 0;
        myLeftPanelConstraints.gridwidth = 3;
        myLeftPanel.add(myPlayAgainButton, myLeftPanelConstraints);
    }


}
