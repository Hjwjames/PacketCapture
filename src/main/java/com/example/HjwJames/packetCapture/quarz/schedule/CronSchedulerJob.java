package com.example.HjwJames.packetCapture.quarz.schedule;
import com.example.HjwJames.packetCapture.quarz.job.BilibiliJob;
import com.example.HjwJames.packetCapture.quarz.job.HelloJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class CronSchedulerJob {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    private void scheduleJob1(Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class) .withIdentity("job1", "group1").build();
        // 2秒执行一次
        //CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/2 * * * * ?");
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0 0/5 * * ? *");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .usingJobData("name","helloword").withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }

    private void scheduleJob2(Scheduler scheduler) throws SchedulerException{
        JobDetail jobDetail = JobBuilder.newJob(BilibiliJob.class) .withIdentity("job2", "group2").build();
        // 每5小时执行一次
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0 0/5 * * ? *");
        //CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/20 * * * * ? *");
        //CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0/30 * * * ? ");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group2")
                .usingJobData("name","Bilibili").withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }

    /**
     * @Author HjwJames
     * @Description 同时启动两个定时任务
     * @Date 16:31 2019/1/24
     * @Param
     * @return void
     **/
    public void scheduleJobs() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        //scheduleJob1(scheduler);
        scheduleJob2(scheduler);
    }
}
