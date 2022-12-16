package view;

import javax.swing.*;
import java.awt.*;

public class DicePanel extends JPanel {






    public DicePanel(GridBagLayout theGridBagLayout, JPanel theCenterPanel, GridBagConstraints theDicePanelConstraints, DrawDice theDrawDice, Dimension theScreenSize) {
        super(theGridBagLayout);

        theDicePanelConstraints.ipady = 600;
        theDicePanelConstraints.ipadx = 100;
        theDicePanelConstraints.anchor = GridBagConstraints.PAGE_END;
        theDicePanelConstraints.gridx = 1;
        theDicePanelConstraints.gridy = 0;
        theDicePanelConstraints.gridheight = 2;
        theDicePanelConstraints.gridwidth = 0;
        theDicePanelConstraints.weightx = 1;
        theDicePanelConstraints.weighty = 1;
        theDicePanelConstraints.insets = new Insets(150, 20, (int) (theScreenSize.getHeight()/30) + 30, 0);
        theCenterPanel.add(theDrawDice, theDicePanelConstraints);
    }

}
