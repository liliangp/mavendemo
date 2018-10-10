package com.hotel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hote.entity.Guest;
import com.hote.entity.Page;
import com.hote.entity.Room;
import com.hote.entity.Roomstatic;
import com.hote.entity.Roomtype;
import com.hotel.enums.Stata;
import com.hotel.service.GusetService;
import com.hotel.service.RoomtypeService;
import com.hotel.service.impl.GusetServiceImpl;
import com.hotel.service.impl.RoomtypeServiceImpl;
import com.hotel.vo.GuestVO;



/**
 * Servlet implementation class GuestController
 */
@WebServlet({"/action/guestController"})
public class GuestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RoomtypeService roomtypeService=new RoomtypeServiceImpl();
    private GusetService guestService=new GusetServiceImpl();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestController() {
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
		
		String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		request.setAttribute("currentTime", datetime);
		String opt=request.getParameter("opt");
		try {
		switch(opt){
		     case "regist":
		    	 this.regist( request,response);
		    	 break;
		     case "goUrl":
		    	 this.goUrl(request,response);
				break;
		     case "query":
		    	 this.findAnd(request,response);
		    	 break;
		     case "backUrl":
		    	 this.gobackUrl(request,response);
		    	 break;
		     case "checkuot":
		    	 this.checkuot(request,response);
		    	 break;
		     case "back":
		    	 this.back(request,response);
		    	 break;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	/**
	 * 登记
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	private void regist(HttpServletRequest request, HttpServletResponse response)throws Exception {
		//设置中文字
        request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
	    PrintWriter out=response.getWriter();
	     
	        //获取名字
	        String name=request.getParameter("name"); 
	        
	        //获取房间类型
	        String roomtype=request.getParameter("roomType");
	        
	        //获取房间
	        String roomId=request.getParameter("room");
	        
	        //获取入住日期
	        String resideDate=request.getParameter("indate");
	      
	        
	        //获取押金
	        String deposit=request.getParameter("deposit");
	       
	        
	        //获取身份证
	        String dataId=request.getParameter("cardid");
	        
	        //获取入住人数
	        String number=request.getParameter("number");
	       
	        
	        //实例化对象
	        Roomstatic roomStatic=new Roomstatic();
	        //获取房间状态
	        roomStatic.setStateId(Stata.FULL.getId());
	        
	        //实例化对象
	        Room room=new Room();
	        room.setRoomId(Integer.parseInt(roomId));
	        room.setRoomNum(Integer.parseInt(number));
	        
	        //设置房间状态
	        room.setRoomstatic(roomStatic);
	        
	        Guest guest=new Guest();
	        guest.setNames(name);
	        guest.setRoom(room);
	        guest.setResideDate(resideDate);
	        guest.setDeposit(Integer.parseInt(deposit));
	        guest.setDataId(dataId);
	       
	        int key=guestService.regist(guest);
	        
	        //按住键查询
	         guest=guestService.findId(key);
	        
	        //请求
	        request.setAttribute("guest",guest);
	        
	        //转发请求                                                                                                                      
	        request.getRequestDispatcher("../WEB-INF/userist.jsp").forward(request,response);
	    
	}
	
	/**
	 * 客户入住登记
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws Exception
	 */
	private void goUrl(HttpServletRequest request, HttpServletResponse response)throws ServletException, Exception {
		//设置中文字
        request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		 
		 List<Roomtype> list=roomtypeService.findAlls();
		//请求
		 request.setAttribute("Roomtypes", list);
		 //转发请求                                                                                                                      
	     request.getRequestDispatcher("../WEB-INF/register.jsp").forward(request,response);
		 
	}
	
	/**
	 * 查询入住客户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws Exception
	 */
	private void query(HttpServletRequest request, HttpServletResponse response)throws ServletException, Exception {
		
		 
		 List<Guest> list=guestService.findAlls();
		//请求
		 request.setAttribute("guest", list);
		 //转发请求                                                                                                                      
	     request.getRequestDispatcher("../WEB-INF/guestlist.jsp").forward(request,response);
		 
	}
	
	private void findAnd(HttpServletRequest request, HttpServletResponse response)throws ServletException, Exception{
		//设置中文字
        request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String name=request.getParameter("name");
		
		int room=-1,currentPage=1,pageSize=10;
		String strPage=request.getParameter("page");
		
		String strPageSize=request.getParameter("pageSize");
		
		String strRoom=request.getParameter("room");
		
		if(strRoom != null && strRoom.length()>0){
			room=Integer.parseInt(request.getParameter("room"));
		}
		if(strPage != null && strPage.length()>0){
			currentPage=Integer.parseInt(request.getParameter("page"));
		}
		if(strPageSize != null && strPageSize.length()>0){
			pageSize=Integer.parseInt(request.getParameter("pageSize"));
		}
		List<Guest> list=guestService.findAnd(name, room, currentPage, pageSize);
		int count=guestService.counts(name, room);
		Page<Guest> page=new Page<>(currentPage,pageSize,count,list);
		
		request.setAttribute("page",page);
		request.setAttribute("name",name);
		request.setAttribute("room",room);
		request.getRequestDispatcher("../WEB-INF/guestlist.jsp").forward(request,response);
		
	}
	/**
	 * 退房查询
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws Exception
	 */
	private void checkuot(HttpServletRequest request, HttpServletResponse response)throws ServletException, Exception {
		 String room=request.getParameter("room");
		 
		 GuestVO guestVO=guestService.findByRoom(room);
		//请求
		 request.setAttribute("guest", guestVO);
		 //转发请求                                                                                                                      
	     request.getRequestDispatcher("../WEB-INF/guestback.jsp").forward(request,response);
		 
	}
	/**
	 * 退房映射
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws Exception
	 */
	private void gobackUrl(HttpServletRequest request, HttpServletResponse response)throws ServletException, Exception {
		                                                                                                                
	     request.getRequestDispatcher("../WEB-INF/guestback.jsp").forward(request,response);
		 
	}
	/**
	 * 退房
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws Exception
	 */
	private void back(HttpServletRequest request, HttpServletResponse response)throws ServletException, Exception {
		      int id=Integer.parseInt(request.getParameter("id"));
		      String leaveDate=request.getParameter("leaveDate");
		      int deposit=Integer.parseInt(request.getParameter("deposit"));
		      int pay=Integer.parseInt(request.getParameter("pay"));
		      int roomId=Integer.parseInt(request.getParameter("roomId"));
		      
		      Guest guest=new Guest();
		      guest.setId(id);
		      guest.setLeaveDate(leaveDate);
		      guest.setToalMoney(deposit+pay);
		      
		      Room room=new Room();
		      room.setRoomId(roomId);
		      room.setRoomNum(0);
		      
		      Roomstatic  roomStata=new Roomstatic();
		      roomStata.setStateId(Stata.EMPATY.getId());
		      room.setRoomstatic(roomStata);
		      
		      guestService.back(guest, room);
		      response.sendRedirect("?opt=backUrl");
		      
	     
		 
	}

}
