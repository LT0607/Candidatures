package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Prospect {

	private int  idProspect, tel1, tel2;
	private String nom, prenom, bac, niv_etude, email, remarque;
	private Date dateNaissance;
	
public Prospect (String n, String p, String b, Date d, String niv_e, int t1, int t2, String e, String r) {
		
	    setNom(n);
	    setPrenom(p);
	    setDateNaissance(d);
	    setBac(b);
	    setNivEtude(niv_e);
	    setTel1(t1);
	    setTel2(t2);
	    setEmail(e);
	    setRemarque(r);
	}
	
	public Prospect (String n, String p, Date d, int t1) {
		
		setNom(n);
	    setPrenom(p);
	    setDateNaissance(d);
	    setTel1(t1);
	}
	
	/*******************getters*****************/
	
	public int getIdProspect () {
		return idProspect;
	}
	
	public int getTel1 () {
		return tel1;
	}

	public int getTel2 () {
		return tel2;
	}
	
	public String getNom () {
		return nom;
	}
	
	public String getPrenom () {
		return prenom;
	}
	
    public String getBac () {
		return bac;
	}
    
    public String getNivEtude () {
		return niv_etude;
	}
    
    public Date getDateNaissance() {
		return dateNaissance;
	}
    
    public String getEmail () {
		return email;
	}
    
    public String getRemarque() {
		return remarque;
	}
    
    /******************Setters*******************/
    
    public void setIdProspect(int idProspect) {
		this.idProspect = idProspect;
	}
    
    
    public void setTel2(int tel2) {
		this.tel2 = tel2;
	}
    
    public void setTel1(int tel1) {
		this.tel1 = tel1;
	}
    
    public void setNom(String nom) {
		this.nom = nom;
	}
    
    public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
    
    public void setBac(String bac) {
		this.bac = bac;
	}
    
    public void setNivEtude(String niv_etude) {
		this.niv_etude = niv_etude;
	}
    
    public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
    
    public void setEmail(String email) {
		this.email = email;
	}
    
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
   
	/******************Methods****************/
    

	public void RechercherProspect(String nom, String prenom) {
		
	}
	
	public void ModifierProspect(String nom, String prenom) {
		
	}
	
	public void SupprimerProspect(String nom, String prenom) {
		
	}

	

	
}

