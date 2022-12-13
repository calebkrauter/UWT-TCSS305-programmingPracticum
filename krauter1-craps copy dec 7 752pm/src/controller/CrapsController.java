package controller;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

// TODO - make sure that the textboxes can't adjust to become too large if there are many wins.
// TODO - check order of params in constructor
// TODO - Add arguments to the constructor
// TODO - figure out if I need to add a super call in the constructor.
// TODO - Fix -> title panel is bigger than the icon on the panel. (icon being the photo)
// TODO - Fix Panel 4, it overlaps the title panel and I don't know how changin gridx and
//  gridy is affecting the title photo, it makes it large
// TODO - simplify code by taking alike blocks of code and consolidating to methods
// TODO - Implement a version of the Dice lables and results text fields
// TODO - implement an object to draw dice based on a numerical value.
//  Consider using a timer and have it draw a dice changing sides.
// TODO - implement wallet/bank
// TODO - implement toolbar
// TODO - add extra credit
// TODO - implement model
// TODO - implement view for changing the theme etc. Consider what else could be done in view. What is the point of view?

public class CrapsController extends JPanel implements PropertyChangeListener {
    private int anchor = 0;
    private static final Color invisible = new Color(1f,0f,0f,0f);
    private final JPanel p1;
    private final JPanel p2;
    private final JPanel p3;
    private final JPanel p4;
    private final JTextField myTextField1;
    private final JTextField myTextField2;
    private final JTextField myTextField3;
    private final JTextField myTextField4;

    private final GridBagConstraints constraints;
    private final JFrame jFrame;
    private static String myInitialCount = String.valueOf(0);
    private static final String myPlayerWon = "Player Wins: ";
    private static final String myHouseWon = "House Wins: ";
    private static final String myPoint = "Players Score: ";
    private static final String myRollText = "ROLL!";
    private static final String myTotalText = "TOTAL: ";
    private static final JLabel myPlayerWins = new JLabel(myPlayerWon);
    private static final JLabel myHouseWins = new JLabel(myHouseWon);
    private static final JLabel myPoints = new JLabel(myPoint);
    private static final JLabel mySum = new JLabel(myTotalText);

    private static final JLabel l1 = new JLabel(new ImageIcon("/Users/calebkrauter/Workspace/uw-tcss-305/krauter1-craps/src/controller/image1.jpg"));
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();

    private static final JButton myRollButton = new JButton(myRollText);;



    public CrapsController(){
        // add passed parameters
        // myPlayerWins = thePlayerWins;
        jFrame = new JFrame();
        constraints = new GridBagConstraints();

        p1 = new JPanel(new GridBagLayout());
        p1.setBackground(Color.GRAY);
        p2 = new JPanel(new GridBagLayout());
        p2.setBackground(invisible);
        p3 = new JPanel(new GridBagLayout());
        p3.setBackground(Color.RED);
        p4 = new JPanel(new GridBagLayout());
        p4.setBackground(Color.GREEN);

        myTextField1 = new JTextField(myInitialCount);
        myTextField1.setEditable(false);
        myTextField2 = new JTextField(myInitialCount);
        myTextField2.setEditable(false);
        myTextField3 = new JTextField(myInitialCount);
        myTextField3.setEditable(false);
        myTextField4 = new JTextField(myInitialCount);
        myTextField4.setEditable(false);
        loadGui();

    }

    public void loadGui() {
        jFrame.setLocation(SCREEN_SIZE.width / 2 - jFrame.getWidth() / 2,
                SCREEN_SIZE.height / 2 - jFrame.getHeight() / 2);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800, 750);
        jFrame.setMinimumSize(new Dimension(700, 600));
        jFrame.setVisible(true);
        jFrame.add(p1);
        titlePanel();
        leftPanel();
        centerPanel();
    }

    public void titlePanel() {
        // Panel 2 - title Panel and photo added ontop
        constraints.ipady = 0;
        constraints.ipadx = jFrame.getWidth();
        constraints.insets = new Insets(0, 0, 300, 0);
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.anchor = GridBagConstraints.PAGE_START;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        p2.add(l1, constraints);
        p1.add(p2, constraints);
    }

    public void leftPanel() {

        // Textfield 1
        constraints.ipady = 20;
        constraints.ipadx = 20;
        constraints.insets = new Insets(200, 100, 0, 30);
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        p3.add(myTextField1, constraints);

        // Textfield 2
        constraints.ipady = 20;
        constraints.ipadx = 20;
        constraints.insets = new Insets(300, 100, 0, 30);
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        p3.add(myTextField2, constraints);

        // Textfield 3
        constraints.ipady = 20;
        constraints.ipadx = 20;
        constraints.insets = new Insets(400, 100, 0, 0);
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        p3.add(myTextField3, constraints);

        // PlayerWinsLabel
        constraints.ipadx = 30;
        constraints.ipady = 10;
        constraints.insets = new Insets(210, 10, 0, 30);
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        p3.add(myPlayerWins, constraints);

        // HouseWinsLabel
        constraints.ipadx = 30;
        constraints.ipady = 10;
        constraints.insets = new Insets(310, 10, 0, 30);
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        p3.add(myHouseWins, constraints);

        // ScoreLabel
        constraints.ipadx = 30;
        constraints.ipady = 10;
        constraints.insets = new Insets(410, 10, 0, 30);
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        p3.add(myPoints, constraints);

        // Add panel three to panel 1 full of buttons and labels
        constraints.ipady = jFrame.getHeight();
        constraints.ipadx = 100;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 2;
        constraints.gridwidth = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(0, 0, 0, 0);
        p1.add(p3, constraints);
    }

    public void centerPanel() {
        // Panel 4, the center panel
        constraints.ipady = jFrame.getHeight();
        constraints.ipadx = 100;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 2;
        constraints.gridwidth = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(100, 0, 0, 0);
        p1.add(p4, constraints);

        constraints.ipady = 20;
        constraints.ipadx = 30;
        constraints.anchor = GridBagConstraints.PAGE_START;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 0;
        constraints.gridwidth = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(100, 0, 0, 0);
        p4.add(myRollButton, constraints);

        // Textfield 4
        constraints.ipady = 20;
        constraints.ipadx = 20;
        constraints.anchor = GridBagConstraints.PAGE_START;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 0;
        constraints.gridwidth = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(300, 0, 0, 0);
        p4.add(myTextField4, constraints);

        // Total Text Label
        constraints.ipadx = 30;
        constraints.ipady = 10;
        constraints.anchor = GridBagConstraints.PAGE_START;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 0;
        constraints.gridwidth = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(310, 0, 0, 100);
        p4.add(mySum, constraints);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
