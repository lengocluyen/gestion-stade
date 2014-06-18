package net.gp.gestade.service;

import java.util.List;

import net.gp.gestade.dao.StadeDao;
import net.gp.gestade.form.Stade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StadeServiceImpl implements StadeService {

	@Autowired
	protected StadeDao sDao;
		@Transactional
	public void update(Stade entity) {
		sDao.update(entity);
	}
	@Transactional
	public void delete(Integer key) {
		sDao.remove(key);
	}
	@Transactional
	public int count() {
		return sDao.count();
	}
	@Transactional
	public List<Stade> all(int page, int pagesize) {
		return sDao.list(page, pagesize);
	}
	@Transactional
	public void add(Stade entity) {
		sDao.add(entity);
	}
	public List<Stade> all() {
		return sDao.list();
	}
	public Stade single(Integer key) {
		return sDao.single(key);
	}
}
