package com.hotel.dao;

import java.util.List;

import com.hote.entity.Guest;
import com.hote.entity.User;
import com.hotel.vo.GuestVO;



public interface IGuestDao {
	/**
	 * ����ͻ��Ǽ���Ϣ
	 * @param guest
	 * @return
	 * @throws Exception
	 */
	public int insert(Guest guest) throws Exception;
	
	/**
	 * ���տ��˵�������ѯ��Ϣ
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<Guest> findByName(String name) throws Exception;
	
	/**
	 * ��ѯ���е���Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<Guest> findAll() throws Exception;
	
	/**
	 * ��������ѯ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Guest> findId(int id) throws Exception;
	
	/**
	 * ��������ѯ
	 * @param name
	 * @param room
	 * @param roomstatic
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Guest> findAnd(String name,int room,int start,int pageSize) throws Exception;
	
	/**
	 * ͳ�ƴ���
	 * @param name
	 * @param room
	 * @return
	 * @throws Exception
	 */
	public int count(String name,int room) throws Exception;
	/**
	 * �˷���ѯ ������Ų�ѯ
	 * @return
	 * @throws Exception
	 */
	public List<GuestVO> findByRoom(String room) throws Exception;
	/**
	 * �˷��޸�
	 * @param name
	 * @param room
	 * @return
	 * @throws Exception
	 */
	public int update(String namresideDate,int toalMoney,int id) throws Exception;
}
