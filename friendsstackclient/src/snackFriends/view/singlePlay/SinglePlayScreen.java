package snackFriends.view.singlePlay;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import snackFriends.view.bean.Music;

public class SinglePlayScreen extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	public static boolean running;
	public static boolean isStop;
	private static final int BLOCKICONWIDTH = 105;
	private static final int BLOCKICONHEIGHT = 110;
	public static int blockLimitHeight;// 박스의 높이
	private int mapHeight = 5012;// 맵의 높이
	private int time;
	private final int FPS = 30;
	private final int TARGET_TIME = 1000 / FPS;
	private ImageIcon background;
	private ImageIcon backgroundUp;
	private ImageIcon backgroundDown;
	private ImageIcon skyground;
	private ImageIcon pauseBaseBtnImg, pauseEntryBtnImg;
	private ImageIcon[] timer;
	private JButton pauseButton;
	private JLabel timerLabel;
	private ArrayList<JButton> iconButtons;
	private ArrayList<BlockBean> stackBlockList = new ArrayList<>();// 블록쌓기저장
	private Thread thread;
	private Music btnSound;
	private static Music gameBgm;

	public static Music getGameBgm() {
		return gameBgm;
	}

	public Thread getThread() {
		return thread;
	}

	private class PauseButtonHandler extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			btnSound = new Music("Button.mp3", false);
			btnSound.start();
			pauseButton.setIcon(pauseEntryBtnImg);
			pauseButton.setBounds(669, 69, 90, 68);
			pauseButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			pauseButton.setIcon(pauseBaseBtnImg);
			pauseButton.setBounds(670, 70, 88, 66);
			pauseButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// 싱글 플레이 일시정지 팝업 창
			isStop = true;
			new SinglePlayPausePopUpDialog().setVisible(true);
		}
	}

	private class IconButtonHandler extends MouseAdapter {
		private SinglePlayController singlePlayController;
		private SinglePlayGameOverController singlePlayGameOverController;

		public IconButtonHandler() {
			singlePlayController = new SinglePlayController();
			singlePlayGameOverController = new SinglePlayGameOverController();
		}

		public void mouseEntered(MouseEvent e) {
			((JButton) e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			((JButton) e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() > 1)
				return;
			if (running == false) {
				running = true;
				thread.start();
			}
			if (stackBlockList.size() == 0) {
				singlePlayController.setGameServiceManager(((JButton) e.getSource()).getIcon(), null);
			} else {
				singlePlayController.setGameServiceManager(((JButton) e.getSource()).getIcon(),
						stackBlockList.get(stackBlockList.size() - 1));
			}
			Icon nextBtn = singlePlayController.getNextButton();
			stackBlockBean(((JButton) e.getSource()).getIcon());
			((JButton) e.getSource()).setIcon(nextBtn);
			lockHeight();
			if (nextBtn == null) {
				running = false;
				new ScorePopUpDialog(singlePlayGameOverController.getScore()).setVisible(true);
				System.out.println("종료됨");
			}
			time = TARGET_TIME * 6;

		}

		public void stackBlockBean(Icon icon) {
			String iconString = icon.toString();
			String iconTemp[] = iconString.split("/");
			iconString = iconTemp[iconTemp.length - 1];
			BlockBean blockBean = new BlockBean(new ImageIcon("image/box/" + iconString),
					340 - new Random().nextInt(60), blockLimitHeight - 200);
			blockBean.start();
			stackBlockList.add(blockBean);
		}

		public void lockHeight() {
			blockLimitHeight -= 165;
			if (blockLimitHeight <= 0) {
				for (BlockBean b : stackBlockList) {
					b.setY(b.getY() + 165);
				}
				blockLimitHeight = 0;
			}
			// 타이머 갱신
		}
	}

	public SinglePlayScreen() {
		isStop = false;
		setLayout(null);
		background = new ImageIcon("image/single/background.png");
		backgroundUp = new ImageIcon("image/single/sigleFrameUp.png");
		backgroundDown = new ImageIcon("image/single/sigleFrameDown.png");
		skyground = new ImageIcon("image/single/skyground.png");
		pauseBaseBtnImg = new ImageIcon("image/single/pause1.png");
		pauseEntryBtnImg = new ImageIcon("image/single/pause2.png");
		timer = new ImageIcon[] { new ImageIcon("image/single/0.png"), new ImageIcon("image/single/1.png"),
				new ImageIcon("image/single/2.png"), new ImageIcon("image/single/3.png"),
				new ImageIcon("image/single/4.png"), new ImageIcon("image/single/5.png") };
		addPauseButton();
		addIconButton();
		addTimerLabel();
		time = TARGET_TIME * 6;
		blockLimitHeight = 530;
		thread = new Thread(this);
		// if(gameBgm == null || ) {
		gameBgm = new Music("gameBgm.mp3", true);
		gameBgm.start();
		// }

	}

	public void addPauseButton() {
		pauseButton = new JButton(pauseBaseBtnImg);
		pauseButton.setBounds(670, 70, 88, 66);
		pauseButton.setBorderPainted(false);
		pauseButton.setContentAreaFilled(false);
		pauseButton.setFocusPainted(false);
		pauseButton.setVisible(true);
		this.add(pauseButton);
		pauseButton.addMouseListener(new PauseButtonHandler());
	}

	public void addIconButton() {
		iconButtons = new ArrayList<>();
		stackBlockList = new ArrayList<>();
		ArrayList<BlockInfo> selectBlockList = BlockAdmin.getInstance().popBlocklist();
		IconButtonHandler iconHandler = new IconButtonHandler();
		for (int i = 0; i < 6; i++) {
			iconButtons.add(new JButton(new ImageIcon("image/boxIcon/" + selectBlockList.get(i).getAnimal() + "Box_"
					+ selectBlockList.get(i).getRelation() + ".png")));
			JButton block = iconButtons.get(i);
			block.setBounds(67 + (118 * i), 790, BLOCKICONWIDTH, BLOCKICONHEIGHT);
			block.setBorderPainted(false);
			block.setContentAreaFilled(false);
			block.setFocusPainted(false);
			block.setVisible(true);
			block.addMouseListener(iconHandler);
			this.add(block);
		}

	}

	public void addTimerLabel() {
		timerLabel = new JLabel(timer[5]);
		timerLabel.setBounds(70, 60, 140, 105);
		this.add(timerLabel);
	}

	public void blockComponent(Graphics g) {
		if (stackBlockList.size() > 4) {
			if (mapHeight >= 1067)
				mapHeight -= 97;
			stackBlockList.remove(0);
		}
		for (BlockBean b : stackBlockList) {
			b.drawBlock(g);
		}
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 1437, 960, null);
		g.drawImage(skyground.getImage(), 63, 50, 780, 900, 0, mapHeight - 970, 842, mapHeight, null);

		blockComponent(g);
		g.drawImage(backgroundUp.getImage(), 59, 0, 725, 50, null);
		g.drawImage(backgroundDown.getImage(), 53, 765, 734, 196, null);

		// repaint();
	}

	public void dropTime() {
		if (time <= 0) {
			running = false;
			new ScorePopUpDialog(new SinglePlayGameOverController().getScore()).setVisible(true);
		}
	}

	public void paintTime() {
		timerLabel.setIcon(timer[(time / TARGET_TIME)]);
	}

	public void run() {
		while (running) {
			System.out.println("2");
			if (!isStop) {
				System.out.println("3");
				repaint();
				time--;
				dropTime();
				paintTime();
				try {
					Thread.sleep(TARGET_TIME);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
