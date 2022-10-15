package com.onlineordermanagement.dao;

import java.sql.*;

import java.util.Date;

import com.onlineordermanagement.action.Encrypt;

public class LoginDB  {
	public static Statement statement;
	public static Connection connection() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/Shopping_Management","root","Ashwin_13");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	} 
	public boolean userAuthentication(int userId, String userPassword)throws Exception { 
		String getCredentialsQuery = "select user_password from user_details where user_id=? and user_password=? and user_role= 'admin'";
		PreparedStatement preparedStatement = connection().prepareStatement(getCredentialsQuery);
		preparedStatement.setInt(1, userId);
		preparedStatement.setString(2, userPassword);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}
	public boolean custAuthentication(int custId, String custPassword)throws Exception { 
		String getCredentialsQuery = "select user_password from user_details where user_id=? and user_password=? and user_role= 'customer'";
		PreparedStatement preparedStatement = connection().prepareStatement(getCredentialsQuery);
		preparedStatement.setInt(1, custId);
		preparedStatement.setString(2, custPassword);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}
	public ResultSet viewCust() throws Exception{
		ResultSet getCustDetails = null;
		String CustDetailsQuery = "select user_id, user_name, user_role from user_details";
		PreparedStatement preparedStatement = connection().prepareStatement(CustDetailsQuery);
		getCustDetails = preparedStatement.executeQuery();
		return getCustDetails;
	}
	public ResultSet viewItem() throws Exception{
		ResultSet getItemDetails = null;
		String ItemDetailsQuery = "select * from item_details";
		PreparedStatement preparedStatement = connection().prepareStatement(ItemDetailsQuery);
		getItemDetails = preparedStatement.executeQuery();
		return getItemDetails;
	}
	public ResultSet viewTopItem() throws Exception{
		ResultSet getTopItemDetails = null;
		String topItemDetailsQuery = "select * from item_details order by item_sales_count desc limit 3";
		PreparedStatement preparedStatement = connection().prepareStatement(topItemDetailsQuery);
		getTopItemDetails = preparedStatement.executeQuery();
		return getTopItemDetails;
	}
	public ResultSet viewCoupon() throws Exception{
		ResultSet getCouponDetails = null;
		String CouponDetailsQuery = "select coupon_name, coupon_category, coupon_value from coupons";
		PreparedStatement preparedStatement = connection().prepareStatement(CouponDetailsQuery);
		getCouponDetails = preparedStatement.executeQuery();
		return getCouponDetails;
	}
	public String AddUser(String newUserName, String newUserRole, String newUserPassword, String newUserCnfrmPassword) throws Exception{
		String ExistUserQuery = "select * from user_details where user_name=?";
		PreparedStatement preparedStatement1 = connection().prepareStatement(ExistUserQuery);
		preparedStatement1.setString(1, newUserName);
		ResultSet getExistUser = preparedStatement1.executeQuery();
		System.out.println(newUserPassword+" "+newUserCnfrmPassword);
		if(!getExistUser.next()) {
			if(newUserPassword.equals(newUserCnfrmPassword)) {
				Encrypt encrypt = new Encrypt();
				newUserPassword = encrypt.encrypt(newUserPassword);
				String addNewCustomerQuery = "insert into user_details values(NULL,?,?,?,NULL)";
				PreparedStatement preparedStatement2 = connection().prepareStatement(addNewCustomerQuery);
				preparedStatement2.setString(1, newUserName);
				preparedStatement2.setString(2, newUserPassword);
				preparedStatement2.setString(3, newUserRole);
				preparedStatement2.executeUpdate();
				return "User Added Successfully";
			}
			else {
				return "Password Not Match";
			}
		}
		else{
			return "Sorry User Exists";
		}
	}
	public String AddItem(int newItemId, String newItemName, String newItemCategory, float newItemPrice, int newItemQuantity) throws Exception{
		String ExistItemQuery = "select * from item_details where item_id=?";
		PreparedStatement preparedStatement1 = connection().prepareStatement(ExistItemQuery);
		preparedStatement1.setInt(1, newItemId);
		ResultSet getExistItem = preparedStatement1.executeQuery();
		if(!getExistItem.next()) {
			if(newItemPrice>0) {
				if(newItemQuantity>0) {
					String addNewItemQuery = "insert into item_details values(?, ?, ?, ?, ?, ?)";
					PreparedStatement preparedStatement2 = connection().prepareStatement(addNewItemQuery);
					preparedStatement2.setInt(1, newItemId);
					preparedStatement2.setString(2, newItemName);
					preparedStatement2.setString(3, newItemCategory);
					preparedStatement2.setFloat(4, newItemPrice);
					preparedStatement2.setInt(5, newItemQuantity);
					preparedStatement2.setInt(6, 0);
					preparedStatement2.executeUpdate();
					return "Item Added Successfully";
				}
				else {
					return "Please Enter a valid Quantity";
				}
			}
			else {
				return "Please Enter a valid Price";
			}
		}
		else{
			return "Sorry Item Exists";
		}
	}
	
	public String AddCpn(String newCouponName, String newCouponCategory, int newCouponValue) throws Exception{
		String ExistCpnQuery = "select * from coupons where coupon_name=?";
		PreparedStatement preparedStatement1 = connection().prepareStatement(ExistCpnQuery);
		preparedStatement1.setString(1, newCouponName);
		ResultSet getExistCpn = preparedStatement1.executeQuery();
		if(!getExistCpn.next()) {
			if(newCouponValue>0) {
					String addNewCpnQuery = "insert into coupons values(?, ?, ?)";
					PreparedStatement preparedStatement2 = connection().prepareStatement(addNewCpnQuery);
					preparedStatement2.setString(1, newCouponName);
					preparedStatement2.setString(2, newCouponCategory);
					preparedStatement2.setInt(3, newCouponValue);
					preparedStatement2.executeUpdate();
					return "Coupon Added Successfully";
			}
			else {
				return "Please Enter a valid Discount";
			}
		}
		else{
			return "Sorry Coupon Exists";
		}
	}
	public String UpdtUser(int updateUserId, String updateUserName, String updateUserRole, String updateUserPassword, String updateUserCnfrmPassword) throws Exception{
		String ExistUsrQuery = "select * from user_details where user_id=?";
		PreparedStatement preparedStatement1 = connection().prepareStatement(ExistUsrQuery);
		preparedStatement1.setInt(1, updateUserId);
		ResultSet getExistCpn = preparedStatement1.executeQuery();
		if(getExistCpn.next()) {
			if(updateUserPassword.equals(updateUserCnfrmPassword)) {
					Encrypt encrypt = new Encrypt();
					updateUserPassword = encrypt.encrypt(updateUserPassword);
					String addUpdtUsrQuery = "update user_details set user_name=?, user_password=?, user_role=? where user_id=?";
					PreparedStatement preparedStatement2 = connection().prepareStatement(addUpdtUsrQuery);
					preparedStatement2.setString(1, updateUserName);
					preparedStatement2.setString(2, updateUserPassword);
					preparedStatement2.setString(3, updateUserRole);
					preparedStatement2.setInt(4, updateUserId);
					preparedStatement2.executeUpdate();
					return "User Updated Successfully";
			}
			else {
				return "Password doesn't Match";
			}
		}
		else{
			return "Sorry User not Exist";
		}
	}
	public String DeltUser(int dltUsrId) throws Exception {
		String ExistUserQuery = "select * from user_details where user_id=?";
		PreparedStatement preparedStatement1 = connection().prepareStatement(ExistUserQuery);
		preparedStatement1.setInt(1, dltUsrId);
		ResultSet getExistUser = preparedStatement1.executeQuery();
		if(getExistUser.next()) {
			String dltUsrQuery = "delete from user_details where user_id=?";
			PreparedStatement preparedStatement2 = connection().prepareStatement(dltUsrQuery);
			preparedStatement2.setInt(1, dltUsrId);
			preparedStatement2.executeUpdate();
			return "User Deleted";
		}
		else {
			return "User not Found";
		}
	}
	public String UpdtItem(int updtItemId, String updtItemName, String updtItemCategory, float updtItemPrice, int updtItemQuantity) throws Exception{
		String ExistItemQuery = "select * from item_details where item_id=?";
		PreparedStatement preparedStatement1 = connection().prepareStatement(ExistItemQuery);
		preparedStatement1.setInt(1, updtItemId);
		ResultSet getExistItem = preparedStatement1.executeQuery();
		if(getExistItem.next()) {
			if(updtItemPrice>0) {
				if(updtItemQuantity>0) {
					String updtNewItemQuery = "update item_details set item_name=?, item_category=?, item_price=?, item_quantity=? where item_id=?";
					PreparedStatement preparedStatement2 = connection().prepareStatement(updtNewItemQuery);
					preparedStatement2.setString(1, updtItemName);
					preparedStatement2.setString(2, updtItemCategory);
					preparedStatement2.setFloat(3, updtItemPrice);
					preparedStatement2.setInt(4, updtItemQuantity);
					preparedStatement2.setInt(5, updtItemId);
					preparedStatement2.executeUpdate();
					return "Item Updated Successfully";
				}
				else {
					return "Please Enter a valid Quantity";
				}
			}
			else {
				return "Please Enter a valid Price";
			}
		}
		else{
			return "Sorry Item Not Exists";
		}
	}
	public String DeltItm(int dltItemId) throws Exception {
		String ExistItmQuery = "select * from item_details where item_id=?";
		PreparedStatement preparedStatement1 = connection().prepareStatement(ExistItmQuery);
		preparedStatement1.setInt(1, dltItemId);
		ResultSet getExistItm = preparedStatement1.executeQuery();
		if(getExistItm.next()) {
			String dltItmQuery = "delete from item_details where item_id=?";
			PreparedStatement preparedStatement2 = connection().prepareStatement(dltItmQuery);
			preparedStatement2.setInt(1, dltItemId);
			preparedStatement2.executeUpdate();
			return "Item Deleted";
		}
		else {
			return "Item not Found";
		}
	}
	public String addToCart(int orderUsrId, int orderItemId, int orderItemQuant, String itmCpn) throws Exception {
		statement = connection().createStatement();
		int itemstockcount = itemAvailableQuantity(orderItemId);
		int itemsalescount = itemSalesCount(orderItemId);
		ResultSet lastOrderId = statement.executeQuery("select order_id from order_history order by order_id desc limit 1");
		int order_id=0;
		if(lastOrderId.next()) {
			order_id=lastOrderId.getInt("order_id")+1;
		}
		else {
			order_id = 1;
		}
		ResultSet get_ordered_price = statement.executeQuery("select item_price from Item_details where item_id ="+orderItemId);
		get_ordered_price.next();
		float ordered_item_price = get_ordered_price.getFloat("item_price");
		float ordered_total_price = orderItemQuant*ordered_item_price;
		if(itemstockcount!=0) {
			if(orderItemQuant<=itemstockcount && orderItemQuant!=0) {
				if(validCpnCheck(itmCpn)) {
					if(validCtgryCheck(orderItemId ,itmCpn)) {
						if(!usedCpn(orderUsrId, itmCpn)) {
							ResultSet get_item_discount = statement.executeQuery("select coupon_value from coupons where coupon_name='"+itmCpn+"'");
							get_item_discount.next();
							float item_discount = get_item_discount.getFloat("coupon_value")/100;
							ordered_total_price -= ordered_total_price*item_discount;
							Date date = new Date();
							String orderedDate = date.toString();
							statement.executeUpdate("insert into order_history values("+order_id+", "+orderUsrId+", "+orderItemId+", "+orderItemQuant+", "+ordered_total_price+", '"+orderedDate+"')");
							statement.executeUpdate("insert into temp_order_history values("+order_id+", "+orderUsrId+", "+orderItemId+", "+orderItemQuant+", "+ordered_total_price+", '"+orderedDate+"')");
							statement.executeUpdate("insert into applied_coupons values("+orderUsrId+", '"+itmCpn+"')");
							itemstockcount -= orderItemQuant;
							itemsalescount += orderItemQuant;
							statement.executeUpdate("update Item_details set item_quantity="+itemstockcount+", item_sales_count="+itemsalescount+" where item_id="+orderItemId);
							statement.executeUpdate("update user_details set used_coupons = JSON_ARRAY_APPEND(used_coupons, '$','"+itmCpn+"') where user_id="+orderUsrId);
							return "Coupon applied Successfully, Added to cart";
						}else {
							Date date = new Date();
							String orderedDate = date.toString();
							statement.executeUpdate("insert into order_history values("+order_id+", "+orderUsrId+", "+orderItemId+", "+orderItemQuant+", "+ordered_total_price+", '"+orderedDate+"')");
							statement.executeUpdate("insert into temp_order_history values("+order_id+", "+orderUsrId+", "+orderItemId+", "+orderItemQuant+", "+ordered_total_price+", '"+orderedDate+"')");
							itemstockcount -= orderItemQuant;
							itemsalescount += orderItemQuant;
							statement.executeUpdate("update Item_details set item_quantity="+itemstockcount+", item_sales_count="+itemsalescount+" where item_id="+orderItemId);
							return "Coupon already used, Added to cart";
						}
					}
					else {
						Date date = new Date();
						String orderedDate = date.toString();
						statement.executeUpdate("insert into order_history values("+order_id+", "+orderUsrId+", "+orderItemId+", "+orderItemQuant+", "+ordered_total_price+", '"+orderedDate+"')");
						statement.executeUpdate("insert into temp_order_history values("+order_id+", "+orderUsrId+", "+orderItemId+", "+orderItemQuant+", "+ordered_total_price+", '"+orderedDate+"')");
						itemstockcount -= orderItemQuant;
						itemsalescount += orderItemQuant;
						statement.executeUpdate("update Item_details set item_quantity="+itemstockcount+", item_sales_count="+itemsalescount+" where item_id="+orderItemId);
						return "Coupon will not apply for this category, Item added to cart";
					}
				}
				else {
					Date date = new Date();
					String orderedDate = date.toString();
					statement.executeUpdate("insert into order_history values("+order_id+", "+orderUsrId+", "+orderItemId+", "+orderItemQuant+", "+ordered_total_price+", '"+orderedDate+"')");
					statement.executeUpdate("insert into temp_order_history values("+order_id+", "+orderUsrId+", "+orderItemId+", "+orderItemQuant+", "+ordered_total_price+", '"+orderedDate+"')");
					itemstockcount -= orderItemQuant;
					itemsalescount += orderItemQuant;
					statement.executeUpdate("update Item_details set item_quantity="+itemstockcount+", item_sales_count="+itemsalescount+" where item_id="+orderItemId);
					return "Coupon not valid, Item added to cart";
				}
			}else {
				return "Quantity is more than stock count or Not Valid quantity";
			}
		}
		else {
			return "Item out of Stock";
		}
	}
	
	public String billOrder(int orderUsrId, String gnrlCpn) throws Exception{
		statement = connection().createStatement();
		ResultSet get_total = statement.executeQuery("select sum(total_price) from temp_order_history where user_id= "+orderUsrId);
		get_total.next();
		float total_ordered_item_price = get_total.getFloat(1);
		if(total_ordered_item_price!=0) {
		if(validCpnCheck(gnrlCpn)) {
			if(!usedCpn(orderUsrId, gnrlCpn)) {
				ResultSet get_coupon_value = statement.executeQuery("select coupon_value from coupons where coupon_name='"+gnrlCpn+"'");
				get_coupon_value.next();
				float coupon_value = get_coupon_value.getFloat("coupon_value")/100;
				total_ordered_item_price -= total_ordered_item_price*coupon_value;
				String result = "Coupon Applied Successful. Order Billed with Total Amount: Rs."+total_ordered_item_price;
				statement.executeUpdate("update user_details set used_coupons = JSON_ARRAY_APPEND(used_coupons, '$','"+gnrlCpn+"') where user_id="+orderUsrId);
				statement.executeUpdate("truncate table temp_order_history");
				return result; 
			}else {
				String result = "Coupon Already Used. Order Billed Successfully with Total Amount: Rs."+total_ordered_item_price;
				statement.executeUpdate("truncate table temp_order_history");
				return result;
			}
		}else {
			String result = "Coupon is not valid. Order Billed Successfully with Total Amount: Rs."+total_ordered_item_price;
			statement.executeUpdate("truncate table temp_order_history");
			return result;
		}
		}
		else {
			return "Cart is Empty. Please add items in cart";
		}
	}
	public int itemAvailableQuantity(int orderItemId) throws Exception{
		String ItmQuantsQuery = "select item_quantity from item_details where item_id=?";
		PreparedStatement preparedStatement1 = connection().prepareStatement(ItmQuantsQuery);
		preparedStatement1.setInt(1, orderItemId);
		ResultSet getItmQuants = preparedStatement1.executeQuery();
		getItmQuants.next();
		return getItmQuants.getInt("item_quantity");
	}
	public int itemSalesCount(int orderItemId) throws Exception{
		String ItmQuantsQuery = "select item_sales_count from item_details where item_id=?";
		PreparedStatement preparedStatement1 = connection().prepareStatement(ItmQuantsQuery);
		preparedStatement1.setInt(1, orderItemId);
		ResultSet getItmQuants = preparedStatement1.executeQuery();
		getItmQuants.next();
		return getItmQuants.getInt("item_sales_count");
	}
	public boolean validCpnCheck(String Cpn) throws Exception{
		String validCpnQuery = "select coupon_name from coupons where coupon_name=?";
		PreparedStatement preparedStatement1 = connection().prepareStatement(validCpnQuery);
		preparedStatement1.setString(1, Cpn);
		ResultSet getItmQuants = preparedStatement1.executeQuery();
		return getItmQuants.next();
	}
	public boolean validCtgryCheck(int orderItemId, String itmCpn) throws Exception{
		String getCpnCtgryQuery = "select coupon_category from coupons where coupon_name=?";
		String getItmCtgryQuery = "select item_category from item_details where item_id=?";
		PreparedStatement preparedStatement1 = connection().prepareStatement(getCpnCtgryQuery);
		preparedStatement1.setString(1, itmCpn);
		ResultSet getCpnCtgry = preparedStatement1.executeQuery();
		getCpnCtgry.next();
		PreparedStatement preparedStatement2 = connection().prepareStatement(getItmCtgryQuery);
		preparedStatement2.setInt(1, orderItemId);
		ResultSet getItmCtgry = preparedStatement2.executeQuery();
		getItmCtgry.next();
		return (getCpnCtgry.getString("coupon_category").equals(getItmCtgry.getString("item_category")));
	}
	public boolean usedCpn(int orderUsrId, String itmCpn) throws Exception{
		statement = connection().createStatement();
		itmCpn = "[\""+itmCpn+"\"]";
		String getUsrCpnQuery = "select * from user_details where JSON_CONTAINS(used_coupons, '"+itmCpn+"') and user_id="+orderUsrId+"";
		ResultSet getUsrCpn = statement.executeQuery(getUsrCpnQuery);
		return getUsrCpn.next();
	}
	public ResultSet viewCart(int custId) throws Exception{
		ResultSet getCartDetails = null;
		String CartDetailsQuery = "select * from temp_order_history where user_id=?";
		PreparedStatement preparedStatement = connection().prepareStatement(CartDetailsQuery);
		preparedStatement.setInt(1, custId);
		getCartDetails = preparedStatement.executeQuery();
		return getCartDetails;
	}
	public ResultSet orderHist(int orderUsrId) throws Exception{
		ResultSet getOrderDetails = null;
		String getOrderDetailsQuery = "select * from order_history where user_id=?";
		PreparedStatement preparedStatement = connection().prepareStatement(getOrderDetailsQuery);
		preparedStatement.setInt(1, orderUsrId);
		getOrderDetails = preparedStatement.executeQuery();
		return getOrderDetails;
	} 
}
