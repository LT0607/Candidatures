#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Prospects
#------------------------------------------------------------

CREATE TABLE Prospects(
        id_prospect Int  Auto_increment  NOT NULL ,
        nom         Varchar (50) NOT NULL ,
        prenom      Varchar (50) NOT NULL ,
        date_naiss  Date ,
        bac         Varchar (20) NOT NULL ,
        tel1        Varchar (20) NOT NULL ,
        tel2        Varchar (20) ,
        email       Varchar (40) ,
        niv_etude   Varchar (50) ,
        remarque    Text
	,CONSTRAINT Prospects_PK PRIMARY KEY (id_prospect)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Candidats
#------------------------------------------------------------

CREATE TABLE Candidats(
        id_prospect     Int NOT NULL ,
        id_candidat     Int NOT NULL ,
        nom             Varchar (50) NOT NULL ,
        prenom          Varchar (50) NOT NULL ,
        date_naiss      Date ,
        bac             Varchar (20) NOT NULL ,
        tel1            Varchar (20) NOT NULL ,
        tel2            Varchar (20) ,
        email           Varchar (40) ,
        niv_etude       Varchar (50) ,
        remarque        Text ,
        id_dossier_test Int NOT NULL
	,CONSTRAINT Candidats_PK PRIMARY KEY (id_prospect,id_candidat)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Tests
#------------------------------------------------------------

CREATE TABLE Tests(
        id_test     Int  Auto_increment  NOT NULL ,
        date_test   Datetime NOT NULL ,
        id_prospect Int NOT NULL ,
        id_candidat Int NOT NULL
	,CONSTRAINT Tests_PK PRIMARY KEY (id_test)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Dossier_test
#------------------------------------------------------------

CREATE TABLE Dossier_test(
        id_dossier_test   Int  Auto_increment  NOT NULL ,
        cv                Blob NOT NULL ,
        lettre_motivation Blob ,
        diplome_bac       Blob ,
        recu_paiement     Blob NOT NULL ,
        id_prospect       Int NOT NULL ,
        id_candidat       Int NOT NULL
	,CONSTRAINT Dossier_test_PK PRIMARY KEY (id_dossier_test)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Etudiants
#------------------------------------------------------------

CREATE TABLE Etudiants(
        id_prospect        Int NOT NULL ,
        id_candidat        Int NOT NULL ,
        matricule_etudiant Int NOT NULL ,
        nom                Varchar (50) NOT NULL ,
        prenom             Varchar (50) NOT NULL ,
        date_naiss         Date ,
        bac                Varchar (20) NOT NULL ,
        tel1               Varchar (20) NOT NULL ,
        tel2               Varchar (20) ,
        email              Varchar (40) ,
        niv_etude          Varchar (50) ,
        remarque           Text ,
        id_dossier_test    Int NOT NULL
	,CONSTRAINT Etudiants_PK PRIMARY KEY (id_prospect,id_candidat,matricule_etudiant)
)ENGINE=InnoDB;




ALTER TABLE Candidats
	ADD CONSTRAINT Candidats_Prospects0_FK
	FOREIGN KEY (id_prospect)
	REFERENCES Prospects(id_prospect);

ALTER TABLE Candidats
	ADD CONSTRAINT Candidats_Dossier_test1_FK
	FOREIGN KEY (id_dossier_test)
	REFERENCES Dossier_test(id_dossier_test);

ALTER TABLE Candidats 
	ADD CONSTRAINT Candidats_Dossier_test0_AK 
	UNIQUE (id_dossier_test);

ALTER TABLE Tests
	ADD CONSTRAINT Tests_Candidats0_FK
	FOREIGN KEY (id_prospect,id_candidat)
	REFERENCES Candidats(id_prospect,id_candidat);

ALTER TABLE Dossier_test
	ADD CONSTRAINT Dossier_test_Candidats0_FK
	FOREIGN KEY (id_prospect,id_candidat)
	REFERENCES Candidats(id_prospect,id_candidat);

ALTER TABLE Dossier_test 
	ADD CONSTRAINT Dossier_test_Candidats0_AK 
	UNIQUE (id_prospect,id_candidat);

ALTER TABLE Etudiants
	ADD CONSTRAINT Etudiants_Candidats0_FK
	FOREIGN KEY (id_prospect,id_candidat)
	REFERENCES Candidats(id_prospect,id_candidat);

ALTER TABLE Etudiants
	ADD CONSTRAINT Etudiants_Dossier_test1_FK
	FOREIGN KEY (id_dossier_test)
	REFERENCES Dossier_test(id_dossier_test);

ALTER TABLE Etudiants 
	ADD CONSTRAINT Etudiants_Dossier_test0_AK 
	UNIQUE (id_dossier_test);
