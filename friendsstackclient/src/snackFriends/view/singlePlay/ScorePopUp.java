package snackFriends.view.singlePlay;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import snackFriends.view.bean.GameFrame;
import snackFriends.view.bean.Music;
import snackFriends.view.mainScreen.MainScreen;

public class ScorePopUp extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon background;
	private ImageIcon replayBaseBtnImg;
	private ImageIcon mainscreenBaseBtnImg;
	private ImageIcon replayEntryBtnImg;
	private ImageIcon mainscreenEntryBtnImg;
	private JDialog dialog;
	private JButton replayButton;
	private JButton mainscreenButton;
	private JLabel scoreLabel;
	private JLabel bestScore;
	private JLabel acquiredKong;
	private JLabel holdingKong;
	private Music music;

	private class ReplayButtonHandler extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			music = new Music("Button.mp3", false);
			music.start();
			replayButton.setIcon(replayEntryBtnImg);
			replayButton.setBounds(160, 690, 440, 90);
			replayButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			replayButton.setIcon(replayBaseBtnImg);
			replayButton.setBounds(170, 688, 420, 85);
			replayButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// BlockAdmin.getInstance().clear();
			dialog.setVisible(false); // 임시로 닫기 해놓음
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
			mainscreenButton.setBounds(160, 785, 440, 90);
			mainscreenButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			mainscreenButton.setIcon(mainscreenBaseBtnImg);
			mainscreenButton.setBounds(170, 787, 420, 85);
			mainscreenButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// 싱글 플레이 게임 종료 -> 메인 화면으로 이동
			dialog.setVisible(false);
			SinglePlayScreen.getGameBgm().close();
			GameFrame.getInstance().setContentPane(new MainScreen());
			GameFrame.getInstance().setVisible(true);
		}
	}

	public ScorePopUp(JDialog dialog, int score) {
		setLayout(null);
		background = new ImageIcon("image/single/score/scorePopUp.png");
		replayBaseBtnImg = new ImageIcon("image/single/score/replay1.png");
		mainscreenBaseBtnImg = new ImageIcon("image/single/score/mainscreen1.png");
		replayEntryBtnImg = new ImageIcon("image/single/score/replay2.png");
		mainscreenEntryBtnImg = new ImageIcon("image/single/score/mainscreen2.png");
		this.dialog = dialog;
		addReplayButton();
		addMainscreenButton();
		addscoreLabel(score);
		addcoinLabel();
	}

	public void addReplayButton() {
		replayButton = new JButton(replayBaseBtnImg);
		replayButton.setBounds(170, 688, 420, 85);
		replayButton.setBorderPainted(false);
		replayButton.setContentAreaFilled(false);
		replayButton.setFocusPainted(false);
		replayButton.setVisible(true);
		this.add(replayButton);
		replayButton.addMouseListener(new ReplayButtonHandler());
	}

	public void addMainscreenButton() {
		mainscreenButton = new JButton(mainscreenBaseBtnImg);
		mainscreenButton.setBounds(170, 787, 420, 85);
		mainscreenButton.setBorderPainted(false);
		mainscreenButton.setContentAreaFilled(false);
		mainscreenButton.setFocusPainted(false);
		mainscreenButton.setVisible(true);
		this.add(mainscreenButton);
		mainscreenButton.addMouseListener(new MainscreenButtonHandler());
	}

	public void addscoreLabel(int score) {
		scoreLabel = new JLabel();
		scoreLabel.setBounds(350, 210, 110, 50);
		scoreLabel.setFont(new Font("배달의민족 주아", Font.PLAIN, 60));
		scoreLabel.setText(Integer.toString(score));
		bestScore = new JLabel();
		bestScore.setBounds(435, 350, 110, 40);
		bestScore.setFont(new Font("배달의민족 주아", Font.PLAIN, 35));
		bestScore.setText("213");
		this.add(scoreLabel);
		this.add(bestScore);
	}

	public void addcoinLabel() {
		acquiredKong = new JLabel();
		acquiredKong.setBounds(425, 455, 110, 40);
		acquiredKong.setFont(new Font("배달의민족 주아", Font.PLAIN, 35));
		acquiredKong.setText("20 콩");
		holdingKong = new JLabel();
		holdingKong.setBounds(415, 560, 110, 40);
		holdingKong.setFont(new Font("배달의민족 주아", Font.PLAIN, 35));
		holdingKong.setText("300 콩");
		this.add(acquiredKong);
		this.add(holdingKong);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 750, 950, null);
	}

}
