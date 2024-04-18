package com.github.danilogmoura.observer.subject;

import com.github.danilogmoura.observer.observer.Observer;

import java.util.List;

public interface Subject<T> {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();

    void executeNotification(List<T> items);

    List<T> getItems();
}
