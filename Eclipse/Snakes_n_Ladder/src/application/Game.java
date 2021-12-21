package application;

import java.util.ArrayList;

public class Game {
	private Player p1;
	private Player p2;
	private Board board;
	
	
	Game(){
		super();
		this.p2 = new Player(2);
		p1 = new Player(1);
		board = new Board();
		
		}
	public int getPosP1() {
		return this.getP1().getPosition().getId();
	}
	public int getPosP2() {
		return this.getP2().getPosition().getId();
	}
	public Player getP1() {
		return p1;
	}
	public Board getBoard() {
		return board;
	}
	public Player getP2() {
		return p2;
	}
}
