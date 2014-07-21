package net.gp.gestade.Utils;

import javax.servlet.http.HttpSession;

import net.gp.gestade.form.Account;
import net.gp.gestade.form.Stade;

public class SessionManage {
	private HttpSession session;

	public HttpSession getSession() {
		return session;
	}

	private Account account;
	private Boolean isLogin;
	private Boolean isAdmin;
	private Stade stade;
	public Account getAccount() {
		if (account != null)
			return account;
		else
			return (Account) session.getAttribute("account");
	}

	public void setAccount(Account account) {
		session.setAttribute("account", account);
		this.account = account;
	}
	public Stade getStade() {
		if (stade != null)
			return stade;
		else
			return (Stade) session.getAttribute("stade");
	}

	public void setStade(Stade stade) {
		session.setAttribute("stade", stade);
		this.stade= stade;
	}
	public Boolean getIsLogin() {
		if (isLogin != null)
			return isLogin;
		else
			return session.getAttribute("islogin")==null?false:true;
	}

	public void setIsLogin(Boolean isLogin) {
		session.setAttribute("isLogin", isLogin);
		this.isLogin = isLogin;
	}

	public Boolean getIsAdmin() {
		if (isAdmin != null)
			return isAdmin;
		else
			return (Boolean) session.getAttribute("isadmin");
	}

	public void setIsAdmin(Boolean isAdmin) {
		session.setAttribute("isadmin", isAdmin);
		this.isAdmin = isAdmin;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public SessionManage(HttpSession _session) {
		this.session = _session;
	}

}
