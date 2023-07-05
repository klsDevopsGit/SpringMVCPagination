package com.springmvc.pagination.service;

import java.util.List;

import com.springmvc.pagination.model.Employee;
import com.springmvc.pagination.model.PaginationResult;

public interface EmployeeService {

	public PaginationResult getAllEmployees(int pageNumber,int pageSize,String sortingField,String sortingDirection);
}
