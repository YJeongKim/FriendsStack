package snackFriends.view.login;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindPWPutIDPopUp extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon background;
	private ImageIcon nextBaseBtnImg, nextEntryBtnImg;
	private ImageIcon cancelBaseBtnImg, cancelEntryBtnImg;
	private JDialog dialog;
	private JButton nextButton;
	private JButton cancelButton;
	private JTextField id;

	private class NextButtonHandler extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			nextButton.setIcon(nextEntryBtnImg);
			nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			nextButton.setIcon(nextBaseBtnImg);
			nextButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// PW 조회 팝업 창(비밀번호 힌트 문답 입력 창)
			dialog.setVisible(false);
			new FindPWPutAnwserPopUpDialog(dialog).setVisible(true);
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
			// PW 조회 팝업 창 (아이디 입력 창) 닫기
			dialog.setVisible(false);
		}
	}

	public FindPWPutIDPopUp(JDialog dialog) {
		setLayout(null);
		background = new ImageIcon("image/FindIDPW/PW/putID/putIDPopUp.png");
		nextBaseBtnImg = new ImageIcon("image/FindIDPW/PW/putID/next1.png");
		cancelBaseBtnImg = new ImageIcon("image/FindIDPW/PW/putID/cancel1.png");
		nextEntryBtnImg = new ImageIcon("image/FindIDPW/PW/putID/next2.png");
		cancelEntryBtnImg = new ImageIcon("image/FindIDPW/PW/putID/cancel2.png");
		this.dialog = dialog;
		addNextButton();
		addCancelButton();
		addIDTextField();
	}

	public void addNextButton() {
		nextButton = new JButton(nextBaseBtnImg);
		nextButton.setBounds(60, 235, 190, 86);
		nextButton.setBorderPainted(false);
		nextButton.setContentAreaFilled(false);
		nextButton.setFocusPainted(false);
		nextButton.setVisible(true);
		this.add(nextButton);
		nextButton.addMouseListener(new NextButtonHandler());
	}

	public void addCancelButton() {
		cancelButton = new JButton(cancelBaseBtnImg);
		cancelButton.setBounds(300, 235, 190, 86);
		cancelButton.setBorderPainted(false);
		cancelButton.setContentAreaFilled(false);
		cancelButton.setFocusPainted(false);
		cancelButton.setVisible(true);
		this.add(cancelButton);
		cancelButton.addMouseListener(new CancelButtonHandler());
	}

	public void addIDTextField() {
		id = new JTextField(10);
		id.setBounds(219, 140, 250, 57);
		id.setFont(new Font("배달의민족 주아", Font.PLAIN, 30));
		id.setHorizontalAlignment(JTextField.CENTER);
		id.setBorder(null);
		id.setBackground(new Color(255, 239, 239));
		this.add(id);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 550, 374, null);
	}

}
