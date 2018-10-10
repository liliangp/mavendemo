<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="utf-8" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-acal=1" > 
<title></title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading" >
			<h3 class="panel-title">用户登录</h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" role="form" method="post" action="">
			    <div class="form-group">
					<div >
					    <label class="col-sm-2 control-label"></label>
						<h4 style="color:red">${err}</h4>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">用户名</label>
					<div class="col-sm-2">
						<input type="text" class="form-control" id="inputName" name="inputName"
							value="${name}" placeholder="请输入用户名">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-2">
						<input type="password" class="form-control" id="inputPassword" name="inputPassword"
							value="${password}" placeholder="请输入密码">
					</div>
				</div>
				<div class="form-group">
				    <label for="inputPassword" class="col-sm-2 control-label"></label>
					<div class="col-sm-2">
                         <input type="checkbox" class="btn btn-primary"  name="remember" value="1" />记住用户 </input>
                    </div>
				</div>
				<div class="form-group">
				    <label for="inputPassword" class="col-sm-2 control-label"></label>
					<div id="myButtons1" class="bs-example">
					    <input type="hidden" value="login" name="opt"></input>
						<button type="submit" class="btn btn-primary">登录</button>
						<!-- <a href="useraction.do" target="" class="btn btn-primary">注册</a> -->
					</div>
				</div>
			</form>
		</div>
</body>
</html>