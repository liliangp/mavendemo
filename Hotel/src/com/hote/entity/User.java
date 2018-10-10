package com.hote.entity;

public class User {
    private int userId;
    private String userName;
    private String password;
    
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User(String userName,String password){
		this.password=password;
		this.userName=userName;
	}
	public User(){
		
	}
    public User(String userName){
		this.userName=userName;
    }
    
}
