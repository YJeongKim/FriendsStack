package snackFriends.view.roomList;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import snackFriends.controller.RefreshRoomController;
import snackFriends.controller.RoomBean;
import snackFriends.view.bean.GameFrame;
import snackFriends.view.mainScreen.MainScreen;
import snackFriends.view.multiPlay.MultiPlayScreen;

public class RoomListScreen extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon background;
	private ImageIcon previousBaseBtnImg, previousEntryBtnImg;
	private ImageIcon nextBaseBtnImg, nextEntryBtnImg;
	private ImageIcon makeRoomBaseBtnImg, makeRoomEntryBtnImg;
	private ImageIcon refreshBaseBtnImg, refreshEntryBtnImg;
	private ImageIcon blueRoomBaseBtnImg, blueRoomEntryBtnImg;
	private ImageIcon pinkRoomBaseBtnImg, pinkRoomEntryBtnImg;
	private ImageIcon backBaseBtnImg, backEntryBtnImg;
	private JButton previousButton;
	private JButton nextButton;
	private JButton makeRoomButton;
	private JButton refreshButton;
	private JButton backButton;
	private JButton[] roomButton;
	private JLabel[] roomNumber;
	private JLabel pageLabel;
	private ArrayList<RoomBean> roomList;
	private int roomCount;
	private ArrayList<String> roomTitle;
	private int totalPage;
	private int page;

	private class PreviousButtonHandler extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			previousButton.setIcon(previousEntryBtnImg);
			previousButton.setBounds(280, 837, 135, 78);
			previousButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			previousButton.setIcon(previousBaseBtnImg);
			previousButton.setBounds(281, 838, 133, 77);
			previousButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// 이전 페이지로 이동
			if (page > 1)
				page--;
			pageLabel.setText(page + "/" + totalPage);
			setRoomLabel();
			setRoomButton();
			repaint();
		}
	}

	private class NextButtonHandler extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			nextButton.setIcon(nextEntryBtnImg);
			nextButton.setBounds(567, 837, 135, 78);
			nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			nextButton.setIcon(nextBaseBtnImg);
			nextButton.setBounds(568, 838, 133, 77);
			nextButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// 다음 페이지로 이동
			if (page < totalPage)
				page++;
			pageLabel.setText(page + "/" + totalPage);
			setRoomLabel();
			setRoomButton();
			repaint();
		}
	}

	private class MakeRoomButtonHandler extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			makeRoomButton.setIcon(makeRoomEntryBtnImg);
			makeRoomButton.setBounds(846, 838, 245, 82);
			makeRoomButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			makeRoomButton.setIcon(makeRoomBaseBtnImg);
			makeRoomButton.setBounds(847, 838, 243, 82);
			makeRoomButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// 방만들기 팝업 창
			new MakeRoomPopUpDialog().setVisible(true);
		}
	}

	private class RefreshButtonHandler extends MouseAdapter {
		private RefreshRoomController refreshRoomController;

		public RefreshButtonHandler() {
			this.refreshRoomController = new RefreshRoomController();
		}

		public void mouseEntered(MouseEvent e) {
			refreshButton.setIcon(refreshEntryBtnImg);
			refreshButton.setBounds(734, 837, 80, 78);
			refreshButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			refreshButton.setIcon(refreshBaseBtnImg);
			refreshButton.setBounds(735, 838, 79, 77);
			refreshButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// 방 리스트 새로고침
			try {
				refreshRoomController.getRoomList();
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			page = 1;
			pageLabel.setText(page + "/" + totalPage);
			setRoomLabel();
			setRoomButton();
			repaint();
		}
	}

	private class BackButtonHandler extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			backButton.setIcon(backEntryBtnImg);
			backButton.setBounds(39, 49, 147, 85);
			backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			backButton.setIcon(backBaseBtnImg);
			backButton.setBounds(40, 50, 145, 84);
			backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// 메인 화면으로 이동
			GameFrame.getInstance().setContentPane(new MainScreen());
			GameFrame.getInstance().setVisible(true);
		}
	}

	private class RoomButtonHandler extends MouseAdapter {
		private JButton button;
		private int index;
		private int y;

		public RoomButtonHandler(JButton button, int index, int y) {
			this.button = button;
			this.index = index;
			this.y = y;
		}

		public void mouseEntered(MouseEvent e) {
			if (index % 2 == 1) // blue
				button.setIcon(blueRoomEntryBtnImg);
			else // pink
				button.setIcon(pinkRoomEntryBtnImg);
			button.setBounds(453, y, 616, 92);
			button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			if (index % 2 == 1) // blue
				button.setIcon(blueRoomBaseBtnImg);
			else // pink
				button.setIcon(pinkRoomBaseBtnImg);
			button.setBounds(453, y, 616, 92);
			button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// 해당 방으로 이동 -> 멀티 플레이 화면으로 이동
			GameFrame.getInstance().setContentPane(new MultiPlayScreen());
			GameFrame.getInstance().setVisible(true);
		}
	}

	public RoomListScreen(int roomCount) {
		roomList = new ArrayList<RoomBean>();
		setLayout(null);
		background = new ImageIcon("image/room/roomBackground.png");
		previousBaseBtnImg = new ImageIcon("image/room/previous1.png");
		nextBaseBtnImg = new ImageIcon("image/room/next1.png");
		makeRoomBaseBtnImg = new ImageIcon("image/room/makeRoom1.png");
		refreshBaseBtnImg = new ImageIcon("image/room/refresh1.png");
		backBaseBtnImg = new ImageIcon("image/room/back1.png");
		previousEntryBtnImg = new ImageIcon("image/room/previous2.png");
		nextEntryBtnImg = new ImageIcon("image/room/next2.png");
		makeRoomEntryBtnImg = new ImageIcon("image/room/makeRoom2.png");
		refreshEntryBtnImg = new ImageIcon("image/room/refresh2.png");
		backEntryBtnImg = new ImageIcon("image/room/back2.png");
		blueRoomBaseBtnImg = new ImageIcon("image/room/blueRoom1.png");
		blueRoomEntryBtnImg = new ImageIcon("image/room/blueRoom2.png");
		pinkRoomBaseBtnImg = new ImageIcon("image/room/pinkRoom1.png");
		pinkRoomEntryBtnImg = new ImageIcon("image/room/pinkRoom2.png");
		this.roomCount = roomCount;
		if (roomCount % 5 == 0)
			totalPage = roomCount / 5;
		else
			totalPage = roomCount / 5 + 1;
		roomTitle = new ArrayList<String>();
		setRoomTitle();
		page = 1;
		addPreviousButton();
		addNextButton();
		addMakeRoomButton();
		addRefreshButton();
		addBackButton();
		addRoomButton();
		addRoomLabel();
		addPageLabel();
	}

	public void addPreviousButton() {
		previousButton = new JButton(previousBaseBtnImg);
		previousButton.setBounds(281, 838, 133, 77);
		previousButton.setBorderPainted(false);
		previousButton.setContentAreaFilled(false);
		previousButton.setFocusPainted(false);
		previousButton.setVisible(true);
		this.add(previousButton);
		previousButton.addMouseListener(new PreviousButtonHandler());
	}

	public void addNextButton() {
		nextButton = new JButton(nextBaseBtnImg);
		nextButton.setBounds(568, 838, 133, 77);
		nextButton.setBorderPainted(false);
		nextButton.setContentAreaFilled(false);
		nextButton.setFocusPainted(false);
		nextButton.setVisible(true);
		this.add(nextButton);
		nextButton.addMouseListener(new NextButtonHandler());
	}

	public void addMakeRoomButton() {
		makeRoomButton = new JButton(makeRoomBaseBtnImg);
		makeRoomButton.setBounds(847, 838, 243, 82);
		makeRoomButton.setBorderPainted(false);
		makeRoomButton.setContentAreaFilled(false);
		makeRoomButton.setFocusPainted(false);
		makeRoomButton.setVisible(true);
		this.add(makeRoomButton);
		makeRoomButton.addMouseListener(new MakeRoomButtonHandler());
	}

	public void addRefreshButton() {
		refreshButton = new JButton(refreshBaseBtnImg);
		refreshButton.setBounds(735, 838, 79, 77);
		refreshButton.setBorderPainted(false);
		refreshButton.setContentAreaFilled(false);
		refreshButton.setFocusPainted(false);
		refreshButton.setVisible(true);
		this.add(refreshButton);
		refreshButton.addMouseListener(new RefreshButtonHandler());
	}

	public void addBackButton() {
		backButton = new JButton(backBaseBtnImg);
		backButton.setBounds(40, 50, 145, 84);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.setVisible(true);
		this.add(backButton);
		backButton.addMouseListener(new BackButtonHandler());
	}

	public void addRoomButton() {
		roomButton = new JButton[] { new JButton(blueRoomBaseBtnImg), new JButton(pinkRoomBaseBtnImg),
				new JButton(blueRoomBaseBtnImg), new JButton(pinkRoomBaseBtnImg), new JButton(blueRoomBaseBtnImg) };
		int y = 147;
		int i = 1;
		for (JButton button : roomButton) {
			button.setBounds(453, y, 616, 92);
			button.setHorizontalTextPosition(JButton.CENTER);
			button.setFont(new Font("배달의민족 주아", Font.BOLD, 30));
			button.setBorderPainted(false);
			button.setContentAreaFilled(false);
			button.setFocusPainted(false);
			button.setVisible(true);
			this.add(button);
			button.addMouseListener(new RoomButtonHandler(button, i, y));
			i++;
			y += 141;
		}
		setRoomButton();
	}

	public void setRoomButton() {
		int cnt = 5;
		for (int i = 0; i < 5; i++) {
			roomButton[i].setText("");
		}
		if (page == totalPage)
			cnt = roomCount % 5;
		for (int i = 0; i < cnt; i++) {
			roomButton[i].setText(roomTitle.get((page - 1) * 5 + i));
		}
	}

	public void addRoomLabel() {
		roomNumber = new JLabel[roomCount];

		int y = 172;
		for (int i = 0; i < roomCount; i++) {
			if (i % 5 == 0)
				y = 172;
			roomNumber[i] = new JLabel();
			if (i < 9)
				roomNumber[i].setBounds(354, y, 50, 40);
			else
				roomNumber[i].setBounds(344, y, 50, 40);
			roomNumber[i].setText(i + 1 + "");
			roomNumber[i].setHorizontalTextPosition(JLabel.CENTER);
			roomNumber[i].setFont(new Font("배달의민족 주아", Font.BOLD, 40));
			y += 141;
		}
		setRoomLabel();
	}

	public void setRoomLabel() {
		int cnt = 5;
		for (int i = 0; i < roomCount; i++) {
			roomNumber[i].setVisible(false);
		}
		if (page == totalPage)
			cnt = roomCount % 5;
		for (int i = 0; i < cnt; i++) {
			roomNumber[((page - 1) * 5) + i].setVisible(true);
			this.add(roomNumber[((page - 1) * 5) + i]);
		}
	}

	public void setRoomTitle() {
		roomTitle.add("가나다라마바사아자차카타파하가 (3/3)");
		roomTitle.add("연정이와 대결할 사람 (2/3)");
		roomTitle.add("드루와 다 드루와!! (1/3)");
		roomTitle.add("주은이가 기다린다 (1/3)");
		roomTitle.add("안 자는 사람 손 (3/3)");
		roomTitle.add("안들어오고 뭐해요 (2/3)");
		roomTitle.add("재밌당 (3/3)");
		roomTitle.add("뀨 (2/3)");
		roomTitle.add("안들어오면 슬퍼ㅜㅅㅜ (1/3)");
		roomTitle.add("가보즈앙~~ (3/3)");
		roomTitle.add("똑똑똑 (3/3)");
		roomTitle.add("즐겜 (1/3)");
		roomTitle.add("나랑 놀쟈 (2/3)");
	}

	public void addPageLabel() {
		pageLabel = new JLabel();
		pageLabel.setBounds(462, 836, 133, 76);
		pageLabel.setFont(new Font("배달의민족 주아", Font.PLAIN, 40));
		pageLabel.setText(page + "/" + totalPage);
		this.add(pageLabel);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 1440, 960, null);
	}

}
