package snackFriends.view.tutorial;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import snackFriends.view.bean.GameFrame;
import snackFriends.view.bean.Music;
import snackFriends.view.mainScreen.MainScreen;

/**
 * 튜토리얼 화면에서 일시정지 버튼을 눌렀을 시 생성되는 팝업 창에 대한 클래스이다.
 * 
 * @author SnackTimeFriends
 *
 */
public class TutorialPausePopUp extends JPanel {
	private static final long serialVersionUID = 1L;
	/**
	 * 튜토리얼 일시정지 팝업창의 배경이미지를 저장하는 변수
	 */
	private ImageIcon background;
	/**
	 * 계속하기 버튼의 이미지 : 마우스 커서가 버튼 내에 있지 않은 경우
	 */
	private ImageIcon continueBaseBtnImg;
	/**
	 * 계속하기 버튼의 이미지 : 마우스 커서가 버튼 내에 있는 경우
	 */
	private ImageIcon continueEntryBtnImg;
	/**
	 * 튜토리얼 종료 버튼의 이미지 : 마우스 커서가 버튼 내에 있지 않은 경우
	 */
	private ImageIcon exitBaseBtnImg;
	/**
	 * 튜토리얼 종료 버튼의 이미지 : 마우스 커서가 버튼 내에 있는 경우
	 */
	private ImageIcon exitEntryBtnImg;
	/**
	 * 튜토리얼 일시정지 팝업 창이 add될 dialog 변수
	 */
	private JDialog dialog;
	/**
	 * 계속하기 버튼
	 */
	private JButton continueButton;
	/**
	 * 튜토리얼 종료 버튼
	 */
	private JButton exitButton;
	private Music bgm;

	/**
	 * 싱글, 멀티 플레이 튜토리얼 화면에서 일시정지 버튼 눌렀을 시 플레이어에게 제공되는 팝업 창이다.
	 * 
	 * @author STF
	 *
	 */
	private class ContinueButtonHandler extends MouseAdapter {

		/**
		 * @return void 마우스 커서가 계속하기 버튼 내에 들어왔을 시 발생한다.
		 */
		public void mouseEntered(MouseEvent e) {
			continueButton.setIcon(continueEntryBtnImg);
			continueButton.setBounds(55, 48, 440, 90);
			continueButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return void 마우스 커서가 계속하기 버튼을 빠져나갔을 시 발생한다.
		 */
		public void mouseExited(MouseEvent e) {
			continueButton.setIcon(continueBaseBtnImg);
			continueButton.setBounds(65, 50, 420, 85);
			continueButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return void 계속하기 버튼을 눌렀을 시 발생하고, 팝업 창을 보이지 않게 설정한다.
		 */
		public void mousePressed(MouseEvent e) {
			// 튜토리얼 정지 팝업 창 닫기
			dialog.setVisible(false);
		}
	}

	/**
	 * 튜토리얼 일시정지 팝업창에서 튜토리얼 종료 버튼을 눌렀을 시 생성되는 클래스이다.
	 * 
	 * @author STF
	 *
	 */
	private class ExitButtonHandler extends MouseAdapter {
		/**
		 * @return void 마우스 커서가 튜토리얼 종료 버튼 내에 들어왔을 시 발생한다.
		 */
		public void mouseEntered(MouseEvent e) {
			exitButton.setIcon(exitEntryBtnImg);
			exitButton.setBounds(55, 150, 440, 90);
			exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return void 마우스 커서가 튜토리얼 버튼을 빠져나갔을 시 발생한다.
		 */
		public void mouseExited(MouseEvent e) {
			exitButton.setIcon(exitBaseBtnImg);
			exitButton.setBounds(65, 152, 420, 85);
			exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return void 튜토리얼 버튼을 눌렀을 시 발생하고, 튜토리얼 화면을 보이지 않게 하고 메인 화면(MainFrame)으로 이동한다.
		 * 
		 */
		public void mousePressed(MouseEvent e) {
			// 튜토리얼 종료 -> 메인 화면으로 이동
			dialog.setVisible(false);
			bgm.close();
			GameFrame.getInstance().setContentPane(new MainScreen());
			GameFrame.getInstance().setVisible(true);
		}
	}

	/**
	 * 
	 * @param dialog
	 *            타입: JDialog - TutorialPausePopUp을 그릴 dialog를 전달받는다. 팝업 창의 배경이미지와
	 *            계속하기 버튼, 튜토리얼 종료 버튼에 대한 이미지를 생성하고 각각의 버튼들을 패널에 add한다.
	 */
	public TutorialPausePopUp(JDialog dialog, Music bgm) {
		setLayout(null);
		this.bgm = bgm;
		background = new ImageIcon("image/tutorial/pausePopUp.png");
		continueBaseBtnImg = new ImageIcon("image/tutorial/continue1.png");
		exitBaseBtnImg = new ImageIcon("image/tutorial/exit1.png");
		continueEntryBtnImg = new ImageIcon("image/tutorial/continue2.png");
		exitEntryBtnImg = new ImageIcon("image/tutorial/exit2.png");
		this.dialog = dialog;
		addContinueButton();
		addExitButton();
	}

	/**
	 * @return void 계속하기 버튼을 패널에 추가하는 메서드이다.
	 */
	public void addContinueButton() {
		continueButton = new JButton(continueBaseBtnImg);
		continueButton.setBounds(65, 50, 420, 85);
		continueButton.setBorderPainted(false);
		continueButton.setContentAreaFilled(false);
		continueButton.setFocusPainted(false);
		continueButton.setVisible(true);
		this.add(continueButton);
		continueButton.addMouseListener(new ContinueButtonHandler());
	}

	/**
	 * @return void 튜토리얼 종료 버튼을 패널에 추가하는 메서드이다.
	 */
	public void addExitButton() {
		exitButton = new JButton(exitBaseBtnImg);
		exitButton.setBounds(65, 152, 420, 85);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.setVisible(true);
		this.add(exitButton);
		exitButton.addMouseListener(new ExitButtonHandler());
	}

	/**
	 * @return void paintComponent()를 통해 튜토리얼 일시정지 팝업 창(TutorialPausePopUp)의 배경이미지를
	 *         그린다.
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 550, 285, null);
	}

}
