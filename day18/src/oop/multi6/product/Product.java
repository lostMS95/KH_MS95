package oop.multi6.product;

public abstract class Product {

	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product(String name) {
		this.name = name;
	}

}
