package snackFriends.view.tutorial;

import javax.swing.JDialog;

import snackFriends.view.bean.GameFrame;
import snackFriends.view.bean.Music;

/**
 * Ʃ�丮�� �Ͻ����� �˾�(TutorialPausePopUp)â�� ���̱� ���� JDialog Ŭ�����̴�.
 * 
 * @author SnackTimeFriends
 *
 */
public class TutorialPausePopUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	/**
	 * TutorialPausePopUpâ�� �����ϰ� TutorialPausePopUpDialog�� TutorialPausePopUp��
	 * add�Ѵ�.
	 */
	public TutorialPausePopUpDialog(Music bgm) {
		super(GameFrame.getInstance(), true);
		add(new TutorialPausePopUp(this, bgm));
		setSize(565, 320);
		this.setLocationRelativeTo(null);
	}

}
