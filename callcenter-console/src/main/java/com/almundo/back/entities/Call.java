package com.almundo.back.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Carlos
 * @version 1.0
 * @created 12-sep.-2018 00:58:31
 */
public class Call implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 318165935867569827L;
	/**
	 * Fecha en la que se realiza la llamada
	 */
	private Date date;
	/**
	 * Hora en la que fue atendida por un empleado
	 */
	private Date hourOfAttention;
	/**
	 * Identificacion en el sistema de la llamada entrante
	 */
	private long idCall;
	/**
	 * Estado en el que se encuentra la llamada
	 */
	private CallStatus status;
	/**
	 * Hora en la que finaliza la llamada
	 */
	private Date timeEnds;
	/**
	 * Hora de ingreso de la llamada al sistema
	 */
	private Date timeOfEntry;

	public Call(){

	}

	public void finalize() throws Throwable {

	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getHourOfAttention() {
		return hourOfAttention;
	}

	public void setHourOfAttention(Date hourOfAttention) {
		this.hourOfAttention = hourOfAttention;
	}

	public long getIdCall() {
		return idCall;
	}

	public void setIdCall(long idCall) {
		this.idCall = idCall;
	}

	public CallStatus getStatus() {
		return status;
	}

	public void setStatus(CallStatus status) {
		this.status = status;
	}

	public Date getTimeEnds() {
		return timeEnds;
	}

	public void setTimeEnds(Date timeEnds) {
		this.timeEnds = timeEnds;
	}

	public Date getTimeOfEntry() {
		return timeOfEntry;
	}

	public void setTimeOfEntry(Date timeOfEntry) {
		this.timeOfEntry = timeOfEntry;
	}

}