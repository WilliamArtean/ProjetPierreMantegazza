package model;

import java.util.List;

public class Checkpoint {

	private boolean start;
	private boolean finish;
	private List<User> players;
	
	public boolean isStart() {
		return start;
	}
	public void setStart(boolean start) {
		this.start = start;
	}
	public boolean isFinish() {
		return finish;
	}
	public void setFinish(boolean finish) {
		this.finish = finish;
	}
	public void addPlayer(User player) {
		this.players.add(player);
	}
	public User getPlayer(int index) {
		return this.players.get(index);
	}
	
}
