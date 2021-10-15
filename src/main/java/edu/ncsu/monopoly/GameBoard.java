package edu.ncsu.monopoly;



public class GameBoard extends BoardGame {

	public GameBoard() {
		super();
		IOwnable go = new GoCell();
		addCell(go);
	}
}
