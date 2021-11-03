package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ControllerProspects implements Initializable {

	@FXML
	private ListView<String> ProspectsListView;
	
	@FXML
	private Label ProspectsLabel;
	
	String[] Prospects = {"prospects1", "prospects2", "prospects3"};
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ProspectsListView.getItems().addAll(Prospects);
		
	}

}
