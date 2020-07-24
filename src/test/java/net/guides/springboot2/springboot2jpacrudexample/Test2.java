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

/*@Configuration
@ComponentScan(basePackages = { "net.guides.springboot2.springboot2jpacrudexample.controller",
		"net.guides.springboot2.springboot2jpacrudexample.service",
		"net.guides.springboot2.springboot2jpacrudexample.repository" })
class CustomConfiguration {

}*/

@RunWith(SpringRunner.class)
public class Test2 {

	@InjectMocks
	private EmployeeController employeeController;

	@Mock
	EmployeeService employeeService;

	@Mock
	EmployeeRepository employeeRepository;

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
		System.err.println("--------------------------------------");
		Employee e = employeeController.createEmployee(employee);
		assertNotNull(e);
		System.err.println("--------------------------------------");
	}

}
