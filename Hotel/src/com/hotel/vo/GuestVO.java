package com.hotel.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GuestVO {
	//房间id
	private Integer id;
	//客户名
	private String  names;
	//身份证
	private String  dataId; 
	//退房日期
	private String  leaveDate;
	//押金
	private Integer deposit;
	//入住日期
	private String  resideDate;
	//入住人数
	private Integer roomNum;
	//单价
	private Integer typePrice;
	//房间号
	private String  description;
	//房间id
	private Integer roomId;
	//其他
	private Integer other=0;
	//总金额
	private Integer toalMoney=0;
	//实付
	private Integer pay=0;
	//应付
	private Integer change=0;
	//获取当前时间
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getDataId() {
		return dataId;
	}
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	public String getLeaveDate() {
		//获取退房当天日期
		leaveDate=sdf.format(new Date());
		return leaveDate;
	}
	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}
	public Integer getDeposit() {
		return deposit;
	}
	public void setDeposit(Integer deposit) {
		
		this.deposit = deposit;
	}
	public String getResideDate() {
		return resideDate;
	}
	public void setResideDate(String resideDate) {
		this.resideDate = resideDate;
	}
	
	public Integer getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(Integer roomNum) {
		this.roomNum = roomNum;
	}
	public Integer getTypePrice() {
		return typePrice;
	}
	public void setTypePrice(Integer typePrice) {
		this.typePrice = typePrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getOther() {
		return other;
	}
	public void setOther(Integer other) {
		this.other = other;
	}
	public Integer getPay() {
		return pay;
	}
	public void setPay(Integer pay) {
		this.pay = pay;
	}
	public Integer getChange() throws ParseException {
		//得到应付的金额
		change=this.getToalMoney()-this.getDeposit();
		return change;
	}
	public void setChange(Integer change) {
		this.change = change;
	}
	public Integer getToalMoney() throws ParseException {
		// 获取入住日期
		Date  in= sdf.parse(this.getResideDate());
		// 获取结账日期
		Date  out= sdf.parse(this.getLeaveDate());
		// 获取入住天数
		int day = (int) ((out.getTime() - in.getTime()) / (24 * 60 * 60 * 1000));
		// 获取总金额
		toalMoney = day * this.getTypePrice() + this.getOther();
		return toalMoney;
	}
	public void setToalMoney(Integer toalMoney) {
		
		this.toalMoney = toalMoney;
	}
	
	
}
