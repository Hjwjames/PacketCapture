package com.example.HjwJames.packetCapture.bean;

import java.util.Date;

public class AopData {
    private Integer id;
    private String className;
    private String functionName;
    private String description;
    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public AopData(Integer id, String className, String functionName, String description, Date createDate) {
        this.id = id;
        this.className = className;
        this.functionName = functionName;
        this.description = description;
        this.createDate = createDate;
    }
}
