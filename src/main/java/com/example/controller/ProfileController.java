package com.example.controller;

import com.example.ProfileService.ProfileService;
import com.example.ProfileService.ProfileServiceImp;
import com.example.dto.ProfileDto;
import com.example.dto.requests.CreateProfileRequest;
import com.example.exceptions.ProfileNotFoundExceptions;
import com.example.exceptions.ProfileNotFoundRestExceptions;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfileServiceImp profileService;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<ProfileDto> getAll() {
        return profileService.findAll();
    }

    @GetMapping("/{profileId}")
    @ResponseStatus(code = HttpStatus.OK)
    public ProfileDto findProfile(@PathVariable("profileId") final UUID uuid) {
        return profileService.findProfile(uuid);
    }

    @DeleteMapping("/{profileId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteProfile(@PathVariable("profileId") final UUID uuid) {
        try {
            profileService.deleteProfile(uuid);
        } catch (ProfileNotFoundExceptions exceptions) {
            throw new ProfileNotFoundRestExceptions(exceptions.getMessage());
        }
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProfileDto createProfile(@Valid @RequestBody final CreateProfileRequest request) {
        System.out.println(request);
        return profileService.save(request);
    }
}
