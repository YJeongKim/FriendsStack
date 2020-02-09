package snackFriends.server;

import java.net.ServerSocket;
import java.util.ArrayList;

import snackFriends.controller.GamePlayerInfo;

public class Server {
	private static final int PORT = 9000;
	private ServerSocket serverSocket;
	public ArrayList<GamePlayerInfo> players;
	private static Server instance;
	public Server() {}
	public ArrayList<GamePlayerInfo>getPlayers() {
		return players;}
	public ServerSocket getserverSocket() {
		return serverSocket;}
	public Server getInstance() {
		return instance;}	
}
