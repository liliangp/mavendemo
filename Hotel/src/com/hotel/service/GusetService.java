package com.hotel.service;

import java.util.List;

import com.hote.entity.Guest;
import com.hote.entity.Room;
import com.hotel.vo.GuestVO;

public interface GusetService {
	
	/**
	 * ��ס�Ǽ�
	 * @param guest
	 * @return
	 * @throws Exception
	 */
	public int regist(Guest guest) throws Exception;
	/**
	 * ��������ѯ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Guest findId(int id) throws Exception;
	/**
	 * ��ѯ���е���Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<Guest> findAlls() throws Exception;
	
	/**
	 * ͳ�ƴ���
	 * @param name
	 * @param room
	 * @return
	 * @throws Exception
	 */
	public int counts(String name,int room) throws Exception;
	
	/**
	 * ��������ѯ
	 * @param name
	 * @param room
	 * @param roomstatic
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Guest> findAnd(String name,int room,int currentPage,int pageSize) throws Exception;
	/**
	 * ������Ų�ѯ
	 * @return
	 * @throws Exception
	 */
	public GuestVO findByRoom(String room) throws Exception;
	/**
	 * �˷�
	 * @return
	 * @throws Exception
	 */
	public int back(Guest guest,Room room) throws Exception;
}
