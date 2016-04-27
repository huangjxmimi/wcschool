package com.wcschool.dao;

import java.util.Collection;
import java.util.List;

public interface baseDao {
	 Object save(Object entity);  
	  
	    /**  
	     *   
	     * 删除实体  
	     *   
	     * @param entity  
	     *            实体对象  
	     *   
	     */  
	    void delete(Object entity);  
	  
	    /**  
	     *   
	     * 更新实体  
	     *   
	     * @param entity  
	     *            实体对象  
	     *   
	     */  
	    void update(Object entity);  
	  
	    /**  
	     *   
	     * 保存或更新实体, 实体没有主键时保存，否则更新  
	     *   
	     * @param entity  
	     *            实体对象  
	     *   
	     */  
	    void saveOrUpdate(Object entity);  
	  
	    /**  
	     *   
	     * 批量保存实体  
	     *   
	     * @param entities  
	     *            实体集合  
	     */  
	    void saveAll(Collection<?> entities);  
	  
	    /**  
	     *   
	     * 批量删除实体  
	     *   
	     * @param entities  
	     *            实体集合  
	     *   
	     */  
	    void deleteAll(Collection<?> entities);  
	  
	    /**  
	     *   
	     * 批量更新实体  
	     *   
	     * @param entities  
	     *            实体集合  
	     *   
	     */  
	    void updateAll(Collection<?> entity);  
	  
	    /**  
	     *   
	     * 批量保存或更新实体, 实体没有主键时保存，否则更新  
	     *   
	     * @param entity  
	     *            实体集合  
	     *   
	     */  
	    void saveOrUpdateAll(Collection<?> entities);  
	    
	    public int getCount(String ClassName);
	    
	    public List<?> pagelist(int startIndex, int length,String ClassName);
}
