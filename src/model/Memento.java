package model;



public class Memento<Param> {
	private String state;

	public Memento(String state) {
		this.state = state;
	}

	public String getPrecedent() {
		return state;
	}
}
