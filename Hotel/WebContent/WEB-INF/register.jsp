<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="utf-8" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-acal=1" >
<title>酒店入住</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
	<link rel="stylesheet" href="../css/register.css">
	<script type="text/javascript" src="../js/jquery.min.js" ></script>
	<script type="text/javascript" src="../js/register.js" ></script>
</head>  
<body>
<section id="register">
	<div class="panel panel-primary">
     <div class="panel-heading">
               客人入住登记
    </div>
	<form action="guestController" method="post" name="myform" style="color:black">
		<dl >
			<dt style="width:100px">姓名：</dt>
			<dd><input id="username" type="text" name="name"
				required
				pattern="[\u4e00-\u9fa5]{2,4}|[a-zA-Z]{4,20}" /></dd>
		</dl>
		<dl>
			<dt style="width:100px">房间类型：</dt>
			<dd><select id="roomType" name="roomType" style="height:30px">
				<option value="-1" >==房间类型==</option>
				<c:forEach var="roomtype" items="${Roomtypes}">
                    <option value="${roomtype.id}">${roomtype.typeName}</option>
                </c:forEach>
                </select>
            </dd>
		</dl>
		<dl>
			<dt style="width:100px">房间号：</dt>
			<dd><select id="room" name="room" style="height:30px">
				   <option value="-1" >==房间号==</option>
			   </select>
			</dd>
		</dl>
		<dl>
			<dt style="width:100px">人数：</dt>
			<dd><input id="number" name="number" type="number" min="1"/></dd>
		</dl>
		<dl>
			<dt style="width:100px">入住日期：</dt>
			<dd><input type="date" value="${currentTime}" name="indate"/><div id="pwd_prompt"></div></dd>
		</dl>
		<dl>
			<dt style="width:100px">押金：</dt>
			<dd><input id="deposit"  placeholder="300" name="deposit"
				required
				pattern="[0-9]{3,4}"/></dd>
		</dl>
		<dl>
			<dt style="width:100px">身份证：</dt>
			<dd><input id="cardId"  type="text" name="cardid"
				required
				pattern="[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}"/>
				<div id="mobile_prompt"/><div id="birth_prompt"></div></dd>
		</dl>
		<dl>
			<dt style="width:100px">&nbsp;</dt>
			<input type="hidden" value="regist" name="opt"></input>
			<dd><button type="submit" class="btn btn-primary btn-sm">登记</button></dd>
		</dl>
  </form>
  </div>
</section>
</body>
</html>