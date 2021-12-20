package application;

public class Rough {
	public static void main(String[] args) {
		
		var b = new Board();
		b.addLadders();
		b.addSnake();
		System.out.println(b.getLadder_list().get(0).getHead().getId());;
	}
}
