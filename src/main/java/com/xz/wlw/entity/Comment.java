package com.xz.wlw.entity;

public class Comment {
    private Integer id;

    private Integer tid;

    private String createtime;

    private String content;

    private String ip;

    public Comment(Integer id, Integer tid, String createtime, String content,String ip) {
        this.ip=ip;
        this.id = id;
        this.tid = tid;
        this.createtime = createtime;
        this.content = content;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Comment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}