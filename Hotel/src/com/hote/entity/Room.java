package com.hote.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 房间类
 * @author Administrator
 *
 */
public class Room implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 6918135610687789967L;
	
	private Integer    roomId;
	private String     description;
	private Integer    roomNum;
    private List<Guest> guestlist;
    private Roomstatic  roomstatic;
    private Roomtype    roomtype;

	public Roomstatic getRoomstatic() {
		return roomstatic;
	}
	public void setRoomstatic(Roomstatic roomstatic) {
		this.roomstatic = roomstatic;
	}
	public Roomtype getRoomtype() {
		return roomtype;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(Integer roomNum) {
		this.roomNum = roomNum;
	}
	public void setRoomtype(Roomtype roomtype) {
		this.roomtype = roomtype;
	}
	public List<Guest> getGuestlist() {
		return guestlist;
	}
	public void setGuestlist(List<Guest> guestlist) {
		this.guestlist = guestlist;
	}
	
	
}
