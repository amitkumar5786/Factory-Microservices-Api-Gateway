package com.factory.factoryauthorizationserver.service;

import com.factory.factoryauthorizationserver.dao.OAuthDao;
import com.factory.factoryauthorizationserver.model.CustomerUserModel;
import com.factory.factoryauthorizationserver.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Author: Amit
 * Date: 30-12-2019
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    OAuthDao oAuthDao;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = null;
        try{
            userModel = oAuthDao.getUserDetails(username);
            if(userModel != null && userModel.getId() != 0){
                CustomerUserModel customUser = new CustomerUserModel(userModel);
                return customUser;
            } else {
                throw new UsernameNotFoundException("Username : "+username+" was not found into the database");
            }
        } catch (Exception e){
            throw new UsernameNotFoundException("Username : "+username+" was not found into the database");
        }
    }
}