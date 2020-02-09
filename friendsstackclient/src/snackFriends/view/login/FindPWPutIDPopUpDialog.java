package snackFriends.view.login;

import javax.swing.JDialog;

public class FindPWPutIDPopUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public FindPWPutIDPopUpDialog(JDialog dialog) {
		super(dialog, true);
		add(new FindPWPutIDPopUp(this));
		setSize(565, 418);
		this.setLocationRelativeTo(null);
	}
}
