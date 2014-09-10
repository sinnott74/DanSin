package dansin.util.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import dansin.util.dao.intf.Dao;

public class DaoImpl<E> implements Dao<E> {

	protected EntityManager em;

	protected Class<E> type;

	public DaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("EJBServer");
		em = emf.createEntityManager();
	}

	public EntityManager em() {
		return em;
	}

	@Override
	public void save(E entity) {
		em.persist(entity);
		em.flush();
		em.refresh(entity);

	}

	@Override
	public void update(E entity) {
		em.merge(entity);

	}

	@Override
	public void delete(E entity) {
		em.remove(entity);

	}

	@Override
	public E get(Long id) {
		return em.find(type, id);
	}
}
