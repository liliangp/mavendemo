$(function(){
	/**
	 * 自定义验证
	 */
	function addEventListenner(){
		var repassword=document.getElementById("repassword");
		    repassword.oninvalid=function(){
		    	this.setCustomValidity("密码不一致，请重新输入密码")
		    }
		    repassword.oninput=function(){
		    	this.setCustomValidity("");
		    }
	}
	
	addEventListenner();
	
	/**
	 * 确认密码
	 */
	function validityRepwd(){
		var repassword=document.getElementById("repassword");
		var pasword=document.getElementById("pasword");
		if(pasword.value!=repassword.value){
			repassword.oninvalid();
			return false;
		}else{
			repassword.oninput();
			return true;
		}
	}
	
	/**
	 * 验证密码
	 */
	function validityPassword(){
		var pasword=document.getElementById("pasword");
		if(pasword.validity.valueMissing){
			pasword.validity.setCustomValidity("请输入密码");
		}
		else if(pasword.validity.patternMismatch){
			pasword.setCustomValidity("密码由六个数字组成");
		}
		else{
			pasword.setCustomValidity("");
		}
	}
	
	/**
	 * 验证用户名
	 */
	function validityUserName(){
		var userName=document.getElementById("userName");
		if(userName.validity.valueMissing){
			userName.setCustomValidity("请输入用户名")
		}
		else if(userName.validity.patternMismatch){
			userName.setCustomValidity("用户名由4-8个字母组成")
		}
		else{
			userName.setCustomValidity("")
		}
	}
	
	
	$("form").click(function(){
		validityUserName();
		validityRepwd();
		validityPassword()
	})
});