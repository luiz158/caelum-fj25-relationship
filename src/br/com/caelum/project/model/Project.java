package br.com.caelum.project.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany(mappedBy = "projects")
	private Collection<Employee> employees;
	
	public Long getId() {
		return id;
	}

	public Collection<Employee> getEmployees() {
		return employees;
	}

}
