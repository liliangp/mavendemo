package com.hote.dao.impl;

import java.util.List;

import org.jbit.dao.BaseDao;

import com.hote.entity.Roomstatic;
import com.hotel.dao.IRoomStaticDao;


public class RoomStaticDaoImpl extends BaseDao implements IRoomStaticDao{
	@Override
	public int save(Roomstatic rst) throws Exception {
		String sql="INSERT INTO t_roomstate(t_stateNameId,t_stateName) VALUES(?,?)";
		Object[] params={rst.getStateId(),rst.getStateName()};
		
		//调用更新方法getUpate
		int res=this.executeUpdate(sql, params);
		return res;
	}

	@Override
	public int Update(Roomstatic rst) throws Exception {
		return 0;
	}

	@Override
	public List<Roomstatic> getFind() throws Exception {
		String sql="";
		Object[] params=null;
		
		//调用查询方法getQuery
		List<Roomstatic> list=this.executeQuery(sql, params, Roomstatic.class);
		return list;
	}

}
