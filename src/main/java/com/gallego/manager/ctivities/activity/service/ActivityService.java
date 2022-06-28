package com.gallego.manager.ctivities.activity.service;

import com.gallego.manager.ctivities.activity.model.Activity;
import com.gallego.manager.ctivities.employed.model.Employed;

import java.util.List;

public interface ActivityService {
    Activity save(Activity activity);

    void delete(Activity activity);

    Activity findItemByName(String nameActivity);

    List<Activity> findAll();

}
