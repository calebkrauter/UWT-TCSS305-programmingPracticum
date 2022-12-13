import controller.CrapsController;
import model.*;

public class Application {

    public static void main(String[] args) {
        CrapsController runGame = new CrapsController();
        runGame.loadGui();
    }

}