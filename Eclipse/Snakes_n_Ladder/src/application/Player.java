package application;

import java.util.Random;

public class Player {
	private int id ;
	private Cell position;
	
	Player(int i){
		this.id = i ;
		position = new Cell(0);
	}
	
	void play() {
		int dice_num = diceRoll();
		position.moVe(dice_num);
	}
	
	public int diceRoll() {
		 int num  =  -1;
		try {
			Random ran = new Random();
			
			num=ran.nextInt(6)+1;
			System.out.println(num);
			}
			catch (Exception e) {
				System.out.println("Error catched");
				e.printStackTrace();
			}
		return num;
	}
	
	public void setPosition(Cell position) {
		this.position = position;
	}
	public Cell getPosition() {
		return position;
	}
	
	
	
}
