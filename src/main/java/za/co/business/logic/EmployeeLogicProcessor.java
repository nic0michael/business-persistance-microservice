package za.co.business.logic;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.business.model.Employee;
import za.co.business.repositories.EmployeeRepository;

@Component
public class EmployeeLogicProcessor {
	private static final Logger log = LoggerFactory.getLogger(EmployeeLogicProcessor.class);
	
	@Autowired
	EmployeeRepository employeeRepository;



	public List<Employee> findAll() {
		System.out.println("getting list of employees");
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		System.out.println("got list of employees : " + employees);
		return employees;
	}



	public Employee findByEmployeeId(String id) {
		Employee employee =null;
		if(StringUtils.isNotEmpty(id) && StringUtils.isNumeric(id) ) {
			Long employeeId=Long.parseLong(id);
			employee = employeeRepository.findByEmployeeId(employeeId);
		}
		return employee;
	}


	
/* for security reasons the following will not be allowed

	public void save(EmployeePersistRequest employeePersistRequest) {
		log.info("PROJECT_MAN : EmployeeModule : save : saving employee from  EmployeePersistRequest: "
				+ employeePersistRequest);
		Employee employee = new Employee();
		employee = Utils.convertToEmployee(employeePersistRequest, employee);
		employeeRepository.save(employee);
	}

	public void delete(Long project_id) {
		Employee employee = findById(project_id);
		employeeRepository.delete(employee);
	}

	public void update(EmployeePersistRequest employeePersistRequest) {
		log.info("PROJECT_MAN : EmployeeModule : update : updating employee from  EmployeePersistRequest: "
				+ employeePersistRequest);
		if (employeePersistRequest != null) {
			Long employeeId = Long.parseLong(employeePersistRequest.getEmployeeId());
			log.info("PROJECT_MAN : EmployeeModule : update : updating employee employeeId : " + employeeId);
			Employee employee = employeeRepository.getOne(employeeId);
			log.info("PROJECT_MAN : EmployeeModule : update : updating employee : " + employee);
			if (employee != null) {
				employee = Utils.convertToEmployee(employeePersistRequest, employee);
				employeeRepository.save(employee);
			}
		}

	}
	
	*/
}
