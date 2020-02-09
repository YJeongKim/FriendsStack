package snackFriends.controller;

public class LoginService {
	public LoginService() {
	}

	public int login(LoginInfo loginInfo) {
		System.out.println(loginInfo);
		return PlayerInfoDAO.getInstance().search(new PlayerInfo(loginInfo.getId(), loginInfo.getPassword()));
	}
}
