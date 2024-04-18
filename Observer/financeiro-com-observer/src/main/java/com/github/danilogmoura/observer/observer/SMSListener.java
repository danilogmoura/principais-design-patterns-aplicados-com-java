package com.github.danilogmoura.observer.observer;

import com.github.danilogmoura.observer.model.Lancamento;
import com.github.danilogmoura.observer.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SMSListener implements Observer {

    private static final Logger logger = LoggerFactory.getLogger(SMSListener.class);

    private final Subject subject;

    public SMSListener(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update() {
        for (Lancamento lancamento : subject.getLancamentosVencidos()) {
            logger.info("Enviando SMS para {}", lancamento.getPessoa().getTelefone());
        }
    }
}
