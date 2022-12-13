import controller.CrapsController;

public class Application {

//    static int myPlayerTotal = 0;
    public static void main(String[] args) {
        CrapsController runGame = new CrapsController();
        runGame.loadGui();
    }

}