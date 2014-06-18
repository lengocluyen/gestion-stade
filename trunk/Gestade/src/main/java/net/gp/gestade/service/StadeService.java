package net.gp.gestade.service;

import java.util.List;

import net.gp.gestade.form.Stade;


public interface StadeService {
	List<Stade> all();
	Stade single(Integer key);
	void update(Stade entity);
	void add(Stade entity);
	void delete(Integer key);
	List<Stade> all(int page, int pagesize);
}
