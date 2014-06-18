package net.gp.gestade.service;

import java.util.List;

import net.gp.gestade.form.Equipment;

public interface EquipmentService {
	
	void add(Equipment entity);

	List<Equipment> all();

	void update(Equipment entity);

	Equipment single(Integer id);

	void remove(Integer id);

	void delete(Equipment u);

	int count();

	List<Equipment> all(int page, int pagesize);
	
	List<Equipment> findByStadeID(String nameStade) ;
	
}
