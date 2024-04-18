package com.github.danilogmoura.observer.job;

import com.github.danilogmoura.observer.model.Lancamento;
import com.github.danilogmoura.observer.repository.Lancamentos;
import com.github.danilogmoura.observer.senders.EnviadorEmail;
import com.github.danilogmoura.observer.senders.EnviadorSMS;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.List;

public class LancamentosVencidosJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();

        Lancamentos lancamentos = (Lancamentos) jobDataMap.get("lancamentos");
        List<Lancamento> lancamentosVencidos = lancamentos.todosVencidos();

        EnviadorEmail enviadorEmail = (EnviadorEmail) jobDataMap.get("enviadorEmail");
        EnviadorSMS enviadorSms = (EnviadorSMS) jobDataMap.get("enviadorSms");
        enviadorEmail.enviar(lancamentosVencidos);
        enviadorSms.enviar(lancamentosVencidos);
    }
}
