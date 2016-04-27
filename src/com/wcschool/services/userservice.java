package com.wcschool.services;

import com.wcschool.bean.pageBean;
import com.wcschool.model.Userinfo;


public interface userservice {
        public void save(Userinfo user);
        public boolean login(String username,String password);
        public pageBean UserPageList(int pageSize,int page);
        public void update(Userinfo user);
        public void delete(Userinfo user);
        public Userinfo getUserBYID(int userid);
}
