package application;
import java.util.*;

import javafx.fxml.FXML;

public class Controller {
	@FXML
	void nul() {
		System.out.println("hI");
	}
	@FXML
	void dice() {
		try {
		Random ran = new Random();
		int num  =  0;
		num=ran.nextInt(6)+1;
		System.out.println(num);
		}
		catch (Exception e) {
			System.out.println("Error catched");
			e.printStackTrace();
		}
	}
	
	
}
