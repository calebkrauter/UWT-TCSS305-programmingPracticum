package view;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 * Dice panel holds location and
 * size info for that it holds components.
 *
 * @author Caleb Krauter
 * @version 1.0
 */
public class DicePanel extends JPanel {

    /**
     * The center panel.
     */
    private final JPanel myCenterPanel;

    /**
     * The GridBagConstraints used in this panel.
     */
    private final GridBagConstraints myDicePanelConstraints;

    /**
     * A reference to the instance call of DrawDice
     * used to place the dice drawings onto the DicePanel.
     */
    private final DrawDice myDrawDice;

    /**
     * A dimension of the screen size.
     */
    private Dimension myScreenSize;

    /**
     *
     * @param theGridBagLayout layout manager.
     * @param theCenterPanel the center panel.
     * @param theDicePanelConstraints GridBagConstraints of the dice panel.
     * @param theDrawDice a reference to the instance call of DrawDice
     *                    used to place the dice drawings onto the DicePanel.
     * @param theScreenSize a dimension of screen size.
     */
    public DicePanel(GridBagLayout theGridBagLayout, JPanel theCenterPanel, GridBagConstraints theDicePanelConstraints, DrawDice theDrawDice, Dimension theScreenSize) {
        super(theGridBagLayout);

        myCenterPanel = theCenterPanel;
        myDicePanelConstraints = theDicePanelConstraints;
        myDrawDice = theDrawDice;
        myScreenSize = theScreenSize;
        myDicePanelConstraints.ipady = 600;
        myDicePanelConstraints.ipadx = 100;
        myDicePanelConstraints.anchor = GridBagConstraints.PAGE_END;
        myDicePanelConstraints.gridx = 1;
        myDicePanelConstraints.gridy = 0;
        myDicePanelConstraints.gridheight = 2;
        myDicePanelConstraints.gridwidth = 0;
        myDicePanelConstraints.weightx = 1;
        myDicePanelConstraints.weighty = 1;
        myDicePanelConstraints.insets = new Insets(150, 20, (int) (myScreenSize.getHeight()/30) + 30, 0);
        myCenterPanel.add(myDrawDice, myDicePanelConstraints);
    }

}
