package com.hote.entity;

import java.io.Serializable;
import java.util.List;

public class Roomtype implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -1534696691370203729L;
	private int id;
	private String  typeName;
    private int typePrice;
    private int typeNum;
    private List<Room> roomlist;
    
    public Roomtype(){
    	
    }
    public Roomtype(int id,String  typeName,int typeNum,int typePrice){
    	this.id=id;
    	this.typeName=typeName;
    	this.typeNum=typeNum;
    	this.typePrice=typePrice;
    	
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getTypePrice() {
		return typePrice;
	}
	public void setTypePrice(int typePrice) {
		this.typePrice = typePrice;
	}
	public int getTypeNum() {
		return typeNum;
	}
	public void setTypeNum(int typeNum) {
		this.typeNum = typeNum;
	}
	public List<Room> getRoomlist() {
		return roomlist;
	}
	public void setRoomlist(List<Room> roomlist) {
		this.roomlist = roomlist;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
	
    
}
