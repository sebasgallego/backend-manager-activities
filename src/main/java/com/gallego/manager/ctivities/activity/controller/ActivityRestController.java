package com.gallego.manager.ctivities.activity.controller;

import com.gallego.manager.ctivities.activity.data.Status;
import com.gallego.manager.ctivities.activity.data.StatusMessage;
import com.gallego.manager.ctivities.activity.model.Activity;
import com.gallego.manager.ctivities.activity.service.ActivityService;
import com.gallego.manager.ctivities.core.DateUtils;
import com.gallego.manager.ctivities.employed.model.Employed;
import com.gallego.manager.ctivities.employed.service.EmployedService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/activity")
public class ActivityRestController {

    private final ActivityService activityService;
    private final EmployedService employedService;
    StatusMessage[] statusesM = StatusMessage.values();

    DateUtils dateUtils = new DateUtils();

    public ActivityRestController(ActivityService activityService, EmployedService employedService) {
        this.activityService = activityService;
        this.employedService = employedService;
    }

    @CrossOrigin
    @PostMapping(value = "/finished")
    public ResponseEntity<?> finished(@RequestBody Activity new_activity) {
        new_activity.setStatus_id(Status.FINISHED.getValue());
        new_activity.setStatus(statusesM[Status.FINISHED.getValue()].getValue());
        activityService.save(new_activity);
        Map<String, Object> rtn = new LinkedHashMap<>();
        rtn.put("status", true);
        rtn.put("message", "Finalizada correctamente");
        return new ResponseEntity<>(rtn, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/edit")
    public ResponseEntity<?> edit(@RequestBody Activity new_activity) {
        new_activity.setStatus_id(Status.ACTIVATE.getValue());
        new_activity.setStatus(statusesM[Status.ACTIVATE.getValue()].getValue());
        activityService.save(new_activity);
        Map<String, Object> rtn = new LinkedHashMap<>();
        rtn.put("status", true);
        rtn.put("message", "Actualizado correctamente");
        return new ResponseEntity<>(rtn, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/date_star")
    public ResponseEntity<?> assignedDate(@RequestBody Activity new_activity) {
        new_activity.setStatus_id(Status.ACTIVATE.getValue());
        new_activity.setStatus(statusesM[Status.ACTIVATE.getValue()].getValue());
        activityService.save(new_activity);
        Map<String, Object> rtn = new LinkedHashMap<>();
        rtn.put("status", true);
        rtn.put("message", "Fecha guardada correctamente");
        return new ResponseEntity<>(rtn, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/assigned")
    public ResponseEntity<?> assigned(@RequestBody Activity new_activity) {
        new_activity.setStatus_id(Status.ASSIGNED.getValue());
        new_activity.setStatus(statusesM[Status.ASSIGNED.getValue()].getValue());
        activityService.save(new_activity);
        Map<String, Object> rtn = new LinkedHashMap<>();
        rtn.put("status", true);
        rtn.put("message", "Asignado correctamente");
        return new ResponseEntity<>(rtn, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody Activity new_activity) {
        String message = "Exito al guardar actividad";
        boolean status = true;
        Activity activity = activityService.findItemByName(new_activity.getName());
        if (activity != null) {
            status = false;
            message = "Actividad ya se encuentra registrada";
        } else {
            new_activity.setStatus_id(Status.PENDING.getValue());
            new_activity.setStatus(statusesM[Status.PENDING.getValue()].getValue());
            activityService.save(new_activity);
        }
        Map<String, Object> rtn = new LinkedHashMap<>();
        rtn.put("status", status);
        rtn.put("message", message);
        return new ResponseEntity<>(rtn, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/delete")
    public ResponseEntity<?> delete(@RequestBody Activity activity) {
        activityService.delete(activity);
        Map<String, Object> rtn = new LinkedHashMap<>();
        rtn.put("status", true);
        rtn.put("message", "Eliminado correctamente");
        return new ResponseEntity<>(rtn, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/all")
    public ResponseEntity<?> all() {
        List<Activity> listResponse = new ArrayList<>();
        for (Activity a : activityService.findAll()) {
            if (a.getEmployees_id() != null) {
                //Check employed assigned
                Optional<Employed> employed = employedService.findById(a.getEmployees_id());
                a.setName_employed(employed.get().getName() + " " + employed.get().getLastName());
                //Check delay days
                if (a.getStart_date() != null && !a.getStart_date().isBlank())
                    a.setDelay_days(dateUtils.checkDifferenceDays(a.getStart_date()));
                else a.setDelay_days(0);
            }
            listResponse.add(a);
        }
        return new ResponseEntity<>(listResponse, HttpStatus.OK);
    }
}
