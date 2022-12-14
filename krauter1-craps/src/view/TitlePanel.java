package view;


import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {
    private static Dimension myScreenSize;
    public TitlePanel(GridBagLayout gridBagLayout, JPanel p1, JLabel l1, GridBagConstraints constraints, JFrame jFrame, Dimension theScreenSize) {
        myScreenSize = theScreenSize;
        constraints.ipady = 0;
        constraints.ipadx = (int) myScreenSize.getWidth();
        constraints.insets = new Insets(0, 0,0, 0);
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.anchor = GridBagConstraints.PAGE_START;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 2;
        p1.add(l1, constraints);
    }
}
