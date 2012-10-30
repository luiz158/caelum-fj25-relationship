package br.com.caelum.project.dao;

import javax.persistence.EntityManager;

import br.com.caelum.project.model.Employee;

public class EmployeeDAO {

	private EntityManager entityManager;

	public EmployeeDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void save(Employee john) {
		entityManager.persist(john);
	}
	
}
