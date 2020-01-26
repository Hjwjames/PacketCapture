package com.example.HjwJames.packetCapture.controller;

import com.example.HjwJames.packetCapture.quarz.service.JobService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    JobService jobService;

    @RequestMapping(value="/demo",method = RequestMethod.GET)
    public String demo(){
        String result = "<h1>Capture from http://news.qq.com/world_index.shtml</h1></br>";
        try {
            Document document = Jsoup.connect("http://news.qq.com/world_index.shtml").get();
            System.out.println(document);
            Elements titleDom = document.select(".linkto");
            int i =1;
            for (Element element : titleDom) {
                result +=  i+"." + element.text() +"</br>";
                //System.out.println(element.text());
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value="/qq",method = RequestMethod.GET)
    public String qq(){
        String result = "<h1>Capture from https://new.qq.com/ch/world/</h1></br>";
        try {
            Document document = Jsoup.connect("https://new.qq.com/ch/world/")
                    .timeout(4000).userAgent("Mozilla").get();
            Elements List = document.select("ul[class=list]");
            int i =1;
            for (Element element : List) {
                Elements element2 = element.select("div[class=detail]");
                for(Element e:element2){
                    result +=  i+"." + e.select("h3").text() +"</br>";
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping(value="/quarz",method = RequestMethod.GET)
    public void quarz(){
        try {
            jobService.quartzTest();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
