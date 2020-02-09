package snackFriends.controller;

public class FindPWService {
	public FindPWService() {
	}

	public boolean checkId(String id) {
		return PlayerInfoDAO.getInstance().searchID(id);
	}

	public String checkpassWordHint(String id, int passwordHintQuestion, String passwordHintAnswer) {
		if (PlayerInfoDAO.getInstance().searchPasswordHintQuestion(id, passwordHintQuestion))
			return PlayerInfoDAO.getInstance().searchPasswordHintAnswer(id, passwordHintAnswer);
		return null;
	}
}
