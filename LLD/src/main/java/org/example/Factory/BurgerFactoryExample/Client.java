package org.example.Factory.BurgerFactoryExample;

public class Client {
    public static void main(String[] args) {
        BurgerFactory burgerFactory = new SimpleBurgerFactory();
        Burger burger = burgerFactory.getBurger();
        burger.prepare();
    }
}
