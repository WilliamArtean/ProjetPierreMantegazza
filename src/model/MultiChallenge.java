package model;

import java.util.List;

public class MultiChallenge extends Challenge {

	private int maxPlayer;
	private List<User> players;
	
	public int getMaxPlayer() {
		return maxPlayer;
	}
	public void setMaxPlayer(int maxPlayer) {
		this.maxPlayer = maxPlayer;
	}
	public List<User> getPlayers() {
		return players;
	}
	public void addPlayers(User player) {
		this.players.add(player);
	}
	
	
}
