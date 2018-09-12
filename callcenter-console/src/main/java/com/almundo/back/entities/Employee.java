package com.almundo.back.entities;

import java.io.Serializable;

/**
 * @author Carlos
 * @version 1.0
 * @created 12-sep.-2018 00:58:31
 */
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7535018064543557249L;
	/**
	 * Cedula del empleado
	 */
	private String idEmployee;
	/**
	 * Apellido del empleado
	 */
	private String lastName;
	/**
	 * Nombre del empleado
	 */
	private String name;
	/**
	 * Tipo de empleado "operador", "supervisor" o "director"
	 */
	private EmployeeType type;
	
	private AvailabilityStatus status;

	public Employee(){

	}

	public void finalize() throws Throwable {

	}

	public String getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(String idEmploee) {
		this.idEmployee = idEmploee;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmployeeType getType() {
		return type;
	}

	public void setType(EmployeeType type) {
		this.type = type;
	}

	public AvailabilityStatus getStatus() {
		return status;
	}

	public void setStatus(AvailabilityStatus status) {
		this.status = status;
	}

}