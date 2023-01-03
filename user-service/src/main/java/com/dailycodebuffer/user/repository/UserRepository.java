package com.dailycodebuffer.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailycodebuffer.user.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserId(Long userId);

}
