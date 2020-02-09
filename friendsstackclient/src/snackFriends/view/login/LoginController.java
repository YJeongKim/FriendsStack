package snackFriends.view.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

import snackFriends.view.bean.GamePlayer;
import snackFriends.view.bean.LoginInfo;
import snackFriends.view.bean.Message;

public class LoginController {
	private static String IP = Message.IP;
	private static int PORT = Message.LOGINPORT;
	private PrintWriter pw;
	private BufferedReader br;

	public LoginController() {
	}

	public GamePlayer login(LoginInfo loginInfo) {
		System.out.println(loginInfo + "12345");
		Socket socket = null;
		int kong = -1;
		try {
			socket = new Socket(IP, PORT);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			pw.println(Message.LOGIN + loginInfo.toString());
			String msg = "";
			msg = br.readLine();
			System.out.println(msg);
			kong = Integer.parseInt(msg);
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
		GamePlayer gamePlayer = null;
		if (kong >= 0) {
			try {
				gamePlayer = new GamePlayer(loginInfo.getId(), new Socket(IP, Message.GAMEPORT), kong);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			gameLogin(gamePlayer);
			return gamePlayer;
		}
		return null;
	}

	public void gameLogin(GamePlayer gamePlayer) {
		PrintWriter pws = null;
		try {
			pws = new PrintWriter(
					new OutputStreamWriter(gamePlayer.getSocket().getOutputStream(), StandardCharsets.UTF_8), true);
			pws.println(Message.LOGIN + gamePlayer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
