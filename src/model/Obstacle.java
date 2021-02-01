package model;

public class Obstacle {

	private String description;
	private boolean state=false;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean getState() {
		return this.state;
	}
	
	public void swapState() {
		this.state=!this.state;
	}
	
	public void setState(boolean newState) {
		this.state = newState;
	}
	
}
