package application;

public class Cell {
	private int id ;
	public Cell(int id){
		this.id = id;
	}
	
	public void moVe(int i) {
		this.id = i;
	}
	public int getId() {
		return id;
	}
	
}
