package org.example.Observer;

import java.util.ArrayList;
import java.util.List;

public class ObservableImpl implements Observable {

    List<Observer> observers = new ArrayList<>();
    List<String> videos = new ArrayList<>();

    @Override
    public void add(Observer ob) {
        observers.add(ob);
        System.out.println("New subscriber added");
    }

    @Override
    public void remove(Observer ob) {
        observers.remove(ob);
        System.out.println("Subscriber removed");
    }

    @Override
    public void notifySubscribers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void addVideo(String title) {
        videos.add(title);
        System.out.println("New video " + title + " added");
        notifySubscribers();
    }

    public String getLatestVideo() {
        return videos.get(videos.size() - 1);
    }
}