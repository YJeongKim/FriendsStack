package snackFriends.view.mainScreen;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import snackFriends.view.bean.GameFrame;
import snackFriends.view.bean.LoginFrame;

/**
 * 메인화면(MainScreen)에서 종료버튼 눌렀을 시 플레이어에게 제공되는 팝업 창이다.
 * 
 * @author STF
 *
 */
public class ExitPopUp extends JPanel {
	private static final long serialVersionUID = 1L;
	/**
	 * 종료 팝업 창의 배경 이미지를 저장하는 변수
	 */
	private ImageIcon background;
	/**
	 * 계속하기 버튼의 이미지 : 마우스 커서가 버튼 내에 있지 않은 경우
	 */
	private ImageIcon continueBaseBtnImg;
	/**
	 * 로그아웃 버튼의 이미지 : 마우스 커서가 버튼 내에 있지 않은 경우
	 */
	private ImageIcon logoutBaseBtnImg;
	/**
	 * 게임종료 버튼의 이미지 : 마우스 커서가 버튼 내에 있지 않은 경우
	 */
	private ImageIcon exitBaseBtnImg;
	/**
	 * 계속하기 버튼의 이미지 : 마우스 커서가 버튼 내에 있는 경우
	 */
	private ImageIcon continueEntryBtnImg;
	/**
	 * 로그아웃 버튼의 이미지 : 마우스 커서가 버튼 내에 있는 경우
	 */
	private ImageIcon logoutEntryBtnImg;
	/**
	 * 게임종료 버튼의 이미지 : 마우스 커서가 버튼 내에 있는 경우
	 */
	private ImageIcon exitEntryBtnImg;
	/**
	 * 종료 팝업 창(ExitPopUp)을 add할 dialog변수
	 */
	private JDialog dialog;
	/**
	 * 계속하기 버튼
	 */
	private JButton continueButton;
	/**
	 * 로그아웃 버튼
	 */
	private JButton logoutButton;
	/**
	 * 게임종료 버튼
	 */
	private JButton exitButton;

	/**
	 * 플레이어가 계속하기 버튼을 눌렀을 시 생성되는 클래스이다.
	 */
	private class ContinueButtonHandler extends MouseAdapter {
		/**
		 * @return void 마우스 커서가 계속하기 버튼 내에 들어왔을 시 발생한다.
		 */
		public void mouseEntered(MouseEvent e) {
			continueButton.setIcon(continueEntryBtnImg);
			continueButton.setBounds(55, 85, 440, 90);
			continueButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return void 마우스 커서가 계속하기 버튼을 빠져나갔을 시 발생한다.
		 */
		public void mouseExited(MouseEvent e) {
			continueButton.setIcon(continueBaseBtnImg);
			continueButton.setBounds(65, 87, 420, 85);
			continueButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return void 계속하기 버튼을 눌렀을 시 발생하고, 팝업 창을 보이지 않게 설정한다.
		 */
		public void mousePressed(MouseEvent e) {
			// 종료 팝업 창 닫기
			dialog.setVisible(false);
		}
	}

	/**
	 * 플레이어가 로그아웃 버튼을 눌렀을 시 생성되는 클래스이다.
	 */
	private class LogoutButtonHandler extends MouseAdapter {

		/**
		 * @return void 마우스 커서가 로그아웃 버튼 내에 들어왔을 시 발생한다.
		 */
		public void mouseEntered(MouseEvent e) {
			logoutButton.setIcon(logoutEntryBtnImg);
			logoutButton.setBounds(55, 190, 440, 90);
			logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return void 마우스 커서가 로그아웃 버튼을 빠져나갔을 시 발생한다.
		 */
		public void mouseExited(MouseEvent e) {
			logoutButton.setIcon(logoutBaseBtnImg);
			logoutButton.setBounds(65, 192, 420, 85);
			logoutButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return void 로그아웃 버튼을 눌렀을 시 발생하고, 로그인 화면(LoginFrame)으로 이동한다.
		 */
		public void mousePressed(MouseEvent e) {
			// 로그인 화면으로 이동
			MainScreen.getMainBgm().close();
			dialog.setVisible(false);
			GameFrame.getInstance().dispose();
			new LoginFrame();
		}
	}

	/**
	 * 플레이어가 종료 버튼을 눌렀을 시 생성되는 클래스이다.
	 * 
	 * @author STF
	 *
	 */
	private class ExitButtonHandler extends MouseAdapter {
		/**
		 * @return void 마우스 커서가 게임종료 버튼 내에 들어왔을 시 발생한다.
		 */
		public void mouseEntered(MouseEvent e) {
			exitButton.setIcon(exitEntryBtnImg);
			exitButton.setBounds(55, 295, 440, 90);
			exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return void 마우스 커서가 게임종료 버튼을 빠져나갔을 시 발생한다.
		 */
		public void mouseExited(MouseEvent e) {
			exitButton.setIcon(exitBaseBtnImg);
			exitButton.setBounds(65, 297, 420, 85);
			exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return void 게임종료 버튼을 눌렀을 시 발생하고, 프로그램을 종료한다.
		 */
		public void mousePressed(MouseEvent e) {
			// 종료
			System.exit(0);
		}
	}

	/**
	 * 
	 * @param dialog
	 *            타입: JDialog - ExitPopUp을 붙이기 위한 변수 종료 팝업 창의 배경이미지와 계속하기 버튼, 로그아웃
	 *            버튼, 게임 종료 버튼에 대한 이미지를 생성하고 각각의 버튼들을 패널에 add한다.
	 */
	public ExitPopUp(JDialog dialog) {
		setLayout(null);
		background = new ImageIcon("image/main/exit/exitPopUp.png");
		continueBaseBtnImg = new ImageIcon("image/main/exit/continue1.png");
		logoutBaseBtnImg = new ImageIcon("image/main/exit/logout1.png");
		exitBaseBtnImg = new ImageIcon("image/main/exit/exit1.png");
		continueEntryBtnImg = new ImageIcon("image/main/exit/continue2.png");
		logoutEntryBtnImg = new ImageIcon("image/main/exit/logout2.png");
		exitEntryBtnImg = new ImageIcon("image/main/exit/exit2.png");
		this.dialog = dialog;
		addContinueButton();
		addLogoutButton();
		addExitButton();
	}

	/**
	 * @return void 계속하기 버튼을 패널에 추가하는 메서드이다.
	 */
	public void addContinueButton() {
		continueButton = new JButton(continueBaseBtnImg);
		continueButton.setBounds(65, 87, 420, 85);
		continueButton.setBorderPainted(false);
		continueButton.setContentAreaFilled(false);
		continueButton.setFocusPainted(false);
		continueButton.setVisible(true);
		this.add(continueButton);
		continueButton.addMouseListener(new ContinueButtonHandler());
	}

	/**
	 * @return void 로그아웃 버튼을 패널에 추가하는 메서드이다.
	 */
	public void addLogoutButton() {
		logoutButton = new JButton(logoutBaseBtnImg);
		logoutButton.setBounds(65, 192, 420, 85);
		logoutButton.setBorderPainted(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setFocusPainted(false);
		logoutButton.setVisible(true);
		this.add(logoutButton);
		logoutButton.addMouseListener(new LogoutButtonHandler());
	}

	/**
	 * @return void 게임종료 버튼을 패널에 추가하는 메서드이다.
	 */
	public void addExitButton() {
		exitButton = new JButton(exitBaseBtnImg);
		exitButton.setBounds(65, 297, 420, 85);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.setVisible(true);
		this.add(exitButton);
		exitButton.addMouseListener(new ExitButtonHandler());
	}

	/**
	 * paintComponent()를 통해 종료 팝업 창(ExitPopUp)의 배경이미지를 그린다.
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 550, 470, null);
	}

}
