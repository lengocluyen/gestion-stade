package net.gp.gestade.service;

import java.util.List;

import net.gp.gestade.dao.EquipmentDao;
import net.gp.gestade.form.Equipment;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EquipmentServiceImpl implements EquipmentService {

	@Autowired
	protected EquipmentDao edao;

	@Transactional
	public List<Equipment> all() {
		return (edao).list();
	}

	@Transactional
	public void delete(Equipment entity) {
		edao.delete(entity);
	}

	@Transactional
	public void remove(Integer id) {
		edao.remove(id);
	}

	@Transactional
	public void add(Equipment entity) {
		edao.add(entity);

	}

	@Transactional
	public Equipment single(Integer id) {
		return edao.single(id);
	}

	@Transactional
	public void update(Equipment entity) {
		edao.update(entity);
	}

	public int count() {
		return edao.count();
	}

	public List<Equipment> all(int page, int pagesize) {
		return edao.list(page, pagesize);
	}


	public List<Equipment> findByStadeID(String nameStade) {
		Criterion con = Restrictions.eq("Stade", nameStade);
		Criterion con2 = Restrictions.gt("EquipmentID", 0);
		LogicalExpression expression = Restrictions.and(con, con2);
		return edao.find(expression);
	}


}
