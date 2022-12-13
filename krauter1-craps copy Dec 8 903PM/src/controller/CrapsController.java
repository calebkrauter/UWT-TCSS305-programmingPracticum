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
    private final JPanel myBackgroundPanel;
    private final JPanel myLeftPanel;
    private final JPanel myCenterPanel;
    private final JPanel drawDice;
    private final JPanel myRightPanel;
    private final JTextField myTextField1;
    private final JTextField myTextField2;
    private final JTextField myTextField3;
    private final JTextField myTextField4;
    private final JTextField myTextField5;
    private final GridBagConstraints myConstraints;
    public final JFrame myJFrame;
    private static String myInitialCount = String.valueOf(0);
    private static final String myPlayerWon = "Player Wins: ";
    private static final String myHouseWon = "House Wins: ";
    private static final String myPoint = "Players Score: ";
    private static final String myRollText = "ROLL!";
    private static final String myWalletText = "Wallet: ";
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
    private static DicePanel dicePanel;
    private static CenterPanel centerPanel;
    private static LeftPanel leftPanel;
    private static RightPanel rightPanel;
    private static TitlePanel titlePanel;




// todo check if I need background for panels and for object panels
    // TODO add passed parameters

    public CrapsController(){
        Random random = new Random();
        int randomRoll1 = random.nextInt(1, 7);
        int randomRoll2 = random.nextInt(1, 7);
        myJFrame = new JFrame("The Game of Craps");
        myConstraints = new GridBagConstraints();
        myBackgroundPanel = new JPanel(new GridBagLayout());
        myBackgroundPanel.setOpaque(true);
        drawDice = new DrawDice(new GridBagLayout(), randomRoll1, randomRoll2);
        drawDice.setOpaque(true);
        myCenterPanel = new JPanel(new GridBagLayout());
        myCenterPanel.setBackground(centerPanelColor);
        myLeftPanel = new JPanel(new GridBagLayout());
        myLeftPanel.setBackground(leftPanelColor);
        myRightPanel = new JPanel(new GridBagLayout());
        myRightPanel.setBackground(rightPanelColor);

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

        dicePanel = new DicePanel(new GridBagLayout(), myBackgroundPanel,
                myCenterPanel, myConstraints, myJFrame, drawDice);
        centerPanel = new CenterPanel(new GridBagLayout(), myBackgroundPanel,
                myCenterPanel, myConstraints, myJFrame, myTextField4, mySum, myRollButton);

        leftPanel = new LeftPanel(new GridBagLayout(), myBackgroundPanel, myLeftPanel, myConstraints,
                myJFrame, myTextField1, myTextField2, myTextField3,
                myPlayerWins, myHouseWins, myHouseWon, myPoints);
        leftPanel.setBackground(leftPanelColor);
        rightPanel = new RightPanel(new GridBagLayout(), myBackgroundPanel, myRightPanel,
                myConstraints, myJFrame, myWallet, myTextField5);
        rightPanel.setBackground(rightPanelColor);
        titlePanel = new TitlePanel(new GridBagLayout(), myBackgroundPanel, l1, myConstraints, myJFrame);
        titlePanel.setOpaque(true);

    }

    public void loadGui() {
        myJFrame.setLocation(SCREEN_SIZE.width / 2 - myJFrame.getWidth() / 2,
        SCREEN_SIZE.height / 2 - myJFrame.getHeight() / 2);
        myJFrame.pack();
        myJFrame.setDefaultCloseOperation(myJFrame.EXIT_ON_CLOSE);
        myJFrame.setSize(800, 750);
        myJFrame.setMinimumSize(new Dimension(700, 750));
        myJFrame.setVisible(true);
        myJFrame.add(myBackgroundPanel);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
