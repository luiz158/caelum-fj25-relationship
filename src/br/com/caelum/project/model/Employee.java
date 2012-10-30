package br.com.caelum.project.model;

import java.util.Collection;

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
	
	@ManyToMany
	@JoinTable(name="EMP_PROJ", joinColumns=@JoinColumn(name="EM_ID"), inverseJoinColumns=@JoinColumn(name="PROJ_ID"))
	private Collection<Project> projects;
		
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

	public Collection<Project> getProjects() {
		return projects;
	}

	public void setProjects(Collection<Project> projects) {
		this.projects = projects;
	}

}

// In ManyToOne will be created a column department_id where will be joined the
// department attribute name and id attribute name of the employee class