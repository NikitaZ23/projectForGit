package com.example.ProfileService;

import com.example.dto.ProfileDto;
import com.example.dto.requests.CreateProfileRequest;

import java.util.UUID;

public interface ProfileService {
    Iterable<ProfileDto> findAll();

    ProfileDto save(CreateProfileRequest request);

    ProfileDto findProfile(UUID uuid);

    void deleteProfile(UUID uuid);
}
