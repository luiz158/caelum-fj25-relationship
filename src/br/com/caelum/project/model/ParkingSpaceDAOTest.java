package br.com.caelum.project.model;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.project.dao.EmployeeDAO;
import br.com.caelum.project.dao.ParkingSpaceDAO;

public class ParkingSpaceDAOTest {

	private EntityManager entityManager;
	
	private EntityManagerFactory factory;

	@Before
	public void setUp() {
		factory = Persistence.createEntityManagerFactory("caelumfj25");
		entityManager = factory.createEntityManager();
	}
	
	@Test
	public void shouldBeReturnedAnEmployeeThroughAParkingSpace() throws Exception {
		ParkingSpace parkingSpace = new ParkingSpace();
		parkingSpace.setLocation("B4");
		ParkingSpaceDAO parkingSpaceDAO = new ParkingSpaceDAO(entityManager);
		
		Employee john = new Employee();
		john.setName("John");
		john.setParkingSpace(parkingSpace);
		EmployeeDAO employeeDAO = new EmployeeDAO(entityManager);
		
		entityManager.getTransaction().begin();
		parkingSpaceDAO.save(parkingSpace);
		employeeDAO.save(john);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		entityManager = factory.createEntityManager();
		ParkingSpace newParkingSpace = entityManager.find(ParkingSpace.class, parkingSpace.getId());

		assertEquals("John", newParkingSpace.getEmployee().getName());
	}
	
}
