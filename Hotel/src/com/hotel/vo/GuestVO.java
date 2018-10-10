package com.hotel.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GuestVO {
	//����id
	private Integer id;
	//�ͻ���
	private String  names;
	//���֤
	private String  dataId; 
	//�˷�����
	private String  leaveDate;
	//Ѻ��
	private Integer deposit;
	//��ס����
	private String  resideDate;
	//��ס����
	private Integer roomNum;
	//����
	private Integer typePrice;
	//�����
	private String  description;
	//����id
	private Integer roomId;
	//����
	private Integer other=0;
	//�ܽ��
	private Integer toalMoney=0;
	//ʵ��
	private Integer pay=0;
	//Ӧ��
	private Integer change=0;
	//��ȡ��ǰʱ��
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
		//��ȡ�˷���������
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
		//�õ�Ӧ���Ľ��
		change=this.getToalMoney()-this.getDeposit();
		return change;
	}
	public void setChange(Integer change) {
		this.change = change;
	}
	public Integer getToalMoney() throws ParseException {
		// ��ȡ��ס����
		Date  in= sdf.parse(this.getResideDate());
		// ��ȡ��������
		Date  out= sdf.parse(this.getLeaveDate());
		// ��ȡ��ס����
		int day = (int) ((out.getTime() - in.getTime()) / (24 * 60 * 60 * 1000));
		// ��ȡ�ܽ��
		toalMoney = day * this.getTypePrice() + this.getOther();
		return toalMoney;
	}
	public void setToalMoney(Integer toalMoney) {
		
		this.toalMoney = toalMoney;
	}
	
	
}
