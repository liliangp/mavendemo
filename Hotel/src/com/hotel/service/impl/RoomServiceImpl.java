package com.hotel.service.impl;

import java.util.List;

import com.hote.dao.impl.RoomDaoImpl;
import com.hote.entity.Room;

import com.hotel.dao.IRoomDao;
import com.hotel.service.RoomService;

public class RoomServiceImpl implements RoomService {
	 private IRoomDao roomDao=new RoomDaoImpl();

	@Override
	public List<Room> findRoomType(int roomtype, int roomstatic) throws Exception {
		
		return roomDao.findRoomType(roomtype, roomstatic);
	}

	@Override
	public List<Room> findAll(int currentPage, int pageSize) throws Exception {
		int start=(currentPage-1)*pageSize;
		return roomDao.findAll(start, pageSize);
	}

	@Override
	public int count() throws Exception {
		return roomDao.count();
	}

	@Override
	public int Update(int roomNum, int roomstatic, int stateId) throws Exception {
		
		return roomDao.Update(roomNum, roomstatic, stateId);
	}

	@Override
	public int Update(String description, int roomtype, int roomId) throws Exception {
		
		return roomDao.Update(description, roomtype, roomId);
	}

	@Override
	public int add(Room room) throws Exception {
		
		return roomDao.inster(room);
	}

	@Override
	public Room findById(int id) throws Exception {
		
		return roomDao.findById(id).get(0);
	}

	@Override
	public List<Room> findAndAll() throws Exception {
		
		return roomDao.findAndAll();
	}
	
   
}
