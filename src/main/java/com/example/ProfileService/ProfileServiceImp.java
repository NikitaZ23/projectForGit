package com.example.ProfileService;

import com.example.domain.Profile;
import com.example.dto.ProfileDto;
import com.example.dto.requests.CreateProfileRequest;
import com.example.exceptions.ProfileNotFoundExceptions;
import com.example.mapper.ProfileMapper;
import com.example.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProfileServiceImp implements ProfileService {
    private static final String PROFILE_NOT_FOUND = "Profile Not found";

    private final ProfileRepository profileRepository;

    private final ProfileMapper profileMapper;

    @Override
    public Iterable<ProfileDto> findAll() {
        return profileMapper.map(profileRepository.findAll());
    }

    @Override
    public ProfileDto save(@NotNull CreateProfileRequest request) {
        return profileMapper.map(profileRepository.save(new Profile(request.getName(), request.getSurname(), request.getSex(), request.getBirthday())));
    }

    @Override
    public ProfileDto findProfile(UUID uuid) {
        return profileMapper.map(profileRepository.findByUuid(uuid).orElseThrow(() ->new ProfileNotFoundExceptions(PROFILE_NOT_FOUND)));
    }

    @Transactional
    @Override
    public void deleteProfile(UUID uuid) {
        Profile profile = profileRepository.findByUuid(uuid).orElseThrow(() -> new ProfileNotFoundExceptions(PROFILE_NOT_FOUND));
        profileRepository.delete(profile);
    }
}
