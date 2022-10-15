package com.onlineordermanagement.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.onlineordermanagement.bean.Couponbean;
import com.onlineordermanagement.dao.LoginDB;
import com.opensymphony.xwork2.ActionSupport;

public class ViewCouponDetails extends ActionSupport{
	private static final long serialVersionUID = 1L;
	ResultSet rs = null;
	Couponbean coupnBean = null;
	List<Couponbean> cpnbeanList = null;
	LoginDB loginDB = new LoginDB();
	
	public String execute()throws Exception {
		cpnbeanList = new ArrayList<>();
		rs = loginDB.viewCoupon();
		while(rs.next()) {
			coupnBean = new Couponbean();
			coupnBean.setCouponName(rs.getString("coupon_name"));
			coupnBean.setCouponCategory(rs.getString("coupon_category"));
			coupnBean.setCouponValue(rs.getInt("coupon_value"));
			cpnbeanList.add(coupnBean);
		}
		return "CouponDetails";
	}

	public List<Couponbean> getCpnbeanList() {
		return cpnbeanList;
	}

	public void setCpnbeanList(List<Couponbean> cpnbeanList) {
		this.cpnbeanList = cpnbeanList;
	}
	
}
