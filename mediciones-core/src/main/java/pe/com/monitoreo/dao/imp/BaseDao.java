package pe.com.monitoreo.dao.imp;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
