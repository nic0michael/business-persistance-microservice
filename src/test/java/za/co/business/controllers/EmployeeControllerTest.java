package za.co.business.controllers;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.CollectionUtils;

import za.co.business.BusinessPersistenceApplication;
import za.co.business.model.Employee;

//@ActiveProfiles({ "test" })
@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = { BusinessPersistenceApplication.class })
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeControllerTest {

	@Autowired
	EmployeeController controller;
	
	@Test
	@Order(1)
	@DisplayName("Test 1")
	public void Test() {		
	
		// GIVEN	
		
		//WHEN
		 List<Employee> employees = controller.getEmployees();
		
		// THEN
		System.out.println("The employees : "+employees);
		Assert.assertNotNull(employees);
		Assert.assertTrue(!CollectionUtils.isEmpty(employees));
	}

}
