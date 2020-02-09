package snackFriends.view.login;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class FindIDPWPopUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public FindIDPWPopUpDialog(JFrame frame) {
		super(frame, true);
		add(new FindIDPWPopUp(this));
		setSize(560, 410);
		this.setLocationRelativeTo(null);
	}
}
