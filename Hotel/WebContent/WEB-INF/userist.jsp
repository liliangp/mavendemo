<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="utf-8" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-acal=1" >
<title>Insert title here</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
</head>
<body>
    <table class="table table-striped">
    <thead>
       <tr>
           <th>姓名</th>
           <th>身份证</th>
           <th>房间号</th>
           <th>入住日期</th>
           <th>押金</th>  
       </tr>
    </thead>
    <tbody>
         <tr>
           <td>${guest.names}</td>
           <td>${guest.dataId}</td> 
           <td>${guest.room.description}</td> 
           <td>${guest.resideDate}</td>
           <td>${guest.deposit}</td> 
       </tr>
    </tbody>
    </table>
</body>
</html>