package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 


public class Connexion {
		 
	    static String user = "root";
	    static String url = "jdbc:mysql://localhost/exia";
	    static String pass = "password";
	    static String driver = "com.mysql.jdbc.Driver";
	 
	    public static Connection getCon() {
	        Connection con = null;
	 
	        try {
	            Class.forName(driver);
	            con = DriverManager.getConnection(url, user, pass);
	            System.out.println("Ok");
	        } catch (Exception ex) {
	        	System.err.println("Erreur");
	            System.err.println(ex);
	        }
	        return con;
	 
	    }
	 
	
}
