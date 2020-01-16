package com.factory.factoryauthorizationserver.dao;

import com.factory.factoryauthorizationserver.model.UserModel;

/**
 * Author: Amit
 * Date: 02-01-2020
 */
public interface OAuthDao {
    public UserModel getUserDetails(String emailId);
}
