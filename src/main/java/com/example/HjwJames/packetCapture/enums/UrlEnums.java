package com.example.HjwJames.packetCapture.enums;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * url source源
 */
public enum UrlEnums {
    BILIBILI("https://www.bilibili.com/ranking","BILIBILI"),
    BILIBILI3("https://www.bilibili.com/ranking/all/0/0/3","BILIBILI"),
    BILIBILI7("https://www.bilibili.com/ranking/all/0/0/7","BILIBILI"),
    BILIBILI30("https://www.bilibili.com/ranking/all/0/0/30","BILIBILI"),
    QQ("https://new.qq.com/ch/world/","QQ"),
    UNKNOWN("UNKNOWN","UNKNOWN");

    private String url;
    private String source;

    UrlEnums(String url, String source) {
        this.url = url;
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
    public static Map<String, String> URLENUMSMAP = initURLENUMSMAP();
    private static Map<String, String> initURLENUMSMAP() {
        Map<String, String> map = new LinkedHashMap<String, String>();
        map.put(BILIBILI.getUrl(),BILIBILI.getSource());
        map.put(BILIBILI3.getUrl(),BILIBILI3.getSource());
        map.put(BILIBILI7.getUrl(),BILIBILI7.getSource());
        map.put(BILIBILI30.getUrl(),BILIBILI30.getSource());
        map.put(QQ.getUrl(), QQ.getSource());
        map.put(UNKNOWN.getUrl(), UNKNOWN.getSource());
        return map;
    }

}
