package org.airtribe.LearnerManagementSystemBelC14.repository;

import org.airtribe.LearnerManagementSystemBelC14.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
