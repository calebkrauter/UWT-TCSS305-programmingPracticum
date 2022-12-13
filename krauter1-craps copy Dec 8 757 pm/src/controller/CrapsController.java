package controller;
import view.*;
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;

// TODO - make sure that the textboxes can't adjust to become too large if there are many wins.
// TODO - check order of params in constructor
// TODO - Add arguments to the constructor
// TODO - figure out if I need to add a super call in the constructor.
// TODO - simplify code by taking alike blocks of code and consolidating to methods
// TODO - Implement a version of the Dice lables and results text fields
// TODO - implement an object to draw dice based on a numerical value.
//  Consider using a timer and have it draw a dice changing sides.
// TODO - implement wallet/bank
// TODO - implement toolbar
// TODO - add extra credit
// TODO - implement model
// TODO - implement view for changing the theme etc. Consider what else could be done in view. What is the point of view?
// TODO - make the title photo stop moving when resizing in the y direction
// TODO - make sure the game consistently loads correctly without bugging out and all components and panels are in the righ places

public class CrapsController extends JPanel implements PropertyChangeListener {
    private int anchor = 0;
    private static final Color centerPanelColor = Color.decode("#FF8383");
    private static final Color leftPanelColor = Color.decode("#D9D8C0");
    private static final Color rightPanelColor = Color.decode("#97D0E3");
    private final JPanel p1;
    private final JPanel p2;
    private final JPanel p3;
    private final JPanel p4;
    private final JPanel drawDice;
    private final JPanel p5;
    private final JTextField myTextField1;
    private final JTextField myTextField2;
    private final JTextField myTextField3;
    private final JTextField myTextField4;
    private final JTextField myTextField5;


    private final GridBagConstraints constraints;
    public final JFrame jFrame;
    private static String myInitialCount = String.valueOf(0);
    private static final String myPlayerWon = "Player Wins: ";
    private static final String myHouseWon = "House Wins: ";
    private static final String myPoint = "Players Score: ";
    private static final String myRollText = "ROLL!";
    private static final String myWalletText = "Wallet: ";
    private static final String myTemporaryValue1 = "Enter Amount";

    private static final String myTotalText = "TOTAL: ";
    private static final JLabel myPlayerWins = new JLabel(myPlayerWon);
    private static final JLabel myHouseWins = new JLabel(myHouseWon);
    private static final JLabel myPoints = new JLabel(myPoint);
    private static final JLabel mySum = new JLabel(myTotalText);
    private static final JLabel myWallet = new JLabel(myWalletText);


    private static final JLabel l1 = new JLabel(new ImageIcon("/Users/calebkrauter/Workspace/uw-tcss-305/krauter1-craps/src/controller/image1.jpg"));
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();

    private static final JButton myRollButton = new JButton(myRollText);

    private int myXCenter;
    private int myYCenter;

    private LeftPanel leftPanel;
    private RightPanel rightPanel;
    private TitlePanel titlePanel;





    public CrapsController(){
        // add passed parameters
        // myPlayerWins = thePlayerWins;
        jFrame = new JFrame("The Game of Craps");
        constraints = new GridBagConstraints();

        p1 = new JPanel(new GridBagLayout());
        p1.setOpaque(true);
        p2 = new JPanel(new GridBagLayout());
        p2.setOpaque(true);
        Random random = new Random();
        int randomRoll1 = random.nextInt(1, 7);
        int randomRoll2 = random.nextInt(1, 7);

        drawDice = new DrawDice(new GridBagLayout(), randomRoll1, randomRoll2);
        drawDice.setOpaque(true);
        p4 = new JPanel(new GridBagLayout());
        p4.setBackground(centerPanelColor);
        p3 = new JPanel(new GridBagLayout());
        p3.setBackground(leftPanelColor);
        p5 = new JPanel(new GridBagLayout());
        p5.setBackground(rightPanelColor);

        myTextField1 = new JTextField(myInitialCount);
        myTextField1.setEditable(false);
        myTextField2 = new JTextField(myInitialCount);
        myTextField2.setEditable(false);
        myTextField3 = new JTextField(myInitialCount);
        myTextField3.setEditable(false);
        myTextField4 = new JTextField(myInitialCount);
        myTextField4.setEditable(false);
        myTextField5 = new JTextField(myInitialCount);
        loadGui();

        leftPanel = new LeftPanel(new GridBagLayout(), p1, p3, constraints,
                jFrame, myTextField1, myTextField2, myTextField3,
                myPlayerWins, myHouseWins, myHouseWon, myPoints);
        leftPanel.setBackground(leftPanelColor);
        rightPanel = new RightPanel(new GridBagLayout(), p1, p5, constraints, jFrame, myWallet, myTextField5);
        rightPanel.setBackground(rightPanelColor);
        titlePanel = new TitlePanel(new GridBagLayout(), p1, l1, constraints, jFrame);
        titlePanel.setOpaque(true);

    }

    public void loadGui() {
        jFrame.setLocation(SCREEN_SIZE.width / 2 - jFrame.getWidth() / 2,
        SCREEN_SIZE.height / 2 - jFrame.getHeight() / 2);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800, 750);
        jFrame.setMinimumSize(new Dimension(700, 750));
        jFrame.setVisible(true);

        jFrame.add(p1);

//        addDie();
//        centerPanel();
//        leftPanel();
//        rightPanel();
//        titleLabel();

    }

//    public void titleLabel() {
//        constraints.ipady = jFrame.getHeight();
//        constraints.ipadx = jFrame.getWidth();
//        constraints.insets = new Insets(0, 0, 0, 0);
//        constraints.weightx = 1;
//        constraints.weighty = 1;
//        constraints.anchor = GridBagConstraints.PAGE_START;
//        constraints.gridx = 1;
//        constraints.gridy = 0;
//        constraints.gridwidth = 2;
//        constraints.gridheight = 2;
//        p1.add(l1, constraints);
//    }

    public void addDie() {

        constraints.ipady = 600;
        constraints.ipadx = 100;
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 2;
        constraints.gridwidth = 2;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(150, 0, 100, 0);
        p4.add(drawDice, constraints);
    }

    public void centerPanel() {

        // Panel 4, the center panel
        constraints.ipady = jFrame.getHeight();
        constraints.ipadx = jFrame.getWidth();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 2;
        constraints.gridwidth = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(125, jFrame.getWidth()/4, 0, jFrame.getWidth()/4);
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
        constraints.ipadx = 40;
        constraints.ipady = 10;
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 0;
        constraints.gridwidth = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(0, 0, 100, 0);
        p4.add(myTextField4, constraints);

        // Total Text Label
        constraints.ipadx = 30;
        constraints.ipady = 10;
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 0;
        constraints.gridwidth = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(0, 0, 105, 100);
        p4.add(mySum, constraints);
    }
//    public void leftPanel() {
//        // Add panel three to panel 1 full of buttons and labels
//        constraints.ipadx = jFrame.getWidth()/3;
//        constraints.ipady = jFrame.getHeight();
//        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        constraints.gridheight = 2;
//        constraints.gridwidth = 0;
//        constraints.weightx = 1;
//        constraints.weighty = 1;
//        constraints.insets = new Insets(125, 0, 0, 0);
//        p1.add(p3, constraints);
//
//        // Textfield 1
//        constraints.ipadx = 40;
//        constraints.ipady = 10;
//        constraints.insets = new Insets(100, 100, 0, 30);
//        constraints.weightx = 1;
//        constraints.weighty = 1;
//        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        constraints.gridwidth = 3;
//        p3.add(myTextField1, constraints);
//
//        // Textfield 2
//        constraints.ipadx = 40;
//        constraints.ipady = 10;
//        constraints.insets = new Insets(200, 100, 0, 30);
//        constraints.weightx = 1;
//        constraints.weighty = 1;
//        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        constraints.gridwidth = 3;
//        p3.add(myTextField2, constraints);
//
//        // Textfield 3
//        constraints.ipadx = 40;
//        constraints.ipady = 10;
//        constraints.insets = new Insets(300, 100, 0, 0);
//        constraints.weightx = 1;
//        constraints.weighty = 1;
//        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        constraints.gridwidth = 3;
//        p3.add(myTextField3, constraints);
//
//        // PlayerWinsLabel
//        constraints.ipadx = 30;
//        constraints.ipady = 10;
//        constraints.insets = new Insets(105, 10, 0, 30);
//        constraints.weightx = 1;
//        constraints.weighty = 1;
//        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        constraints.gridwidth = 3;
//        p3.add(myPlayerWins, constraints);
//
//        // HouseWinsLabel
//        constraints.ipadx = 30;
//        constraints.ipady = 10;
//        constraints.insets = new Insets(205, 10, 0, 30);
//        constraints.weightx = 1;
//        constraints.weighty = 1;
//        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        constraints.gridwidth = 3;
//        p3.add(myHouseWins, constraints);
//
//        // ScoreLabel
//        constraints.ipadx = 30;
//        constraints.ipady = 10;
//        constraints.insets = new Insets(305, 10, 0, 30);
//        constraints.weightx = 1;
//        constraints.weighty = 1;
//        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        constraints.gridwidth = 3;
//        p3.add(myPoints, constraints);
//    }

//    public void rightPanel() {
//        // Right panel
//        constraints.ipadx = jFrame.getWidth()/3;
//        constraints.ipady = jFrame.getHeight();
//        constraints.anchor = GridBagConstraints.FIRST_LINE_END;
//        constraints.gridx = 2;
//        constraints.gridy = 0;
//        constraints.gridheight = 2;
//        constraints.gridwidth = 0;
//        constraints.weightx = 1;
//        constraints.weighty = 1;
//        constraints.insets = new Insets(125, 0, 0, 0);
//        p1.add(p5, constraints);
//
//        // Wallet label
//        constraints.ipadx = 30;
//        constraints.ipady = 10;
//        constraints.anchor = GridBagConstraints.FIRST_LINE_END;
//        constraints.gridx = 2;
//        constraints.gridy = 1;
//        constraints.gridheight = 0;
//        constraints.gridwidth = 0;
//        constraints.weightx = 1;
//        constraints.weighty = 1;
//        constraints.insets = new Insets(105, 0, 0, 100);
//        p5.add(myWallet, constraints);
//
//        // Wallet textfield
//        constraints.ipadx = 40;
//        constraints.ipady = 10;
//        constraints.anchor = GridBagConstraints.FIRST_LINE_END;
//        constraints.gridx = 2;
//        constraints.gridy = 1;
//        constraints.gridheight = 0;
//        constraints.gridwidth = 0;
//        constraints.weightx = 1;
//        constraints.weighty = 1;
//        constraints.insets = new Insets(100, 0, 0, 50);
//        p5.add(myTextField5, constraints);
//    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
