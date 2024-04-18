package com.github.danilogmoura.observer.observer;

import com.github.danilogmoura.observer.model.Order;
import com.github.danilogmoura.observer.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TruckReservationSystemLister implements Observer {

    private static final Logger logger = LoggerFactory.getLogger(TruckReservationSystemLister.class);

    private final Subject subject;

    public TruckReservationSystemLister(Subject subject) {
        subject.registerObserver(this);
        this.subject = subject;
    }

    @Override
    public void update() {
        for (var order : subject.getItems()) {
            logger.info("[Reserving truk] Order {}, R${}", ((Order) order).getDescription(),
                ((Order) order).getPrice());
        }
    }
}
