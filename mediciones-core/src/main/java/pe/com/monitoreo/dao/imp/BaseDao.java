package pe.com.monitoreo.dao.imp;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.annotations.NamedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao<T extends Serializable> {

	@PersistenceContext
	private EntityManager em;

	public T findOne(Class<T> entity, Serializable id) {
		return em.find(entity, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> entity) {
		return em.createQuery("from " + entity.getName()).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByQueryOneParam(Class<T> entity, String name, Serializable userName) {
		return em.createNamedQuery(name).setParameter(1, userName).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByQueryTwoParam(Class<T> entity, String name, Serializable param1, Serializable param2) {
		return em.createNamedQuery(name).setParameter(1, param1).setParameter(2, param2).getResultList();
	}

	public void create(T entity) {
		em.persist(entity);
	}

	public T update(T entity) {
		return em.merge(entity);
	}

	public void delete(T entity) {
		em.remove(entity);
	}

	/*
	 * public void deleteById(long entityId) { T entity = findOne(entityId);
	 * delete(entity); }
	 */
}
