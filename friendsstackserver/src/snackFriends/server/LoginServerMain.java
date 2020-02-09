package snackFriends.server;

import java.io.IOException;
import java.net.Socket;

import snackFriends.controller.LoginServiceManager;

public class LoginServerMain extends Thread {
	public LoginServerMain() {
	}

	public void run() {
		LoginServer loginServer = LoginServer.getInstance();
		while (true) {
			try {
				Socket socket = loginServer.getServerSocket().accept();
				System.out.println(socket);
				new LoginServiceManager(socket).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
