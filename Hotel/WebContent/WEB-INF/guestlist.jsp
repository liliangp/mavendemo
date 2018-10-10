<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="utf-8" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-acal=1" >
<title>Insert title here</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
    <link rel="stylesheet" href="../css/register.css">
     <script type="text/javascript" src="../js/jquery.min.js" ></script>
     <script type="text/javascript" src="../js/bootstrap.min.js" ></script>
     <script type="text/javascript" src="../js/guestlist.js" ></script>
</head>
<body>
    <body>
     <form action="guestController?opt=query" method="post" >
		<table class="table table-striped">
			<tbody>
				<tr>
					<td style="width:55px">姓名</td>
					<td><input type="text" value="${name}" name="name"  id="username" class="form-control" 
					     style="width:180px"/></td>
					
					<td style="width:55px">房间</td>
					<td>
						<select id="room" name="room" class="form-control" style="width:200px" >
							<option value="-1" >==房间号==</option>
						</select>
					</td>
					<td><button type="button" id="query" class="btn btn-default">查询</button></td>
				</tr>
			</tbody>
		</table>
    <table class="table table-striped">
    <thead>
       <tr>
           <th>姓名</th>
           <th>身份证</th>
           <th>入住日期</th>
           <th>退房日期</th>
           <th>房间号</th>
           <th>总金额</th>
       </tr>
    </thead>
    <tbody>
         <c:if test="${not empty page.content}">
           <c:forEach var="guests" items="${page.content}">
              <tr>
                 <td>${guests.names}</td>
                 <td>${guests.dataId}</td>
                 <td>${guests.leaveDate}</td>
                 <td>${guests.resideDate}</td>
                 <td>${guests.room.description}</td>
                 <td>${guests.toalMoney}</td>
              </tr>
           </c:forEach> 
        </c:if>
    </tbody>
    </table>
      <p class="text-center">
                共
       <select id="myselect" name="pageSize">
       	  <option value=1 ${page.pageSize eq 1?"selected":""}>1</option>
          <option value=5 ${page.pageSize eq 5?"selected":""}>5</option>
          <option value=10 ${page.pageSize eq 10?"selected":""}>10</option>
          <option value=15 ${page.pageSize eq 15?"selected":""}>15</option>
          <option value=20 ${page.pageSize eq 20?"selected":""}>20</option>
       </select>
               条/页&nbsp;&nbsp;
               共${page.count}条/记录<totalpage>${page.totalPage}</totalpage>页&nbsp;&nbsp;
      <a href="javaScript:void(0)" id="frist">首页</a>&nbsp;&nbsp;
      <a href="javaScript:void(0)" id="prev">上一页</a>&nbsp;&nbsp;
      <a href="javaScript:void(0)" id="next">下一页</a>&nbsp;&nbsp;
      <a href="javaScript:void(0)" id="last">尾页</a>&nbsp;&nbsp;
      <input type="number" min="1" max="${page.totalPage}" value="${page.currentPage }" 
             style="width:40px" name="page">
      <input name="go" id="go" type="button" value="GO">
    </p>
  </form>
</body>
</html>