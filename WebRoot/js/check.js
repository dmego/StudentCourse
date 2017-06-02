function checkUser(){
	var iuserid = document.getElementById("iuserid").value;
	var iusername = document.getElementById("iusername").value;
	var ipassword = document.getElementById("ipassword").value;
	var iuserphole = document.getElementById("iuserphole").value;
	if(iuserid ==="" || iusername == "" || iuserphole == "" || ipassword == ""){
		alert("请检查参数是否全部设置!");
		return false;
	}else if(isNaN(iuserphole) || iuserphole.length != 11){
		alert("电话设置有误!");
		return false;
	}
	return true;
}
 function checkOrder(){
	 	var iorderNum = document.getElementById("iorderNum").value;
		var isumDish = document.getElementById("isumDish").value;
		var isumPrice = document.getElementById("isumPrice").value;
		var iorderTime = document.getElementById("iorderTime").value;
		var iorderAddress = document.getElementById("iorderAddress").value;
		if(iorderNum == "" || isumDish == "" || isumPrice == "" || iorderTime == "" || iorderAddress == ""){
			alert("请检查参数是否全部设置!");
			return false;
		}else if(isNaN(isumDish)  ){
			alert("菜品总数量设置有误!");
			return false;
		}else if(isNaN(isumPrice)){
			alert("订单总价格设置有误!");
			return false;
		}
		return true;
 }
 
 function checkMenu(){
	 	var imenuNum = document.getElementById("imenuNum").value;
		var imenuName = document.getElementById("imenuName").value;
		var imenuPrice = document.getElementById("imenuPrice").value;
		if(imenuNum ==="" || imenuName == "" || imenuPrice == ""){
			alert("请检查参数是否全部设置!");
			return false;
		}else if(isNaN(imenuPrice)){
			alert("价格设置有误!");
			return false;
		}
		return true;
 }
 
 function checkLogin(){
	 var iusername = document.getElementById("iusername").value;
	 var ipassword = document.getElementById("ipassword").value;
	 if(iusername == "" || ipassword == ""){
		 alert("请检查参数是否全部设置!");
			return false;
	 }
	 return true;
 }