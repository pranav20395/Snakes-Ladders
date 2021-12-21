package application;
import java.io.File;
import java.util.*;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {
	@FXML
	private ImageView green;
	@FXML
	private ImageView blue;
	@FXML
	private ImageView diceview;
	@FXML
	void nul() {
		System.out.println("hI");
	}
	int num = 0;
	@FXML
	void dice() {
		Thread dicet = new Thread() {
			public void run() {
				try {
					for (int j = 0; j < 8; j++) {
						Random ran = new Random();
						num = ran.nextInt(6) + 1;
						File f = new File("src/application/dice"+num+".png");
						diceview.setImage(new Image(f.toURI().toString()));
						Thread.sleep(100);
						System.out.println(num);
					}
					inboard();
					for(int j=0;j<num;j++){

						skiph();
					}

				} catch (
						Exception e) {
					System.out.println("Error catched");
					e.printStackTrace();

				}
			}

		};
		dicet.start();
	}

	@FXML
	void inboard(){

		TranslateTransition move = new TranslateTransition();
		move.setNode(green);
		move.setByX(29);
		move.setByY(-41);
		move.play();

	}
	@FXML
	void bboard(){
		TranslateTransition mov = new TranslateTransition();
		mov.setNode(blue);
		mov.setByY(-39);
		mov.play();

	}
	@FXML
	void skiph(){
		TranslateTransition giti = new TranslateTransition();
		giti.setNode(green);
		giti.setByX(34);
		giti.play();


	}
	@FXML
	void nskiph(){
		TranslateTransition giti = new TranslateTransition();
		giti.setNode(green);
		giti.setByX(-34);
		giti.play();


	}
	@FXML
	void skipv(){
		TranslateTransition giti = new TranslateTransition();
		giti.setNode(green);
		giti.setByY(-45);
		giti.play();

	}
	@FXML
	void nskipv(){
		TranslateTransition giti = new TranslateTransition();
		giti.setNode(green);
		giti.setByY(45);
		giti.play();

	}


}
