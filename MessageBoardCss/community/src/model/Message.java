package model;

import java.util.Date;
import java.sql.*;

public class Message {
	
	private int id;
	private int userId;
	private Date date;
	private String title;
	private String content;
	private String good;
	
	public String getGood() {
		return good;
	}
	public void setGood(String good) {
		this.good = good;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	

}
