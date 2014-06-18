package net.gp.gestade.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class GenericDaoImpl<E, K extends Serializable> implements
		GenericDao<E, K> {
	private SessionFactory sessionFactory;
	protected Class<? extends E> daoType;
	public GenericDaoImpl() {
		daoType = (Class<E>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void add(E entity) {
		currentSession().save(entity);
	}

	public void update(E entity) {
		currentSession().saveOrUpdate(entity);
	}


	public void delete(E entity) {
		currentSession().delete(entity);
	}

	public void remove(K id) {
		delete(single(id));
	}

	public E single(K key) {
		return (E) currentSession().get(daoType, key);
	}

	public List<E> list() {
		return currentSession().createCriteria(daoType).addOrder(Order.desc(daoType.getDeclaredFields()[0].getName())).list();
	}

	public int count() {
		Criteria criteria = currentSession().createCriteria(daoType);

		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.uniqueResult()).intValue();
	}

	public List<E> list(int startpage, int pagesize) {
		if (startpage > 0)
			--startpage;
		int firsResult = startpage * pagesize;
		Criteria criteria = currentSession().createCriteria(daoType);
		criteria.addOrder(Order.desc(daoType.getDeclaredFields()[0].getName()));
		criteria.setFirstResult(firsResult);
		criteria.setMaxResults(pagesize);
		return criteria.list();
	}

	public List<E> find(LogicalExpression le) {
		Criteria criteria = currentSession().createCriteria(daoType);
		criteria.add(le);
		criteria.addOrder(Order.desc(daoType.getDeclaredFields()[0].getName()));
		return criteria.list();
	}
}
