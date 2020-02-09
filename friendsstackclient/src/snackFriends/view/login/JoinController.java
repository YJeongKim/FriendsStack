package snackFriends.view.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

import snackFriends.view.bean.JoinInfo;
import snackFriends.view.bean.Message;

public class JoinController {
	private static String IP = Message.IP;
	private static int PORT = Message.LOGINPORT;
	private PrintWriter pw;
	private BufferedReader br;

	public JoinController() {
	}

	public int join(JoinInfo joinInfo) {
		System.out.println(joinInfo + " in controller");
		int checkJoin = 0;
		Socket socket = null;
		try {
			socket = new Socket(IP, PORT);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			pw.println(Message.JOIN + joinInfo.toString());
			String msg = "";
			msg = br.readLine();
			System.out.println(msg);
			checkJoin = Integer.parseInt(msg);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			pw.close();
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return checkJoin;
	}

}
