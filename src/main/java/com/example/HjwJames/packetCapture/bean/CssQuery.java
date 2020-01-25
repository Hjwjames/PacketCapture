package com.example.HjwJames.packetCapture.bean;

public class CssQuery {
    //html样式
    private String element;
    //html class属性名
    private String className;
    //需要抓取的数据格式text/href
    private String resultType;
    //录表字段
    private String tableCol;

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getTableCol() {
        return tableCol;
    }

    public void setTableCol(String tableCol) {
        this.tableCol = tableCol;
    }

    public CssQuery(String element, String className, String resultType, String tableCol) {
        this.element = element;
        this.className = className;
        this.resultType = resultType;
        this.tableCol = tableCol;
    }

}
