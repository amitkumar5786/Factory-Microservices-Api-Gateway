package com.factory.factoryauthorizationserver.model;

import org.springframework.security.core.GrantedAuthority;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Author: Amit
 * Date: 02-01-2020
 */
public class UserModel {
    private int id;
    private String name;
    private String emailId;
    private String password;
    private Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();

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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<GrantedAuthority> getGrantedAuthoritiesList() {
        return grantedAuthoritiesList;
    }

    public void setGrantedAuthoritiesList(Collection<GrantedAuthority> grantedAuthoritiesList) {
        this.grantedAuthoritiesList = grantedAuthoritiesList;
    }
}
