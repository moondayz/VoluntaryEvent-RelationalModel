package com.vol.event.mp5_s18052.repository;


import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vol.event.mp5_s18052.model.Organizer;


public interface OrganizerRepo extends CrudRepository<Organizer, Long>{

	//for specific search - different then the one in CRUD repo
	
//	@Query("select o from Organizer o where o.salary = max(salary)") 
//	List<Organizer> findBySalary();
	
	@Query("select o from Organizer o where o.phoneNumber=:phoneNumber ") 
	List<Organizer> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);
	

}
