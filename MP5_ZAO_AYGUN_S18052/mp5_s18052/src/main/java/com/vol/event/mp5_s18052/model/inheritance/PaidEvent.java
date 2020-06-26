package com.vol.event.mp5_s18052.model.inheritance;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="idEvent")
public class PaidEvent extends Event {

	
	private int ticketPrice;

	public PaidEvent() {
		super();
	}

	public PaidEvent(@NotBlank String nameEvent, int capacity ,  int ticketPrice) {
		super(nameEvent, capacity);
		this.ticketPrice = ticketPrice;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	
}
