package net.gp.gestade.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.gp.gestade.Utils.Utils;
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

	public Boolean checkInscriptionTime(String date, String toHour,
			String fromHour) {

		return true;
	}

	@Transactional
	public Boolean checkExiste(Schedule schedule) {
		List<Schedule> schedules = sdao.list();
		for (Schedule s : schedules) {
			if (s.getAccountID().compareTo(schedule.getAccountID()) == 0
					&& s.getStadeID().compareTo(schedule.getStadeID()) == 0
					&& s.getDateOrder().compareTo(schedule.getDateOrder()) == 0
					&& s.getFromHour().compareTo(schedule.getFromHour()) == 0)
				return true;

		}
		return false;
	}

	public List<Schedule> getByDate(int stadeID) {
		List<Schedule> result = new ArrayList<Schedule>();
		List<Schedule> schedules = sdao.list();
		for (Schedule s : schedules) {
			if (s.getStadeID().compareTo(stadeID) == 0)
				result.add(s);

		}
		return result;
	}

	public List<Schedule> getByDateInput(Date date) {
		List<Schedule> result = new ArrayList<Schedule>();
		List<Schedule> schedules = sdao.list();
		for (Schedule s : schedules) {
			if (Utils.getDate(s.getDateOrder()).compareTo(date) >= 0)
				result.add(s);

		}
		return result;
	}
}
