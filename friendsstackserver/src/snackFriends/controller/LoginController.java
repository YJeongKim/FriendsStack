package snackFriends.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class LoginController {
	private static String IP = "localhost";
	private static int PORT = Message.LOGINPORT;
	private PrintWriter pw;
	private BufferedReader br;

	public LoginController() {
	}

	public GamePlayer login(LoginInfo loginInfo) {
		Socket socket;
		try {
			socket = new Socket(IP, PORT);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			pw.println(Message.LOGIN + loginInfo.toString());
			String msg = "";
			msg = br.readLine();
			int kong = Integer.parseInt(msg);
			socket.close();
			if (kong >= 0) {
				GamePlayer gamePlayer = new GamePlayer(loginInfo.getId(), new Socket(IP, Message.GAMEPORT), kong);
				gameLogin(gamePlayer);
				return gamePlayer;
			}
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
		} finally {
			pws.close();
		}
	}
}
