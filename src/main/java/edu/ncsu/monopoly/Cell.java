package edu.ncsu.monopoly;

public abstract class Cell implements IOwnable {
	private boolean available = true;
	String name;
	protected Player proprietary;

	public String getName() {
		return name;
	}

	@Override
	public Player getProprietary() {
		return proprietary;
	}
	
	@Override
	public int getPrice() {
		return 0;
	}

	@Override
	public boolean isAvailable() {
		return available;
	}
	
	public abstract void playAction();

	@Override
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setProprietary(Player owner) {
		this.proprietary = owner;
	}
    
    /**
	 * @deprecated Use {@link edu.ncsu.monopoly.Player#toString(edu.ncsu.monopoly.Cell)} instead
	 */
	public String toString() {
		return proprietary.toString(this);
	}
}
