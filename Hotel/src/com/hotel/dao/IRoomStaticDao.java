package com.hotel.dao;

import java.util.List;

import com.hote.entity.Roomstatic;



public interface IRoomStaticDao {
	/**
	 * ����ͷ�״̬��Ϣ
	 * @param rst
	 * @return
	 * @throws Exception
	 */
	public int save(Roomstatic rst) throws Exception;
	
	/**
	 * ���£�����ɾ�ͷ�״̬��Ϣ
	 * @param rst
	 * @return
	 * @throws Exception
	 */
    public int Update(Roomstatic rst) throws Exception;
    
    /**
     * ���ҿͷ�״̬��Ϣ
     * @return
     * @throws Exception
     */
    public List<Roomstatic> getFind() throws Exception;
}
