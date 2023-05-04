package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 * TitlePanel holds location and
 * size info for that it holds components.
 *
 * @author Caleb Krauter
 * @version 1.1
 */
public class TitlePanel extends JPanel {

    /**
     * The background panel.
     */
    private final JPanel myBackgroundPanel;

    /**
     * The title image label.
     */
    private final JLabel myTitleImageLabel;

    /**
     * The GridBagConstraints used in this panel.
     */
    private final GridBagConstraints myTitleConstraints;

    /**
     * A dimension of the screen size.
     */
    private static Dimension myScreenSize;

    /**
     * The TitlePanel constructor.
     *
     * @param theGridBagLayout layout manager.
     * @param theBackgroundPanel the background panel.
     * @param theTitleImageLabel The title image label.
     * @param theTitleConstraints GridBagConstraints of the title image label.
     * @param theScreenSize a dimension of screen size.
     */
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
        myBackgroundPanel.add(myTitleImageLabel, myTitleConstraints);
    }
}
