package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class Controller implements Initializable {
	@FXML
	Button button;
	@FXML
	Text txt;
	
	
	@FXML
	void Display(MouseEvent e) {
		txt.setText("X->"+ e.getX() + " y-> "+e.getY());
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
}
