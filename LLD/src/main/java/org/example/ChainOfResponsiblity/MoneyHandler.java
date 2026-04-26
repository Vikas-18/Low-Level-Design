package org.example.ChainOfResponsiblity;

public abstract class MoneyHandler {
    MoneyHandler nextHandler;

    MoneyHandler(){
        this.nextHandler = null;
    }

    void setNextHandler(MoneyHandler nextHandler)
    {
        this.nextHandler = nextHandler;
    }

    public abstract void dispense(int amount);
}
