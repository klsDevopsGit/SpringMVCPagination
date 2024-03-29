package com.springmvc.pagination.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "employees")
public class Employee {

	    @Id
	    @GeneratedValue(generator = "incrementor")
		@GenericGenerator(name = "incrementor", strategy = "increment")	
	    @Column(name = "EMPLOYEE_ID", nullable = false)
    private long id;
	    
	@Column(name = "first_name", nullable = false)    
    private String firstName;
	
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name = "EMAIL", nullable = false)
    private String emailId;
 
    public Employee() {
  
    }
 
    public Employee(String firstName, String lastName, String emailId) {
         this.firstName = firstName;
         this.lastName = lastName;
         this.emailId = emailId;
    }
 
   
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
 

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
   
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
       + "]";
    }
 
}