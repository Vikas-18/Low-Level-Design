package org.example.Factory.BurgerFactoryExample;

public class PremiumBurgerFactory extends BurgerFactory{
    @Override
    public Burger getBurger() {
        return new PremiumBurger();
    }
}
