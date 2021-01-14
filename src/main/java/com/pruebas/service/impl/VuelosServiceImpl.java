package com.pruebas.service.impl;

import org.apache.log4j.Logger;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pruebas.dto.ResponseStatus;
import com.pruebas.entity.Vuelo;
import com.pruebas.repository.VuelosRepository;
import com.pruebas.service.VuelosService;

@Service
public class VuelosServiceImpl implements VuelosService {
	
	@Autowired
	private VuelosRepository vuelosRepository;
	
	protected static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	protected static Validator validator = factory.getValidator();

	private static final Logger log = Logger.getLogger(VuelosServiceImpl.class);

	@Override
	public ResponseStatus getItiniraryId(Integer itineraryId) {
		ResponseStatus rs = new ResponseStatus();
		try {
			Vuelo vuelo = vuelosRepository.findOne(itineraryId);
			if( vuelo != null) {
				rs.setMessage("OK");
				rs.setVuelo(vuelo);
				rs.setHttpStatus(HttpStatus.OK);
			} else {
				throw new ValidationException("No se encontró el vuelo");
			}
		} catch (NullPointerException ne) {
			log.error(ne.getMessage());
			rs.setMessage(ne.getMessage());
			rs.setHttpStatus(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			log.error(e.getMessage());
			rs.setMessage(e.getMessage());
			rs.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return rs;
	}

	@Override
	public ResponseStatus guardarVuelo(Vuelo vuelo) {
		ResponseStatus rs = new ResponseStatus();
		try {
			validaVuelo(vuelo);
			Vuelo vueloSaved = vuelosRepository.save(vuelo);
			rs.setVuelo(vueloSaved);
			rs.setHttpStatus(HttpStatus.OK);
			rs.setMessage("OK");
		} catch (ValidationException ve) {
			log.error(ve.getMessage());
			rs.setHttpStatus(HttpStatus.BAD_REQUEST);
			rs.setMessage(ve.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			rs.setMessage(e.getMessage());
			rs.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return rs;
	}
	
	private void validaVuelo(Vuelo vuelo) {
		Set<ConstraintViolation<Vuelo>> violations = validator.validate(vuelo);

		for (ConstraintViolation<Vuelo> vi : violations) {
			log.error("Error: El campo " + vi.getPropertyPath() + " " + vi.getMessage());
			throw new ValidationException("Error: El campo " + vi.getPropertyPath() + " " + vi.getMessage());
		}
	}

}
