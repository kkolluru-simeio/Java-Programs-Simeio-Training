package com.bookapp.exceptions;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bookapp.model.ApiErrors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		String message = ex.getMessage();
		List<Object> error = Arrays.asList("This method is not supported", ex.getSupportedHttpMethods());
		
		headers.add("info", "Invalid method");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), message, status, status.value(), error);
		return ResponseEntity.status(status).headers(headers).body(errors);
		
	}
	

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<Object> error = Arrays.asList("This media type is not supported", ex.getSupportedMediaTypes());
		
		headers.add("info", "Invalid media type");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), message, status, status.value(), error);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<Object> error = Arrays.asList("Path variable is missing", ex.getVariableName());
		
		headers.add("info", "missing path variable");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), message, status, status.value(), error);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<Object> error = Arrays.asList("Missing servlet request parameter", ex.getParameterName());
		
		headers.add("info", "missing  a parameter in servlet request");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), message, status, status.value(), error);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<Object> error = Arrays.asList("type mismatch", ex.getRequiredType());
		
		headers.add("info", "mismatch of type variable");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), message, status, status.value(), error);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<Object> handleBookNotFound(BookNotFoundException ex) {
		String message = ex.getMessage();
		List<Object> error = Arrays.asList("book not found", ex.getMessage());
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("info", "book not found");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), message, HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), error);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(httpHeaders).body(errors);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception ex) {
		String message = ex.getMessage();
		List<Object> error = Arrays.asList("other exception", ex.getMessage());
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("info", "other");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), message, HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), error);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(httpHeaders).body(errors);
	}
	

}
