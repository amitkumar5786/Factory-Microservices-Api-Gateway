package com.factory.factoryupdatedetails.dao;

import com.factory.factoryupdatedetails.model.ApplicationModel;

/**
 * Author: Amit
 * Date: 03-01-2020
 */
public interface ApplicationUpdateDao {
    public int getUpdateApplicationDetailsByIdInDb(ApplicationModel applicationModel);
}
