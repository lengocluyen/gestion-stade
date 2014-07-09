package net.gp.gestade.service;

import java.util.List;

import net.gp.gestade.dao.AccountDao;
import net.gp.gestade.dao.ScheduleDao;
import net.gp.gestade.form.Account;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	protected AccountDao adao;

	@Transactional
	public List<Account> all() {
		return (adao).list();
	}

	@Transactional
	public void delete(Account entity) {
		adao.delete(entity);
	}

	@Transactional
	public void remove(Integer key) {
		adao.remove(key);
	}

	@Transactional
	public void add(Account entity) {
		adao.add(entity);

	}

	@Transactional
	public Account single(int key)  {
		return adao.single(key);
	}

	@Transactional
	public void update(Account entity) {
		adao.update(entity);
	}
	@Transactional
	public int count() {
		return adao.count();
	}
	@Transactional
	public List<Account> all(int page, int pagesize) {
		return adao.list(page, pagesize);
	}
	@Transactional
	public Account login(String login, String pass) {
		Criterion l = Restrictions.eq("username", login);
		Criterion p = Restrictions.eq("password", pass);
		LogicalExpression le = Restrictions.and(l, p);
		List<Account> ls = adao.find(le);
		if (ls.size() > 0)
			return ls.get(0);
		else
			return null;
	}
	@Transactional
	public Account FindByLogin(String login) {
		Criterion l = Restrictions.eq("username", login);
		Criterion p = Restrictions.gt("accountID", 0);
		LogicalExpression le = Restrictions.and(l, p);
		List<Account> ls = adao.find(le);
		if (ls.size() > 0)
			return ls.get(0);
		else
			return null;
	}
	@Transactional
	public Account findByPhoneNumber(String phoneName)
	{
		Criterion l = Restrictions.eq("phonename", phoneName);
		Criterion p = Restrictions.gt("accountID", 0);
		LogicalExpression le = Restrictions.and(l, p);
		List<Account> ls = adao.find(le);
		if (ls.size() > 0)
			return ls.get(0);
		else
			return null;
	}

}
