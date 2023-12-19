package com.badassuniverse.mapstoragebackend.repo;

import com.badassuniverse.mapstoragebackend.model.PhysicsItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicsItemRepository extends CrudRepository<PhysicsItem, Integer> {

}
