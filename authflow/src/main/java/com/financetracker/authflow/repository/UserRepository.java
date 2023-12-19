package com.financetracker.authflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financetracker.authflow.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
