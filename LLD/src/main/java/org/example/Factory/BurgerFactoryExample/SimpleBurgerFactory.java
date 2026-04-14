package org.example.Factory.BurgerFactoryExample;

public class SimpleBurgerFactory extends BurgerFactory{
    @Override
    public Burger getBurger() {
        return new BasicBurger();
    }
}
