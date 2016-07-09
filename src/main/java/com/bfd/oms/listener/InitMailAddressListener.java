package com.bfd.oms.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import com.bfd.oms.util.TokenThread;

/**
 * spring 初始化完毕后执行启动一个线程保存公司所有人的邮箱
 * 
 * @author 余明溢
 * @mail mingyi.yu@baifendian.com
 */
public class InitMailAddressListener implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null) {
			// 启动一个线程保存公司所有人的邮箱
			new Thread(new TokenThread()).start();
		}
	}

}
