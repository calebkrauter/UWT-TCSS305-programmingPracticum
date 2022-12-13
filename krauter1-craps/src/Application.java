import controller.CrapsController;
import model.*;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        CrapsController runGame = new CrapsController();
        runGame.loadGui();
    }

}