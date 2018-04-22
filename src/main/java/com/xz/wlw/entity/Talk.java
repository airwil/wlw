package com.xz.wlw.entity;

public class Talk {
    private Integer id;

    private String title;

    private String ip;

    private String content;

    private Integer commentNum;

    public Talk(Integer id, String title, String ip, String content,Integer commentNum) {
        this.id = id;
        this.title = title;
        this.ip = ip;
        this.content = content;
        this.commentNum=commentNum;
    }

    public Talk() {
        super();
    }

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
        this.title = title == null ? null : title.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }
}