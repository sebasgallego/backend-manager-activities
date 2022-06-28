package com.gallego.manager.ctivities.employed.service;

import com.gallego.manager.ctivities.employed.model.Employed;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface EmployedService {

    Employed save(Employed employed);

    void delete(Employed employed);

    Employed findItemByEmail(String nameEmployed);


    List<Employed> findAll();

    Optional<Employed> findById(String employed_id);
}
