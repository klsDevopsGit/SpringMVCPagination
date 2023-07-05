package com.springmvc.pagination.dao;

import java.util.List;

//import com.springmvc.pagination.model.Employee;
import com.springmvc.pagination.model.PaginationResult;

public interface EmployeeDAO {
	
	public  PaginationResult getAllEmployees(int pageNumber,int pageSize,String sortingField,String sortingDirection);

}
