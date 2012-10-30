package br.com.caelum.project.model;

import java.util.Collection;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany
	@JoinTable(name="Employee_Project", joinColumns=@JoinColumn(name="employee_id"), inverseJoinColumns=@JoinColumn(name="project_id"))
	private Collection<Project> projects;
		
	@Embedded
	private Address address;
	
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

	public Collection<Project> getProjects() {
		return projects;
	}

	public void setProjects(Collection<Project> projects) {
		this.projects = projects;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}

// In ManyToOne will be created a column department_id where will be joined the
// department attribute name and id attribute name of the employee class