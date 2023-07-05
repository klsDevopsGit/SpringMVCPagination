package com.springmvc.pagination.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.springmvc.pagination.model.Employee;
import com.springmvc.pagination.model.PaginationResult;
import com.springmvc.pagination.utils.HibernateUtils;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@SuppressWarnings("unused")
	public  PaginationResult getAllEmployees(int pageNumber,int pageSize,String sortingField,String sortingDirection) {
		 
		SessionFactory sessionFactory = null;
		Session session = null;
		 int pagination = pageNumber * pageSize; //to set first result in Query
		 List<Employee> employeeList = null;
		 int lastPageNumber = 0;
		 PaginationResult pageResult = null;
		try 
		{
			session = HibernateUtils.getSessionFactory().openSession();
			List<Employee> totalEmployees = null;
			
			int totalRecordsSize = 0;
			
			String sql = "from Employee e order by e." + sortingField  + " " +  sortingDirection;
			Query query = session.createQuery(sql);
			
			if(totalEmployees != null && totalEmployees.size() >= 0) {
				totalEmployees = query.list();
				totalRecordsSize = totalEmployees.size();
			    
			    if(totalRecordsSize % pageSize == 0) 
			    {
			    	  lastPageNumber = (int) totalRecordsSize/pageSize;
			    }
			    else 
			    {
			    	  lastPageNumber = (int) totalRecordsSize/pageSize + 1;
			    }
			    	 
			}
			
			query.setFirstResult(pagination);
			query.setMaxResults(pageSize);
			
			employeeList = query.list();
			
			pageResult.setOffset(pagination);
			pageResult.setCurrentPageNumber(pageNumber);
			pageResult.setLastPageNumber(lastPageNumber);
			pageResult.setTotalElements(totalRecordsSize);
			pageResult.setTotalPages(lastPageNumber);
			pageResult.setEmployeeList(employeeList);
		}
		catch (Exception e) {
		      e.printStackTrace();
		}
		   finally
		   {
			   session.close();
			   sessionFactory.close();
		   }
		return pageResult;
	}

}
