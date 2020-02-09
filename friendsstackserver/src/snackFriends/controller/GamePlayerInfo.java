package snackFriends.controller;

import java.io.Serializable;
import java.net.Socket;

public class GamePlayerInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Socket socket;
	private int kong;

	public GamePlayerInfo() {
	}

	public GamePlayerInfo(String id, Socket socket, int kong) {
		this.id = id;
		this.socket = socket;
		this.kong = kong;
	}

	public GamePlayerInfo(String[] gamePlayerInfo, Socket socket) {
		this(gamePlayerInfo[0], socket, Integer.parseInt(gamePlayerInfo[1]));
	}

	public int getKong() {
		return kong;
	}

	public void setKong(int kong) {
		this.kong += kong;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("");
		sb.append(id + "//");
		sb.append(kong + "//");
		return sb.toString();
	}
}
