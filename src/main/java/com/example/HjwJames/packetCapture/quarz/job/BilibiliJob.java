package com.example.HjwJames.packetCapture.quarz.job;

import com.example.HjwJames.packetCapture.bean.CssQuery;
import com.example.HjwJames.packetCapture.bean.ExceptionData;
import com.example.HjwJames.packetCapture.dao.ExceptionDataDao;
import com.example.HjwJames.packetCapture.service.PacketCaptureService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BilibiliJob implements Job {
    @Autowired
    PacketCaptureService packetCaptureService;
    @Autowired
    ExceptionDataDao exceptionDataDao;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try{
            bilibili("30");
            bilibili("7");
            bilibili("3");
            System.out.println("BilibiliJob执行抓包：" + LocalDateTime.now());
        }catch (Exception e){
            exceptionDataDao.insert(new ExceptionData(null,this.getClass().getName(),Thread.currentThread() .getStackTrace()[1].getMethodName(),null,e.toString(),null));
            throw e;
        }

    }
    public void bilibili(String days){
        //找到item
        List<CssQuery> itemList = new ArrayList<>();
        itemList.add(new CssQuery("div","rank-list-wrap","",""));
        itemList.add(new CssQuery("ul","rank-list","",""));
        itemList.add(new CssQuery("li","rank-item","",""));
        //找到item里详情
        List<CssQuery> itemDetailList = new ArrayList<>();
        itemDetailList.add(new CssQuery("div","content","",""));
        itemDetailList.add(new CssQuery("div","info","",""));
        String url = "https://www.bilibili.com/ranking/all/0/0/"+days;
        //找到详情里要输出的元素
        List<CssQuery> resultList = new ArrayList<>();
        resultList.add(new CssQuery("a","title","text","TITLE"));
        resultList.add(new CssQuery("a","title","href","URL"));
        resultList.add(new CssQuery("div","pts","text","POINTS"));
        resultList.add(new CssQuery("i","b-icon play","i","PLAY_TIMES"));
        resultList.add(new CssQuery("i","b-icon view","i","BULLET"));
        resultList.add(new CssQuery("i","b-icon author","i","UPLOADER"));
        packetCaptureService.capture(url,itemList,itemDetailList,resultList);
    }
}
