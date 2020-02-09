package snackFriends.view.mainScreen;

import javax.swing.JDialog;

import snackFriends.view.bean.GameFrame;

/**
 * ���� �˾�(ExitPopUp)â�� ���̱� ���� JDialog Ŭ�����̴�.
 * 
 * @author STF
 *
 */
public class ExitPopUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	/**
	 * ExitPopUpâ�� �����ϰ� ExitPopUpDialog�� ExitPopUp�� add�Ѵ�.
	 */
	public ExitPopUpDialog() {
		super(GameFrame.getInstance(), true);
		add(new ExitPopUp(this));
		setSize(565, 505);
		this.setLocationRelativeTo(null);
	}

}
