package snackFriends.view.multiPlay;

import javax.swing.JDialog;

import snackFriends.view.bean.GameFrame;

/**
 * �� �˾�(TipPopUp)â�� ���̱� ���� JDialog Ŭ�����̴�.
 * @author SnackTimeFriends 
 */
public class TipPopUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	/**
	 * TipPopUpâ�� �����ϰ� TipPopUpDialog�� TipPopUp�� add�Ѵ�. 
	 */
	public TipPopUpDialog() {
		super(GameFrame.getInstance(), true);
		add(new TipPopUp(this));
		setSize(695,985);
		this.setLocationRelativeTo(null);
	}
		
}
