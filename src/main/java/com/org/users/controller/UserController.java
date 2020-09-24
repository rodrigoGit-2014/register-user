package com.org.users.controller;

import com.org.users.data.UserEntity;
import com.org.users.dto.UserDTO;
import com.org.users.repository.UserRepository;
import com.org.users.service.UserServiceImpl;
import com.org.users.ui.model.UserRequestModel;
import com.org.users.ui.model.UserResponseModel;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private DozerBeanMapper mapper;


    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseModel> createUser(@Valid @RequestBody UserRequestModel userRequest,
                                                        @RequestHeader (value = "Authorization" ) String token) {
        UserDTO userDTO = mapper.map(userRequest, UserDTO.class);
        userDTO.setToken(token);
        UserDTO userCreated = userService.createUser(userDTO);
        UserResponseModel userResponse = mapper.map(userCreated, UserResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }


}
