package com.example.HjwJames.packetCapture.bean;

import java.util.List;

public class PackCaptureVo {
    private String url;
    private List<CssQuery> itemList;
    private List<CssQuery> itemDetailList;
    private List<CssQuery> resultList;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<CssQuery> getItemList() {
        return itemList;
    }

    public void setItemList(List<CssQuery> itemList) {
        this.itemList = itemList;
    }

    public List<CssQuery> getItemDetailList() {
        return itemDetailList;
    }

    public void setItemDetailList(List<CssQuery> itemDetailList) {
        this.itemDetailList = itemDetailList;
    }

    public List<CssQuery> getResultList() {
        return resultList;
    }

    public void setResultList(List<CssQuery> resultList) {
        this.resultList = resultList;
    }
}
