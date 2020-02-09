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
 * ��Ƽ�÷��� ���� ���� �� �÷��̾�� �����Ǵ� �˾� â�̴�.
 * @author STF	 
 */
public class RankPopUp extends JPanel {
	private static final long serialVersionUID = 1L;
	/**
	 * ��� �˾� â�� ��� �̹����� �����ϴ� ����
	 */
	private ImageIcon background;
	/**
	 * ������ ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� ���� ���� ���
	 */
	private ImageIcon exitBaseBtnImg;
	/**
	 * ������ ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� �ִ� ���
	 */
	private ImageIcon exitEntryBtnImg;
	/**
	 * ��� �˾� â�� add�� dialog ����
	 */
	private JDialog dialog;
	/**
	 * ������ ��ư
	 */
	private JButton exitButton;
	
	/**
	 * @author STF
	 * �÷��̾ ������ ��ư�� ������ ��� �����Ǵ� Ŭ�����̴�.
	 */
	private class ExitButtonHandler extends MouseAdapter {
		
		/**
		 * @return
		 * ���콺 Ŀ���� ������ ��ư ���� ������ �� �߻��Ѵ�. 
		 */
		public void mouseEntered(MouseEvent e) {
			exitButton.setIcon(exitEntryBtnImg);
			exitButton.setBounds(160, 794, 440, 90);
			exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return
		 * ���콺 Ŀ���� ������ ��ư�� ���������� �� �߻��Ѵ�. 
		 */
		public void mouseExited(MouseEvent e) {
			exitButton.setIcon(exitBaseBtnImg);
			exitButton.setBounds(170, 796, 420, 86);
			exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return 
		 * ������ ��ư�� ������ �� �߻��ϰ�  �� ����Ʈ ȭ��(RoomListScreen)���� �̵��Ѵ�.
		 */
		public void mousePressed(MouseEvent e) {
			// ��Ƽ �÷��� ���� ���� -> �渮��Ʈ ȭ������ �̵�
			dialog.setVisible(false);
			GameFrame.getInstance().setContentPane(new RoomListScreen(12));
			GameFrame.getInstance().setVisible(true);
		}
	}

	/**
	 * ��� �˾� â�� ����̹����� ������ ��ư�� ���� �̹����� �����ϰ� �гο� add�Ѵ�.
	 * @param dialog Ÿ�� : JDialog
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
	 * ������ ��ư�� �гο� �߰��ϴ� �޼����̴�.
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
	 * 10���� ������ �ٽ� �����ϵ��� �ϴ� �޼����̴�.
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
	 * paintComponent()�� ���� ��� �˾� â(RankPopUp)�� ����̹����� �׸���.
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 750, 952, null);
	}

}
