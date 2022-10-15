package com.onlineordermanagement.action;

import com.onlineordermanagement.dao.LoginDB;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteUser extends ActionSupport{
	private static final long serialVersionUID = -3827439829486925185L;

	private int dltUsrId;
	private String msg;
	
	public int getDltUsrId() {
		return dltUsrId;
	}
	public void setDltUsrId(String dltUsrId) {
		this.dltUsrId = Integer.parseInt(dltUsrId);
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String execute() throws Exception{
		LoginDB loginDB = new LoginDB();
		msg = loginDB.DeltUser(dltUsrId);
		return "success";
	}
}
