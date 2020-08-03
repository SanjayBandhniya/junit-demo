
package net.guides.springboot2.springboot2jpacrudexample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.guides.springboot2.springboot2jpacrudexample.controller.EmployeeController;
import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.service.EmployeeService;
import net.guides.springboot2.springboot2jpacrudexample.service.EmployeeServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class Test1 {

	@Configuration
	static class ContextConfiguration {

		@Bean
		EmployeeController employeeController() {
			return new EmployeeController();
		}

	}

	@InjectMocks
	@Spy
	private EmployeeController employeeController;

	@org.junit.Test
	public void test() throws Exception {

		Employee employee = new Employee();
		employee.setEmailId("admin@gmail.com");
		employee.setFirstName("admin");
		employee.setLastName("admin");
		System.err.println("--------------------------------------");
		Employee e = employeeController.createEmployee(employee);
		assertNotNull(e);
		System.err.println("--------------------------------------");

		ResponseEntity<Employee> e1 = employeeController.getEmployeeById(e.getId());
		assertEquals("admin", e1.getBody().getFirstName());
	}

}