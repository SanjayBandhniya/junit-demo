package net.guides.springboot2.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	Employee save(Employee employee);

	Employee findById(Long employeeId) throws ResourceNotFoundException;

	Employee update(@Valid Employee employeeDetails, Long employeeId) throws ResourceNotFoundException;

	Map<String, Boolean> delete(Long employeeId) throws ResourceNotFoundException;

}
