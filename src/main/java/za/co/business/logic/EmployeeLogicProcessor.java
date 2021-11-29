package za.co.business.logic;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.business.dtos.AuthenticationRequest;
import za.co.business.dtos.AuthenticationResponse;
import za.co.business.enums.ErrorCodes;
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



	public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
		AuthenticationResponse response = new AuthenticationResponse();
		Employee employee =null;
		String userId=null;
		String password=null;
		if(authenticationRequest!=null && StringUtils.isNotEmpty(authenticationRequest.getUserIdHash()) 
				&& StringUtils.isNotEmpty(authenticationRequest.getPasswordHash()) ) {
			
			userId=decrypt(authenticationRequest.getUserIdHash());
			password=decrypt(authenticationRequest.getPasswordHash());
			employee = employeeRepository.findByUserId(userId);
			
			if(employee==null) {
				response.setResponseCode(ErrorCodes.BUSINESS_FROM_DATABASE_FAILURE.getCode());
				response.setResponseMessage(ErrorCodes.BUSINESS_FROM_DATABASE_FAILURE.getMessage());
			} else  if(StringUtils.isNotEmpty(employee.getPassword()) && StringUtils.isNotEmpty(employee.getUserId())
				&& password.equals(employee.getPassword()) 
				&& userId.equals(employee.getUserId()) ){
				
					response.setResponseCode(ErrorCodes.SUCCESS.getCode());
					response.setResponseMessage(ErrorCodes.SUCCESS.getMessage());
					
			}else{
					response.setResponseCode(ErrorCodes.BUSINESS_FROM_DATABASE_FAILURE.getCode());
					response.setResponseMessage(ErrorCodes.BUSINESS_FROM_DATABASE_FAILURE.getMessage());
					
				
			}
			
		} else {
			response.setResponseCode(ErrorCodes.BUSINESS_FROM_DATABASE_FAILURE.getCode());
			response.setResponseMessage(ErrorCodes.BUSINESS_FROM_DATABASE_FAILURE.getMessage());		
		}
		
		return response;
		
	}



	private String decrypt(String value) {
		return value;
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
