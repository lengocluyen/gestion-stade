package net.gp.gestade.Utils;

import javax.servlet.http.HttpSession;

import net.gp.gestade.form.Account;

public class SessionManage {
	private HttpSession session;

	public HttpSession getSession() {
		return session;
	}

	private Account account;
	private Boolean isLogin;
	private Boolean isAdmin;

	public Account getAccount() {
		if (account != null)
			return account;
		else
			return (Account) session.getAttribute("Account");
	}

	public void setAccount(Account account) {
		session.setAttribute("Account", account);
		this.account = account;
	}

	public Boolean getIsLogin() {
		if (isLogin != null)
			return isLogin;
		else
			return (Boolean) session.getAttribute("IsLogin");
	}

	public void setIsLogin(Boolean isLogin) {
		session.setAttribute("IsLogin", isLogin);
		this.isLogin = isLogin;
	}

	public Boolean getIsAdmin() {
		if (isAdmin != null)
			return isAdmin;
		else
			return (Boolean) session.getAttribute("IsAdmin");
	}

	public void setIsAdmin(Boolean isAdmin) {
		session.setAttribute("IsAdmin", isAdmin);
		this.isAdmin = isAdmin;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public SessionManage(HttpSession _session) {
		this.session = _session;
	}

}
