package com.example.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProfileRequest {
    @NotBlank(message = "Name may not be empty")
    @Size(min = 2, max = 32)
    String name;
    @NotBlank(message = "Surname may not be empty")
    @Size(min = 2, max = 32)
    String surname;
    String sex;
    LocalDate birthday;
}
