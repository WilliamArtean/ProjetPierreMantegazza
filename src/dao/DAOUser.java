package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.RegisteredChallenge;
import model.User;

public class DAOUser extends DAOAbstractFacade<User> {

	public DAOUser() {
		super(User.class);
	}
	
	public User findByName(String name) {
		CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<User> query = cb.createQuery(User.class);
		Root<User> users = query.from(User.class);
		
		query.select(users).where(cb.equal(users.get("name"), name));
		return this.getEntityManager().createQuery(query).getSingleResult();
	}
}
