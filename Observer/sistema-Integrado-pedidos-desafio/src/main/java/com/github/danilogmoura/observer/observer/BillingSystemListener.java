package com.github.danilogmoura.observer.observer;

import com.github.danilogmoura.observer.model.Order;
import com.github.danilogmoura.observer.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BillingSystemListener implements Observer {

    private static final Logger logger = LoggerFactory.getLogger(BillingSystemListener.class);
    private final Subject subject;

    public BillingSystemListener(Subject subject) {
        subject.registerObserver(this);
        this.subject = subject;
    }

    @Override
    public void update() {
        for (var order : subject.getItems()) {
            logger.info("[Billing System Notifier] Order {}, {}", ((Order) order).getDescription(),
                ((Order) order).getPrice());
        }
    }
}
