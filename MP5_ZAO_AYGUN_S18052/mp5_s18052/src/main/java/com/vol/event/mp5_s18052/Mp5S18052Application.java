package com.vol.event.mp5_s18052;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.vol.event.mp5_s18052.model.OrgGroup;
import com.vol.event.mp5_s18052.model.Organizer;
import com.vol.event.mp5_s18052.model.inheritance.Event;
import com.vol.event.mp5_s18052.model.inheritance.FreeEvent;
import com.vol.event.mp5_s18052.model.inheritance.PaidEvent;
import com.vol.event.mp5_s18052.repository.EventRepo;
import com.vol.event.mp5_s18052.repository.OrgGroupRepo;
import com.vol.event.mp5_s18052.repository.OrganizerRepo;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class Mp5S18052Application {

	public static void main(String[] args) {
		SpringApplication.run(Mp5S18052Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(
			OrganizerRepo orgRepo,
			OrgGroupRepo groupRepo,
			EventRepo eventRepo
	) {
		return (args) -> {
			// Association ---------------------------------------
			Organizer org1 = new Organizer("Bob", "Marley", "111-111-111", 5000.0);
			Organizer org2 = new Organizer("Ashley", "Down", "222-222-222",7000.0);
			Organizer org3 = new Organizer("Elon", "Mask", "333-333-333",9000.0);
			Organizer org4 = new Organizer("Ben", "Four", "444-444-444",4000.0);
			
			OrgGroup og4 = new OrgGroup("number4", 12);
			OrgGroup og2 = new OrgGroup("number2", 10);
			
			// association between org and group -------------
			org4.setOrgGroup(og4);
			og4.getOrgs().add(org4);
			groupRepo.save(og4);
			org2.setOrgGroup(og2);
			og2.getOrgs().add(org2);
			
			groupRepo.save(og2);
			
			orgRepo.save(org1);
			orgRepo.save(org2);
			orgRepo.save(org3);
			orgRepo.save(org4);
			
			Iterable<Organizer> findAllOrg = orgRepo.findAll();
			System.out.println(findAllOrg);
			System.out.println("----" + og4.getOrgs());
			
	//		List<Organizer> findBySalary = orgRepo.findBySalary();
	//		System.out.println(findBySalary);
			
			List<Organizer> findByPhone= orgRepo.findByPhoneNumber("222-222-222");
			System.out.println(findByPhone);
	
			System.out.println("----------------------------------------------------------------------------");
		//	OrgGroup ogCap = groupRepo.findByCapacity(10).get(0);
			OrgGroup ogCap = groupRepo.findById(2l).get(); 
			System.out.println("Find by capacity -> "+ ogCap);
			
			
			
			// Inheritance --------------------
		
			Event  fe1 = new FreeEvent("High School Reunion", 150 , "AD1-14B-257");
			Event  fe2 = new FreeEvent( "Tech Summit20", 800 , "TTT-25B-SS3");
			
			Event pe1 = new PaidEvent( "Webinar'20", 200 , 150);
			Event pe2 = new PaidEvent( "Open Day", 70 , 30);
			
			System.out.println("----- Event -----" + fe1);
		
		//	List<Event> events =Arrays.asList(fe1,fe2);
			
			Event[] evs = {fe1,fe2,pe1,pe2};
			List events = Arrays.asList(evs);	
			eventRepo.saveAll(events);
		
			
		
			
		};
	}
}
