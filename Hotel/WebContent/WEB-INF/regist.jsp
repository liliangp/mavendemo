<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="utf-8" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-acal=1" >
<title>Insert title here</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <script type="text/javascript" src="js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="js/jquery.min.js" ></script>
    <script type="text/javascript" src="js/registeration.js" ></script>
</head>
	<body>
	  <div class="panel panel-primary">
	     <div class="panel-heading">
			<h3 class="panel-title">新用户注册</h3>
		 </div>
		 <div class="panel-body">
		 <form class="form-horizontal" role="form" method="post" action="">
		    <div class="form-group">
					<div >
					    <label class="col-sm-2 control-label"></label>
						<h4 style="color:red"></h4>
					</div>
				</div>
            <div class="form-group">
               <label for="firstname" class="col-sm-2 control-label">用户名:</label>
               <div class="col-sm-2">
                  <input type="text" class="form-control" id="userName" name="name" placeholder="请输入用户名"
                  	     value="${name}" required
				         pattern="[a-zA-Z]{4,8}">
				  <span style="color:red">${reuslt}</span>
               </div>
            </div>
            <div class="form-group">
               <label for="lastname" class="col-sm-2 control-label">输入密码:</label>
               <div class="col-sm-2">
                  <input type="password" class="form-control" name="password" id="pasword" placeholder="请输入密码"
                  	     value="${password}" required
				         pattern="\d{6}">
               </div>
            </div>
            <div class="form-group">
               <label for="lastname" class="col-sm-2 control-label">确认密码:</label>
               <div class="col-sm-2">
                  <input type="password" class="form-control" id="repassword" placeholder="">
                  <span id="msg" style="color: red;"></span>
               </div>
            </div>
           <div class="bs-example">
               <label for="lastname" class="col-sm-2 control-label"></label>
               <div class="bs-example">
                   <input type="hidden" value="add" name="opt"></input>
                   <button type="submit" class="btn btn-primary">注册</button>
                   <a href="loginaction.do" target="" class="btn btn-primary">登录</a>
               </div>
           </div>
          </div>
        </form>
       </div>
	</body>
</html>