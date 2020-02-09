package snackFriends.view.login;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class FindPWPutAnwserPopUp extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon background;
	private ImageIcon findBaseBtnImg, findEntryBtnImg;
	private ImageIcon cancelBaseBtnImg, cancelEntryBtnImg;
	private JDialog dialog;
	private JButton findButton;
	private JButton cancelButton;
	private JComboBox<String> hint;
	private JTextField anwser;

	private class FindButtonHandler extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			findButton.setIcon(findEntryBtnImg);
			findButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			findButton.setIcon(findBaseBtnImg);
			findButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// PW 조회 결과 팝업 창
			dialog.setVisible(false);
			new ShowPWPopUpDialog(dialog).setVisible(true);
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
			// PW 조회 팝업 창 (비밀번호 힌트 문답 입력 창) 닫기
			dialog.setVisible(false);
		}
	}

	public FindPWPutAnwserPopUp(JDialog dialog) {
		setLayout(null);
		background = new ImageIcon("Image/FindIDPW/PW/putAnswer/putAnwserPopUp.png");
		findBaseBtnImg = new ImageIcon("Image/FindIDPW/PW/putAnswer/find1.png");
		cancelBaseBtnImg = new ImageIcon("Image/FindIDPW/PW/putAnswer/cancel1.png");
		findEntryBtnImg = new ImageIcon("Image/FindIDPW/PW/putAnswer/find2.png");
		cancelEntryBtnImg = new ImageIcon("Image/FindIDPW/PW/putAnswer/cancel2.png");
		this.dialog = dialog;
		addFindButton();
		addCancelButton();
		addHintComboBox();
		addAnwserTextField();
	}

	public void addFindButton() {
		findButton = new JButton(findBaseBtnImg);
		findButton.setBounds(120, 400, 200, 90);
		findButton.setBorderPainted(false);
		findButton.setContentAreaFilled(false);
		findButton.setFocusPainted(false);
		findButton.setVisible(true);
		this.add(findButton);
		findButton.addMouseListener(new FindButtonHandler());
	}

	public void addCancelButton() {
		cancelButton = new JButton(cancelBaseBtnImg);
		cancelButton.setBounds(425, 400, 200, 90);
		cancelButton.setBorderPainted(false);
		cancelButton.setContentAreaFilled(false);
		cancelButton.setFocusPainted(false);
		cancelButton.setVisible(true);
		this.add(cancelButton);
		cancelButton.addMouseListener(new CancelButtonHandler());
	}

	public void addHintComboBox() {
		String hints[] = { "나의 보물 1호는?", "나의 출신 초등학교는?", "나의 첫사랑은?" };
		hint = new JComboBox<String>(hints);
		hint.setBounds(243, 170, 400, 57);
		hint.setFont((new Font("배달의민족 주아", Font.PLAIN, 30)));
		hint.setBackground(new Color(255, 239, 239));
		hint.setBorder(new LineBorder(Color.WHITE));
		this.add(hint);
	}

	public void addAnwserTextField() {
		anwser = new JTextField();
		anwser.setBounds(264, 299, 350, 57);
		anwser.setFont(new Font("배달의민족 주아", Font.PLAIN, 30));
		anwser.setHorizontalAlignment(JTextField.CENTER);
		anwser.setBorder(null);
		anwser.setBackground(new Color(255, 239, 239));
		this.add(anwser);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 750, 560, null);
	}

}
