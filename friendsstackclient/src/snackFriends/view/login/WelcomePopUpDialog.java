package snackFriends.view.login;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class WelcomePopUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public WelcomePopUpDialog(JFrame frame) {
		super(frame, true);
		add(new WelcomePopUp(frame, this));
		setSize(565, 450);
		this.setLocationRelativeTo(null);
	}

}
