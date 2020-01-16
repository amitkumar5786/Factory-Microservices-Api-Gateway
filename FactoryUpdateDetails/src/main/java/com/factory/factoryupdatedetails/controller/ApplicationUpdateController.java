package com.factory.factoryupdatedetails.controller;

import com.factory.factoryupdatedetails.model.ApplicationModel;
import com.factory.factoryupdatedetails.service.ApplicationUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Amit
 * Date: 03-01-2020
 */

@RestController
@RequestMapping("Update")
public class ApplicationUpdateController {
    
    @Autowired
    ApplicationUpdateService applicationUpdateService;
    
    @PutMapping(value = "/ApplicationDetails", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> getUpdateApplicationDetails(@RequestBody ApplicationModel applicationModel){
        String response = "";
        int status = applicationUpdateService.getUpdateApplicationDetailsById(applicationModel);
        if(status>0){
            response = "success";
        } else {
            response = "failure";
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
