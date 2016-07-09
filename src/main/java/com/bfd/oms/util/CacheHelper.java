package com.bfd.oms.util;

import java.io.Serializable;
import java.util.List;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import org.apache.log4j.Logger;

/**
 * ehcache缓存util
 * 
 * @author 余明溢
 * @mail mingyi.yu@baifendian.com
 *
 */
public class CacheHelper {
	/**
	 * 默认缓存
	 */
	public static String		CACHE_DEFAULT_NAME		= "default_cache";
	/**
	 * 用户登录的
	 */
	public static String		CACHE_LOGIN_USER_NAME	= "loginUserCache";
	/**
	 * 邮箱信息
	 */
	public static String		CACHE_MAIL				= "mailCache";

	private static CacheManager	manager					= null;
	private static Logger		log						= Logger.getLogger(CacheHelper.class);
	static {
		manager = CacheManager.newInstance();
		CacheConfiguration config = new CacheConfiguration();
		config.setName(CacheHelper.CACHE_DEFAULT_NAME);
		// 对象空闲时间，指对象在多长时间没有被访问就会失效。只对eternal为false的有效。默认值0，表示一直可以访问。
		config.setTimeToIdleSeconds(60 * 60);
		// 对象存活时间，指对象从创建到失效所需要的时间。只对eternal为false的有效。默认值0，表示一直可以访问。
		config.setTimeToLiveSeconds(60 * 60 * 24);
		// 在堆内存中最大缓存对象数
		config.setMaxEntriesLocalHeap(10000);
		// 在磁盘上缓存的element的最大数目，默认值为0，表示不限制。
		// 注意：如果缓存的对象要写入到硬盘中的话，则该对象必须实现了Serializable接口才行
		config.setMaxEntriesLocalDisk(0);
		Cache c = new Cache(config);

		CacheConfiguration config_login = new CacheConfiguration();
		config_login.setName(CacheHelper.CACHE_LOGIN_USER_NAME);
		// 对象空闲时间，指对象在多长时间没有被访问就会失效。只对eternal为false的有效。默认值0，表示一直可以访问。
		config_login.setTimeToIdleSeconds(60 * 30);
		// 对象存活时间，指对象从创建到失效所需要的时间。只对eternal为false的有效。默认值0，表示一直可以访问。
		config_login.setTimeToLiveSeconds(60 * 30);
		// 在堆内存中最大缓存对象数
		config_login.setMaxEntriesLocalHeap(10000);
		// 在磁盘上缓存的element的最大数目，默认值为0，表示不限制。
		// 注意：如果缓存的对象要写入到硬盘中的话，则该对象必须实现了Serializable接口才行
		config_login.setMaxEntriesLocalDisk(0);
		Cache c_login = new Cache(config_login);

		CacheConfiguration config_mail = new CacheConfiguration();
		config_mail.setName(CacheHelper.CACHE_MAIL);
		// 对象空闲时间，指对象在多长时间没有被访问就会失效。只对eternal为false的有效。默认值0，表示一直可以访问。
		config_mail.setTimeToIdleSeconds(60 * 60 * 2);
		// 对象存活时间，指对象从创建到失效所需要的时间。只对eternal为false的有效。默认值0，表示一直可以访问。
		config_mail.setTimeToLiveSeconds(60 * 60 * 2);
		// 在堆内存中最大缓存对象数
		config_mail.setMaxEntriesLocalHeap(10000);
		// 在磁盘上缓存的element的最大数目，默认值为0，表示不限制。
		// 注意：如果缓存的对象要写入到硬盘中的话，则该对象必须实现了Serializable接口才行
		config_mail.setMaxEntriesLocalDisk(0);
		Cache c_mail = new Cache(config_mail);

		manager.addCache(c);
		manager.addCache(c_login);
		manager.addCache(c_mail);
	}

	/**
	 * 添加缓存
	 * 
	 * @param name
	 * @param config
	 */
	public static Cache setCache(String name) {
		CacheConfiguration config = new CacheConfiguration();
		config.setName(name);
		config.setTimeToIdleSeconds(60 * 60);
		config.setTimeToLiveSeconds(60 * 60 * 24);
		config.setMaxEntriesLocalHeap(10000);
		config.setMaxEntriesLocalDisk(1000000);
		return setCache(config);
	}

	/**
	 * 添加缓存
	 * 
	 * @param name
	 * @param config
	 */
	public static Cache setCache(CacheConfiguration config) {
		if (checkIsNull())
			return null;
		Cache cache = null;
		if (config == null)
			return null;
		String name = config.getName();
		if (name.equalsIgnoreCase(CacheHelper.CACHE_DEFAULT_NAME))
			return manager.getCache(CacheHelper.CACHE_DEFAULT_NAME);
		if (containsCache(name)) {
			manager.removeCache(name);
		}
		cache = new Cache(config);
		manager.addCache(cache);
		return cache;
	}

	public static boolean containsCache(String name) {
		if (checkIsNull())
			return false;
		if (name == null)
			return false;
		return manager.cacheExists(name);
	}

	/**
	 * 获取缓存
	 * 
	 * @param name
	 * @return
	 */
	public static Cache getCache(String name) {
		if (checkIsNull())
			return null;
		Cache cache = null;
		if (containsCache(name)) {
			cache = manager.getCache(name);
		}
		else {
			cache = setCache(name);
		}
		return cache;
	}

	/**
	 * 设置缓存
	 * 
	 * @param cacheName
	 * @param key
	 * @param object
	 */
	public static void setValue(String cacheName, String key, Object object) {
		Cache cache = getCache(cacheName);
		if (cache == null)
			return;
		Element element = new Element(key, object);
		cache.put(element);
	}

	/**
	 * 查询缓存结果
	 * 
	 * @param cacheName
	 * @param key
	 * @return
	 */
	public static Object getValue(String cacheName, String key) {
		Cache cache = getCache(cacheName);
		if (cache == null)
			return null;
		Element e = cache.get(key);
		return e == null ? null : e.getObjectValue();
	}

	/**
	 * 设置到默认缓存
	 * 
	 * @param key
	 * @param value
	 */
	public static void setValue(String key, Serializable value) {
		setValue(CacheHelper.CACHE_DEFAULT_NAME, key, value);
	}

	/**
	 * 获取缓存结果
	 * 
	 * @param key
	 * @return
	 */
	public static String getStringValue(String key) {
		Object obj = getValue(CacheHelper.CACHE_DEFAULT_NAME, key);
		return obj == null ? null : obj.toString();
	}

	/**
	 * 获取缓存key
	 * 
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<String> getKeys(String cacheName) {
		if (cacheName == null)
			cacheName = CACHE_DEFAULT_NAME;
		Cache cache = getCache(cacheName);
		return cache.getKeys();
	}

	public static boolean containsKey(String name) {
		Cache cache = getCache(CACHE_DEFAULT_NAME);
		if (cache == null)
			return false;
		return cache.isKeyInCache(name);
	}

	/**
	 * 删除以字符串开头的缓存
	 * 
	 * @param pre
	 * @return
	 */
	public static synchronized boolean removePreKey(String pre) {
		Cache cache = getCache(CACHE_DEFAULT_NAME);
		if (cache == null)
			return false;
		for (String key : getKeys(CACHE_DEFAULT_NAME)) {
			if (key.startsWith(pre))
				cache.remove(key);
		}
		return true;
	}

	/**
	 * 删除对呀缓存的 Key
	 * 
	 * @param cacheName
	 * @param pre
	 * @return
	 */
	public static synchronized boolean removePreKey(String cacheName, String pre) {
		Cache cache = getCache(cacheName);
		if (cache == null)
			return false;
		for (String key : getKeys(cacheName)) {
			if (key.equals(pre))
				cache.remove(key);
		}
		return true;
	}

	public static boolean checkIsNull() {
		if (manager == null) {
			log.error("cache manager is null!");
			return true;
		}
		else
			return false;
	}

	@Override
	protected void finalize() throws Throwable {
		if (manager != null) {
			manager.removeCache(CACHE_DEFAULT_NAME);
			manager.shutdown();
			log.info("cache manager shutdown.");
		}
		super.finalize();
	}

}
