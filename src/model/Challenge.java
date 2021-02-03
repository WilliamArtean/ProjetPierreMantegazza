package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class Challenge {
	
	@Id @GeneratedValue
	private long id;
	private List<Checkpoint> checkpoints;
	private List<Segment> segments;
	private String name;
	private String description;
	
	public Challenge() {
		this.name = "Default";
		this.checkpoints = new ArrayList<Checkpoint>();
		this.segments = new ArrayList<Segment>();
	}
	public Challenge(String name, List<Checkpoint> checkpoints, List<Segment> segments) {
		this.name = name;
		this.checkpoints = checkpoints;
		this.segments = segments;
	}
	
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
