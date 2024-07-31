package com.journalapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.journalapp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

//	User findByName(String name);
	Optional<User> findByName(String username);
}
