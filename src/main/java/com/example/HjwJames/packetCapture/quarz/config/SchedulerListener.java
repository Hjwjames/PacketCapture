//package com.example.HjwJames.packetCapture.quarz.config;
//
//import com.example.HjwJames.packetCapture.quarz.schedule.CronSchedulerJob;
//import org.quartz.SchedulerException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//定时启动
//@Configuration
//@EnableScheduling
//@Component
//public class SchedulerListener {
//
//    @Autowired
//    public CronSchedulerJob scheduleJobs;
//
//    @Scheduled(cron="0 47 16 24 1 ?")
//    public void schedule() throws SchedulerException {
//        scheduleJobs.scheduleJobs();
//        System.out.println(">>>>>>>>>>>>>>>定时任务开始执行<<<<<<<<<<<<<");
//    }
//
//}