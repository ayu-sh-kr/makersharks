package dev.arhimedes.makersharks.user.entity;

import dev.arhimedes.makersharks.user.utils.UserIdGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserIdGenerator")
    @GenericGenerator(type = UserIdGenerator.class, name = "UserIdGenerator")
    private String id;
    private String name;
    private String email;
    private String password;
    private String phone;
    @Temporal(TemporalType.DATE)
    private LocalDate dob;

}
