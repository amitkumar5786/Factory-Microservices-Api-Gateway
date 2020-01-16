package com.factory.factoryauthorizationserver.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Author: Amit
 * Date: 02-01-2020
 */
public class CustomerUserModel extends User {
    private int id;
    private String name;

    public CustomerUserModel(UserModel userModel) {
        super(userModel.getEmailId(), userModel.getPassword(), userModel.getGrantedAuthoritiesList());
        this.id = userModel.getId();
        this.name= userModel.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
