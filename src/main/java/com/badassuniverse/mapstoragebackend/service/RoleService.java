package com.badassuniverse.mapstoragebackend.service;

import com.badassuniverse.mapstoragebackend.model.Role;
import com.badassuniverse.mapstoragebackend.repo.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole() {
        log.info("Getting role `USER`");
        return roleRepository.findByName("ROLE_USER").get();
    }
}
