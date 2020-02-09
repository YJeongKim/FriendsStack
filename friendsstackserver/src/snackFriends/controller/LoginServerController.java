package snackFriends.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import snackFriends.server.GameServer;

public class LoginServerController extends Thread {
	private Socket socket = null;
	private BufferedReader br;

	public LoginServerController(Socket socket) {
		this.socket = socket;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void login(GamePlayerInfo gamePlayerInfo) {
		GameServer.getInstance().getPlayers().insert(gamePlayerInfo);
	}

	public void run() {
		String msg = null;
		try {
			msg = br.readLine();
			System.out.println(msg + " msg »Æ¿Œ");
			if (msg.substring(0, 4).equals(Message.LOGIN))
				login(new GamePlayerInfo(msg.substring(4).split("//"), socket));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
