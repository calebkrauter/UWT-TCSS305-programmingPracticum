package controller;

public class Application {

    public static void main(String[] args) {
        CrapsController runGame = new CrapsController();
        runGame.loadGui();
    }

}

/*
public void updateWallet(theBet) {
    myPool += thebet;
    if(myBetAmountButton1.isEditable == false) {
        setPool(myPool)
    }
    if(playerWon) {
        setWallet(myCurrentCash + getPool())
    }
}

public void setWallet(theCash) {
    myCurrentCash = theCash;
}

public void setPool(thePool) {
    myPool = thePool;
}
public void getWallet() {
    return myCurrentCash;
}
public int getPool() {
    return myPool;
}
 */