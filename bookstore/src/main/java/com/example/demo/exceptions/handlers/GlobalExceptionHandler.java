package com.example.demo.exceptions.handlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.data.dto.ErrorResponse;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.UnauthorizedException;
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler({ResourceNotFoundException.class})
	protected ResponseEntity<ErrorResponse> handleResourceNotFoundException(RuntimeException exception,
			WebRequest request) {
		ErrorResponse error = new ErrorResponse("404", exception.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler({UnauthorizedException.class})
	protected ResponseEntity<ErrorResponse> handleUnauthorizedException(RuntimeException exception, WebRequest request){
		ErrorResponse error = new ErrorResponse("401", exception.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.UNAUTHORIZED);
	}
	@ExceptionHandler({IllegalArgumentException.class })
	protected ResponseEntity<ErrorResponse> handleIllegalArgumentException(RuntimeException exception,
			WebRequest request) {
		ErrorResponse error = new ErrorResponse("400", exception.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();

			System.out.println(fieldName+" "+ errorMessage);
			errors.put(fieldName, errorMessage);
		});
		ErrorResponse error = new ErrorResponse("400", "Validation Error", errors);
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}

}
