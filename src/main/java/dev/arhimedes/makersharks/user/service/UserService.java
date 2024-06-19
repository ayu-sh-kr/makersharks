package dev.arhimedes.makersharks.user.service;

import dev.arhimedes.makersharks.helper.api.APIResponse;
import dev.arhimedes.makersharks.user.converter.UserRequestConverter;
import dev.arhimedes.makersharks.user.dtos.UserRegistrationDTO;
import dev.arhimedes.makersharks.user.entity.UserModel;
import dev.arhimedes.makersharks.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserRequestConverter userRequestConverter;


    public ResponseEntity<APIResponse> create(UserRegistrationDTO userRegistrationDTO){

        if(userRepository.existsByEmail(userRegistrationDTO.getEmail())){
            return new ResponseEntity<>(APIResponse.withMessage("Email Already Exists"), HttpStatus.FORBIDDEN);
        }

        UserModel userModel = userRequestConverter.revert(userRegistrationDTO, null);
        return new ResponseEntity<>(APIResponse.withMessage("User Registered with Id: " + userModel.getId()), HttpStatus.CREATED);
    }


    public ResponseEntity<APIResponse> fetchAllUsers(){
        return new ResponseEntity<>(
                APIResponse.withBody(
                        "User Fetched Successfully",
                            userRepository.findAllUsersInfo()
                        ),
                HttpStatus.OK
        );
    }

    public ResponseEntity<APIResponse> fetchWithPage(int page, int size){
        return new ResponseEntity<>(
                APIResponse.withBody(
                        "User Fetched Successfully",
                        userRepository.findAllUsers(PageRequest.of(page, size))
                ),
                HttpStatus.OK
        );
    }

}
