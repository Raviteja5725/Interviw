package com.est.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.est.test.entity.Role_Master;
@Repository
public interface RoleMaster_Repository extends JpaRepository<Role_Master, Long> {

	
	
}
