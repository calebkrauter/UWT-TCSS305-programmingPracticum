package controller;

import model.GameLogic;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.InputMismatchException;

import static java.awt.event.KeyEvent.*;

public class CrapsController extends JPanel implements PropertyChangeListener {
    private static String myCount = String.valueOf(0);
    private int myRandomRoll2;
    private int myPlayerWins;
    private int myHouseWins;
    private int myPlayerScore;
    private int myRollValue = 0;
    private final static int myBet1 = 1;
    private final static int myBet2 = 5;
    private final static int myBet3 = 10;
    private final static int myBet4 = 50;
    private final static int myBet5 = 100;
    private final static int myBet6 = 500;
    private int myRandomRoll1;
    private static final Color myCenterPanelColor = Color.decode("#FF8383");
    private static final Color myLeftPanelColor = Color.decode("#D9D8C0");
    private static final Color myRightPanelColor = Color.decode("#97D0E3");
    private static final Color myBackgroundPanelColor = Color.decode("#B97A57");
    private DrawDice drawDice;
    private GameLogic gameLogic;
    private final JPanel myRightPanel;
    private final JPanel myLeftPanel;
    private final JPanel myCenterPanel;
    private final JPanel myBackgroundPanel;
    private final DicePanel dicePanel;
    private final CenterPanel centerPanel;
    private final LeftPanel leftPanel;
    private final RightPanel rightPanel;
    private final TitlePanel titlePanel;
    private static final ImageIcon myImage = new ImageIcon("src/controller/poopy.png");
    private static final ImageIcon myImageIcon = new ImageIcon("src/controller/poopyIcon.png");
    private static final ImageIcon myExitImageIcon = new ImageIcon("src/controller/poopyIconSad.png");
    private static final JLabel titleImageLabel = new JLabel(myImage);
    private static final JLabel myPlayerWinsLabel = new JLabel("Player Wins: ");
    private static final JLabel myHouseWinsLabel = new JLabel("House Wins: ");
    private static final JLabel myScoreLabel = new JLabel("Players Score: ");
    private static final JLabel mySumLabel = new JLabel("TOTAL: ");
    private static final JLabel myWalletLabel = new JLabel("Wallet: ");
    private JTextField myPlayerWinsField = new JTextField(myCount);
    private JTextField myHouseWinsField = new JTextField(myCount);
    private JTextField myScoreField = new JTextField(myCount);
    private JTextField myRollField = new JTextField(String.valueOf(getMyRollTotal()));
    private JTextField myWalletField = new JTextField(String.valueOf(0));
    private GridBagConstraints myTitlePanelConstraints;
    private GridBagConstraints myDicePanelConstraints;
    private GridBagConstraints myLeftPanelConstraints;
    private GridBagConstraints myRightPanelConstraints;
    private GridBagConstraints myCenterPanelConstraints;
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
    private static final JButton myRollButton = new JButton("Roll");
    private JButton myBetButton1 = new JButton(intToMoneyString(myBet1));
    private JButton myBetButton2 = new JButton(intToMoneyString(myBet2));
    private JButton myBetButton3 = new JButton(intToMoneyString(myBet3));
    private JButton myBetButton4 = new JButton(intToMoneyString(myBet4));
    private JButton myBetButton5 = new JButton(intToMoneyString(myBet5));
    private JButton myBetButton6 = new JButton(intToMoneyString(myBet6));
    private JButton myPlayAgainButton = new JButton("Play Again");
    private static JMenuBar menuBar = new JMenuBar();
    private final JMenu gameMenu;
    private final JMenu helpMenu;
    private final JMenuItem startItem;
    private final JMenuItem resetItem;
    private final JMenuItem playAgainItem;
    private final JMenuItem exitItem;
    private final JMenuItem rulesItem;
    private final JMenuItem aboutItem;
    private static boolean myBetButtonEnabled = false;
    public JFrame myJFrame;

    public CrapsController() {

        gameLogic = new GameLogic();
        myJFrame = new JFrame("The Game of Craps");

        // GridBagConstraints
        myTitlePanelConstraints = new GridBagConstraints();
        myDicePanelConstraints = new GridBagConstraints();
        myLeftPanelConstraints = new GridBagConstraints();
        myRightPanelConstraints = new GridBagConstraints();
        myCenterPanelConstraints = new GridBagConstraints();

        // Panels
        myBackgroundPanel = new JPanel(new GridBagLayout());
        drawDice = new DrawDice(
                new GridBagLayout(),
                getMyRandomRoll1(),
                getMyRandomRoll2());
        myRightPanel = new JPanel(new GridBagLayout());
        myLeftPanel = new JPanel(new GridBagLayout());
        myCenterPanel = new JPanel(new GridBagLayout());
        dicePanel = new DicePanel(
                new GridBagLayout(),
                myCenterPanel,
                myDicePanelConstraints,
                drawDice,
                SCREEN_SIZE);
        rightPanel = new RightPanel(
                new GridBagLayout(),
                myBackgroundPanel,
                myRightPanel,
                myRightPanelConstraints,
                myJFrame,
                myWalletLabel,
                myWalletField,
                myBetButton1,
                myBetButton2,
                myBetButton3,
                myBetButton4,
                myBetButton5,
                myBetButton6,
                SCREEN_SIZE);
        leftPanel = new LeftPanel(
                new GridBagLayout(),
                myBackgroundPanel,
                myLeftPanel,
                myLeftPanelConstraints,
                myJFrame,
                myPlayerWinsField,
                myHouseWinsField,
                myScoreField,
                myPlayerWinsLabel,
                myHouseWinsLabel,
                myScoreLabel,
                SCREEN_SIZE, myPlayAgainButton);
        centerPanel = new CenterPanel(
                new GridBagLayout(),
                myBackgroundPanel,
                myCenterPanel,
                myCenterPanelConstraints,
                myJFrame,
                myRollField,
                mySumLabel,
                myRollButton,
                SCREEN_SIZE);
        titlePanel = new TitlePanel(
                new GridBagLayout(),
                myBackgroundPanel,
                titleImageLabel,
                myTitlePanelConstraints,
                myJFrame,
                SCREEN_SIZE);

        //Set background colors
        myBackgroundPanel.setBackground(myBackgroundPanelColor);
        drawDice.setBackground(myCenterPanelColor);
        myRightPanel.setBackground(myRightPanelColor);
        myLeftPanel.setBackground(myLeftPanelColor);
        myCenterPanel.setBackground(myCenterPanelColor);
        rightPanel.setBackground(myRightPanelColor);
        leftPanel.setBackground(myLeftPanelColor);
        titlePanel.setOpaque(true);

        myPlayerWinsField.setEditable(false);
        myHouseWinsField.setEditable(false);
        myScoreField.setEditable(false);
        myRollField.setEditable(false);


        menuBar = new JMenuBar();

        aboutItem = new JMenuItem("About", VK_A);
        rulesItem = new JMenuItem("Rules", VK_R);
        startItem = new JMenuItem("Start", VK_S);
        resetItem = new JMenuItem("Reset Game", VK_X);
        playAgainItem = new JMenuItem("Play Again", VK_P);
        exitItem = new JMenuItem("EXIT", VK_C);

        gameMenu = new JMenu("The Game of Craps");
        helpMenu = new JMenu("Help");

        startItem.setEnabled(true);
        playAgainItem.setEnabled(false);
        myPlayAgainButton.setEnabled(false);

        new Shortcuts(startItem,
                resetItem,
                exitItem,
                rulesItem,
                aboutItem,
                playAgainItem,
                myRollButton,
                myBetButton1,
                myBetButton2,
                myBetButton3,
                myBetButton4,
                myBetButton5,
                myBetButton6, myPlayAgainButton);
        addMenuComponents();

        setMyRandomNum1();
        setMyRandomNum2();
        setEnableBetButtons(false);
        setWalletTextFieldEditable(false);
        setEnableRollButton(false);
        myRollField.setText(String.valueOf(0));
        createStartJPane();
        loadGui();
        listen();

    }

    private String intToMoneyString(int theText) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("$ ");
        stringBuilder.append(theText);
        return stringBuilder.toString();
    }

    private void addMenuComponents() {
        gameMenu.add(startItem);
        gameMenu.add(resetItem);
        gameMenu.add(playAgainItem);
        gameMenu.add(exitItem);
        helpMenu.add(aboutItem);
        helpMenu.add(rulesItem);

        menuBar.add(gameMenu);
        menuBar.add(helpMenu);
    }

    private void createStartJPane() {

        String myInput = JOptionPane.showInputDialog(new JFrame(),
                "Enter a dollar amount to start game.", Integer.parseInt("0"));

       try {
           if (Integer.parseInt(myInput) <= 0) {
               badInputError();
           } else {
               setWallet(Integer.parseInt(myInput));
           }
       } catch (NumberFormatException e) {
           badInputError();
       }


    }

    private void badInputError() {
        JOptionPane.showConfirmDialog(new JFrame(),
                "Error - You may enter a new value when you start the game.",
                "ERROR",
                JOptionPane.DEFAULT_OPTION);
    }
    private void youWonMessage() {
        int input = JOptionPane.showConfirmDialog(new JFrame(),"You are so cool. Keep playing. "
                + "You deserve to spend some money. "
                + "\nYOU WON!" + "\nWould you like to play again?", "You Won",
                JOptionPane.OK_OPTION );
        if (input == 0) {
            playAgain();
        } else {
            reset();
        }
    }
    private void youLostMessage() {
        int input = JOptionPane.showConfirmDialog(new JFrame(),"That stunk, you're crap loser."
                        + "\n Would you like to play again?"
                , "You Lost",
                JOptionPane.OK_OPTION );
        if (input == 0) {
            playAgain();
        } else {
            reset();
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

    private void listen() {
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
                    walletInputAction();
                }
            }
        };

        myWalletField.addKeyListener(newKeyAction);

        myRollButton.addActionListener(e -> rollButtonAction());
        myBetButton1.addActionListener(e -> betButtonAction(myBet1));
        myBetButton2.addActionListener(e -> betButtonAction(myBet2));
        myBetButton3.addActionListener(e -> betButtonAction(myBet3));
        myBetButton4.addActionListener(e -> betButtonAction(myBet4));
        myBetButton5.addActionListener(e -> betButtonAction(myBet5));
        myBetButton6.addActionListener(e -> betButtonAction(myBet6));
        startItem.addActionListener(e -> start());
        resetItem.addActionListener(e -> reset());
        playAgainItem.addActionListener(e -> playAgain());
        exitItem.addActionListener(e -> exit());
        aboutItem.addActionListener(e -> about());
        rulesItem.addActionListener(e -> rules());
        myPlayAgainButton.addActionListener(e -> playAgain());

    }

    private void start() {
        setWallet(getWallet());
        setEnableBetButtons(true);
        setWalletTextFieldEditable(true);
    }

    private void reset() {
        myRollField.setText(String.valueOf(0));
        setEnableBetButtons(false);
        setWalletTextFieldEditable(false);
        setEnableRollButton(false);
        startItem.setEnabled(true);
        resetGameData();
    }

    private void playAgain() {
        myRollField.setText(String.valueOf(0));
        setEnableBetButtons(true);
        setWalletTextFieldEditable(true);
        playAgainItem.setEnabled(false);
        myPlayAgainButton.setEnabled(false);
    }

    private void exit() {
        int input = JOptionPane.showConfirmDialog(
                new JFrame(),
                "It would stink if you left. " +
                "\nAre you sure that's what you want to do?",
                "DON'T LEAVE YOU IDIOT",
                JOptionPane.YES_OPTION,
                JOptionPane.NO_OPTION,
                myExitImageIcon);
        if (input == 0) {
            System.exit(0);
        }
    }

    private void about() {
        JOptionPane.showMessageDialog(
                new JFrame(),
                "Author: Caleb Krauter -> App version 1.0",
                "About",
                JOptionPane.DEFAULT_OPTION,
                myImageIcon);
    }

    private void rules() {
        JOptionPane.showMessageDialog(
                new JFrame(),
                "The rules of the Game of craps are as follows:\n" +
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
                JOptionPane.DEFAULT_OPTION,
                myImageIcon);
    }

    private void betButtonAction(int theBet) {
        updateWalletAfterBet(theBet);
        setEnableRollButton(true);
        setWalletTextFieldEditable(false);
            if (getWallet() < 0) {
                setWallet(0);
                setEnableBetButtons(false);
                int input = JOptionPane.showConfirmDialog(
                        new JFrame(),
                        "Don't bet more than you have... We took it all!"
                                + " \n Would you like to play again?");
                if (input == 0) {
                    playAgain();
                } else if (getWallet() == 0) {
                    setEnableRollButton(false);
                    setWalletTextFieldEditable(true);
                }

            }


    }

    private void rollButtonAction() {
        gameLogic.setWinValue(false);
        setMyRandomNum1();
        setMyRandomNum2();
        drawDice.setRandomNum1(getMyRandomRoll1());
        drawDice.setRandomNum2(getMyRandomRoll2());
        drawDice.repaint();
        drawDice.setBackground(myCenterPanelColor);
        setRollTotal();
        myRollField.setText(String.valueOf(getMyRollTotal()));
        gameLogic.scoreLogic();
        setPlayerWins();
        setHouseWins();
        setPlayerScore();
        myPlayerWinsField.setText(String.valueOf(getPlayerWins()));
        myHouseWinsField.setText(String.valueOf(getHouseWins()));
        myScoreField.setText(String.valueOf(getPlayerScore()));
        if (getWinValue()) {
            setWalletTextFieldEditable(true);
            updateWalletTextField();
            setEnableBetButtons(true);
            setEnableRollButton(false);
            playAgainItem.setEnabled(true);
            myPlayAgainButton.setEnabled(true);
            startItem.setEnabled(true);
        } else {
            setEnableBetButtons(false);
            playAgainItem.setEnabled(false);
            myPlayAgainButton.setEnabled(false);
            startItem.setEnabled(false);
        }
        if (getPlayerWon()) {
            youWonMessage();
        }
        if (getHouseWon()) {
            youLostMessage();
        }
    }
    private void walletInputAction() {
        if (!(myWalletField.getText().isBlank())) {
            try {
                if (Integer.parseInt(myWalletField.getText()) > 0) {
                    setWallet(Integer.parseInt(myWalletField.getText()));
                    setEnableBetButtons(true);
                } else {
                    setEnableBetButtons(false);
                }
            } catch (NumberFormatException exception) {

                badInputError();
                setEnableBetButtons(false);
                setWallet(1);
            }
        }
    }

    private void setWallet(int theCurrentCash) {
        gameLogic.setWallet(theCurrentCash);
        myWalletField.setText(String.valueOf(getWallet()));
    }

    public void setPlayerScore(int theScore) {
        gameLogic.setPlayerScore(theScore);
        myPlayerScore = gameLogic.getPlayerScore();
    }

    private void setEnableBetButtons(boolean theValue) {
        myBetButton1.setEnabled(theValue);
        myBetButton2.setEnabled(theValue);
        myBetButton3.setEnabled(theValue);
        myBetButton4.setEnabled(theValue);
        myBetButton5.setEnabled(theValue);
        myBetButton6.setEnabled(theValue);
        if (myBetButton1.isEnabled()) {
            myBetButtonEnabled = true;
        } else {
            myBetButtonEnabled = false;
        }
        getBetButtonsEnabled();
    }

    private void setEnableRollButton(boolean theValue) {
        myRollButton.setEnabled(theValue);
    }

    private void setWalletTextFieldEditable(boolean theValue) {
        myWalletField.setEditable(theValue);
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

    private void setRollTotal() {
        gameLogic.setRollTotal();
        myRollValue = gameLogic.getRollTotal();
        myRollField.setText(String.valueOf(getMyRollTotal()));

    }
    private void setRollTotalZero() {
        gameLogic.setRollTotalZero();
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

    private void updateWalletAfterBet(int theBet) {
        gameLogic.updateWalletAfterBet(theBet, getBetButtonsEnabled());
        myWalletField.setText(String.valueOf(getWallet()));
    }

    private void updateWalletTextField() {
        myWalletField.setText(String.valueOf(getWallet()));

    }

    private boolean getPlayerWon() {
        return gameLogic.getPlayerWon();
    }
    private boolean getHouseWon() {
        return gameLogic.getHouseWon();
    }
    private int getWallet() {
        return gameLogic.getWallet();
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

    private int getMyRandomRoll1() {
        return myRandomRoll1;
    }

    private int getMyRandomRoll2() {
        return myRandomRoll2;
    }

    private int getMyRollTotal() {
        return myRollValue;
    }

    private boolean getBetButtonsEnabled() {
        return myBetButtonEnabled;
    }

    private boolean getWinValue() {
        return gameLogic.getWinValue();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
