package com.hotel.service;

import java.util.List;

import com.hote.entity.Room;
import com.hote.entity.Roomtype;

public interface RoomtypeService {
	/**
	 * �������з��� 
	 * @return
	 * @throws Exception
	 */
   public List<Roomtype> findAlls()throws Exception;
   /**
	  * �����ͷ�����
	  * @param type
	  * @return
	  * @throws Exception
	  */
	 public int insters(Roomtype type) throws Exception;
	 /**
		 * ����Ų�ѯ
		 * @param id
		 * @return
		 * @throws Exception
		 */
    public Roomtype findById(int id) throws Exception;
}
