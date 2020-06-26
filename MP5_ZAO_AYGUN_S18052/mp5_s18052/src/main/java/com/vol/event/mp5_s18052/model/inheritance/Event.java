package com.vol.event.mp5_s18052.model.inheritance;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Event implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEvent;


	@NotBlank // mandatory
	private String nameEvent;

	//@Size(min = 20, message = "Event capacity should be at least 20")
	private int capacity;

	public Event(@NotBlank String nameEvent, int capacity) {
		super();
		
		this.nameEvent = nameEvent;
		this.capacity = capacity;
	}
	

	public Event() {
		super();
		
	}


	public Long getIdEvent() {
		return idEvent;
	}


	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}


	public String getNameEvent() {
		return nameEvent;
	}


	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		return "Event Name :" + nameEvent + " capacity : " + capacity ;
	}

}
