package com.hote.dao.impl;

import java.util.List;


import org.jbit.dao.BaseDao;
import com.hote.entity.Roomtype;
import com.hotel.dao.IRoomTypeDao;

public class RoomTypeDaoImpl extends BaseDao implements IRoomTypeDao{
	@Override
	public int Update(Roomtype roomtype) throws Exception {
		String sql="UPDATE t_roomtype SET t_typePrice=? WHERE t_typeId=?";
		Object[] params={roomtype.getTypePrice(),roomtype.getId()};
		return this.executeUpdate(sql, params);
	}

	@Override
	public List<Roomtype> findAll() throws Exception {
		String sql="SELECT t_typeId id,t_typeName typeName FROM t_roomtype";
		List<Roomtype> list=this.executeQuery(sql, null, Roomtype.class);
		return list; 
	}

	@Override
	public int insters(Roomtype roomtype) throws Exception {
		String sql="INSERT INTO t_roomtype(t_typeId,t_typePrice,t_typeNum,t_typeName) VALUES(?,?,?,?)";
		Object[] params={roomtype.getId(),roomtype.getTypePrice(),roomtype.getTypeNum(),roomtype.getTypeName()};
		return this.executeUpdate(sql, params);
		
	}

	@Override
	public List<Roomtype> findById(int id) throws Exception {
		String sql="SELECT t_typeId id,t_typeName typeName FROM t_roomtype WHERE t_typeId=?";
		Object[] params={id};
		List<Roomtype> list=this.executeQuery(sql, params, Roomtype.class);
		return list;
	}

}
