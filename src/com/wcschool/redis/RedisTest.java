package com.wcschool.redis;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;



public class RedisTest {
 
        private Jedis jedis;
        private JedisPool pool;
        @Before
        public void init() {
    		pool = new JedisPool(new JedisPoolConfig(), "112.74.198.63");
    		jedis = pool.getResource();
    	}
        @Test
        public void test()
        {
        	List<String> list=jedis.hvals("userinfo_6");
       	 Iterator<String> iter =list.iterator();
       	 System.out.println(iter.hasNext());
        }
		public Jedis getJedis() {
			return jedis;
		}
		public void setJedis(Jedis jedis) {
			this.jedis = jedis;
		}
		public JedisPool getPool() {
			return pool;
		}
		public void setPool(JedisPool pool) {
			this.pool = pool;
		}
}
