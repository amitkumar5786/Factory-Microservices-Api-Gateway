package com.factory.factorydeletedetails.controller;

import com.factory.factorydeletedetails.service.ApplicationDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;

/**
 * Author: Amit
 * Date: 03-01-2020
 */

@RestController
@RequestMapping("Delete")
public class ApplicationDeleteController {
    
    @Autowired
    ApplicationDeleteService applicationDeleteService;
    
    @DeleteMapping(value = "AllApplicationDetails", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> getDeleteAllApplications(){
        String response = "";
        int status = applicationDeleteService.getDeleteAllApplication();
        if(status>0){
            response = "success";
        } else {
            response = "failure";
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "ApplicationDetailsById", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> getDeleteAllApplications(@RequestParam("id") int id){
        String response = "";
        int status = applicationDeleteService.getDeleteApplicationById(id);
        if(status>0){
            response = "success";
        } else {
            response = "failure";
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
