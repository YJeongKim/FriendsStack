package snackFriends.view.mainScreen;

import javax.swing.JDialog;

import snackFriends.view.bean.GameFrame;

/**
 * Ʃ�丮�� �˾�(TutorialPopUp)â�� ���̱� ���� JDialog Ŭ�����̴�.
 * @author SnackTimeFriends
 */
public class TutorialPopUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	/**
	 * TutorialPopUpâ�� �����ϰ� TutorialPopUpDialog�� TutorialPopUp�� add�Ѵ�.
	 */
	public TutorialPopUpDialog() {
		super(GameFrame.getInstance(), true);
		add(new TutorialPopUp(this));
		setSize(565, 575);
		this.setLocationRelativeTo(null);
	}
	
}
