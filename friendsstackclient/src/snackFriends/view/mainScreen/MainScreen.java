package snackFriends.view.mainScreen;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import snackFriends.view.bean.GameFrame;
import snackFriends.view.bean.Music;
import snackFriends.view.roomList.RoomListScreen;
import snackFriends.view.singlePlay.SinglePlayScreen;

/**
 * �α���ȭ�� ���� �÷��̾�� �����Ǵ� ȭ���̴�.
 * 
 * @author STF
 *
 */
public class MainScreen extends JPanel {
	private static final long serialVersionUID = 1L;
	/**
	 * ����ȭ���� ����̹����� �����ϴ� ����
	 */
	private ImageIcon background;
	/**
	 * ���� ������ �����ϴ� ����
	 */
	private ImageIcon logo;
	/**
	 * ���� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� ���� ���� ���
	 */
	private ImageIcon exitBaseBtnImg;
	/**
	 * ���� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� �ִ� ���
	 */
	private ImageIcon exitEntryBtnImg;
	/**
	 * ���� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� �ִ� ���
	 */
	private ImageIcon storeEntryBtnImg;
	/**
	 * ���� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� ���� ���� ���
	 */
	private ImageIcon storeBaseBtnImg;
	/**
	 * Ʃ�丮�� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� �ִ� ���
	 */
	private ImageIcon tutorialEntryBtnImg;
	/**
	 * Ʃ�丮�� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� ���� ���� ���
	 */
	private ImageIcon tutorialBaseBtnImg;
	/**
	 * �̱��÷��� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� �ִ� ���
	 */
	private ImageIcon singlePlayEntryBtnImg;
	/**
	 * �̱��÷��� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� ���� ���� ���
	 */
	private ImageIcon singlePlayBaseBtnImg;
	/**
	 * ��Ƽ�÷��� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� �ִ� ���
	 */
	private ImageIcon multiPlayEntryBtnImg;
	/**
	 * ��Ƽ�÷��� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� ���� ���� ���
	 */
	private ImageIcon multiPlayBaseBtnImg;
	/**
	 * ���� ��ư
	 */
	private JButton exitButton;
	/**
	 * ���� ��ư
	 */
	private JButton storeButton;
	/**
	 * Ʃ�丮�� ��ư
	 */
	private JButton tutorialButton;
	/**
	 * �̱��÷��� ��ư
	 */
	private JButton singlePlayButton;
	/**
	 * ��Ƽ�÷��� ��ư
	 */
	private JButton multiPlayButton;
	/**
	 * �÷��̾��� ���� ��Ÿ���� JLabel
	 */
	private JLabel kong;
	/**
	 * ����ȭ���� ��������� �����ϴ� ����
	 */
	private static Music mainBgm;

	/**
	 * ����ȭ���� ������� ��ü�� �����Ѵ�.
	 * 
	 * @return Music
	 * 
	 */
	public static Music getMainBgm() {
		return mainBgm;
	}

	/**
	 * �÷��̾ ���� ��ư�� ������ �� �����Ǵ� Ŭ�����̴�.
	 * 
	 * @author STF
	 *
	 */
	private class ExitButtonHandler extends MouseAdapter {

		/**
		 * @return void ���콺 Ŀ���� �����ư ���� ������ �� �߻��Ѵ�.
		 */
		public void mouseEntered(MouseEvent e) {
			new Music("Button.mp3", false).start();
			exitButton.setIcon(exitEntryBtnImg);
			exitButton.setBounds(29, 29, 130, 130);
			exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return void ���콺 Ŀ���� �����ư�� ���������� �ÿ� �߻��Ѵ�.
		 */
		public void mouseExited(MouseEvent e) {
			exitButton.setIcon(exitBaseBtnImg);
			exitButton.setBounds(30, 30, 110, 110);
			exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return void �����ư�� ������ �ÿ� �߻��Ѵ�.
		 */
		public void mousePressed(MouseEvent e) {
			// ���� �˾� â
			new ExitPopUpDialog().setVisible(true);
		}
	}

	/**
	 * �÷��̾ ������ư�� ������ �� �����Ǵ� Ŭ�����̴�.
	 * 
	 * @author STF
	 *
	 */
	private class StoreButtonHandler extends MouseAdapter {
		/**
		 * @return void ���콺 Ŀ���� ������ư ���� ������ �ÿ� �߻��Ѵ�.
		 */
		public void mouseEntered(MouseEvent e) {
			new Music("Button.mp3", false).start();
			storeButton.setIcon(storeEntryBtnImg);
			storeButton.setBounds(30, 770, 130, 150);
			storeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return void ���콺 Ŀ���� ������ư�� ���������� �ÿ� �߻��Ѵ�.
		 */
		public void mouseExited(MouseEvent e) {
			storeButton.setIcon(storeBaseBtnImg);
			storeButton.setBounds(35, 780, 120, 140);
			storeButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return void ������ư�� ������ �ÿ� �߻��Ѵ�.
		 */
		public void mousePressed(MouseEvent e) {
			// ���� �� ����
		}
	}

	/**
	 * �÷��̾ Ʃ�丮�� ��ư�� ������ �� �����Ǵ� Ŭ�����̴�.
	 * 
	 * @author STF
	 *
	 */
	private class TutorialButtonHandler extends MouseAdapter {
		/**
		 * @return void ���콺 Ŀ���� Ʃ�丮�� ��ư ���� ������ �ÿ� �߻��Ѵ�.
		 */
		public void mouseEntered(MouseEvent e) {
			new Music("Button.mp3", false).start();
			tutorialButton.setIcon(tutorialEntryBtnImg);
			tutorialButton.setBounds(1260, 780, 140, 160);
			tutorialButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return void ���콺 Ŀ���� Ʃ�丮�� ��ư�� ���������� �ÿ� �߻��Ѵ�.
		 */
		public void mouseExited(MouseEvent e) {
			tutorialButton.setIcon(tutorialBaseBtnImg);
			tutorialButton.setBounds(1280, 790, 110, 135);
			tutorialButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return void Ʃ�丮�� ��ư�� ������ �ÿ� �߻��ϰ� Ʃ�丮�� �˾� â�� �����Ѵ�.
		 */
		public void mousePressed(MouseEvent e) {
			// Ʃ�丮�� �˾� â
			new TutorialPopUpDialog().setVisible(true);
		}
	}

	/**
	 * �÷��̾ �̱��÷��� ��ư�� ������ �� �����Ǵ� Ŭ�����̴�.
	 * 
	 * @author STF
	 */
	private class SinglePlayButtonHandler extends MouseAdapter {
		/**
		 * @return void ���콺 Ŀ���� �̱��÷��� ��ư���� ������ �ÿ� �߻��Ѵ�.
		 */
		public void mouseEntered(MouseEvent e) {
			new Music("Button.mp3", false).start();
			singlePlayButton.setIcon(singlePlayEntryBtnImg);
			singlePlayButton.setBounds(513, 515, 415, 110);
			singlePlayButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return void ���콺 Ŀ���� �̱��÷��� ��ư�� ���������� �ÿ� �߻��Ѵ�.
		 */
		public void mouseExited(MouseEvent e) {
			singlePlayButton.setIcon(singlePlayBaseBtnImg);
			singlePlayButton.setBounds(520, 520, 400, 100);
			singlePlayButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return void �̱��÷��� ��ư�� ������ �ÿ� �߻��ϰ� �̱��÷��� ȭ������ �̵��Ѵ�.
		 */
		public void mousePressed(MouseEvent e) {
			// �̱� �÷��� ȭ������ �̵�
			mainBgm.close();
			GameFrame.getInstance().setContentPane(new SinglePlayScreen());
			GameFrame.getInstance().setVisible(true);

		}
	}

	/**
	 * �÷��̾ ��Ƽ�÷��� ��ư�� ������ �� �����Ǵ� Ŭ�����̴�.
	 * 
	 * @author STF
	 */
	private class MultiPlayButtonHandler extends MouseAdapter {

		/**
		 * @return void ���콺 Ŀ���� ��Ƽ�÷��� ��ư ���� ������ �ÿ� �߻��Ѵ�.
		 */
		public void mouseEntered(MouseEvent e) {
			new Music("Button.mp3", false).start();
			multiPlayButton.setIcon(multiPlayEntryBtnImg);
			multiPlayButton.setBounds(513, 665, 415, 110);
			multiPlayButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return void ���콺 Ŀ���� ��Ƽ�÷��� ��ư�� ���������� �ÿ� �߻��Ѵ�.
		 */
		public void mouseExited(MouseEvent e) {
			multiPlayButton.setIcon(multiPlayBaseBtnImg);
			multiPlayButton.setBounds(520, 670, 400, 100);
			multiPlayButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return void ��Ƽ�÷��� ��ư�� ������ �ÿ� �߻��ϰ� ��Ƽ�÷��� ȭ������ �̵��Ѵ�.
		 */
		public void mousePressed(MouseEvent e) {
			// ��Ƽ �÷��� - �渮��Ʈ ȭ������ �̵�
			// 13 -> �ӽ� �� ����
			new Music("Button.mp3", false).start();
			mainBgm.close();
			GameFrame.getInstance().setContentPane(new RoomListScreen(13));
			GameFrame.getInstance().setVisible(true);
		}
	}

	/**
	 * ����ȭ���� ����̹����� �ΰ��̹���, ���� ��ư, ���� ��ư, Ʃ�丮�� ��ư, �̱��÷��� ��ư, ��Ƽ�÷��� ��ư�� ���� �̹����� �����ϰ�
	 * ������ ��ư���� �гο� add�Ѵ�.
	 */
	public MainScreen() {
		setLayout(null);
		background = new ImageIcon("image/main/mainBackground.png");
		logo = new ImageIcon("image/main/logo.png");
		exitBaseBtnImg = new ImageIcon("image/main/sun1.png");
		exitEntryBtnImg = new ImageIcon("image/main/sun2.png");
		storeBaseBtnImg = new ImageIcon("image/main/store1.png");
		storeEntryBtnImg = new ImageIcon("image/main/store2.png");
		tutorialBaseBtnImg = new ImageIcon("image/main/tutorial1.png");
		tutorialEntryBtnImg = new ImageIcon("image/main/tutorial2.png");
		singlePlayBaseBtnImg = new ImageIcon("image/main/singlePlay1.png");
		singlePlayEntryBtnImg = new ImageIcon("image/main/singlePlay2.png");
		multiPlayBaseBtnImg = new ImageIcon("image/main/multiPlay1.png");
		multiPlayEntryBtnImg = new ImageIcon("image/main/multiPlay2.png");
		mainBgm = new Music("mainBgm.mp3", true);
		mainBgm.start();

		addExitButton();
		addStoreButton();
		addTutorialButton();
		addSinglePlayButton();
		addMultiPlayButton();
		addKongLabel();
	}

	/**
	 * @return void ���� ��ư�� �гο� �߰��ϴ� �޼����̴�.
	 */
	public void addExitButton() {
		exitButton = new JButton(exitBaseBtnImg);
		exitButton.setBounds(30, 30, 110, 110);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.setVisible(true);
		this.add(exitButton);
		exitButton.addMouseListener(new ExitButtonHandler());
	}

	/**
	 * @return void ���� ��ư�� �гο� �߰��ϴ� �޼����̴�.
	 */
	public void addStoreButton() {
		storeButton = new JButton(storeBaseBtnImg);
		storeButton.setBounds(35, 780, 120, 140);
		storeButton.setBorderPainted(false);
		storeButton.setContentAreaFilled(false);
		storeButton.setFocusPainted(false);
		storeButton.setVisible(true);
		this.add(storeButton);
		storeButton.addMouseListener(new StoreButtonHandler());
	}

	/**
	 * @return void Ʃ�丮�� ��ư�� �гο� �߰��ϴ� �޼����̴�.
	 */
	public void addTutorialButton() {
		tutorialButton = new JButton(tutorialBaseBtnImg);
		tutorialButton.setBounds(1280, 790, 110, 135);
		tutorialButton.setBorderPainted(false);
		tutorialButton.setContentAreaFilled(false);
		tutorialButton.setFocusPainted(false);
		tutorialButton.setVisible(true);
		this.add(tutorialButton);
		tutorialButton.addMouseListener(new TutorialButtonHandler());
	}

	/**
	 * @return void �̱��÷��� ��ư�� �гο� �߰��ϴ� �޼����̴�.
	 */
	public void addSinglePlayButton() {
		singlePlayButton = new JButton(singlePlayBaseBtnImg);
		singlePlayButton.setBounds(520, 520, 400, 100);
		singlePlayButton.setBorderPainted(false);
		singlePlayButton.setContentAreaFilled(false);
		singlePlayButton.setFocusPainted(false);
		singlePlayButton.setVisible(true);
		this.add(singlePlayButton);
		singlePlayButton.addMouseListener(new SinglePlayButtonHandler());
	}

	/**
	 * @return void ��Ƽ�÷��� ��ư�� �гο� �߰��ϴ� �޼����̴�.
	 */
	public void addMultiPlayButton() {
		multiPlayButton = new JButton(multiPlayBaseBtnImg);
		multiPlayButton.setBounds(520, 670, 400, 100);
		multiPlayButton.setBorderPainted(false);
		multiPlayButton.setContentAreaFilled(false);
		multiPlayButton.setFocusPainted(false);
		multiPlayButton.setVisible(true);
		this.add(multiPlayButton);
		multiPlayButton.addMouseListener(new MultiPlayButtonHandler());
	}

	/**
	 * @return void �÷��̾��� ���� �гο� �߰��ϴ� �޼����̴�.
	 */
	public void addKongLabel() {
		kong = new JLabel();
		kong.setBounds(1280, 60, 150, 30);
		kong.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 30));
		kong.setText("1,300 ��");
		this.add(kong);
	}

	/**
	 * paintComponent()�� ���� ����ȭ��(MainScreen)�� ����̹���, �ΰ��̹���, �����ư�̹����� �׸���.
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 1440, 960, null);
		g.drawImage(logo.getImage(), 260, 100, null);
		g.drawImage(exitBaseBtnImg.getImage(), 30, 30, 110, 110, null);
	}

}
