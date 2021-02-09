package com.example.HjwJames.packetCapture.service.impl;

import com.example.HjwJames.packetCapture.bean.CaptureData;
import com.example.HjwJames.packetCapture.bean.CssQuery;
import com.example.HjwJames.packetCapture.bean.ExceptionData;
import com.example.HjwJames.packetCapture.dao.CaptureDataDao;
import com.example.HjwJames.packetCapture.dao.ExceptionDataDao;
import com.example.HjwJames.packetCapture.enums.UrlEnums;
import com.example.HjwJames.packetCapture.service.CaptureDataService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 抓取数据录入表
 */
@Service
public class CaptureDataServiceImpl implements CaptureDataService {
    @Autowired
    CaptureDataDao captureDataDao;
    @Autowired
    ExceptionDataDao exceptionDataDao;
    @Override
    public void batchSaveCaptureData(List<CaptureData> captureData) {
        captureDataDao.insertOrUpdate_List(captureData);
    }

    @Override
    public void dateSupplyment(String url , CaptureData captureData) {
        if(UrlEnums.URLENUMSMAP.containsKey(url)){
            captureData.setSource(UrlEnums.URLENUMSMAP.get(url));
        }else{
            captureData.setSource(UrlEnums.URLENUMSMAP.get("UNKNOWN"));
        }
       /* if(captureData.getSource().equals("BILIBILI")){
            this.setDetailInformationForBilibili(captureData);
        }*/
    }

    /**
     * 进入url获取精确的数据
     * @param captureData
     */
    public void setDetailInformationForBilibili(CaptureData captureData){
        String url = captureData.getUrl();
        try{
            Thread.sleep(3000);
            Document document = Jsoup.connect(url).timeout(4000).userAgent("Mozilla").get();
            Elements elements = null;
            //递归出document里Item项目位置
            elements = document.select("div[class=l-con]");
            elements = elements.select("div[class=video-data]");
            //遍历item里需要输出的内容
            for(Element e : elements){
                //Elements ee= e.select("div[class=video-data]");
               String view = e.select("span[class=view]").attr("title");
               String dm = e.select("span[class=dm]").attr("title");
                String view1 = e.select("span[class=view]").text();
                String dm1 = e.select("span[class=dm]").text();
               /*if(!StringUtils.isEmpty(view)){
                   String token[] = view.split("数");
                   if(!StringUtils.isEmpty(token[1])){
                       captureData.setPlayTimes(new Double(token[1]));
                   }
               }
                if(!StringUtils.isEmpty(dm)){
                    String token[] = view.split("数");
                    if(!StringUtils.isEmpty(token[1])){
                        captureData.setBullet(new Double(token[1]));
                    }
                }*/
            }
        }catch (Exception e){
            //exceptionDataDao.insert(new ExceptionData(null,this.getClass().getName(),Thread.currentThread() .getStackTrace()[1].getMethodName(),null,e.toString(),null));
            e.printStackTrace();
        }
    }
}
