package com.example.projet.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String desc;
    private int qte;
    private LocalDate date;
    private Long montant;
    

	 public Commande(Long id, String desc, int qte, LocalDate date, Long montant) {
		super();
		this.id = id;
		this.desc = desc;
		this.qte = qte;
		this.date = date;
		this.montant = montant;
		
	 }


	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public int getQte() {
		return qte;
	}


	public void setQte(int qte) {
		this.qte = qte;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public Long getMontant() {
		return montant;
	}


	public void setMontant(Long montant) {
		this.montant = montant;
	}

	
}