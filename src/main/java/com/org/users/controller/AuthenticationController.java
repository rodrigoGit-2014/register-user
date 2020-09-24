package com.org.users.controller;

import com.org.users.service.MyUserDetailsService;
import com.org.users.ui.model.AuthenticationRequestModel;
import com.org.users.ui.model.AuthenticationResponseModel;
import com.org.users.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseModel> createAuthenticationToken(@RequestBody AuthenticationRequestModel authenticationRequestModel) throws Exception {
        try {
           authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequestModel.getUsername(),
                    authenticationRequestModel.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequestModel.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponseModel(jwt));
    }
}
