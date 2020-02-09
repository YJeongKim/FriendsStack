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
 * ����ȭ��(MainScreen)���� �����ư ������ �� �÷��̾�� �����Ǵ� �˾� â�̴�.
 * 
 * @author STF
 *
 */
public class ExitPopUp extends JPanel {
	private static final long serialVersionUID = 1L;
	/**
	 * ���� �˾� â�� ��� �̹����� �����ϴ� ����
	 */
	private ImageIcon background;
	/**
	 * ����ϱ� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� ���� ���� ���
	 */
	private ImageIcon continueBaseBtnImg;
	/**
	 * �α׾ƿ� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� ���� ���� ���
	 */
	private ImageIcon logoutBaseBtnImg;
	/**
	 * �������� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� ���� ���� ���
	 */
	private ImageIcon exitBaseBtnImg;
	/**
	 * ����ϱ� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� �ִ� ���
	 */
	private ImageIcon continueEntryBtnImg;
	/**
	 * �α׾ƿ� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� �ִ� ���
	 */
	private ImageIcon logoutEntryBtnImg;
	/**
	 * �������� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� �ִ� ���
	 */
	private ImageIcon exitEntryBtnImg;
	/**
	 * ���� �˾� â(ExitPopUp)�� add�� dialog����
	 */
	private JDialog dialog;
	/**
	 * ����ϱ� ��ư
	 */
	private JButton continueButton;
	/**
	 * �α׾ƿ� ��ư
	 */
	private JButton logoutButton;
	/**
	 * �������� ��ư
	 */
	private JButton exitButton;

	/**
	 * �÷��̾ ����ϱ� ��ư�� ������ �� �����Ǵ� Ŭ�����̴�.
	 */
	private class ContinueButtonHandler extends MouseAdapter {
		/**
		 * @return void ���콺 Ŀ���� ����ϱ� ��ư ���� ������ �� �߻��Ѵ�.
		 */
		public void mouseEntered(MouseEvent e) {
			continueButton.setIcon(continueEntryBtnImg);
			continueButton.setBounds(55, 85, 440, 90);
			continueButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return void ���콺 Ŀ���� ����ϱ� ��ư�� ���������� �� �߻��Ѵ�.
		 */
		public void mouseExited(MouseEvent e) {
			continueButton.setIcon(continueBaseBtnImg);
			continueButton.setBounds(65, 87, 420, 85);
			continueButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return void ����ϱ� ��ư�� ������ �� �߻��ϰ�, �˾� â�� ������ �ʰ� �����Ѵ�.
		 */
		public void mousePressed(MouseEvent e) {
			// ���� �˾� â �ݱ�
			dialog.setVisible(false);
		}
	}

	/**
	 * �÷��̾ �α׾ƿ� ��ư�� ������ �� �����Ǵ� Ŭ�����̴�.
	 */
	private class LogoutButtonHandler extends MouseAdapter {

		/**
		 * @return void ���콺 Ŀ���� �α׾ƿ� ��ư ���� ������ �� �߻��Ѵ�.
		 */
		public void mouseEntered(MouseEvent e) {
			logoutButton.setIcon(logoutEntryBtnImg);
			logoutButton.setBounds(55, 190, 440, 90);
			logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return void ���콺 Ŀ���� �α׾ƿ� ��ư�� ���������� �� �߻��Ѵ�.
		 */
		public void mouseExited(MouseEvent e) {
			logoutButton.setIcon(logoutBaseBtnImg);
			logoutButton.setBounds(65, 192, 420, 85);
			logoutButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return void �α׾ƿ� ��ư�� ������ �� �߻��ϰ�, �α��� ȭ��(LoginFrame)���� �̵��Ѵ�.
		 */
		public void mousePressed(MouseEvent e) {
			// �α��� ȭ������ �̵�
			MainScreen.getMainBgm().close();
			dialog.setVisible(false);
			GameFrame.getInstance().dispose();
			new LoginFrame();
		}
	}

	/**
	 * �÷��̾ ���� ��ư�� ������ �� �����Ǵ� Ŭ�����̴�.
	 * 
	 * @author STF
	 *
	 */
	private class ExitButtonHandler extends MouseAdapter {
		/**
		 * @return void ���콺 Ŀ���� �������� ��ư ���� ������ �� �߻��Ѵ�.
		 */
		public void mouseEntered(MouseEvent e) {
			exitButton.setIcon(exitEntryBtnImg);
			exitButton.setBounds(55, 295, 440, 90);
			exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return void ���콺 Ŀ���� �������� ��ư�� ���������� �� �߻��Ѵ�.
		 */
		public void mouseExited(MouseEvent e) {
			exitButton.setIcon(exitBaseBtnImg);
			exitButton.setBounds(65, 297, 420, 85);
			exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return void �������� ��ư�� ������ �� �߻��ϰ�, ���α׷��� �����Ѵ�.
		 */
		public void mousePressed(MouseEvent e) {
			// ����
			System.exit(0);
		}
	}

	/**
	 * 
	 * @param dialog
	 *            Ÿ��: JDialog - ExitPopUp�� ���̱� ���� ���� ���� �˾� â�� ����̹����� ����ϱ� ��ư, �α׾ƿ�
	 *            ��ư, ���� ���� ��ư�� ���� �̹����� �����ϰ� ������ ��ư���� �гο� add�Ѵ�.
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
	 * @return void ����ϱ� ��ư�� �гο� �߰��ϴ� �޼����̴�.
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
	 * @return void �α׾ƿ� ��ư�� �гο� �߰��ϴ� �޼����̴�.
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
	 * @return void �������� ��ư�� �гο� �߰��ϴ� �޼����̴�.
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
	 * paintComponent()�� ���� ���� �˾� â(ExitPopUp)�� ����̹����� �׸���.
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 550, 470, null);
	}

}
