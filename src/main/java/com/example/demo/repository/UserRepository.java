package com.example.demo.repository;

import com.example.demo.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by addis on 7/18/17.
 */
public interface UserRepository extends JpaRepository<Users,Long> {

    Users findByUserName(String userName);
}


