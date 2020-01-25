package com.example.HjwJames.packetCapture.controller;

import com.example.HjwJames.packetCapture.bean.CssQuery;
import com.example.HjwJames.packetCapture.bean.PackCaptureVo;
import com.example.HjwJames.packetCapture.service.PacketCaptureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/captureController")
public class CaptureController {

    @Autowired
    PacketCaptureService packetCaptureService;

    @RequestMapping(value="/qq",method = RequestMethod.GET)
    public String qq(){
        List<CssQuery> itemList = new ArrayList<>();

        itemList.add(new CssQuery("ul","list","",""));
        itemList.add(new CssQuery("div","detail","",""));

        List<CssQuery> itemDetailList = new ArrayList<>();
        String url = "https://new.qq.com/ch/world/";
        //String outputElement = "a[class=title]";
        List<CssQuery> resultList = new ArrayList<>();
        resultList.add(new CssQuery("h3","","text",""));
        return packetCaptureService.capture(url,itemList,itemDetailList,resultList);
    }
    @RequestMapping(value="/bilibili",method = RequestMethod.GET)
    public String bilibili(){
        //找到item
        List<CssQuery> itemList = new ArrayList<>();
        itemList.add(new CssQuery("div","rank-list-wrap","",""));
        itemList.add(new CssQuery("ul","rank-list","",""));
        itemList.add(new CssQuery("li","rank-item","",""));
        //找到item里详情
        List<CssQuery> itemDetailList = new ArrayList<>();
        itemDetailList.add(new CssQuery("div","content","",""));
        itemDetailList.add(new CssQuery("div","info","",""));
        String url = "https://www.bilibili.com/ranking";
        //找到详情里要输出的元素
        List<CssQuery> resultList = new ArrayList<>();
        resultList.add(new CssQuery("a","title","text","TITLE"));
        resultList.add(new CssQuery("a","title","href","URL"));
        resultList.add(new CssQuery("div","pts","text","POINTS"));
        resultList.add(new CssQuery("i","b-icon play","i","PLAY_TIMES"));
        resultList.add(new CssQuery("i","b-icon view","i","BULLET"));
        resultList.add(new CssQuery("i","b-icon author","i","UPLOADER"));
        return packetCaptureService.capture(url,itemList,itemDetailList,resultList);
    }

    @RequestMapping(value="/capture",method = RequestMethod.POST)
    public String captureAll(@RequestBody PackCaptureVo packCaptureVo){
        String res = packetCaptureService.capture(packCaptureVo.getUrl(),packCaptureVo.getItemList(),packCaptureVo.getItemDetailList(),packCaptureVo.getResultList());
        return res;
    }






}

/**

 {
 "url":"https://www.bilibili.com/ranking",
 "itemList":[{
 "element":"div",
 "className":"rank-list-wrap",
 "resultType":"text"
 },{
 "element":"ul",
 "className":"rank-list",
 "resultType":"text"
 },{
 "element":"li",
 "className":"rank-item",
 "resultType":"text"
 }],
 "itemDetailList":[{
 "element":"div",
 "className":"content",
 "resultType":"text"
 },{
 "element":"div",
 "className":"info",
 "resultType":"text"
 }],
 "resultList":[{
 "element":"a",
 "className":"title",
 "resultType":"text"
 },{
 "element":"a",
 "className":"title",
 "resultType":"href"
 },{
 "element":"div",
 "className":"pts",
 "resultType":"text"
 }]
 }
 */