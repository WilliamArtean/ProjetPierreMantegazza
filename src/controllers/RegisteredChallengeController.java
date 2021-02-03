package controllers;

import java.util.ArrayList;
import java.util.List;

import dao.DAORegisteredChallenge;
import model.Challenge;
import model.RegisteredChallenge;
import model.User;

public class RegisteredChallengeController {
	
	static DAORegisteredChallenge daoRc = new DAORegisteredChallenge();
	
	static public List<RegisteredChallenge> getChallenges(User user) {
		return daoRc.findByUser(user);
	}
	
	static public boolean createRegisteredChallenge(User user, Challenge challenge) {
		RegisteredChallenge rc = new RegisteredChallenge(user, challenge);
		if(daoRc.exist(rc)) {
			return false;
		}
		daoRc.create(rc);
		return true;
	}
}
