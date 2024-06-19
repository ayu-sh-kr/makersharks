package dev.arhimedes.makersharks.user.converter;

import dev.arhimedes.makersharks.helper.contracts.Converter;
import dev.arhimedes.makersharks.user.dtos.UserRegistrationDTO;
import dev.arhimedes.makersharks.user.entity.UserModel;
import dev.arhimedes.makersharks.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRequestConverter implements Converter<UserModel, UserRegistrationDTO> {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public UserRegistrationDTO convert(UserModel source, UserRegistrationDTO target) {
        return null;
    }

    @Override
    public UserModel revert(UserRegistrationDTO source, UserModel target) {

        if(null == target){
            target = new UserModel();
        }

        target.setName(source.getName());
        target.setEmail(source.getEmail());
        target.setPhone(source.getPhone());
        target.setPassword(passwordEncoder.encode(source.getPassword()));
        target.setDob(source.getDob());

        return userRepository.save(target);
    }
}
