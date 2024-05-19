package com.sai.userService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sai.userService.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
