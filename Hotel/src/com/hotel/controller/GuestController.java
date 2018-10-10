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
		//����������
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
	 * �Ǽ�
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	private void regist(HttpServletRequest request, HttpServletResponse response)throws Exception {
		//����������
        request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
	    PrintWriter out=response.getWriter();
	     
	        //��ȡ����
	        String name=request.getParameter("name"); 
	        
	        //��ȡ��������
	        String roomtype=request.getParameter("roomType");
	        
	        //��ȡ����
	        String roomId=request.getParameter("room");
	        
	        //��ȡ��ס����
	        String resideDate=request.getParameter("indate");
	      
	        
	        //��ȡѺ��
	        String deposit=request.getParameter("deposit");
	       
	        
	        //��ȡ���֤
	        String dataId=request.getParameter("cardid");
	        
	        //��ȡ��ס����
	        String number=request.getParameter("number");
	       
	        
	        //ʵ��������
	        Roomstatic roomStatic=new Roomstatic();
	        //��ȡ����״̬
	        roomStatic.setStateId(Stata.FULL.getId());
	        
	        //ʵ��������
	        Room room=new Room();
	        room.setRoomId(Integer.parseInt(roomId));
	        room.setRoomNum(Integer.parseInt(number));
	        
	        //���÷���״̬
	        room.setRoomstatic(roomStatic);
	        
	        Guest guest=new Guest();
	        guest.setNames(name);
	        guest.setRoom(room);
	        guest.setResideDate(resideDate);
	        guest.setDeposit(Integer.parseInt(deposit));
	        guest.setDataId(dataId);
	       
	        int key=guestService.regist(guest);
	        
	        //��ס����ѯ
	         guest=guestService.findId(key);
	        
	        //����
	        request.setAttribute("guest",guest);
	        
	        //ת������                                                                                                                      
	        request.getRequestDispatcher("../WEB-INF/userist.jsp").forward(request,response);
	    
	}
	
	/**
	 * �ͻ���ס�Ǽ�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws Exception
	 */
	private void goUrl(HttpServletRequest request, HttpServletResponse response)throws ServletException, Exception {
		//����������
        request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		 
		 List<Roomtype> list=roomtypeService.findAlls();
		//����
		 request.setAttribute("Roomtypes", list);
		 //ת������                                                                                                                      
	     request.getRequestDispatcher("../WEB-INF/register.jsp").forward(request,response);
		 
	}
	
	/**
	 * ��ѯ��ס�ͻ���Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws Exception
	 */
	private void query(HttpServletRequest request, HttpServletResponse response)throws ServletException, Exception {
		
		 
		 List<Guest> list=guestService.findAlls();
		//����
		 request.setAttribute("guest", list);
		 //ת������                                                                                                                      
	     request.getRequestDispatcher("../WEB-INF/guestlist.jsp").forward(request,response);
		 
	}
	
	private void findAnd(HttpServletRequest request, HttpServletResponse response)throws ServletException, Exception{
		//����������
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
	 * �˷���ѯ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws Exception
	 */
	private void checkuot(HttpServletRequest request, HttpServletResponse response)throws ServletException, Exception {
		 String room=request.getParameter("room");
		 
		 GuestVO guestVO=guestService.findByRoom(room);
		//����
		 request.setAttribute("guest", guestVO);
		 //ת������                                                                                                                      
	     request.getRequestDispatcher("../WEB-INF/guestback.jsp").forward(request,response);
		 
	}
	/**
	 * �˷�ӳ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws Exception
	 */
	private void gobackUrl(HttpServletRequest request, HttpServletResponse response)throws ServletException, Exception {
		                                                                                                                
	     request.getRequestDispatcher("../WEB-INF/guestback.jsp").forward(request,response);
		 
	}
	/**
	 * �˷�
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
