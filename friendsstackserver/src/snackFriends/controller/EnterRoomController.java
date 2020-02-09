package snackFriends.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import snackFriends.view.roomList.MultiGameRoomBean;
import snackFriendsserver.MultiGameRoom;

public class EnterRoomController {
	private static String IP="192.168.30.182";
	private static int PORT=9000;
	private PrintWriter pw;
	private BufferedReader br;
	public EnterRoomController() {
	}
	public MultiGameRoomBean enterRoom(String id, int roomNumber) throws IOException, ClassNotFoundException {
		Socket connection =new Socket(IP,PORT);
		pw=new PrintWriter(new OutputStreamWriter(connection.getOutputStream(),StandardCharsets.UTF_8),true);
		pw.println("[ENTER]\r\n"+id+"\r\n"+roomNumber+"\r\n");
		
		
		StringBuilder msg=new StringBuilder("");
		br=new BufferedReader(new InputStreamReader(connection.getInputStream(),StandardCharsets.UTF_8));
		while((msg.append(br.readLine()))!=null);//�о����
		
		String base64Member=msg.toString();//���۵� ����Ʈ ����
		byte[] serializedMember = Base64.getDecoder().decode(base64Member);
	    try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember)) {
	        try (ObjectInputStream ois = new ObjectInputStream(bais)) {
	            // ������ȭ�� Member ��ü�� �о�´�.
	            Object objectMember = ois.readObject();
	            MultiGameRoom member = (MultiGameRoom) objectMember;
	            
	            br.close();
	        	pw.close();
	        	connection.close();
	        	return new MultiGameRoomBean(member);
	        }
	    }	
	}
}
