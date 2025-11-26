package com.cityblockmap.cityblockmap.repository;

import com.cityblockmap.cityblockmap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
