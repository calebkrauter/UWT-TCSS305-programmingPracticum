package view;

import javax.swing.*;
import java.awt.*;

public class CenterPanel {

    private static GridBagLayout myGridBagLayout;
    private static JPanel myBackgroundPanel;
    private static JPanel myCenterPanel;
    private static GridBagConstraints myConstraints;
    private static JFrame myJFrame;
    private static JTextField myTextField4;
    private static JLabel mySum;
    private static JButton myRollButton;
    public CenterPanel(GridBagLayout theGridBagLayout, JPanel theBackgroundPanel,
                       JPanel theCenterPanel, GridBagConstraints theConstraints,
                       JFrame theJFrame, JTextField theTextField4, JLabel theSum, JButton theRollButton) {

        myGridBagLayout = theGridBagLayout;
        myBackgroundPanel = theBackgroundPanel;
        myCenterPanel = theCenterPanel;
        myConstraints = theConstraints;
        myJFrame = theJFrame;
        myTextField4 = theTextField4;
        mySum = theSum;
        myRollButton = theRollButton;
        centerPanel();
        button();
        textField();
        textLabel();
    }

    private void centerPanel() {
        myConstraints.ipady = myJFrame.getHeight();
        myConstraints.ipadx = myJFrame.getWidth();
        myConstraints.anchor = GridBagConstraints.CENTER;
        myConstraints.gridx = 1;
        myConstraints.gridy = 0;
        myConstraints.gridheight = 2;
        myConstraints.gridwidth = 0;
        myConstraints.weightx = 1;
        myConstraints.weighty = 1;
        myConstraints.insets = new Insets(125, myJFrame.getWidth()/4, 0, myJFrame.getWidth()/4);
        myBackgroundPanel.add(myCenterPanel, myConstraints);
    }

    private void button() {
        myConstraints.ipady = 20;
        myConstraints.ipadx = 30;
        myConstraints.anchor = GridBagConstraints.PAGE_START;
        myConstraints.gridx = 1;
        myConstraints.gridy = 0;
        myConstraints.gridheight = 0;
        myConstraints.gridwidth = 0;
        myConstraints.weightx = 1;
        myConstraints.weighty = 1;
        myConstraints.insets = new Insets(100, 0, 0, 0);
        myCenterPanel.add(myRollButton,myConstraints);
    }

    private void textField() {
        myConstraints.ipadx = 40;
        myConstraints.ipady = 10;
        myConstraints.anchor = GridBagConstraints.PAGE_END;
        myConstraints.gridx = 1;
        myConstraints.gridy = 0;
        myConstraints.gridheight = 0;
        myConstraints.gridwidth = 0;
        myConstraints.weightx = 1;
        myConstraints.weighty = 1;
        myConstraints.insets = new Insets(0, 0, 100, 0);
        myCenterPanel.add(myTextField4,myConstraints);
    }

    private void textLabel() {
        myConstraints.ipadx = 30;
        myConstraints.ipady = 10;
        myConstraints.anchor = GridBagConstraints.PAGE_END;
        myConstraints.gridx = 1;
        myConstraints.gridy = 0;
        myConstraints.gridheight = 0;
        myConstraints.gridwidth = 0;
        myConstraints.weightx = 1;
        myConstraints.weighty = 1;
        myConstraints.insets = new Insets(0, 0, 105, 100);
        myCenterPanel.add(mySum, myConstraints);
    }
}
