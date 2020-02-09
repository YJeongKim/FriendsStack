package snackFriends.view.login;

import javax.swing.JDialog;

public class ShowIDPopUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public ShowIDPopUpDialog(JDialog dialog,String id) {
		super(dialog, true);
		add(new ShowIDPopUp(this,id));
		setSize(565, 375);
		this.setLocationRelativeTo(null);
	}

}
