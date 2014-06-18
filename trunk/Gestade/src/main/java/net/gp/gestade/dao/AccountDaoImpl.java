package net.gp.gestade.dao;

import net.gp.gestade.form.Account;

import org.springframework.stereotype.Repository;

@Repository("AccountDao")
public class AccountDaoImpl extends GenericDaoImpl<Account, Integer> implements
		AccountDao {
}
