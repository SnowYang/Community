package model;

public class User {
	
	private int id;
	private String username;
	private String userpwd;
	private String usersex;
	private String useradr;
	private String userhobby;
	private String userinfo;
	private String userphoto;
	private String userstatus;
	
	public String getUserphoto() {
		return userphoto;
	}
	public void setUserphoto(String userphoto) {
		this.userphoto = userphoto;
	}
	public String getUserstatus() {
		return userstatus;
	}
	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	public String getUseradr() {
		return useradr;
	}
	public void setUseradr(String useradr) {
		this.useradr = useradr;
	}
	public String getUserhobby() {
		return userhobby;
	}
	public void setUserhobby(String userhobby) {
		this.userhobby = userhobby;
	}
	public String getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

}
