package com.hotel.dao;

import java.util.List;

import com.hote.entity.User;

public interface IUserDao {
	/**
	 * 按登录名和密码查询
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
    public List<User> findLoginAndPassword(String userName,String password)throws Exception;
    
    /**
     * 添加数据
     * @param user
     * @return
     * @throws Exception
     */
    public int insert(User user)throws Exception;
    
    /**
     * 按用户名查找
     * @param userName
     * @return
     * @throws Exception
     */
    public List<User> findLogin(String userName)throws Exception;
}
