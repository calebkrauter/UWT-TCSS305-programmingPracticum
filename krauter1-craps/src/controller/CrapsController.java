package controller;
import model.GameLogic;
import view.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import static java.awt.event.KeyEvent.*;

// TODO remove any implementation of betbutton
// TODO make sure images load on any pc
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

    private JTextField myTextField1 = new JTextField(myCount);
    private JTextField myTextField2 = new JTextField(myCount);
    private JTextField myTextField3 = new JTextField(myCount);
    private JTextField myTextField4 = new JTextField(String.valueOf(getMyRollTotal()));
    private GameLogic gameLogic;

    private JTextField myTextField5 = new JTextField(String.valueOf(0));
    private GridBagConstraints myTitlePanelConstraints;
    private GridBagConstraints myDicePanelConstraints;
    private GridBagConstraints myLeftPanelConstraints;
    private GridBagConstraints myRightPanelConstraints;
    private GridBagConstraints myCenterPanelConstraints;


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
    private static final ImageIcon myImage = new ImageIcon("image1.jpg");
    private static final JLabel titleImageLabel = new JLabel(myImage);
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
    private static final JButton myRollButton = new JButton(myRollText);
    

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
    private static int myTempValue = 0;
    private static String myBetButtonText = "Bet";
    private static String myBetAmountText1 = "$ 1";
    private static String myBetAmountText2 = "$ 5";
    private static String myBetAmountText3 = "$ 10";
    private static String myBetAmountText4 = "$ 50";
    private static String myBetAmountText5 = "$ 100";
    private static String myBetAmountText6 = "$ 500";
    private static int myBetAmount1 = 1;
    private static int myBetAmount2 = 5;
    private static int myBetAmount3 = 10;
    private static int myBetAmount4 = 50;
    private static int myBetAmount5 = 100;
    private static int myBetAmount6 = 500;
    private static int myBetCounter = 0;


    private static JButton myBetButton = new JButton(myBetButtonText);
    private static JButton myBetAmountButton1 = new JButton(myBetAmountText1);
    private static JButton myBetAmountButton2 = new JButton(myBetAmountText2);
    private static JButton myBetAmountButton3 = new JButton(myBetAmountText3);
    private static JButton myBetAmountButton4 = new JButton(myBetAmountText4);
    private static JButton myBetAmountButton5 = new JButton(myBetAmountText5);
    private static JButton myBetAmountButton6 = new JButton(myBetAmountText6);
    boolean myWin = false;
    private static int mySecondTempValue = 0;
    private static int myThirdTempValue = 0;
    private static int counter1 = 0;
    private static int counter2 = 0;
    private static int myBet = 0;
    private static JMenuBar menuBar = new JMenuBar();
    private static JMenu gameMenu;
    private static JMenu helpMenu;
    private static JMenuItem optionsItem;
    private static JMenuItem startItem;
    private static JMenuItem resetItem;
    private static JMenuItem exitItem;
    private static JMenuItem rulesItem;
    private static JMenuItem aboutItem;

    public CrapsController() {
        gameLogic = new GameLogic();
        myJFrame = new JFrame("The Game of Craps");

        myTitlePanelConstraints = new GridBagConstraints();
        myDicePanelConstraints = new GridBagConstraints();
        myLeftPanelConstraints = new GridBagConstraints();
        myRightPanelConstraints = new GridBagConstraints();
        myCenterPanelConstraints = new GridBagConstraints();

        myBackgroundPanel = new JPanel(new GridBagLayout());
        myBackgroundPanel.setOpaque(true);
        myStartJPane = new JOptionPane();

        drawDice = new DrawDice(new GridBagLayout(), getMyRandomRoll1(), getMyRandomRoll2());
        drawDice.setBackground(myCenterPanelColor);

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

        myTextField1.setEditable(false);
        myTextField2.setEditable(false);
        myTextField3.setEditable(false);
        myTextField4.setEditable(false);
        setCash(getWallet());

        dicePanel = new DicePanel(new GridBagLayout(), myBackgroundPanel,
                myCenterPanel, myDicePanelConstraints, myJFrame, drawDice);


        rightPanel = new RightPanel(new GridBagLayout(), myBackgroundPanel, myRightPanel,
                myRightPanelConstraints, myJFrame, myWalletLabel, myTextField5, myBetButton,
                myBetAmountButton1, myBetAmountButton2, myBetAmountButton3, myBetAmountButton4, myBetAmountButton5, myBetAmountButton6, SCREEN_SIZE);
        rightPanel.setBackground(myRightPanelColor);
        leftPanel = new LeftPanel(new GridBagLayout(), myBackgroundPanel, myLeftPanel, myLeftPanelConstraints,
                myJFrame, myTextField1, myTextField2, myTextField3,
                CrapsController.myPlayerWinsLabel, CrapsController.myHouseWinsLabel, myHouseWon, myScoreLabel, SCREEN_SIZE);
        leftPanel.setBackground(myLeftPanelColor);
        centerPanel = new CenterPanel(new GridBagLayout(), myBackgroundPanel,
                myCenterPanel, myCenterPanelConstraints, myJFrame, myTextField4, CrapsController.mySumLabel, myRollButton, SCREEN_SIZE);
        titlePanel = new TitlePanel(new GridBagLayout(), myBackgroundPanel, titleImageLabel, myTitlePanelConstraints, myJFrame, SCREEN_SIZE);
        titlePanel.setOpaque(true);


        //TODO - add listeners and actions for all menuitems
        //TODO - add sound
        //TODO - add Options
        //TODO - add info to each menuitem page
        //Consider making one page used for all menuitems but display different
        // info depending on the button to minimize code
        menuBar = new JMenuBar();

        optionsItem = new JMenuItem("Options", KeyEvent.VK_O);
        optionsItem.setToolTipText("press 'O'");
        aboutItem = new JMenuItem("About", KeyEvent.VK_A);
        aboutItem.setToolTipText("press 'A'");

        rulesItem = new JMenuItem("Rules", KeyEvent.VK_R);
        rulesItem.setToolTipText("press 'R'");

        startItem = new JMenuItem("About", VK_SPACE);
        startItem.setToolTipText("press 'SPACE'");

        resetItem = new JMenuItem("Reset Game", KeyEvent.VK_R);
        resetItem.setToolTipText("press 'R'");

        exitItem = new JMenuItem("EXIT", KeyEvent.VK_ESCAPE);
        exitItem.setToolTipText("press 'Alt/Option + ESC'");
//        exitItem.setMnemonic(VK_ESCAPE);
        exitItem.setAccelerator(KeyStroke.getKeyStroke(VK_ESCAPE, ActionEvent.ALT_MASK));




        gameMenu = new JMenu("The Game of Craps");
        helpMenu = new JMenu("Help");

        gameMenu.add(startItem);
        gameMenu.add(resetItem);
        gameMenu.add(exitItem);
        gameMenu.add(optionsItem);
        helpMenu.add(aboutItem);
        helpMenu.add(rulesItem);

        menuBar.add(gameMenu);
        menuBar.add(helpMenu);
        listen();
//        performAction();
    }

    public void loadGui() {
        myJFrame.setLocation(SCREEN_SIZE.width / 2 - myJFrame.getWidth() / 2,
                SCREEN_SIZE.height / 2 - myJFrame.getHeight() / 2);
        myJFrame.pack();
        myJFrame.setDefaultCloseOperation(myJFrame.EXIT_ON_CLOSE);
        myJFrame.setSize(800, 750);
        myJFrame.setMinimumSize(new Dimension(700, 750));
        myJFrame.add(myBackgroundPanel);
//        myJFrame.setIconImage(myImage.getImage());
        myJFrame.setJMenuBar(menuBar);
        myJFrame.setVisible(true);

    }


    // TODO when consolidating joptionpane look at this
    //  https://mkyong.com/swing/java-swing-joptionpane-showinputdialog-example/
    private void createStartJPane() {

        String myInput = JOptionPane.showInputDialog(new JFrame(),
                "Enter a dollar amount to start game.", Integer.parseInt("0"));
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
                    gameLogic.setWinValue(false);
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
                    setWallet();
                }
// TODO - add implmentation for buttons.

                if(e.getSource().equals(myBetAmountButton1)) {
                    updateWallet(myBetAmount1);
                }
                if(e.getSource().equals(myBetAmountButton2)) {
                    updateWallet(myBetAmount2);
                }
                if(e.getSource().equals(myBetAmountButton3)) {
                    updateWallet(myBetAmount3);
                }
                if(e.getSource().equals(myBetAmountButton4)) {
                    updateWallet(myBetAmount4);
                }
                if(e.getSource().equals(myBetAmountButton5)) {
                    updateWallet(myBetAmount5);
                }
                if(e.getSource().equals(myBetAmountButton6)) {
                    updateWallet(myBetAmount6);
                }
                if (e.getSource().equals(exitItem)) {
                    System.exit(0);
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
        myBetButton.addActionListener(newAction);
        myBetAmountButton1.addActionListener(newAction);
        myBetAmountButton2.addActionListener(newAction);
        myBetAmountButton3.addActionListener(newAction);
        myBetAmountButton4.addActionListener(newAction);
        myBetAmountButton5.addActionListener(newAction);
        myBetAmountButton6.addActionListener(newAction);

        exitItem.addActionListener(newAction);

    }
//    private void performAction() {
//        AbstractAction action = new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (e.getSource().equals(exitItem)) {
//                }
//            }
//        };
//        exitItem.setAction(action);
//    }


    private void setWallet(int theCash) {
        gameLogic.setWallet(theCash);
        myTextField5.setText(String.valueOf(getWallet()));

    }
    private void setWallet() {
        myTextField5.setText(String.valueOf(getWallet()));
    }
    private void updateWallet(int theBet) {
        myBet = theBet;
        gameLogic.updateWallet(myBet);
        myTextField5.setText(String.valueOf(getWallet()));
    }
    public int getWallet() {
        return gameLogic.getWallet();
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
    private void setCash(int theCash) {
        gameLogic.setCash(theCash);
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
