package com.pruebas.service;

import com.pruebas.dto.ResponseStatus;
import com.pruebas.entity.Vuelo;

public interface VuelosService {
	
	/**
	 * Metodo para consultar un vuelo por itineraryId
	 * @param itineraryId el identificador 
	 * @return vuelo
	 */
	ResponseStatus getItiniraryId(Integer itineraryId);
	
	/**
	 * Metodo para guardar un vuelo
	 * @param Vuelo vuelo a guardar
	 * @return vuelo guardado
	 */
	ResponseStatus guardarVuelo(Vuelo vuelo);
	
}
