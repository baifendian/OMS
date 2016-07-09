package com.bfd.oms.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class WorkTime {
    private Long worktimeId;

    private String userName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date worktimeBegin;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date worktimeEnd;

    private Integer total;

    private String auditName;
 
    private String auditStatus;

    private Integer type;
    private String typename;

    private Integer isusedcompletely;

    private Integer surplusTotal;

    private Date surplusTimeBegin;

    private Date surplusTimeEnd;

    private Integer status;

    private Long mailId;

    private String worktimeRelationId;

    private Date createTime;

    private Date updateTime;

    private String createUser;

    private String updateUser;
    
    private Mail mail;
    
    private MailWithBLOBs mailwithblobs;
    
    private Long approveMailId;
    
    private String content;
    
    
    
    

    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getApproveMailId() {
		return approveMailId;
	}

	public void setApproveMailId(Long approveMailId) {
		this.approveMailId = approveMailId;
	}

	public MailWithBLOBs getMailwithblobs() {
		return mailwithblobs;
	}

	public void setMailwithblobs(MailWithBLOBs mailwithblobs) {
		this.mailwithblobs = mailwithblobs;
	}

	public Mail getMail() {
		return mail;
	}

	public void setMail(Mail mail) {
		this.mail = mail;
	}

	public Long getWorktimeId() {
        return worktimeId;
    }

    public void setWorktimeId(Long worktimeId) {
        this.worktimeId = worktimeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
    
    public Date getWorktimeBegin() {
        return worktimeBegin;
    }

    public void setWorktimeBegin(Date worktimeBegin) {
        this.worktimeBegin = worktimeBegin;
    }
   
    public Date getWorktimeEnd() {
        return worktimeEnd;
    }

    public void setWorktimeEnd(Date worktimeEnd) {
        this.worktimeEnd = worktimeEnd;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getAuditName() {
        return auditName;
    }

    public void setAuditName(String auditName) {
        this.auditName = auditName == null ? null : auditName.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsusedcompletely() {
        return isusedcompletely;
    }

    public void setIsusedcompletely(Integer isusedcompletely) {
        this.isusedcompletely = isusedcompletely;
    }

    public Integer getSurplusTotal() {
        return surplusTotal;
    }

    public void setSurplusTotal(Integer surplusTotal) {
        this.surplusTotal = surplusTotal;
    }

    public Date getSurplusTimeBegin() {
        return surplusTimeBegin;
    }

    public void setSurplusTimeBegin(Date surplusTimeBegin) {
        this.surplusTimeBegin = surplusTimeBegin;
    }

    public Date getSurplusTimeEnd() {
        return surplusTimeEnd;
    }

    public void setSurplusTimeEnd(Date surplusTimeEnd) {
        this.surplusTimeEnd = surplusTimeEnd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getMailId() {
        return mailId;
    }

    public void setMailId(Long mailId) {
        this.mailId = mailId;
    }

    public String getWorktimeRelationId() {
        return worktimeRelationId;
    }

    public void setWorktimeRelationId(String worktimeRelationId) {
        this.worktimeRelationId = worktimeRelationId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	 
    
    
}