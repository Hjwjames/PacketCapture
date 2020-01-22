package com.example.HjwJames.packetCapture.bean;

public class CssQuery {
    private String element;
    private String className;
    private String resultType;

    /*public CssQuery(String element, String className) {
        this.element = element;
        this.className = className;
        this.resultType = "";
    }*/

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

    public CssQuery(String element, String className, String resultType) {
        this.element = element;
        this.className = className;
        this.resultType = resultType;
    }
}
