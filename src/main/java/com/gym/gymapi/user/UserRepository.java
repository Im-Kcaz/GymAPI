package com.gym.gymapi.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query(value = "SELECT * FROM Users u WHERE u.email = ?1", nativeQuery = true)
    Optional<User> findUserByEmail(String email);
}
