package com.example.ProfileService;

import com.example.domain.Profile;
import com.example.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfileServiceImp implements ProfileService {
    ProfileRepository profileRepository;

    @Override
    public Iterable<Profile> findAll() {
        return profileRepository.findAll();
    }
}
