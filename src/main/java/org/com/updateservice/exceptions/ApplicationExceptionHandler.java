package org.com.updateservice.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(VersionNotFoundException.class)
	public ResponseEntity<Object> handleException(VersionNotFoundException exception) {
		
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception exception) {
		
		return ResponseEntity.internalServerError().build();
	}
}
