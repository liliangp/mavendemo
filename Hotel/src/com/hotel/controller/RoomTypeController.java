package com.hotel.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hote.entity.Roomtype;
import com.hotel.service.RoomtypeService;
import com.hotel.service.impl.RoomtypeServiceImpl;

/**
 * Servlet implementation class RoomTypeController
 */
@WebServlet("/action/roomtypeaction.do")
public class RoomTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoomtypeService roomTypeService=new RoomtypeServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomTypeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置中文字
        request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String opt=request.getParameter("opt");
		switch(opt){
		     case "add":
		    	 this.add(request,response);
		    	 break;
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
	 * 添加数据
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		int bed=Integer.parseInt(request.getParameter("bed"));
		int price=Integer.parseInt(request.getParameter("price"));
		Roomtype roomType=new Roomtype(id,name,bed,price);
		try {
			roomTypeService.insters(roomType);
			roomType=roomTypeService.findById(id);
			
			PrintWriter out=response.getWriter();
			
			String json=JSON.toJSONString(roomType,SerializerFeature.PrettyFormat);
			out.print(json);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
