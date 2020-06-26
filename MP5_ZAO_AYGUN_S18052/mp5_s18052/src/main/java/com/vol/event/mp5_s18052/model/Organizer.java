package com.vol.event.mp5_s18052.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;;

@Entity
public class Organizer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // id will be generated automatically
	private Long idOrg;
	
	@Size(min = 2, message = "Name should be having at least 2 characters")  // validation api
	private String nameOrg;
	
	@NotBlank // mandatory
	private String surnameOrg;
	
	@Pattern(regexp =	"(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{3}", message = "phone format (xxx-xxx-xxx)")
	private String phoneNumber;
	
	@Min(3000)
	private Double salary;
	
	// Association
	@ManyToOne /*(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH  }) */
			 //with using cascade no need to save org group after creating
	@JoinColumn(name = "idOG")
	@JsonIgnore
	private OrgGroup group;
	
	public Organizer() { // this constructor for db
		
	}

	public Organizer(@Size(min = 2, message = "Name should be have atleast2 characters") String nameOrg,
			@NotBlank String surnameOrg,
			@Pattern(regexp = "(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{3}", message = "phone format (xxx-xxx-xxx)") String phoneNumber,
			@Min(3000) Double salary) {
		super();
		this.nameOrg = nameOrg;
		this.surnameOrg = surnameOrg;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
	}
	
	public OrgGroup getOrgGroup() {
		return group;
	}
	
	public void setOrgGroup(OrgGroup group) {
		this.group = group;
	}
	
	public Long getIdOrg() {
		return idOrg;
	}

	public void setIdOrg(Long idOrg) {
		this.idOrg = idOrg;
	}

	public String getNameOrg() {
		return nameOrg;
	}

	public void setNameOrg(String nameOrg) {
		this.nameOrg = nameOrg;
	}

	public String getSurnameOrg() {
		return surnameOrg;
	}

	public void setSurnameOrg(String surnameOrg) {
		this.surnameOrg = surnameOrg;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Organizer id = " + idOrg + " Name :" + nameOrg + " " + surnameOrg + " number : " + phoneNumber + " Salary : " + salary ;
	}
}
