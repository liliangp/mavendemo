package com.hote.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.jbit.dao.BaseDao;

import com.hote.entity.Guest;
import com.hotel.dao.IGuestDao;
import com.hotel.vo.GuestVO;

public class GuestDaoImpl extends BaseDao implements IGuestDao {
	
	//重载查询的方法
	@Override
	public List<Guest> findByName(String name) throws Exception {
		String sql="SELECT t.g_name g_name,t.g_dataId g_dataId,t.g_roomId g_roomId,r.t_description 'room.t_description'"
				+ "FROM t_guest t JOIN t_room r ON (t.g_roomId=r.t_roomId)"
				+ "WHERE t.g_name LIKE CONCAT('%',?,'%')";
		Object[] params={name};
		List<Guest> list=this.executeQuery(sql, params,Guest.class);
		return list;
	}
    
	/**
	 * 查找全部
	 */
	@Override
	public List<Guest> findAll() throws Exception {
		String sql="SELECT a.g_name,a.g_dataId,a.g_resideDate, "
				+ "a.g_deposit,b.t_description 'room.description', "
				+ "c.t_typeName 'room.roomtype.typeName' "
				+ "FROM  t_guest a,t_room b,t_roomtype c "
				+ "WHERE a.g_roomId=b.t_roomId "
				+ "AND   b.t_roomType=c.t_typeId";
		List<Guest> list=this.executeQuery(sql, null,Guest.class);
		return list;
	}
    
	/**
	 * 插入客户登记信息
	 */
	@Override
	public int insert(Guest guest) throws Exception {
		String sql="INSERT INTO t_guest(g_name,g_dataId,g_roomId,g_resideDate,g_deposit) "
				+ "VALUES(?,?,?,?,?)";
		Object[] params= {guest.getNames(),guest.getDataId(),guest.getRoom().getRoomId(),guest.getResideDate(),guest.getDeposit()}; 
		return this.executeUpdate(sql, params);
		
	}
    
	/**
	 * 按主键查询
	 */
	@Override
	public List<Guest> findId(int id) throws Exception {
		String sql="SELECT a.g_name names,a.g_dataId dataId,a.g_resideDate resideDate, "
				+ "a.g_deposit deposit,b.t_description 'room.description' "
				+ "FROM t_guest a, t_room b WHERE a.g_roomId=b.t_roomId "
				+ "AND g_id=?";
		Object[] params={id};
		List<Guest> list=this.executeQuery(sql, params, Guest.class);
		return list;
	}
    
	/**
	 * 按条件查询
	 */
	@Override
	public List<Guest> findAnd(String name, int room, int start, int pageSize) throws Exception {
		String sql1=" AND a.g_name LIKE CONCAT('%',?,'%')";
		String sql2=" AND a.g_roomId=?";
		String pageSql=" LIMIT ?,?";
		String sql="SELECT a.g_name names,a.g_dataId dataId,a.g_leaveDate leaveDate,a.g_resideDate resideDate, "
				+ " a.g_toalMoney toalMoney,b.t_description 'room.description' "
				+ " FROM t_guest a, t_room b "
				+ " WHERE a.g_roomId=b.t_roomId "
				+ " AND 1=1";
		List params=new ArrayList();
		if(name !=null && name.length()>0){
			sql=sql+sql1;
			params.add(name);
		}
		if(room>0){
			sql=sql+sql2;
			params.add(room);
		}
		sql+=pageSql;
		params.add(start);
		params.add(pageSize);
		List<Guest> list=this.executeQuery(sql, params.toArray(), Guest.class);
		return list;
	}
    
	/**
	 * 统计页面次数
	 */
	@Override
	public int count(String name, int room) throws Exception {
		String sql="SELECT COUNT(g_id) FROM t_guest WHERE 1=1";
		String sql1=" AND g_name LIKE CONCAT('%',?,'%')";
		String sql2=" AND g_roomId=?";
		List params=new ArrayList();
		if(name !=null && name.length()>0){
			sql=sql+sql1;
			params.add(name);
		}
		if(room>0){
			sql=sql+sql2;
			params.add(room);
		}
		return this.executeCount(sql, params.toArray());
	}
    
	/**
	 * 退房管理查询
	 */
	@Override
	public List<GuestVO> findByRoom(String room) throws Exception {
		String sql="SELECT a.g_id id,a.g_name names,a.g_dataId dataId,"
				+ " a.g_resideDate resideDate,"
				+ " a.g_leaveDate leaveDate,a.g_deposit deposit,"
				+ " a.g_toalMoney toalMoney,"
				+ " b.t_description description,b.t_roomId roomId,"
				+ " b.t_roomNum roomNum,"
				+ " c.t_typePrice typePrice"
				+ " FROM   t_guest a,t_room b, t_roomtype c"
				+ " WHERE  a.g_roomId=b.t_roomId"
				+ " AND    b.t_roomType=c.t_typeId"
				+ " AND    a.g_leaveDate IS NULL"
				+ " AND    b.t_description=?";
		Object[] params={room};
		
		return this.executeQuery(sql, params, GuestVO.class);
	}

	@Override
	public int update(String resideDate, int toalMoney,int id) throws Exception {
		String sql="UPDATE t_guest SET g_leaveDate=?,g_toalMoney=?"
				+ " WHERE g_id=?";
		Object[] params={resideDate,toalMoney,id};
		return this.executeUpdate(sql, params);
	}
    
	
	
}
