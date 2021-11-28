package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ControllerProspects implements Initializable {
	
	
	/*@FXML
	private ListView<String> id_listview_prospects;
	
	@FXML
	private Label ProspectsLabel;
	
	String[] Prospects = {"prospects1", "prospects2", "prospects3", "prospects4"};
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		id_listview_prospects.getItems().addAll(Prospects);
		
	}*/
	

	
    @FXML
	ListView<String> id_listview_prospects;

	ObservableList<String> items = FXCollections.observableArrayList();
	
	@Override
	  public void initialize(URL location, ResourceBundle resources) {
		
		id_listview_prospects.setItems(items);

		
	    try {
	    	
	    	
	    	 //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/exia","root","password");  ;
	 		
		     Statement stmt = Connexion.getCon().createStatement();
		     ResultSet rs = stmt.executeQuery("SELECT nom FROM prospects");
	         while (rs.next()) {
	        	 items.add(rs.getString("nom"));
	             System.out.println(rs.getString("nom"));
	             
	         }
	     } catch (SQLException e) {

	     }
		
	}
	
	
}
