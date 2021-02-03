package model;

public enum Role {
	ADMINISTRATOR("Administrator"),
	NORMAL("Normal");
	
	private final String value;
	
	Role(String v) {
		this.value = v;
	}
	
	public boolean equals(String role) {
		return role == this.value;
	}
}
