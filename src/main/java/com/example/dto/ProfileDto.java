package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ProfileDto {
    private int id;
    UUID uuid;
    UUID user;
    String name;
    String surname;
    String sex;
    LocalDate birthday;
    LocalDateTime signUpDate;
    LocalDateTime lastVisitDate;
}
