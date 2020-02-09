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
 * 플레이어가 메인화면에서 튜토리얼 버튼을 눌렀을시 생성되는 팝업 창에 대한 클래스이다.
 * @author SnackTimeFriends
 */
public class TutorialPopUp extends JPanel {
	private static final long serialVersionUID = 1L;
	/**
	 * 튜토리얼 팝업 창의 배경 이미지를 저장하는 변수
	 */
	private ImageIcon background;
	/**
	 * 싱글플레이 버튼의 이미지 : 마우스 커서가 버튼 내에 있지 않은 경우
	 */
	private ImageIcon singlePlayBaseBtnImg;
	/**
	 * 멀티플레이 버튼의 이미지 : 마우스 커서가 버튼 내에 있지 않은 경우
	 */
	private ImageIcon multiPlayBaseBtnImg;
	/**
	 * 닫기 버튼의 이미지 : 마우스 커서가 버튼 내에 있지 않은 경우
	 */
	private ImageIcon closeBaseBtnImg;
	/**
	 * 싱글플레이 버튼의 이미지 : 마우스 커서가 버튼 내에 있는 경우
	 */
	private ImageIcon singlePlayEntryBtnImg;
	/**
	 * 멀티플레이 버튼의 이미지 : 마우스 커서가 버튼 내에 있는 경우
	 */
	private ImageIcon multiPlayEntryBtnImg;
	/**
	 * 닫기 버튼의 이미지 : 마우스 커서가 버튼 내에 있는 경우
	 */
	private ImageIcon closeEntryBtnImg;
	/**
	 * 튜토리얼 팝업 창이 add될 dialog 변수
	 */
	private JDialog dialog;
	/**
	 * 싱글플레이 버튼
	 */
	private JButton singlePlayButton;
	/**
	 * 멀티플레이 버튼
	 */
	private JButton multiPlayButton;
	/**
	 * 닫기 버튼
	 */
	private JButton closeButton;	

	/**
	 * 플레이어가 싱글플레이 버튼을 눌렀을 경우 생성되는 클래스이다.
	 */
	private class SinglePlayButtonHandler extends MouseAdapter {
		/**
		 * @return void
		 * 마우스 커서가 싱글플레이 버튼 내에 들어왔을 시 발생한다.
		 */
		public void mouseEntered(MouseEvent e) {
			singlePlayButton.setIcon(singlePlayEntryBtnImg);
			singlePlayButton.setBounds(55, 150, 440, 90);
			singlePlayButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		/**
		 * @return void
		 * 마우스 커서가 싱글플레이 버튼을 빠져 나갔을 시에 발생한다.
		 */
		public void mouseExited(MouseEvent e) {
			singlePlayButton.setIcon(singlePlayBaseBtnImg);
			singlePlayButton.setBounds(65, 152, 420, 85);
			singlePlayButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		
		/**
		 * @return void
		 * 싱글플레이 버튼을 눌렀을 시 발생하고 싱글플레이 튜토리얼 화면으로 이동한다.
		 */
		public void mousePressed(MouseEvent e) {
			// 싱글 플레이 튜토리얼 화면으로 이동
			dialog.setVisible(false);
			GameFrame.getInstance().setContentPane(new SingleTutorialScreen());
			GameFrame.getInstance().setVisible(true);
			MainScreen.getMainBgm().close();
		}
	}

	/**	 
	 * 플레이어가 멀티플레이 버튼을 눌렀을 시 생성되는 클래스이다. 
	 */
	private class MultiPlayButtonHandler extends MouseAdapter {
		
		/**
		 * @return void
		 * 마우스 커서가 멀티플레이 버튼 내에 들어왔을 시 발생한다.
		 */	
		public void mouseEntered(MouseEvent e) {
			multiPlayButton.setIcon(multiPlayEntryBtnImg);
			multiPlayButton.setBounds(55, 255, 440, 90);
			multiPlayButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
	
		/**
		 * @return void
		 * 마우스 커서가 멀티플레이 버튼을 빠져 나갔을 시에 발생한다.
		 */
		public void mouseExited(MouseEvent e) {
			multiPlayButton.setIcon(multiPlayBaseBtnImg);
			multiPlayButton.setBounds(65, 257, 420, 85);
			multiPlayButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	
		/**
		 * @return void
		 * 멀티플레이 버튼을 눌렀을 시 발생하고 멀티플레이 튜토리얼 화면으로 이동한다.
		 */
		public void mousePressed(MouseEvent e) {
			// 멀티 플레이 튜토리얼 화면으로 이동
			dialog.setVisible(false);
			GameFrame.getInstance().setContentPane(new MultiTutorialScreen());
			GameFrame.getInstance().setVisible(true);
			MainScreen.getMainBgm().close();
		}
	}
	
	/**	 
	 * 플레이어가 닫기 버튼을 눌렀을 경우 생성되는 클래스이다.
	 */
	private class CloseButtonHandler extends MouseAdapter {
		
		/**
		 * @return void
		 * 마우스 커서가 종료하기 버튼 내에 들어왔을 시 발생한다.
		 */		
		public void mouseEntered(MouseEvent e) {
			closeButton.setIcon(closeEntryBtnImg);
			closeButton.setBounds(55, 360, 440, 90);
			closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		/**
		 * @return void
		 * 마우스 커서가 종료하기 버튼을 빠져 나갔을 시에 발생한다.
		 */		
		public void mouseExited(MouseEvent e) {
			closeButton.setIcon(closeBaseBtnImg);
			closeButton.setBounds(65, 362, 420, 85);
			closeButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		
		/**
		 * @return void
		 * 종료하기 버튼을 눌렀을 시 발생하고 튜토리얼 팝업 창이 보이지 않게 한다.
		 */
		public void mousePressed(MouseEvent e) {
			// 튜토리얼 팝업 창 닫기
			dialog.setVisible(false);
		}
	}

	/**	 
	 * @param dialog 타입: JDialog - TutorialPopUp을 그릴 dialog를 전달받는다.
	 * 팝업 창의 배경이미지와 싱글플레이 버튼, 멀티플레이 버튼, 종료하기 버튼에 대한 이미지를 생성하고  각각의 버튼들을 패널에 add한다.	 	 
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
	 * 싱글플레이 버튼을 패널에 추가하는 메서드이다.
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
	 * 멀티플레이 버튼을 패널에 추가하는 메서드이다.
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
	 * 종료하기 버튼을 패널에 추가하는 메서드이다.
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
	 * paintComponent()를 통해 튜토리얼 팝업 창(TutorialPopUp)의 배경이미지를 그린다.
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 550, 540, null);
	}

}
