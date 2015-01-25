package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Message;
import model.ReplyMessage;
import model.User;


public class DB {
	private Connection con = null;
	private PreparedStatement pstmt=null;
    private ResultSet rs = null;
    
    //数据库的连接
    
    public DB()
    {
    	try{
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/messageboard?useUnicode=true&characterEncoding=utf-8","root","root");
		}catch(Exception e){
			e.printStackTrace();
		}
			
		
    }
    
    
    
    //**************************查询登录用户是否存在***************************
    
    public User checkUser(String username,String userpwd)
    {
    	try {
    		pstmt=con.prepareStatement("select * from usertable where username=? and userpwd=?");
    		pstmt.setString(1,username);
    		pstmt.setString(2, userpwd);
    		rs=pstmt.executeQuery();
    		User user=new User();
    		while(rs.next())
    		{
    			user.setId(rs.getInt(1));
    			user.setUsername(rs.getString(2));
    			user.setUserpwd(rs.getString(3));
    			user.setUsersex(rs.getString(4));
    			user.setUseradr(rs.getString(5));
    			user.setUserhobby(rs.getString(6));
    			user.setUserinfo(rs.getString(7)); 
    			user.setUserphoto(rs.getString(8));
    			user.setUserstatus(rs.getString(9));
    			return user;    			
    			
    		}
    		return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
    
    
//**************************查询管理员用户是否存在***************************
    
    public User checkUserLogin(String username,String userpwd)
    {
    	try {
    		pstmt=con.prepareStatement("select * from usertable where username=? and userpwd=? and userstatus=1");
    		pstmt.setString(1,username);
    		pstmt.setString(2, userpwd);
    		rs=pstmt.executeQuery();
    		User user=new User();
    		while(rs.next())
    		{
    			user.setId(rs.getInt(1));
    			user.setUsername(rs.getString(2));
    			user.setUserpwd(rs.getString(3));
    			user.setUsersex(rs.getString(4));
    			user.setUseradr(rs.getString(5));
    			user.setUserhobby(rs.getString(6));
    			user.setUserinfo(rs.getString(7)); 
    			user.setUserphoto(rs.getString(8));
    			user.setUserstatus(rs.getString(9));
    			return user;    			
    			
    		}
    		return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
    
    //*********************************返回所有用户信息**************************
  
    public ArrayList<User> findAllUserInfo()
    {
    	try {
    		
    		ArrayList<User> list=new ArrayList<User>();
    		pstmt=con.prepareStatement("select * from usertable");
    		rs=pstmt.executeQuery();
    		while(rs.next())
    		{
    			User user=new User();
    			user.setId(rs.getInt(1));
    			user.setUsername(rs.getString(2));
    			user.setUserpwd(rs.getString(3));
    			user.setUsersex(rs.getString(4));
    			user.setUseradr(rs.getString(5));
    			user.setUserhobby(rs.getString(6));
    			user.setUserhobby(rs.getString(7));
    			user.setUserphoto(rs.getString(8));
    			user.setUserstatus(rs.getString(9));
    			list.add(user);
    		}
    		return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
    
    //*********************************依据用户id删除用户信息**************************
      
    public boolean delUserInfo(int id)
    {
    	
    	try {
    		pstmt=con.prepareStatement("delete from usertable where id=?");
			pstmt.setInt(1,id);			
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
    
    //*********************************返回所有留言**************************

    public ArrayList<Message> findMessageInfo()
    {
    	try {
    		
    		ArrayList<Message> list=new ArrayList<Message>();
    		pstmt=con.prepareStatement("select * from Message");
    		rs=pstmt.executeQuery();
    		while(rs.next())
    		{
    			Message message=new Message();
    			message.setId(rs.getInt(1));
    			message.setUserId(rs.getInt(2));    			
    			message.setDate(rs.getDate(3));
    			message.setTitle(rs.getString(4));
    			message.setContent(rs.getString(5));
    			message.setGood(rs.getString(6));
    			list.add(message);
    		}
    		return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
    
    //*********************************返回经典留言**************************

    public ArrayList<Message> findGoodMessageInfo()
    {
    	try {
    		
    		ArrayList<Message> list=new ArrayList<Message>();
    		pstmt=con.prepareStatement("select * from Message where good=1");
    		rs=pstmt.executeQuery();
    		while(rs.next())
    		{
    			Message message=new Message();
    			message.setId(rs.getInt(1));
    			message.setUserId(rs.getInt(2));    			
    			message.setDate(rs.getDate(3));
    			message.setTitle(rs.getString(4));
    			message.setContent(rs.getString(5));
    			message.setGood(rs.getString(6));
    			list.add(message);
    		}
    		return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
    
    //***************************依据用户id获取用户*******************
    public User getUserMessage(int id)
    {
    	
    	try {
    		pstmt=con.prepareStatement("select *  from usertable where id=?");
    		pstmt.setInt(1,id);
    		rs=pstmt.executeQuery(); 
    		User user=new User();
    		while(rs.next())
    		{
    			user.setId(rs.getInt(1));
    			user.setUsername(rs.getString(2));
    			user.setUserpwd(rs.getString(3));
    			user.setUsersex(rs.getString(4));
    			user.setUseradr(rs.getString(5));
    			user.setUserhobby(rs.getString(6));
    			user.setUserinfo(rs.getString(7)); 
    			user.setUserphoto(rs.getString(8));
    			user.setUserstatus(rs.getString(9));
    			return user;  
    			
    		}
    		return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
    }
    //***************************添加留言******************* 
    public boolean addInfo(Message message)
    {
    	
    	try {
    		pstmt=con.prepareStatement("insert into Message (userid,date,title,content,good)values (?,?,?,?,?)");
			pstmt.setInt(1, message.getUserId());
			pstmt.setDate(2, (Date) message.getDate());
			pstmt.setString(3, message.getTitle());
			pstmt.setString(4, message.getContent());
			pstmt.setString(5, message.getGood());
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
    
    //***************************插入用户信息*****************************

 public boolean insertUser(User user)
 {
	
	 try{
		 pstmt=con.prepareStatement("insert into usertable (username,userpwd,usersex,useradr,userhobby,userinfo,userphoto,userstatus) values(?,?,?,?,?,?,?,?)");
		 pstmt.setString(1, user.getUsername());
		 pstmt.setString(2, user.getUserpwd());
		 pstmt.setString(3, user.getUsersex());
		 pstmt.setString(4, user.getUseradr());
		 pstmt.setString(5, user.getUserhobby());
		 pstmt.setString(6, user.getUserinfo());
		 pstmt.setString(7, user.getUserphoto());
		 pstmt.setString(8, user.getUserstatus());
		 pstmt.executeUpdate();
		return true;
	 }
		 
	 catch(SQLException e)
	 {
		 e.printStackTrace();
		 return false;
	 }
	 
  }
 //***************************修改用户信息*****************************

 public boolean updateUser(User user,int id)
 {
	
	 try{
		 pstmt=con.prepareStatement("update usertable set username=?,userpwd=?,usersex=?,useradr=?,userhobby=?,userinfo=?,userphoto=?,userstatus=? where id=?");
		 pstmt.setString(1, user.getUsername());
		 pstmt.setString(2, user.getUserpwd());
		 pstmt.setString(3, user.getUsersex());
		 pstmt.setString(4, user.getUseradr());
		 pstmt.setString(5, user.getUserhobby());
		 pstmt.setString(6, user.getUserinfo());
		 pstmt.setString(7, user.getUserphoto());
		 pstmt.setString(8, user.getUserstatus());
		 pstmt.setInt(9,id);
		 pstmt.executeUpdate();
		return true;
	 }
		 
	 catch(SQLException e)
	 {
		 e.printStackTrace();
		 return false;
	 }
	 
  }
 
//***************************重置用户密码*****************************

 public boolean resetUserPwd(int id)
 {
	
	 try{
		 pstmt=con.prepareStatement("update usertable set userpwd='666666' where id=?");
		 pstmt.setInt(1, id);
		 pstmt.executeUpdate();
		return true;
	 }
		 
	 catch(SQLException e)
	 {
		 e.printStackTrace();
		 return false;
	 }
	 
  }
 
//***************************设置管理员权限*****************************

 public boolean setAdmin(int id)
 {
	
	 try{
		 pstmt=con.prepareStatement("update usertable set userstatus='1' where id=?");
		 pstmt.setInt(1, id);
		 pstmt.executeUpdate();
		return true;
	 }
		 
	 catch(SQLException e)
	 {
		 e.printStackTrace();
		 return false;
	 }
	 
  }
	
//***************************添加回复留言******************* 
 public boolean addReplyMessage(ReplyMessage replymessage)
 {
 	try {
 		pstmt=con.prepareStatement("insert into replymessage (messageid,replyusername,replydate,replycontent)values (?,?,?,?)");
			pstmt.setInt(1, replymessage.getMessageid());
			pstmt.setString(2, replymessage.getReplyusername());
			pstmt.setDate(3, (Date)replymessage.getReplydate());
			pstmt.setString(4, replymessage.getReplycontent());
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
 }
 
//***************************依据message id 获取回复留言*******************
 public ArrayList<ReplyMessage> getReplyMessage(int messageid)
 {
 	
 	try {
 		pstmt=con.prepareStatement("select *  from ReplyMessage where messageid=?");
 		pstmt.setInt(1,messageid);
 		rs=pstmt.executeQuery();  		
 		ArrayList<ReplyMessage> list=new ArrayList<ReplyMessage>();
 		while(rs.next())
 		{
 			ReplyMessage replymessage=new ReplyMessage();
 			replymessage.setMessageid(rs.getInt(2));
 			replymessage.setReplyusername(rs.getString(3));
 			replymessage.setReplydate(rs.getDate(4));
 			replymessage.setReplycontent(rs.getString(5));
 			list.add(replymessage);
 			  
 			
 		}
 		return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
 }
 
//***************************依据留言人姓名检索留言信息*******************
 public ArrayList<Message> getMessageUserName(String username)
 {
	 
 	try {
 		pstmt=con.prepareStatement("SELECT message.* FROM usertable,message WHERE usertable.id=message.userid and usertable.username=?");
 		pstmt.setString(1, username);
 		rs=pstmt.executeQuery();  		
 		ArrayList<Message> list=new ArrayList<Message>();
 		while(rs.next())
 		{
 			Message message=new Message();
 			message.setId(rs.getInt(1));
 			message.setUserId(rs.getInt(2));
 			message.setDate(rs.getDate(3));
 		    message.setTitle(rs.getString(4));
 		    message.setContent(rs.getString(5));
 			message.setGood(rs.getString(6));
 			list.add(message);
 			  
 			
 		}
 		return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
 }
 
//***************************依据留言标题关键字检索留言信息*******************
 public ArrayList<Message> getMessageTitleKey(String titlekey)
 {
	 
 	try {
 		pstmt=con.prepareStatement("SELECT * from message WHERE title LIKE ?");
 		pstmt.setString(1, '%'+titlekey+'%');
 		rs=pstmt.executeQuery();  		
 		ArrayList<Message> list=new ArrayList<Message>();
 		while(rs.next())
 		{
 			Message message=new Message();
 			message.setId(rs.getInt(1));
 			message.setUserId(rs.getInt(2));
 			message.setDate(rs.getDate(3));
 		    message.setTitle(rs.getString(4));
 		    message.setContent(rs.getString(5));
 			message.setGood(rs.getString(6));
 			list.add(message);
 			  
 			
 		}
 		return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
 }
 
}
