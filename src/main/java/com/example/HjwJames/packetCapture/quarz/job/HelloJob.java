package com.example.HjwJames.packetCapture.quarz.job;

import com.example.HjwJames.packetCapture.bean.ExceptionData;
import com.example.HjwJames.packetCapture.dao.ExceptionDataDao;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class HelloJob implements Job {
    @Autowired
    ExceptionDataDao exceptionDataDao;
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            System.out.println("Hello执行：" + LocalDateTime.now());
        }catch (Exception e){
            exceptionDataDao.insert(new ExceptionData(null,this.getClass().getName(),Thread.currentThread() .getStackTrace()[1].getMethodName(),null,e.toString(),null));
            throw e;
        }


    }
}
