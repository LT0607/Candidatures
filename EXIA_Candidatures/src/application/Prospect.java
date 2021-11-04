package application;

import java.util.Date;

public class Prospect {

	private int  idProspect, tel1, tel2;
	private String nom, prenom, bac, niv_etude, email, remarque;
	private Date dateNaissance;
	
	public Prospect (String n, String p, String b, Date d, int tel, String e) {
		
		this.nom = n;
		this.prenom = p;
		this.bac = b;
		this.dateNaissance = d;
		this.tel1 = tel;
		this.email = e;
		
	}
	
	public void RechercherProspect() {
		
	}
	
	public void ModifierProspect() {
		
	}
	
	public void SupprimerProspect() {
		
	}
}

