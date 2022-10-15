package com.onlineordermanagement.action;


import com.onlineordermanagement.dao.LoginDB;
import com.opensymphony.xwork2.ActionSupport;

public class AddNewUser extends ActionSupport{
	private static final long serialVersionUID = -3827439829486925185L;
	
	private String newUserName;
	private String newUserRole;
	private String newUserPassword;
	private String newUserCnfrmPassword;
	private String msg;
	LoginDB loginDB = null;
	public String getNewUserName() {
		return newUserName;
	}
	public void setNewUserName(String newUserName) {
		this.newUserName = newUserName;
	}
	public String getNewUserRole() {
		return newUserRole;
	}
	public void setNewUserRole(String newUserRole) {
		this.newUserRole = newUserRole;
	}
	public String getNewUserPassword() {
		return newUserPassword;
	}
	public void setNewUserPassword(String newUserPassword) {
		this.newUserPassword = newUserPassword;
	}
	public String getNewUserCnfrmPassword() {
		return newUserCnfrmPassword;
	}
	public void setNewUserCnfrmPassword(String newUserCnfrmPassword) {
		this.newUserCnfrmPassword = newUserCnfrmPassword;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String execute() throws Exception{
		loginDB = new LoginDB();
		msg = loginDB.AddUser(newUserName, newUserRole, newUserPassword, newUserCnfrmPassword);
		return "success";
	}
}
