package application;
import java.util.*;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Translate;

public class Controller {
	@FXML
	private ImageView green;
	@FXML
	void nul() {
		System.out.println("hI");
	}
	@FXML
	//private int numm;
	int dice() {
		try {
		Random ran = new Random();
		int num  =  0;
		num=ran.nextInt(6)+1;
		System.out.println(num);
		return num;

		}
		catch (Exception e) {
			System.out.println("Error catched");
			e.printStackTrace();
			return 0;
		}
	}

	@FXML
	void inboard(){
		TranslateTransition move = new TranslateTransition();
		move.setNode(green);
		move.setByX(29);
		move.setByY(-41);
		move.play();

	}


}
