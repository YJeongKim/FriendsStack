package snackFriends.view.login;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WelcomePopUp extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon background;
	private ImageIcon confirmBaseBtnImg;
	private ImageIcon confirmEntryBtnImg;
	private JFrame frame;
	private JDialog dialog;
	private JButton confirmButton;

	private class ConfirmButtonHandler extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			confirmButton.setIcon(confirmEntryBtnImg);
			confirmButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			confirmButton.setIcon(confirmBaseBtnImg);
			confirmButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// 환영 팝업 창 닫기 -> 로그인 화면으로 이동
			dialog.setVisible(false);
			frame.setContentPane(new LoginScreen(frame));
			frame.setVisible(true);
		}
	}

	public WelcomePopUp(JFrame frame, JDialog dialog) {
		setLayout(null);
		background = new ImageIcon("image/join/welcomePopUp.png");
		confirmBaseBtnImg = new ImageIcon("image/join/confirm1.png");
		confirmEntryBtnImg = new ImageIcon("image/join/confirm2.png");
		this.frame = frame;
		this.dialog = dialog;
		addConfirmButton();
	}

	public void addConfirmButton() {
		confirmButton = new JButton(confirmBaseBtnImg);
		confirmButton.setBounds(178, 278, 200, 90);
		confirmButton.setBorderPainted(false);
		confirmButton.setContentAreaFilled(false);
		confirmButton.setFocusPainted(false);
		confirmButton.setVisible(true);
		this.add(confirmButton);
		confirmButton.addMouseListener(new ConfirmButtonHandler());
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 550, 414, null);
	}

}
