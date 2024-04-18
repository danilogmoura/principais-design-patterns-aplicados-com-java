package com.github.danilogmoura.observer.subject;

import com.github.danilogmoura.observer.model.Order;
import com.github.danilogmoura.observer.observer.Observer;

import java.util.*;

public class OrderSystemNotifier implements Subject<Order> {

    private final Set<Observer> observers = new HashSet<>();

    private List<Order> orders = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(Observer::update);
    }

    @Override
    public void executeNotification(List<Order> orders) {
        this.orders = orders;
        notifyObserver();
    }

    @Override
    public List<Order> getItems() {
        return Collections.unmodifiableList(orders);
    }
}
