
package net.guides.springboot2.springboot2jpacrudexample;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import net.guides.springboot2.springboot2jpacrudexample.controller.EmployeeController;
import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeeRepository;
import net.guides.springboot2.springboot2jpacrudexample.service.EmployeeService;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.guides.springboot2.springboot2jpacrudexample.controller.EmployeeController;
import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.service.EmployeeService;

@Configuration
@ComponentScan(basePackages = { "com.controller", "com.service", "com.repository" })
class CustomConfiguration {

}

@RunWith(SpringJUnit4ClassRunner.class)
@org.springframework.test.context.ContextConfiguration(classes = CustomConfiguration.class)
public class Test1 {

	@InjectMocks
	@Spy
	private EmployeeController employeeController;

	@Mock
	EmployeeService employeeService;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@org.junit.Test
	public void test() throws Exception {

		Employee employee = new Employee();
		employee.setEmailId("admin@gmail.com");
		employee.setFirstName("admin");
		employee.setLastName("admin");

		Employee e = employeeController.createEmployee(employee);
		assertNotNull(e);
	}

}