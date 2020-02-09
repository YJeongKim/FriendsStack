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
 * 튜토리얼 팝업 창에서 싱글플레이 버튼을 눌렀을 시 플레이어에게 제공하는 화면이다.
 * 
 * @author SnackTimeFriends
 *
 */
public class SingleTutorialScreen extends JPanel {
	private static final long serialVersionUID = 1L;
	/**
	 * 싱글플레이 튜토리얼의 모든 페이지에 대한 이미지들을 저장하고 있는 변수
	 */
	private ImageIcon[] single;
	/**
	 * 이전페이지 버튼의 이미지: 마우스 커서가 버튼 내에 있지 않은 경우
	 */
	private ImageIcon previousBaseBtnImg;
	/**
	 * 이전페이지 버튼의 이미지: 마우스 커서가 버튼 내에 있는 경우
	 */
	private ImageIcon previousEntryBtnImg;
	/**
	 * 다음페이지 버튼의 이미지: 마우스 커서가 버튼 내에 있지 않은 경우
	 */
	private ImageIcon nextBaseBtnImg;
	/**
	 * 다음페이지 버튼의 이미지: 마우스 커서가 버튼 내에 있는 경우
	 */
	private ImageIcon nextEntryBtnImg;
	/**
	 * 일시정지 버튼의 이미지: 마우스 커서가 버튼 내에 있지 않은 경우
	 */
	private ImageIcon pauseBaseBtnImg;
	/**
	 * 일시정지 버튼의 이미지: 마우스 커서가 버튼 내에 있는 경우
	 */
	private ImageIcon pauseEntryBtnImg;
	/**
	 * 싱글플레이 튜토리얼 화면의 이전페이지 버튼
	 */
	private JButton previousButton;
	/**
	 * 멀티플레이 튜토리얼 화면의 다음페이지 버튼
	 */
	private JButton nextButton;
	/**
	 * 멀티플레이 튜토리얼 화면의 일시정지 버튼
	 */
	private JButton pauseButton;
	/**
	 * 멀티튜토리얼의 페이지를 나타내는 변수
	 */
	private JLabel pageLabel;
	/**
	 * 멀티튜토리얼의 현재 페이지를 나타내는 변수
	 */
	private int page;
	/**
	 * 튜토리얼 화면 내의 버튼에 대한 효과음을 저장하는 변수
	 */
	private Music btnSound;
	/**
	 * 튜토리얼 화면의 배경음악을 저장하는 변수
	 */
	private Music bgm;

	/**
	 * 플레이어가 이전페이지 버튼을 눌렀을 때 생성되는 클래스이다.
	 * 
	 * @author SnackTimeFriends
	 */
	private class PreviousButtonHandler extends MouseAdapter {
		/**
		 * return 타입: void 마우스 커서가 이전 페이지 버튼 내에 들어왔을 시 발생한다.
		 */
		public void mouseEntered(MouseEvent e) {
			btnSound = new Music("Button.mp3", false);
			btnSound.start();
			previousButton.setIcon(previousEntryBtnImg);
			previousButton.setBounds(435, 891, 120, 65);
			previousButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * return 타입: void 마우스 커서가 이전 페이지 버튼을 빠져나갔을 시 발생한다.
		 */
		public void mouseExited(MouseEvent e) {
			previousButton.setIcon(previousBaseBtnImg);
			previousButton.setBounds(440, 892, 110, 63);
			previousButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * return 타입: void 이전 페이지 버튼을 눌렀을 시 발생하고 현재 페이지에서 하나 전 페이지로 이동한다. 만약 이전 페이지 버튼을
		 * 눌렀을 시 현재 페이지가 첫 번째 페이지였다면, 튜토리얼의 맨 뒤 페이지로 이동한다.
		 */
		public void mousePressed(MouseEvent e) {
			// 이전 페이지로 이동
			if (page == 0)
				page = single.length - 1;
			else
				page--;
			pageLabel.setText((page + 1) + "/" + single.length);
			repaint();
		}
	}

	/**
	 * 플레이어가 다음페이지 버튼을 눌렀을 때 생성되는 클래스이다.
	 * 
	 * @author SnackTimeFriends
	 */
	private class NextButtonHandler extends MouseAdapter {
		/**
		 * return 타입: void 마우스 커서가 다음 페이지 버튼 내에 들어왔을 시 발생한다.
		 */
		public void mouseEntered(MouseEvent e) {
			btnSound = new Music("Button.mp3", false);
			btnSound.start();
			nextButton.setIcon(nextEntryBtnImg);
			nextButton.setBounds(915, 891, 120, 65);
			nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * return 타입: void 마우스 커서가 다음 페이지 버튼을 빠져나갔을 시 발생한다.
		 */
		public void mouseExited(MouseEvent e) {
			nextButton.setIcon(nextBaseBtnImg);
			nextButton.setBounds(920, 892, 110, 63);
			nextButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * return 타입: void 다음 페이지 버튼을 눌렀을 시 발생하고 현재 페이지에서 하나 뒤 페이지로 이동한다. 만약 이전 페이지 버튼을
		 * 눌렀을 시 현재 페이지가 맨 뒤 페이지였다면, 튜토리얼의 맨 앞 페이지로 이동한다.
		 */
		public void mousePressed(MouseEvent e) {
			// 다음 페이지로 이동
			if (page == single.length - 1)
				page = 0;
			else
				page++;
			pageLabel.setText((page + 1) + "/" + single.length);
			repaint();
		}
	}

	/**
	 * 플레이어가 일시정지 버튼을 눌렀을 때 생성되는 클래스이다.
	 * 
	 * @author SnackTimeFriends
	 */
	private class PauseButtonHandler extends MouseAdapter {

		/**
		 * return 타입: void 마우스 커서가 일시정지 버튼 내에 들어왔을 시 발생한다.
		 */
		public void mouseEntered(MouseEvent e) {
			btnSound = new Music("Button.mp3", false);
			btnSound.start();
			pauseButton.setIcon(pauseEntryBtnImg);
			pauseButton.setBounds(675, 891, 120, 65);
			pauseButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * return 타입: void 마우스 커서가 일시정지 버튼을 빠져나갔을 시 발생한다.
		 */
		public void mouseExited(MouseEvent e) {
			pauseButton.setIcon(pauseBaseBtnImg);
			pauseButton.setBounds(680, 892, 110, 63);
			pauseButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * 일시정지 버튼을 눌렀을 시 발생하고, 튜토리얼 일시정지 팝업창(TutorialPausePopUpDialog)을 플레이어에게 제공한다.
		 */
		public void mousePressed(MouseEvent e) {
			// 일시정지 팝업 창
			new TutorialPausePopUpDialog(bgm).setVisible(true);
		}
	}

	/**
	 * 싱글플레이 튜토리얼 각각의 페이지에 해당하는 이미지와 이전페이지 버튼, 다음페이지 버튼, 일시정지 버튼에 대한 이미지를 생성하고 각각의
	 * 버튼과 페이지 JLabel을 패널에 add한다.
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
	 * return 타입: void 이전페이지 버튼을 패널에 추가하는 메서드이다.
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
	 * return 타입: void 다음페이지 버튼을 패널에 추가하는 메서드이다.
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
	 * return 타입: void 일시정지 버튼을 패널에 추가하는 메서드이다.
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
	 * return 타입: void 싱글튜토리얼 화면에 페이지 라벨을 추가하는 메서드이다.
	 */
	public void addPageLabel() {
		pageLabel = new JLabel();
		pageLabel.setBounds(1310, 910, 110, 30);
		pageLabel.setFont(new Font("배달의민족 주아", Font.PLAIN, 40));
		pageLabel.setForeground(Color.white);
		pageLabel.setText((page + 1) + "/" + single.length);
		this.add(pageLabel);
	}

	/**
	 * paintComponent()를 통해 싱글플레이 튜토리얼 화면(SingleTutorialScreen)의 배경이미지를 그린다.
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(single[page].getImage(), 0, 0, 1440, 960, null);
	}

}
