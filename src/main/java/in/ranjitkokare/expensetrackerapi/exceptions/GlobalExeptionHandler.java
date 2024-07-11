package in.ranjitkokare.expensetrackerapi.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import in.ranjitkokare.expensetrackerapi.entity.ErrorObject;

@ControllerAdvice
public class GlobalExeptionHandler { //as soon as we run app spring will create obj. of this class
	
	//method to catch the exception for expense not found
	@ExceptionHandler(ResourceNotFoundException.class) //multilevel annotation, pass exception name
	public ResponseEntity<ErrorObject> handleExpenseNotFoundException(ResourceNotFoundException ex,WebRequest request) {
		ErrorObject errorObject = new ErrorObject();
		
		errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		errorObject.setMessage(ex.getMessage());
		
		errorObject.setTimestamp(new Date());
		
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
	}
	
	//Bad request exception
	@ExceptionHandler(MethodArgumentTypeMismatchException.class) //multilevel annotation, pass exception name
	public ResponseEntity<ErrorObject> handleMethodArgumentMismatchException(MethodArgumentTypeMismatchException ex,WebRequest request) {
		ErrorObject errorObject = new ErrorObject();
		
		errorObject.setStatusCode(HttpStatus.BAD_REQUEST.value());
		
		errorObject.setMessage(ex.getMessage());
		
		errorObject.setTimestamp(new Date());
		
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.BAD_REQUEST);
	}
	
	//Generalized exception
		@ExceptionHandler(Exception.class) //multilevel annotation, pass exception name
		public ResponseEntity<ErrorObject> handleGeneralException(Exception ex,WebRequest request) {
			ErrorObject errorObject = new ErrorObject();
			
			errorObject.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			
			errorObject.setMessage(ex.getMessage());
			
			errorObject.setTimestamp(new Date());
			
			return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
