package com.taxes.taxesservice.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the province database table.
 * 
 */
@Entity
@Table(name="province")
@NamedQuery(name="Province.findAll", query="SELECT p FROM Province p")
public class Province implements Serializable {
	private static final long serialVersionUID = 1L;
	private String code;
	private String nom;
	private List<Taxe>  taxes = new  ArrayList<Taxe>();

	public Province() {
	}


	@Id
	@Column(unique=true, nullable=false, length=2)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	@Column(nullable=false, length=200)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	//bi-directional many-to-one association to Taxe
	
	@OneToMany(mappedBy="province" ,fetch=FetchType.LAZY )
    @JsonIgnore
	public List<Taxe> getTaxes() {
		return this.taxes;
	}

	public void setTaxes(List<Taxe> taxes) {
		this.taxes = taxes;
	}

	

}