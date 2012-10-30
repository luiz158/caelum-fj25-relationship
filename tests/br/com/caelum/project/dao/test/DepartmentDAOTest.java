package br.com.caelum.project.dao.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.project.dao.DepartmentDAO;
import br.com.caelum.project.dao.EmployeeDAO;
import br.com.caelum.project.model.Department;
import br.com.caelum.project.model.Employee;

public class DepartmentDAOTest {

	private EntityManagerFactory factory;
	
	private EntityManager entityManager;

	@Before
	public void setUp() {
		factory = Persistence.createEntityManagerFactory("caelumfj25");
		entityManager = factory.createEntityManager();
	}
	
	@Test
	public void shouldBeReturnedAListOfEmployeesThatWorksInDepartment() throws Exception {
		Employee john = new Employee();
		john.setName("John");
		Employee michael = new Employee();
		michael.setName("Michael");
		
		
		Department department = new Department();
		department.setName("IT");
		john.setDepartment(department);
		michael.setDepartment(department);
		
		entityManager.getTransaction().begin();
		EmployeeDAO employeeDAO = new EmployeeDAO(entityManager);
		DepartmentDAO departmentDAO = new DepartmentDAO(entityManager);
		employeeDAO.save(john);
		employeeDAO.save(michael);
		departmentDAO.save(department);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		entityManager = factory.createEntityManager();
		Department it = entityManager.find(Department.class, department.getId());
		
		assertEquals(2, it.getEmployees().size());
	}
	
}
