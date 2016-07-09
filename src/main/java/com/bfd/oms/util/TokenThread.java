package com.bfd.oms.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 定时获取邮箱的线程
 * 
 * @author liuyq
 * @date 2013-05-02
 */
public class TokenThread implements Runnable {
	
	public  final Log				logger	= LogFactory.getLog(TokenThread.class);
	public void run() {
		while (true) {
			try {
				Object obj=CacheHelper.getValue(CacheHelper.CACHE_MAIL, 
						GlobalVariable.MAIL_DETAIL_CACHE);
				
				if (null != obj) {
					logger.info("获取mail成功，有效时长7200秒");
					// 休眠7000秒
					Thread.sleep(1000*60*55*2);
				} else {
					// 如果为null，60秒后再获取
					Thread.sleep(60 * 1000);
					CacheHelper.setValue(CacheHelper.CACHE_MAIL, 
							GlobalVariable.MAIL_DETAIL_CACHE, LoginValidte.getMail());
				}
			} catch (InterruptedException e) {
				try {
					Thread.sleep(60 * 1000);
				} catch (InterruptedException e1) {
					logger.error("{}", e1);
				}
				logger.error("{}", e);
			}
		}
	}
}
