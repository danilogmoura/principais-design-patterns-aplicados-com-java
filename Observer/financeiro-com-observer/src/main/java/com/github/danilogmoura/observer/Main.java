package com.github.danilogmoura.observer;

import com.github.danilogmoura.observer.job.LancamentosVencidosJob;
import com.github.danilogmoura.observer.observer.EmailListener;
import com.github.danilogmoura.observer.observer.SMSListener;
import com.github.danilogmoura.observer.repository.Lancamentos;
import com.github.danilogmoura.observer.subject.LancamentodVencidosSubject;
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
        var lancamentos = new Lancamentos();
        var subject = new LancamentodVencidosSubject();

        new SMSListener(subject);
        new EmailListener(subject);

        JobDataMap jobDataMap = new JobDataMap();
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        jobDataMap.put("lancamentos", lancamentos);
        jobDataMap.put("subject", subject);

        JobDetail job = newJob(LancamentosVencidosJob.class)
            .setJobData(jobDataMap)
            .withIdentity("lancamentosVencidosJob", "lancamentosVencidosGroup")
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
