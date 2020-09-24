package com.org.users.controller;

import com.org.users.data.UserEntity;
import com.org.users.repository.UserRepository;
import com.org.users.service.UserServiceImpl;
import org.dozer.DozerBeanMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserServiceImpl userService;
    @Spy
    private DozerBeanMapper mapper;

    @InjectMocks
    private UserController userController;

    @Test
    public void test(){
        when(userRepository.findAll()).thenReturn(userEntitiesMock());
        ResponseEntity<List<UserEntity>> result =  userController.getAllUsers();
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(result.getBody().size(),1);
    }


    private List<UserEntity> userEntitiesMock(){
        return Arrays.asList(new UserEntity("Rod","dumyMail","123","ww",null));
    }

}