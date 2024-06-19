package dev.arhimedes.makersharks.user.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class UserRegistrationDTO {

    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    @Size(min = 8, message = "Password must be at least 8 character long")
    private String password;

    @Size(max = 10, min = 10, message = "Indian phone number length must be 10 character long")
    @Pattern(regexp = "\\d+", message = "Phone number should be numeric")
    private String phone;

    @Past(message = "Date of birth must be a date in the past")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dob;
}
