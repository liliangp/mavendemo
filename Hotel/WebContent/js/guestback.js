$(function(){
	
	
	 /**
	  * 计算应付
	  */
	 $("[name=other]").change(function(){
		 var change=$("[name=change]").val();
		 var other=$("[name=other]").val();
		 
		 var toalMoney=$("[name=toalMoney]").val();
		 var deposit=$("[name=deposit]").val();
		 
		 toalMoney=parseInt(toalMoney)+parseInt(other);
		 $("[name=toalMoney]").val(toalMoney);
		 
		 change=(parseInt(toalMoney)+parseInt(other))-parseInt(deposit);
		 $("[name=change]").val(change);
	 })
	 
	 /**
	  * 结算
	  */
	 $("#confirm").click(function(){
		 var receipt=$("[name=receipt]").val();
		 var pay=$("[name=pay]").val();
		 var zero=receipt-pay;
		 $("[name=zero]").val(zero);
	 })
	
});