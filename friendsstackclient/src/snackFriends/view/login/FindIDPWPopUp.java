package snackFriends.view.login;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class FindIDPWPopUp extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon background;
	private ImageIcon idBaseBtnImg, idEntryBtnImg;
	private ImageIcon pwBaseBtnImg, pwEntryBtnImg;
	private ImageIcon cancelBaseBtnImg, cancelEntryBtnImg;
	private JDialog dialog;
	private JButton idButton;
	private JButton pwButton;
	private JButton cancelButton;

	private class IDButtonHandler extends MouseAdapter {
	
		public void mouseEntered(MouseEvent e) {
			idButton.setIcon(idEntryBtnImg);
			idButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			idButton.setIcon(idBaseBtnImg);
			idButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// ID 조회 팝업 창 (이메일 입력 창)
			new FindIDPutEmailPopUpDialog(dialog).setVisible(true);
		}
	}

	private class PWButtonHandler extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			pwButton.setIcon(pwEntryBtnImg);
			pwButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			pwButton.setIcon(pwBaseBtnImg);
			pwButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// PW 조회 팝업 창 (아이디 입력 창)
			new FindPWPutIDPopUpDialog(dialog).setVisible(true);
		}
	}

	private class CancelButtonHandler extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			cancelButton.setIcon(cancelEntryBtnImg);
			cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			cancelButton.setIcon(cancelBaseBtnImg);
			cancelButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// ID/PW 조회 팝업 창 닫기
			dialog.setVisible(false);
		}
	}

	public FindIDPWPopUp(JDialog dialog) {
		setLayout(null);
		background = new ImageIcon("image/FindIDPW/findIDPWPopUp.png");
		idBaseBtnImg = new ImageIcon("image/FindIDPW/id1.png");
		cancelBaseBtnImg = new ImageIcon("image/FindIDPW/cancel1.png");
		pwBaseBtnImg = new ImageIcon("image/FindIDPW/pw1.png");
		idEntryBtnImg = new ImageIcon("image/FindIDPW/id2.png");
		pwEntryBtnImg = new ImageIcon("image/FindIDPW/pw2.png");
		cancelEntryBtnImg = new ImageIcon("image/FindIDPW/cancel2.png");
		this.dialog = dialog;
		addIDButton();
		addPWButton();
		addCancelButton();
	}

	public void addIDButton() {
		idButton = new JButton(idBaseBtnImg);
		idButton.setBounds(60, 135, 200, 90);
		idButton.setBorderPainted(false);
		idButton.setContentAreaFilled(false);
		idButton.setFocusPainted(false);
		idButton.setVisible(true);
		this.add(idButton);
		idButton.addMouseListener(new IDButtonHandler());
	}

	public void addPWButton() {
		pwButton = new JButton(pwBaseBtnImg);
		pwButton.setBounds(280, 135, 201, 89);
		pwButton.setBorderPainted(false);
		pwButton.setContentAreaFilled(false);
		pwButton.setFocusPainted(false);
		pwButton.setVisible(true);
		this.add(pwButton);
		pwButton.addMouseListener(new PWButtonHandler());
	}

	public void addCancelButton() {
		cancelButton = new JButton(cancelBaseBtnImg);
		cancelButton.setBounds(48, 240, 444, 90);
		cancelButton.setBorderPainted(false);
		cancelButton.setContentAreaFilled(false);
		cancelButton.setFocusPainted(false);
		cancelButton.setVisible(true);
		this.add(cancelButton);
		cancelButton.addMouseListener(new CancelButtonHandler());
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 550, 374, null);
	}

}
