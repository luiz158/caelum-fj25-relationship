package br.com.caelum.project.dao;

import javax.persistence.EntityManager;

import br.com.caelum.project.model.Department;

public class DepartmentDAO {

	private EntityManager entityManager;

	public DepartmentDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void save(Department department) {
		entityManager.persist(department);
	}

}
