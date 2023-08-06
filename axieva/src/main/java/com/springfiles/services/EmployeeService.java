package com.springfiles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springfiles.entity.Employee;
import com.springfiles.repository.EmployeeRepository;

@Service
public class EmployeeService  
{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void saveEmployee(Employee employee)
	{
		employeeRepository.save(employee);
	}
	
	public List<Employee> getRecordByName(String name)
	{
		List<Employee> findName = employeeRepository.findByName(name);
		
		return findName;
	}
	
	
}
