package com.blog.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	

}
