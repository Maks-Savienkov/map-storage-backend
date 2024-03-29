package com.badassuniverse.mapstoragebackend.repo;

import com.badassuniverse.mapstoragebackend.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {

}
