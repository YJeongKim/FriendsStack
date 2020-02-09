package snackFriends.view.tutorial;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import snackFriends.view.bean.Music;

/**
 * Ʃ�丮�� �˾� â���� �̱��÷��� ��ư�� ������ �� �÷��̾�� �����ϴ� ȭ���̴�.
 * 
 * @author SnackTimeFriends
 *
 */
public class SingleTutorialScreen extends JPanel {
	private static final long serialVersionUID = 1L;
	/**
	 * �̱��÷��� Ʃ�丮���� ��� �������� ���� �̹������� �����ϰ� �ִ� ����
	 */
	private ImageIcon[] single;
	/**
	 * ���������� ��ư�� �̹���: ���콺 Ŀ���� ��ư ���� ���� ���� ���
	 */
	private ImageIcon previousBaseBtnImg;
	/**
	 * ���������� ��ư�� �̹���: ���콺 Ŀ���� ��ư ���� �ִ� ���
	 */
	private ImageIcon previousEntryBtnImg;
	/**
	 * ���������� ��ư�� �̹���: ���콺 Ŀ���� ��ư ���� ���� ���� ���
	 */
	private ImageIcon nextBaseBtnImg;
	/**
	 * ���������� ��ư�� �̹���: ���콺 Ŀ���� ��ư ���� �ִ� ���
	 */
	private ImageIcon nextEntryBtnImg;
	/**
	 * �Ͻ����� ��ư�� �̹���: ���콺 Ŀ���� ��ư ���� ���� ���� ���
	 */
	private ImageIcon pauseBaseBtnImg;
	/**
	 * �Ͻ����� ��ư�� �̹���: ���콺 Ŀ���� ��ư ���� �ִ� ���
	 */
	private ImageIcon pauseEntryBtnImg;
	/**
	 * �̱��÷��� Ʃ�丮�� ȭ���� ���������� ��ư
	 */
	private JButton previousButton;
	/**
	 * ��Ƽ�÷��� Ʃ�丮�� ȭ���� ���������� ��ư
	 */
	private JButton nextButton;
	/**
	 * ��Ƽ�÷��� Ʃ�丮�� ȭ���� �Ͻ����� ��ư
	 */
	private JButton pauseButton;
	/**
	 * ��ƼƩ�丮���� �������� ��Ÿ���� ����
	 */
	private JLabel pageLabel;
	/**
	 * ��ƼƩ�丮���� ���� �������� ��Ÿ���� ����
	 */
	private int page;
	/**
	 * Ʃ�丮�� ȭ�� ���� ��ư�� ���� ȿ������ �����ϴ� ����
	 */
	private Music btnSound;
	/**
	 * Ʃ�丮�� ȭ���� ��������� �����ϴ� ����
	 */
	private Music bgm;

	/**
	 * �÷��̾ ���������� ��ư�� ������ �� �����Ǵ� Ŭ�����̴�.
	 * 
	 * @author SnackTimeFriends
	 */
	private class PreviousButtonHandler extends MouseAdapter {
		/**
		 * return Ÿ��: void ���콺 Ŀ���� ���� ������ ��ư ���� ������ �� �߻��Ѵ�.
		 */
		public void mouseEntered(MouseEvent e) {
			btnSound = new Music("Button.mp3", false);
			btnSound.start();
			previousButton.setIcon(previousEntryBtnImg);
			previousButton.setBounds(435, 891, 120, 65);
			previousButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * return Ÿ��: void ���콺 Ŀ���� ���� ������ ��ư�� ���������� �� �߻��Ѵ�.
		 */
		public void mouseExited(MouseEvent e) {
			previousButton.setIcon(previousBaseBtnImg);
			previousButton.setBounds(440, 892, 110, 63);
			previousButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * return Ÿ��: void ���� ������ ��ư�� ������ �� �߻��ϰ� ���� ���������� �ϳ� �� �������� �̵��Ѵ�. ���� ���� ������ ��ư��
		 * ������ �� ���� �������� ù ��° ���������ٸ�, Ʃ�丮���� �� �� �������� �̵��Ѵ�.
		 */
		public void mousePressed(MouseEvent e) {
			// ���� �������� �̵�
			if (page == 0)
				page = single.length - 1;
			else
				page--;
			pageLabel.setText((page + 1) + "/" + single.length);
			repaint();
		}
	}

	/**
	 * �÷��̾ ���������� ��ư�� ������ �� �����Ǵ� Ŭ�����̴�.
	 * 
	 * @author SnackTimeFriends
	 */
	private class NextButtonHandler extends MouseAdapter {
		/**
		 * return Ÿ��: void ���콺 Ŀ���� ���� ������ ��ư ���� ������ �� �߻��Ѵ�.
		 */
		public void mouseEntered(MouseEvent e) {
			btnSound = new Music("Button.mp3", false);
			btnSound.start();
			nextButton.setIcon(nextEntryBtnImg);
			nextButton.setBounds(915, 891, 120, 65);
			nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * return Ÿ��: void ���콺 Ŀ���� ���� ������ ��ư�� ���������� �� �߻��Ѵ�.
		 */
		public void mouseExited(MouseEvent e) {
			nextButton.setIcon(nextBaseBtnImg);
			nextButton.setBounds(920, 892, 110, 63);
			nextButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * return Ÿ��: void ���� ������ ��ư�� ������ �� �߻��ϰ� ���� ���������� �ϳ� �� �������� �̵��Ѵ�. ���� ���� ������ ��ư��
		 * ������ �� ���� �������� �� �� ���������ٸ�, Ʃ�丮���� �� �� �������� �̵��Ѵ�.
		 */
		public void mousePressed(MouseEvent e) {
			// ���� �������� �̵�
			if (page == single.length - 1)
				page = 0;
			else
				page++;
			pageLabel.setText((page + 1) + "/" + single.length);
			repaint();
		}
	}

	/**
	 * �÷��̾ �Ͻ����� ��ư�� ������ �� �����Ǵ� Ŭ�����̴�.
	 * 
	 * @author SnackTimeFriends
	 */
	private class PauseButtonHandler extends MouseAdapter {

		/**
		 * return Ÿ��: void ���콺 Ŀ���� �Ͻ����� ��ư ���� ������ �� �߻��Ѵ�.
		 */
		public void mouseEntered(MouseEvent e) {
			btnSound = new Music("Button.mp3", false);
			btnSound.start();
			pauseButton.setIcon(pauseEntryBtnImg);
			pauseButton.setBounds(675, 891, 120, 65);
			pauseButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * return Ÿ��: void ���콺 Ŀ���� �Ͻ����� ��ư�� ���������� �� �߻��Ѵ�.
		 */
		public void mouseExited(MouseEvent e) {
			pauseButton.setIcon(pauseBaseBtnImg);
			pauseButton.setBounds(680, 892, 110, 63);
			pauseButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * �Ͻ����� ��ư�� ������ �� �߻��ϰ�, Ʃ�丮�� �Ͻ����� �˾�â(TutorialPausePopUpDialog)�� �÷��̾�� �����Ѵ�.
		 */
		public void mousePressed(MouseEvent e) {
			// �Ͻ����� �˾� â
			new TutorialPausePopUpDialog(bgm).setVisible(true);
		}
	}

	/**
	 * �̱��÷��� Ʃ�丮�� ������ �������� �ش��ϴ� �̹����� ���������� ��ư, ���������� ��ư, �Ͻ����� ��ư�� ���� �̹����� �����ϰ� ������
	 * ��ư�� ������ JLabel�� �гο� add�Ѵ�.
	 */
	public SingleTutorialScreen() {
		setLayout(null);
		single = new ImageIcon[] { new ImageIcon("image/tutorial/single/singleBackground0.png"),
				new ImageIcon("image/tutorial/single/singleBackground1.png"),
				new ImageIcon("image/tutorial/single/singleBackground2.png") };
		previousBaseBtnImg = new ImageIcon("image/tutorial/previous1.png");
		nextBaseBtnImg = new ImageIcon("image/tutorial/next1.png");
		pauseBaseBtnImg = new ImageIcon("image/tutorial/pause1.png");
		previousEntryBtnImg = new ImageIcon("image/tutorial/previous2.png");
		nextEntryBtnImg = new ImageIcon("image/tutorial/next2.png");
		pauseEntryBtnImg = new ImageIcon("image/tutorial/pause2.png");
		page = 0;
		bgm = new Music("tutorialBgm.mp3", true);
		bgm.start();
		addPreviousButton();
		addNextButton();
		addPauseButton();
		addPageLabel();
	}

	/**
	 * return Ÿ��: void ���������� ��ư�� �гο� �߰��ϴ� �޼����̴�.
	 */
	public void addPreviousButton() {
		previousButton = new JButton(previousBaseBtnImg);
		previousButton.setBounds(440, 892, 110, 63);
		previousButton.setBorderPainted(false);
		previousButton.setContentAreaFilled(false);
		previousButton.setFocusPainted(false);
		previousButton.setVisible(true);
		this.add(previousButton);
		previousButton.addMouseListener(new PreviousButtonHandler());
	}

	/**
	 * return Ÿ��: void ���������� ��ư�� �гο� �߰��ϴ� �޼����̴�.
	 */
	public void addNextButton() {
		nextButton = new JButton(nextBaseBtnImg);
		nextButton.setBounds(920, 892, 110, 63);
		nextButton.setBorderPainted(false);
		nextButton.setContentAreaFilled(false);
		nextButton.setFocusPainted(false);
		nextButton.setVisible(true);
		this.add(nextButton);
		nextButton.addMouseListener(new NextButtonHandler());
	}

	/**
	 * return Ÿ��: void �Ͻ����� ��ư�� �гο� �߰��ϴ� �޼����̴�.
	 */
	public void addPauseButton() {
		pauseButton = new JButton(pauseBaseBtnImg);
		pauseButton.setBounds(680, 892, 110, 63);
		pauseButton.setBorderPainted(false);
		pauseButton.setContentAreaFilled(false);
		pauseButton.setFocusPainted(false);
		pauseButton.setVisible(true);
		this.add(pauseButton);
		pauseButton.addMouseListener(new PauseButtonHandler());
	}

	/**
	 * return Ÿ��: void �̱�Ʃ�丮�� ȭ�鿡 ������ ���� �߰��ϴ� �޼����̴�.
	 */
	public void addPageLabel() {
		pageLabel = new JLabel();
		pageLabel.setBounds(1310, 910, 110, 30);
		pageLabel.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 40));
		pageLabel.setForeground(Color.white);
		pageLabel.setText((page + 1) + "/" + single.length);
		this.add(pageLabel);
	}

	/**
	 * paintComponent()�� ���� �̱��÷��� Ʃ�丮�� ȭ��(SingleTutorialScreen)�� ����̹����� �׸���.
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(single[page].getImage(), 0, 0, 1440, 960, null);
	}

}
