package dao;

import java.util.ArrayList;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaQuery;

public abstract class DAOAbstractFacade<T> {

	@PersistenceUnit(unitName = "GVFC")
	private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GVFC");
	@PersistenceContext(unitName = "GVFC")
	private EntityManager em;

	private Class<T> classeEntite;


	public DAOAbstractFacade(Class<T> classeEntite) {
		this.classeEntite = classeEntite;
	}


	protected EntityManager getEntityManager() {
		if (em == null)
			em = emfactory.createEntityManager();
		return em;
	}


	public T create(T entite) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(entite);
		getEntityManager().flush();
		getEntityManager().getTransaction().commit();
		return entite;
	}


	public void edit(T entite) {
		getEntityManager().getTransaction().begin();
		getEntityManager().merge(entite);
		getEntityManager().getTransaction().commit();
	}


	public void remove(T entite) {
		getEntityManager().remove(getEntityManager().merge(entite));
	}


	public T find(Object id) {
		return getEntityManager().find(classeEntite, id);
	}


	public ArrayList<T> findAll() {
		@SuppressWarnings("unchecked")
		CriteriaQuery<T> cq = (CriteriaQuery<T>) getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(classeEntite));
		Vector<T> v = (Vector<T>) getEntityManager().createQuery(cq).getResultList();
		if (v != null)
			return new ArrayList<T>(v);
		return null;
	}


	public int count() {
		CriteriaQuery<Object> cq = getEntityManager().getCriteriaBuilder().createQuery();
		javax.persistence.criteria.Root<T> rt = cq.from(classeEntite);
		cq.select(getEntityManager().getCriteriaBuilder().count(rt));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		return ((Long) q.getSingleResult()).intValue();
	}
}