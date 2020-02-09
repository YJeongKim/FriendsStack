package snackFriends.server;

import java.io.IOException;
import java.net.Socket;

import snackFriends.controller.LoginServerController;

public class GameServerMain extends Thread {
	public GameServerMain() {
	}

	public void run() {
		GameServer gameServer = GameServer.getInstance();
		while (true) {
			try {
				Socket socket = gameServer.getServerSocket().accept();
				System.out.println(socket);
				new LoginServerController(socket).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
