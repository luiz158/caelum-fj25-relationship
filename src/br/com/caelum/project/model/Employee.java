package br.com.caelum.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Department department;

	@OneToOne
	private ParkingSpace parkingSpace;

	private String name;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}

// In ManyToOne will be created a column department_id where will be joined the
// department attribute name and id attribute name of the employee class