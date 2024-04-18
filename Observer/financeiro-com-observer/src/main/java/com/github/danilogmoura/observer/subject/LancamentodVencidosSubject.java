package com.github.danilogmoura.observer.subject;

import com.github.danilogmoura.observer.model.Lancamento;
import com.github.danilogmoura.observer.observer.Observer;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LancamentodVencidosSubject implements Subject {

    private final Set<Observer> observers = new HashSet<>();
    private List<Lancamento> lancamentosVencidos;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }

    @Override
    public void executeNotification(List<Lancamento> lancamentosVencidos) {
        this.lancamentosVencidos = lancamentosVencidos;
        notifyObservers();
    }

    @Override
    public List<Lancamento> getLancamentosVencidos() {
        return Collections.unmodifiableList(lancamentosVencidos);
    }
}
