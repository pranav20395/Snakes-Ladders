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
	public void increasePosP1() {
		this.p1.increaseId();
	}
	public void increasePosP2() {
		this.p2.increaseId();
	}
	public void setPositionP1(int i) {
		this.p1.setPosition(i);
	}
	public void setPositionP2(int i) {
		this.p2.setPosition(i);
	}
	public int getPosP1() {
		return this.p1.getPosition();
	}
	public int getPosP2() {
		return this.p2.getPosition();
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
