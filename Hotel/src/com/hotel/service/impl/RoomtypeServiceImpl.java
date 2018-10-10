package com.hotel.service.impl;

import java.util.List;

import com.hote.dao.impl.RoomTypeDaoImpl;
import com.hote.entity.Room;
import com.hote.entity.Roomtype;
import com.hotel.dao.IRoomDao;
import com.hotel.dao.IRoomTypeDao;
import com.hotel.service.RoomtypeService;

public class RoomtypeServiceImpl implements RoomtypeService {
	private IRoomTypeDao roomtypeDao = new RoomTypeDaoImpl();

	@Override
	public List<Roomtype> findAlls() throws Exception {

		return roomtypeDao.findAll();
	}

	@Override
	public int insters(Roomtype type) throws Exception {

		return roomtypeDao.insters(type);
	}

	@Override
	public Roomtype findById(int id) throws Exception {

		return roomtypeDao.findById(id).get(0);
	}
}
