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
 * 로그인화면 이후 플레이어에게 제공되는 화면이다.
 * 
 * @author STF
 *
 */
public class MainScreen extends JPanel {
	private static final long serialVersionUID = 1L;
	/**
	 * 메인화면의 배경이미지를 저장하는 변수
	 */
	private ImageIcon background;
	/**
	 * 게임 제목을 저장하는 변수
	 */
	private ImageIcon logo;
	/**
	 * 종료 버튼의 이미지 : 마우스 커서가 버튼 내에 있지 않은 경우
	 */
	private ImageIcon exitBaseBtnImg;
	/**
	 * 종료 버튼의 이미지 : 마우스 커서가 버튼 내에 있는 경우
	 */
	private ImageIcon exitEntryBtnImg;
	/**
	 * 상점 버튼의 이미지 : 마우스 커서가 버튼 내에 있는 경우
	 */
	private ImageIcon storeEntryBtnImg;
	/**
	 * 상점 버튼의 이미지 : 마우스 커서가 버튼 내에 있지 않은 경우
	 */
	private ImageIcon storeBaseBtnImg;
	/**
	 * 튜토리얼 버튼의 이미지 : 마우스 커서가 버튼 내에 있는 경우
	 */
	private ImageIcon tutorialEntryBtnImg;
	/**
	 * 튜토리얼 버튼의 이미지 : 마우스 커서가 버튼 내에 있지 않은 경우
	 */
	private ImageIcon tutorialBaseBtnImg;
	/**
	 * 싱글플레이 버튼의 이미지 : 마우스 커서가 버튼 내에 있는 경우
	 */
	private ImageIcon singlePlayEntryBtnImg;
	/**
	 * 싱글플레이 버튼의 이미지 : 마우스 커서가 버튼 내에 있지 않은 경우
	 */
	private ImageIcon singlePlayBaseBtnImg;
	/**
	 * 멀티플레이 버튼의 이미지 : 마우스 커서가 버튼 내에 있는 경우
	 */
	private ImageIcon multiPlayEntryBtnImg;
	/**
	 * 멀티플레이 버튼의 이미지 : 마우스 커서가 버튼 내에 있지 않은 경우
	 */
	private ImageIcon multiPlayBaseBtnImg;
	/**
	 * 종료 버튼
	 */
	private JButton exitButton;
	/**
	 * 상점 버튼
	 */
	private JButton storeButton;
	/**
	 * 튜토리얼 버튼
	 */
	private JButton tutorialButton;
	/**
	 * 싱글플레이 버튼
	 */
	private JButton singlePlayButton;
	/**
	 * 멀티플레이 버튼
	 */
	private JButton multiPlayButton;
	/**
	 * 플레이어의 콩을 나타내는 JLabel
	 */
	private JLabel kong;
	/**
	 * 메인화면의 배경음악을 저장하는 변수
	 */
	private static Music mainBgm;

	/**
	 * 메인화면의 배경음악 객체를 리턴한다.
	 * 
	 * @return Music
	 * 
	 */
	public static Music getMainBgm() {
		return mainBgm;
	}

	/**
	 * 플레이어가 종료 버튼을 눌렀을 시 생성되는 클래스이다.
	 * 
	 * @author STF
	 *
	 */
	private class ExitButtonHandler extends MouseAdapter {

		/**
		 * @return void 마우스 커서가 종료버튼 내에 들어왔을 시 발생한다.
		 */
		public void mouseEntered(MouseEvent e) {
			new Music("Button.mp3", false).start();
			exitButton.setIcon(exitEntryBtnImg);
			exitButton.setBounds(29, 29, 130, 130);
			exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return void 마우스 커서가 종료버튼을 빠져나갔을 시에 발생한다.
		 */
		public void mouseExited(MouseEvent e) {
			exitButton.setIcon(exitBaseBtnImg);
			exitButton.setBounds(30, 30, 110, 110);
			exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return void 종료버튼을 눌렀을 시에 발생한다.
		 */
		public void mousePressed(MouseEvent e) {
			// 종료 팝업 창
			new ExitPopUpDialog().setVisible(true);
		}
	}

	/**
	 * 플레이어가 상점버튼을 눌렀을 시 생성되는 클래스이다.
	 * 
	 * @author STF
	 *
	 */
	private class StoreButtonHandler extends MouseAdapter {
		/**
		 * @return void 마우스 커서가 상점버튼 내에 들어왔을 시에 발생한다.
		 */
		public void mouseEntered(MouseEvent e) {
			new Music("Button.mp3", false).start();
			storeButton.setIcon(storeEntryBtnImg);
			storeButton.setBounds(30, 770, 130, 150);
			storeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return void 마우스 커서가 상점버튼을 빠져나갔을 시에 발생한다.
		 */
		public void mouseExited(MouseEvent e) {
			storeButton.setIcon(storeBaseBtnImg);
			storeButton.setBounds(35, 780, 120, 140);
			storeButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return void 상점버튼을 눌렀을 시에 발생한다.
		 */
		public void mousePressed(MouseEvent e) {
			// 상점 미 오픈
		}
	}

	/**
	 * 플레이어가 튜토리얼 버튼을 눌렀을 시 생성되는 클래스이다.
	 * 
	 * @author STF
	 *
	 */
	private class TutorialButtonHandler extends MouseAdapter {
		/**
		 * @return void 마우스 커서가 튜토리얼 버튼 내에 들어왔을 시에 발생한다.
		 */
		public void mouseEntered(MouseEvent e) {
			new Music("Button.mp3", false).start();
			tutorialButton.setIcon(tutorialEntryBtnImg);
			tutorialButton.setBounds(1260, 780, 140, 160);
			tutorialButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return void 마우스 커서가 튜토리얼 버튼을 빠져나갔을 시에 발생한다.
		 */
		public void mouseExited(MouseEvent e) {
			tutorialButton.setIcon(tutorialBaseBtnImg);
			tutorialButton.setBounds(1280, 790, 110, 135);
			tutorialButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return void 튜토리얼 버튼을 눌렀을 시에 발생하고 튜토리얼 팝업 창을 생성한다.
		 */
		public void mousePressed(MouseEvent e) {
			// 튜토리얼 팝업 창
			new TutorialPopUpDialog().setVisible(true);
		}
	}

	/**
	 * 플레이어가 싱글플레이 버튼을 눌렀을 시 생성되는 클래스이다.
	 * 
	 * @author STF
	 */
	private class SinglePlayButtonHandler extends MouseAdapter {
		/**
		 * @return void 마우스 커서가 싱글플레이 버튼내에 들어왔을 시에 발생한다.
		 */
		public void mouseEntered(MouseEvent e) {
			new Music("Button.mp3", false).start();
			singlePlayButton.setIcon(singlePlayEntryBtnImg);
			singlePlayButton.setBounds(513, 515, 415, 110);
			singlePlayButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return void 마우스 커서가 싱글플레이 버튼을 빠져나갔을 시에 발생한다.
		 */
		public void mouseExited(MouseEvent e) {
			singlePlayButton.setIcon(singlePlayBaseBtnImg);
			singlePlayButton.setBounds(520, 520, 400, 100);
			singlePlayButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return void 싱글플레이 버튼을 눌렀을 시에 발생하고 싱글플레이 화면으로 이동한다.
		 */
		public void mousePressed(MouseEvent e) {
			// 싱글 플레이 화면으로 이동
			mainBgm.close();
			GameFrame.getInstance().setContentPane(new SinglePlayScreen());
			GameFrame.getInstance().setVisible(true);

		}
	}

	/**
	 * 플레이어가 멀티플레이 버튼을 눌렀을 시 생성되는 클래스이다.
	 * 
	 * @author STF
	 */
	private class MultiPlayButtonHandler extends MouseAdapter {

		/**
		 * @return void 마우스 커서가 멀티플레이 버튼 내에 들어왔을 시에 발생한다.
		 */
		public void mouseEntered(MouseEvent e) {
			new Music("Button.mp3", false).start();
			multiPlayButton.setIcon(multiPlayEntryBtnImg);
			multiPlayButton.setBounds(513, 665, 415, 110);
			multiPlayButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return void 마우스 커서가 멀티플레이 버튼을 빠져나갔을 시에 발생한다.
		 */
		public void mouseExited(MouseEvent e) {
			multiPlayButton.setIcon(multiPlayBaseBtnImg);
			multiPlayButton.setBounds(520, 670, 400, 100);
			multiPlayButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return void 멀티플레이 버튼을 눌렀을 시에 발생하고 멀티플레이 화면으로 이동한다.
		 */
		public void mousePressed(MouseEvent e) {
			// 멀티 플레이 - 방리스트 화면으로 이동
			// 13 -> 임시 방 개수
			new Music("Button.mp3", false).start();
			mainBgm.close();
			GameFrame.getInstance().setContentPane(new RoomListScreen(13));
			GameFrame.getInstance().setVisible(true);
		}
	}

	/**
	 * 메인화면의 배경이미지와 로고이미지, 종료 버튼, 상점 버튼, 튜토리얼 버튼, 싱글플레이 버튼, 멀티플레이 버튼에 대한 이미지를 생성하고
	 * 각각의 버튼들을 패널에 add한다.
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
	 * @return void 종료 버튼을 패널에 추가하는 메서드이다.
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
	 * @return void 상점 버튼을 패널에 추가하는 메서드이다.
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
	 * @return void 튜토리얼 버튼을 패널에 추가하는 메서드이다.
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
	 * @return void 싱글플레이 버튼을 패널에 추가하는 메서드이다.
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
	 * @return void 멀티플레이 버튼을 패널에 추가하는 메서드이다.
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
	 * @return void 플레이어의 콩을 패널에 추가하는 메서드이다.
	 */
	public void addKongLabel() {
		kong = new JLabel();
		kong.setBounds(1280, 60, 150, 30);
		kong.setFont(new Font("배달의민족 주아", Font.PLAIN, 30));
		kong.setText("1,300 콩");
		this.add(kong);
	}

	/**
	 * paintComponent()를 통해 메인화면(MainScreen)의 배경이미지, 로고이미지, 종료버튼이미지를 그린다.
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 1440, 960, null);
		g.drawImage(logo.getImage(), 260, 100, null);
		g.drawImage(exitBaseBtnImg.getImage(), 30, 30, 110, 110, null);
	}

}
