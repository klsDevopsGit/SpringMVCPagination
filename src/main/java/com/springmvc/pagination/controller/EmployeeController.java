package com.springmvc.pagination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.pagination.model.PaginationResult;
import com.springmvc.pagination.service.EmployeeService;

 

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empployeeService;
	
    @RequestMapping("/getEmployees")
    public PaginationResult getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize,
                               @RequestParam String sortingField, @RequestParam String sortingDirection, Model model) {
      
       
    	PaginationResult paginationResult = empployeeService.getAllEmployees(pageNumber, pageSize, sortingField, sortingDirection);
    	
    	model.addAttribute("paginationResult", paginationResult);
    	
    	return paginationResult;
    }

}
