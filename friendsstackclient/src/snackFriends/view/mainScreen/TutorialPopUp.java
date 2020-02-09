package snackFriends.view.mainScreen;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import snackFriends.view.bean.GameFrame;
import snackFriends.view.tutorial.MultiTutorialScreen;
import snackFriends.view.tutorial.SingleTutorialScreen;
/**
 * �÷��̾ ����ȭ�鿡�� Ʃ�丮�� ��ư�� �������� �����Ǵ� �˾� â�� ���� Ŭ�����̴�.
 * @author SnackTimeFriends
 */
public class TutorialPopUp extends JPanel {
	private static final long serialVersionUID = 1L;
	/**
	 * Ʃ�丮�� �˾� â�� ��� �̹����� �����ϴ� ����
	 */
	private ImageIcon background;
	/**
	 * �̱��÷��� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� ���� ���� ���
	 */
	private ImageIcon singlePlayBaseBtnImg;
	/**
	 * ��Ƽ�÷��� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� ���� ���� ���
	 */
	private ImageIcon multiPlayBaseBtnImg;
	/**
	 * �ݱ� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� ���� ���� ���
	 */
	private ImageIcon closeBaseBtnImg;
	/**
	 * �̱��÷��� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� �ִ� ���
	 */
	private ImageIcon singlePlayEntryBtnImg;
	/**
	 * ��Ƽ�÷��� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� �ִ� ���
	 */
	private ImageIcon multiPlayEntryBtnImg;
	/**
	 * �ݱ� ��ư�� �̹��� : ���콺 Ŀ���� ��ư ���� �ִ� ���
	 */
	private ImageIcon closeEntryBtnImg;
	/**
	 * Ʃ�丮�� �˾� â�� add�� dialog ����
	 */
	private JDialog dialog;
	/**
	 * �̱��÷��� ��ư
	 */
	private JButton singlePlayButton;
	/**
	 * ��Ƽ�÷��� ��ư
	 */
	private JButton multiPlayButton;
	/**
	 * �ݱ� ��ư
	 */
	private JButton closeButton;	

	/**
	 * �÷��̾ �̱��÷��� ��ư�� ������ ��� �����Ǵ� Ŭ�����̴�.
	 */
	private class SinglePlayButtonHandler extends MouseAdapter {
		/**
		 * @return void
		 * ���콺 Ŀ���� �̱��÷��� ��ư ���� ������ �� �߻��Ѵ�.
		 */
		public void mouseEntered(MouseEvent e) {
			singlePlayButton.setIcon(singlePlayEntryBtnImg);
			singlePlayButton.setBounds(55, 150, 440, 90);
			singlePlayButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		/**
		 * @return void
		 * ���콺 Ŀ���� �̱��÷��� ��ư�� ���� ������ �ÿ� �߻��Ѵ�.
		 */
		public void mouseExited(MouseEvent e) {
			singlePlayButton.setIcon(singlePlayBaseBtnImg);
			singlePlayButton.setBounds(65, 152, 420, 85);
			singlePlayButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		
		/**
		 * @return void
		 * �̱��÷��� ��ư�� ������ �� �߻��ϰ� �̱��÷��� Ʃ�丮�� ȭ������ �̵��Ѵ�.
		 */
		public void mousePressed(MouseEvent e) {
			// �̱� �÷��� Ʃ�丮�� ȭ������ �̵�
			dialog.setVisible(false);
			GameFrame.getInstance().setContentPane(new SingleTutorialScreen());
			GameFrame.getInstance().setVisible(true);
			MainScreen.getMainBgm().close();
		}
	}

	/**	 
	 * �÷��̾ ��Ƽ�÷��� ��ư�� ������ �� �����Ǵ� Ŭ�����̴�. 
	 */
	private class MultiPlayButtonHandler extends MouseAdapter {
		
		/**
		 * @return void
		 * ���콺 Ŀ���� ��Ƽ�÷��� ��ư ���� ������ �� �߻��Ѵ�.
		 */	
		public void mouseEntered(MouseEvent e) {
			multiPlayButton.setIcon(multiPlayEntryBtnImg);
			multiPlayButton.setBounds(55, 255, 440, 90);
			multiPlayButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
	
		/**
		 * @return void
		 * ���콺 Ŀ���� ��Ƽ�÷��� ��ư�� ���� ������ �ÿ� �߻��Ѵ�.
		 */
		public void mouseExited(MouseEvent e) {
			multiPlayButton.setIcon(multiPlayBaseBtnImg);
			multiPlayButton.setBounds(65, 257, 420, 85);
			multiPlayButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	
		/**
		 * @return void
		 * ��Ƽ�÷��� ��ư�� ������ �� �߻��ϰ� ��Ƽ�÷��� Ʃ�丮�� ȭ������ �̵��Ѵ�.
		 */
		public void mousePressed(MouseEvent e) {
			// ��Ƽ �÷��� Ʃ�丮�� ȭ������ �̵�
			dialog.setVisible(false);
			GameFrame.getInstance().setContentPane(new MultiTutorialScreen());
			GameFrame.getInstance().setVisible(true);
			MainScreen.getMainBgm().close();
		}
	}
	
	/**	 
	 * �÷��̾ �ݱ� ��ư�� ������ ��� �����Ǵ� Ŭ�����̴�.
	 */
	private class CloseButtonHandler extends MouseAdapter {
		
		/**
		 * @return void
		 * ���콺 Ŀ���� �����ϱ� ��ư ���� ������ �� �߻��Ѵ�.
		 */		
		public void mouseEntered(MouseEvent e) {
			closeButton.setIcon(closeEntryBtnImg);
			closeButton.setBounds(55, 360, 440, 90);
			closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		/**
		 * @return void
		 * ���콺 Ŀ���� �����ϱ� ��ư�� ���� ������ �ÿ� �߻��Ѵ�.
		 */		
		public void mouseExited(MouseEvent e) {
			closeButton.setIcon(closeBaseBtnImg);
			closeButton.setBounds(65, 362, 420, 85);
			closeButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		
		/**
		 * @return void
		 * �����ϱ� ��ư�� ������ �� �߻��ϰ� Ʃ�丮�� �˾� â�� ������ �ʰ� �Ѵ�.
		 */
		public void mousePressed(MouseEvent e) {
			// Ʃ�丮�� �˾� â �ݱ�
			dialog.setVisible(false);
		}
	}

	/**	 
	 * @param dialog Ÿ��: JDialog - TutorialPopUp�� �׸� dialog�� ���޹޴´�.
	 * �˾� â�� ����̹����� �̱��÷��� ��ư, ��Ƽ�÷��� ��ư, �����ϱ� ��ư�� ���� �̹����� �����ϰ�  ������ ��ư���� �гο� add�Ѵ�.	 	 
	 */
	public TutorialPopUp(JDialog dialog) {
		setLayout(null);
		background = new ImageIcon("image/main/tutorial/tutorialPopUp.png");
		singlePlayBaseBtnImg = new ImageIcon("image/main/tutorial/singlePlay1.png");
		multiPlayBaseBtnImg = new ImageIcon("image/main/tutorial/multiPlay1.png");
		closeBaseBtnImg = new ImageIcon("image/main/tutorial/close1.png");
		singlePlayEntryBtnImg = new ImageIcon("image/main/tutorial/singlePlay2.png");
		multiPlayEntryBtnImg = new ImageIcon("image/main/tutorial/multiPlay2.png");
		closeEntryBtnImg = new ImageIcon("image/main/tutorial/close2.png");
		this.dialog = dialog;
		addSinglePlayButton();
		addMultiPlayButton();
		addCloseButton();
	}

	/**
	 * @return void
	 * �̱��÷��� ��ư�� �гο� �߰��ϴ� �޼����̴�.
	 */
	public void addSinglePlayButton() {
		singlePlayButton = new JButton(singlePlayBaseBtnImg);
		singlePlayButton.setBounds(65, 152, 420, 85);
		singlePlayButton.setBorderPainted(false);
		singlePlayButton.setContentAreaFilled(false);
		singlePlayButton.setFocusPainted(false);
		singlePlayButton.setVisible(true);
		this.add(singlePlayButton);
		singlePlayButton.addMouseListener(new SinglePlayButtonHandler());
	}

	/**
	 * @return void
	 * ��Ƽ�÷��� ��ư�� �гο� �߰��ϴ� �޼����̴�.
	 */
	public void addMultiPlayButton() {
		multiPlayButton = new JButton(multiPlayBaseBtnImg);
		multiPlayButton.setBounds(65, 257, 420, 85);
		multiPlayButton.setBorderPainted(false);
		multiPlayButton.setContentAreaFilled(false);
		multiPlayButton.setFocusPainted(false);
		multiPlayButton.setVisible(true);
		this.add(multiPlayButton);
		multiPlayButton.addMouseListener(new MultiPlayButtonHandler());
	}

	/**
	 * @return void
	 * �����ϱ� ��ư�� �гο� �߰��ϴ� �޼����̴�.
	 */
	public void addCloseButton() {
		closeButton = new JButton(closeBaseBtnImg);
		closeButton.setBounds(65, 362, 420, 85);
		closeButton.setBorderPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setFocusPainted(false);
		closeButton.setVisible(true);
		this.add(closeButton);
		closeButton.addMouseListener(new CloseButtonHandler());
	}

	/**	
	 * paintComponent()�� ���� Ʃ�丮�� �˾� â(TutorialPopUp)�� ����̹����� �׸���.
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 550, 540, null);
	}

}
