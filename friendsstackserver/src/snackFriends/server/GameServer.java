package snackFriends.server;

import java.io.IOException;
import java.net.ServerSocket;

import snackFriends.controller.GamePlayerDAO;
import snackFriends.controller.Message;

public class GameServer {
	private static final int PORT = Message.GAMEPORT;
	private ServerSocket serverSocket;
	private GamePlayerDAO players;
	private static GameServer instance;

	private GameServer() {
		players = new GamePlayerDAO();
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public GamePlayerDAO getPlayers() {
		return players;
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public static GameServer getInstance() {
		if (instance == null) {
			instance = new GameServer();
		}
		return instance;
	}
}
