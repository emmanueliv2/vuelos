package com.pruebas.dto;

import org.springframework.http.HttpStatus;

import com.pruebas.entity.Vuelo;

import lombok.Data;

@Data
public class ResponseStatus{
	
	private Vuelo vuelo;
	private String message;
	private HttpStatus httpStatus;
	

}
