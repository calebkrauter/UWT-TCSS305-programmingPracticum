package controller;

/**
 * This class starts the Game of Craps.
 * @author Caleb Krauter
 * @version 1.0
 */
public class Application {

    /**
     * Starts the program and loads the gui.
     * @param args
     */
    public static void main(String[] args) {
        CrapsController runGame = new CrapsController();
        runGame.loadGui();
    }

}

