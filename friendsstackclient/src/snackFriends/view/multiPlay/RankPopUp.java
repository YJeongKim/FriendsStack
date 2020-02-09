package snackFriends.view.multiPlay;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import snackFriends.view.bean.GameFrame;
import snackFriends.view.roomList.RoomListScreen;

/**
 * 멀티플레이 게임 종료 시 플레이어에게 제공되는 팝업 창이다.
 * @author STF	 
 */
public class RankPopUp extends JPanel {
	private static final long serialVersionUID = 1L;
	/**
	 * 결과 팝업 창의 배경 이미지를 저장하는 변수
	 */
	private ImageIcon background;
	/**
	 * 나가기 버튼의 이미지 : 마우스 커서가 버튼 내에 있지 않은 경우
	 */
	private ImageIcon exitBaseBtnImg;
	/**
	 * 나가기 버튼의 이미지 : 마우스 커서가 버튼 내에 있는 경우
	 */
	private ImageIcon exitEntryBtnImg;
	/**
	 * 결과 팝업 창이 add될 dialog 변수
	 */
	private JDialog dialog;
	/**
	 * 나가기 버튼
	 */
	private JButton exitButton;
	
	/**
	 * @author STF
	 * 플레이어가 나가기 버튼을 눌렀을 경우 생성되는 클래스이다.
	 */
	private class ExitButtonHandler extends MouseAdapter {
		
		/**
		 * @return
		 * 마우스 커서가 나가기 버튼 내에 들어왔을 시 발생한다. 
		 */
		public void mouseEntered(MouseEvent e) {
			exitButton.setIcon(exitEntryBtnImg);
			exitButton.setBounds(160, 794, 440, 90);
			exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return
		 * 마우스 커서가 나가기 버튼을 빠져나갔을 시 발생한다. 
		 */
		public void mouseExited(MouseEvent e) {
			exitButton.setIcon(exitBaseBtnImg);
			exitButton.setBounds(170, 796, 420, 86);
			exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return 
		 * 나가기 버튼을 눌렀을 시 발생하고  방 리스트 화면(RoomListScreen)으로 이동한다.
		 */
		public void mousePressed(MouseEvent e) {
			// 멀티 플레이 게임 종료 -> 방리스트 화면으로 이동
			dialog.setVisible(false);
			GameFrame.getInstance().setContentPane(new RoomListScreen(12));
			GameFrame.getInstance().setVisible(true);
		}
	}

	/**
	 * 결과 팝업 창의 배경이미지와 나가기 버튼에 대한 이미지를 생성하고 패널에 add한다.
	 * @param dialog 타입 : JDialog
	 */
	public RankPopUp(JDialog dialog) {
		setLayout(null);
		background = new ImageIcon("image/multi/rank/rankPopUp.png");
		exitBaseBtnImg = new ImageIcon("image/multi/rank/exit1.png");
		exitEntryBtnImg = new ImageIcon("image/multi/rank/exit2.png");
		this.dialog = dialog;
		addExitButton();
		reGame();
	}

	/**
	 * @return 
	 * 나가기 버튼을 패널에 추가하는 메서드이다.
	 */
	public void addExitButton() {
		exitButton = new JButton(exitBaseBtnImg);
		exitButton.setBounds(170, 796, 420, 86);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.setVisible(true);
		this.add(exitButton);
		exitButton.addMouseListener(new ExitButtonHandler());
	}

	/**
	 * @return 
	 * 10초후 게임을 다시 시작하도록 하는 메서드이다.
	 */
	public void reGame() {
		Timer m_timer = new Timer();
		TimerTask m_task = new TimerTask() {
			public void run() {
				dialog.setVisible(false);
			}
		};
		m_timer.schedule(m_task, 10000);
	}

	/**
	 * @return 
	 * paintComponent()를 통해 결과 팝업 창(RankPopUp)의 배경이미지를 그린다.
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 750, 952, null);
	}

}
