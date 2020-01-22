package com.example.HjwJames.packetCapture.service;

import com.example.HjwJames.packetCapture.bean.CssQuery;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

public interface PacketCaptureService {
    /**
     * 主算法
     * @param url
     * @param itemList
     * @param itemDetailList
     * @param resultList
     * @return
     */
    public String capture(String url, List<CssQuery> itemList,List<CssQuery> itemDetailList,List<CssQuery> resultList);
    /**
     * 遍历出document里Item项目
     * @param document
     * @param cssQuery
     * @param elements
     * @return
     */
    public Elements getHtmlElements(Document document , CssQuery cssQuery, org.jsoup.select.Elements elements);

    /**
     * pojo转换成querytext
     * @param cssQuery
     * @return
     */
    public String getCssQueryText(CssQuery cssQuery);

    /**
     * //获取item详情定位
     * @param resultList
     * @param element
     * @return
     */
    public Elements selectElement(List<CssQuery> resultList, Element element);

    /**
     * 获取结果集
     * @param i
     * @param resultList
     * @param innerElements
     * @return
     */
    public String getResult(int i ,List<CssQuery>  resultList,Elements innerElements);
}
