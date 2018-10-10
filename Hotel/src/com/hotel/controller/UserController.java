package com.hotel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hote.entity.User;

import com.hotel.dao.IUserDao;
import com.hotel.service.UserService;
import com.hotel.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/useraction.do")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 //注入
	  private  UserService userService=new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opt = request.getParameter("opt");
		if(opt==null){
			opt="urls";
		}
		try {
			switch (opt) {
			// 注册
			case "add":
				this.regist(request, response);
				break;
			case "uls":
				this.url(request, response);
				break;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
   /**
    * 用户注册
    * @param request
    * @param response
    * @return
    * @throws ServletException
    * @throws Exception
    */
   private void regist(HttpServletRequest request, HttpServletResponse response)throws ServletException, Exception{
	    String name=request.getParameter("name"); 
	    String password=request.getParameter("password");
	    User user=new User(name, password);
	    userService.regist(user);
	    response.sendRedirect("WEB-INF/login.jsp");
	   
   }
   /**
	 * 映射
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
		    request.getRequestDispatcher("WEB-INF/regist.jsp").forward(request, response);
	}

}