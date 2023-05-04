package controller;

import model.GameLogic;
import view.CenterPanel;
import view.DicePanel;
import view.DrawDice;
import view.LeftPanel;
import view.RightPanel;
import view.TitlePanel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import static java.awt.event.KeyEvent.*;

/**
 * This controller object acts as an intermediary between the view and the model.
 * CrapsController listens for events, handles them, updates the model and view.
 * CrapsController handles the heavy lifting when it comes to communicating data.
 *
 * @author Caleb Krauter
 * @version 1.1
 */
public class CrapsController extends JPanel implements PropertyChangeListener {
    /**
     * myCount a String value used to initialize Jlabels.
     */
    private static String myCount = String.valueOf(0);
    /**
     * MUSIC a URL that represents the path to audio
     */
    private static final URL MUSIC = CrapsController.class.getResource("music.wav");
    /**
     * DICE_AUDIO a URL that represents the path to audio
     */
    private static final URL DICE_AUDIO = CrapsController.class.getResource("diceRoll.wav");
    /**
     * WIN_AUDIO a URL that represents the path to audio
     */
    private static final URL WIN_AUDIO = CrapsController.class.getResource("winAudio.wav");
    /**
     * LOSE_AUDIO a URL that represents the path to audio
     */
    private static final URL LOSE_AUDIO = CrapsController.class.getResource("loseAudio.wav");
    /**
     * BUTTON_AUDIO a URL that represents the path to audio
     */
    private static final URL BUTTON_AUDIO = CrapsController.class.getResource("buttonAudio.wav");
    /**
     * myRandomRoll1 an int that represents the value of a rolled die.
     */
    private int myRandomRoll1;
    /**
     * myRandomRoll2 an int that represents the value of a rolled die.
     */
    private int myRandomRoll2;
    /**
     * myPlayerWins an int that represents the number of wins that the player has.
     */
    private int myPlayerWins;
    /**
     * myHouseWins an int that represents the number of wins that the house has.
     */
    private int myHouseWins;
    /**
     * myPlayerScore an int that represents the temporary score that the player has.
     */
    private int myPlayerScore;
    /**
     * myRollValue the sum the points from two rolled dice.
     */
    private int myRollValue = 0;
    /**
     * BET_1 an int representing the amount of money that can be bet.
     */
    private static final int BET_1 = 1;
    /**
     * BET_2 an int representing the amount of money that can be bet.
     */
    private static final int BET_2 = 5;
    /**
     * BET_3 an int representing the amount of money that can be bet.
     */
    private static final int BET_3 = 10;
    /**
     *  BET_4 an int representing the amount of money that can be bet.
     */
    private static final int BET_4 = 50;
    /**
     * BET_5 an int representing the amount of money that can be bet.
     */
    private static final int BET_5 = 100;
    /**
     * BET_6 an int representing the amount of money that can be bet.
     */
    private static final int BET_6 = 500;

    /**
     * CENTER_PANEL_COLOR a Color value representing the color of a panel.
     */
    private static final Color CENTER_PANEL_COLOR = Color.decode("#FF8383");
    /**
     * LEFT_PANEL_COLOR a Color value representing the color of a panel.
     */
    private static final Color LEFT_PANEL_COLOR = Color.decode("#D9D8C0");
    /**
     * RIGHT_PANEL_COLOR a Color value representing the color of a panel.
     */
    private static final Color RIGHT_PANEL_COLOR = Color.decode("#97D0E3");
    /**
     * BACKGROUND_PANEL_COLOR a Color value representing the color of a panel.
     */
    private static final Color BACKGROUND_PANEL_COLOR = Color.decode("#B97A57");
    /**
     * drawDice an instance variable used to access an object where dice are drawn.
     */
    private DrawDice drawDice;
    /**
     * gameLogic an instance variable used to access an object where game logic is used.
     */
    private GameLogic gameLogic;
    /**
     * myRightPanel a JPanel used in the gui.
     */
    private final JPanel myRightPanel;
    /**
     * myLeftPanel a JPanel used in the gui.
     */
    private final JPanel myLeftPanel;
    /**
      myCenterPanel a JPanel used in the gui.
     */
    private final JPanel myCenterPanel;
    /**
     * myBackgroundPanel a JPanel used in the gui.
     */
    private final JPanel myBackgroundPanel;
    /**
     * dicePanel a DicePanel object used in the gui to house the dice.
     */
    private final DicePanel dicePanel;
    /**
     * centerPanel a CenterPanel object used in the gui.
     */
    private final CenterPanel centerPanel;
    /**
     *  leftPanel a LeftPanel object used in the gui.
     */
    private final LeftPanel leftPanel;
    /**
     *  rightPanel a RightPanel object used in the gui.
     */
    private final RightPanel rightPanel;
    /**
     * titlePanel a TitlePanel object used in the gui.
     */
    private final TitlePanel titlePanel;
    /**
     * POOPY_IMAGE_BANNER is a URL that gets used for a new ImageIcon.
     */
    private static final URL POOPY_IMAGE_BANNER = CrapsController.class.getResource("poopy.png");
    /**
     * POOPY_IMAGE_ICON is a URL that gets used for a new ImageIcon.
     */
    private static final URL POOPY_IMAGE_ICON = CrapsController.class.getResource("poopyIcon.png");
    /**
     * SAD_POOPY_IMAGE is a URL that gets used for a new ImageIcon.
     */
    private static final URL SAD_POOPY_IMAGE = CrapsController.class.getResource("poopyIconSad.png");
    /**
     * TITLE_IMAGE_LABEL is a JLabel used to house the title image.
     */
    private static final JLabel TITLE_IMAGE_LABEL = new JLabel(new ImageIcon(POOPY_IMAGE_BANNER));
    /**
     * PLAYER_WINS_LABEL player wins.
     */
    private static final JLabel PLAYER_WINS_LABEL = new JLabel("Player Wins: ");
    /**
     * HOUSE_WINS_LABEL house wins.
     */
    private static final JLabel HOUSE_WINS_LABEL = new JLabel("House Wins: ");
    /**
     * SCORE_LABEL score.
     */
    private static final JLabel SCORE_LABEL = new JLabel("Players Score: ");
    /**
     * SUM_LABEL total roll.
     */
    private static final JLabel SUM_LABEL = new JLabel("TOTAL: ");
    /**
     * WALLET_LABEL wallet.
     */
    private static final JLabel WALLET_LABEL = new JLabel("Wallet: ");
    /**
     * myPlayerWinsField text field to communicate wins.
     */
    private JTextField myPlayerWinsField = new JTextField(myCount);
    /**
     * myHouseWinsField text field to communicate wins.
     */
    private JTextField myHouseWinsField = new JTextField(myCount);
    /**
     * myScoreField text field to communicate score.
     */
    private JTextField myScoreField = new JTextField(myCount);
    /**
     * myRollField text field to communicate roll total.
     */
    private JTextField myRollField = new JTextField(String.valueOf(getMyRollTotal()));
    /**
     * myWalletField text field to communicate funds.
     */
    private JTextField myWalletField = new JTextField(String.valueOf(0));
    /**
     * myTitlePanelConstraints gridBagConstraints for positioning and size.
     */
    private GridBagConstraints myTitlePanelConstraints;
    /**
     * myDicePanelConstraints gridBagConstraints for positioning and size
     */
    private GridBagConstraints myDicePanelConstraints;
    /**
     * myLeftPanelConstraints gridBagConstraints for positioning and size
     */
    private GridBagConstraints myLeftPanelConstraints;
    /**
     * myRightPanelConstraints gridBagConstraints for positioning and size
     */
    private GridBagConstraints myRightPanelConstraints;
    /**
     * myCenterPanelConstraints gridBagConstraints for positioning and size
     */
    private GridBagConstraints myCenterPanelConstraints;
    /**
     * KIT used for getting info about screen size.
     */
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    /**
     * SCREEN_SIZE screen size.
     */
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
    /**
     * ROLL_BUTTON the roll button.
     */
    private static final JButton ROLL_BUTTON = new JButton("Roll");
    /**
     * myBetButton1 a bet button.
     */
    private final JButton myBetButton1 = new JButton(intToMoneyString(BET_1));
    /**
     * myBetButton2 a bet button.
     */
    private final JButton myBetButton2 = new JButton(intToMoneyString(BET_2));
    /**
     * myBetButton3 a bet button.
     */
    private final JButton myBetButton3 = new JButton(intToMoneyString(BET_3));
    /**
     * myBetButton4 a bet button.
     */
    private final JButton myBetButton4 = new JButton(intToMoneyString(BET_4));
    /**
     * myBetButton5 a bet button.
     */
    private final JButton myBetButton5 = new JButton(intToMoneyString(BET_5));
    /**
     * myBetButton6 a bet button.
     */
    private final JButton myBetButton6 = new JButton(intToMoneyString(BET_6));
    /**
     * myPlayAgainButton a play again button.
     */
    private final JButton myPlayAgainButton = new JButton("Play Again");
    /**
     * menuBar a menu bar.
     */
    private static JMenuBar menuBar = new JMenuBar();
    /**
     * gameMenu a menu.
     */
    private final JMenu gameMenu;
    /**
     * helpMenu a menu.
     */
    private final JMenu helpMenu;
    /**
     * startItem a menu item.
     */
    private final JMenuItem startItem;
    /**
     * resetItem a menu item.
     */
    private final JMenuItem resetItem;
    /**
     * playAgainItem a menu item.
     */
    private final JMenuItem playAgainItem;
    /**
     * exitItem a menu item.
     */
    private final JMenuItem exitItem;
    /**
     * rulesItem a menu item.
     */
    private final JMenuItem rulesItem;
    /**
     * aboutItem a menu item.
     */
    private final JMenuItem aboutItem;
    /**
     * myBetButtonEnabled check if bet buttons are enabled.
     */
    private static boolean myBetButtonEnabled = false;
    /**
     * myJFrame a JFrame.
     */
    private static JFrame myJFrame;

    /**
     * The constructor.
     */
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
                WALLET_LABEL,
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
                myPlayerWinsField,
                myHouseWinsField,
                myScoreField,
                PLAYER_WINS_LABEL,
                HOUSE_WINS_LABEL,
                SCORE_LABEL,
                SCREEN_SIZE, myPlayAgainButton);
        centerPanel = new CenterPanel(
                new GridBagLayout(),
                myBackgroundPanel,
                myCenterPanel,
                myCenterPanelConstraints,
                myRollField,
                SUM_LABEL,
                ROLL_BUTTON,
                SCREEN_SIZE);
        titlePanel = new TitlePanel(
                new GridBagLayout(),
                myBackgroundPanel,
                TITLE_IMAGE_LABEL,
                myTitlePanelConstraints,
                SCREEN_SIZE);

        //Set background colors
        myBackgroundPanel.setBackground(BACKGROUND_PANEL_COLOR);
        drawDice.setBackground(CENTER_PANEL_COLOR);
        myRightPanel.setBackground(RIGHT_PANEL_COLOR);
        myLeftPanel.setBackground(LEFT_PANEL_COLOR);
        myCenterPanel.setBackground(CENTER_PANEL_COLOR);
        rightPanel.setBackground(RIGHT_PANEL_COLOR);
        leftPanel.setBackground(LEFT_PANEL_COLOR);
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
                ROLL_BUTTON,
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

        try {
            playMusic();
        } catch (LineUnavailableException e) {
            audioError();
        } catch (IOException e) {
            audioError();
        } catch (UnsupportedAudioFileException e) {
            audioError();
        }

    }

    /**
     *
     * @param theText bet value to be converted to string.
     * @return string representation of integers as money.
     */
    private String intToMoneyString(int theText) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("$ ");
        stringBuilder.append(theText);
        return stringBuilder.toString();
    }

    /**
     * Adds menu components.
     */
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

    /**
     * Creates the first JOptionPane for entering money into your wallet/bank.
     */
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

    /**
     * Displays a JOptionPane for a bad value.
     */
    private void badInputError() {
        JOptionPane.showConfirmDialog(new JFrame(),
                "Error - There has been an error with the input that has been entered.",
                "ERROR",
                JOptionPane.DEFAULT_OPTION);
    }

    /**
     * Displays a JOptionPane for a player win.
     */
    private void youWonMessage() {
        try {
            playAudio(WIN_AUDIO);
        } catch (LineUnavailableException e) {
            audioError();
        } catch (IOException e) {
            audioError();
        } catch (UnsupportedAudioFileException e) {
            audioError();
        }
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

    /**
     * Displays a JOptionPane for a player loss.
     */
    private void youLostMessage() {
        try {
            playAudio(LOSE_AUDIO);
        } catch (LineUnavailableException e) {
            audioError();
        } catch (IOException e) {
            audioError();
        } catch (UnsupportedAudioFileException e) {
            audioError();
        }
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

    /**
     * Loads gui.
     */
    void loadGui() {
        myJFrame.setLocation(SCREEN_SIZE.width / 2 - myJFrame.getWidth() / 2,
                SCREEN_SIZE.height / 2 - myJFrame.getHeight() / 2);
        myJFrame.pack();
        myJFrame.setDefaultCloseOperation(myJFrame.EXIT_ON_CLOSE);
        myJFrame.setSize(850, 850);
        myJFrame.setMinimumSize(new Dimension(750, 750));
        myJFrame.add(myBackgroundPanel);
        myJFrame.setIconImage(new ImageIcon(POOPY_IMAGE_ICON).getImage());
        myJFrame.setJMenuBar(menuBar);
        myJFrame.setVisible(true);

    }

    /**
     * Listens for input and handles events.
     */
    private void listen() {
        final KeyListener newKeyAction = new KeyListener() {

            /**
             * A method required to be overridden.
             */
            @Override
            public void keyTyped(KeyEvent e) {

            }

            /**
             * A method required to be overridden.
             */
            @Override
            public void keyPressed(KeyEvent e) {

            }

            /**
             * Listens for a released key in the wallet
             * text field.
             */
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getSource().equals(myWalletField)) {
                    walletInputAction();
                }
            }
        };

        myWalletField.addKeyListener(newKeyAction);

        ROLL_BUTTON.addActionListener(e -> rollButtonAction());
        myBetButton1.addActionListener(e -> betButtonAction(BET_1));
        myBetButton2.addActionListener(e -> betButtonAction(BET_2));
        myBetButton3.addActionListener(e -> betButtonAction(BET_3));
        myBetButton4.addActionListener(e -> betButtonAction(BET_4));
        myBetButton5.addActionListener(e -> betButtonAction(BET_5));
        myBetButton6.addActionListener(e -> betButtonAction(BET_6));
        startItem.addActionListener(e -> {
            start();
        });
        resetItem.addActionListener(e -> reset());
        playAgainItem.addActionListener(e -> playAgain());
        exitItem.addActionListener(e -> exit());
        aboutItem.addActionListener(e -> about());
        rulesItem.addActionListener(e -> rules());
        myPlayAgainButton.addActionListener(e -> playAgain());

    }

    /**
     * Action for start item.
     */
    private void start() {
        setWallet(getWallet());
        setEnableBetButtons(true);
        setWalletTextFieldEditable(true);

        try {
            playAudio(BUTTON_AUDIO);
        } catch (LineUnavailableException e) {
            audioError();
        } catch (IOException e) {
            audioError();
        } catch (UnsupportedAudioFileException e) {
            audioError();
        }
    }

    /**
     * Action for reset item.
     */
    private void reset() {
        try {
            playAudio(BUTTON_AUDIO);
        } catch (LineUnavailableException e) {
            audioError();
        } catch (IOException e) {
            audioError();
        } catch (UnsupportedAudioFileException e) {
            audioError();
        }
        myRollField.setText(String.valueOf(0));
        setEnableBetButtons(false);
        setWalletTextFieldEditable(false);
        setEnableRollButton(false);
        startItem.setEnabled(true);
        resetGameData();
    }

    /**
     * Action for playAgain item and button.
     */
    private void playAgain() {
        try {
            playAudio(BUTTON_AUDIO);
        } catch (LineUnavailableException e) {
            audioError();
        } catch (IOException e) {
            audioError();
        } catch (UnsupportedAudioFileException e) {
            audioError();
        }
        myRollField.setText(String.valueOf(0));
        setEnableBetButtons(true);
        setWalletTextFieldEditable(true);
        playAgainItem.setEnabled(false);
        myPlayAgainButton.setEnabled(false);
    }

    /**
     * Action for exit item.
     */
    private void exit() {
        try {
            playAudio(BUTTON_AUDIO);
        } catch (LineUnavailableException e) {
            audioError();
        } catch (IOException e) {
            audioError();
        } catch (UnsupportedAudioFileException e) {
            audioError();
        }
        int input = JOptionPane.showConfirmDialog(
                new JFrame(),
                "It would stink if you left. " +
                        "\nAre you sure that's what you want to do?",
                "DON'T LEAVE YOU IDIOT",
                JOptionPane.YES_OPTION,
                JOptionPane.NO_OPTION,
                new ImageIcon(SAD_POOPY_IMAGE));
        if (input == 0) {
            System.exit(0);
        }
    }

    /**
     * Action for about item.
     */
    private void about() {
        try {
            playAudio(BUTTON_AUDIO);
        } catch (LineUnavailableException e) {
            audioError();
        } catch (IOException e) {
            audioError();
        } catch (UnsupportedAudioFileException e) {
            audioError();
        }
        JOptionPane.showMessageDialog(
                new JFrame(),
                "Author: Caleb Krauter -> Game version 1.1",
                "About",
                JOptionPane.DEFAULT_OPTION,
                new ImageIcon(POOPY_IMAGE_ICON));
    }

    /**
     * Action for rules item.
     */
    private void rules() {
        try {
            playAudio(BUTTON_AUDIO);
        } catch (LineUnavailableException e) {
            audioError();
        } catch (IOException e) {
            audioError();
        } catch (UnsupportedAudioFileException e) {
            audioError();
        }
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
                new ImageIcon(POOPY_IMAGE_ICON));
    }

    /**
     * Action for bet buttons.
     */
    private void betButtonAction(int theBet) {
        try {
            playAudio(BUTTON_AUDIO);
        } catch (LineUnavailableException e) {
            audioError();
        } catch (IOException e) {
            audioError();
        } catch (UnsupportedAudioFileException e) {
            audioError();
        }
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

    /**
     * Action for roll button.
     */
    private void rollButtonAction() {
        try {
            playAudio(DICE_AUDIO);
            playAudio(BUTTON_AUDIO);
        } catch (LineUnavailableException e) {
            audioError();
        } catch (IOException e) {
            audioError();
        } catch (UnsupportedAudioFileException e) {
            audioError();
        }

        gameLogic.setWinValue(false);
        setMyRandomNum1();
        setMyRandomNum2();
        drawDice.setRandomNum1(getMyRandomRoll1());
        drawDice.setRandomNum2(getMyRandomRoll2());
        drawDice.repaint();
        drawDice.setBackground(CENTER_PANEL_COLOR);
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

    /**
     * Action for wallet text field input.
     */
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

    /**
     * JOptionPane for audio error.
     */
    private void audioError() {
        JOptionPane.showConfirmDialog(new JFrame(), "Audio Error. Game Shutting Down.");
        System.exit(0);
    }

    /**
     * Plays music.
     * @throws LineUnavailableException
     * @throws IOException
     * @throws UnsupportedAudioFileException
     */
    private void playMusic() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(MUSIC);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }

    /**
     * Plays audio clips.
     * @param theAudio
     * @throws LineUnavailableException
     * @throws IOException
     * @throws UnsupportedAudioFileException
     */
    private void playAudio(URL theAudio) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(theAudio);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }

    /**
     * Sets wallet with a passed in value.
     * @param theCurrentCash
     */
    private void setWallet(int theCurrentCash) {
        gameLogic.setWallet(theCurrentCash);
        myWalletField.setText(String.valueOf(getWallet()));
    }

    /**
     * Sets the score with passed in value.
     * @param theScore
     */
    private void setPlayerScore(int theScore) {
        gameLogic.setPlayerScore(theScore);
        myPlayerScore = gameLogic.getPlayerScore();
    }

    /**
     * Sets bet buttons as enabled or disabled.
     * @param theValue
     */
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

    /**
     * Enables and disables the roll button.
     * @param theValue
     */
    private void setEnableRollButton(boolean theValue) {
        ROLL_BUTTON.setEnabled(theValue);
    }

    /**
     * Enables and disables the ability to edit the wallet text field..
     * @param theValue
     */
    private void setWalletTextFieldEditable(boolean theValue) {
        myWalletField.setEditable(theValue);
    }

    /**
     * Sets player wins.
     */
    private void setPlayerWins() {
        myPlayerWins = gameLogic.getPlayerWins();
    }

    /**
     * Sets house wins.
     */
    private void setHouseWins() {
        myHouseWins = gameLogic.getHouseWins();
    }

    /**
     * Sets score.
     */
    private void setPlayerScore() {
        myPlayerScore = gameLogic.getPlayerScore();
    }

    /**
     * Sets a random number for a die.
     */
    private void setMyRandomNum1() {
        gameLogic.setMyRandomRoll1();
        myRandomRoll1 = gameLogic.getRandomRoll1();
        drawDice.setRandomNum1(myRandomRoll1);
    }

    /**
     * Sets a random number for a die.
     */
    private void setMyRandomNum2() {
        gameLogic.setMyRandomRoll2();
        myRandomRoll2 = gameLogic.getRandomRoll2();
        drawDice.setRandomNum2(myRandomRoll2);
    }

    /**
     * Sets a roll total.
     */
    private void setRollTotal() {
        gameLogic.setRollTotal();
        myRollValue = gameLogic.getRollTotal();
        myRollField.setText(String.valueOf(getMyRollTotal()));

    }

    /**
     * Resets game data.
     */
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

    /**
     * Updates the wallet and corrisponding text field and uses the passed in bet.
     * @param theBet
     */
    private void updateWalletAfterBet(int theBet) {
        gameLogic.updateWalletAfterBet(theBet, getBetButtonsEnabled());
        myWalletField.setText(String.valueOf(getWallet()));
    }

    /**
     * Updates the wallet text field.
     */
    private void updateWalletTextField() {
        myWalletField.setText(String.valueOf(getWallet()));

    }

    /**
     * Gets boolean value for if the player won.
     * @return boolean
     */
    private boolean getPlayerWon() {
        return gameLogic.getPlayerWon();
    }

    /**
     * Gets boolean value for if the house won.
     * @return boolean
     */
    private boolean getHouseWon() {
        return gameLogic.getHouseWon();
    }

    /**
     * Gets int value for the wallet.
     * @return cash in wallet
     */
    private int getWallet() {
        return gameLogic.getWallet();
    }

    /**
     * Gets player wins.
     * @return int value of wins.
     */
    private int getPlayerWins() {
        return myPlayerWins;
    }

    /**
     * Gets house wins.
     * @return int value of wins.
     */
    private int getHouseWins() {
        return myHouseWins;
    }

    /**
     * Gets player score.
     * @return int value of score.
     */
    private int getPlayerScore() {
        return myPlayerScore;
    }

    /**
     * Gets a die roll.
     * @return int value of roll.
     */
    private int getMyRandomRoll1() {
        return myRandomRoll1;
    }

    /**
     * Gets a die roll.
     * @return int value of roll.
     */
    private int getMyRandomRoll2() {
        return myRandomRoll2;
    }

    /**
     * Gets a roll total.
     * @return int value for roll total.
     */
    private int getMyRollTotal() {
        return myRollValue;
    }

    /**
     * Returns a boolean value for bet buttons to communicate if they are enabled or disabled.
     * @return a boolean value.
     */
    private boolean getBetButtonsEnabled() {
        return myBetButtonEnabled;
    }

    /**
     * Gets any possible win.
     * @return a boolean to communicate if the player or house won.
     */
    private boolean getWinValue() {
        return gameLogic.getWinValue();
    }

    /**
     * A method required to be overridden.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
