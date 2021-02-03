package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.RegisteredChallenge;
import model.User;

public class DAORegisteredChallenge extends DAOAbstractFacade<RegisteredChallenge> {
	
	public DAORegisteredChallenge() {
		super(RegisteredChallenge.class);
	}
	
	public List<RegisteredChallenge> findByUser(User u) {
		CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<RegisteredChallenge> query = cb.createQuery(RegisteredChallenge.class);
		Root<RegisteredChallenge> rc = query.from(RegisteredChallenge.class);
		
		query.select(rc).where(cb.equal(rc.get("user"), u));
		return this.getEntityManager().createQuery(query).getResultList();
	}
	
	public boolean exist(RegisteredChallenge rc) {
		CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<RegisteredChallenge> query = cb.createQuery(RegisteredChallenge.class);
		Root<RegisteredChallenge> registered = query.from(RegisteredChallenge.class);
		
		query.select(registered).where(cb.equal(registered, rc));
		if(this.getEntityManager().createQuery(query).getResultList().size() != 0) {
			return true;
		}
		return false;
	}
}
