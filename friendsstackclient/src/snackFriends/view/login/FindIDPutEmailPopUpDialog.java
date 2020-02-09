package snackFriends.view.login;

import javax.swing.JDialog;

public class FindIDPutEmailPopUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public FindIDPutEmailPopUpDialog(JDialog dialog) {
		super(dialog, true);
		add(new FindIDPutEmailPopUp(this));
		setSize(763, 495);
		this.setLocationRelativeTo(null);
	}

}
