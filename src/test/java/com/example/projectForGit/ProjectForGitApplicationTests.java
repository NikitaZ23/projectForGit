package com.example.projectForGit;

import com.example.ProfileService.ProfileServiceImp;
import com.example.domain.Profile;
import com.example.dto.ProfileDto;
import com.example.dto.requests.CreateProfileRequest;
import com.example.mapper.ProfileMapper;
import com.example.repository.ProfileRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ProjectForGitApplicationTests {

    @Mock
    ProfileRepository profileRepository;

    @InjectMocks
    ProfileServiceImp service;

    @Mock
    ProfileMapper profileMapper;

    @Test
    void contextLoads() {
        Profile profile = new Profile("name", "family", "male", LocalDate.now());

        Mockito.when(profileRepository.save(Mockito.any())).thenReturn(profile);

        ProfileDto profile2 = service.save(new CreateProfileRequest("a", "v", "male", LocalDate.now()));

        assertThat(profileMapper.map(profile)).isEqualTo(profile2);
    }

}
