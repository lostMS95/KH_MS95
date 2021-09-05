package oop.multi5;

public abstract class Grocery extends Product {

	protected String Life;

	public Grocery(String name, String life) {
		super(name);
		Life = life;
	}

	public String getLife() {
		return Life;
	}

	public void setLife(String life) {
		Life = life;
	}
}
