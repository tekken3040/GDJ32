package com.javateam.jse;

import java.util.Date;

public class MemberVO 
{
	private String id;
	private String pw;
	private String name;
	private String address;
	private Date joinDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	private int page = 10;

    private int totalPage = 100;

    private int limit = 99;

	@Override
	public String toString() {
		return "PageVO  [page=" + page + ", totalPage=" + totalPage + ", limit=" + limit + "]";
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
	}
}
