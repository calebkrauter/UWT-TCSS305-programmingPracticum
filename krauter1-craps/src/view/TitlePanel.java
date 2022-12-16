package view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class TitlePanel extends JPanel {
    private final JPanel myBackgroundPanel;
    private final JLabel myTitleImageLabel;
    private final GridBagConstraints myTitleConstraints;
    private static Dimension myScreenSize;
    public TitlePanel(GridBagLayout theGridBagLayout,
                      JPanel theBackgroundPanel,
                      JLabel theTitleImageLabel,
                      GridBagConstraints theTitleConstraints,
                      Dimension theScreenSize) {

        super(theGridBagLayout);
        myBackgroundPanel = theBackgroundPanel;
        myTitleImageLabel = theTitleImageLabel;
        myTitleConstraints = theTitleConstraints;

        myScreenSize = theScreenSize;
       myTitleConstraints.ipady = 0;
       myTitleConstraints.ipadx = (int) myScreenSize.getWidth();
       myTitleConstraints.insets = new Insets(0, 0,0, 0);
       myTitleConstraints.weightx = 1;
       myTitleConstraints.weighty = 1;
       myTitleConstraints.anchor = GridBagConstraints.PAGE_START;
       myTitleConstraints.gridx = 1;
       myTitleConstraints.gridy = 0;
       myTitleConstraints.gridwidth = 2;
       myTitleConstraints.gridheight = 2;
        myBackgroundPanel.add(theTitleImageLabel, myTitleConstraints);
    }
}
