package net.gp.gestade.service;

import java.util.List;

import net.gp.gestade.form.Schedule;

public interface ScheduleService {
	void add(Schedule entity);

	List<Schedule> all();

	void update(Schedule entity);

	Schedule single(Integer id);


	void delete(Integer uid);

	int count();

	List<Schedule> all(int page, int pagesize);
}
