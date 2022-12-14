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
    private static Dimension myScreenSize;

    public LeftPanel(GridBagLayout theGridBagLayout, JPanel theBackgroundPanel, JPanel theLeftPanel,
                     GridBagConstraints theConstraints, JFrame theJFrame,
                     JTextField theTextField1, JTextField theTextField2,
                     JTextField theTextField3, JLabel thePlayerWins, JLabel theHouseWins,
                     String theHouseWon, JLabel thePoints, Dimension theScreenSize) {

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
        myScreenSize = theScreenSize;
        leftPanel();
        labels();
        textFields();
    }
    private void leftPanel() {
        //Add panel three to panel 1 full of buttons and labels
        // TODO fix bandid that makes left panel big enough by using multiplier
        myConstraints.ipady = (int) myScreenSize.getHeight();
        myConstraints.ipadx = 115;
        myConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        myConstraints.gridx = 0;
        myConstraints.gridy = 0;
        myConstraints.gridheight = 2;
        myConstraints.gridwidth = 0;
        myConstraints.weightx = 1;
        myConstraints.weighty = 1;
        myConstraints.insets = new Insets(160, 0, 0, 0);
        myBackgroundPanel.add(myLeftPanel, myConstraints);

    }

    private void textFields() {
        // Textfield 1
        myConstraints.ipadx = 40;
        myConstraints.ipady = 10;
        myConstraints.insets = new Insets(100, 100, 0, 30);
        myConstraints.weightx = 1;
        myConstraints.weighty = 1;
        myConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        myConstraints.gridx = 0;
        myConstraints.gridy = 0;
        myConstraints.gridwidth = 3;
        myLeftPanel.add(myTextField1, myConstraints);

        // Textfield 2

        myConstraints.insets = new Insets(200, 100, 0, 30);
        myLeftPanel.add(myTextField2, myConstraints);

        // Textfield 3
        myConstraints.insets = new Insets(300, 100, 0, 0);
        myLeftPanel.add(myTextField3, myConstraints);
    }

    private void labels() {
        // PlayerWinsLabel
        myConstraints.ipadx = 30;
        myConstraints.ipady = 10;
        myConstraints.insets = new Insets(100, 10, 0, 30);
        myConstraints.weightx = 1;
        myConstraints.weighty = 1;
        myConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        myConstraints.gridx = 0;
        myConstraints.gridy = 0;
        myConstraints.gridwidth = 3;
        myLeftPanel.add(myPlayerWins, myConstraints);

        // HouseWinsLabel
        myConstraints.ipadx = 30;
        myConstraints.ipady = 10;
        myConstraints.insets = new Insets(200, 10, 0, 30);
        myConstraints.weightx = 1;
        myConstraints.weighty = 1;
        myConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        myConstraints.gridx = 0;
        myConstraints.gridy = 0;
        myConstraints.gridwidth = 3;
        myLeftPanel.add(myHouseWins, myConstraints);

        // ScoreLabel
        myConstraints.ipadx = 30;
        myConstraints.ipady = 10;
        myConstraints.insets = new Insets(300, 10, 0, 30);
        myConstraints.weightx = 1;
        myConstraints.weighty = 1;
        myConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        myConstraints.gridx = 0;
        myConstraints.gridy = 0;
        myConstraints.gridwidth = 3;
        myLeftPanel.add(myPoints, myConstraints);
    }


}
