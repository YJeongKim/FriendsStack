package snackFriends.controller;

public class JoinService {
	public JoinService() {
	}

	public int join(JoinInfo joinInfo) {
		if (PlayerInfoDAO.getInstance().insert(joinInfo))
			return 1;
		return 0;
	}
}
