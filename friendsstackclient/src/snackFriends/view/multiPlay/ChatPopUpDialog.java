package snackFriends.view.multiPlay;

import javax.swing.JDialog;
import javax.swing.JLabel;

import snackFriends.view.bean.GameFrame;

/**
 * 채팅 팝업(ChatPopUp)창을 붙이기 위한 JDialog 클래스이다.
 * @author SnackTimeFriends
 */
public class ChatPopUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ChatPopUp창을 생성하고 ChatPopUpDialog에 ChatPopUp을 add한다. 
	 * @param chatLabel 타입: JLabel - 사용자가 클릭한 이모티콘 버튼을 add한다.
	 */
	public ChatPopUpDialog(JLabel chatLabel) {
		super(GameFrame.getInstance(), true);
		add(new ChatPopUp(this, chatLabel));
		setSize(565, 320);
		this.setLocationRelativeTo(null);
	}	
}
