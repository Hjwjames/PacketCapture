package com.example.HjwJames.packetCapture.bean;

import java.util.Date;

public class ExceptionData {
    private Integer id;
    private String className;
    private String functionName;
    private String description;
    private String exception;
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

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public ExceptionData(Integer id, String className, String functionName, String description, String exception, Date createDate) {
        this.id = id;
        this.className = className;
        this.functionName = functionName;
        this.description = description;
        this.exception = exception;
        this.createDate = createDate;
    }
}
