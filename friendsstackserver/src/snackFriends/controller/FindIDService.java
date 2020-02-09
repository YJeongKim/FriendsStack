package snackFriends.controller;

public class FindIDService {
	public FindIDService() {
	}
	public String findID(String email) {
		return PlayerInfoDAO.getInstance().searchEmail(email);
	}
}
