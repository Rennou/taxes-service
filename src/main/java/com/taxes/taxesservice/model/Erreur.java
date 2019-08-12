package com.taxes.taxesservice.model;

public class Erreur{
	String message;

	public Erreur(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
