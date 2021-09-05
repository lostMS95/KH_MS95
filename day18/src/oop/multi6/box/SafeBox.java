package oop.multi6.box;

import oop.multi6.product.Brokenable;

public class SafeBox {
	
	private Brokenable value;

	public Brokenable getValue() {
		return value;
	}

	public void setValue(Brokenable value) {
		this.value = value;
	}
}
