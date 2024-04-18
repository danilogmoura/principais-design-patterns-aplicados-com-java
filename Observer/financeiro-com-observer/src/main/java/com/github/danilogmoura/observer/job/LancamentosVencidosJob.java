package com.github.danilogmoura.observer.job;

import com.github.danilogmoura.observer.repository.Lancamentos;
import com.github.danilogmoura.observer.subject.Subject;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class LancamentosVencidosJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();

        var lancamentos = (Lancamentos) jobDataMap.get("lancamentos");
        var lancamentosVencidos = lancamentos.todosVencidos();

        var subject = (Subject) jobDataMap.get("subject");
        subject.executeNotification(lancamentosVencidos);
    }
}
