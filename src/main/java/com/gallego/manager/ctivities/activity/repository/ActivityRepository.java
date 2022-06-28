package com.gallego.manager.ctivities.activity.repository;

import com.gallego.manager.ctivities.activity.model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ActivityRepository extends MongoRepository<Activity, String> {

    Activity findItemByName(String name);

    List<Activity> findAll();

}