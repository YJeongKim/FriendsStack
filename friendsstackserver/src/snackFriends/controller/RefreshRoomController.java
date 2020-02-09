package snackFriends.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;

import snackFriends.view.roomList.RoomList;
import snackFriends.view.server.MultiGameRoom;

public class RefreshRoomController {
	private static String IP="localhost";
	private static int PORT=9000;
	private PrintWriter pw;
	private BufferedReader br;
	public RefreshRoomController() {}
	public ArrayList<RoomBean> getRoomList() throws UnknownHostException, IOException, ClassNotFoundException {
		Socket connection =new Socket(IP,PORT);
		System.out.println("getRoom");
		br=new BufferedReader(new InputStreamReader(connection.getInputStream(),StandardCharsets.UTF_8));
		pw=new PrintWriter(new OutputStreamWriter(connection.getOutputStream(),StandardCharsets.UTF_8),true);
		pw.println("[FRESH]\r\n");
		System.out.println("gd");
		StringBuilder msg=new StringBuilder("");
		
		
		while((msg.append(br.readLine()))!=null);//읽어오기
		String base64Member=msg.toString();//전송된 바이트 받음
		byte[] serializedMember = Base64.getDecoder().decode(base64Member);
		System.out.println("getRoom2");
	    try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember)) {
	        try (ObjectInputStream ois = new ObjectInputStream(bais)) {
	            // 역직렬화된 Member 객체를 읽어온다.
	            Object objectMember = ois.readObject();
	            RoomList member = (RoomList) objectMember;
	            ArrayList<RoomBean> roomBeanAry=new ArrayList<>();
	            for(int i=0;i<roomBeanAry.size();i++) {
	            	MultiGameRoom mgr = member.getRoomList().get(i);
	            	roomBeanAry.add(new RoomBean(mgr.getId(),mgr.getTitle(),mgr.getPlayerList().size()));
	            }
	            System.out.println(roomBeanAry);
	            br.close();
	        	pw.close();
	        	connection.close();
	        	return roomBeanAry;
	        }
	    }
	}
}
