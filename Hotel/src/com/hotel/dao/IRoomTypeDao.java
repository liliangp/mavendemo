package com.hotel.dao;

import java.util.List;

import com.hote.entity.Roomtype;

public interface IRoomTypeDao {
	
	 
	 /**
	  * �ͷ����͸�����Ϣ
	  * @param type
	  * @return
	  * @throws Exception
	  */
	 public int Update(Roomtype roomtype) throws Exception;
	 
	 /**
	  * �ͷ����Ͳ�����Ϣ
	  * @return
	  * @throws Exception
	  */
	 public List<Roomtype> findAll() throws Exception;
	 
	 /**
	  * �����ͷ�����
	  * @param type
	  * @return
	  * @throws Exception
	  */
	 public int insters(Roomtype roomtype) throws Exception;
	/**
	 * ����Ų�ѯ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	 public List<Roomtype> findById(int id) throws Exception;
}
