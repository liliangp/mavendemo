package com.hotel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hote.entity.Guest;
import com.hote.entity.Page;
import com.hote.entity.Room;
import com.hote.entity.Roomtype;
import com.hotel.enums.Stata;
import com.hotel.service.RoomService;
import com.hotel.service.RoomtypeService;
import com.hotel.service.impl.RoomServiceImpl;
import com.hotel.service.impl.RoomtypeServiceImpl;

/**
 * Servlet implementation class RoomController
 */
@WebServlet("/action/roomaction.do")
public class RoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoomService roomService=new RoomServiceImpl();
	private RoomtypeService roomtypeService=new RoomtypeServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomController() {
        super();
        
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
	     case "list":
	    	 this.findAll( request,response);
	    	 break;
	     case "addurl":
	    	 this.goaddUrl( request,response);
	    	 break;
	     case "add":
	    	 this.add( request,response);
	    	 break;
	     case "editurl":
	    	 this.goEditUrl( request,response);
	    	 break;
	     case "edit":
	    	 this.edit( request,response);
	    	 break;
	     case "andALL":
	    	 this.findAndAll( request,response);
	    	 break;
	     case "type":
	    	 this.findByRoomType( request,response);
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
	 * 房间列表
	 * @throws ServletException
	 * @throws IOException
	 */
	private void findAll(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		//获取参数  当前页和页面大小
		int currentPage=1,pageSize=10;
		String inputCurrentPage=request.getParameter("page");
		String inputPageSize=request.getParameter("pageSize");
		if(inputCurrentPage != null){
			currentPage=Integer.parseInt(inputCurrentPage);
		}
		if(inputPageSize != null){
			pageSize=Integer.parseInt(inputPageSize);
		}
		try {
			//去页面内容
			List<Room> content=roomService.findAll(currentPage, pageSize);
			
			//获取总记录数
			int count=roomService.count();
			
			//封装数据到页面
			Page<Room> page=new Page<>(currentPage,pageSize,count,content);
			
			//转发数据
		    request.setAttribute("page",page);
		    request.getRequestDispatcher("../WEB-INF/roomlist.jsp").forward(request,response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	/**
	 * 添加页面映射
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goaddUrl(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		try {
			List<Roomtype> list=roomtypeService.findAlls();
			request.setAttribute("roomTypes", list);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		request.setAttribute("opt", "add");
		request.getRequestDispatcher("../WEB-INF/roomadd.jsp").forward(request,response);
	}
	/**
	 * 添加数据
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void add(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String description=request.getParameter("description");
	    int roomTypeId=Integer.parseInt(request.getParameter("roomType"));
	    
	    Room room=new Room();
	    room.setDescription(description);
	    
	    Roomtype roomType=new Roomtype();
	    roomType.setId(roomTypeId);
	    room.setRoomtype(roomType);
	    
	    try {
			roomService.add(room);
			response.sendRedirect("?opt=list");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	/**
	 * 修改页面映射
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goEditUrl(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		 int id=Integer.parseInt(request.getParameter("roomId"));
		try {
			//取客房类型
			List<Roomtype> list=roomtypeService.findAlls();
			request.setAttribute("roomTypes", list);
			
			//取修改的数据
			Room room=roomService.findById(id);
			
			request.setAttribute("room", room);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		request.setAttribute("opt", "edit");
		request.getRequestDispatcher("../WEB-INF/roomadd.jsp").forward(request,response);
	}
	/**
	 * 修改后添加数据
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void edit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String description=request.getParameter("description");
	    int roomTypeId=Integer.parseInt(request.getParameter("roomType"));
	    int roomId=Integer.parseInt(request.getParameter("id"));
	    
	    try {
	    	//修改数据
			roomService.Update(description, roomTypeId, roomId);
			response.sendRedirect("?opt=list");
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}
	/**
	 * 查询所有房间
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void findAndAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		try {
			List<Room> list=roomService.findAndAll();
			String json=JSON.toJSONString(list,SerializerFeature.PrettyFormat);
			out.print(json);
		} catch (Exception e) {
			
			throw new ServletException(e.getMessage());
		}
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
     private void findByRoomType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 int roomType=Integer.parseInt(request.getParameter("roomType"));
    	 PrintWriter out=response.getWriter();
		try {
			List<Room> list=roomService.findRoomType(roomType, Stata.EMPATY.getId());
			String json=JSON.toJSONString(list,SerializerFeature.PrettyFormat);
			out.print(json);
		} catch (Exception e) {
			
			throw new ServletException(e.getMessage());
		}
	}

}
