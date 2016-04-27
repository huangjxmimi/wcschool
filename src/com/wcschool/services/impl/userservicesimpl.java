package com.wcschool.services.impl;


import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcschool.bean.pageBean;
import com.wcschool.dao.baseDao;
import com.wcschool.dao.userdao;
import com.wcschool.model.Userinfo;
import com.wcschool.redis.RedisUtil;
import com.wcschool.services.pageservice;
import com.wcschool.services.userservice;
@Service("userservices")
public class userservicesimpl implements userservice{    
    private List<Userinfo> list ;
    @Autowired
	private userdao userDao;
	@Autowired
	private baseDao basedao;
	@Autowired
	private pageservice pageservices;
	@Autowired
	private RedisUtil redis;
	 HashMap<String,String> userinfo=new HashMap<String,String>();
	private String userID;
	public void save(Userinfo user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}
	public userdao getUserDao() {
		return userDao;
	}
	public void setUserDao(userdao userDao) {
		this.userDao = userDao;
	}
	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		userID="6";
		if (redis.exists("userinfo_"+userID, userID)) {
			System.out.println("redis login");
			return true;
		} else {
			list = userDao.login(username, password);
			if (list.size() > 0) {
				System.out.println("mysql login");
				Userinfo user = (Userinfo) list.get(0);
				userID = new String(user.getId().toString());
				userinfo.put("userid", userID);
				userinfo.put("username", username);
				userinfo.put("password", password);
				redis.MapCache("userinfo_"+userID, userinfo);
				redis.expire("userinfo_"+userID);
				return true;
			} else {
				return false;
			}
		}
	}
	public List<Userinfo> getList() {
		return list;
	}
	public void setList(List<Userinfo> list) {
		this.list = list;
	}
	@Override
	public pageBean UserPageList(int pageSize, int page) {		
		// TODO Auto-generated method stub
		pageBean pagemanager =pageservices.queryForpage(pageSize, page, "Userinfo");
		return pagemanager;
	}
	@Override
	public void update(Userinfo user) {
		// TODO Auto-generated method stub
		basedao.update(user);
	}
	@Override
	public void delete(Userinfo user) {
		// TODO Auto-generated method stub
		basedao.delete(user);
	}
	@Override
	public Userinfo getUserBYID(int userid) {
		// TODO Auto-generated method stub
		return userDao.getUserBYID(userid);
	}

}
