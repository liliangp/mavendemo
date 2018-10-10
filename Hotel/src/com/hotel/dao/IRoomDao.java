package com.hotel.dao;

import java.util.List;

import com.hote.entity.Room;



public interface IRoomDao {
	/**
	 * 按客房类型和状态查询
	 * @param room
	 * @param state
	 * @return
	 * @throws Exception
	 */
	public List<Room> findRoomType(int roomtype,int roomstatic) throws Exception;
	/**
	 * 查询所有房间、页数
	 * @param room
	 * @param state
	 * @return
	 * @throws Exception
	 */
	public List<Room> findAll(int start,int pageSize) throws Exception;
	/**
	 * 查询所有房间
	 * @param room
	 * @param state
	 * @return
	 * @throws Exception
	 */
	public List<Room> findAndAll() throws Exception;
	/**
	 * 按编号查询
	 * @param room
	 * @param state
	 * @return
	 * @throws Exception
	 */
	public List<Room> findById(int id) throws Exception;
	
	/**
	 * 统计总页数
	 * @return
	 * @throws Exception
	 */
	public int count()throws Exception;
	
	/**
	 * 修改入住状态入住及人数
	 * @param room
	 * @return
	 * @throws Exception
	 */
	public int Update(int roomNum,int roomstatic,int stateId) throws Exception;
	
	/**
	 * 修改客房信息
	 * @param room
	 * @return
	 * @throws Exception
	 */
	public int Update(String description,int roomtype,int roomId) throws Exception;
	
	/**
	 * 新增客房
	 * @param room
	 * @param state
	 * @return
	 * @throws Exception
	 */
	public int inster(Room room) throws Exception;
}
