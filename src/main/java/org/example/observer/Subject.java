package org.example.observer;

public interface Subject {
    void registerObserver(Observer observer);
    void notifyObservers(Observer observer);
}
