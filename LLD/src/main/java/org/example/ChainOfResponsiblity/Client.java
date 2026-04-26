package org.example.ChainOfResponsiblity;

public class Client {
    public static void main(String[] args) {
        ThousandHandler thousandHandler = new ThousandHandler(10);
        FiveHunderedHandler fiveHunderedHandler = new FiveHunderedHandler(5);
        HundredHandler hundredHandler = new HundredHandler(20);

        thousandHandler.setNextHandler(fiveHunderedHandler);
        fiveHunderedHandler.setNextHandler(hundredHandler);

        int moneyToWithdraw = 5650;
        thousandHandler.dispense(moneyToWithdraw);
    }
}
