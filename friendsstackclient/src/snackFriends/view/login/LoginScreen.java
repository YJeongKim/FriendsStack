package snackFriends.view.login;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import snackFriends.view.bean.GameFrame;
import snackFriends.view.bean.GamePlayer;
import snackFriends.view.bean.LoginInfo;

public class LoginScreen extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon background;
	private ImageIcon loginBaseBtnImg, loginEntryBtnImg;
	private ImageIcon kakaologinBaseBtnImg, kakaologinEntryBtnImg;
	private ImageIcon joinBaseBtnImg, joinEntryBtnImg;
	private ImageIcon findIDPWBaseBtnImg, findIDPWEntryBtnImg;
	private ImageIcon exitBaseBtnImg, exitEntryBtnImg;
	private JFrame frame;
	private JButton loginButton;
	private JButton kakaoLoginButton;
	private JButton joinButton;
	private JButton findIDPWButton;
	private JButton exitButton;
	private JTextField idTextField;
	private JPasswordField passwordTextField;

	private class LoginButtonHandler extends MouseAdapter {
		private LoginController loginController;

		public LoginButtonHandler() {
			loginController = new LoginController();
		}

		public void mouseEntered(MouseEvent e) {
			loginButton.setIcon(loginEntryBtnImg);
			loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			loginButton.setIcon(loginBaseBtnImg);
			loginButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			System.out.println("안녕?");
			String id = idTextField.getText();
			String password = new String(passwordTextField.getPassword());
			if (CheckValid.idValidCheck(id)) {
				if (CheckValid.passwordValidCheck(password)) {
					System.out.println(id + " " + "password");
					GamePlayer gamePlayer = loginController.login(new LoginInfo(id, password));
					if (gamePlayer == null) {
						idTextField.setText("로그인 실패!");
						passwordTextField.setText("");
					} else {
						System.out.println("로그인 성공!");
						// Login 화면 닫고 Main 화면으로 이동
						frame.dispose();
						GameFrame.getInstance().setGamePlayer(gamePlayer);
						GameFrame.getInstance().setVisible(true);
					}
				} else {
					idTextField.setText("잘못 입력하셨습니다.");
				}
			} else {
				idTextField.setText("잘못 입력하셨습니다.");
			}
		}
	}

	private class KakaoLoginButtonHandler extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			kakaoLoginButton.setIcon(kakaologinEntryBtnImg);
			kakaoLoginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			kakaoLoginButton.setIcon(kakaologinBaseBtnImg);
			kakaoLoginButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// 카카오톡 연동 (x)
		}
	}

	private class JoinButtonHandler extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			joinButton.setIcon(joinEntryBtnImg);
			joinButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			joinButton.setIcon(joinBaseBtnImg);
			joinButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// 회원가입 화면으로 이동
			frame.setContentPane(new JoinScreen(frame));
			frame.setVisible(true);
		}
	}

	private class FindIDPWButtonHandler extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			findIDPWButton.setIcon(findIDPWEntryBtnImg);
			findIDPWButton.setBounds(123, 775, 220, 100);
			findIDPWButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			findIDPWButton.setIcon(findIDPWBaseBtnImg);
			findIDPWButton.setBounds(123, 775, 220, 110);
			findIDPWButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// ID/PW 조회 팝업 창
			new FindIDPWPopUpDialog(frame).setVisible(true);
		}
	}

	private class ExitButtonHandler extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			exitButton.setIcon(exitEntryBtnImg);
			exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			exitButton.setIcon(exitBaseBtnImg);
			exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// 게임 종료
			System.exit(1);
		}

	}

	public LoginScreen(JFrame frame) {
		System.out.println("??");
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		background = new ImageIcon("image/login/loginBackground.png");
		loginBaseBtnImg = new ImageIcon("image/login/login1.png");
		loginEntryBtnImg = new ImageIcon("image/login/login2.png");
		kakaologinBaseBtnImg = new ImageIcon("image/login/kakaoTalk1.png");
		kakaologinEntryBtnImg = new ImageIcon("image/login/kakaoTalk2.png");
		joinBaseBtnImg = new ImageIcon("image/login/join1.png");
		joinEntryBtnImg = new ImageIcon("image/login/join2.png");
		findIDPWBaseBtnImg = new ImageIcon("image/login/findIDPW1.png");
		findIDPWEntryBtnImg = new ImageIcon("image/login/findIDPW2.png");
		exitBaseBtnImg = new ImageIcon("image/login/exit1.png");
		exitEntryBtnImg = new ImageIcon("image/login/exit2.png");
		this.frame = frame;
		addLoginButton();
		addKakaoLoginButton();
		addJoinButton();
		addFindIDPWButton();
		addExitButton();
		addIdTextField();
		addPasswordTextField();
	}

	public void addLoginButton() {
		loginButton = new JButton(loginBaseBtnImg);
		loginButton.setBounds(270, 492, 220, 132);
		loginButton.setBorderPainted(false);
		loginButton.setContentAreaFilled(false);
		loginButton.setFocusPainted(false);
		this.add(loginButton);
		loginButton.addMouseListener(new LoginButtonHandler());
	}

	public void addKakaoLoginButton() {
		kakaoLoginButton = new JButton(kakaologinBaseBtnImg);
		kakaoLoginButton.setBounds(123, 647, 220, 101);
		kakaoLoginButton.setBorderPainted(false);
		kakaoLoginButton.setContentAreaFilled(false);
		kakaoLoginButton.setFocusPainted(false);
		this.add(kakaoLoginButton);
		kakaoLoginButton.addMouseListener(new KakaoLoginButtonHandler());
	}

	public void addJoinButton() {
		joinButton = new JButton(joinBaseBtnImg);
		joinButton.setBounds(405, 647, 220, 101);
		joinButton.setBorderPainted(false);
		joinButton.setContentAreaFilled(false);
		joinButton.setFocusPainted(false);
		this.add(joinButton);
		joinButton.addMouseListener(new JoinButtonHandler());
	}

	public void addFindIDPWButton() {
		findIDPWButton = new JButton(findIDPWBaseBtnImg);
		findIDPWButton.setBounds(123, 775, 220, 110);
		findIDPWButton.setBorderPainted(false);
		findIDPWButton.setContentAreaFilled(false);
		findIDPWButton.setFocusPainted(false);
		this.add(findIDPWButton);
		findIDPWButton.addMouseListener(new FindIDPWButtonHandler());
	}

	public void addExitButton() {
		exitButton = new JButton(exitBaseBtnImg);
		exitButton.setBounds(405, 775, 220, 101);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		this.add(exitButton);
		exitButton.addMouseListener(new ExitButtonHandler());
	}

	public void addIdTextField() {
		idTextField = new JTextField(10);
		idTextField.setBounds(356, 305, 250, 57);
		idTextField.setFont(new Font("배달의민족 주아", Font.PLAIN, 30));
		idTextField.setHorizontalAlignment(JTextField.CENTER);
		idTextField.setBorder(null);
		idTextField.setBackground(new Color(255, 239, 239));
		this.add(idTextField);
	}

	public void addPasswordTextField() {
		passwordTextField = new JPasswordField(15);
		passwordTextField.setBounds(356, 399, 250, 57);
		passwordTextField.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		passwordTextField.setHorizontalAlignment(JTextField.CENTER);
		passwordTextField.setBorder(null);
		passwordTextField.setBackground(new Color(255, 239, 239));
		this.add(passwordTextField);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 750, 951, null);
	}

}
