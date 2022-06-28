package com.gallego.manager.ctivities.employed.controller;

import com.gallego.manager.ctivities.employed.model.Employed;
import com.gallego.manager.ctivities.employed.service.EmployedService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/employed")
public class EmployedRestController {

    private final EmployedService employedService;

    public EmployedRestController(EmployedService employedService) {
        this.employedService = employedService;
    }

    @CrossOrigin
    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody Employed new_activity) {
        String message = "Exito al guardar empleado";
        boolean status = true;
        Employed employed = employedService.findItemByEmail(new_activity.getEmail());
        if (employed != null) {
            status = false;
            message = "Empleado ya se encuentra registrado";
        } else {
            employedService.save(new_activity);
        }
        Map<String, Object> rtn = new LinkedHashMap<>();
        rtn.put("status", status);
        rtn.put("message", message);
        return new ResponseEntity<>(rtn, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/delete")
    public ResponseEntity<?> delete(@RequestBody Employed employed) {
        employedService.delete(employed);
        Map<String, Object> rtn = new LinkedHashMap<>();
        rtn.put("status", true);
        rtn.put("message", "Eliminado correctamente");
        return new ResponseEntity<>(rtn, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/all")
    public ResponseEntity<?> all() {
        return new ResponseEntity<>(employedService.findAll(), HttpStatus.OK);
    }

}
