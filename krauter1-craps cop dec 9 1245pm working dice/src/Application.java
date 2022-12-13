import controller.CrapsController;
import model.*;

public class Application {

//    static int myPlayerTotal = 0;
    public static void main(String[] args) {
        CrapsController runGame = new CrapsController();
        runGame.loadGui();
    }

}