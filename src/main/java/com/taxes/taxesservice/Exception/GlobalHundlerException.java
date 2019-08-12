package com.taxes.taxesservice.Exception;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.fasterxml.jackson.databind.ObjectMapper;


@ControllerAdvice
public class GlobalHundlerException {

	
	@Autowired
	ObjectMapper mp ;
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<Erreur> noDataFoundHundlerException(DataNotFoundException e) {
		return new ResponseEntity<Erreur>(new Erreur(e.getMessage()), HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(MapperException.class)
	public ResponseEntity<String> mapperHundlerException(MapperException e) {
	
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(PersistentDataException.class)
	public ResponseEntity<Erreur> persistentDataHundlerException(PersistentDataException e) {
	
		return new ResponseEntity<Erreur>(new Erreur(e.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
	
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
		
}
