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
 * ��Ƽ�÷��� ȭ��(MultiPlayScreen)���� ä�ù�ư�� ������ �� �÷��̾�� �����Ǵ� �˾� â�̴�.
 * @author SnackTimeFriends
 *
 */
public class ChatPopUp extends JPanel {
	private static final long serialVersionUID = 1L;
	/**
	 * ä�� �˾� â�� ��� �̹����� �����ϴ� ����
	 */
	private ImageIcon background;
	/**
	 * �� ǳ�� �̹������� �����ϴ� ����
	 */
	private ImageIcon[] bubbleImg;
	/**
	 * 10���� �̸�Ƽ�� ��ư�� �ش��ϴ� �̹������� �����ϰ� �ִ� ����
	 */
	private ArrayList<ImageIcon> emoticonBtnImg;
	/**
	 * ä�� �˾� â�� add�� ����
	 */
	private JDialog dialog;
	/**
	 * 10���� �̸�Ƽ�� ��ư���� �����ϴ� ���� 
	 */
	private JButton[] emoticonButton;
	/**
	 * �̹����� ��� ��Ƽ�÷��� ȭ�鿡 �����ϴ� ���� 
	 */
	private JLabel emoticonLabel;
	
	/**
	 * �÷��̾ ä�� �˾� â���� �̸�Ƽ���� ������ ��� �߻��ϴ� Ŭ�����̴�.	 
	 */
	private class EmoticonButtonHandler extends MouseAdapter {
		/**
		 * index Ÿ��: int
		 * �÷��̾ ���콺�� ���� �̸�Ƽ���� ��ȣ�� �����ϴ� ����
		 */
		private int index;

		/**
		 * �÷��̾ ������ �̸�Ƽ���� ��ȣ�� �ʱ�ȭ�Ѵ�.
		 * @param index Ÿ��: int 
		 */
		public EmoticonButtonHandler(int index) {
			this.index = index;
		}

		/**
		 * @return
		 * ���콺 Ŀ���� �̸�Ƽ�� ��ư ���� ������ �ÿ� �߻��Ѵ�.		
		 */
		public void mouseEntered(MouseEvent e) {
			emoticonButton[index].setIcon(emoticonBtnImg.get(index));
			emoticonButton[index].setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		/**
		 * @return 
		 * ���콺 Ŀ���� �̸�Ƽ�� ��ư�� ���������� �ÿ� �߻��Ѵ�.		
		 */
		public void mouseExited(MouseEvent e) {
			emoticonButton[index].setIcon(null);
			emoticonButton[index].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		/**
		 * @return 
		 * �̸�Ƽ�� ��ư�� ������ �ÿ� �߻��ϰ� �̸�Ƽ���� ����ȭ�鿡 �����Ѵ�.		
		 */
		public void mousePressed(MouseEvent e) {
			dialog.setVisible(false);
			emoticonLabel.setIcon(bubbleImg[index]);
			emoticonLabel.setVisible(true);
		}
	}

	/**
	 * ä�� �˾� â�� ����̹����� ������ �̸�Ƽ�� ��ư�� ���� �̹����� �����ϰ� �гο� add�Ѵ�.
	 * @param dialog Ÿ��: JDialog - ChatPopUp�� ���̱� ���� �����̴�.
	 * @param label Ÿ��: JLabel - �÷��̾ ������ �̸�Ƽ���� �ٿ� ����ȭ�鿡 �����ϱ� ���� �����̴�.
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
	 * ������ �̸�Ƽ�� ��ư�� ���� �̹����� �����ϴ� �޼����̴�.
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
	 * ������ �̸�Ƽ���� ChatPopUp�гο� add�ϰ� ������ �̸�Ƽ�ܿ� EmoticonButtonHandler�� �����Ѵ�.
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
	 * ������ �̸�Ƽ�� �̹������� ��ǳ�� �̹����� ���̴� �޼����̴�.
	 */
	public void setbubbleImgImageIcon() {
		bubbleImg = new ImageIcon[emoticonBtnImg.size()];
		for (int i = 0; i < emoticonBtnImg.size(); i++) {
			bubbleImg[i] = new ImageIcon("image/multi/bubble/bubble" + (i + 1) + ".png");
		}
	}

	/**
	 * @return 
	 * paintComponent()�� ���� ä�� �˾� â(ChatPopUp)�� ����̹����� �׸���.
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
	}

}
