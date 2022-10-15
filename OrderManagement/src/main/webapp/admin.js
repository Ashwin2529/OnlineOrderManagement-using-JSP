/* -------------------------------------------View--------------------------------- */

function viewCustomer(){
		$.ajax({
			type:"GET",
			url:"viewCust",
			success: function(result){
				var tblData="<h1>Customer Details</h2><table ><thead><tr><th>User Id</th><th>User Name</th><th>User Role</th></tr></thead><tbody>";
				$.each(result.beanList, function() {					
					tblData += 
					"<tr>"+
						"<td>" + this.userId + "</td>" + 
						"<td>" + this.userName + "</td>" + 
						"<td>" + this.userRole + "</td>" +
					"</tr>";
			});
			tblData+="</tbody></table>";
			$("#Details").html(tblData);
	},
			error: function(result){
				alert("Sorry some error occured.");
			}
		})
	}
	
function viewItem(){
		$.ajax({
			type:"GET",
			url:"viewItm",
			success: function(result){
				var itmtblData="<h1>Item Details</h2><table><thead><tr><th>Item Id</th><th>Item Name</th><th>Item Category</th><th>Item Price</th><th>Item Quantity</th><th>Item Sales Count</th></tr></thead><tbody>";
				$.each(result.itembeanList, function() {					
					itmtblData += 
					"<tr>"+
						"<td>" + this.itemId + "</td>" + 
						"<td>" + this.itemName + "</td>" + 
						"<td>" + this.itemCategory + "</td>" +
						"<td>" + this.itemPrice + "</td>" +
						"<td>" + this.itemQuantity + "</td>" +
						"<td>" + this.itemSalesCnt + "</td>" +
					"</tr>";
			});
			itmtblData+="</tbody></table>";
			$("#Details").html(itmtblData);
	},
			error: function(result){
				alert("Sorry some error occured.");
			}
		})
	}
function viewCoupon(){
		$.ajax({
			type:"GET",
			url:"viewCpn",
			success: function(result){
				var cpntblData="<h1>Coupon Details</h2><table><thead><tr><th>Coupon Name</th><th>Coupon Category</th><th>Coupon Value</th></tr></thead><tbody>";
				$.each(result.cpnbeanList, function() {					
					cpntblData += 
					"<tr>"+
						"<td>" + this.couponName + "</td>" + 
						"<td>" + this.couponCategory + "</td>" + 
						"<td>" + this.couponValue + "</td>" +
					"</tr>";
			});
			cpntblData+="</tbody></table>";
			$("#Details").html(cpntblData);
	},
			error: function(result){
				alert("Sorry some error occured.");
			}
		})
	}
	
	
/* -------------------------------------------Add--------------------------------- */

	
function addCustomer(){
	var user_register = "<h1>Add New Customer</h1>"+
	"<input type='text' name='newUserName' id='newUserName' placeholder='Enter New User Name'>"+
	"<label for='newUserRole'>Select User Role</label>"+
	"<select id='newUserRole' name='newUserRole'>"+
	"<option value='admin'>Admin</option>"+
	"<option value='customer'>Customer</option>"+
	"</select>"+
	"<input type='password' name='newUserPassword' id='newUserPassword' placeholder='Enter New Password'>"+
	"<input type='password' name='newUserCnfrmPassword' id='newUserCnfrmPassword' placeholder='Re-enter Password to Confirm'>"+
	"<button onclick='registerUser();' type='button'>Register</button>";
	$("#Details").html(user_register);
}
function registerUser() {
		var newUserName = $("#newUserName").val();
		var newUserRole = $("#newUserRole").val();
		var newUserPassword = $("#newUserPassword").val();
		var newUserCnfrmPassword = $("#newUserCnfrmPassword").val();
		$.ajax({
			type : "POST",
			url : "addCust",
			data : "newUserName=" + newUserName + "&newUserRole=" + newUserRole	+ "&newUserPassword=" + newUserPassword +"&newUserCnfrmPassword=" + newUserCnfrmPassword,
			success : function(data) {
				var ht = data.msg;
				alert(ht);
			},
			error : function(data) {
				alert("Some error occured.");
			}
		});
	}
function addItem(){
	var item_register = "<h1>Add New Item</h1>"+
	"<input type='text' name='newItemId' id='newItemId' placeholder='Enter New Item ID'>"+
	"<input type='text' name='newItemName' id='newItemName' placeholder='Enter New Item Name'>"+
	"<input type='text' name='newItemCategory' id='newItemCategory' placeholder='Enter New Item Category'>"+
	"<input type='text' name='newItemPrice' id='newItemPrice' placeholder='Enter New Item Price'>"+
	"<input type='number' name='newItemQuantity' id='newItemQuantity' placeholder='Enter New Item Quantity'>"+
	"<button onclick='registerItem();' type='button'>Register</button>";
	$("#Details").html(item_register);
}
function registerItem() {
		var newItemId = $("#newItemId").val();
		var newItemName = $("#newItemName").val();
		var newItemCategory = $("#newItemCategory").val();
		var newItemPrice = $("#newItemPrice").val();
		var newItemQuantity = $("#newItemQuantity").val();
		$.ajax({
			type : "POST",
			url : "addItm",
			data : "newItemId=" + newItemId + "&newItemName=" + newItemName + "&newItemCategory=" + newItemCategory	+ "&newItemPrice=" + newItemPrice +"&newItemQuantity=" + newItemQuantity,
			success : function(data) {
				var ht = data.msg;
				alert(ht);
			},
			error : function(data) {
				alert("Some error occured.");
			}
		});
	}

function addCoupon(){
	var item_register = "<h1>Add New Coupon</h1>"+
	"<input type='text' name='newCouponName' id='newCouponName' placeholder='Enter New Coupon Name'>"+
	"<label for='newCouponCategory'>Item Category</label>"+
	"<select id='newCouponCategory' name='newCouponCategory'></select>"+
	"<input type='number' name='newCouponValue' id='newCouponValue' placeholder='Enter New Coupon Value'>"+
	"<button onclick='registerCoupon();' type='button'>Register</button>";
	$("#Details").html(item_register);
	$.ajax({
			type:"GET",
			url:"viewItm",
			success: function(result){
				var ctgrydrpdwn="<option value='general'>General</option>";
				$.each(result.itembeanList, function() {					
					ctgrydrpdwn += "<option value='"+this.itemCategory+"'>" + this.itemCategory + "</option>";
			});
			$("#newCouponCategory").html(ctgrydrpdwn);
		},
	});
}
function registerCoupon() {
		var newCouponName = $("#newCouponName").val();
		var newCouponCategory = $("#newCouponCategory").val();
		var newCouponValue = $("#newCouponValue").val();
		
		$.ajax({
			type : "POST",
			url : "addCpn",
			data : "newCouponName=" + newCouponName + "&newCouponCategory=" + newCouponCategory + "&newCouponValue=" + newCouponValue,
			success : function(data) {
				var ht = data.msg;
				alert(ht);
			},
			error : function(data) {
				alert("Some error occured.");
			}
		});
	}

/* -------------------------------------------Update--------------------------------- */

function updateCustomer(){
	var update_cust = "<h1>Update Customer</h1>"+
	"<button onclick='editCust();' type='button'>Edit</button>"+
	"<button onclick='deleteCust();' type='button'>Delete</button>"+
	"<div id='updt'></div>";
	$("#Details").html(update_cust);
}


function editCust(){
	var dsply_usr = "<label for='updateUserId'>Select User Id</label>"+
	"<select id='updateUserId' name='updateUserId'></select>"+
	"<input type='text' name='updateUserName' id='updateUserName' placeholder='Enter New User Name'>"+
	"<label for='updateUserRole'>Select User Role</label>"+
	"<select id='updateUserRole' name='updateUserRole'>"+
	"<option value='admin'>Admin</option>"+
	"<option value='customer'>Customer</option>"+
	"</select>"+
	"<input type='password' name='updateUserPassword' id='updateUserPassword' placeholder='Enter New Password'>"+
	"<input type='password' name='updateUserCnfrmPassword' id='updateUserCnfrmPassword' placeholder='Re-enter Password to Confirm'>"+
	"<button onclick='updtUser();' type='button'>Register</button>";
	$.ajax({
			type:"GET",
			url:"viewCust",
			success: function(result){
				var usriddrpdwn="";
				$.each(result.beanList, function() {					
					usriddrpdwn += "<option value='"+this.userId+"'>" + this.userId + "</option>";
			});
			$("#updateUserId").html(usriddrpdwn);
		},
	});
	$("#updt").html(dsply_usr);
}

function updtUser(){
		var updateUserId = $("#updateUserId").val();
		var updateUserName = $("#updateUserName").val();
		var updateUserRole = $("#updateUserRole").val();
		var updateUserPassword = $("#updateUserPassword").val();
		var updateUserCnfrmPassword = $("#updateUserCnfrmPassword").val();
		$.ajax({
			type : "POST",
			url : "updtCust",
			data : "updateUserId=" + updateUserId + "&updateUserName=" + updateUserName + "&updateUserRole=" + updateUserRole	+ "&updateUserPassword=" + updateUserPassword +"&updateUserCnfrmPassword=" + updateUserCnfrmPassword,
			success : function(data) {
				var ht = data.msg;
				alert(ht);
			},
			error : function(data) {
				alert("Some error occured.");
			}
		});
}

function deleteCust(){
	var dlt_dsply_usr = "<label for='dltUsrId'>Select User Id to be Deleted</label>"+
	"<select id='dltUsrId' name='dltUsrId'></select>"+
	"<button onclick='delCust();' type='button'>Delete</button>";
	$.ajax({
			type:"GET",
			url:"viewCust",
			success: function(result){
				var dlt_usr="";
				$.each(result.beanList, function() {					
					dlt_usr += "<option value='"+this.userId+"'>" + this.userId + "</option>";
			});
			$("#dltUsrId").html(dlt_usr);
		},
	});
	$("#updt").html(dlt_dsply_usr);
}
function delCust(){
	var dltUsrId = $("#dltUsrId").val();
		$.ajax({
			type : "POST",
			url : "dltUsr",
			data : "dltUsrId=" + dltUsrId,
			success : function(data) {
				var ht = data.msg;
				alert(ht);
			},
			error : function(data) {
				alert("Some error occured.");
			}
		});
}




function updateItem(){
	var update_itm = "<h1>Update Item</h1>"+
	"<button onclick='editItm();' type='button'>Edit</button>"+
	"<button onclick='deleteItm();' type='button'>Delete</button>"+
	"<div id='updt'></div>";
	$("#Details").html(update_itm);
}

function deleteItm(){
	var dlt_dsply_itm = "<label for='dltItemId'>Select Item Id to be Deleted</label>"+
	"<select id='dltItemId' name='dltItemId'></select>"+
	"<button onclick='delItm();' type='button'>Delete</button>";
	$.ajax({
			type:"GET",
			url:"viewItm",
			success: function(result){
				var dlt_itm="";
				$.each(result.itembeanList, function() {					
					dlt_itm += "<option value='"+this.itemId+"'>" + this.itemId + "</option>";
			});
			$("#dltItemId").html(dlt_itm);
		},
	});
	$("#updt").html(dlt_dsply_itm);
}
function delItm(){
	var dltItemId = $("#dltItemId").val();
		$.ajax({
			type : "POST",
			url : "dltItm",
			data : "dltItemId=" + dltItemId,
			success : function(data) {
				var ht = data.msg;
				alert(ht);
			},
			error : function(data) {
				alert("Some error occured.");
			}
		});
}

function editItm(){
	var dsply_itm = "<label for='updtItemId'>Select Item Id</label>"+
	"<select id='updtItemId' name='updtItemId'></select>"+
	"<input type='text' name='updtItemName' id='updtItemName' placeholder='Enter New Item Name'>"+
	"<label for='updtItemCategory'>Select Item Category</label>"+
	"<select id='updtItemCategory' name='updtItemCategory'></select>"+
	"<input type='text' name='updtItemPrice' id='updtItemPrice' placeholder='Enter New Item Price'>"+
	"<input type='number' name='updtItemQuantity' id='updtItemQuantity' placeholder='Enter new Item Quantity'>"+
	"<button onclick='updtItm();' type='button'>Register</button>";
	$.ajax({
			type:"GET",
			url:"viewItm",
			success: function(result){
				var itmiddrpdwn="";
				$.each(result.itembeanList, function() {					
					itmiddrpdwn += "<option value='"+this.itemId+"'>" + this.itemId + "</option>";
			});
			$("#updtItemId").html(itmiddrpdwn);
		},
	});
	$.ajax({
			type:"GET",
			url:"viewItm",
			success: function(result){
				var itmiddrpdwn="";
				$.each(result.itembeanList, function() {					
					itmiddrpdwn += "<option value='"+this.itemCategory+"'>" + this.itemCategory + "</option>";
			});
			$("#updtItemCategory").html(itmiddrpdwn);
		},
	});
	$("#updt").html(dsply_itm);
}
function updtItm(){
		var updtItemId = $("#updtItemId").val();
		var updtItemName = $("#updtItemName").val();
		var updtItemCategory = $("#updtItemCategory").val();
		var updtItemPrice = $("#updtItemPrice").val();
		var updtItemQuantity = $("#updtItemQuantity").val();
		$.ajax({
			type : "POST",
			url : "updtItm",
			data : "updtItemId=" + updtItemId + "&updtItemName=" + updtItemName + "&updtItemCategory=" + updtItemCategory	+ "&updtItemPrice=" + updtItemPrice +"&updtItemQuantity=" + updtItemQuantity,
			success : function(data) {
				var ht = data.msg;
				alert(ht);
			},
			error : function(data) {
				alert("Some error occured.");
			}
		});
}

function topSelling(){
	var topSellingTable="<h1>Top Selling Items</h2><table><thead><tr><th>Item Id</th><th>Item Name</th><th>Item Category</th><th>Item Price</th><th>Item Quantity</th><th>Item Sales Count</th></tr></thead><tbody>";
	$.ajax({
		type: "GET",
		url: "topSelling",
		success: function(result){
			$.each(result.topItembeanList, function() {					
					topSellingTable += 
					"<tr>"+
						"<td>" + this.itemId + "</td>" + 
						"<td>" + this.itemName + "</td>" + 
						"<td>" + this.itemCategory + "</td>" +
						"<td>" + this.itemPrice + "</td>" +
						"<td>" + this.itemQuantity + "</td>" +
						"<td>" + this.itemSalesCnt + "</td>" +
					"</tr>";
			});
			topSellingTable+="</tbody></table>";
			$("#Details").html(topSellingTable);
		},
		error: function(data){
			alert("Some error occured.");
		}
	});
}