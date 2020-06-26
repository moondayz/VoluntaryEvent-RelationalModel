package com.vol.event.mp5_s18052.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vol.event.mp5_s18052.model.OrgGroup;
import com.vol.event.mp5_s18052.model.Organizer;

public interface OrgGroupRepo extends CrudRepository<OrgGroup, Long> {

	List<OrgGroup>  findByCapacity(int capacity);
	
	@Query(value= "SELECT o from OrgGroup o LEFT JOIN FETCH o.orgs WHERE o.id=:id")
	Optional<OrgGroup> findById(@Param("id")Long id);
	
	
}
