package com.epam.dhontar.aqamp.observer;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private List messages = new ArrayList<>();
    private List<ChatObserver> observers = new ArrayList<>();

    public void addObserver(ChatObserver observer) {
        observers.add(observer);
    }

    public void addMessage(String message) {
        messages.add(message);
        notifyObservers(message);
    }

    private void notifyObservers(String message) {
        for (ChatObserver observer : observers) {
            observer.update(message);
        }
    }
}
