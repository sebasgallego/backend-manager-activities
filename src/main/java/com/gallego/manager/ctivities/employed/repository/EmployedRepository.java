package com.gallego.manager.ctivities.employed.repository;

import com.gallego.manager.ctivities.employed.model.Employed;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EmployedRepository extends MongoRepository<Employed, String> {
    Employed findItemByEmail(String email);

    Optional<Employed> findById(String id);

    List<Employed> findAll();
}