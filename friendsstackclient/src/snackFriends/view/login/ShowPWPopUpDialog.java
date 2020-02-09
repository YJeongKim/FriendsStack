package snackFriends.view.login;

import javax.swing.JDialog;

public class ShowPWPopUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public ShowPWPopUpDialog(JDialog dialog) {
		super(dialog, true);
		add(new ShowPWPopUp(this));
		setSize(565, 375);
		this.setLocationRelativeTo(null);
	}

}
