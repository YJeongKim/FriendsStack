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

public class ShowIDPopUp extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon background;
	private ImageIcon backBaseBtnImg;
	private ImageIcon backEntryBtnImg;
	private JDialog dialog;
	private JButton backButton;
	private JTextField id;

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
			// ID 조회 결과 팝업 창 닫기
			dialog.setVisible(false);
		}
	}

	public ShowIDPopUp(JDialog dialog, String ids) {
		setLayout(null);
		background = new ImageIcon("image/FindIDPW/ID/showID/showIDPopUp.png");
		backBaseBtnImg = new ImageIcon("image/FindIDPW/ID/showID/back1.png");
		backEntryBtnImg = new ImageIcon("image/FindIDPW/ID/showID/back2.png");
		this.dialog = dialog;
		addBackButton();
		addIDTextField(ids);
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

	public void addIDTextField(String ids) {
		if (ids == null)
			ids = new String("존재하지 않는 이메일입니다.");
		id = new JTextField(ids);
		id.setBounds(226, 120, 230, 57);
		id.setFont(new Font("배달의민족 주아", Font.PLAIN, 30));
		id.setHorizontalAlignment(JTextField.CENTER);
		id.setBorder(null);
		id.setBackground(new Color(255, 239, 239));
		id.setEditable(false);
		this.add(id);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 550, 331, null);
	}

}
