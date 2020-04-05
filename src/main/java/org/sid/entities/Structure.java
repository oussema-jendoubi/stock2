package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "structures" )
public class Structure implements Serializable  {
          
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id @GeneratedValue
	private Long id;
	private String nom ;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Structure() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Structure(String nom) {
		super();
		this.nom = nom;
	}
	
	
	
	
	
	
	
}
