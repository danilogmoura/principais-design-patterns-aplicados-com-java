package com.github.danilogmoura.observer.subject;

import com.github.danilogmoura.observer.model.Lancamento;
import com.github.danilogmoura.observer.observer.Observer;

import java.util.List;

public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

    void executeNotification(List<Lancamento> lancamentosVencidos);

    List<Lancamento> getLancamentosVencidos();
}
