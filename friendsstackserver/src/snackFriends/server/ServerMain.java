package snackFriends.server;

public class ServerMain {
	public static void main(String[] args) {
		new LoginServerMain().start();
		System.out.println("LoginServerMain Start");
		new GameServerMain().start();
		System.out.println("GameServerMain Start");
	}
}
