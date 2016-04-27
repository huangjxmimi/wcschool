package com.wcschool.redis;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class RedisUtil {
	private Jedis jedis;
	private JedisPool pool;
	private Boolean flag;

	public void init() {
		pool = new JedisPool(new JedisPoolConfig(), "112.74.198.63");
		jedis = pool.getResource();
	}
     public boolean exists(String key,String value)
     { 
    	 List<String> list=jedis.hvals(key);
    	 Iterator<String> iter =list.iterator();
    	 if(iter.hasNext())
    	 {
            flag=true;
    	 }
    	 else 
    		 {flag =false;}
    	 return flag;
     }
     public void expire(String key)
     {
    	 jedis.expire(key, 1800);
     }
    public void MapCache(String key,Map<String, String> map)
    {
    	jedis.hmset(key, map);
    }
    public List<String> getMapCache(String key,String fields)
    {
    	List<String> list=jedis.hmget(key, fields);
    	return list;
    }
	public Jedis getJedis() {
		return jedis;
	}

	public void setJdedis(Jedis jedis) {
		this.jedis = jedis;
	}

	public JedisPool getPool() {
		return pool;
	}

	public void setPool(JedisPool pool) {
		this.pool = pool;
	}
}
