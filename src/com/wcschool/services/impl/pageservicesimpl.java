package com.wcschool.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcschool.bean.pageBean;
import com.wcschool.dao.baseDao;
import com.wcschool.services.pageservice;
@Service("pageservices")
public class pageservicesimpl implements pageservice {	
	@Autowired
	private baseDao baseDao;
	@Override
	public  pageBean queryForpage(int pageSize, int page,String ClassName) {
		// TODO Auto-generated method stub
		int allRow=baseDao.getCount(ClassName);//总记录数
		int totalpage=pageBean.countTotalPage(pageSize, allRow);//总页数
		final int startIndex=pageBean.countStartIndex(pageSize, page);//开始查询
		final int length=pageSize;//每页记录数
		final int currentPage=pageBean.currentPage(page);
		@SuppressWarnings("rawtypes")
		List list=baseDao.pagelist(startIndex, length,ClassName);//一页的记录
		pageBean pagemanager=new pageBean();
		pagemanager.setList(list);
		pagemanager.setPageSize(pageSize);
		pagemanager.setAllRow(allRow);
		pagemanager.setCurrentPage(currentPage);
		pagemanager.setTotalPage(totalpage);
		pagemanager.init();
		return pagemanager;
	}
}
