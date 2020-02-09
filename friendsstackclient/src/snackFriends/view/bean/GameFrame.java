package snackFriends.view.bean;

import javax.swing.JFrame;

import snackFriends.view.mainScreen.MainScreen;

public class GameFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private static GameFrame gfInstance = new GameFrame();
	private GamePlayer gamePlayer;

	private GameFrame() {
		super("Friends Stack");
		// 메인 화면
		setContentPane(new MainScreen());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1450, 1000);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void setGamePlayer(GamePlayer gamePlayer) {
		this.gamePlayer = gamePlayer;
	}

	public static GameFrame getInstance() {
		if (gfInstance == null) {
			gfInstance = new GameFrame();
		}
		return gfInstance;
	}

}
