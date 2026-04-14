package org.example.Factory.BurgerFactoryExample;

public class BasicBurger extends Burger {
    @Override
    public void prepare() {
        System.out.println("Prepairing burger with sauce and bun and patty");
    }
}
