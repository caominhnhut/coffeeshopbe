package com.projectbase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projectbase.entity.UserEntity;
import com.projectbase.exception.AuthenticationException;
import com.projectbase.factory.UserStatus;
import com.projectbase.model.MyUserDetail;
import com.projectbase.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JwtUserService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        UserEntity userEntity = userRepository.findByEmailAndStatus(username, UserStatus.ACTIVE);

        if(userEntity == null){
            log.error("{} not found", username);
            throw new AuthenticationException("username is not valid");
        }

        return new MyUserDetail(userEntity);
    }
}
