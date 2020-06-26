package com.vol.event.mp5_s18052.model.inheritance;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="idEvent")

public class FreeEvent extends Event {

	@NotBlank
	//@Pattern(regexp =	"(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{3}", message = "coupon code format (xxx-xxx-xxx)")
	private String couponCode;

	public FreeEvent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FreeEvent( @NotBlank String nameEvent, int capacity, @NotBlank String couponCode) {
		
		super(nameEvent, capacity);
		this.couponCode = couponCode;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	
	
}

