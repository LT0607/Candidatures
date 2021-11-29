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


public class ControllerProspects implements Initializable {
	
	
    @FXML
	ListView<String> id_listview_prospects;

	ObservableList<String> items = FXCollections.observableArrayList();
	
	@Override
	  public void initialize(URL location, ResourceBundle resources) {
		
		id_listview_prospects.setItems(items);

		
	    try {
	    	
		     Statement stmt = Connexion.getCon().createStatement();
		     ResultSet rs = stmt.executeQuery("SELECT nom, prenom FROM prospects");
	         while (rs.next()) {
	        	 items.add(rs.getString("nom")+ "   " + rs.getString("prenom"));
	             System.out.println(rs.getString("nom")+ "   " +rs.getString("prenom"));
	         }
	         String r = id_listview_prospects.getItems().get(0);
	         System.out.println("le premier element est : "+ r);
	       //  String selected_item = id_listview_prospects.getSelectionModel().getSelectedItem();
	     } catch (SQLException e) {

	     }
	 }
	
}
