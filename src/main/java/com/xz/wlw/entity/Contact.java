package com.xz.wlw.entity;

import java.io.Serializable;

public class Contact implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String address;

    private String tel;

    private String qq;

    public Contact(Integer id, String address, String tel, String qq) {
        this.id = id;
        this.address = address;
        this.tel = tel;
        this.qq = qq;
    }

    public Contact() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

	@Override
	public String toString() {
		return "Contact [id=" + id + ", address=" + address + ", tel=" + tel + ", qq=" + qq + "]";
	}
    
    
}