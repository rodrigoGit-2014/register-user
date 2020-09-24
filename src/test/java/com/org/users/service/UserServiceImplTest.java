package com.org.users.service;

import com.org.users.data.UserEntity;
import com.org.users.dto.PhoneDTO;
import com.org.users.dto.UserDTO;
import com.org.users.repository.UserRepository;
import org.dozer.DozerBeanMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private BCryptPasswordEncoder encryptPassword;
    @Spy
    private DozerBeanMapper mapper;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void createUserTest() {
        when(encryptPassword.encode(any())).thenReturn("dummy encode password");
        when(userRepository.save(any())).thenReturn(new UserEntity());
        when(userRepository.findByMail(any())).thenReturn(Optional.empty());
        UserDTO userDTO = userService.createUser(userDTOMock());
        Assert.assertNotNull(userDTO);
    }

    private UserDTO userDTOMock(){
        UserDTO userDTO = new UserDTO();
        userDTO.setMail("dumyMail");
        userDTO.setPassword("dumyPassword");
        userDTO.setPhones(Arrays.asList(new PhoneDTO(0,0,0)));
        return userDTO;
    }

    private UserEntity userEntityMock(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUID.randomUUID());
        userEntity.setMail("dumyMail");
        userEntity.setName("dumyName");
        return userEntity;
    }


}