package dev.arhimedes.makersharks.user.repository;

import dev.arhimedes.makersharks.user.entity.UserInfoDTO;
import dev.arhimedes.makersharks.user.entity.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, String> {

    @Query("select new dev.arhimedes.makersharks.user.entity.UserInfoDTO(u.id, u.name, u.email, u.phone, u.dob) from UserModel u")
    Page<UserInfoDTO> findAllUsers(Pageable pageable);

    @Query("select new dev.arhimedes.makersharks.user.entity.UserInfoDTO(u.id, u.name, u.email, u.phone, u.dob) from UserModel u")
    List<UserInfoDTO> findAllUsersInfo();

    boolean existsByEmail(String email);
}
