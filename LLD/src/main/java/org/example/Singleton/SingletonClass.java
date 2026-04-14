package org.example.Singleton;

import java.util.Objects;

public class SingletonClass {
    private static SingletonClass singletonClass;

    private SingletonClass()
    {
        System.out.println("Hii i am created for the 1st time");
    }
    public static SingletonClass getInstance()
    {
        return Objects.requireNonNullElseGet(singletonClass, SingletonClass::new);
    }



}
