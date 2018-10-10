$(function() {
	
   $("#new").click(function(){
   	   $("#myModal").modal("show");
   })
   
    $("#ok").click(function() {
			var id = $("#myModal #id").val();
			var name = $("#myModal #name").val();
			var bed = $("#myModal  #bed").val();
			var price =$("#myModal #price").val();
			var roomType={
				id: id,
				name: name,
			    bed:bed,
				price: price
			};
			$.getJSON("roomtypeaction.do?opt=add", roomType, function(result) {
				$("#roomType").append("<option value='" + result.id + "'>" + result.typeName + "</option>");
			});
			
			//关闭模态框
			$("#myModal").modal("hide");
			$("#myModal:text").val("");
			
		})
		
        $("#add").click(function(){
        	$("form").submit();
        })
        
        
   })