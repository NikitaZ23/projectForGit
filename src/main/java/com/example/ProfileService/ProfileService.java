package com.example.ProfileService;

import com.example.domain.Profile;

public interface ProfileService {
    Iterable<Profile> findAll();
}
