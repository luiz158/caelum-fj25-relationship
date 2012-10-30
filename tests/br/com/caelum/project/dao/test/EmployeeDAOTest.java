package br.com.caelum.project.dao.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.project.dao.DepartmentDAO;
import br.com.caelum.project.dao.EmployeeDAO;
import br.com.caelum.project.dao.ParkingSpaceDAO;
import br.com.caelum.project.model.Department;
import br.com.caelum.project.model.Employee;
import br.com.caelum.project.model.ParkingSpace;

public class EmployeeDAOTest {

	private EntityManager entityManager;

	@Before
	public void setUp() {
		entityManager = Persistence.createEntityManagerFactory("caelumfj25").createEntityManager();
	}
	
	@Test
	public void shouldBeInsertAnEmployeeWithDepartment() throws Exception {
		Department department = new Department();
		department.setName("IT");
		DepartmentDAO departmentDAO = new DepartmentDAO(entityManager);
		
		Employee john = new Employee();
		john.setDepartment(department);
		EmployeeDAO employeeDAO = new EmployeeDAO(entityManager);
		
		entityManager.getTransaction().begin();
		departmentDAO.save(department);
		employeeDAO.save(john);
		entityManager.getTransaction().commit();
		
		Employee employee = entityManager.find(Employee.class, john.getId());
		
		assertEquals("IT", employee.getDepartment().getName());
	}
	
	@Test
	public void shouldBeInsertAnEmployeeWithParkingSpace() throws Exception {
		ParkingSpace parkingSpace = new ParkingSpace();
		parkingSpace.setLocation("C4");
		ParkingSpaceDAO parkingSpaceDAO = new ParkingSpaceDAO(entityManager);
		
		Employee john = new Employee();
		john.setParkingSpace(parkingSpace);
		EmployeeDAO employeeDAO = new EmployeeDAO(entityManager);

		entityManager.getTransaction().begin();
		parkingSpaceDAO.save(parkingSpace);
		employeeDAO.save(john);
		entityManager.getTransaction().commit();
		
		Employee employee = entityManager.find(Employee.class, john.getId());
		
		assertEquals("C4", employee.getParkingSpace().getLocation());
	}
	
}
