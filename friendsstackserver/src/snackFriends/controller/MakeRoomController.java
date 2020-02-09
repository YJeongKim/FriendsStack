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
import java.util.Base64;

import snackFriends.view.roomList.MultiGameRoomBean;
import snackFriends.view.server.MultiGameRoom;

public class MakeRoomController {
	private static String IP="localhost";
	private static int PORT=9000;
	private PrintWriter pw;
	private BufferedReader br;
	
	public MakeRoomController() {}
	
	public MultiGameRoomBean makeRoom(String id, String title) throws UnknownHostException, IOException, ClassNotFoundException {
		Socket connection =new Socket(IP,PORT);
		pw=new PrintWriter(new OutputStreamWriter(connection.getOutputStream(),StandardCharsets.UTF_8),true);
		pw.println("[MAKER]//"+id+"//"+title);
		
		
		System.out.println("인코딩전송...");
		
		
		String tempc ="";
		br=new BufferedReader(new InputStreamReader(connection.getInputStream(),StandardCharsets.UTF_8));
		tempc=br.readLine();//읽어오기
		System.out.println("인코딩방정보...");
		String base64Member=tempc;//전송된 바이트 받음
		byte[] serializedMember = Base64.getDecoder().decode(base64Member);
	    try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember)) {
	        try (ObjectInputStream ois = new ObjectInputStream(bais)) {
	            // 역직렬화된 Member 객체를 읽어온다.
	            Object objectMember = ois.readObject();
	            MultiGameRoom member = (MultiGameRoom) objectMember;
	            System.out.println(member.getId()+member.getTitle()+member.getPlayerList()+"디코딩방정보.."); 
	            br.close();
	        	pw.close();
	        	connection.close();
	        	return new MultiGameRoomBean(member);
	        }
	    }
		
	}
}
