package com.fuadrabbi.eommerce_backend.api.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistrationBody {
    @NotNull
    @NotBlank
    @Size(min=3, max=255)
    private String username;
    @NotNull
    @Email
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")
    @Size(min=6, max=32)
    private String password;
    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;
}
