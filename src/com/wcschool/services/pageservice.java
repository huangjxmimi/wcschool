package com.wcschool.services;

import com.wcschool.bean.pageBean;

public interface pageservice {
	
     public   pageBean queryForpage(int pageSize, int page,String ClassName);
	
}
