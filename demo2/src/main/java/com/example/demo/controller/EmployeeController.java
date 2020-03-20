package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	@GetMapping("/employees")
	public List<Employee> getAllEmp(){
		return employeeRepository.findAll();
	}
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable(value="id") Long empId) throws ResourceNotFoundException
	{
		Employee employee=employeeRepository.findById(empId).orElseThrow(()->new ResourceNotFoundException("employee not found for this id::"+empId));
		return ResponseEntity.ok().body(employee);
	}
	@PostMapping("/employees")
	public Employee createemployee(@Valid @RequestBody Employee employee)
	{
		return employeeRepository.save(employee);
	}
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empId,@Valid @RequestBody Employee employeedetails) throws ResourceNotFoundException
	{
		Employee employee=employeeRepository.findById(empId).orElseThrow(()->new ResourceNotFoundException("employee not found for this id::"+empId));
		employee.setEmailId(employeedetails.getEmailId());
		employee.setLastName(employeedetails.getLastName());
		employee.setFirstName(employeedetails.getFirstName());
		final Employee updatesemployee=employeeRepository.save(employee);
		return ResponseEntity.ok(updatesemployee);
	}
	@DeleteMapping("/employees/{id}")
	public Map<String,Boolean> deleteemployee(@PathVariable(value="id") Long empId) throws ResourceNotFoundException
	{
		Employee employee=employeeRepository.findById(empId).orElseThrow(()->new ResourceNotFoundException("employee not found for this id::"+empId));
		employeeRepository.delete(employee);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;

	}

	
}
