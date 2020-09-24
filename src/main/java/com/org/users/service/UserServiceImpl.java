package com.org.users.service;

import com.org.users.data.PhoneEntity;
import com.org.users.data.UserEntity;
import com.org.users.dto.UserDTO;
import com.org.users.exceptions.DuplicateMailException;
import com.org.users.repository.UserRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encryptPassword;

    @Autowired
    private DozerBeanMapper mapper;


    @Override
    public UserDTO createUser(UserDTO userDTO) {
        userDTO.setPassword(encryptPassword.encode(userDTO.getPassword()));
        UserEntity userEntity = mapper.map(userDTO, UserEntity.class);
        for (PhoneEntity phone : userEntity.getPhones()) {
            phone.setUser(userEntity);
        }
        if (existMail(userDTO.getMail())) throw new DuplicateMailException("Mail duplicate");
        userRepository.save(userEntity);
        return userDTO;
    }

    private boolean existMail(String mail) {
        Optional<UserEntity> users = userRepository.findByMail(mail);
        return users.isPresent();
    }
}
