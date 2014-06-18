package net.gp.gestade.dao;

import java.util.List;

import org.hibernate.criterion.LogicalExpression;

public interface GenericDao<E, K> {
	public void add(E entity);

	public void update(E entity);

	public void delete(E entity);

	public void remove(K id);

	public E single(K key);

	public List<E> list();

	public int count();

	public List<E> list(int startpage, int pagesize);

	public List<E> find(LogicalExpression le);

}
