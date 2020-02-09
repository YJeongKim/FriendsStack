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

public class ShowPWPopUp extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon background;
	private ImageIcon backBaseBtnImg;
	private ImageIcon backEntryBtnImg;
	private JDialog dialog;
	private JButton backButton;
	private JTextField pw;

	private class BackButtonHandler extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			backButton.setIcon(backEntryBtnImg);
			backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			backButton.setIcon(backBaseBtnImg);
			backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// PW 조회 결과 팝업 창 닫기
			dialog.setVisible(false);
		}
	}

	public ShowPWPopUp(JDialog dialog) {
		setLayout(null);
		background = new ImageIcon("image/FindIDPW/PW/showPW/showPWPopUp.png");
		backBaseBtnImg = new ImageIcon("image/FindIDPW/PW/showPW/back1.png");
		backEntryBtnImg = new ImageIcon("image/FindIDPW/PW/showPW/back2.png");
		this.dialog = dialog;
		addBackButton();
		addPWTextField();
	}

	public void addBackButton() {
		backButton = new JButton(backBaseBtnImg);
		backButton.setBounds(178, 203, 200, 90);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.setVisible(true);
		this.add(backButton);
		backButton.addMouseListener(new BackButtonHandler());
	}

	public void addPWTextField() {
		pw = new JTextField(15);
		pw.setBounds(226, 120, 230, 57);
		pw.setFont(new Font("배달의민족 주아", Font.PLAIN, 30));
		pw.setHorizontalAlignment(JTextField.CENTER);
		pw.setBorder(null);
		pw.setBackground(new Color(255, 239, 239));
		pw.setEditable(false);
		this.add(pw);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 550, 331, null);
	}

}
