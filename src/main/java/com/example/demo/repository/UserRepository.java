package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT c FROM User c WHERE c.email = :email or c.username = :username")
	public User UserExistence(@Param("email") String email,@Param("username") String username);
	@Query("SELECT c FROM User c WHERE c.username = :username and c.password = :password")
	public User LoginCheck(@Param("username") String username,@Param("password") String password);
}
