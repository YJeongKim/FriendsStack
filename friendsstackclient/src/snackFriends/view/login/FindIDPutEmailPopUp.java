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

public class FindIDPutEmailPopUp extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon background;
	private ImageIcon findBaseBtnImg, findEntryBtnImg;
	private ImageIcon cancelBaseBtnImg, cancelEntryBtnImg;
	private JDialog dialog;
	private JButton findButton;
	private JButton cancelButton;
	private JTextField email;

	private class FindButtonHandler extends MouseAdapter {
		private FindIdController findIdController;

		public FindButtonHandler() {
			findIdController = new FindIdController();
		}

		public void mouseEntered(MouseEvent e) {
			findButton.setIcon(findEntryBtnImg);
			findButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			findButton.setIcon(findBaseBtnImg);
			findButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// ID 조회 결과 팝업 창
			String id = null;
			id = findIdController.findId(email.getText());
			new ShowIDPopUpDialog(dialog, id).setVisible(true);
			dialog.setVisible(false);
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
			// ID 조회 팝업 창 (이메일 입력 창) 닫기
			dialog.setVisible(false);
		}
	}

	public FindIDPutEmailPopUp(JDialog dialog) {
		setLayout(null);
		background = new ImageIcon("Image/FindIDPW/ID/putEmail/putEmailPopUp.png");
		findBaseBtnImg = new ImageIcon("Image/FindIDPW/ID/putEmail/find1.png");
		cancelBaseBtnImg = new ImageIcon("Image/FindIDPW/ID/putEmail/cancel1.png");
		findEntryBtnImg = new ImageIcon("Image/FindIDPW/ID/putEmail/find2.png");
		cancelEntryBtnImg = new ImageIcon("Image/FindIDPW/ID/putEmail/cancel2.png");
		this.dialog = dialog;
		addFindButton();
		addCancelButton();
		addEmailTextField();
	}

	public void addFindButton() {
		findButton = new JButton(findBaseBtnImg);
		findButton.setBounds(120, 285, 220, 98);
		findButton.setBorderPainted(false);
		findButton.setContentAreaFilled(false);
		findButton.setFocusPainted(false);
		findButton.setVisible(true);
		this.add(findButton);
		findButton.addMouseListener(new FindButtonHandler());
	}

	public void addCancelButton() {
		cancelButton = new JButton(cancelBaseBtnImg);
		cancelButton.setBounds(410, 285, 220, 98);
		cancelButton.setBorderPainted(false);
		cancelButton.setContentAreaFilled(false);
		cancelButton.setFocusPainted(false);
		cancelButton.setVisible(true);
		this.add(cancelButton);
		cancelButton.addMouseListener(new CancelButtonHandler());
	}

	public void addEmailTextField() {
		email = new JTextField();
		email.setBounds(290, 175, 350, 57);
		email.setFont(new Font("배달의민족 주아", Font.PLAIN, 30));
		email.setHorizontalAlignment(JTextField.CENTER);
		email.setBorder(null);
		email.setBackground(new Color(255, 239, 239));
		this.add(email);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 750, 451, null);
	}

}
