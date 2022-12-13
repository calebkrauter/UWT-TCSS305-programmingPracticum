package view;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel{

    private static JPanel myBackgroundPanel;
    private static JPanel myLeftPanel;
    private static GridBagConstraints myConstraints;
    private static JFrame myJFrame;
    private static JTextField myTextField1;
    private static JTextField myTextField2;
    private static JTextField myTextField3;
    private static JLabel myPlayerWins;
    private static JLabel myHouseWins;
    private static String myHouseWon;
    private static JLabel myPoints;


    public LeftPanel(GridBagLayout theGridBagLayout, JPanel theBackgroundPanel, JPanel theLeftPanel,
                     GridBagConstraints theConstraints, JFrame theJFrame,
                     JTextField theTextField1, JTextField theTextField2,
                     JTextField theTextField3, JLabel thePlayerWins, JLabel theHouseWins,
                     String theHouseWon, JLabel thePoints) {

        super(theGridBagLayout);

        myBackgroundPanel = theBackgroundPanel;
        myLeftPanel = theLeftPanel;
        myConstraints = theConstraints;
        myJFrame = theJFrame;
        myTextField1 = theTextField1;
        myTextField2 = theTextField2;
        myTextField3 = theTextField3;
        myPlayerWins = thePlayerWins;
        myHouseWins = theHouseWins;
        myHouseWon = theHouseWon;
        myPoints = thePoints;


        //Add panel three to panel 1 full of buttons and labels
       theConstraints.ipadx = myJFrame.getWidth()/3;
       theConstraints.ipady = myJFrame.getHeight();
       theConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
       theConstraints.gridx = 0;
       theConstraints.gridy = 0;
       theConstraints.gridheight = 2;
       theConstraints.gridwidth = 0;
       theConstraints.weightx = 1;
       theConstraints.weighty = 1;
       theConstraints.insets = new Insets(125, 0, 0, 0);
        theBackgroundPanel.add(theLeftPanel,theConstraints);

        // Textfield 1
       theConstraints.ipadx = 40;
       theConstraints.ipady = 10;
       theConstraints.insets = new Insets(100, 100, 0, 30);
       theConstraints.weightx = 1;
       theConstraints.weighty = 1;
       theConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
       theConstraints.gridx = 0;
       theConstraints.gridy = 0;
       theConstraints.gridwidth = 3;
       theLeftPanel.add(myTextField1,theConstraints);

        // Textfield 2
       theConstraints.ipadx = 40;
       theConstraints.ipady = 10;
       theConstraints.insets = new Insets(200, 100, 0, 30);
       theConstraints.weightx = 1;
       theConstraints.weighty = 1;
       theConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
       theConstraints.gridx = 0;
       theConstraints.gridy = 0;
       theConstraints.gridwidth = 3;
       theLeftPanel.add(myTextField2,theConstraints);

        // Textfield 3
       theConstraints.ipadx = 40;
       theConstraints.ipady = 10;
       theConstraints.insets = new Insets(300, 100, 0, 0);
       theConstraints.weightx = 1;
       theConstraints.weighty = 1;
       theConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
       theConstraints.gridx = 0;
       theConstraints.gridy = 0;
       theConstraints.gridwidth = 3;
       theLeftPanel.add(myTextField3,theConstraints);

        // PlayerWinsLabel
       theConstraints.ipadx = 30;
       theConstraints.ipady = 10;
       theConstraints.insets = new Insets(105, 10, 0, 30);
       theConstraints.weightx = 1;
       theConstraints.weighty = 1;
       theConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
       theConstraints.gridx = 0;
       theConstraints.gridy = 0;
       theConstraints.gridwidth = 3;
       theLeftPanel.add(myPlayerWins,theConstraints);

        // HouseWinsLabel
       theConstraints.ipadx = 30;
       theConstraints.ipady = 10;
       theConstraints.insets = new Insets(205, 10, 0, 30);
       theConstraints.weightx = 1;
       theConstraints.weighty = 1;
       theConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
       theConstraints.gridx = 0;
       theConstraints.gridy = 0;
       theConstraints.gridwidth = 3;
       theLeftPanel.add(myHouseWins,theConstraints);

        // ScoreLabel
       theConstraints.ipadx = 30;
       theConstraints.ipady = 10;
       theConstraints.insets = new Insets(305, 10, 0, 30);
       theConstraints.weightx = 1;
       theConstraints.weighty = 1;
       theConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
       theConstraints.gridx = 0;
       theConstraints.gridy = 0;
       theConstraints.gridwidth = 3;
       theLeftPanel.add(myPoints,theConstraints);
    }


}
