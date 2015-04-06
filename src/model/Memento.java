package model;

public class Memento<Param> {
	private Param param;

	public Memento(Param param) {
		this.param = param;
	}

	public Param getPrecedent() {
		return (this.param);
	}
}
