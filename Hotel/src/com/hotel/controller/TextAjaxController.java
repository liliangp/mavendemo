package com.hotel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hote.entity.User;
import com.hotel.service.UserService;
import com.hotel.service.impl.UserServiceImpl;

/**
 * Servlet implementation class TextAjaxController
 */
@WebServlet("/test.do")
public class TextAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TextAjaxController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String name = request.getParameter("name");
		Boolean used=false;
		//����ҵ��
		UserService userService=new UserServiceImpl();
		try {
			List<User> list=userService.findLogins(name);
			out.print(list);
			if(name.equals(list)) {
				used=true;
			} else {
				used=false;
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

}
