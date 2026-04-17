package org.example.Observer;

public class Client {
    public static void main(String[] args) {

        ObservableImpl observable = new ObservableImpl();

        ObserverImpl observer1 = new ObserverImpl("Vikas");
        ObserverImpl observer2 = new ObserverImpl("Ben");

        observer1.subscribe(observable);
        observer2.subscribe(observable);

        observable.addVideo("Observer Pattern");
    }
}