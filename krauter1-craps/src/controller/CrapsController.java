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
import static java.awt.event.KeyEvent.*;

public class CrapsController extends JPanel implements PropertyChangeListener {
    private static String myCount = String.valueOf(0);
    private static final String myPlayerWon = "Player Wins: ";
    private static final String myHouseWon = "House Wins: ";
    private static final String myScoreText = "Players Score: ";
    private static final String myRollText = "ROLL!";
    private static final String myWalletText = "Wallet: ";
    private static final String myTotalText = "TOTAL: ";
    private static String myBetButtonText = "Bet";
    private static String myBetAmountText1 = "$ 1";
    private static String myBetAmountText2 = "$ 5";
    private static String myBetAmountText3 = "$ 10";
    private static String myBetAmountText4 = "$ 50";
    private static String myBetAmountText5 = "$ 100";
    private static String myBetAmountText6 = "$ 500";
    private int myRandomRoll2;
    private int myPlayerWins;
    private int myHouseWins;
    private int myPlayerScore;
    private int myRollValue = 0;
    private static int myBetAmount1 = 1;
    private static int myBetAmount2 = 5;
    private static int myBetAmount3 = 10;
    private static int myBetAmount4 = 50;
    private static int myBetAmount5 = 100;
    private static int myBetAmount6 = 500;
    private int myRandomRoll1;
    private static final Color myCenterPanelColor = Color.decode("#FF8383");
    private static final Color myLeftPanelColor = Color.decode("#D9D8C0");
    private static final Color myRightPanelColor = Color.decode("#97D0E3");
    private static final Color myBackgroundPanelColor = Color.decode("#B97A57");
    private DrawDice drawDice;
    private JPanel myRightPanel;
    private JPanel myLeftPanel;
    private JPanel myCenterPanel;
    private JPanel myBackgroundPanel;
    private static DicePanel dicePanel;
    private static CenterPanel centerPanel;
    private static LeftPanel leftPanel;
    private static RightPanel rightPanel;
    private static TitlePanel titlePanel;
    private static final ImageIcon myImage = new ImageIcon("src/controller/poopy.png");
    private static final ImageIcon myImageIcon = new ImageIcon("src/controller/poopyIcon.png");
    private static final ImageIcon myExitImageIcon = new ImageIcon("src/controller/poopyIconSad.png");
    private static final JLabel titleImageLabel = new JLabel(myImage);
    private static final JLabel myPlayerWinsLabel = new JLabel(myPlayerWon);
    private static final JLabel myHouseWinsLabel = new JLabel(myHouseWon);
    private static final JLabel myScoreLabel = new JLabel(myScoreText);
    private static final JLabel mySumLabel = new JLabel(myTotalText);
    private static final JLabel myWalletLabel = new JLabel(myWalletText);
    private JTextField myPlayerWinsField = new JTextField(myCount);
    private JTextField myHouseWinsField = new JTextField(myCount);
    private JTextField myScoreField = new JTextField(myCount);
    private JTextField myRollField = new JTextField(String.valueOf(getMyRollTotal()));
    private JTextField myWalletField = new JTextField(String.valueOf(0));
    private GameLogic gameLogic;
    private GridBagConstraints myTitlePanelConstraints;
    private GridBagConstraints myDicePanelConstraints;
    private GridBagConstraints myLeftPanelConstraints;
    private GridBagConstraints myRightPanelConstraints;
    private GridBagConstraints myCenterPanelConstraints;
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
    public JFrame myJFrame;
    private static final JButton myRollButton = new JButton(myRollText);
    private static JButton myBetButton = new JButton(myBetButtonText);
    private static JButton myBetAmountButton1 = new JButton(myBetAmountText1);
    private static JButton myBetAmountButton2 = new JButton(myBetAmountText2);
    private static JButton myBetAmountButton3 = new JButton(myBetAmountText3);
    private static JButton myBetAmountButton4 = new JButton(myBetAmountText4);
    private static JButton myBetAmountButton5 = new JButton(myBetAmountText5);
    private static JButton myBetAmountButton6 = new JButton(myBetAmountText6);
    private static JMenuBar menuBar = new JMenuBar();
    private static BuildMenus buildMenus;
    private static JMenu gameMenu;
    private static JMenu helpMenu;
    private static JMenuItem optionsItem;
    private static JMenuItem startItem;
    private static JMenuItem resetItem;
    private static JMenuItem exitItem;
    private static JMenuItem rulesItem;
    private static JMenuItem aboutItem;
    private static boolean myBetButtonEnabled = false;

    public CrapsController() {

        gameLogic = new GameLogic();
        myJFrame = new JFrame("The Game of Craps");
        myTitlePanelConstraints = new GridBagConstraints();
        myDicePanelConstraints = new GridBagConstraints();
        myLeftPanelConstraints = new GridBagConstraints();
        myRightPanelConstraints = new GridBagConstraints();
        myCenterPanelConstraints = new GridBagConstraints();

        // Panels
        myBackgroundPanel = new JPanel(new GridBagLayout());
        myBackgroundPanel.setBackground(myBackgroundPanelColor);
        drawDice = new DrawDice(new GridBagLayout(), getMyRandomRoll1(), getMyRandomRoll2());
        drawDice.setBackground(myCenterPanelColor);
        myRightPanel = new JPanel(new GridBagLayout());
        myRightPanel.setBackground(myRightPanelColor);
        myLeftPanel = new JPanel(new GridBagLayout());
        myLeftPanel.setBackground(myLeftPanelColor);
        myCenterPanel = new JPanel(new GridBagLayout());
        myCenterPanel.setBackground(myCenterPanelColor);
        dicePanel = new DicePanel(new GridBagLayout(), myBackgroundPanel,
                myCenterPanel, myDicePanelConstraints, myJFrame, drawDice, SCREEN_SIZE);
        rightPanel = new RightPanel(new GridBagLayout(), myBackgroundPanel, myRightPanel,
                myRightPanelConstraints, myJFrame, myWalletLabel, myWalletField, myBetButton,
                myBetAmountButton1, myBetAmountButton2, myBetAmountButton3, myBetAmountButton4, myBetAmountButton5, myBetAmountButton6, SCREEN_SIZE);
        rightPanel.setBackground(myRightPanelColor);
        leftPanel = new LeftPanel(new GridBagLayout(), myBackgroundPanel, myLeftPanel, myLeftPanelConstraints,
                myJFrame, myPlayerWinsField, myHouseWinsField, myScoreField,
                CrapsController.myPlayerWinsLabel, CrapsController.myHouseWinsLabel, myHouseWon, myScoreLabel, SCREEN_SIZE);
        leftPanel.setBackground(myLeftPanelColor);
        centerPanel = new CenterPanel(new GridBagLayout(), myBackgroundPanel,
                myCenterPanel, myCenterPanelConstraints, myJFrame, myRollField, CrapsController.mySumLabel, myRollButton, SCREEN_SIZE);

        titlePanel = new TitlePanel(new GridBagLayout(), myBackgroundPanel, titleImageLabel, myTitlePanelConstraints, myJFrame, SCREEN_SIZE);
        titlePanel.setOpaque(true);

        myPlayerWinsField.setEditable(false);
        myHouseWinsField.setEditable(false);
        myScoreField.setEditable(false);
        myRollField.setEditable(false);
        setMyRandomNum1();
        setMyRandomNum2();
        setMyRollTotal();
        createStartJPane();
        loadGui();
        loadMenus();
        listen();
        setEnableBetButtons(false);
        setWalletTextFieldEditable(false);
        setEnableRollButton(false);

        myRollButton.setMnemonic(VK_7);
        myRollButton.setToolTipText("press '7'");
    }
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
    public void loadGui() {
        myJFrame.setLocation(SCREEN_SIZE.width / 2 - myJFrame.getWidth() / 2,
                SCREEN_SIZE.height / 2 - myJFrame.getHeight() / 2);
        myJFrame.pack();
        myJFrame.setDefaultCloseOperation(myJFrame.EXIT_ON_CLOSE);
        myJFrame.setSize(850, 850);
        myJFrame.setMinimumSize(new Dimension(750, 750));
        myJFrame.add(myBackgroundPanel);
        myJFrame.setIconImage(myImageIcon.getImage());
        myJFrame.setJMenuBar(menuBar);
        myJFrame.setVisible(true);

    }
    private void loadMenus() {
        menuBar = new JMenuBar();

        optionsItem = new JMenuItem("Options", KeyEvent.VK_O);
        aboutItem = new JMenuItem("About", KeyEvent.VK_A);
        rulesItem = new JMenuItem("Rules", KeyEvent.VK_R);
        startItem = new JMenuItem("Start", VK_SPACE);
        resetItem = new JMenuItem("Reset Game", KeyEvent.VK_R);
        exitItem = new JMenuItem("EXIT", KeyEvent.VK_ESCAPE);

        gameMenu = new JMenu("The Game of Craps");
        helpMenu = new JMenu("Help");
        buildMenus = new BuildMenus(startItem, resetItem, exitItem, optionsItem, aboutItem, rulesItem);

        gameMenu.add(startItem);
        gameMenu.add(resetItem);
        gameMenu.add(exitItem);
        gameMenu.add(optionsItem);
        helpMenu.add(aboutItem);
        helpMenu.add(rulesItem);

        menuBar.add(gameMenu);
        menuBar.add(helpMenu);
    }


    // TODO implement helper methods to simplify code in action performed consolidating specific actions.
    private void listen() {
        final ActionListener newAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(myRollButton) || e.getSource().equals(VK_7)) {
                    gameLogic.setWinValue(false);
                    setMyRandomNum1();
                    setMyRandomNum2();
                    drawDice.setRandomNum1(getMyRandomRoll1());
                    drawDice.setRandomNum2(getMyRandomRoll2());
                    drawDice.repaint();
                    drawDice.setBackground(myCenterPanelColor);
                    setMyRollTotal();
                    myRollField.setText(String.valueOf(getMyRollTotal()));
                    gameLogic.scoreLogic();
                    setPlayerWins();
                    setHouseWins();
                    setPlayerScore();
                    myPlayerWinsField.setText(String.valueOf(getPlayerWins()));
                    myHouseWinsField.setText(String.valueOf(getHouseWins()));
                    myScoreField.setText(String.valueOf(getPlayerScore()));
                    if(getWinValue()) {
                        setWalletTextFieldEditable(true);
                        updateWalletTextField();
                        setEnableBetButtons(true);
                        setEnableRollButton(false);
                    } else {
                        setEnableBetButtons(false);
                    }
                }


                if(e.getSource().equals(myBetAmountButton1)) {
                    updateWalletAfterBet(myBetAmount1);
                    setEnableRollButton(true);
                    setWalletTextFieldEditable(false);
                }
                if(e.getSource().equals(myBetAmountButton2)) {
                    updateWalletAfterBet(myBetAmount2);
                    setEnableRollButton(true);
                    setWalletTextFieldEditable(false);
                }
                if(e.getSource().equals(myBetAmountButton3)) {
                    updateWalletAfterBet(myBetAmount3);
                    setEnableRollButton(true);
                    setWalletTextFieldEditable(false);
                }
                if(e.getSource().equals(myBetAmountButton4)) {
                    updateWalletAfterBet(myBetAmount4);
                    setEnableRollButton(true);
                    setWalletTextFieldEditable(false);
                }
                if(e.getSource().equals(myBetAmountButton5)) {
                    updateWalletAfterBet(myBetAmount5);
                    setEnableRollButton(true);
                    setWalletTextFieldEditable(false);
                }
                if(e.getSource().equals(myBetAmountButton6)) {
                    updateWalletAfterBet(myBetAmount6);
                    setEnableRollButton(true);
                    setWalletTextFieldEditable(false);
                }
                if (e.getSource().equals(startItem)) {
                    setEnableBetButtons(true);
                    setWalletTextFieldEditable(true);
                }
                if (e.getSource().equals(resetItem)) {
                    setEnableBetButtons(false);
                    setWalletTextFieldEditable(false);
                    setEnableRollButton(false);
                    resetGameData();

                }
                if (e.getSource().equals(exitItem)) {
                    int input = JOptionPane.showConfirmDialog(new JFrame(), "It would stink if you left. " +
                                                "\nAre you sure that's what you want to do?", "DON'T LEAVE YOU IDIOT", JOptionPane.YES_OPTION, JOptionPane.NO_OPTION, myExitImageIcon);
                    if (input == 0) {
                        System.exit(0);
                    }
                }
                if (e.getSource().equals(aboutItem)) {
                    JOptionPane.showMessageDialog(new JFrame(), "Author: Caleb Krauter -> App version 1.0",
                            "About", JOptionPane.DEFAULT_OPTION, myImageIcon);
                }
                if (e.getSource().equals((rulesItem))) {
                    JOptionPane.showMessageDialog(new JFrame(), "The rules of the Game of craps are as follows:\n" +
                            "\n" +
                            "- A player rolls two dice where each die has six faces in the usual way (values 1 through 6).\n" +
                            "- After the dice have come to rest the sum of the two upward faces is calculated.\n" +
                            "- The first roll/throw\n" +
                            "\n- If the sum is 7 or 11 on the first throw the roller/player wins.\n" +
                            "- If the sum is 2, 3 or 12 the roller/player loses, that is the house wins.\n" +
                            "- If the sum is 4, 5, 6, 8, 9, or 10, that sum becomes the roller/player's 'point'.\n" +
                            "\n-Continue rolling given the player's point\n" +
                            "-Now the player must roll the 'point' total before rolling a 7 in order to win.\n" +
                            "-If they roll a 7 before rolling the point value they got on" +
                            " the first roll the roller/player loses (the 'house' wins).", "Rules",
                            JOptionPane.DEFAULT_OPTION, myImageIcon);
                }
            }
        };

        final KeyListener newKeyAction = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {

            }
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getSource().equals(myWalletField)) {
                    setWallet(Integer.parseInt(myWalletField.getText()));
                }
                    System.out.println(e.getKeyChar());


            }
        };

        myWalletField.addKeyListener(newKeyAction);

        myRollButton.addActionListener(newAction);
        myBetAmountButton1.addActionListener(newAction);
        myBetAmountButton2.addActionListener(newAction);
        myBetAmountButton3.addActionListener(newAction);
        myBetAmountButton4.addActionListener(newAction);
        myBetAmountButton5.addActionListener(newAction);
        myBetAmountButton6.addActionListener(newAction);

        gameMenu.addActionListener(newAction);
        startItem.addActionListener(newAction);
        resetItem.addActionListener(newAction);
        exitItem.addActionListener(newAction);
        aboutItem.addActionListener(newAction);
        rulesItem.addActionListener(newAction);

    }
    // TODO set initial cash text field and then after a round ends set the cash to be initialcash

    private void setWallet(int theCurrentCash) {
        gameLogic.setWallet(theCurrentCash);
        myWalletField.setText(String.valueOf(getWallet()));
    }
    private void updateWalletTextField() {
        myWalletField.setText(String.valueOf(getWallet()));

    }
    private int getWallet() {
        System.out.println("wallet" + gameLogic.getWallet());
        return gameLogic.getWallet();
    }
    private void updateWalletAfterBet(int theBet) {
        gameLogic.updateWalletAfterBet(theBet, betButtonsEnabled());
        myWalletField.setText(String.valueOf(getWallet()));
    }
    public void setPlayerScore(int theScore) {
        gameLogic.setPlayerScore(theScore);
        myPlayerScore = gameLogic.getPlayerScore();
    }
    private void resetGameData() {
        gameLogic.resetGameData();
        setPlayerWins();
        setHouseWins();
        setPlayerScore(0);
        myPlayerWinsField.setText(String.valueOf(getPlayerWins()));
        myHouseWinsField.setText(String.valueOf(getHouseWins()));
        myScoreField.setText(String.valueOf(getPlayerScore()));
        myWalletField.setText(String.valueOf(getWallet()));

    }

    private void setEnableBetButtons(boolean theValue) {
        myBetAmountButton1.setEnabled(theValue);
        myBetAmountButton2.setEnabled(theValue);
        myBetAmountButton3.setEnabled(theValue);
        myBetAmountButton4.setEnabled(theValue);
        myBetAmountButton5.setEnabled(theValue);
        myBetAmountButton6.setEnabled(theValue);

        if (myBetAmountButton1.isEnabled()) {
            myBetButtonEnabled = true;
        } else {
            myBetButtonEnabled = false;
        }
        betButtonsEnabled();
    }
    private boolean betButtonsEnabled() {
        return myBetButtonEnabled;
    }
    private void setEnableRollButton(boolean theValue) {
        myRollButton.setEnabled(theValue);
    }
    private void setWalletTextFieldEditable(boolean theValue) {
        myWalletField.setEditable(theValue);
    }
//    public int getWallet() {
//        return gameLogic.getWallet();
//    }

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

    private int getMyRandomRoll1() {
       return myRandomRoll1;
    }

    private int getMyRandomRoll2() {
        return myRandomRoll2;
    }

    private void setMyRollTotal() {
        gameLogic.setMyRollTotal();
        myRollValue = gameLogic.getRollTotal();
        myRollField.setText(String.valueOf(getMyRollTotal()));

    }
    private int getMyRollTotal() {
        return myRollValue;
    }
    private boolean getWinValue() {
        return gameLogic.getWinValue();
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
