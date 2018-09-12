package com.almundo.back.business;

import com.almundo.back.entities.Call;
import com.almundo.back.entities.EmployeeType;

/**
 * @author Carlos
 * @version 1.0
 * @created 12-sep.-2018 00:58:31
 */
public interface IHandler {

	public IHandler getNext();

	/**
	 * 
	 * @param call
	 */
	public boolean handleCall(Call call, EmployeeType transferTo) throws InterruptedException;

	/**
	 * 
	 * @param employeeHandler
	 */
	public void setNext(IHandler employeeHandler);

}