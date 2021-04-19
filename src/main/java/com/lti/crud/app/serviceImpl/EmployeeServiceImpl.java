package com.lti.crud.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.crud.app.exception.ResourceNotFoundException;
import com.lti.crud.app.model.Employee;
import com.lti.crud.app.repository.EmployeeRepository;
import com.lti.crud.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository repository;
	

	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}

	public Employee getEmployee(int employeeId) {
		
		return repository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("EmployeeId:  "+ employeeId));
	}

	public List<Employee> removeEmployee(int employeeId) {
		repository.deleteById(employeeId);
		return repository.findAll();
	}
	
	@Override
	public List<Employee> getAllEmployee() {
		return repository.findAll();
	}

}
