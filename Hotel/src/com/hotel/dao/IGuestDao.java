package com.hotel.dao;

import java.util.List;

import com.hote.entity.Guest;
import com.hote.entity.User;
import com.hotel.vo.GuestVO;



public interface IGuestDao {
	/**
	 * 插入客户登记信息
	 * @param guest
	 * @return
	 * @throws Exception
	 */
	public int insert(Guest guest) throws Exception;
	
	/**
	 * 按照客人的姓名查询信息
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<Guest> findByName(String name) throws Exception;
	
	/**
	 * 查询所有的信息
	 * @return
	 * @throws Exception
	 */
	public List<Guest> findAll() throws Exception;
	
	/**
	 * 按主键查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Guest> findId(int id) throws Exception;
	
	/**
	 * 按条件查询
	 * @param name
	 * @param room
	 * @param roomstatic
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Guest> findAnd(String name,int room,int start,int pageSize) throws Exception;
	
	/**
	 * 统计次数
	 * @param name
	 * @param room
	 * @return
	 * @throws Exception
	 */
	public int count(String name,int room) throws Exception;
	/**
	 * 退房查询 按房间号查询
	 * @return
	 * @throws Exception
	 */
	public List<GuestVO> findByRoom(String room) throws Exception;
	/**
	 * 退房修改
	 * @param name
	 * @param room
	 * @return
	 * @throws Exception
	 */
	public int update(String namresideDate,int toalMoney,int id) throws Exception;
}
