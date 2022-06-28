package com.gallego.manager.ctivities.activity.service;

import com.gallego.manager.ctivities.activity.repository.ActivityRepository;
import com.gallego.manager.ctivities.activity.model.Activity;
import com.gallego.manager.ctivities.employed.model.Employed;
import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.include;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private MongoClient client;

    private static final String DatabaseName = "manager-db";
    private static final String CollectionName = "activities";


    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public Activity save(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public void delete(Activity activity) {
        activityRepository.delete(activity);
    }

    @Override
    public Activity findItemByName(String nameActivity) {
        return activityRepository.findItemByName(nameActivity);
    }

    @Override
    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

}
