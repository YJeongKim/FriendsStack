package snackFriends.view.login;

import javax.swing.JDialog;

public class FindPWPutAnwserPopUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public FindPWPutAnwserPopUpDialog(JDialog dialog) {
		super(dialog, true);
		add(new FindPWPutAnwserPopUp(this));
		setSize(763, 600);
		this.setLocationRelativeTo(null);
	}

}
