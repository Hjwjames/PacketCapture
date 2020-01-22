package com.example.HjwJames.packetCapture.service.impl;

import com.example.HjwJames.packetCapture.bean.CssQuery;
import com.example.HjwJames.packetCapture.service.PacketCaptureService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Service
public class PacketCaptureServiceImpl implements PacketCaptureService {
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
            //递归出document里Item项目位置
            for(CssQuery cssQuery : itemList){
                elements = getHtmlElements(document,cssQuery,elements);
            }
            //遍历item里需要输出的内容
            int i = 1;
            for(Element e : elements){
                //获取item详情定位
                Elements innerElements = selectElement(itemDetailList,e);
                //获取结果集合
                result += getResult(i,resultList,innerElements);
                i++;
            }
        }catch (Exception e){
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
     * @param i
     * @param resultList
     * @param innerElements
     * @return
     */
    public String getResult(int i ,List<CssQuery>  resultList,Elements innerElements){
        String result = "";
        result +=  i+"." ;
        for(CssQuery cssQuery : resultList){
            switch (cssQuery.getResultType()){
                case "text":
                    result += "<b>"+innerElements.select(getCssQueryText(cssQuery)).text() +"</b></br>";
                    break;
                case "href":
                    result +=innerElements.select(getCssQueryText(cssQuery)).attr("href") +"</br>";
                    break;
                case "":
                    result += innerElements.select(getCssQueryText(cssQuery)).text() +"</br>";
                    break;
            }
        }
        return result;
    }

}
