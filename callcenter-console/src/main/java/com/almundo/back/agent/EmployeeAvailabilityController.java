package com.almundo.back.agent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.almundo.back.entities.AvailabilityStatus;
import com.almundo.back.entities.Employee;
import com.almundo.back.entities.EmployeeType;

public class EmployeeAvailabilityController {
	
	private static EmployeeAvailabilityController instance;
	
	public static synchronized EmployeeAvailabilityController getInstance() {
		if (instance == null) {
			instance = new EmployeeAvailabilityController();
		}
		return instance;
	}
	
	private static Map<String, Employee> operators = new HashMap<String, Employee>();
	private static Map<String, Employee> supervisors = new HashMap<String, Employee>();
	private static Map<String, Employee> directors = new HashMap<String, Employee>();
	
	public EmployeeAvailabilityController() {
		Employee emp1 = new Employee();
		emp1.setIdEmployee("123");
		emp1.setName("Andres");
		emp1.setLastName("Moncada");
		emp1.setStatus(AvailabilityStatus.Available);
		emp1.setType(EmployeeType.Operator);
		
		Employee emp2 = new Employee();
		emp2.setIdEmployee("123");
		emp2.setName("Supervisor");
		emp2.setLastName("1");
		emp2.setStatus(AvailabilityStatus.Available);
		emp2.setType(EmployeeType.Supervisor);
		
		Employee emp3 = new Employee();
		emp3.setIdEmployee("123");
		emp3.setName("Director");
		emp3.setLastName("1");
		emp3.setStatus(AvailabilityStatus.Available);
		emp3.setType(EmployeeType.Director);
		
		operators.put(emp1.getIdEmployee(), emp1);
		supervisors.put(emp2.getIdEmployee(), emp2);
		directors.put(emp3.getIdEmployee(), emp3);
		
	}
	
	public synchronized Employee getAvailableOperator() {
		for (Entry<String, Employee> emp : operators.entrySet()) {
			if (AvailabilityStatus.Available.equals(emp.getValue().getStatus())) {
				emp.getValue().setStatus(AvailabilityStatus.Not_available);
				return emp.getValue();
			}
		}
		return null;
	}
	
	public synchronized Employee getAvailableSupervisor() {
		for (Entry<String, Employee> emp : supervisors.entrySet()) {
			if (AvailabilityStatus.Available.equals(emp.getValue().getStatus())) {
				emp.getValue().setStatus(AvailabilityStatus.Not_available);
				return emp.getValue();
			}
		}
		return null;
	}
	
	public synchronized Employee getAvailableDirector() {
		for (Entry<String, Employee> emp : directors.entrySet()) {
			if (AvailabilityStatus.Available.equals(emp.getValue().getStatus())) {
				emp.getValue().setStatus(AvailabilityStatus.Not_available);
				return emp.getValue();
			}
		}
		return null;
	}
	
	public void addOperator(Employee emp) {
		if (emp != null && EmployeeType.Operator.equals(emp.getType())) {
			if (!operators.containsKey(emp.getIdEmployee())) {
				operators.put(emp.getIdEmployee(), emp);
			} else {
				//TODO: log indicando que el operador ya existe
			}
		} else {
			//TODO: log indicando que el empleado indicado no es un operador
		}
	}
	//EmployeeAvailabilityController
	
	
	public void addSupervisor(Employee emp) {
		if (emp != null && EmployeeType.Supervisor.equals(emp.getType())) {
			if (!supervisors.containsKey(emp.getIdEmployee())) {
				supervisors.put(emp.getIdEmployee(), emp);
			} else {
				//TODO: log indicando que el Supervisor ya existe
			}
		} else {
			//TODO: log indicando que el empleado indicado no es un Supervisor
		}
	}
	
	public void addDirector(Employee emp) {
		if (emp != null && EmployeeType.Director.equals(emp.getType())) {
			if (!directors.containsKey(emp.getIdEmployee())) {
				directors.put(emp.getIdEmployee(), emp);
			} else {
				//TODO: log indicando que el Director ya existe
			}
		} else {
			//TODO: log indicando que el empleado indicado no es un Director
		}
	}
	

}
