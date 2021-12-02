package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import org.w3c.dom.events.MouseEvent;

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
	Label id_label_date_naiss, id_label_option_bac, id_label_niv_etude, id_label_tel1, id_label_tel2, id_label_email, id_label_remarque;
    @FXML
	ListView<String> id_listview_prospects;
    @FXML
    Button id_btn_modif, id_btn_sauvegarde, id_btn_supp, id_btn_ajout_prospect;
   @FXML 
   TextField id_label_NP_prospects ,id_textfield_date_naiss, id_textfield_option_bac, id_textfield_niv_etude, id_textfield_tel1, id_textfield_tel2, id_textfield_email, id_textfield_remarque;

  void Textfield_modif() {
		
	// ** Editable Form ***
	   
   	id_textfield_date_naiss.setEditable(true);
   	id_textfield_option_bac.setEditable(true);
   	id_textfield_niv_etude.setEditable(true);
   	id_textfield_tel1.setEditable(true);
   	id_textfield_tel2.setEditable(true);
   	id_textfield_email.setEditable(true);
   	id_textfield_remarque.setEditable(true);
   	
   	id_textfield_date_naiss.setStyle("-fx-background-color:white; -fx-border-color:#6454F0; -fx-text-fill:#6454F0");
   	id_textfield_option_bac.setStyle("-fx-background-color:white; -fx-border-color:#6454F0; -fx-text-fill:#6454F0");
   	id_textfield_niv_etude.setStyle("-fx-background-color:white; -fx-border-color:#6454F0; -fx-text-fill:#6454F0");
   	id_textfield_tel1.setStyle("-fx-background-color:white; -fx-border-color:#6454F0; -fx-text-fill:#6454F0");
   	id_textfield_tel2.setStyle("-fx-background-color:white; -fx-border-color:#6454F0; -fx-text-fill:#6454F0");
   	id_textfield_email.setStyle("-fx-background-color:white; -fx-border-color:#6454F0; -fx-text-fill:#6454F0");
   	id_textfield_remarque.setStyle("-fx-background-color:white; -fx-border-color:#6454F0; -fx-text-fill:#6454F0");
   	
   	id_btn_sauvegarde.setVisible(true);
	   
	}
   void Textfield_affiche() {
		
		// ** Editable Form ***
	   	id_textfield_date_naiss.setEditable(false);
	   	id_textfield_option_bac.setEditable(false);
	   	id_textfield_niv_etude.setEditable(false);
	   	id_textfield_tel1.setEditable(false);
	   	id_textfield_tel2.setEditable(false);
	   	id_textfield_email.setEditable(false);
	   	id_textfield_remarque.setEditable(false);
	   	
	   	id_textfield_date_naiss.setStyle("-fx-background-color: transparent; -fx-border-color:transparent transparent #bfbfbf transparent; -fx-text-fill:#595959");
	   	id_textfield_option_bac.setStyle("-fx-background-color: transparent; -fx-border-color:transparent transparent #bfbfbf transparent; -fx-text-fill:#595959");
	   	id_textfield_niv_etude.setStyle("-fx-background-color:transparent; -fx-border-color:transparent transparent #bfbfbf transparent; -fx-text-fill:#595959");
	   	id_textfield_tel1.setStyle("-fx-background-color:transparent; -fx-border-color:transparent transparent #bfbfbf transparent; -fx-text-fill:#595959");
	   	id_textfield_tel2.setStyle("-fx-background-color:transparent; -fx-border-color:transparent transparent #bfbfbf transparent; -fx-text-fill:#595959");
	   	id_textfield_email.setStyle("-fx-background-color:transparent; -fx-border-color:transparent transparent #bfbfbf transparent; -fx-text-fill:#595959");
	   	id_textfield_remarque.setStyle("-fx-background-color:transparent; -fx-border-color:   #bfbfbf; -fx-text-fill:#595959");
	   	
	   	id_btn_sauvegarde.setVisible(false);
		   
		}
   void TextField_vider() {
	   id_label_NP_prospects.setText(null);
		id_textfield_date_naiss.setText(null);
	   	id_textfield_option_bac.setText(null);
	   	id_textfield_niv_etude.setText(null);
	   	id_textfield_tel1.setText(null);
	   	id_textfield_tel2.setText(null);
	   	id_textfield_email.setText(null);
	   	id_textfield_remarque.setText(null);
   }
   void update_prospect() throws SQLException {
	   
	   String sql =  "UPDATE prospects SET date_naiss = '" + id_textfield_date_naiss.getText() + "', option_bac = '"+id_textfield_option_bac.getText()+"', niv_etude = '"+id_textfield_niv_etude.getText()+"' WHERE CONCAT(nom,'   ',prenom) = '"+id_label_NP_prospects.getText()+"'";
	   PreparedStatement preparedStatement = Connexion.getCon().prepareStatement(sql);
	   preparedStatement.executeUpdate();	 
	   
	 }
   void delete_prospect() throws SQLException{
	   String sql = "DELETE from prospects WHERE CONCAT(nom,'   ',prenom) = '"+id_label_NP_prospects.getText()+"'";
	   PreparedStatement preparedStatement = Connexion.getCon().prepareStatement(sql);
	   preparedStatement.executeUpdate();	
	   afficher_list_prospect();
   }
   
   void afficher_list_prospect() throws SQLException {
	   
	 //*********** From Database to the List ************
	   ObservableList<String> items = FXCollections.observableArrayList();
		
		id_listview_prospects.setItems(items);
		
		 Statement stmt = Connexion.getCon().createStatement();
	     String sql1 = "SELECT nom, prenom FROM prospects";
	     ResultSet rs = stmt.executeQuery(sql1);
	     
	 
         while (rs.next()) {
        	 items.add(rs.getString("nom")+ "   " + rs.getString("prenom"));
             System.out.println(rs.getString("nom")+ "   " +rs.getString("prenom"));
         }
         String sql2 = "SELECT * FROM prospects WHERE id_prospect = (SELECT Max(id_prospect) FROM prospects)";  
         ResultSet rs1 = stmt.executeQuery(sql2);
         
		 while (rs1.next()) {
			 id_label_NP_prospects.setText(rs1.getString("nom")+ "   " +rs1.getString("prenom"));
			 id_textfield_date_naiss.setText(rs1.getString("date_naiss"));
			 id_textfield_option_bac.setText(rs1.getString("option_bac"));
			 id_textfield_niv_etude.setText(rs1.getString("niv_etude"));
			 id_textfield_tel1.setText(rs1.getString("tel1"));
			 id_textfield_tel2.setText(rs1.getString("tel2"));
			 id_textfield_email.setText(rs1.getString("email"));
			 id_textfield_remarque.setText(rs1.getString("remarque"));
         }
		 
   }
   
   void ajouter_prospect() throws SQLException{
	   String n = "SELECT VALUE FROM STRING_SPLIT('"+id_label_NP_prospects.getText()+"', '   ', 1) WHERE ordinal = 1";
	   String p = "SELECT VALUE FROM STRING_SPLIT('"+id_label_NP_prospects.getText()+"', '   ', 1) WHERE ordinal = 2";
	   String sql =  "INSERT INTO prospects VALUES nom = '"+ n+"', prenom = '"+p+"', date_naiss = '" + id_textfield_date_naiss.getText() + "', option_bac = '"+id_textfield_option_bac.getText()+"', niv_etude = '"+id_textfield_niv_etude.getText()+"'";
	   PreparedStatement preparedStatement = Connexion.getCon().prepareStatement(sql);
	   preparedStatement.executeUpdate();	
   }
	@Override
	  public void initialize(URL location, ResourceBundle resources) {
		
		try {
			afficher_list_prospect();
			
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		 //**************** Update prospect ****************
		  //event invoked when button modify is pressed
		 
			EventHandler<ActionEvent> event_modif = new EventHandler<ActionEvent>() {
		            public void handle(ActionEvent e)
		            {
		            	Textfield_modif();
		            	
		            }
		        };
		        id_btn_modif.setOnAction(event_modif);
		        
		  //event invoked when button save is pressed
		    EventHandler<ActionEvent> event_save = new EventHandler<ActionEvent>() {
		            public void handle(ActionEvent e)
		            {
		            	try {
							update_prospect();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		            	Textfield_affiche();
		            }
		        };
		 id_btn_sauvegarde.setOnAction(event_save);    
		      
		    //event invoked when button delete is pressed    
		        
		       EventHandler<ActionEvent> event_delete = new EventHandler<ActionEvent>() {
		            public void handle(ActionEvent e)
		            {
		            	try {
							delete_prospect();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		            	Textfield_affiche();
		            	
		            }
		        };  
		        id_btn_supp.setOnAction(event_delete);
		        
		        EventHandler<ActionEvent> event_create = new EventHandler<ActionEvent>() {
		            public void handle(ActionEvent e)
		            {
		            	Textfield_modif();
		            	TextField_vider();
		            	try {
							ajouter_prospect();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
		            	
		            }
		        };  
		        id_btn_ajout_prospect.setOnAction(event_create);
	
	    id_listview_prospects.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
				 String selectedItem = id_listview_prospects.getSelectionModel().getSelectedItem();
				
				 Textfield_affiche();
				 
				 try {
					 
				 Statement stmt = Connexion.getCon().createStatement();
				 String sql3 = "SELECT * FROM prospects WHERE CONCAT(nom,'   ',prenom) = '"+selectedItem+"'";
				  
				
					
				ResultSet rs2 = stmt.executeQuery(sql3);
				 while (rs2.next()) {
					 String n = rs2.getString("nom");
					 String p =rs2.getString("prenom");
					
					 
					 id_label_NP_prospects.setText(n+ "   " +p);
					 id_textfield_date_naiss.setText(rs2.getString("date_naiss"));
					 id_textfield_option_bac.setText(rs2.getString("option_bac"));
					 id_textfield_niv_etude.setText(rs2.getString("niv_etude"));
					 id_textfield_tel1.setText(rs2.getString("tel1"));
					 id_textfield_tel2.setText(rs2.getString("tel2"));
					 id_textfield_email.setText(rs2.getString("email"));
					 id_textfield_remarque.setText(rs2.getString("remarque"));
					 
					 
					 
					 }
					 
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 } 
			 );
	   
	 }
	
}
