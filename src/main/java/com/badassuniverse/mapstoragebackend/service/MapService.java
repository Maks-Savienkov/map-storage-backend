package com.badassuniverse.mapstoragebackend.service;

import com.badassuniverse.mapstoragebackend.dto.MapDto;
import com.badassuniverse.mapstoragebackend.exceptions.UserNotAuthorizedException;
import com.badassuniverse.mapstoragebackend.mapper.MapMapper;
import com.badassuniverse.mapstoragebackend.model.Map;
import com.badassuniverse.mapstoragebackend.model.User;
import com.badassuniverse.mapstoragebackend.repo.MapRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MapService {
    private final MapRepository repository;
    private final UserService userService;
    private final MapMapper mapper;

    public List<MapDto> getAll() {
        log.info("Getting all maps.");
        return ((List<Map>) repository.findAll()).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public MapDto create(MapDto mapDto) {
        log.info("Try to create new map");
        Map map = mapper.toModel(mapDto);
        repository.save(map);
        log.info("Map created with id: " + map.getId() + ".");
        return mapDto;
    }

    public void deleteById(Integer id) {
        log.info("Try to delete map with id: " + id);

        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getAuthorities();

        if (authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .noneMatch(x -> Objects.equals(x, "ROLE_ADMIN"))
        ) {
            MapDto mapDto = getById(id);
            if (Objects.nonNull(mapDto)) {
                Optional<User> userOptional = userService.findByUsername(username);
                if (userOptional.isPresent() && Objects.equals(userOptional.get().getId(), mapDto.getUserId())) {
                    repository.deleteById(id);
                } else {
                    throw new UserNotAuthorizedException("User don't has authority to delete this map.");
                }
            }
        }

        log.info("Map with id: " + id + " no longer exists");
    }

    public MapDto getById(Integer id) {
        log.info("Getting map with id: " + id);
        return mapper.toDTO(repository.findById(id).orElse(null));
    }

    public List<MapDto> getAllByUserId(Integer userId) {
        log.info("Getting all maps with userId: " + userId);
        return repository.findAllByUserId(userId).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
