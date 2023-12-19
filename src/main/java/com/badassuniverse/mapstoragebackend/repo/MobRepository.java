package com.badassuniverse.mapstoragebackend.repo;

import com.badassuniverse.mapstoragebackend.model.Mob;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobRepository extends CrudRepository<Mob, Integer> {

}
