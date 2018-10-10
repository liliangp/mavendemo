package com.hotel.dao;

import java.util.List;

import com.hote.entity.Roomtype;

public interface IRoomTypeDao {
	
	 
	 /**
	  * 客房类型更新信息
	  * @param type
	  * @return
	  * @throws Exception
	  */
	 public int Update(Roomtype roomtype) throws Exception;
	 
	 /**
	  * 客房类型查找信息
	  * @return
	  * @throws Exception
	  */
	 public List<Roomtype> findAll() throws Exception;
	 
	 /**
	  * 新增客房类型
	  * @param type
	  * @return
	  * @throws Exception
	  */
	 public int insters(Roomtype roomtype) throws Exception;
	/**
	 * 按编号查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	 public List<Roomtype> findById(int id) throws Exception;
}
