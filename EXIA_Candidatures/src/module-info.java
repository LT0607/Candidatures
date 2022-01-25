module EXIA_Candidatures {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
    requires java.sql;
	requires java.desktop;
	requires java.xml;
	
	opens application to javafx.graphics, javafx.fxml;
	
	exports application; 
	
}
