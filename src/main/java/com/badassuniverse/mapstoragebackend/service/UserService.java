package com.badassuniverse.mapstoragebackend.service;

import com.badassuniverse.mapstoragebackend.dto.RegistrationUserDto;
import com.badassuniverse.mapstoragebackend.dto.UserDto;
import com.badassuniverse.mapstoragebackend.mapper.UserMapper;
import com.badassuniverse.mapstoragebackend.model.User;
import com.badassuniverse.mapstoragebackend.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public Optional<User> findByUsername(String username) {
        log.info("Searching user with username: " + username);
        return repository.findByUsername(username);
    }

    public User createUser(RegistrationUserDto registrationUserDto) {
        log.info("Creating user");
        User user = User.builder()
                .username(registrationUserDto.getUsername())
                .password(passwordEncoder.encode(registrationUserDto.getPassword()))
                .active(true)
                .roles(List.of(roleService.getUserRole()))
                .build();

        return repository.save(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Loading user with username: " + username);
        User user = findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User %s not found".formatted(username)));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role.getName()))
                        .collect(Collectors.toList())
        );
    }

    public List<UserDto> getAll() {
        log.info("Getting all users.");
        return ((List<User>) repository.findAll()).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        log.info("Try to delete user with id: " + id);
        repository.deleteById(id);
        log.info("User with id: " + id + " no longer exists");
    }
}
