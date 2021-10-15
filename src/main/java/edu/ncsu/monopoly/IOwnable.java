package edu.ncsu.monopoly;

public interface IOwnable {

	Player getProprietary();

	int getPrice();

	boolean isAvailable();

	void setAvailable(boolean available);

	void setProprietary(Player owner);

}