package snackFriends.view.bean;

import java.net.Socket;

public class GamePlayer {
	private String id;
	private Socket socket;
	private int kong;

	public GamePlayer() {
		this(null, null, 0);
	}

	public GamePlayer(String id, Socket socket, int kong) {
		this.id = id;
		this.socket = socket;
		this.kong = kong;
	}

	public int getKong() {
		return kong;
	}

	public void setKong(int kong) {
		this.kong = kong;
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
		sb.append(kong);
		return sb.toString();
	}
}
