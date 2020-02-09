package snackFriends.view.multiPlay;

import java.awt.Cursor;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 멀티플레이 화면(MultiPlayScreen)에서 채팅버튼을 눌렀을 시 플레이어에게 제공되는 팝업 창이다.
 * @author SnackTimeFriends
 *
 */
public class ChatPopUp extends JPanel {
	private static final long serialVersionUID = 1L;
	/**
	 * 채팅 팝업 창의 배경 이미지를 저장하는 변수
	 */
	private ImageIcon background;
	/**
	 * 말 풍선 이미지들을 저장하는 변수
	 */
	private ImageIcon[] bubbleImg;
	/**
	 * 10개의 이모티콘 버튼에 해당하는 이미지들을 저장하고 있는 변수
	 */
	private ArrayList<ImageIcon> emoticonBtnImg;
	/**
	 * 채팅 팝업 창이 add될 변수
	 */
	private JDialog dialog;
	/**
	 * 10개의 이모티콘 버튼들을 저장하는 변수 
	 */
	private JButton[] emoticonButton;
	/**
	 * 이미지를 담고 멀티플레이 화면에 제공하는 변수 
	 */
	private JLabel emoticonLabel;
	
	/**
	 * 플레이어가 채팅 팝업 창에서 이모티콘을 눌렀을 경우 발생하는 클래스이다.	 
	 */
	private class EmoticonButtonHandler extends MouseAdapter {
		/**
		 * index 타입: int
		 * 플레이어가 마우스로 누른 이모티콘의 번호를 저장하는 변수
		 */
		private int index;

		/**
		 * 플레이어가 선택한 이모티콘의 번호로 초기화한다.
		 * @param index 타입: int 
		 */
		public EmoticonButtonHandler(int index) {
			this.index = index;
		}

		/**
		 * @return
		 * 마우스 커서가 이모티콘 버튼 내에 들어왔을 시에 발생한다.		
		 */
		public void mouseEntered(MouseEvent e) {
			emoticonButton[index].setIcon(emoticonBtnImg.get(index));
			emoticonButton[index].setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return 
		 * 마우스 커서가 이모티콘 버튼을 빠져나갔을 시에 발생한다.		
		 */
		public void mouseExited(MouseEvent e) {
			emoticonButton[index].setIcon(null);
			emoticonButton[index].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return 
		 * 이모티콘 버튼을 눌렀을 시에 발생하고 이모티콘을 게임화면에 제공한다.		
		 */
		public void mousePressed(MouseEvent e) {
			dialog.setVisible(false);
			emoticonLabel.setIcon(bubbleImg[index]);
			emoticonLabel.setVisible(true);
		}
	}

	/**
	 * 채팅 팝업 창의 배경이미지와 각각의 이모티콘 버튼에 대한 이미지를 생성하고 패널에 add한다.
	 * @param dialog 타입: JDialog - ChatPopUp을 붙이기 위한 변수이다.
	 * @param label 타입: JLabel - 플레이어가 선택한 이모티콘을 붙여 게임화면에 제공하기 위한 변수이다.
	 */
	public ChatPopUp(JDialog dialog, JLabel label) {
		setLayout(null);
		background = new ImageIcon("image/multi/emoticon/emoticonPopUp.png");
		emoticonBtnImg = new ArrayList<>();
		setEmoticonButton();
		emoticonButton = new JButton[emoticonBtnImg.size()];
		addEmoticonButton();
		setbubbleImgImageIcon();
		this.emoticonLabel = label;
		this.dialog = dialog;
	}
	
	/**
	 * @return 
	 * 각각의 이모티콘 버튼에 대한 이미지를 생성하는 메서드이다.
	 */
	public void setEmoticonButton() {
		emoticonBtnImg.add(new ImageIcon("image/multi/emoticon/laugh.png"));
		emoticonBtnImg.add(new ImageIcon("image/multi/emoticon/smile.png"));
		emoticonBtnImg.add(new ImageIcon("image/multi/emoticon/shy.png"));
		emoticonBtnImg.add(new ImageIcon("image/multi/emoticon/angry.png"));
		emoticonBtnImg.add(new ImageIcon("image/multi/emoticon/pface.png"));
		emoticonBtnImg.add(new ImageIcon("image/multi/emoticon/cry.png"));
		emoticonBtnImg.add(new ImageIcon("image/multi/emoticon/kiss.png"));
		emoticonBtnImg.add(new ImageIcon("image/multi/emoticon/angel.png"));
		emoticonBtnImg.add(new ImageIcon("image/multi/emoticon/teeth.png"));
		emoticonBtnImg.add(new ImageIcon("image/multi/emoticon/frightened.png"));
	}

	/**
	 * @return 
	 * 각각의 이모티콘을 ChatPopUp패널에 add하고 각각의 이모티콘에 EmoticonButtonHandler를 생성한다.
	 */
	public void addEmoticonButton() {
		int x = 29, y = 32;
		for (int i = 0; i < emoticonBtnImg.size(); i++) {
			if (i % 5 == 0 && i != 0) {
				x = 29;
				y = 160;
			}
			emoticonButton[i] = new JButton();
			emoticonButton[i].setBounds(x, y, 95, 95);
			emoticonButton[i].setBorderPainted(false);
			emoticonButton[i].setContentAreaFilled(false);
			emoticonButton[i].setFocusPainted(false);
			emoticonButton[i].setVisible(true);
			emoticonButton[i].addMouseListener(new EmoticonButtonHandler(i));
			this.add(emoticonButton[i]);
			x += 98;
		}

	}

	/**
	 * @return
	 * 각각의 이모티콘 이미지들을 말풍선 이미지에 붙이는 메서드이다.
	 */
	public void setbubbleImgImageIcon() {
		bubbleImg = new ImageIcon[emoticonBtnImg.size()];
		for (int i = 0; i < emoticonBtnImg.size(); i++) {
			bubbleImg[i] = new ImageIcon("image/multi/bubble/bubble" + (i + 1) + ".png");
		}
	}

	/**
	 * @return 
	 * paintComponent()를 통해 채팅 팝업 창(ChatPopUp)의 배경이미지를 그린다.
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
	}

}
