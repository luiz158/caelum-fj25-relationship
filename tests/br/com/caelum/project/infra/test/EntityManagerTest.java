package br.com.caelum.project.infra.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class EntityManagerTest {

	@Test
	public void shouldBeReturnedEntityManager() throws Exception {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("caelumfj25");
		EntityManager entityManager = factory.createEntityManager();
		
		assertNotNull(entityManager);
	}
}
