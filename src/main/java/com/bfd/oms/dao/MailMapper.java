package com.bfd.oms.dao;

import com.bfd.oms.model.MailWithBLOBs;

public interface MailMapper {


	 

	/**
	 * 保存
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：boolean
	 */
	void insertSelective(MailWithBLOBs mailwithblobs);

}