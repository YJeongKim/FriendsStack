package snackFriends.view.roomList;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import snackFriends.controller.MakeRoomController;
import snackFriends.view.bean.GameFrame;
import snackFriends.view.multiPlay.MultiPlayScreen;

public class MakeRoomPopUp extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon background;
	private ImageIcon makeBtn1;
	private ImageIcon cancelBtn1;
	private ImageIcon makeBtn2;
	private ImageIcon cancelBtn2;
	private JDialog dialog;
	private JButton makeButton;
	private JButton cancelButton;
	private JTextField title;
	
	private class MakeButtonHandler extends MouseAdapter {
		private MakeRoomController makeRoomController;
		public MakeButtonHandler() {
			this.makeRoomController = new MakeRoomController();
		}
		public void mouseEntered(MouseEvent e) {
			makeButton.setIcon(makeBtn2);
			makeButton.setBounds(119, 150, 142, 69);
			makeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			makeButton.setIcon(makeBtn1);
			makeButton.setBounds(120, 150, 140, 68);
			makeButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			try {
				MultiGameRoomBean mgrb= makeRoomController.makeRoom("jiho", "title이 나옵니다");
				System.out.println("방이름" + mgrb.getRoomTitle());
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dialog.setVisible(false);
			GameFrame.getInstance().setContentPane(new MultiPlayScreen());
			GameFrame.getInstance().setVisible(true);
		}
	}

	private class CancelButtonHandler extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			cancelButton.setIcon(cancelBtn2);
			cancelButton.setBounds(299, 150, 142, 69);
			cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			cancelButton.setIcon(cancelBtn1);
			cancelButton.setBounds(300, 150, 140, 68);
			cancelButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// 방만들기 팝업 창 닫기
			dialog.setVisible(false);
		}
	}

	public MakeRoomPopUp(JDialog dialog) {
		setLayout(null);
		background = new ImageIcon("image/room/makeRoom/makeRoomPopUp.png");
		makeBtn1 = new ImageIcon("image/room/makeRoom/make1.png");
		cancelBtn1 = new ImageIcon("image/room/makeRoom/cancel1.png");
		makeBtn2 = new ImageIcon("image/room/makeRoom/make2.png");
		cancelBtn2 = new ImageIcon("image/room/makeRoom/cancel2.png");
		this.dialog = dialog;
		addMakeButton();
		addCancelButton();
		addTitle();
	}

	public void addMakeButton() {
		makeButton = new JButton(makeBtn1);
		makeButton.setBounds(120, 150, 140, 68);
		makeButton.setBorderPainted(false);
		makeButton.setContentAreaFilled(false);
		makeButton.setFocusPainted(false);
		makeButton.setVisible(true);
		this.add(makeButton);
		makeButton.addMouseListener(new MakeButtonHandler());
	}

	public void addCancelButton() {
		cancelButton = new JButton(cancelBtn1);
		cancelButton.setBounds(300, 150, 140, 68);
		cancelButton.setBorderPainted(false);
		cancelButton.setContentAreaFilled(false);
		cancelButton.setFocusPainted(false);
		cancelButton.setVisible(true);
		this.add(cancelButton);
		cancelButton.addMouseListener(new CancelButtonHandler());
	}

	public void addTitle() {
		title = new JTextField(15);
		title.setBounds(185, 73, 310, 60);
		title.setBorder(null);
		title.setFont(new Font("배달의민족 주아", Font.PLAIN, 28));
		title.setHorizontalAlignment(JTextField.CENTER);
		title.setBackground(new Color(255, 207, 207));
		title.setVisible(true);
		this.add(title);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 550, 243, null);
	}

}
