package com.orangezup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orangezup.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}

