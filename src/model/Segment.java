package model;

import java.util.List;

public class Segment {

	private List<Obstacle> obstacles;
	private Checkpoint previousCheckpoint;
	private Checkpoint nextCheckpoint;
	
	public List<Obstacle> getObstacles() {
		return obstacles;
	}
	public void addObstacles(Obstacle obstacle) {
		this.obstacles.add(obstacle);
	}
	public Checkpoint getPreviousCheckpoint() {
		return previousCheckpoint;
	}
	public void setPreviousCheckpoint(Checkpoint previousCheckpoint) {
		this.previousCheckpoint = previousCheckpoint;
	}
	public Checkpoint getNextCheckpoint() {
		return nextCheckpoint;
	}
	public void setNextCheckpoint(Checkpoint nextCheckpoint) {
		this.nextCheckpoint = nextCheckpoint;
	}
	
}
