package application;

import java.util.ArrayList;

public class Board {
	final ArrayList<Cell> grid =new ArrayList<>() ;
	private ArrayList<Snake> snape_list = new ArrayList<>();
	private ArrayList<Ladder> ladder_list = new ArrayList<>();
	Board(){
		for (int i = 0 ; i<100 ; i++) {
			grid.add(new Cell(i));
		}
	}
	
	void addSnake() {
		int index = 0;
		int arr[] = {22,2,15,5,33,8,44,23,79,43,94,47,68,50,85,65,92,71,98,82}; 
		for (int i =0 ; i < 10 ; i++) {
			snape_list.add(new Snake(i+1));
			snape_list.get(i).addSnake(arr[index], arr[index+1]);
			index +=2;
		}
	}
	void addLadders() {
		int index = 0;
		int arr[] = {24,3,34,7,31,12,41,20,46,36,63,56,81,60,97,78,95,75,93,69}; 
		for (int i =0 ; i < 10 ; i++) {
			ladder_list.add(new Ladder(i+1));
			ladder_list.get(i).addLadder(arr[index], arr[index+1]);
			index +=2;
		}
		
	}
	public ArrayList<Ladder> getLadder_list() {
		return ladder_list;
	}
}
