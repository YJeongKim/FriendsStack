package snackFriends.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class LoginServiceManager extends Thread {
	private PrintWriter pw;
	private BufferedReader br;
	private LoginService loginService;
	private JoinService joinService;
	private FindIDService findIDService;
	private FindPWService findPWService;
	private Socket socket;

	public LoginServiceManager(Socket socket) {
		this.socket = socket;
		loginService = new LoginService();
		joinService = new JoinService();
		findIDService = new FindIDService();
		findPWService = new FindPWService();

		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		String msg = null;
		try {
			msg = br.readLine();
			if (msg.substring(0, 4).equals(Message.LOGIN))
				login(msg.substring(4));
			else if (msg.substring(0, 4).equals(Message.JOIN))
				join(msg.substring(4));
			else if (msg.substring(0, 4).equals(Message.FINDID))
				findId(msg.substring(4));
			else if (msg.substring(0, 4).equals(Message.FINDPW_CHECK_ID))
				checkId(msg.substring(4));
			else if (msg.substring(0, 4).equals(Message.FINDPW_CHECK_HINT))
				checkPasswordHint(msg.substring(4));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// } finally {
		// try {
		// br.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// pw.close();
		// try {
		// socket.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}

	public void login(String loginInfo) {
		pw.println(loginService.login(new LoginInfo(loginInfo.split("//"))));
	}

	public void join(String joinInfo) {
		pw.println(joinService.join(new JoinInfo(joinInfo.split("//"))));
	}

	public void findId(String email) {
		pw.println(findIDService.findID(email));
	}

	public void checkId(String id) {
		pw.println(findPWService.checkId(id));
	}

	public void checkPasswordHint(String idHintInfo) {
		String[] idHintInfos = idHintInfo.split("//");
		pw.println(findPWService.checkpassWordHint(idHintInfos[0], Integer.parseInt(idHintInfos[1]), idHintInfos[2]));
	}

}
