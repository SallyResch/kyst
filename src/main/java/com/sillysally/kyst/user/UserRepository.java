package com.sillysally.kyst.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Objects;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
Optional<Object> findCustomerById(Long id);
}
