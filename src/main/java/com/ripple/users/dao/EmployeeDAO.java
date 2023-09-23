package com.ripple.users.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.ripple.users.dto.Emp;

public class EmployeeDAO {
	private EntityManagerFactory emf  =Persistence.createEntityManagerFactory("employeedb");
	EntityManager em=emf.createEntityManager();

  
    
    
    public Emp createEmployee(Emp employee) {
        try {
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
            return employee;
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw ex;
        } 
    }
    
    public Emp getEmployeeById(int id) {
    	
        
            return em.find(Emp.class, id);
       
    }
        
    public List<Emp> getAllEmployees() {
    
    	    
    	        String jpql = "SELECT e FROM Emp e";
    	        TypedQuery<Emp> query = em.createQuery(jpql, Emp.class);
    	        return query.getResultList();
    	    
    }
    
    public Emp updateEmployee(Emp employee) {
    
        try {
            em.getTransaction().begin();
            Emp updatedEmployee = em.merge(employee);
            em.getTransaction().commit();
            return updatedEmployee;
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw ex;
        } 
    }
    
    public void deleteEmployee(int id) {
    	Emp employee=getEmployeeById(id);
    	
    
        
        	if(employee!=null) {
        		em.getTransaction().begin();
        		em.remove(employee);
        		em.getTransaction().commit();
        	}
           
            
       
           }
    
    public void close() {
    	em.close();
    	emf.close();
    }
    
    




}
