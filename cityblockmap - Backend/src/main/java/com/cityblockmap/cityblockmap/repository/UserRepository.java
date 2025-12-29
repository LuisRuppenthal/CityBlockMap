package com.cityblockmap.cityblockmap.repository;

import com.cityblockmap.cityblockmap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);
}
