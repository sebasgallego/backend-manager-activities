package com.gallego.manager.ctivities.employed.service;

import com.gallego.manager.ctivities.employed.model.Employed;
import com.gallego.manager.ctivities.employed.repository.EmployedRepository;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployedServiceImpl implements EmployedService {

    private static final String DatabaseName = "manager-db";
    private static final String CollectionName = "activities";

    @Autowired
    private MongoClient client;
    @Autowired
    private EmployedRepository employedRepository;

    @Override
    public Employed save(Employed employed) {
        return employedRepository.save(employed);
    }

    @Override
    public void delete(Employed employed) {
        employedRepository.delete(employed);
    }

    @Override
    public Employed findItemByEmail(String nameEmployed) {
        return employedRepository.findItemByEmail(nameEmployed);
    }

    @Override
    public List<Employed> findAll() {
        return employedRepository.findAll();
    }

    @Override
    public Optional<Employed> findById(String employed_id) {
        return employedRepository.findById(employed_id);
    }

}
