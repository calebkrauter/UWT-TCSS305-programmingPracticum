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
 * CenterPanel holds location and
 * size info for that it holds components.
 *
 * @author Caleb Krauter
 * @version 1.0
 */
public class CenterPanel extends JPanel{

    /**
     * The background panel.
     */
    private static JPanel myBackgroundPanel;

    /**
     * The center panel.
     */
    private static JPanel myCenterPanel;

    /**
     * The GridBagConstraints used in this panel.
     */
    private static GridBagConstraints myCenterPanelConstraints;

    /**
     * The text field used for the roll total.
     */
    private static JTextField myRollField;

    /**
     * The JLabel used for displaying the
     * total of the rolled dice.
     */
    private static JLabel mySum;

    /**
     * The roll button.
     */
    private static JButton myRollButton;

    /**
     * A dimension of the screen size.
     */
    private static Dimension myScreenSize;

    /**
     * The CenterPanel constructor.
     *
     * @param theGridBagLayout layout manager.
     * @param theBackgroundPanel the background panel.
     * @param theCenterPanel the center panel.
     * @param theCenterPanelConstraints GridBagConstraints of the center panel.
     * @param theRollField text field to display roll total.
     * @param theSum total of the rolled dice.
     * @param theRollButton roll button.
     * @param theScreenSize a dimension of screen size.
     */
    public CenterPanel(GridBagLayout theGridBagLayout,
                       JPanel theBackgroundPanel,
                       JPanel theCenterPanel,
                       GridBagConstraints theCenterPanelConstraints,
                       JTextField theRollField,
                       JLabel theSum,
                       JButton theRollButton,
                       Dimension theScreenSize) {
        super(theGridBagLayout);

        myBackgroundPanel = theBackgroundPanel;
        myCenterPanel = theCenterPanel;
        myCenterPanelConstraints = theCenterPanelConstraints;
        myRollField = theRollField;
        mySum = theSum;
        myRollButton = theRollButton;
        myScreenSize = theScreenSize;
        centerPanel();
        rollButton();
        textField();
        textLabel();
        myRollButton.setEnabled(true);
    }

    /**
     * Location and sizing of the center panel.
     */
    private void centerPanel() {
        myCenterPanelConstraints.ipady = (int) myScreenSize.getHeight();
        myCenterPanelConstraints.ipadx = (int) myScreenSize.getWidth();
        myCenterPanelConstraints.anchor = GridBagConstraints.CENTER;
        myCenterPanelConstraints.gridx = 1;
        myCenterPanelConstraints.gridy = 0;
        myCenterPanelConstraints.gridheight = 2;
        myCenterPanelConstraints.gridwidth = 0;
        myCenterPanelConstraints.weightx = 1;
        myCenterPanelConstraints.weighty = 1;
        myCenterPanelConstraints.insets = new Insets(160, 0, 0, 0);
        myBackgroundPanel.add(myCenterPanel, myCenterPanelConstraints);
    }

    /**
     * Location and sizing of the roll button.
     */
    private void rollButton() {
        myCenterPanelConstraints.ipady = 20;
        myCenterPanelConstraints.ipadx = 30;
        myCenterPanelConstraints.anchor = GridBagConstraints.PAGE_START;
        myCenterPanelConstraints.gridx = 1;
        myCenterPanelConstraints.gridy = 0;
        myCenterPanelConstraints.gridheight = 0;
        myCenterPanelConstraints.gridwidth = 0;
        myCenterPanelConstraints.weightx = 1;
        myCenterPanelConstraints.weighty = 1;
        myCenterPanelConstraints.insets = new Insets(100, 20, 0, 0);
        myCenterPanel.add(myRollButton,myCenterPanelConstraints);
    }

    /**
     * Location and sizing of the text
     * field for the roll total.
     */
    private void textField() {
        myCenterPanelConstraints.ipadx = 40;
        myCenterPanelConstraints.ipady = 10;
        myCenterPanelConstraints.anchor = GridBagConstraints.PAGE_END;
        myCenterPanelConstraints.gridx = 1;
        myCenterPanelConstraints.gridy = 0;
        myCenterPanelConstraints.gridheight = 0;
        myCenterPanelConstraints.gridwidth = 0;
        myCenterPanelConstraints.weightx = 1;
        myCenterPanelConstraints.weighty = 1;
        myCenterPanelConstraints.insets = new Insets(0, 25, 25, 0);
        myCenterPanel.add(myRollField,myCenterPanelConstraints);
    }

    /**
     * Location and sizing of the text
     * displayed by the roll total text
     * field.
     */
    private void textLabel() {
        myCenterPanelConstraints.ipadx = 30;
        myCenterPanelConstraints.ipady = 10;
        myCenterPanelConstraints.anchor = GridBagConstraints.PAGE_END;
        myCenterPanelConstraints.gridx = 1;
        myCenterPanelConstraints.gridy = 0;
        myCenterPanelConstraints.gridheight = 0;
        myCenterPanelConstraints.gridwidth = 0;
        myCenterPanelConstraints.weightx = 1;
        myCenterPanelConstraints.weighty = 1;
        myCenterPanelConstraints.insets = new Insets(0, 20, 25, 100);
        myCenterPanel.add(mySum, myCenterPanelConstraints);
    }
}
