package com.pruebas.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.dto.ResponseStatus;
import com.pruebas.entity.Vuelo;
import com.pruebas.service.VuelosService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Z052886
 * Class con endpoints de servicios de push
 */
@RestController
@RequestMapping("vuelos/")
@EnableSwagger2
public class VuelosController {

	@Autowired
	private VuelosService vuelosService;

	@RequestMapping(value = "/vuelo/{itineraryId}", method = { RequestMethod.GET })
	public ResponseEntity<Vuelo> consultarVuelo(@PathVariable Integer itineraryId) {
		ResponseStatus res = vuelosService.getItiniraryId(itineraryId);
		
		HttpStatus hs = res.getHttpStatus();
		HttpHeaders header = new HttpHeaders();
		header.add("errorMessage", res.getMessage());

		Vuelo response = res.getVuelo();
		
		return new ResponseEntity<Vuelo>(response, header, hs);
	}
	
	@RequestMapping(value = "/vuelo", method = { RequestMethod.POST })
	public ResponseEntity<Vuelo> guardarVuelo(@RequestBody Vuelo vuelo) {
		
		ResponseStatus res = vuelosService.guardarVuelo(vuelo);

		HttpStatus hs = res.getHttpStatus();
		HttpHeaders header = new HttpHeaders();
		header.add("errorMessage", res.getMessage());

		Vuelo response = res.getVuelo();

		return new ResponseEntity<Vuelo>(response, header, hs);
	}
	
}
