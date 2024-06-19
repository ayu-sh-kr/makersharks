package dev.arhimedes.makersharks.user.controller;

import dev.arhimedes.makersharks.helper.api.APIResponse;
import dev.arhimedes.makersharks.user.dtos.UserRegistrationDTO;
import dev.arhimedes.makersharks.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<APIResponse> createUser(@RequestBody @Validated UserRegistrationDTO userRegistrationDTO){
        return userService.create(userRegistrationDTO);
    }


    @GetMapping
    public ResponseEntity<APIResponse> getAll(){
        return userService.fetchAllUsers();
    }

    @GetMapping("/page")
    public ResponseEntity<APIResponse> getAllByPage(@RequestParam("page") int page, @RequestParam("size") int size){
        return userService.fetchWithPage(page, size);
    }

}
