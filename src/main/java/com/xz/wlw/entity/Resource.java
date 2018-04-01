package com.xz.wlw.entity;

import java.io.Serializable;

public class Resource implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String name;

    private String fileurl;

    public Resource(Integer id, String name, String fileurl) {
        this.id = id;
        this.name = name;
        this.fileurl = fileurl;
    }

    public Resource() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl == null ? null : fileurl.trim();
    }
}