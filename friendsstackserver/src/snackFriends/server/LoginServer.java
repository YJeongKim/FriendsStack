package snackFriends.server;

import java.io.IOException;
import java.net.ServerSocket;

import snackFriends.controller.Message;

public class LoginServer {
	private static final int PORT = Message.LOGINPORT;
	private ServerSocket serverSocket;
	private static LoginServer instance = new LoginServer();

	private LoginServer() {
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static LoginServer getInstance() {
		if (instance == null)
			instance = new LoginServer();
		return instance;
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}
}
