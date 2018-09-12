package com.almundo.back.business;

import java.text.MessageFormat;
import java.util.Date;

import com.almundo.back.agent.EmployeeAvailabilityController;
import com.almundo.back.entities.AvailabilityStatus;
import com.almundo.back.entities.Call;
import com.almundo.back.entities.Employee;
import com.almundo.back.entities.EmployeeType;

/**
 * @author Carlos
 * @version 1.0
 * @created 12-sep.-2018 00:58:31
 */
public class DirectorHandler implements IHandler {
	
	private IHandler next;
	
	
	public DirectorHandler(IHandler next) {
		setNext(next);
	}

	@Override
	public IHandler getNext() {
		return this.next;
	}

	@Override
	public boolean handleCall(Call call, EmployeeType transferTo) throws InterruptedException {
		boolean returnValue = false;
		
		if (EmployeeType.Director.equals(transferTo)) {
			//TODO: Codigo para atender la llamada por parte de un director.
			Employee emp = EmployeeAvailabilityController.getInstance().getAvailableDirector();
			if (emp != null) {
				call.setHourOfAttention(new Date());
				System.out.println(MessageFormat.format("Llamada {0} atendida por el Director {1}-{2} {3}, {4}", 
						call.getIdCall(), 
						emp.getIdEmployee(), 
						emp.getName(), 
						emp.getLastName(),
						call.getHourOfAttention().toGMTString()));
				int randomWaitTime = (int) (Math.floor(Math.random()*10+5));
				Thread.sleep(randomWaitTime * 1000);
				call.setTimeEnds(new Date());
				System.out.println(MessageFormat.format("Llamada {0} finaliza: {1}", call.getIdCall(), call.getTimeEnds().toGMTString()));
				returnValue = true;
				emp.setStatus(AvailabilityStatus.Available);
			} else {
				returnValue = getNext().handleCall(call, transferTo);
			}
		} else {
			returnValue = getNext().handleCall(call, transferTo);
		}
		
		return returnValue;
	}

	@Override
	public void setNext(IHandler employeeHandler) {
		this.next = employeeHandler;
	}

}