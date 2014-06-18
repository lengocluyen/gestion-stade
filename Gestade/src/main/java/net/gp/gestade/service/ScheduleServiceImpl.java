package net.gp.gestade.service;

import java.util.Date;
import java.util.List;

import net.gp.gestade.dao.ScheduleDao;
import net.gp.gestade.dao.AccountDao;
import net.gp.gestade.form.Account;
import net.gp.gestade.form.Schedule;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	protected ScheduleDao sdao;
	@Transactional
	public List<Schedule> all() {
		return (sdao).list();
	}

	@Transactional
	public void delete(Integer id) {
		sdao.remove(id);
	}

	@Transactional
	public void add(Schedule entity) {
		sdao.add(entity);

	}

	@Transactional
	public Schedule single(Integer id) {
		return sdao.single(id);
	}

	@Transactional
	public void update(Schedule entity) {
		sdao.update(entity);
	}
	@Transactional
	public int count() {
		return sdao.count();
	}
	@Transactional
	public List<Schedule> all(int page, int pagesize) {
		return sdao.list(page, pagesize);
	}

}
