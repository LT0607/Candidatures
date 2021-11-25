package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ControllerScene {

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	public void SwitchToProspects(ActionEvent event ) throws IOException {
		
	root = FXMLLoader.load(getClass().getResource("/Prospects3.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}

	public void SwitchToCandidats(ActionEvent event ) throws IOException {
		
		root = FXMLLoader.load(getClass().getResource("/Prospects.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		}
	
	public void SwitchToTests(ActionEvent event ) throws IOException {
		
		root = FXMLLoader.load(getClass().getResource("/Prospects.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		}
	
}
