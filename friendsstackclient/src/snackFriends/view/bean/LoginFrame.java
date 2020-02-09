package snackFriends.view.bean;

import javax.swing.JFrame;

import snackFriends.view.login.LoginScreen;

public class LoginFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int SCREEN_WIDTH = 755;
	public static final int SCREEN_HEGIHT = 980;

	public LoginFrame() {

		super("Freinds Stack");
		// 로그인 화면
		setContentPane(new LoginScreen(this));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(LoginFrame.SCREEN_WIDTH, LoginFrame.SCREEN_HEGIHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {

		System.out.println("start");

		new LoginFrame();
	}

}
