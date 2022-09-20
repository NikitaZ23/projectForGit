package com.example.controller;

import com.example.ProfileService.ProfileService;
import com.example.domain.Profile;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/profiles")
public class ProfileController {
    ProfileService profileService;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<Profile> getAll(){
        return profileService.findAll();
    }
}
