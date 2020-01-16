package com.factory.factoryviewdetails.controller;

import com.factory.factoryviewdetails.model.ApplicationModel;
import com.factory.factoryviewdetails.service.ApplicationViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: Amit
 * Date: 02-01-2020
 */
@RestController
@RequestMapping("View")
public class ApplicationViewController {
    
    @Autowired
    ApplicationViewService applicationViewService;
    
    @GetMapping(value = "/GetAllApplicationsDetails", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ApplicationModel>> getAllApplicationDetails(){
        List<ApplicationModel> applicationList = applicationViewService.getAllApplicationDetails();
        return new ResponseEntity<>(applicationList, HttpStatus.OK);
    }

    @GetMapping(value = "/GetSingleApplicationsDetails", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ApplicationModel>> getSingleApplicationsDetails(@RequestParam("id") int id){
        List<ApplicationModel> applicationList = applicationViewService.getSingleApplicationDetailsById(id);
        return new ResponseEntity<>(applicationList, HttpStatus.OK);
    }
}
