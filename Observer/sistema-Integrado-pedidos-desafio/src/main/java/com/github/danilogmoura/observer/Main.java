package com.github.danilogmoura.observer;

import com.github.danilogmoura.observer.job.OrderNotifier;
import com.github.danilogmoura.observer.observer.BillingSystemListener;
import com.github.danilogmoura.observer.observer.TruckReservationSystemLister;
import com.github.danilogmoura.observer.repository.order.OrderRepositoryImpl;
import com.github.danilogmoura.observer.subject.OrderSystemNotifier;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class Main {
    public static void main(String[] args) throws Exception {
        var orderSystemNotifier = new OrderSystemNotifier();

        new BillingSystemListener(orderSystemNotifier);
        new TruckReservationSystemLister(orderSystemNotifier);

        var orderRepository = new OrderRepositoryImpl();

        JobDataMap jobDataMap = new JobDataMap();
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        jobDataMap.put("orderSystemNotifier", orderSystemNotifier);
        jobDataMap.put("orderRepository", orderRepository);

        JobDetail job = newJob(OrderNotifier.class)
            .setJobData(jobDataMap)
            .withIdentity("orderSystemNotifierJob", "orderSystemNotifierGroup")
            .build();

        CronTrigger trigger = newTrigger()
            .withIdentity("trigger1", "group1")
            .withSchedule(cronSchedule("0 * * * * ?"))
            .build();

        scheduler.scheduleJob(job, trigger);
        scheduler.start();
        Thread.sleep(220000);
        scheduler.shutdown(true);
    }
}
