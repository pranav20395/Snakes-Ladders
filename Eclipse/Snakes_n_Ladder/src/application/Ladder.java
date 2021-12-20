package application;

public class Ladder {
	private int id;
	private Cell head;
	private Cell tail;
	Ladder(int id){
		this.id = id;
	}
	
	Ladder(int id , Cell head , Cell tail){
		this.id = id;
		this.head = head;
		this.tail = tail;
	}
	void addLadder(int head , int tail) {
		this.setHead(new Cell(head));
		this.setTail(new Cell(tail));
	}
	//------------------------------
	public Cell getHead() {
		return head;
	}
	public Cell getTail() {
		return tail;
	}
	public void setHead(Cell head) {
		this.head = head;
	}
	public void setTail(Cell tail) {
		this.tail = tail;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
