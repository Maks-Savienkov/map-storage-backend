package com.badassuniverse.mapstoragebackend.repo;

import com.badassuniverse.mapstoragebackend.model.Facade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacadeRepository extends CrudRepository<Facade, Integer> {

}
