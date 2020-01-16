package com.factory.factoryapigatway.controller;

import com.factory.factoryapigatway.model.AccessTokenMapper;
import com.factory.factoryapigatway.model.ApplicationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Author: Amit
 * Date: 03-01-2020
 */

@RestController
@RequestMapping("Factory")
public class ApplicationController {
    
    @Autowired
    RestTemplate restTemplate;
    
    @PreAuthorize("hasRole('Update')")
    @PutMapping(value = "/Update", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getUpdateApplicationDetails(@RequestBody ApplicationModel applicationModel){
        AccessTokenMapper accessTokenMapper = (AccessTokenMapper)
                ((OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails()).getDecodedDetails();
        System.out.println("accessTokenMapper id = " + accessTokenMapper.getId());
        System.out.println("accessTokenMapper name = " + accessTokenMapper.getName());
        
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<ApplicationModel> httpEntity = new HttpEntity<>(applicationModel, httpHeaders);
        return restTemplate.exchange("http://localhost:8084/FactoryUpdateDetails/Update/ApplicationDetails", HttpMethod.PUT, httpEntity, String.class).getBody();
    }
}
