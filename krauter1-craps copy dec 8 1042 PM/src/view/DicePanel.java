package view;

import javax.swing.*;
import java.awt.*;

public class DicePanel extends JPanel {

    private static JPanel myBackgroundPanel;
    private static JPanel myCenterPanel;
    private static GridBagConstraints myConstraints;
    private static JFrame myJFrame;
    private static JPanel myDicePanel;


    public DicePanel(GridBagLayout theGridBagLayout, JPanel theBackgroundPanel,
                     JPanel theCenterPanel, GridBagConstraints theConstraints,
                     JFrame theJFrame, JPanel theDicePanel) {
        super(theGridBagLayout);

        myBackgroundPanel = theBackgroundPanel;
        myCenterPanel = theCenterPanel;
        myConstraints = theConstraints;
        myJFrame = theJFrame;
        myDicePanel = theDicePanel;
        dicePanel();

    }
    private void dicePanel() {
        myConstraints.ipady = 600;
        myConstraints.ipadx = 100;
        myConstraints.anchor = GridBagConstraints.PAGE_END;
        myConstraints.gridx = 1;
        myConstraints.gridy = 0;
        myConstraints.gridheight = 2;
        myConstraints.gridwidth = 2;
        myConstraints.weightx = 1;
        myConstraints.weighty = 1;
        myConstraints.insets = new Insets(150, 0, 100, 0);
        myCenterPanel.add(myDicePanel, myConstraints);
    }
}
