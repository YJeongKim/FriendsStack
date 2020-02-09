package snackFriends.view.roomList;

import java.util.ArrayList;

import javax.swing.Icon;

import snackFriends.view.server.GamePlayerInfo;
import snackFriends.view.server.MultiGameRoom;

public class MultiGameRoomBean {
	private int roomNumber;
	private String roomTitle;
	private ArrayList<String> playerIdList;
	
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getRoomTitle() {
		return roomTitle;
	}
	public void setRoomTitle(String roomTitle) {
		this.roomTitle = roomTitle;
	}
	public ArrayList<String> getPlayerIdList() {
		return playerIdList;
	}
	public void setPlayerIdList(ArrayList<String> playerIdList) {
		this.playerIdList = playerIdList;
	}
	public MultiGameRoomBean() {}
	public MultiGameRoomBean(MultiGameRoom room) {
		this(room.getId(),room.getTitle(),room.getPlayerList());
	}
	public MultiGameRoomBean(int roomNumber, String roomTitle, ArrayList<GamePlayerInfo> playerIdList) {
		this.roomNumber = roomNumber;
		this.roomTitle = roomTitle;
		this.playerIdList = new ArrayList<String>();
		for(GamePlayerInfo temp:playerIdList)
			this.playerIdList.add(temp.getId());
	}
	
}
