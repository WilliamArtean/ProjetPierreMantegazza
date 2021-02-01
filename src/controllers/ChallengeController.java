package controllers;

import java.util.ArrayList;
import java.util.List;

import dao.DAOChallenge;
import dao.DAOUser;
import model.Challenge;
import model.Checkpoint;
import model.MultiChallenge;
import model.Role;
import model.Segment;
import model.SoloChallenge;
import model.User;

public class ChallengeController {

	static DAOChallenge daoChallenge = new DAOChallenge();

	public static List<Challenge> getChallenges() {
		List<Challenge> l = daoChallenge.findAll();
		return l;
	}

	public static Challenge getChallenge(String name) {
		if (name == null)
			return null;

		Challenge c = daoChallenge.find(name);
		return c;
	}

	public static boolean createSoloChallenge(String name, List<Checkpoint> checkpoints, List<Segment> segments) {
		Challenge c = daoChallenge.find(name);
		if (c == null) {
			daoChallenge.create(new SoloChallenge(name, checkpoints, segments));
			return true;
		}
		return false;
	}
	
	public static boolean createMultiChallenge(String name, List<Checkpoint> checkpoints, List<Segment> segments) {
		Challenge c = daoChallenge.find(name);
		if (c == null) {
			daoChallenge.create(new MultiChallenge(name, checkpoints, segments));
			return true;
		}
		return false;
	}
	
	
}
