package com.springmvc.pagination.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.pagination.dao.EmployeeDAO;
import com.springmvc.pagination.model.Employee;
import com.springmvc.pagination.model.PaginationResult;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO empDao;
	
	public PaginationResult getAllEmployees(int pageNumber,int pageSize,String sortingField,String sortingDirection) {
		 
		PaginationResult paginationResult = empDao.getAllEmployees(pageNumber, pageSize, sortingField, sortingDirection);
		    
		return paginationResult;
	}

}
