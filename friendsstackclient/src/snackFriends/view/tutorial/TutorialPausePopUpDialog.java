package snackFriends.view.tutorial;

import javax.swing.JDialog;

import snackFriends.view.bean.GameFrame;
import snackFriends.view.bean.Music;

/**
 * 튜토리얼 일시정지 팝업(TutorialPausePopUp)창을 붙이기 위한 JDialog 클래스이다.
 * 
 * @author SnackTimeFriends
 *
 */
public class TutorialPausePopUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	/**
	 * TutorialPausePopUp창을 생성하고 TutorialPausePopUpDialog에 TutorialPausePopUp을
	 * add한다.
	 */
	public TutorialPausePopUpDialog(Music bgm) {
		super(GameFrame.getInstance(), true);
		add(new TutorialPausePopUp(this, bgm));
		setSize(565, 320);
		this.setLocationRelativeTo(null);
	}

}
