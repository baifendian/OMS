package com.bfd.oms.model;

import java.util.Date;

public class WorktimeRelation {
    private String relationId;

    private Long worktimeId;

    private Integer type;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private String createUser;

    private String updateUser;

   

    public String getRelationId() {
		return relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}

	public Long getWorktimeId() {
        return worktimeId;
    }

    public void setWorktimeId(Long worktimeId) {
        this.worktimeId = worktimeId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}