package model;

import java.util.List;

public abstract class Challenge {
	
	protected List<Checkpoint> checkpoints;
	protected List<Segment> segments;
	protected String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Checkpoint> getCheckpoints() {
		return checkpoints;
	}
	public void addCheckpoints(Checkpoint checkpoint) {
		this.checkpoints.add(checkpoint);
	}
	public List<Segment> getSegments() {
		return segments;
	}
	public void addSegments(Segment segment) {
		this.segments.add(segment);
	}
	
}
