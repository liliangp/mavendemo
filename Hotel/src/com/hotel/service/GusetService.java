package com.hotel.service;

import java.util.List;

import com.hote.entity.Guest;
import com.hote.entity.Room;
import com.hotel.vo.GuestVO;

public interface GusetService {
	
	/**
	 * 入住登记
	 * @param guest
	 * @return
	 * @throws Exception
	 */
	public int regist(Guest guest) throws Exception;
	/**
	 * 按主键查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Guest findId(int id) throws Exception;
	/**
	 * 查询所有的信息
	 * @return
	 * @throws Exception
	 */
	public List<Guest> findAlls() throws Exception;
	
	/**
	 * 统计次数
	 * @param name
	 * @param room
	 * @return
	 * @throws Exception
	 */
	public int counts(String name,int room) throws Exception;
	
	/**
	 * 按条件查询
	 * @param name
	 * @param room
	 * @param roomstatic
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Guest> findAnd(String name,int room,int currentPage,int pageSize) throws Exception;
	/**
	 * 按房间号查询
	 * @return
	 * @throws Exception
	 */
	public GuestVO findByRoom(String room) throws Exception;
	/**
	 * 退房
	 * @return
	 * @throws Exception
	 */
	public int back(Guest guest,Room room) throws Exception;
}
