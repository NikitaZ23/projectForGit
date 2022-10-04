package com.example.repository;

import com.example.domain.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {
    Optional<Profile> findByUuid(UUID uuid);
}
