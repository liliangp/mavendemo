<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="utf-8" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-acal=1" >
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/register.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/guestback.js"></script>
</head>
<body>
<body>
	<form action="guestController?opt=checkuot" method="post">
		<table class="table table-striped" style="color:10px">
			<tbody>
				<tr>
					<td>房间号</td>
					<td><input type="text" value="${room}" name="room"
						class="form-control" /></td>
					<td><button type="submit"  class="btn btn-default">查询</button></td>
				</tr>
			</tbody>
		</table>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>姓名</th>
					<th>身份证</th>
					<th>房间号</th>
					<th>入住人数</th>
					<th>入住日期</th>
					<th>退房日期</th>
					<th>单价</th>
					<th>押金</th>
					<th>其他</th>
					<th>总金额</th>
					<th>实付</th>
					<th>应付</th>
				</tr>
			</thead>
			<tbody>
			 <c:if test="${not empty guest }">
				<tr>
					<td>${guest.names }</td>
					<td>${guest.dataId }</td>
					<td>${guest.description }</td>
					<td>${guest.roomNum }</td>
					<td>${guest.resideDate }</td>
					<td>${guest.leaveDate }</td>
					<td>${guest.typePrice }</td>
					<td>${guest.deposit }</td>
					<td>${guest.other }</td>
					<td>${guest.toalMoney }</td>
					<td>${guest.pay }</td>
					<td>${guest.change }</td>
				</tr>
              </c:if>
			</tbody>
		</table>
	</form>
<section id="register" >
 <form action="guestController" method="post" name="myform" >
   <div class="panel panel-primary">
	<div class="modal-footer" style="color:black">
		<!-- 表单开始 -->
		<dl>
			<dt>单价</dt>
			<dd>
				<input type="text" value="${guest.typePrice }" name="typePrice" />
			</dd>
		</dl>
		<dl>
			<dt>押金</dt>
			<dd>
				<input  readonly value="${guest.deposit}" type="text" name="deposit" />
			</dd>
		</dl>
		<dl>
			<dt>费用</dt>
			<dd>
				<input readonly value="${guest.toalMoney}" type="text" name="toalMoney" />
			</dd>
		</dl>
		<dl>
			<dt>其他</dt>
			<dd>
				<input  type="text" name="other" value="0"/>
			</dd>
		</dl>
		<dl>
			<dt>应付</dt>
			<dd>
				<input  type="text" value="${guest.change }" name="change" />
			</dd>
		</dl>
		<dl>
			<dt>实付</dt>
			<dd>
				<input  type="text" value="0" name="pay" />
			</dd>
		</dl>
		<dl>
			<dt>实收</dt>
			<dd>
				<input  value="0" type="text" name="receipt" />
			</dd>
		</dl>
		<dl>
			<dt>找零</dt>
			<dd>
				<input  readonly type="text" name="zero" value="0"/>
			</dd>
		</dl>
		<dl>
			<dt></dt>
			<input type="hidden" value="${guest.id }" name="id"/>
			<input type="hidden" value="${guest.leaveDate }" name="leaveDate"/>
			<input type="hidden" value="back" name="opt"/>
			<input type="hidden" value="${guest.roomId }" name="roomId"/>
			<button id="confirm" type="button"  style="width:50px;color:red;float:left">结算</button>
		    <button type="submit" style="width:50px;float:left;margin-left:10px">提交</button>
		</dl>
       
       
	  </div>
	<!-- 表单结束-->
	
    </div>
  </form>
</section>
</body>
</html>