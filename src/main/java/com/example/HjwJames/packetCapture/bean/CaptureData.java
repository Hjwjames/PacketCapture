package com.example.HjwJames.packetCapture.bean;

import org.springframework.util.StringUtils;

import java.util.Date;
/*
抓包数据
 */
public class CaptureData {
    private Integer id;
    private String title;
    private Integer points;
    private Double playTimes;
    private Double bullet;
    private String uploader;
    private Integer updateTimes;
    private String url;
    private String source;
    private Date createDate;
    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public Integer getUpdateTimes() {
        return updateTimes;
    }

    public void setUpdateTimes(Integer updateTimes) {
        this.updateTimes = updateTimes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Double getPlayTimes() {
        return playTimes;
    }

    public void setPlayTimes(Double playTimes) {
        this.playTimes = playTimes;
    }

    public Double getBullet() {
        return bullet;
    }

    public void setBullet(Double bullet) {
        this.bullet = bullet;
    }


    public CaptureData(Integer id, String title, Integer points, Double playTimes, Double bullet, String uploader, Integer updateTimes, String url, String source, Date createDate, Date updateDate) {
        this.id = id;
        this.title = title;
        this.points = points;
        this.playTimes = playTimes;
        this.bullet = bullet;
        this.uploader = uploader;
        this.updateTimes = updateTimes;
        this.url = url;
        this.source = source;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public CaptureData() {
    }

    @Override
    public String toString() {
        String result = "";
        if(!StringUtils.isEmpty(title)){
            result += "<b>标题： "+title +"</b><br>";
        }
        if(points!=null){
            result += "热度： "+points +"<br>";
        }
        if(!StringUtils.isEmpty(playTimes)){
            result += "播放量： " + playTimes +"<br>";
        }
        if(!StringUtils.isEmpty(bullet)){
            result += "弹幕量： " + bullet +"<br>";
        }
        if(!StringUtils.isEmpty(uploader)){
            result += "UP主： " + uploader +"<br>";
        }
        if(updateTimes!=null){
            result += "更新次数： " + updateTimes +"<br>";
        }
        if(!StringUtils.isEmpty(url)){
            result += "URL： "+ url +"<br>";
        }
        if(!StringUtils.isEmpty(source)){
            result += "来源： " + source +"<br>";
        }
        if(createDate!=null){
            result += "创建时间： " + createDate +"<br>";
        }
        if(updateDate!=null){
            result += "更新时间： " + updateDate +"<br>";
        }

        return result;
    }
}
