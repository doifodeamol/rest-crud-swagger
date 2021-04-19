package com.lti.crud.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.crud.app.exception.ResourceNotFoundException;
import com.lti.crud.app.model.Employee;
import com.lti.crud.app.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/employee")
@Api(value = "Employee Service", description = "Employee Managment")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/save")
	@ApiOperation(value = "store employee api")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}
	
	 @GetMapping("/employees")
	 @ApiOperation(value = "retrive all employee api")
	 public List<Employee> getAllEmployees() {
	        return service.getAllEmployee();
	 }

	@ApiOperation(value = "search employee api")
	@GetMapping("/searchEmployee/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		return service.getEmployee(employeeId);
	}

	@DeleteMapping("/deleteEMployee/{employeeId}")
	public List<Employee> deleteEmployee(@PathVariable int employeeId) {
		return service.removeEmployee(employeeId);

	}
	
	@PutMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int employeeId,
          @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = service.getEmployee(employeeId);

        employee.setName(employeeDetails.getName());
        employee.setDept(employeeDetails.getDept());
        employee.setSalary(employeeDetails.getSalary());
        final Employee updatedEmployee = service.saveEmployee(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
}