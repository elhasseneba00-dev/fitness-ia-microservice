package com.fitnessmicroservice.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
    private String firstName;
    private String lastName;

    @Email(message = "Email invalide")
    @NotBlank(message = "Email required")
    private String email;

    @NotBlank(message = "Password required")
    @Size(min = 6, message = "Password doit être au moins 6 caractères")
    private String password;

}
