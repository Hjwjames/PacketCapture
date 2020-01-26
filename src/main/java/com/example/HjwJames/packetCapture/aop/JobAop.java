package com.example.HjwJames.packetCapture.aop;

import com.example.HjwJames.packetCapture.bean.AopData;
import com.example.HjwJames.packetCapture.dao.AopDataDao;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JobAop {

    @Autowired
    AopDataDao aopDataDao;

    //配置切点
    @Pointcut("execution(* com.example.HjwJames.packetCapture.quarz.job.BilibiliJob.execute(..))")
    public void log() {
    }
    //配置切点
    @Pointcut("execution(* com.example.HjwJames.packetCapture.quarz.job.HelloJob.execute(..))")
    public void log2() {
    }

    @Before(value ="execution(* com.example.HjwJames.packetCapture.service.PacketCaptureService.capture(..))")  //前置通知
    public void beforeExecution(JoinPoint joinPoint) {
        String description = joinPoint.getArgs()[0].toString();
        aopDataDao.insert(new AopData(null,joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName(),description,null));
    }


}
