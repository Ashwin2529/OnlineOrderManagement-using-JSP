package com.onlineordermanagement.action;

import com.onlineordermanagement.dao.LoginDB;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteItem extends ActionSupport{
	private static final long serialVersionUID = -3827439829486925185L;

	private int dltItemId;
	private String msg;
	
	public int getDltItemId() {
		return dltItemId;
	}
	public void setDltItemId(String dltItemId) {
		this.dltItemId = Integer.parseInt(dltItemId);
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}



	public String execute() throws Exception{
		LoginDB loginDB = new LoginDB();
		msg = loginDB.DeltItm(dltItemId);
		return "success";
	}

}
