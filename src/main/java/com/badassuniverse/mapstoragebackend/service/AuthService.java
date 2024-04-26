package com.badassuniverse.mapstoragebackend.service;

import com.badassuniverse.mapstoragebackend.dto.JwtRequest;
import com.badassuniverse.mapstoragebackend.dto.JwtResponse;
import com.badassuniverse.mapstoragebackend.dto.RegistrationUserDto;
import com.badassuniverse.mapstoragebackend.dto.UserDto;
import com.badassuniverse.mapstoragebackend.exceptions.AuthTokenCreatingException;
import com.badassuniverse.mapstoragebackend.exceptions.UserCreatingException;
import com.badassuniverse.mapstoragebackend.model.User;
import com.badassuniverse.mapstoragebackend.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final UserService userService;
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthenticationManager authenticationManager;

    public JwtResponse createAuthToken(@RequestBody JwtRequest request) {
        log.info("Getting token");
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new AuthTokenCreatingException("Invalid username or password");
        }
        UserDetails userDetails = userService.loadUserByUsername(request.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);

        return new JwtResponse(token);
    }

    public UserDto createNewUser(@RequestBody RegistrationUserDto registrationUserDto) {
        log.info("Registration new user");
        if (!registrationUserDto.getPassword().equals(registrationUserDto.getConfirmPassword())) {
            throw new UserCreatingException("Password mismatch");
        }
        if (userService.findByUsername(registrationUserDto.getUsername()).isPresent()) {
            throw new UserCreatingException("This user name is already taken");
        }
        User user = userService.createUser(registrationUserDto);
        return new UserDto(user.getId(), user.getUsername(), user.getActive());
    }
}
