package org.example.Singleton;

public class Client {
    public static void main(String[] args){
        SingletonClass singletonClass = SingletonClass.getInstance();
        SingletonClass singletonClass1 = SingletonClass.getInstance();
    }
}
