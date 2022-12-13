package controller;
import model.GameLogic;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static java.awt.event.KeyEvent.VK_SPACE;
// TODO add poop emoji, try using a sprite sheet.
// TODO - make sure that the textboxes can't adjust to become too large if there are many wins.
// TODO - check order of params in constructor
// TODO - Add arguments to the constructor
// TODO - figure out if I need to add a super call in the constructor.
// TODO - simplify code by taking alike blocks of code and consolidating to methods
// TODO - implement wallet/bank
// TODO - implement toolbar
// TODO - add extra credit
// TODO - make the title photo stop moving when resizing in the y direction
// TODO - make sure the game consistently loads correctly without bugging out and all components and panels are in the righ places

public class CrapsController extends JPanel implements PropertyChangeListener {
    private int anchor = 0;
    private static final Color myCenterPanelColor = Color.decode("#FF8383");
    private static final Color myLeftPanelColor = Color.decode("#D9D8C0");
    private static final Color myRightPanelColor = Color.decode("#97D0E3");
    private JPanel myBackgroundPanel;
    private JPanel myLeftPanel;
    private JPanel myCenterPanel;
    private DrawDice drawDice;
    private JPanel myRightPanel;

    private JTextField myTextField1;
    private JTextField myTextField2;
    private JTextField myTextField3;
    private JTextField myTextField4;
    private JTextField myTextField5;
    private GridBagConstraints myConstraints;
    public JFrame myJFrame;
    private static String myCount = String.valueOf(0);
    private static final String myPlayerWon = "Player Wins: ";
    private static final String myHouseWon = "House Wins: ";
    private static final String myScoreText = "Players Score: ";
    private static final String myRollText = "ROLL!";
    private static final String myWalletText = "Wallet: ";
    private static final String myTotalText = "TOTAL: ";
    private static final JLabel myPlayerWinsLabel = new JLabel(myPlayerWon);
    private static final JLabel myHouseWinsLabel = new JLabel(myHouseWon);
    private static final JLabel myScoreLabel = new JLabel(myScoreText);
    private static final JLabel mySumLabel = new JLabel(myTotalText);
    private static final JLabel myWalletLabel = new JLabel(myWalletText);
    private static final JLabel l1 = new JLabel(new ImageIcon("/Users/calebkrauter/Workspace/uw-tcss-305/krauter1-craps/src/controller/image1.jpg"));
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
    private static final JButton myRollButton = new JButton(myRollText);
    private GameLogic gameLogic;

    private static DicePanel dicePanel;
    private static CenterPanel centerPanel;
    private static LeftPanel leftPanel;
    private static RightPanel rightPanel;
    private static TitlePanel titlePanel;
    private int myRandomRoll1;
    private int myRandomRoll2;
    private int mySum;
    private int myPlayerWins;
    private int myHouseWins;
    private int myPlayerScore;
    private int myRollValue = 0;

    private static final Color myInvisibleColor = new Color(0xFF, 0xFF, 0xFF, 0x33);


    private JButton myButton;
    private static JPanel myStartPanel;
    private static JOptionPane myStartJPane;
//    InputMap inputMap = myButton.getInputMap();

    private static int myCash = 0;

    private static String myBetButtonText = "Bet";
    private static String myBetAmountText1 = "$ 1";
    private static String myBetAmountText2 = "$ 5";
    private static String myBetAmountText3 = "$ 10";
    private static String myBetAmountText4 = "$ 50";
    private static String myBetAmountText5 = "$ 100";
    private static String myBetAmountText6 = "$ 500";


    private static JButton myBetButton = new JButton(myBetButtonText);
    private static JButton myBetAmount1 = new JButton(myBetAmountText1);
    private static JButton myBetAmount2 = new JButton(myBetAmountText2);
    private static JButton myBetAmount3 = new JButton(myBetAmountText3);
    private static JButton myBetAmount4 = new JButton(myBetAmountText4);
    private static JButton myBetAmount5 = new JButton(myBetAmountText5);
    private static JButton myBetAmount6 = new JButton(myBetAmountText6);



    public CrapsController() {
        gameLogic = new GameLogic();
        myJFrame = new JFrame("The Game of Craps");
        myConstraints = new GridBagConstraints();
        myBackgroundPanel = new JPanel(new GridBagLayout());
        myBackgroundPanel.setOpaque(true);
        myStartJPane = new JOptionPane();
//        inputMap.put(KeyStroke.getKeyStroke("ENTER"), "pressed");

        listen();
        drawDice = new DrawDice(new GridBagLayout(), getMyRandomRoll1(), getMyRandomRoll2());
        drawDice.setOpaque(true);
        setMyRandomNum1();
        setMyRandomNum2();
        setMyRollTotal();

        myCenterPanel = new JPanel(new GridBagLayout());
        myCenterPanel.setBackground(myCenterPanelColor);
        myLeftPanel = new JPanel(new GridBagLayout());
        myLeftPanel.setBackground(myLeftPanelColor);
        myRightPanel = new JPanel(new GridBagLayout());
        myRightPanel.setBackground(myRightPanelColor);
        myStartPanel = new JPanel(new GridBagLayout());
        myStartPanel.setBackground(Color.RED);
        createStartJPane();
        loadGui();
        myTextField1 = new JTextField(myCount);
        myTextField2 = new JTextField(myCount);
        myTextField3 = new JTextField(myCount);
        myTextField4 = new JTextField(String.valueOf(getMyRollTotal()));
        myTextField5 = new JTextField(String.valueOf(getWallet()));
        myTextField1.setEditable(false);
        myTextField2.setEditable(false);
        myTextField3.setEditable(false);
        myTextField4.setEditable(false);


        dicePanel = new DicePanel(new GridBagLayout(), myBackgroundPanel,
                myCenterPanel, myConstraints, myJFrame, drawDice);
        centerPanel = new CenterPanel(new GridBagLayout(), myBackgroundPanel,
                myCenterPanel, myConstraints, myJFrame, myTextField4, CrapsController.mySumLabel, myRollButton);

        leftPanel = new LeftPanel(new GridBagLayout(), myBackgroundPanel, myLeftPanel, myConstraints,
                myJFrame, myTextField1, myTextField2, myTextField3,
                CrapsController.myPlayerWinsLabel, CrapsController.myHouseWinsLabel, myHouseWon, myScoreLabel);
        leftPanel.setBackground(myLeftPanelColor);
        rightPanel = new RightPanel(new GridBagLayout(), myBackgroundPanel, myRightPanel,
                myConstraints, myJFrame, myWalletLabel, myTextField5, myBetButton,
                myBetAmount1, myBetAmount2, myBetAmount3, myBetAmount4, myBetAmount5, myBetAmount6);
        rightPanel.setBackground(myRightPanelColor);
        titlePanel = new TitlePanel(new GridBagLayout(), myBackgroundPanel, l1, myConstraints, myJFrame);
        titlePanel.setOpaque(true);

    }

    // TODO when consolidating joptionpane look at this
    //  https://mkyong.com/swing/java-swing-joptionpane-showinputdialog-example/
    private void createStartJPane() {

        String myInput = JOptionPane.showInputDialog(new JFrame(),
                "Enter a dollar amount to start game.", "0");
        boolean isGoodNumber = true;

        // TODO - Make sure exception is being thrown.
        if (myInput.isBlank()) {
            throw new NullPointerException("Text field has null input");
        }
        if (Integer.parseInt(myInput) <= 0) {
            isGoodNumber = false;
            System.exit(0);
        } else {
            isGoodNumber = true;
            setWallet(Integer.parseInt(myInput));
        }


    }

    // TODO implement helper methods to simplify code in action performed consolidating specific actions.
    private void listen() {

        final ActionListener newAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(myRollButton)) {
                    setMyRandomNum1();
                    setMyRandomNum2();
                    drawDice.setRandomNum1(getMyRandomRoll1());
                    drawDice.setRandomNum2(getMyRandomRoll2());
                    drawDice.repaint();
                    drawDice.setBackground(myCenterPanelColor);
                    setMyRollTotal();
                    myTextField4.setText(String.valueOf(getMyRollTotal()));
                    gameLogic.scoreLogic();
                    setPlayerWins();
                    setHouseWins();
                    setPlayerScore();
                    myTextField1.setText(String.valueOf(getPlayerWins()));
                    myTextField2.setText(String.valueOf(getHouseWins()));
                    myTextField3.setText(String.valueOf(getPlayerScore()));
                }
            }
        };

        final KeyListener newKeyAction = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getSource().equals(VK_SPACE)) {

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

        myRollButton.addActionListener(newAction);
        myRollButton.addKeyListener(newKeyAction);
    }

    public void loadGui() {
        myJFrame.setLocation(SCREEN_SIZE.width / 2 - myJFrame.getWidth() / 2,
                SCREEN_SIZE.height / 2 - myJFrame.getHeight() / 2);
        myJFrame.pack();
        myJFrame.setDefaultCloseOperation(myJFrame.EXIT_ON_CLOSE);
        myJFrame.setSize(800, 750);
        myJFrame.setMinimumSize(new Dimension(700, 750));
        myJFrame.add(myBackgroundPanel);
        myJFrame.setVisible(true);

    }


    private void setMyCount(int theValue) {
        myCount = String.valueOf(theValue);
    }

    private void setWallet(int theValue) {
        myCash = theValue;
    }

    private int getWallet() {
        return myCash;
    }

    private void setPlayerWins() {
        myPlayerWins = gameLogic.getPlayerWins();
    }
    private void setHouseWins() {
        myHouseWins = gameLogic.getHouseWins();
    }
    public void setPlayerScore() {
        myPlayerScore = gameLogic.getPlayerScore();
    }
    public int getPlayerWins() {
        return myPlayerWins;
    }
    public int getHouseWins() {
        return myHouseWins;
    }
    public int getPlayerScore() {
        return myPlayerScore;
    }

    private void setMyRandomNum1() {
        gameLogic.setMyRandomRoll1();
        myRandomRoll1 = gameLogic.getRandomRoll1();
        drawDice.setRandomNum1(myRandomRoll1);
    }
    private void setMyRandomNum2() {
        gameLogic.setMyRandomRoll2();
        myRandomRoll2 = gameLogic.getRandomRoll2();
        drawDice.setRandomNum2(myRandomRoll2);
    }

    private void resetRoll() {
        myRandomRoll1 = 0;
        myRandomRoll1 = 0;
    }
    private int getMyRandomRoll1() {
       return myRandomRoll1;
    }

    private int getMyRandomRoll2() {
        return myRandomRoll2;
    }

    private void setMyRollTotal() {
        gameLogic.setMyRollTotal();
        myRollValue = gameLogic.getRollTotal();
    }
    private int getMyRollTotal() {
        return myRollValue;
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
