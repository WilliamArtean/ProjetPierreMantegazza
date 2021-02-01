package model;

import java.util.ArrayList;
import java.util.List;

public class Segment {

	private List<Obstacle> obstacles;
	private Checkpoint previousCheckpoint;
	private Checkpoint nextCheckpoint;
	private float distance;
	
    public Segment(Checkpoint start, Checkpoint end, float distance) {
        this.obstacles = new ArrayList<>();
        this.previousCheckpoint = start;
        this.nextCheckpoint = end;
        this.distance = distance;
    }
    
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
	public float getDistance() {
        return distance;
    }
    public void setDistance(float distance) {
        this.distance = distance;
    }

}
