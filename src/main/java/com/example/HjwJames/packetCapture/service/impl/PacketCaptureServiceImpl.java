package com.example.HjwJames.packetCapture.service.impl;

import com.example.HjwJames.packetCapture.bean.CaptureData;
import com.example.HjwJames.packetCapture.bean.CssQuery;
import com.example.HjwJames.packetCapture.bean.ExceptionData;
import com.example.HjwJames.packetCapture.dao.ExceptionDataDao;
import com.example.HjwJames.packetCapture.service.CaptureDataService;
import com.example.HjwJames.packetCapture.service.PacketCaptureService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacketCaptureServiceImpl implements PacketCaptureService {
    @Autowired
    CaptureDataService captureDataService;
    @Autowired
    ExceptionDataDao exceptionDataDao;
    /**
     * 主算法
     * @param url
     * @param itemList
     * @param itemDetailList
     * @param resultList
     * @return
     */
    public String capture(String url, List<CssQuery> itemList,List<CssQuery> itemDetailList,List<CssQuery> resultList){
        String result ="<h1>Capture from "+url+"</h1></br>";
        try{
            Document document = Jsoup.connect(url).timeout(4000).userAgent("Mozilla").get();
            Elements elements = null;
            List<CaptureData> captureDatalist = new ArrayList<>();
            //递归出document里Item项目位置
            for(CssQuery cssQuery : itemList){
                elements = getHtmlElements(document,cssQuery,elements);
            }
            //遍历item里需要输出的内容
            for(Element e : elements){
                CaptureData captureData = new CaptureData();
                //获取item详情定位
                Elements innerElements = selectElement(itemDetailList,e);
                //获取结果集合并保存在captureData中
                getResult(resultList,innerElements,captureData);
                //录入数据库
                captureDataService.dateSupplyment(url,captureData);
                captureDatalist.add(captureData);
                //输出详情
                result += captureData.toString();
                result += "--------------------------------------------------------------------------</br>";
            }
            captureDataService.batchSaveCaptureData(captureDatalist);
        }catch (Exception e){
            exceptionDataDao.insert(new ExceptionData(null,this.getClass().getName(),Thread.currentThread() .getStackTrace()[1].getMethodName(),null,e.toString(),null));
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 遍历出document里Item项目
     * @param document
     * @param cssQuery
     * @param elements
     * @return
     */
    public Elements getHtmlElements(Document document , CssQuery cssQuery, Elements elements){
        String queryText = getCssQueryText(cssQuery);
        if(null == elements){
            return document.select(queryText);
        }else{
            for(Element e : elements){
                return e.select(queryText);
            }
        }
        return null;
    }
    /**
     * pojo转换成querytext
     * @param cssQuery
     * @return
     */
    public String getCssQueryText(CssQuery cssQuery){
        String css = "";
        if(cssQuery.getClassName().isEmpty()){
            css = cssQuery.getElement();
        }else{
            css = cssQuery.getElement()+"[class="+cssQuery.getClassName()+"]";
        }

        return css;
    }
    /**
     * //递归获取item详情定位
     * @param resultList
     * @param element
     * @return
     */
    public Elements selectElement(List<CssQuery> resultList, Element element){
        Elements elements = null;
        if(CollectionUtils.isEmpty(resultList)){
            return element.getAllElements();
        }
        for(CssQuery cssQuery : resultList){
            if(null == elements){
                //启动递归
                elements = element.select(getCssQueryText(cssQuery));
            }else{
                elements = getHtmlElements(null,cssQuery,elements);
            }
        }
        return elements;
    }

    /**
     * 获取结果集
     * @param resultList
     * @param innerElements
     * @return
     */
    public String getResult(List<CssQuery>  resultList,Elements innerElements,CaptureData captureData){
        String result = "";
        Double d = new Double(0);
        for(CssQuery cssQuery : resultList){
            switch (cssQuery.getResultType()){
                case "text":
                    result = innerElements.select(getCssQueryText(cssQuery)).text();
                    break;
                case "href":
                    result =innerElements.select(getCssQueryText(cssQuery)).attr("href");
                    break;
                case "i":
                    result =innerElements.select(getCssQueryText(cssQuery)).first().parent().text();
                    break;
                case "":
                    result = innerElements.select(getCssQueryText(cssQuery)).text();
                    break;
            }
            switch(cssQuery.getTableCol()){
                case  "TITLE":
                    captureData.setTitle(result);
                    break;
                case  "POINTS":
                    //for bilibili
                    String tokens[] = result.split(" ");
                    captureData.setPoints(Integer.parseInt(tokens[0]));
                    break;
                case  "PLAY_TIMES":
                    //for bilibili
                    if(result.contains("万")){
                        result=result.replace("万","");
                        d = new Double(result) * 10000;
                    }
                    captureData.setPlayTimes(d);
                    break;
                case  "BULLET":
                    //for bilibili
                    if(result.contains("万")){
                        result=result.replace("万","");
                        d = new Double(result) * 10000;
                    }
                    captureData.setBullet(d);
                    break;
                case  "UPLOADER":
                    captureData.setUploader(result);
                    break;
                case  "URL":
                    captureData.setUrl(result);
                    break;
            }
        }
        return result;
    }

}
