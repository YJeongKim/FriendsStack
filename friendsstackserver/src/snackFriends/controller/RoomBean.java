package snackFriends.controller;

public class RoomBean {
	private int roomNumber;
	private String title;
	private int count;
	
	public RoomBean() {
		this(0,null,0);
	}
	public RoomBean(int roomNumber, String title, int count) {
		this.roomNumber=roomNumber;
		this.title=title;
		this.count=count;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
