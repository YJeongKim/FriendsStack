package snackFriends.view.multiPlay;

import javax.swing.JDialog;
import javax.swing.JLabel;

import snackFriends.view.bean.GameFrame;

/**
 * ä�� �˾�(ChatPopUp)â�� ���̱� ���� JDialog Ŭ�����̴�.
 * @author SnackTimeFriends
 */
public class ChatPopUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ChatPopUpâ�� �����ϰ� ChatPopUpDialog�� ChatPopUp�� add�Ѵ�. 
	 * @param chatLabel Ÿ��: JLabel - ����ڰ� Ŭ���� �̸�Ƽ�� ��ư�� add�Ѵ�.
	 */
	public ChatPopUpDialog(JLabel chatLabel) {
		super(GameFrame.getInstance(), true);
		add(new ChatPopUp(this, chatLabel));
		setSize(565, 320);
		this.setLocationRelativeTo(null);
	}	
}
