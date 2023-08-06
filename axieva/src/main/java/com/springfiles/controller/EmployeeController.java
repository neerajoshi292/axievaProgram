package com.springfiles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springfiles.entity.Employee;
import com.springfiles.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee)
	{
		employeeService.saveEmployee(employee);
		
		return ResponseEntity.ok("Employee Record saved...");
	}
	
	@GetMapping("/view")
	public ResponseEntity<List<Employee>> viewRecordByName(@RequestParam("name") String name)
	{
		List<Employee> recordByName = employeeService.getRecordByName(name);
		
		if(recordByName.isEmpty())
		{
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(recordByName);
		}

	}

}
