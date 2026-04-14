package org.example.Factory.BurgerFactoryExample;

public class PremiumBurger extends Burger {
    @Override
    public void prepare() {
        System.out.println("Prepairing burger with premium bun and mustard sauce and cheessee patty");
    }
}
