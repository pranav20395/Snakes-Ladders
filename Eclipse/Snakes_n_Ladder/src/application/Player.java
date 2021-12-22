package application;

import javafx.animation.TranslateTransition;

import java.util.Random;

import javafx.animation.TranslateTransition;

public class Player {
	private int id ;
	private int position;
	
	Player(int i){
		this.id = i ;
		position=1;
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
	public void setPosition(int position) {
		this.position = position;
	}
	
	public void increaseId() {
		this.position++;
	}
	public int getPosition() {
		return position;
	}
	
}
