/**
 * guestlist脚本文件
 */
$(function() {

	function initRoom() {
		
		$.getJSON("roomaction.do?opt=andALL", function(result) {
			// 清空
			$("#room").empty();

			$("#room").append('<option value="-1">==客房地址==</option>');
			for (var i = 0; i < result.length; i++) {

				var opt ="";
				if (room == result[i].roomId) {
					var opt = '<option selected value="' + result[i].roomId
							+ '">' + result[i].description + '</option>';
				} else {
					var opt = '<option value="' + result[i].roomId + '">'
							+ result[i].description + '</option>';
				}

				$("#room").append(opt);
			}

		})
	}
	
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
	 * 翻页
	 */
	$("#go").click(function() {
		$("form").submit();
	})
	
   
	
	/**
	 * 首页
	 */
	$("#frist").click(function() {
		var page = $("[name=page]").val();
		if (page > 1) {
			$("[name=page]").val(1);
			$("form").submit();
		}
	})

	/**
	 * 上一页
	 */
	$("#prev").click(function() {
		var page = $("[name=page]").val();
		if (page > 1) {
			$("[name=page]").val(page - 1);
			$("form").submit();
		}
	})
	/**
	 * 下一页
	 */
	$("#next").click(function() {
		var page = parseInt($("[name=page]").val());
		var last = $("totalpage").text();
		if (page < last) {
			$("[name=page]").val(page + 1);
			$("form").submit();
		}
	})

	/**
	 * 尾页
	 */
	$("#last").click(function() {
		var page = $("[name=page]").val();
		var last = $("totalpage").text();
		if (page < last) {
			$("[name=page]").val(last);
			$("form").submit();
		}
	})

	/**
	 * 提交表单
	 */
	$("#query").click(function() {
		$("form").submit();
	})
	
	// 执行
	initRoom();
	
	$("form").click(function(){
		validityUserName();
		//validityroomType();
		
	});
});