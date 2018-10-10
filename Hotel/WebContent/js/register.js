$(function(){
	
	$("#roomType").change(function() {
		var idx = $(this).find("option:selected").val();
		$.getJSON("roomaction.do", {opt: "type",roomType: idx}, function(result) {

			//清空
			$("#room").empty(); 
			$("#room").append('<option value="-1">==客房地址==</option>');
			for(var i = 0; i < result.length; i++) {
				var opt = '<option value="' + result[i].roomId + '">' + result[i].description + '</option>';
				$("#room").append(opt);
			}

		});
	})
    	 /**
	      * 注册自定义验证房间类型
	      */
	     function addEventListenner(){
            var roomtype =document.getElementById("roomType");
	            roomtype.oninvalid=function(){
			    roomtype.setCustomValidity("请选择房间类型");
	        } 
	          roomtype.oninput=function(){
			  roomtype.setCustomValidity("");
	       }
	}
	addEventListenner();
		
        
	/**
	 * 验证用户名名字
	 */
	function validityUserName(){
		var username =document.getElementById("username");
    	if(username.validity.valueMissing) {
    		
        	username.setCustomValidity("名字不能为空");		
	    } 
	    else if(username.validity.patternMismatch){
	    	
             username.setCustomValidity("用户名由2~3各汉字组成或20个字母组成");
		}else{
			username.setCustomValidity("");
		}
	}
	
	/**
     * 验证房间类型
     */
	function validityroomType(){
        var roomtype =document.getElementById("roomType");
    	if(roomtype.value<0) {
        	roomtype.oninvalid();
			return false;
	    } else{
             roomtype.oninput();
			 return true;
		}
	}
	
	/**
	 * 验证身份证
	 */
	function validityCardId(){
		var cardId=document.getElementById("cardId");
		if(cardId.validity.valueMissing){
			cardId.setCustomValidity("身份证不能为空");
		}
		else if(cardId.validity.patternMismatch){
			cardId.setCustomValidity("身份证由18位或15为组成");
		}else{
			cardId.setCustomValidity("");
		}
	}
	
	/**
	 * 验证押金
	 */
	function validityDeposit(){
		var deposit=document.getElementById("deposit");
		if(deposit.validity.valueMissing){
			deposit.setCustomValidity("请输入押金");
		}
		else if(deposit.validity.patternMismatch){
			deposit.setCustomValidity("输入错误");
		}else{
			deposit.setCustomValidity("");
		}
	}
	
	$("form").click(function(){
		validityUserName();
		validityroomType();
		validityCardId();
		validityDeposit()
	});
	
	
});