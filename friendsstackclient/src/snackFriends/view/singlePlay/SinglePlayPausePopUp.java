package snackFriends.view.singlePlay;

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

public class SinglePlayPausePopUp extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon background;
	private ImageIcon continueBaseBtnImg;
	private ImageIcon exitBaseBtnImg;
	private ImageIcon replayBaseBtnImg;
	private ImageIcon mainscreenBaseBtnImg;
	private ImageIcon continueEntryBtnImg;
	private ImageIcon exitEntryBtnImg;
	private ImageIcon replayEntryBtnImg;
	private ImageIcon mainscreenEntryBtnImg;
	private JDialog dialog;
	private JButton continueButton;
	private JButton exitButton;
	private JButton replayButton;
	private JButton mainscreenButton;
	private Music music;

	private class ContinueButtonHandler extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			music = new Music("Button.mp3", false);
			music.start();
			continueButton.setIcon(continueEntryBtnImg);
			continueButton.setBounds(55, 150, 440, 90);
			continueButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			continueButton.setIcon(continueBaseBtnImg);
			continueButton.setBounds(65, 152, 420, 85);
			continueButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			SinglePlayScreen.isStop = false;
			dialog.setVisible(false);
		}
	}

	private class ExitButtonHandler extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			music = new Music("Button.mp3", false);
			music.start();
			exitButton.setIcon(exitEntryBtnImg);
			exitButton.setBounds(55, 255, 440, 90);
			exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			exitButton.setIcon(exitBaseBtnImg);
			exitButton.setBounds(65, 257, 420, 85);
			exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// 게임 종료 - 싱글 플레이 일시정지 팝업 창 닫기 -> 점수 팝업 창 띄우기
			SinglePlayScreen.running = false;
			new ScorePopUpDialog(new SinglePlayGameOverController().getScore()).setVisible(true);
			dialog.setVisible(false);
		}
	}

	private class ReplayButtonHandler extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			music = new Music("Button.mp3", false);
			music.start();
			replayButton.setIcon(replayEntryBtnImg);
			replayButton.setBounds(55, 360, 440, 90);
			replayButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			replayButton.setIcon(replayBaseBtnImg);
			replayButton.setBounds(65, 362, 420, 85);
			replayButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// 다시하기 - 싱글 플레이 일시정지 팝업 창 닫기
			// BlockAdmin.getInstance().clear();
			dialog.setVisible(false);
			// TO DO
			SinglePlayScreen.running = false;
			SinglePlayScreen.getGameBgm().close();
			GameFrame.getInstance().setContentPane(new SinglePlayScreen());
			GameFrame.getInstance().setVisible(true);
		}
	}

	private class MainscreenButtonHandler extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			music = new Music("Button.mp3", false);
			music.start();
			mainscreenButton.setIcon(mainscreenEntryBtnImg);
			mainscreenButton.setBounds(55, 465, 440, 90);
			mainscreenButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			mainscreenButton.setIcon(mainscreenBaseBtnImg);
			mainscreenButton.setBounds(65, 467, 420, 85);
			mainscreenButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// 싱글 플레이 게임 종료 -> 메인 화면으로 이동
			SinglePlayScreen.running = false;
			SinglePlayScreen.getGameBgm().close();
			dialog.setVisible(false);
			GameFrame.getInstance().setContentPane(new MainScreen());
			GameFrame.getInstance().setVisible(true);
		}
	}

	public SinglePlayPausePopUp(JDialog dialog) {
		setLayout(null);
		background = new ImageIcon("image/single/pause/pausePopUp.png");
		continueBaseBtnImg = new ImageIcon("image/single/pause/continue1.png");
		exitBaseBtnImg = new ImageIcon("image/single/pause/exit1.png");
		replayBaseBtnImg = new ImageIcon("image/single/pause/replay1.png");
		mainscreenBaseBtnImg = new ImageIcon("image/single/pause/mainscreen1.png");
		continueEntryBtnImg = new ImageIcon("image/single/pause/continue2.png");
		exitEntryBtnImg = new ImageIcon("image/single/pause/exit2.png");
		replayEntryBtnImg = new ImageIcon("image/single/pause/replay2.png");
		mainscreenEntryBtnImg = new ImageIcon("image/single/pause/mainscreen2.png");
		this.dialog = dialog;
		addContinueButton();
		addExitButton();
		addReplayButton();
		addMainscreen();
	}

	public void addContinueButton() {
		continueButton = new JButton(continueBaseBtnImg);
		continueButton.setBounds(65, 152, 420, 85);
		continueButton.setBorderPainted(false);
		continueButton.setContentAreaFilled(false);
		continueButton.setFocusPainted(false);
		continueButton.setVisible(true);
		this.add(continueButton);
		continueButton.addMouseListener(new ContinueButtonHandler());
	}

	public void addExitButton() {
		exitButton = new JButton(exitBaseBtnImg);
		exitButton.setBounds(65, 257, 420, 85);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.setVisible(true);
		this.add(exitButton);
		exitButton.addMouseListener(new ExitButtonHandler());
	}

	public void addReplayButton() {
		replayButton = new JButton(replayBaseBtnImg);
		replayButton.setBounds(65, 362, 420, 85);
		replayButton.setBorderPainted(false);
		replayButton.setContentAreaFilled(false);
		replayButton.setFocusPainted(false);
		replayButton.setVisible(true);
		this.add(replayButton);
		replayButton.addMouseListener(new ReplayButtonHandler());
	}

	public void addMainscreen() {
		mainscreenButton = new JButton(mainscreenBaseBtnImg);
		mainscreenButton.setBounds(65, 467, 420, 85);
		mainscreenButton.setBorderPainted(false);
		mainscreenButton.setContentAreaFilled(false);
		mainscreenButton.setFocusPainted(false);
		mainscreenButton.setVisible(true);
		this.add(mainscreenButton);
		mainscreenButton.addMouseListener(new MainscreenButtonHandler());
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 550, 630, null);
	}

}