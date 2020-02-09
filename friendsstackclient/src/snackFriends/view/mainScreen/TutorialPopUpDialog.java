package snackFriends.view.mainScreen;

import javax.swing.JDialog;

import snackFriends.view.bean.GameFrame;

/**
 * 튜토리얼 팝업(TutorialPopUp)창을 붙이기 위한 JDialog 클래스이다.
 * @author SnackTimeFriends
 */
public class TutorialPopUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	/**
	 * TutorialPopUp창을 생성하고 TutorialPopUpDialog에 TutorialPopUp을 add한다.
	 */
	public TutorialPopUpDialog() {
		super(GameFrame.getInstance(), true);
		add(new TutorialPopUp(this));
		setSize(565, 575);
		this.setLocationRelativeTo(null);
	}
	
}
