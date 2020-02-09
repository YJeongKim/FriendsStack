package snackFriends.controller;

import java.util.ArrayList;

public class MultiGameRoomInfo {
	private int id;
	private String title;
	private ArrayList<GamePlayerInfo> playerList;
	private boolean isPlay;
	private int disapperTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<GamePlayerInfo> getPlayerList() {
		return playerList;
	}
	public void setPlayerList(ArrayList<GamePlayerInfo> playerList) {
		this.playerList = playerList;
	}
	public boolean isPlay() {
		return isPlay;
	}
	public void setPlay(boolean isPlay) {
		this.isPlay = isPlay;
	}
	public MultiGameRoomInfo() {}
	public MultiGameRoomInfo(int id, String title, ArrayList<GamePlayInfo> userList) {}
	
}
