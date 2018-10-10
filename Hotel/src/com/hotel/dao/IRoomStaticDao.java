package com.hotel.dao;

import java.util.List;

import com.hote.entity.Roomstatic;



public interface IRoomStaticDao {
	/**
	 * 保存客房状态信息
	 * @param rst
	 * @return
	 * @throws Exception
	 */
	public int save(Roomstatic rst) throws Exception;
	
	/**
	 * 更新，增，删客房状态信息
	 * @param rst
	 * @return
	 * @throws Exception
	 */
    public int Update(Roomstatic rst) throws Exception;
    
    /**
     * 查找客房状态信息
     * @return
     * @throws Exception
     */
    public List<Roomstatic> getFind() throws Exception;
}
