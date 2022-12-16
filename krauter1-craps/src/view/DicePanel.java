package view;

import javax.swing.*;
import java.awt.*;

public class DicePanel extends JPanel {


    private final JPanel myCenterPanel;
    private final GridBagConstraints myDicePanelConstraints;
    private final DrawDice myDrawDice;
    private Dimension myScreenSize;

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
