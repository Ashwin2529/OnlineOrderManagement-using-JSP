
$(document).ready(()=>{$("#customerId").text("Welcome "+$("#hiddenUsrId").val())});

function viewitems(){
	var viewItemDetails="";
	$.ajax({
			type:"GET",
			url:"viewItm",
			success: function(result){
				viewItemDetails+="<h1>Available Items</h2><table><thead><tr><th>Item Id</th><th>Item Name</th><th>Item Role</th><th>Item Price</th><th>Item Quantity</th><th>Item Sales Count</th></tr></thead><tbody>";
				$.each(result.itembeanList, function() {					
					viewItemDetails += 
					"<tr>"+
						"<td>" + this.itemId + "</td>" + 
						"<td>" + this.itemName + "</td>" + 
						"<td>" + this.itemCategory + "</td>" +
						"<td>" + this.itemPrice + "</td>" +
						"<td>" + this.itemQuantity + "</td>" +
						"<td>" + this.itemSalesCnt + "</td>" +
					"</tr>";
			});
			viewItemDetails+="</tbody></table>";
			$("#customer_workplace").html(viewItemDetails);
	},
			error: function(result){
				alert("Sorry some error occured.");
			}
		});
}

function placeOrder(){
	var placeOrderDetails="<h1>Place Order</h2>";
	placeOrderDetails += "<label for='orderItemId'>Select Item Id to be ordered</label>"+
	"<select id='orderItemId' name='orderItemId'></select>"+
	"<input type='number' name='orderItemQuant' id='orderItemQuant' placeholder='Enter Order Item Quantity'>"+
	"<input type='text' name='itmCpn' id='itmCpn' placeholder='Enter Item Specific Coupon if Present'>"+
	"<button onclick='addToCart();' type='button'>Add to Cart</button>"+
	"<button onclick='ViewCart();' type='button'>View Cart</button>"+
	"<button onclick='cnfrmOrder();' type='button'>Confirm Order</button>"+
	"<div id='cartShow'></div>"+
	"<div id='billShow'></div>";
	$.ajax({
			type:"GET",
			url:"viewItm",
			success: function(result){
				var itmiddrpdwn="";
				$.each(result.itembeanList, function() {					
					itmiddrpdwn += "<option value='"+this.itemId+"'>" + this.itemName + "</option>";
			});
			$("#orderItemId").html(itmiddrpdwn);
		},
	});
	$("#customer_workplace").html(placeOrderDetails);
}
function addToCart(){
		var orderUsrId = $("#hiddenUsrId").val();
		var orderItemId = $("#orderItemId").val();
		var orderItemQuant = $("#orderItemQuant").val();
		var itmCpn = $("#itmCpn").val();
		$.ajax({
			type : "POST",
			url : "addCrt",
			data : "orderUsrId=" + orderUsrId + "&orderItemId=" + orderItemId + "&orderItemQuant=" + orderItemQuant + "&itmCpn=" + itmCpn,
			success : function(data) {
				var ht = data.msg;
				alert(ht);
			},
			error : function(data) {
				alert("Some error occured.");
			}
		});
}
function ViewCart(){
	var orderUsrId = $("#hiddenUsrId").val();
	$.ajax({
			type:"GET",
			url:"viewCart",
			data: "orderUsrId=" + orderUsrId,
			success: function(result){
				var tblData="<h1>Items in Cart</h2><table ><thead><tr><th>Order Id</th><th>Order User Id</th><th>Order Item Id</th><th>Order Item Quantity</th><th>Order Item Price</th><th>Order Item Date</th></tr></thead><tbody>";
				$.each(result.cartBeanList, function() {					
					tblData += 
					"<tr>"+
						"<td>" + this.order_id + "</td>" + 
						"<td>" + this.orderUsrId + "</td>" + 
						"<td>" + this.orderItemId + "</td>" +
						"<td>" + this.orderItemQuant + "</td>" +
						"<td>" + this.ordered_total_price + "</td>" +
						"<td>" + this.orderedDate + "</td>" +
					"</tr>";
			});
			tblData+="</tbody></table>";
			$("#cartShow").html(tblData);
	},
			error: function(result){
				alert("Sorry some error occured.");
			}
		})
}

function cnfrmOrder(){
	var cnfrm_ordr_details = "<input type='text' name='gnrlCpn' id='gnrlCpn' placeholder='Enter General Specific Coupon if Present'>"+
	"<button onclick='bill();' type='button'>Place Order</button>";
	$("#billShow").html(cnfrm_ordr_details);
}
function bill(){
		var orderUsrId = $("#hiddenUsrId").val();
		var gnrlCpn = $("#gnrlCpn").val();
		$.ajax({
			type : "POST",
			url : "billordr",
			data : "orderUsrId=" + orderUsrId + "&gnrlCpn=" + gnrlCpn,
			success : function(data) {
				var ht = data.msg;
				alert(ht);
			},
			error : function(data) {
				alert("Some error occured.");
			}
		});
}
function viewOrderHistory(){
	var orderUsrId = $("#hiddenUsrId").val();
	$.ajax({
			type:"GET",
			url:"viewOrders",
			data: "orderUsrId=" + orderUsrId,
			success: function(result){
				var tblData="<h1>Your Order History</h2><table ><thead><tr><th>Order Id</th><th>Order User Id</th><th>Order Item Id</th><th>Order Item Quantity</th><th>Order Item Price</th><th>Order Item Date</th></tr></thead><tbody>";
				$.each(result.orderBeanList, function() {					
					tblData += 
					"<tr>"+
						"<td>" + this.order_id + "</td>" + 
						"<td>" + this.orderUsrId + "</td>" + 
						"<td>" + this.orderItemId + "</td>" +
						"<td>" + this.orderItemQuant + "</td>" +
						"<td>" + this.ordered_total_price + "</td>" +
						"<td>" + this.orderedDate + "</td>" +
					"</tr>";
			});
			tblData+="</tbody></table>";
			$("#customer_workplace").html(tblData);
	},
			error: function(result){
				alert("Sorry some error occured.");
			}
		});
}

function adminForm(){
	$("#adminForm").show();
	$("#custForm").hide();
}

function custForm(){
	$("#custForm").show();
	$("#adminForm").hide();
}