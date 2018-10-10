package com.hotel.service;

import java.util.List;

import com.hote.entity.Room;

public interface RoomService {
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
	public List<Room> findAll(int currentPage,int pageSize) throws Exception;
	
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
	public int add(Room room) throws Exception;
	/**
	 * ����Ų�ѯ
	 * @param room
	 * @param state
	 * @return
	 * @throws Exception
	 */
	public Room findById(int id) throws Exception;
	/**
	 * ��ѯ���з���
	 * @param room
	 * @param state
	 * @return
	 * @throws Exception
	 */
	public List<Room> findAndAll() throws Exception;
	
}
