package oop.multi5;

public class SafeBox {
	
	private Brokenable value;

	public Brokenable getValue() {
		return value;
	}

	public void setValue(Brokenable value) {
		this.value = value;
	}
}
