package com.hotel.dao;

import java.util.List;

import com.hote.entity.User;

public interface IUserDao {
	/**
	 * ����¼���������ѯ
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
    public List<User> findLoginAndPassword(String userName,String password)throws Exception;
    
    /**
     * �������
     * @param user
     * @return
     * @throws Exception
     */
    public int insert(User user)throws Exception;
    
    /**
     * ���û�������
     * @param userName
     * @return
     * @throws Exception
     */
    public List<User> findLogin(String userName)throws Exception;
}
