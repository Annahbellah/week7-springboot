package com.example.Week7.repositories;

import com.example.Week7.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    void deleteByEmail(String email);
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
    @Query(nativeQuery = true,value = "select * from  users  where name like %:question% or email like %:question%")
    Optional<List<User>> findBySearch(String question);
}
