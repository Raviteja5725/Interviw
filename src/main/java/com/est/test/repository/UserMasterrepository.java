package com.est.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.est.test.entity.User_Master;
@Repository
public interface UserMasterrepository extends JpaRepository<User_Master, Long> {

	User_Master findByuserName(String username);

	Object findByEmail(String email);

}
