package com.wcschool.controller;



import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;










import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wcschool.model.Userinfo;
import com.wcschool.services.impl.userservicesimpl;

@Controller

public class userController {
     
	private String username;
	private String password;
	private MessageDigest md5;
	 @Autowired
	 @Qualifier("userservices")
	private userservicesimpl userservimpl;
	@RequestMapping("home/login")
	public String login(HttpServletRequest request,HttpServletResponse response)
	{		
		username ="132124";
		password ="45456";
		try {
			setMd5(MessageDigest.getInstance("MD5"));
			 
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] byteArray = null;
		try {
			byteArray = password.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        password = hexValue.toString();
		boolean flag =userservimpl.login(username, password);
		if(flag == true)
		{
			return "Home_Page";
		}		
		else
		{
			return "Home_Page";
		}		
	}
	@RequestMapping("home/register")
	public String register(HttpServletRequest request,HttpServletResponse response)
	{		
		username =request.getParameter("username");
		password =request.getParameter("password");		
		try {
			setMd5(MessageDigest.getInstance("MD5"));
			 
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] byteArray = null;
		try {
			byteArray = password.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
			Userinfo user =new Userinfo();
			user.setUsername(username);
			user.setPassword(hexValue.toString());
			userservimpl.save(user);
			return "Home_Page";	
	}
	@RequestMapping("home/update")
	public String update(HttpServletRequest request,HttpServletResponse response)
	{		
		username =request.getParameter("username");
		password =request.getParameter("password");		
		try {
			setMd5(MessageDigest.getInstance("MD5"));
			 
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		byte[] byteArray = null;
		try {
			byteArray = password.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
			Userinfo user =new Userinfo();
			user.setUsername(username);
			user.setPassword(hexValue.toString());
			userservimpl.update(user);
			return "Home_Page";	
	}
	public String delete(HttpServletRequest request,HttpServletResponse response)
	{
		String id = request.getParameter("id");
		int userid = new Integer(id);
		Userinfo user=userservimpl.getUserBYID(userid);
		userservimpl.delete(user);
		return "success";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public userservicesimpl getUserservimpl() {
		return userservimpl;
	}
	public void setUserservimpl(userservicesimpl userservimpl) {
		this.userservimpl = userservimpl;
	}
	public MessageDigest getMd5() {
		return md5;
	}
	public void setMd5(MessageDigest md5) {
		this.md5 = md5;
	}
}
