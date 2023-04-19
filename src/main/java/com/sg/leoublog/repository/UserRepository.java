package com.sg.leoublog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sg.leoublog.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
