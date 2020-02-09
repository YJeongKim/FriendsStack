package snackFriends.view.multiPlay;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import snackFriends.view.bean.Box;
import snackFriends.view.bean.GameFrame;
import snackFriends.view.bean.SelectAnimal;

/**
 * 메인화면에서 플레이어가 멀티플레이 버튼을 눌렀을 시 제공되는 화면에 대한 클래스이다.
 * @author SnackTimeFriends
 *
 */
public class MultiPlayScreen extends JPanel {
	private static final long serialVersionUID = 1L;
	/**
	 * 멀티 플레이 화면의 배경 이미지를 저장하는 변수
	 */
	private ImageIcon background;
	/**
	 * 
	 */
	private ImageIcon skyground;
	/**
	 * 
	 */
	private ImageIcon backgroundCut1;
	/**
	 * 
	 */
	private ImageIcon backgroundCut2;
	/**
	 * 
	 */
	private ImageIcon[] animalIcons;
	/**
	 * 
	 */
	private ImageIcon exitBaseBtnImg;
	/**
	 * 
	 */
	private ImageIcon exitEntryBtnImg;
	/**
	 * 
	 */
	private ImageIcon tipBtnImg;
	/**
	 * 
	 */
	private ImageIcon chatBaseBtnImg;
	/**
	 * 
	 */
	private ImageIcon chatEntryBtnImg;
	/**
	 * 
	 */
	private ImageIcon titleLabelImg;
	/**
	 * 
	 */
	private ArrayList<JButton> iconButtons;
	/**
	 * 
	 */
	private JButton exitButton;
	/**
	 * 
	 */
	private JButton tipButton;
	/**
	 * 
	 */
	private JButton chatButton;
	/**
	 * 
	 */
	private JLabel exitLabel;// 전원버튼 레이블
	/**
	 * 
	 */
	private JLabel chatLabel;// 채팅 레이블
	/**
	 * 
	 */
	private JLabel timebarLabel;// 타임바 레이블
	/**
	 * 
	 */
	private JLabel roomTitleLabel;// 제목 레이블
	/**
	 * 
	 */
	private boolean isOut; // 방 나가기 flag
	/**
	 * 
	 */
	private boolean check;
	/**
	 * 
	 */
	private Random random = new Random();
	/**
	 * 
	 */
	public static int boxHeight = 900;// 박스의 높이
	/**
	 * 
	 */
	private int mapHeight = 5012;// 맵의 높이
	/**
	 * 
	 */
	private ArrayList<Box> boxAry = new ArrayList<Box>();// 블록쌓기저장
	/**
	 * 
	 */
	private ArrayList<String> BoxTypeList = new ArrayList<String>();// 박스타입저장

	/**
	 * 메인화면(MainScreen)에서 멀티플레이(MultiPlayScreen)버튼을 눌렀을 시 플레이어에게 제공되는 화면이다.
	 * @author STF
	 *
	 */
	private class ExitButtonHandler extends MouseAdapter {
		/**
		 * 
		 * 마우스 커서가 전원(방 나가기)버튼 내에 들어왔을 시 발생한다. 
		 */
		public void mouseEntered(MouseEvent e) {
			exitButton.setIcon(exitEntryBtnImg);
			exitButton.setBounds(999, 69, 82, 82);
			exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return 
		 * 마우스 커서가 전원(방 나가기)버튼을 빠져나갔을 시 발생한다. 
		 */
		public void mouseExited(MouseEvent e) {
			exitButton.setIcon(exitBaseBtnImg);
			exitButton.setBounds(1000, 70, 80, 80);
			exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return 
		 * 전원(방 나가기)버튼을 눌렀을 시 발생한다. 만약 게임 시작 전이라면 방 리스트 화면으로 이동하고, 게임 진행 중일 경우 방 나가기 예약을 한다.
		 */
		public void mousePressed(MouseEvent e) {
			String str;
			exitLabel.setVisible(true);
			if (isOut == false) {
				str = "방 나가기를 예약하셨습니다.";
				isOut = true;
			} else {
				str = "방 나가기를 취소하셨습니다.";
				isOut = false;
			}
			exitLabel.setText(str);
			clear(exitLabel);
			new RankPopUpDialog().setVisible(true);
		}
	}

	
	public class TipButtonHandler extends MouseAdapter {
		/**
		 * @return 
		 * 마우스 커서가 ?(팁)버튼 내에 들어왔을 시 발생한다. 
		 */
		public void mouseEntered(MouseEvent e) {
			tipButton.setIcon(tipBtnImg);
			tipButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return 
		 * 마우스 커서가 ?(팁)버튼을  빠져나왔을 시 발생한다.
		 */
		public void mouseExited(MouseEvent e) {
			tipButton.setIcon(null);
			tipButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		
		/**
		 * @return 
		 * ?(팁)버튼을 눌렀을 시 발생하고 팁 팝업 창을 플레이어에게 제공한다. 
		 */
		public void mousePressed(MouseEvent e) {
			// 팁 팝업창 띄우기
			new TipPopUpDialog().setVisible(true);
		}
	}

	public class ChatButtonHandler extends MouseAdapter {
		
		/**
		 * @return 
		 * 마우스 커서가 채팅 버튼 내에 들어왔을 시 발생한다. 
		 */		
		public void mouseEntered(MouseEvent e) {
			chatButton.setIcon(chatEntryBtnImg);
			chatButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
	
		/**
		 * @return 
		 * 마우스 커서가 채팅 버튼을  빠져나왔을 시 발생한다.
		 */		
		public void mouseExited(MouseEvent e) {
			chatButton.setIcon(chatBaseBtnImg);
			chatButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	
		/**
		 * @return 
		 * 채팅버튼을 눌렀을 시 발생하고 채팅 팝업 창을 플레이어에게 제공한다. 
		 */
		public void mousePressed(MouseEvent e) {
			// 채팅 팝업창 띄우기
			new ChatPopUpDialog(chatLabel).setVisible(true);
			clear(chatLabel);
		}
	}

	private class IconButtonHandler extends MouseAdapter {
		/**
		 * index 타입: int
		 * 플레이어가 선택한 Icon의 번호를 저장하기 위한 변수이다.
		 */
		private int index;

		/**
		 * 플레이어가 선택한 Icon의 번호를 저장한다.
		 * @param index 타입: int
		 */
		public IconButtonHandler(int index) {
			this.index = index;
		}

		/**
		 * @return 
		 * 마우스 커서가 아이콘 버튼 내에 들어왔을 시 발생한다. 
		 */
		public void mouseEntered(MouseEvent e) {
			((JButton) e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		/**
		 * @return 
		 * 마우스 커서가 아이콘 버튼을  빠져나왔을 시 발생한다.
		 */
		@Override
		public void mouseExited(MouseEvent e) {
			((JButton) e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return 
		 * 아이콘 버튼을 눌렀을 시 발생하고   
		 */
		@Override
		public void mouseClicked(MouseEvent e) {
			Box box = new Box(BoxTypeList.get(index), boxHeight, "multi");
			SelectAnimal.getInstance(GameFrame.getInstance(), box);
			box.start();
			boxAry.add(box);
			boxHeight -= 165;
			System.out.println(boxHeight);
			lockHeight();
			((JButton) e.getSource()).setVisible(false);
			repaint();
		}

		/**
		 * @return 
		 * 
		 */
		public void lockHeight() {
			if (boxHeight <= 200) {
				for (Box b : boxAry) {
					b.setBoxHeight(b.getBoxHeight() + 165);
				}
				boxHeight = 240;
			}
			// 타임바 갱신
			timebarLabel.setVisible(false);
			if (check = !check)
				timebarLabel.setIcon(new ImageIcon("image/multi/timebar1.gif"));
			else
				timebarLabel.setIcon(new ImageIcon("image/multi/timebar2.gif"));
			timebarLabel.setVisible(true);
			// repaint();
			// reGame(FriendsStack.getInstance());
		}
	}

	/**
	 * 채팅 팝업 창의 배경이미지와 각각의 이모티콘 버튼에 대한 이미지를 생성하고 패널에 add한다.
	 * 멀티플레이(MultiPlayScreen)화면에 exit(방 나가기)버튼, 
	 */
	public MultiPlayScreen() {
		setLayout(null);
		background = new ImageIcon("image/multi/background.png");
		backgroundCut1 = new ImageIcon("image/multi/backgroundCut1.png");
		backgroundCut2 = new ImageIcon("image/multi/backgroundCut2.png");
		skyground = new ImageIcon("image/multi/skyground.png");
		exitBaseBtnImg = new ImageIcon("image/multi/exit1.png");
		exitEntryBtnImg = new ImageIcon("image/multi/exit2.png");
		tipBtnImg = new ImageIcon("image/multi/tip.png");
		chatBaseBtnImg = new ImageIcon("image/multi/chat1.png");
		chatEntryBtnImg = new ImageIcon("image/multi/chat2.png");
		titleLabelImg = new ImageIcon("image/multi/title.png");
		addExitButton();
		addTipButton();
		addChatButton();
		addIconButton();
		addChatLabel();
		addTimebarLabel();
		addRoomTitleLabel();
	}

	/**
	 * @return 
	 * 이전페이지 버튼을 패널에 추가하는 메서드이다.
	 */
	public void addExitButton() {
		exitButton = new JButton(exitBaseBtnImg);
		exitButton.setBounds(1000, 70, 80, 80);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.setVisible(true);
		this.add(exitButton);
		exitButton.addMouseListener(new ExitButtonHandler());

		exitLabel = new JLabel();
		exitLabel.setFont(new Font("배달의민족 주아", Font.PLAIN, 24));
		exitLabel.setBounds(840, 800, 400, 100);
		this.add(exitLabel);
	}

	/**
	 * @return 
	 * 이전페이지 버튼을 패널에 추가하는 메서드이다.
	 */
	public void addTipButton() {
		tipButton = new JButton();
		tipButton.setBounds(1130, 770, 245, 138);
		tipButton.setBorderPainted(false);
		tipButton.setContentAreaFilled(false);
		tipButton.setFocusPainted(false);
		tipButton.setVisible(true);
		this.add(tipButton);
		tipButton.addMouseListener(new TipButtonHandler());
	}

	/**
	 * @return 
	 * 이전페이지 버튼을 패널에 추가하는 메서드이다.
	 */
	public void addChatButton() {
		chatButton = new JButton(chatBaseBtnImg);
		chatButton.setBounds(370, 805, 100, 77);
		chatButton.setBorderPainted(false);
		chatButton.setContentAreaFilled(false);
		chatButton.setFocusPainted(false);
		chatButton.setVisible(true);
		this.add(chatButton);
		chatButton.addMouseListener(new ChatButtonHandler());
	}

	/**
	 * @return 
	 * 이전페이지 버튼을 패널에 추가하는 메서드이다.
	 */
	public void addIconButton() {
		initiconButtons();
		for (int i = 0; i < 12; i++) {
			int randNum = random.nextInt(animalIcons.length);
			iconButtons.add(new JButton(animalIcons[randNum]));
			JButton block = iconButtons.get(i);
			if (i < 6) {
				block.setBounds(1138, 58 + (116 * i), 106, 109);
			} else {
				block.setBounds(1260, 58 + (116 * (i - 6)), 106, 109);
			}
			block.setBorderPainted(false);
			block.setContentAreaFilled(false);
			block.setFocusPainted(false);
			block.setVisible(true);
			block.addMouseListener(new IconButtonHandler(randNum));
			this.add(block);
		}
	}

	/**
	 * @return 
	 * 이전페이지 버튼을 패널에 추가하는 메서드이다.
	 */
	public void addChatLabel() {
		chatLabel = new JLabel();
		chatLabel.setBounds(310, 600, 160, 160);
		chatLabel.setVisible(false);
		this.add(chatLabel);
	}

	/**
	 * @return 
	 * 이전페이지 버튼을 패널에 추가하는 메서드이다.
	 */
	public void addTimebarLabel() {
		timebarLabel = new JLabel();
		timebarLabel.setBounds(520, 160, 322, 22);
		timebarLabel.setVisible(false);
		this.add(timebarLabel);
	}

	/**
	 * @return 
	 * 이전페이지 버튼을 패널에 추가하는 메서드이다.
	 */
	public void addRoomTitleLabel() {
		roomTitleLabel = new JLabel(titleLabelImg);
		roomTitleLabel.setBounds(400, 75, 550, 68);
		roomTitleLabel.setFont(new Font("배달의민족 주아", Font.BOLD, 30));
		roomTitleLabel.setHorizontalTextPosition(JLabel.CENTER);
		roomTitleLabel.setText("이곳에는 방 제목이 표시됩니다.");
		this.add(roomTitleLabel);
	}

	/**
	 * @return 
	 * 박스 
	 */
	public void initiconButtons() {
		BoxTypeList.add("bearBox_friendly");
		BoxTypeList.add("bearBox_private");
		BoxTypeList.add("bearBox_public");
		BoxTypeList.add("beeBox_friendly");
		BoxTypeList.add("beeBox_private");
		BoxTypeList.add("beeBox_public");
		BoxTypeList.add("catBox_friendly");
		BoxTypeList.add("catBox_private");
		BoxTypeList.add("catBox_public");
		BoxTypeList.add("dogBox_friendly");
		BoxTypeList.add("dogBox_private");
		BoxTypeList.add("dogBox_public");
		BoxTypeList.add("rabbitBox_friendly");
		BoxTypeList.add("rabbitBox_private");
		BoxTypeList.add("rabbitBox_public");
		BoxTypeList.add("lionBox");

		animalIcons = new ImageIcon[BoxTypeList.size()];
		iconButtons = new ArrayList<>();

		for (int i = 0; i < BoxTypeList.size(); i++)
			animalIcons[i] = new ImageIcon("image/boxIcon/" + BoxTypeList.get(i) + ".png");
	}

	/**	
	 * @return 
	 * paintComponent()를 통해 멀티플레이화면(MultiPlayScreen)의 배경이미지를 그린다.
	 */		
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 1440, 961, null);
		g.drawImage(skyground.getImage(), 342, 0, 1105, 970, 0, mapHeight - 970, 842, mapHeight, null);
		boxComponent(g);// 박스 화면 출력
		g.drawImage(backgroundCut1.getImage(), 340, 910, 778, 51, null);
		g.drawImage(backgroundCut2.getImage(), 340, 0, 778, 49, null);
		repaint();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return 
	 * @param g 타입 : Graphics
	 */
	public void boxComponent(Graphics g) {
		if (boxAry.size() > 4) {
			if (mapHeight >= 1067)
				mapHeight -= 97;
			boxAry.remove(0);
		}
		for (Box b : boxAry) {
			b.drawBox(g);
		}
	}

	/**
	 * @return 
	 * 이모티콘을 3초 동안 출력하는 메서드이다.
	 * @param label 타입: JLabel - 플레이어가 선택한 이모티콘이 그려진 JLabel 변수이다.
	 */
	public void clear(JLabel label) {
		Timer timer = new Timer();
		TimerTask m_task = new TimerTask() {
			public void run() {
				label.setVisible(false);
			}
		};
		timer.schedule(m_task, 3000);
	}

	/**
	 * @return 
	 * 결과 팝업 창 10초후 게임을 재시작하는 메서드이다.
	 */
	public void reGame() {
		Timer timer = new Timer();
		TimerTask m_task = new TimerTask() {
			public void run() {
				new RankPopUpDialog().setVisible(true);
			}
		};
		timer.schedule(m_task, 10000);
	}

}