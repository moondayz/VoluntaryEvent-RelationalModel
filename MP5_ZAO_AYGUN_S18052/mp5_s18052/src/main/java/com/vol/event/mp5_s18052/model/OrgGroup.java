package com.vol.event.mp5_s18052.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;;

@Entity
public class OrgGroup {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // id will be generated automatically
	private Long idOG;
	
	//@Size(min = 3, message = "Group Name should be having at least 3 characters")  
	private String nameOG;
	
	//@Size(max = 15, message = " Capacity of the group is max 15")
	private int capacity;
	
	//@Size(min = 1, message = "There must be at least one organizer in a group")  
	//association - a may have many organizers -define anotation
	@OneToMany(fetch = FetchType.LAZY, 
			mappedBy = "group")
	private Set<Organizer> orgs = new HashSet<Organizer>();

	public OrgGroup() {
		
	}
	
	public OrgGroup(@Size(min = 3, message = "Group Name should be having at least 3 characters") String nameOG,
			@Size(max = 15, message = " Capacity of the group is max 15") int capacity) {
		super();
		this.nameOG = nameOG;
		this.capacity = capacity;
	}
	
	public Set<Organizer> getOrgs() {
		return orgs;
	}
	
	public void setOrgs(Set<Organizer> orgs) {
		this.orgs = orgs;
	}
	
	public Long getIdOG() {
		return idOG;
	}
	public void setIdOG(Long idOG) {
		this.idOG = idOG;
	}
	public String getNameOG() {
		return nameOG;
	}
	public void setNameOG(String nameOG) {
		this.nameOG = nameOG;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		return "Organizer Group id = " + idOG + " Name :" + nameOG + " Capacity : " + capacity  + " Organizers : " + orgs ;
	}
	
} 
