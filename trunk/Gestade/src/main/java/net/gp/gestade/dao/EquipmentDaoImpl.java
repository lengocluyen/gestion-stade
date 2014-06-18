package net.gp.gestade.dao;

import net.gp.gestade.form.Equipment;

import org.springframework.stereotype.Repository;

@Repository("EquipmentDao")
public class EquipmentDaoImpl extends GenericDaoImpl<Equipment, Integer> implements
		EquipmentDao {

}
