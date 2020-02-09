package snackFriends.view.multiPlay;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * 멀티플레이 화면에서 팁 버튼을 눌렀을 시 생성되는 팝업 창에 대한 클래스이다.
 * @author SnackTimeFriends
 */
public class TipPopUp extends JPanel {	
	private static final long serialVersionUID = 1L;
	/**
	 * 팁 팝업 창의 배경 이미지를 저장하는 변수
	 */
	private ImageIcon friendMap;
	
	/**
	 * 멀티플레이 게임 화면(MultiPlayScreen)에서 ?(팁)버튼 눌렀을 시 플레이어에게 제공되는 팝업 창이다.
	 * @param dialog 타입: JDialog - TipPopUp을 붙일 JDialog를 전달 받는다.
	 */
	public TipPopUp(JDialog dialog) {
		friendMap = new ImageIcon("image/multi/friendMap.png");
	}
	
	/**
	 * paintComponent()를 통해 팁 팝업 창(TipPopUp)의 배경이미지를 그린다.
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(friendMap.getImage(), 0, 0, null);
	}

}
