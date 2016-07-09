package com.bfd.oms.model;

public class MailWithBLOBs extends Mail {
    private String content;
    
    private String contents;

    private String receiveUsers;

    private String copyUser;

    private String approveContent;
    
    
    
    
	public MailWithBLOBs(String content, String receiveUsers, String copyUser, String approveContent) {
		super();
		this.content = content;
		this.receiveUsers = receiveUsers;
		this.copyUser = copyUser;
		this.approveContent = approveContent;
	}



	public MailWithBLOBs() {
		super();
	}



	public String getContents() {
		return contents;
	}



	public void setContents(String contents) {
		this.contents = contents;
	}



	public String getApproveContent() {
		return approveContent;
	}



	public void setApproveContent(String approveContent) {
		this.approveContent = approveContent;
	}



	public String getContent() {
        return content;
    }

	
	
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getReceiveUsers() {
        return receiveUsers;
    }

    public void setReceiveUsers(String receiveUsers) {
        this.receiveUsers = receiveUsers == null ? null : receiveUsers.trim();
    }

    public String getCopyUser() {
        return copyUser;
    }

    public void setCopyUser(String copyUser) {
        this.copyUser = copyUser == null ? null : copyUser.trim();
    }
}