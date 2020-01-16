package com.factory.factoryapigatway.model;

/**
 * Author: Amit
 * Date: 04-01-2020
 */
public class AccessTokenMapper {
    private String access_token;
    private int id;
    private String name;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
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
