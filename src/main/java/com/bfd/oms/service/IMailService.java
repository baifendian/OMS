package com.bfd.oms.service;

import java.util.Map;

import com.bfd.oms.model.MailWithBLOBs;
import com.bfd.oms.model.WorkTime;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface IMailService {
	
	/**
	 * 查询用户的基本信息
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：List<Users>
	 */
    public PageList<WorkTime> PageQuery(Map<String, Object> map) ;

    /**
     * 审批人同意
     * @author：wujun
     * @email: jun.wu@baifendian.com
     * @return_type：boolean
     */
	public boolean agree(WorkTime workTime);

}
