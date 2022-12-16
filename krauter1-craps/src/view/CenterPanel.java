package view;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel{

    private static JPanel myBackgroundPanel;
    private static JPanel myCenterPanel;
    private static GridBagConstraints myConstraints;
    private static JTextField myTextField4;
    private static JLabel mySum;
    private static JButton myRollButton;
    private static Dimension myScreenSize;
    public CenterPanel(GridBagLayout theGridBagLayout,
                       JPanel theBackgroundPanel,
                       JPanel theCenterPanel,
                       GridBagConstraints theConstraints,
                       JTextField theTextField4,
                       JLabel theSum,
                       JButton theRollButton,
                       Dimension theScreenSize) {
        super(theGridBagLayout);

        myBackgroundPanel = theBackgroundPanel;
        myCenterPanel = theCenterPanel;
        myConstraints = theConstraints;
        myTextField4 = theTextField4;
        mySum = theSum;
        myRollButton = theRollButton;
        myScreenSize = theScreenSize;
        centerPanel();
        button();
        textField();
        textLabel();
        myRollButton.setEnabled(true);
    }

    private void centerPanel() {
        myConstraints.ipady = (int) myScreenSize.getHeight();
        myConstraints.ipadx = (int) myScreenSize.getWidth();
        myConstraints.anchor = GridBagConstraints.CENTER;
        myConstraints.gridx = 1;
        myConstraints.gridy = 0;
        myConstraints.gridheight = 2;
        myConstraints.gridwidth = 0;
        myConstraints.weightx = 1;
        myConstraints.weighty = 1;
        myConstraints.insets = new Insets(160, 0, 0, 0);
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
        myConstraints.insets = new Insets(100, 20, 0, 0);
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
        myConstraints.insets = new Insets(0, 25, 25, 0);
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
        myConstraints.insets = new Insets(0, 20, 25, 100);
        myCenterPanel.add(mySum, myConstraints);
    }
}
