package snackFriends.controller;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

public class GamePlayerDAO {
	private static final ArrayList<GamePlayerInfo> players;
	static {
		players = new ArrayList<GamePlayerInfo>();
		Collections.synchronizedList(players);
	}

	public GamePlayerDAO() {
	}

	public GamePlayerInfo search(String id) {
		for (GamePlayerInfo gpi : players) {
			if (gpi.getId().equals(id))
				return gpi;
		}
		return null;
	}

	public boolean delete(String id) {
		return players.remove(search(id));
	}

	public GamePlayerInfo update(String id, int kong) {
		GamePlayerInfo gpi = search(id);
		if (gpi == null)
			return null;
		gpi.setKong(kong);
		return gpi;
	}

	public GamePlayerInfo insert(GamePlayerInfo gamePlayerInfo) {
		players.add(gamePlayerInfo);
		printGamePlayer();
		return gamePlayerInfo;
	}

	public GamePlayerInfo insert(String id, Socket socket, int kong) {
		GamePlayerInfo gamePlayerInfo = new GamePlayerInfo(id, socket, kong);
		players.add(gamePlayerInfo);
		return gamePlayerInfo;
	}

	public void printGamePlayer() {
		System.out.println("현 접속인원 : " + players.size());
		for (GamePlayerInfo g : players) {
			System.out.println("아이디 : " + g.getId() + "소켓 : " + g.getSocket());
		}
	}
}
