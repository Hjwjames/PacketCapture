package com.example.HjwJames.packetCapture.quarz.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName SchedulerFactory
 * @Description quarz的job不属于spring容器内部资源，把job注册入容器内
 * @Author lg
 * @Date
 * @Version 1.0
 **/
@Component
public class SchedulerFactory extends AdaptableJobFactory {
    //spring bean 对象管理工厂
    @Autowired
    private AutowireCapableBeanFactory capableBeanFactory;
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        //调用父类的方法
        Object jobInstance = super.createJobInstance(bundle);
        //自动注入
        capableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
