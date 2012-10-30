package br.com.caelum.project.dao;

import javax.persistence.EntityManager;

import br.com.caelum.project.model.ParkingSpace;

public class ParkingSpaceDAO {

	private EntityManager entityManager;

	public ParkingSpaceDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void save(ParkingSpace parkingSpace) {
		entityManager.persist(parkingSpace);
	}

}
