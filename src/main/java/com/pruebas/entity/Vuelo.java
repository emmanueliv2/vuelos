package com.pruebas.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import lombok.Data;

@Data
@Entity
@Table(name="vuelo")
public class Vuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ITINERARY")
	@SequenceGenerator(sequenceName = "VUELO_SEQ_ITINERARY", allocationSize = 1, name = "SEQ_ITINERARY")
	@Column(name="itineraryId")
	private Integer itineraryId;
	@Past
	@NotNull(message = "no puede ser nulo")
	@Column(name = "fecha_salida")
	@Temporal(TemporalType.DATE)
	private Date fechaSalida;
	@Past
	@NotNull(message = "no puede ser nulo")
	@Column(name = "fecha_llegada")
	@Temporal(TemporalType.DATE)
	private Date fechaLlegada;
	@NotNull(message = "no puede ser nulo")
	@Column(name="ciudad_origen")
	private String ciudadOrigen;
	@NotNull(message = "no puede ser nulo")
	@Column(name="ciudad_destino")
	private String ciudadDestino;
	@NotNull(message = "no puede ser nulo")
	@Column(name="nombre_pasajero")
	private String nombrePasajero;
	@NotNull(message = "no puede ser nulo")
	@Column(name="edad_pasajero")
	private Integer edad_pasajero;
	@NotNull(message = "no puede ser nulo")
	@Column(name="bodega")
	private Integer bodega;
	@NotNull(message = "no puede ser nulo")
	@Column(name="precio")
	private Double precio;
	@NotNull(message = "no puede ser nulo")
	@Column(name = "hora_salida")
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaSalida;
	@NotNull(message = "no puede ser nulo")
	@Column(name = "hora_llegada")
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaLlegada;
	
}
