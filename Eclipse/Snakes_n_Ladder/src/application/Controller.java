package application;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller {
	private Game game = new Game();
	@FXML
	private Text greenwon;
	@FXML
	private Text bluewon;
	@FXML
	private ImageView winpopup;
	@FXML
	public Button replay;


	@FXML
	private Button tempbutton;
	@FXML
	public ImageView green;
	@FXML
	public ImageView blue;
	@FXML
	private ImageView diceview;

	@FXML
	void nul() {
		System.out.println("hI");
	}

	int num = 0;
	int in = 0;
	int in_p1 = 0;
	int in_p2 = 0;
	int gg = 0;
	int player_turn = 1;
	int p1_pos = 1;
	int p2_pos = 1;
	int yaxis_counter = 1;
	int yaxis_counter2 = 1;
	int limit = 11;
	private Stage welcom;
	private Scene login;
	private Parent root;
	int ladder[] ={24,3,34,7,31,12,41,20,46,36,63,56,81,60,97,78,95,75,93,69};

	@FXML
	void gamePlay() {


		if (game.getPosP1() >= 100) {
			//---------

			//---------
			return;
		}
		if (game.getPosP2() >= 100) {
			//--------

			//---------
			return;
		}

		if (player_turn % 2 == 0) {    // for p1
			System.out.println("green turn");
			try {
				dice();
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (in_p1 == 0 && num == 1) {
				inboard(); //green gioti for p1
				in_p1++;
			} else if (in_p1 != 0) {
				if (num == 6) player_turn--;

				if (game.getPosP1() + num > 100) {
					player_turn++;
					return;
				}
				tempbutton.setDisable(true);
				//-------------------------------
				Thread goti_thread = new Thread() {

					public void run() {
						//if (p1_pos+num >100) return;
						try {
							if ((num + game.getPosP1()) == 100) {
								System.out.println("p1 win");
								show_winpage(2);

							}
							for (int i = 0; i < num; i++) {

								if (game.getPosP1() == 100) {
									System.out.println("p1 win");
									show_winpage(2);
									return;

								}
								p1_pos++;
								game.increasePosP1();
								System.out.println(game.getPosP1());
								if (game.getPosP1() % 10 == 1) {
									yUp_green();
									yaxis_counter++;
									Thread.sleep(500);

									continue;
								}
								if (yaxis_counter % 2 != 0) {
									skiph();
								} else if (yaxis_counter % 2 == 0) {
									nskiph();
								}

								Thread.sleep(500);

								//System.out.println(p1_pos);

								
							}
							
							//----------------------------
							
							 climb_ladder(game.getPosP1(), 1);
							 climb_snakes(game.getPosP1(), 1);
							//----------------------------
							
						} catch (Exception e) {
							e.printStackTrace();
						}
						
						tempbutton.setDisable(false);
					}
				};
				goti_thread.start();
				
				


				//-------------------------------
			}


		} else {     // for p2
			System.out.println("blue turn");
			try {
				dice();
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (in_p2 == 0 && num == 1) {
				bboard(); //blue gioti for p1
				in_p2++;
			} else if (in_p2 != 0) {
				//-------------------------------
				if (num == 6) player_turn--;
				
				if (game.getPosP2() + num > 100) {
					player_turn++;
					return;
				}
				tempbutton.setDisable(true);
				Thread goti_thread2 = new Thread() {

					public void run() {
						try {
							if ((num + game.getPosP2()) == 100) {
								System.out.println("p2 win");
								show_winpage(0);

							}

							for (int i = 0; i < num; i++) {
								if (game.getPosP2() == 100) {
									System.out.println("p2 win");
									show_winpage(0);
									return;

								}
								game.increasePosP2();
								//p2_pos++;
								//System.out.println(p2_pos);
								if (game.getPosP2() % 10 == 1) {
									//System.out.println("i am here");
									yUp_blue();
									yaxis_counter2++;
									Thread.sleep(500);

									continue;
								}
								if ((yaxis_counter2) % 2 != 0) {
									skiph_blue();
								} else if (yaxis_counter2 % 2 == 0) {
									nskiph_blue();
								}

								Thread.sleep(500);

								//System.out.println(p2_pos);


							}
							//------------------------------
							climb_ladder(game.getPosP2(), 0);
							climb_snakes(game.getPosP2(), 0);
							//-------------------------------
						} catch (Exception e) {
							e.printStackTrace();
						}
						tempbutton.setDisable(false);
					}
				};
				goti_thread2.start();


				//-------------------------------
			}
		}

		player_turn++;

	}
	void show_winpage(int i){
		winpopup.setOpacity(1);
		if (i ==0 ){
			bluewon.setOpacity(1);
			return;
		}
		greenwon.setOpacity(1);
	}
	@FXML
	void dice_run() {

		try {
			dice();

			tempbutton.setDisable(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (in == 0) inboard();
		in++;
		System.out.println("--" + num);
		Thread goti_thread = new Thread() {

			public void run() {
				try {
					for (int i = 0; i < num; i++) {
						//System.out.println(num );
						skiph();
						Thread.sleep(500);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				tempbutton.setDisable(false);
			}

		};
		goti_thread.start();


	}


	@FXML
	void dice() throws InterruptedException {
		Random ran = new Random();
		num = ran.nextInt(6) + 1;
		File f = new File("src/application/dice" + num + ".png");
		diceview.setImage(new Image(f.toURI().toString()));

		//System.out.println("--"+num+"--");
	}

	//--------------------------------------------
	@FXML
	void inboard() { // for green goti

		TranslateTransition move = new TranslateTransition();
		move.setNode(green);
		move.setByX(29);
		move.setByY(-41);
		move.play();

	}

	@FXML
	void bboard() { // for blue gotiya
		TranslateTransition mov = new TranslateTransition();
		mov.setNode(blue);
		mov.setByY(-39);
		mov.play();

	}

	@FXML
	void skiph() { // for moving green horizontally
		TranslateTransition giti = new TranslateTransition();
		giti.setNode(green);
		giti.setByX(34);
		giti.play();
	}

	void skiph_blue() {
		TranslateTransition giti = new TranslateTransition();
		giti.setNode(blue);
		giti.setByX(34);
		giti.play();


	}

	@FXML
	void nskiph() {
		TranslateTransition giti = new TranslateTransition();
		giti.setNode(green);
		giti.setByX(-34);
		giti.play();


	}

	void nskiph_blue() {
		TranslateTransition giti = new TranslateTransition();
		giti.setNode(blue);
		giti.setByX(-34);
		giti.play();


	}

	@FXML
	void yUp_green() {
		TranslateTransition giti = new TranslateTransition();
		giti.setNode(green);
		giti.setByY(-45);
		giti.play();

	}

	void yUp_blue() {
		TranslateTransition giti = new TranslateTransition();
		giti.setNode(blue);
		giti.setByY(-45);
		giti.play();

	}

	void yDown_green() {
		TranslateTransition giti = new TranslateTransition();
		giti.setNode(green);
		giti.setByY(45);
		giti.play();

	}

	@FXML
	public void play(ActionEvent p) throws IOException {
		root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start.fxml")));
		welcom = (Stage) ((Node) p.getSource()).getScene().getWindow();
		login = new Scene(root);
		welcom.setScene(login);
		welcom.show();


	}

	@FXML
	public void replay(ActionEvent p) throws IOException {
		root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main.fxml")));
		welcom = (Stage) ((Node) p.getSource()).getScene().getWindow();
		login = new Scene(root);
		welcom.setScene(login);
		welcom.show();
	}
	public void climb_ladder(int pos,int id){                  //id=1 for green else blue
		if (pos==3){
			TranslateTransition giti = new TranslateTransition();
			if(id==1){
				giti.setNode(green);
				game.setPositionP1(24);
				yaxis_counter=3;
			}
			else{
				giti.setNode(blue);
				game.setPositionP2(24);
				yaxis_counter2=3;
			}
			giti.setByX(36);
			giti.setByY(-91);
			giti.play();

		}
		else if(pos==7){
			TranslateTransition giti = new TranslateTransition();
			if(id==1){
				giti.setNode(green);
				game.setPositionP1(34);
				yaxis_counter=4;
			}
			else{
				giti.setNode(blue);
				game.setPositionP2(34);
				yaxis_counter2=4;
			}
			giti.setByY(-133);
			giti.play();
		}
		else if(pos==12){
			TranslateTransition giti = new TranslateTransition();
			if(id==1){
				giti.setNode(green);
				game.setPositionP1(31);
				yaxis_counter=4;
			}
			else{
				giti.setNode(blue);
				game.setPositionP2(31);
				yaxis_counter2=4;
			}
			giti.setByX(36);
			giti.setByY(-91);
			giti.play();
		}
		else if(pos==20){
			TranslateTransition giti = new TranslateTransition();
			if(id==1){
				giti.setNode(green);
				game.setPositionP1(41);
				yaxis_counter=5;
			}
			else{
				giti.setNode(blue);
				game.setPositionP2(41);
				yaxis_counter2=5;
			}
			giti.setByY(-133);
			giti.play();
		}
		else if(pos==36){
			TranslateTransition giti = new TranslateTransition();
			if(id==1){
				giti.setNode(green);
				game.setPositionP1(46);
				yaxis_counter=5;
				
			}
			else{
				giti.setNode(blue);
				game.setPositionP2(46);
				yaxis_counter2=5;
			}
			giti.setByX(32);
			giti.setByY(-44);
			giti.play();
		}
		else if(pos==56){
			TranslateTransition giti = new TranslateTransition();
			if(id==1){
				giti.setNode(green);
				game.setPositionP1(63);
				yaxis_counter=7;
			}
			else{
				giti.setNode(blue);
				game.setPositionP2(63);
				yaxis_counter2=7;
			}
			giti.setByX(-69);
			giti.setByY(-48);
			giti.play();
			
		}
		else if(pos==60){
			TranslateTransition giti = new TranslateTransition();
			if(id==1){
				giti.setNode(green);
				game.setPositionP1(81);
				yaxis_counter=9;
			}
			else{
				giti.setNode(blue);
				game.setPositionP2(81);
				yaxis_counter2=9;
			}
			giti.setByY(-133);
			giti.play();
		}
		else if(pos==69){
			TranslateTransition giti = new TranslateTransition();
			if(id==1){
				giti.setNode(green);
				game.setPositionP1(93);
				yaxis_counter=10;
			}
			else{
				giti.setNode(blue);
				game.setPositionP2(93);
				yaxis_counter2=10;
			}
			giti.setByX(-35);
			giti.setByY(-134);
			giti.play();
		}
		else if(pos==75){
			TranslateTransition giti = new TranslateTransition();
			if(id==1){
				giti.setNode(green);
				game.setPositionP1(95);
				yaxis_counter=10;
			}
			else{
				giti.setNode(blue);
				game.setPositionP2(95);
				yaxis_counter2=5;
			}
			giti.setByY(-91);
			giti.play();
		}
		else if(pos==78){
			TranslateTransition giti = new TranslateTransition();
			if(id==1){
				giti.setNode(green);
				game.setPositionP1(97);
				yaxis_counter=10;
			}
			else{
				giti.setNode(blue);
				game.setPositionP2(97);
				yaxis_counter2=10;
			}
			giti.setByX(36);
			giti.setByY(-91);
			giti.play();
		}

	}
	public void climb_snakes(int pos,int id){                  //id=1 for green else blue
		if (pos==15){
			//TranslateTransition giti = new TranslateTransition();
			Polyline snake = new Polyline();
			snake.getPoints().addAll(215.0,397.0,
					179.0,418.0,
					206.0,445.0,
					179.0,445.0);
			PathTransition giti = new PathTransition();
			if(id==1){
				giti.setNode(green);
			}
			else{
				giti.setNode(blue);
			}
			giti.setDuration(Duration.seconds(2));
			giti.setPath(snake);
			giti.play();

		}
//		else if(pos==7){
//			TranslateTransition giti = new TranslateTransition();
//			if(id==1){
//				giti.setNode(green);
//			}
//			else{
//				giti.setNode(blue);
//			}
//			giti.setByY(-133);
//			giti.play();
//		}
//		else if(pos==12){
//			TranslateTransition giti = new TranslateTransition();
//			if(id==1){
//				giti.setNode(green);
//			}
//			else{
//				giti.setNode(blue);
//			}
//			giti.setByX(36);
//			giti.setByY(-91);
//			giti.play();
//		}
//		else if(pos==20){
//			TranslateTransition giti = new TranslateTransition();
//			if(id==1){
//				giti.setNode(green);
//			}
//			else{
//				giti.setNode(blue);
//			}
//			giti.setByY(-133);
//			giti.play();
//		}
//		else if(pos==36){
//			TranslateTransition giti = new TranslateTransition();
//			if(id==1){
//				giti.setNode(green);
//			}
//			else{
//				giti.setNode(blue);
//			}
//			giti.setByX(32);
//			giti.setByY(-44);
//			giti.play();
//		}
//		else if(pos==56){
//			TranslateTransition giti = new TranslateTransition();
//			if(id==1){
//				giti.setNode(green);
//			}
//			else{
//				giti.setNode(blue);
//			}
//			giti.setByX(-69);
//			giti.setByY(-48);
//			giti.play();
//		}
//		else if(pos==60){
//			TranslateTransition giti = new TranslateTransition();
//			if(id==1){
//				giti.setNode(green);
//			}
//			else{
//				giti.setNode(blue);
//			}
//			giti.setByY(-133);
//			giti.play();
//		}
//		else if(pos==69){
//			TranslateTransition giti = new TranslateTransition();
//			if(id==1){
//				giti.setNode(green);
//			}
//			else{
//				giti.setNode(blue);
//			}
//			giti.setByX(-35);
//			giti.setByY(-134);
//			giti.play();
//		}
//		else if(pos==75){
//			TranslateTransition giti = new TranslateTransition();
//			if(id==1){
//				giti.setNode(green);
//			}
//			else{
//				giti.setNode(blue);
//			}
//			giti.setByY(-91);
//			giti.play();
//		}
//		else if(pos==78){
//			TranslateTransition giti = new TranslateTransition();
//			if(id==1){
//				giti.setNode(green);
//			}
//			else{
//				giti.setNode(blue);
//			}
//			giti.setByX(36);
//			giti.setByY(-91);
//			giti.play();
//		}

	}

}

