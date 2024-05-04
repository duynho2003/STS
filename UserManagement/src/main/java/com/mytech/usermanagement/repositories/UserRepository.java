package com.mytech.usermanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mytech.usermanagement.models.User;


public interface UserRepository extends JpaRepository<User, Long>{

	//Prefix findBy + property -> ko can viet dau query
	public User findByUsername(String username);
	public User findByPassword(String password);
	
	@Query("SELECT u FROM User u WHERE u.username = :username")
	public User getByUsername(@Param("username") String username);
}
