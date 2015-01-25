package model;

import java.util.Date;

public class ReplyMessage {
	
	private int id;
	private int messageid;
	private String replyusername;
	private Date replydate;
	private String replycontent;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMessageid() {
		return messageid;
	}
	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}
	public String getReplyusername() {
		return replyusername;
	}
	public void setReplyusername(String replyusername) {
		this.replyusername = replyusername;
	}
	public Date getReplydate() {
		return replydate;
	}
	public void setReplydate(Date replydate) {
		this.replydate = replydate;
	}
	public String getReplycontent() {
		return replycontent;
	}
	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}

}
