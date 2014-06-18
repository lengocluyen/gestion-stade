package net.gp.gestade.service;

import java.util.List;

import net.gp.gestade.form.Account;

public interface AccountService {
	void add(Account user);

	List<Account> all();

	void update(Account entity);

	Account single(int key);
	
	Account FindByLogin(String login);
	
	void remove(Integer key);

	void delete(Account entity);

	int count();

	List<Account> all(int page, int pagesize);
	
	Account login(String login, String pass);
	
	Account findByPhoneNumber(String phoneName);
	
}
