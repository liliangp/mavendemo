package com.hotel.service;

import java.util.List;

import com.hote.entity.Room;
import com.hote.entity.Roomtype;

public interface RoomtypeService {
	/**
	 * 查找所有房间 
	 * @return
	 * @throws Exception
	 */
   public List<Roomtype> findAlls()throws Exception;
   /**
	  * 新增客房类型
	  * @param type
	  * @return
	  * @throws Exception
	  */
	 public int insters(Roomtype type) throws Exception;
	 /**
		 * 按编号查询
		 * @param id
		 * @return
		 * @throws Exception
		 */
    public Roomtype findById(int id) throws Exception;
}
