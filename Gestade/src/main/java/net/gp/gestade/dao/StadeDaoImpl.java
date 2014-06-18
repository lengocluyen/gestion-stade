package net.gp.gestade.dao;


import net.gp.gestade.form.Stade;

import org.springframework.stereotype.Repository;

@Repository("StadeDao")
public class StadeDaoImpl extends GenericDaoImpl<Stade, Integer>
		implements StadeDao {

}
