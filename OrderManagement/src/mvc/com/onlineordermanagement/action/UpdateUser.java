package com.onlineordermanagement.action;

import com.onlineordermanagement.dao.LoginDB;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateUser extends ActionSupport{
	
	private static final long serialVersionUID = -3827439829486925185L;
	
	private int updateUserId;
	private String updateUserName;
	private String updateUserRole;
	private String updateUserPassword;
	private String updateUserCnfrmPassword;
	private String msg;
	LoginDB loginDB = null;
	
	public int getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = Integer.parseInt(updateUserId);
	}
	public String getUpdateUserName() {
		return updateUserName;
	}
	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}
	public String getUpdateUserRole() {
		return updateUserRole;
	}
	public void setUpdateUserRole(String updateUserRole) {
		this.updateUserRole = updateUserRole;
	}
	public String getUpdateUserPassword() {
		return updateUserPassword;
	}
	public void setUpdateUserPassword(String updateUserPassword) {
		this.updateUserPassword = updateUserPassword;
	}
	public String getUpdateUserCnfrmPassword() {
		return updateUserCnfrmPassword;
	}
	public void setUpdateUserCnfrmPassword(String updateUserCnfrmPassword) {
		this.updateUserCnfrmPassword = updateUserCnfrmPassword;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String execute() throws Exception {
		loginDB = new LoginDB();
		msg = loginDB.UpdtUser(updateUserId, updateUserName, updateUserRole, updateUserPassword, updateUserCnfrmPassword);
		return "success";
	}
	
}
