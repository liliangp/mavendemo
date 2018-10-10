package com.hotel.dao;

import java.util.List;

import com.hote.entity.Room;



public interface IRoomDao {
	/**
	 * ���ͷ����ͺ�״̬��ѯ
	 * @param room
	 * @param state
	 * @return
	 * @throws Exception
	 */
	public List<Room> findRoomType(int roomtype,int roomstatic) throws Exception;
	/**
	 * ��ѯ���з��䡢ҳ��
	 * @param room
	 * @param state
	 * @return
	 * @throws Exception
	 */
	public List<Room> findAll(int start,int pageSize) throws Exception;
	/**
	 * ��ѯ���з���
	 * @param room
	 * @param state
	 * @return
	 * @throws Exception
	 */
	public List<Room> findAndAll() throws Exception;
	/**
	 * ����Ų�ѯ
	 * @param room
	 * @param state
	 * @return
	 * @throws Exception
	 */
	public List<Room> findById(int id) throws Exception;
	
	/**
	 * ͳ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public int count()throws Exception;
	
	/**
	 * �޸���ס״̬��ס������
	 * @param room
	 * @return
	 * @throws Exception
	 */
	public int Update(int roomNum,int roomstatic,int stateId) throws Exception;
	
	/**
	 * �޸Ŀͷ���Ϣ
	 * @param room
	 * @return
	 * @throws Exception
	 */
	public int Update(String description,int roomtype,int roomId) throws Exception;
	
	/**
	 * �����ͷ�
	 * @param room
	 * @param state
	 * @return
	 * @throws Exception
	 */
	public int inster(Room room) throws Exception;
}
