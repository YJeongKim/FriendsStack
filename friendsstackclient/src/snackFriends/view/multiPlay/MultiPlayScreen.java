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
 * ����ȭ�鿡�� �÷��̾ ��Ƽ�÷��� ��ư�� ������ �� �����Ǵ� ȭ�鿡 ���� Ŭ�����̴�.
 * @author SnackTimeFriends
 *
 */
public class MultiPlayScreen extends JPanel {
	private static final long serialVersionUID = 1L;
	/**
	 * ��Ƽ �÷��� ȭ���� ��� �̹����� �����ϴ� ����
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
	private JLabel exitLabel;// ������ư ���̺�
	/**
	 * 
	 */
	private JLabel chatLabel;// ä�� ���̺�
	/**
	 * 
	 */
	private JLabel timebarLabel;// Ÿ�ӹ� ���̺�
	/**
	 * 
	 */
	private JLabel roomTitleLabel;// ���� ���̺�
	/**
	 * 
	 */
	private boolean isOut; // �� ������ flag
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
	public static int boxHeight = 900;// �ڽ��� ����
	/**
	 * 
	 */
	private int mapHeight = 5012;// ���� ����
	/**
	 * 
	 */
	private ArrayList<Box> boxAry = new ArrayList<Box>();// ��Ͻױ�����
	/**
	 * 
	 */
	private ArrayList<String> BoxTypeList = new ArrayList<String>();// �ڽ�Ÿ������

	/**
	 * ����ȭ��(MainScreen)���� ��Ƽ�÷���(MultiPlayScreen)��ư�� ������ �� �÷��̾�� �����Ǵ� ȭ���̴�.
	 * @author STF
	 *
	 */
	private class ExitButtonHandler extends MouseAdapter {
		/**
		 * 
		 * ���콺 Ŀ���� ����(�� ������)��ư ���� ������ �� �߻��Ѵ�. 
		 */
		public void mouseEntered(MouseEvent e) {
			exitButton.setIcon(exitEntryBtnImg);
			exitButton.setBounds(999, 69, 82, 82);
			exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return 
		 * ���콺 Ŀ���� ����(�� ������)��ư�� ���������� �� �߻��Ѵ�. 
		 */
		public void mouseExited(MouseEvent e) {
			exitButton.setIcon(exitBaseBtnImg);
			exitButton.setBounds(1000, 70, 80, 80);
			exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return 
		 * ����(�� ������)��ư�� ������ �� �߻��Ѵ�. ���� ���� ���� ���̶�� �� ����Ʈ ȭ������ �̵��ϰ�, ���� ���� ���� ��� �� ������ ������ �Ѵ�.
		 */
		public void mousePressed(MouseEvent e) {
			String str;
			exitLabel.setVisible(true);
			if (isOut == false) {
				str = "�� �����⸦ �����ϼ̽��ϴ�.";
				isOut = true;
			} else {
				str = "�� �����⸦ ����ϼ̽��ϴ�.";
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
		 * ���콺 Ŀ���� ?(��)��ư ���� ������ �� �߻��Ѵ�. 
		 */
		public void mouseEntered(MouseEvent e) {
			tipButton.setIcon(tipBtnImg);
			tipButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return 
		 * ���콺 Ŀ���� ?(��)��ư��  ���������� �� �߻��Ѵ�.
		 */
		public void mouseExited(MouseEvent e) {
			tipButton.setIcon(null);
			tipButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		
		/**
		 * @return 
		 * ?(��)��ư�� ������ �� �߻��ϰ� �� �˾� â�� �÷��̾�� �����Ѵ�. 
		 */
		public void mousePressed(MouseEvent e) {
			// �� �˾�â ����
			new TipPopUpDialog().setVisible(true);
		}
	}

	public class ChatButtonHandler extends MouseAdapter {
		
		/**
		 * @return 
		 * ���콺 Ŀ���� ä�� ��ư ���� ������ �� �߻��Ѵ�. 
		 */		
		public void mouseEntered(MouseEvent e) {
			chatButton.setIcon(chatEntryBtnImg);
			chatButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
	
		/**
		 * @return 
		 * ���콺 Ŀ���� ä�� ��ư��  ���������� �� �߻��Ѵ�.
		 */		
		public void mouseExited(MouseEvent e) {
			chatButton.setIcon(chatBaseBtnImg);
			chatButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	
		/**
		 * @return 
		 * ä�ù�ư�� ������ �� �߻��ϰ� ä�� �˾� â�� �÷��̾�� �����Ѵ�. 
		 */
		public void mousePressed(MouseEvent e) {
			// ä�� �˾�â ����
			new ChatPopUpDialog(chatLabel).setVisible(true);
			clear(chatLabel);
		}
	}

	private class IconButtonHandler extends MouseAdapter {
		/**
		 * index Ÿ��: int
		 * �÷��̾ ������ Icon�� ��ȣ�� �����ϱ� ���� �����̴�.
		 */
		private int index;

		/**
		 * �÷��̾ ������ Icon�� ��ȣ�� �����Ѵ�.
		 * @param index Ÿ��: int
		 */
		public IconButtonHandler(int index) {
			this.index = index;
		}

		/**
		 * @return 
		 * ���콺 Ŀ���� ������ ��ư ���� ������ �� �߻��Ѵ�. 
		 */
		public void mouseEntered(MouseEvent e) {
			((JButton) e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		/**
		 * @return 
		 * ���콺 Ŀ���� ������ ��ư��  ���������� �� �߻��Ѵ�.
		 */
		@Override
		public void mouseExited(MouseEvent e) {
			((JButton) e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return 
		 * ������ ��ư�� ������ �� �߻��ϰ�   
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
			// Ÿ�ӹ� ����
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
	 * ä�� �˾� â�� ����̹����� ������ �̸�Ƽ�� ��ư�� ���� �̹����� �����ϰ� �гο� add�Ѵ�.
	 * ��Ƽ�÷���(MultiPlayScreen)ȭ�鿡 exit(�� ������)��ư, 
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
	 * ���������� ��ư�� �гο� �߰��ϴ� �޼����̴�.
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
		exitLabel.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 24));
		exitLabel.setBounds(840, 800, 400, 100);
		this.add(exitLabel);
	}

	/**
	 * @return 
	 * ���������� ��ư�� �гο� �߰��ϴ� �޼����̴�.
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
	 * ���������� ��ư�� �гο� �߰��ϴ� �޼����̴�.
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
	 * ���������� ��ư�� �гο� �߰��ϴ� �޼����̴�.
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
	 * ���������� ��ư�� �гο� �߰��ϴ� �޼����̴�.
	 */
	public void addChatLabel() {
		chatLabel = new JLabel();
		chatLabel.setBounds(310, 600, 160, 160);
		chatLabel.setVisible(false);
		this.add(chatLabel);
	}

	/**
	 * @return 
	 * ���������� ��ư�� �гο� �߰��ϴ� �޼����̴�.
	 */
	public void addTimebarLabel() {
		timebarLabel = new JLabel();
		timebarLabel.setBounds(520, 160, 322, 22);
		timebarLabel.setVisible(false);
		this.add(timebarLabel);
	}

	/**
	 * @return 
	 * ���������� ��ư�� �гο� �߰��ϴ� �޼����̴�.
	 */
	public void addRoomTitleLabel() {
		roomTitleLabel = new JLabel(titleLabelImg);
		roomTitleLabel.setBounds(400, 75, 550, 68);
		roomTitleLabel.setFont(new Font("����ǹ��� �־�", Font.BOLD, 30));
		roomTitleLabel.setHorizontalTextPosition(JLabel.CENTER);
		roomTitleLabel.setText("�̰����� �� ������ ǥ�õ˴ϴ�.");
		this.add(roomTitleLabel);
	}

	/**
	 * @return 
	 * �ڽ� 
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
	 * paintComponent()�� ���� ��Ƽ�÷���ȭ��(MultiPlayScreen)�� ����̹����� �׸���.
	 */		
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 1440, 961, null);
		g.drawImage(skyground.getImage(), 342, 0, 1105, 970, 0, mapHeight - 970, 842, mapHeight, null);
		boxComponent(g);// �ڽ� ȭ�� ���
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
	 * @param g Ÿ�� : Graphics
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
	 * �̸�Ƽ���� 3�� ���� ����ϴ� �޼����̴�.
	 * @param label Ÿ��: JLabel - �÷��̾ ������ �̸�Ƽ���� �׷��� JLabel �����̴�.
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
	 * ��� �˾� â 10���� ������ ������ϴ� �޼����̴�.
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