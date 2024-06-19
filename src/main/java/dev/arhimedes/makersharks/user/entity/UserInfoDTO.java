package dev.arhimedes.makersharks.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link UserModel}
 */
@Getter @Setter
@AllArgsConstructor
public class UserInfoDTO implements Serializable {
    String id;
    String name;
    String email;
    String phone;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    LocalDate dob;
}