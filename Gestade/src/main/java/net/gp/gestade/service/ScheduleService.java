package net.gp.gestade.service;

import java.util.Date;
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
	
	Boolean checkInscriptionTime(String date,String toHour, String fromHour );
	Boolean checkExiste(Schedule schedule);
	List<Schedule> getByDate( int stadeID);
	List<Schedule> getByDateInput(Date date);
}
