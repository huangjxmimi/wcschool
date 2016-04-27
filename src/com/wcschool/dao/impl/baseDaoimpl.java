package com.wcschool.dao.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.wcschool.dao.baseDao;

@Repository
public class baseDaoimpl implements baseDao {
	/*
	 * 注入sessionFactory
	 */
	@SuppressWarnings("rawtypes")
	private List resultList;
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	public Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.getCurrentSession();
	}
	/*
	 * 
	 * 保存PO
	 */
	public int getCount(String ClassName) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			String hql = "select entity from " + ClassName + " as entity ";
			Query query = getSession().createQuery(hql);
			count = query.list().size();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}

	public List<?> pagelist(int startIndex, int length, String ClassName) {
		// TODO Auto-generated method stub
		try {
			String hql = "select entity from " + ClassName + " as entity ";
			Query query = getSession().createQuery(hql);
			query.setFirstResult(startIndex);
			query.setMaxResults(length);
			resultList = query.list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultList;
	}

	@Override
	public Object save(Object entity) {
		// TODO Auto-generated method stub
		return getSession().save(entity);
	}

	@Override
	public void delete(Object entity) {
		// TODO Auto-generated method stub
		getSession().delete(entity);
	}

	@Override
	public void update(Object entity) {
		// TODO Auto-generated method stub
		getSession().update(entity);
	}

	@Override
	public void saveOrUpdate(Object entity) {
		// TODO Auto-generated method stub
         getSession().saveOrUpdate(entity);
	}

	@Override
	public void saveAll(Collection<?> entities) {
		// TODO Auto-generated method stub
           Iterator<?> iterator =entities.iterator();
           while(iterator.hasNext())
           {
        	   Object entity=iterator.next();
        	   getSession().save(entity);
           }
	}

	@Override
	public void deleteAll(Collection<?> entities) {
		// TODO Auto-generated method stub
		  Iterator<?> iterator =entities.iterator();
          while(iterator.hasNext())
          {
       	   Object entity=iterator.next();
       	   getSession().delete(entity);
          }
	}

	@Override
	public void updateAll(Collection<?> entities) {
		// TODO Auto-generated method stub
		Iterator<?> iterator =entities.iterator();
        while(iterator.hasNext())
        {
     	   Object entity=iterator.next();
     	   getSession().update(entity);
        }
	}

	@Override
	public void saveOrUpdateAll(Collection<?> entities) {
		// TODO Auto-generated method stub
		Iterator<?> iterator =entities.iterator();
        while(iterator.hasNext())
        {
     	   Object entity=iterator.next();
     	   getSession().saveOrUpdate(entity);;
        }
	}

	@SuppressWarnings("rawtypes")
	public List getResultList() {
		return resultList;
	}

	@SuppressWarnings("rawtypes")
	public void setResultList(List resultList) {
		this.resultList = resultList;
	}
}
