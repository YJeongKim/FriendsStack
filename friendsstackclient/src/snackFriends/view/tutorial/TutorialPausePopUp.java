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
 * Ʃ�丮�� ȭ�鿡�� �Ͻ����� ��ư�� ������ �� �����Ǵ� �˾� â�� ���� Ŭ�����̴�.
 * 
 * @author SnackTimeFriends
 *
 */
public class TutorialPausePopUp extends JPanel {
	private static final long serialVersionUID = 1L;
	/**
	 * Ʃ�丮�� �Ͻ����� �˾�â�� ����̹����� �����ϴ� ����
	 */
	private ImageIcon background;
	/**
	 * ����ϱ� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� ���� ���� ���
	 */
	private ImageIcon continueBaseBtnImg;
	/**
	 * ����ϱ� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� �ִ� ���
	 */
	private ImageIcon continueEntryBtnImg;
	/**
	 * Ʃ�丮�� ���� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� ���� ���� ���
	 */
	private ImageIcon exitBaseBtnImg;
	/**
	 * Ʃ�丮�� ���� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� �ִ� ���
	 */
	private ImageIcon exitEntryBtnImg;
	/**
	 * Ʃ�丮�� �Ͻ����� �˾� â�� add�� dialog ����
	 */
	private JDialog dialog;
	/**
	 * ����ϱ� ��ư
	 */
	private JButton continueButton;
	/**
	 * Ʃ�丮�� ���� ��ư
	 */
	private JButton exitButton;
	private Music bgm;

	/**
	 * �̱�, ��Ƽ �÷��� Ʃ�丮�� ȭ�鿡�� �Ͻ����� ��ư ������ �� �÷��̾�� �����Ǵ� �˾� â�̴�.
	 * 
	 * @author STF
	 *
	 */
	private class ContinueButtonHandler extends MouseAdapter {

		/**
		 * @return void ���콺 Ŀ���� ����ϱ� ��ư ���� ������ �� �߻��Ѵ�.
		 */
		public void mouseEntered(MouseEvent e) {
			continueButton.setIcon(continueEntryBtnImg);
			continueButton.setBounds(55, 48, 440, 90);
			continueButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return void ���콺 Ŀ���� ����ϱ� ��ư�� ���������� �� �߻��Ѵ�.
		 */
		public void mouseExited(MouseEvent e) {
			continueButton.setIcon(continueBaseBtnImg);
			continueButton.setBounds(65, 50, 420, 85);
			continueButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return void ����ϱ� ��ư�� ������ �� �߻��ϰ�, �˾� â�� ������ �ʰ� �����Ѵ�.
		 */
		public void mousePressed(MouseEvent e) {
			// Ʃ�丮�� ���� �˾� â �ݱ�
			dialog.setVisible(false);
		}
	}

	/**
	 * Ʃ�丮�� �Ͻ����� �˾�â���� Ʃ�丮�� ���� ��ư�� ������ �� �����Ǵ� Ŭ�����̴�.
	 * 
	 * @author STF
	 *
	 */
	private class ExitButtonHandler extends MouseAdapter {
		/**
		 * @return void ���콺 Ŀ���� Ʃ�丮�� ���� ��ư ���� ������ �� �߻��Ѵ�.
		 */
		public void mouseEntered(MouseEvent e) {
			exitButton.setIcon(exitEntryBtnImg);
			exitButton.setBounds(55, 150, 440, 90);
			exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return void ���콺 Ŀ���� Ʃ�丮�� ��ư�� ���������� �� �߻��Ѵ�.
		 */
		public void mouseExited(MouseEvent e) {
			exitButton.setIcon(exitBaseBtnImg);
			exitButton.setBounds(65, 152, 420, 85);
			exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return void Ʃ�丮�� ��ư�� ������ �� �߻��ϰ�, Ʃ�丮�� ȭ���� ������ �ʰ� �ϰ� ���� ȭ��(MainFrame)���� �̵��Ѵ�.
		 * 
		 */
		public void mousePressed(MouseEvent e) {
			// Ʃ�丮�� ���� -> ���� ȭ������ �̵�
			dialog.setVisible(false);
			bgm.close();
			GameFrame.getInstance().setContentPane(new MainScreen());
			GameFrame.getInstance().setVisible(true);
		}
	}

	/**
	 * 
	 * @param dialog
	 *            Ÿ��: JDialog - TutorialPausePopUp�� �׸� dialog�� ���޹޴´�. �˾� â�� ����̹�����
	 *            ����ϱ� ��ư, Ʃ�丮�� ���� ��ư�� ���� �̹����� �����ϰ� ������ ��ư���� �гο� add�Ѵ�.
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
	 * @return void ����ϱ� ��ư�� �гο� �߰��ϴ� �޼����̴�.
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
	 * @return void Ʃ�丮�� ���� ��ư�� �гο� �߰��ϴ� �޼����̴�.
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
	 * @return void paintComponent()�� ���� Ʃ�丮�� �Ͻ����� �˾� â(TutorialPausePopUp)�� ����̹�����
	 *         �׸���.
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 550, 285, null);
	}

}
