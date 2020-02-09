package snackFriends.view.roomList;

import java.util.ArrayList;

import snackFriends.controller.MultiGameRoom;
import snackFriends.view.server.MultiGameRoomInfo;

public class RoomList {
	private ArrayList<MultiGameRoom> data;
	public RoomList(ArrayList<MultiGameRoomInfo> mgri) {
		for(int i=0;i<mgri.size();i++) {
		data.add(new MultiGameRoom(mgri.get(i)));
		}
	}
	public ArrayList<MultiGameRoom> getRoomList(){
		return data;
	}
}
