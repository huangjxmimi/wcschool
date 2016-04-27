package com.wcschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wcschool.bean.pageBean;
import com.wcschool.services.impl.userservicesimpl;

@Controller
public class pageController {
    private int currentpage;
	 @Autowired
	 @Qualifier("userservices")
	private userservicesimpl userservimpl;
	@RequestMapping("home/userpage")
	@ResponseBody
	public pageBean userpage()
	{
		pageBean page =userservimpl.UserPageList(10, currentpage);
		return page;		
	}
	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
}
