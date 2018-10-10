package com.hote.dao.impl;

import java.util.List;

import org.jbit.dao.BaseDao;

import com.hote.entity.Room;
import com.hotel.dao.IRoomDao;


public class RoomDaoImpl extends BaseDao implements IRoomDao{
    /**
     * 客房类型查询方法
     */
	@Override
	public List<Room> findRoomType(int roomtype,int roomstatic) throws Exception {
		String sql="SELECT t_roomId roomId,t_description description "
				+ "FROM t_room "
				+ "WHERE t_roomType=? AND t_roomState=?";
		Object[] params={roomtype,roomstatic};
		List<Room> list=this.executeQuery(sql, params, Room.class);
		return list;
	}
    
	/**
	 * 修改状态
	 */
	@Override
	public int Update(int roomNum,int roomstatic,int stateId) throws Exception {
		String sql="UPDATE t_room SET t_roomNum=?,t_roomState=? WHERE t_roomId=?";
		Object[] params={roomNum,roomstatic,stateId};
		return this.executeUpdate(sql, params);
	} 

	@Override
	public List<Room> findAll(int start,int pageSize) throws Exception {
		String sql="SELECT a.t_roomId roomId,a.t_description description,a.t_roomNum roomNum, "
				+ "c.t_stateName 'roomstatic.stateName', "
				+ "b.t_typeName 'roomtype.typeName' "
				+ "FROM  t_room a,t_roomstate c,t_roomtype b "
				+ "WHERE a.t_roomType=b.t_typeId "
				+ "AND   a.t_roomState=c.t_stateNameId "
				+ "ORDER BY a.t_roomId DESC "
				+ "LIMIT ?,?";	
		Object[] params={start,pageSize};
		return this.executeQuery(sql, params, Room.class);
	}

	@Override
	public int count() throws Exception {
		String sql="SELECT COUNT(t_roomId) FROM t_room ";
		return this.executeCount(sql, null);
	}

	@Override
	public int Update(String description, int roomtype, int roomId) throws Exception {
		String sql="UPDATE t_room SET t_description=?,t_roomType=? WHERE t_roomId=?";
		Object[] params={description,roomtype,roomId};
		return this.executeUpdate(sql, params);
	}
     
	@Override
	public int inster(Room room) throws Exception {
		String sql="INSERT INTO t_room(t_description,t_roomType) VALUES(?,?)";
		Object[] params={room.getDescription(),room.getRoomtype().getId()};
		return this.executeUpdate(sql, params);
	}

	@Override
	public List<Room> findById(int id) throws Exception {
		String sql="SELECT t_roomId roomId,t_description description,t_roomType 'roomtype.id' FROM t_room "
				+ "WHERE t_roomId=?";
		Object[] params={id};
		return this.executeQuery(sql, params, Room.class);
	}

	@Override
	public List<Room> findAndAll() throws Exception {
		String sql="SELECT t_roomId roomId,t_description description "
				+ "FROM  t_room ";
		return this.executeQuery(sql, null, Room.class);
	}

}
