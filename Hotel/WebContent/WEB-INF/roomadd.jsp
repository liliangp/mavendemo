<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="utf-8" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-acal=1" >
<title>添加客房类型</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
    <link rel="stylesheet" href="../css/register.css">  
	<script type="text/javascript" src="../js/jquery.min.js" ></script>
	<script type="text/javascript" src="../js/bootstrap.min.js" ></script>
	<script type="text/javascript" src="../js/roomadd.js" ></script>
</head>
<body>
<section id="register">
<div class="panel panel-primary">
     <div class="panel-heading">
               添加客房
    </div>
	<form action="roomaction.do" method="post" name="myform" style="color:black">
	    <dl class="form-group" >
			<dt class="col-sm-3 control-Label" style="width:130px">ID：</dt>
			<dd >
			   <input id="id" class="form-control"  type="text" value="${room.roomId}" name="id" >
			</dd>
		</dl>
		<dl class="form-group">
			<dt class="col-sm-3 control-Label" style="width:130px">房间号：</dt>
			<dd > 
			   <input id="description" class="form-control" value="${room.description}"   type="text" 
			          required placeholder="7-333"  name="description" >
			</dd>
		</dl>
		<dl class="form-group">
			<dt class="col-sm-3 control-Label" style="width:130px">房间类型：</dt>
			<dd >
			  <select id="roomType"  name="roomType" style="height:30px">
				<option value="-1" class="form-control">==房间类型==</option>
				<c:if test="${not empty roomTypes }">
				  <c:forEach var="roomtype" items="${roomTypes}">
                     <option  ${roomtype.id eq room.roomtype.id?'selected':''} value="${roomtype.id }" >${roomtype.typeName}</option>
                  </c:forEach>
                </c:if>
                </select>
            </dd>
		</dl>
		<dl class="form-group">
			<dt class="col-sm-3 control-Label" style="width:130px"></dt>
			<input type="hidden" value="${opt}" name="opt"></input>
			<dd>
			  <button type="button" id="add" class="btn btn-primary btn-sm" style="width:50px">保存</button>
			  <button id="new" type="button" class="btn btn-primary btn-sm" style="width:50px">新建</button>
			 </dd>
		</dl>
		</form>
   </div>
		<!-- 模态框开始 -->
		  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" 
		       aria-hidden="true">
             <div class="modal-dialog" style="width:324px;height:324px">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                       <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                        <h4 class="modal-title" id="myModalLabel">新建客房类型</h4>
                   </div>
                   <div class="modal-footer">
                      <!-- 表单开始 -->
                         <dl>
			               <dt>编号</dt>
			               <dd><input id="id" min="1" type="number" name="id"/></dd>
		                 </dl>
		                 <dl>
			               <dt>单价</dt>
			               <dd><input id="price"  type="text" name="price" /></dd>
		                 </dl>
		                 <dl>
			               <dt>床位</dt>
			               <dd><input id="bed" min="1" type="number" name="bed"/></dd>
		                 </dl>
		                 <dl>
			               <dt>类型</dt>
			               <dd><input id="name"  type="text" name="name"/></dd>
		                 </dl>
                      <!-- 表单结束-->
                      <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                      <button id="ok" type="button" class="btn btn-primary">确定</button>
                  </div>
              </div><!-- /.modal-content -->
           </div><!-- /.modal-dialog -->
        </div>
		<!-- 模态框结束 -->
</section>
</body>
</html>