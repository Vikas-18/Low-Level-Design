package org.example.Observer;

public class ObserverImpl implements Observer {

    private String name;
    private ObservableImpl observable;

    public ObserverImpl(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(name + " got notification: New video released -> "
                + observable.getLatestVideo());
    }

    public void subscribe(ObservableImpl observable) {
        this.observable = observable;
        observable.add(this);
    }

    public void unsubscribe() {
        observable.remove(this);
    }

    public String getName() {
        return name;
    }
}