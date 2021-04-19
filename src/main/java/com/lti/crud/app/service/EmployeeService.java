package com.lti.crud.app.service;

import java.util.List;

import com.lti.crud.app.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	Employee getEmployee(int employeeId);

	List<Employee> removeEmployee(int employeeId);

	List<Employee> getAllEmployee();
}
