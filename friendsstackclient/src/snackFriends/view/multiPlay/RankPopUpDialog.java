package snackFriends.view.multiPlay;

import javax.swing.JDialog;

import snackFriends.view.bean.GameFrame;

/**
 * ��� �˾�(RankPopUp)â�� ���̱� ���� JDialog Ŭ�����̴�.
 * @author SnackTimeFriends
 *
 */
public class RankPopUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	/**
	 * RankPopUpâ�� �����ϰ� RankPopUpDialog�� RankPopUp�� add�Ѵ�.
	 */
	public RankPopUpDialog() {
		super(GameFrame.getInstance(), true);
		add(new RankPopUp(this));
		setSize(765, 990);
		this.setLocationRelativeTo(null);
	}

}
