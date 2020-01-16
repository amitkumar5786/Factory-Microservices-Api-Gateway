package com.factory.factoryinsertdetails.controller;

import com.factory.factoryinsertdetails.model.ApplicationModel;
import com.factory.factoryinsertdetails.service.ApplicationInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Amit
 * Date: 02-01-2020
 */

@RestController
@RequestMapping("Insert")
public class ApplicationInsertController {
    
    @Autowired
    ApplicationInsertService applicationInsertService;
    
    @PostMapping(value = "/ApplicationDetails", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> insertApplicationDetails(@RequestBody ApplicationModel applicationModel){
        String response = "";
        int status = applicationInsertService.insertApplicationDetails(applicationModel);
        if(status>0){
            response = "success";
        } else {
            response = "failure";
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
