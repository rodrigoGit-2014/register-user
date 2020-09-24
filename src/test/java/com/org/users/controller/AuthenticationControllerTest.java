package com.org.users.controller;

import com.org.users.service.MyUserDetailsService;
import com.org.users.ui.model.AuthenticationRequestModel;
import com.org.users.ui.model.AuthenticationResponseModel;
import com.org.users.util.JWTUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private MyUserDetailsService userDetailsService;
    @Mock
    private JWTUtil jwtUtil;
    @InjectMocks
    private AuthenticationController authenticationController;


    @Test
    public void createAuthenticationTokenTest() throws Exception {
        when(authenticationManager.authenticate(any())).thenReturn(null);
        when(userDetailsService.loadUserByUsername(any())).thenReturn(userDetailsMock());
        when(jwtUtil.generateToken(any())).thenReturn("dummy jwt");
        AuthenticationRequestModel authenticationRequestModel = new AuthenticationRequestModel("root", "root");
        ResponseEntity<?> responseEntity = authenticationController.createAuthenticationToken(authenticationRequestModel);
        Assert.assertNotNull(responseEntity);
        Assert.assertEquals("dummy jwt", ((AuthenticationResponseModel) responseEntity.getBody()).getJwt());
    }

    @Test(expected = Exception.class)
    public void createAuthenticationTokenExceptionTest() throws Exception {
        when(authenticationManager.authenticate(any())).thenThrow(BadCredentialsException.class);
        AuthenticationRequestModel authenticationRequestModel = new AuthenticationRequestModel("root", "root");
        ResponseEntity<?> responseEntity = authenticationController.createAuthenticationToken(authenticationRequestModel);
    }

    private UserDetails userDetailsMock() {
        return User.withDefaultPasswordEncoder().username("root").password("root").roles("USER").build();
    }
}