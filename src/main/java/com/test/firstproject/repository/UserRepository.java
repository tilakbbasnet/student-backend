package com.test.firstproject.repository;

import com.test.firstproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findUserByUserNameAndPassword(String username, String password);
}
