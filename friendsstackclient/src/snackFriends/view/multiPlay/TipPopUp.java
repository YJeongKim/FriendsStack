package snackFriends.view.multiPlay;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * ��Ƽ�÷��� ȭ�鿡�� �� ��ư�� ������ �� �����Ǵ� �˾� â�� ���� Ŭ�����̴�.
 * @author SnackTimeFriends
 */
public class TipPopUp extends JPanel {	
	private static final long serialVersionUID = 1L;
	/**
	 * �� �˾� â�� ��� �̹����� �����ϴ� ����
	 */
	private ImageIcon friendMap;
	
	/**
	 * ��Ƽ�÷��� ���� ȭ��(MultiPlayScreen)���� ?(��)��ư ������ �� �÷��̾�� �����Ǵ� �˾� â�̴�.
	 * @param dialog Ÿ��: JDialog - TipPopUp�� ���� JDialog�� ���� �޴´�.
	 */
	public TipPopUp(JDialog dialog) {
		friendMap = new ImageIcon("image/multi/friendMap.png");
	}
	
	/**
	 * paintComponent()�� ���� �� �˾� â(TipPopUp)�� ����̹����� �׸���.
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(friendMap.getImage(), 0, 0, null);
	}

}
