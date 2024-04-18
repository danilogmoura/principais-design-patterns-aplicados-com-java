package com.github.danilogmoura.observer.job;


import com.github.danilogmoura.observer.repository.order.OrderRepositoryImpl;
import com.github.danilogmoura.observer.subject.Subject;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;

public class OrderNotifier implements Job {

    @Override
    @SuppressWarnings("unchecked")
    public void execute(JobExecutionContext context) {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();

        var onders = (OrderRepositoryImpl) jobDataMap.get("orderRepository");
        var lancamentosVencidos = onders.findAll();

        var subject = (Subject) jobDataMap.get("orderSystemNotifier");
        subject.executeNotification(lancamentosVencidos);
    }
}
