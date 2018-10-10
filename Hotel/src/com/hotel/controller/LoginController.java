package com.hotel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hote.entity.User;
import com.hotel.service.UserService;
import com.hotel.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/loginaction.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService=new UserServiceImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opt = request.getParameter("opt");
		if(opt==null){
			opt="url";
		}
		switch (opt) {	 
	        case "login":
		          this.login(request, response);
		          break;
	        case "url":
	        	  this.url(request, response);
		          break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * 映射登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void url(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String name="",password="";
		   //读取cookie
		   Cookie[] cookies=request.getCookies();
		   //当cookies不为空时读取信息 
		    if(cookies!=null){
		    	for(int i=0;i<cookies.length;i++){
		    		if(cookies[i].getName().equals("name")){
		    			name=cookies[i].getValue();
		    		} 
		    		else if(cookies[i].getName().equals("password")){
		    			password=cookies[i].getValue();
		    		}
		    	}
		    }
		    request.setAttribute("name", name);
		    request.setAttribute("password", password);
		    request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}
	/**
	 * 用户 登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws Exception
	 */
   private void login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
	    //
	    String name=request.getParameter("inputName"); 
	    String password=request.getParameter("inputPassword");
	    String remember=request.getParameter("remember");
	    
	    //链接数据库
	    List<User> list;
		try {
			list = userService.logins(name,password);
			if(list.size()>0){
		    	//写session
		    	HttpSession session=request.getSession();
		    	//登录标记 登录标记 
		    	session.setAttribute("login", name);
		    	session.setMaxInactiveInterval(5*60);
		    	
		    	if(remember!=null && remember.equals("1")){
		    		//创建cookie
		    		Cookie cookieName=new Cookie("name",name);
		    		Cookie cookiePassword=new Cookie("password",password);
		    		
		    		//生命周期
		    		cookieName.setMaxAge(1*24*60*60);
		    		cookiePassword.setMaxAge(1*24*60*60);
		    		
		    		//写入cookie
		    		response.addCookie(cookieName);
		    		response.addCookie(cookiePassword);
		    	}
		    	//成功跳转页面
		    	request.getRequestDispatcher("WEB-INF/main.html").forward(request, response);
		    	
		    }else{
		    	request.setAttribute("err", "用户名或密码错误，请重新输入");
		    	//失败跳转页面
		    	request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
		    }
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	    
	    
   }

}
