package com.sayhellostream.repo;


import com.sayhellostream.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findOneByEmail(String email);
    Optional<AppUser> findOneByUsername(String email);
}