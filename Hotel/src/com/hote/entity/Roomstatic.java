package com.hote.entity;

import java.io.Serializable;
import java.util.List;

public class Roomstatic implements Serializable{

	private static final long serialVersionUID = -3991140819318309320L;
	private Integer stateId;
	private String  stateName;
	private List<Room> roomlist;
	
	public List<Room> getRoomlist() {
		return roomlist;
	}
	public void setRoomlist(List<Room> roomlist) {
		this.roomlist = roomlist;
	}
	
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Roomstatic()
	{
		
	}
	
	public Roomstatic(Integer stateId,String  stateName)
	{
		this.stateId=stateId;
		this.stateName=stateName;
	}
	

}
