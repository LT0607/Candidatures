package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class ControllerProspects implements Initializable {
	
	@FXML
	Label id_label_NP_prospects, id_label_date_naiss, id_label_option_bac, id_label_niv_etude, id_label_tel1, id_label_tel2, id_label_email, id_label_remarque;
    @FXML
	ListView<String> id_listview_prospects;
    @FXML
    Button id_btn_modif;
 

	
	
	@Override
	  public void initialize(URL location, ResourceBundle resources) {
		
		ObservableList<String> items = FXCollections.observableArrayList();
		
		TextField tf = new TextField();
		id_listview_prospects.setItems(items);
		
		
	    try {
	    	
	    	//*********** From Database to the List ************
	    	
		     Statement stmt = Connexion.getCon().createStatement();
		     String sql1 = "SELECT nom, prenom FROM prospects";
		     ResultSet rs = stmt.executeQuery(sql1);
		 
	         while (rs.next()) {
	        	 items.add(rs.getString("nom")+ "   " + rs.getString("prenom"));
	             System.out.println(rs.getString("nom")+ "   " +rs.getString("prenom"));
	         }
	         
	         //************* DEFAULT : Form takes data of last prospect in DB ***********
	         
	         String sql2 = "SELECT * FROM prospects WHERE id_prospect = (SELECT Max(id_prospect) FROM prospects)";  
	         ResultSet rs1 = stmt.executeQuery(sql2);
	         
			 while (rs1.next()) {
				 id_label_NP_prospects.setText(rs1.getString("nom")+ "   " +rs1.getString("prenom"));
			     id_label_date_naiss.setText(rs1.getString("date_naiss"));
			     id_label_option_bac.setText(rs1.getString("option_bac"));
		         id_label_niv_etude.setText(rs1.getString("niv_etude"));
		         id_label_tel1.setText(rs1.getString("tel1"));
		         id_label_tel2.setText(rs1.getString("tel2"));
		         id_label_email.setText(rs1.getString("email"));
		         id_label_remarque.setText(rs1.getString("remarque"));
	         }
			 
			  //************* SELECT Item : display data of the chosen prospect ************
			 
			  id_listview_prospects.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
					 String selectedItem = id_listview_prospects.getSelectionModel().getSelectedItem();
					
					 String sql3 = "SELECT * FROM prospects WHERE CONCAT(nom,'   ',prenom) = '"+selectedItem+"'";
					  
					try {
						
					ResultSet rs2 = stmt.executeQuery(sql3);
					 while (rs2.next()) {
						 String n = rs2.getString("nom");
						 String p =rs2.getString("prenom");
						
						 
						 id_label_NP_prospects.setText(n+ "   " +p);
						 id_label_date_naiss.setText(rs2.getString("date_naiss"));
					     id_label_option_bac.setText(rs2.getString("option_bac"));
				         id_label_niv_etude.setText(rs2.getString("niv_etude"));
				         id_label_tel1.setText(rs2.getString("tel1"));
				         id_label_tel2.setText(rs2.getString("tel2"));
				         id_label_email.setText(rs2.getString("email"));
				         id_label_remarque.setText(rs2.getString("remarque"));
						 }
					 
					} catch (SQLException e) {
						e.printStackTrace();
					}
				 } 
				 );
			  
			  //**************** Update prospect ****************
			  
			/*  
			 * EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
		            public void handle(ActionEvent e)
		            {
		            	id_label_date_naiss.setGraphic(tf);
		            }
		        };
		  
		        // when button is pressed
		        id_btn_modif.setOnAction(event);
			 */
			 
			
	    }
	    catch (SQLException e) {
	    	
	    	 System.out.println(e.getMessage());
	     }
	  
	  
	    
	  
	 }
	
	
	
}
