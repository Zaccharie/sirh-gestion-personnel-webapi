package dev.sirhgestionpersonnelwepapi.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="COLLABORATEUR")
public class Collaborateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="MATRICULE")
	private String matricule;
	@Column(name="NOM")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="INTITULE_POSTE")
	private String intitulePoste;
	@Column(name="BANQUE")
	private String banque;
	@Column(name="BIC")
	private String bic;
	@Column(name="IBAN")
	private String iban;
	@Column(name="DATE_NAISSANCE")
	private LocalDate dateNaissance;
	@Column(name="ADRESSE")
	private String adresse;
	@Column(name="NUMERO_SECU")
	private String numeroSecu;
	@Column(name="EMAIL_PRO")
	private String emailPro;
	@Column(name="PHOTO")
	private String photo;
	@Column(name="DATE_HEURE_CREATION")
	private ZonedDateTime dateHeureCreation;
	@Column(name="ACTIF")
	private Boolean actif;
	
	@ManyToOne
	private Departement departement;
	
	//constructor
	public Collaborateur() {
		
	}
	
	public Collaborateur(String matricule, String nom, String prenom, String intitulePoste, LocalDate dateNaissance, String adresse,
			String numeroSecu, String emailPro, String photo, ZonedDateTime dateHeureCreation, String banque,
			String iban, String bic, Boolean actif, Departement dep) {
		
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.numeroSecu = numeroSecu;
		this.emailPro = emailPro;
		this.photo = photo;
		this.dateHeureCreation = dateHeureCreation;
		this.intitulePoste = intitulePoste;
		this.actif = actif;
		this.banque = banque;
		this.bic = bic;
		this.iban = iban;
		this.departement = dep;
	}
	
	//getters and setters
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getIntitulePoste() {
		return intitulePoste;
	}
	public void setIntitulePoste(String intitulePoste) {
		this.intitulePoste = intitulePoste;
	}
	public String getBanque() {
		return banque;
	}
	public void setBanque(String banque) {
		this.banque = banque;
	}
	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNumeroSecu() {
		return numeroSecu;
	}
	public void setNumeroSecu(String numeroSecu) {
		this.numeroSecu = numeroSecu;
	}
	public String getEmailPro() {
		return emailPro;
	}
	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	public ZonedDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}
	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public void setDateHeureCreation(ZonedDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}
	public Boolean getActif() {
		return actif;
	}
	public void setActif(Boolean actif) {
		this.actif = actif;
	}
		
}

