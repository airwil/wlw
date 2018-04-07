package com.xz.wlw.entity;

public class Introduct {
    private Integer id;

    private String content;

    public Introduct(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Introduct() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}