package snackFriends.controller;

public class RoomServiceManager extends Thread {
	private RefreshRoomService refreshRoomService;
	private MakeRoomService makeRoomService;
	private EnterRoomService enterRoomService;
	private ExitRoomService  exitRoomService;
	
	public RoomServiceManager() {}
	public ArrayList<MultiGameRoom> getRoomList(){}
	public MultiGameRoom makeRoom(String id , String title) {}
	public MultiGameRoom enterRoom(String id , int roomNumber) {}
	public boolean exitRoom(GamePlayer gamePlayer) {}
	public void run() {}
}
