package net.gp.gestade.dao;

import net.gp.gestade.form.Schedule;

import org.springframework.stereotype.Repository;

@Repository("ScheduleDao")
public class ScheduleDaoImpl extends GenericDaoImpl<Schedule, Integer> implements
		ScheduleDao {
}
