package com.almundo.back.agent;

import com.almundo.back.business.DirectorHandler;
import com.almundo.back.business.NoEmployeeHandler;
import com.almundo.back.business.OperatorHandler;
import com.almundo.back.business.SupervisorHandler;
import com.almundo.back.entities.Call;
import com.almundo.back.entities.EmployeeType;

public class Agent implements Runnable {
	
	private Call call;
	
	public Agent(Call call) {
		this.call = call;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		NoEmployeeHandler endHandler = new NoEmployeeHandler();
		DirectorHandler dirhandler = new DirectorHandler(endHandler);
		SupervisorHandler supHandler = new SupervisorHandler(dirhandler);
		OperatorHandler opHandler = new OperatorHandler(supHandler);
		
		boolean findEmployee = true;
		for (EmployeeType type : EmployeeType.values()) {
			try {
				findEmployee = opHandler.handleCall(call, type);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (findEmployee) {
				break;
			}
		}
		
	}

}
