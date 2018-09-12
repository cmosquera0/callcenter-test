package com.almundo.back.business;

import com.almundo.back.entities.Call;
import com.almundo.back.entities.EmployeeType;

public class NoEmployeeHandler implements IHandler {

	@Override
	public IHandler getNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public synchronized boolean handleCall(Call call, EmployeeType transferTo) {
		System.out.println("No hay operadores disponibles, por favor intente mas tarde. Llamada: " + call.getIdCall());
		return true;
	}

	@Override
	public void setNext(IHandler employeeHandler) {
		// TODO Auto-generated method stub

	}

}
