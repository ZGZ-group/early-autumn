package com.earlyautumn.ruaiter.config;

import com.earlyautumn.ruaiter.config.job.TestQuartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class QuartzConfigurer {

    private static final String JOB_NAME = "testQuartz";

    @Bean
    public JobDetail jobDetail() {
        JobBuilder jobBuilder = JobBuilder.newJob(TestQuartz.class);
        jobBuilder.withIdentity(JOB_NAME);
        return jobBuilder.storeDurably().build();
    }


    @Bean
    public Trigger trigger(JobDetail jobDetail) {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");

        TriggerBuilder<Trigger> triggerTriggerBuilder = TriggerBuilder.newTrigger();
        triggerTriggerBuilder.forJob(jobDetail);
        triggerTriggerBuilder.withIdentity(JOB_NAME);
        triggerTriggerBuilder.withSchedule(scheduleBuilder);

        return triggerTriggerBuilder.build();
    }

}
