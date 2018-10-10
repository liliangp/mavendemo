package com.hotel.service.impl;

import java.util.List;

import com.hote.dao.impl.GuestDaoImpl;
import com.hote.dao.impl.RoomDaoImpl;
import com.hote.entity.Guest;
import com.hote.entity.Room;
import com.hotel.dao.IGuestDao;
import com.hotel.dao.IRoomDao;
import com.hotel.service.GusetService;
import com.hotel.vo.GuestVO;

public class GusetServiceImpl implements GusetService{
	private IGuestDao guestDao=new GuestDaoImpl();
    private IRoomDao  roomDao=new RoomDaoImpl();

	@Override
	public int regist(Guest guest) throws Exception {
		//修改客房登记
		roomDao.Update(guest.getRoom().getRoomNum(),guest.getRoom().getRoomstatic().getStateId(),guest.getRoom().getRoomId());
		return guestDao.insert(guest);
	}

	@Override
	public Guest findId(int id) throws Exception {
		Guest guest=new Guest();
		List<Guest> list=guestDao.findId(id);
		if(list.size()>0){
			guest=list.get(0);
		}
		 return guest;
	}

	@Override
	public List<Guest> findAlls() throws Exception {
		
		return guestDao.findAll();
	}

	@Override
	public int counts(String name, int room) throws Exception {
		
		return guestDao.count(name, room);
	}

	@Override
	public List<Guest> findAnd(String name, int room, int currentPage, int pageSize) throws Exception {
		int start=(currentPage-1)*pageSize;
		return guestDao.findAnd(name, room, start, pageSize);
	}

	@Override
	public GuestVO findByRoom(String room) throws Exception {
	    GuestVO guest=new GuestVO();
		List<GuestVO> list=guestDao.findByRoom(room);
		if(list.size()>0){
			guest=list.get(0);
		}
		 return guest;
		//return guestDao.findByRoom(room).get(0);
	}

	@Override
	public int back(Guest guest, Room room) throws Exception {
		int guestkey=guestDao.update(guest.getLeaveDate(), guest.getToalMoney(), guest.getId());
		int roomkey=roomDao.Update(room.getRoomNum(), room.getRoomstatic().getStateId(), room.getRoomId());
		return guestkey;
	}
	
	
}
