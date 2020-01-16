package com.factory.factoryviewdetails.dao;

import com.factory.factoryviewdetails.model.ApplicationModel;

import java.util.List;

/**
 * Author: Amit
 * Date: 02-01-2020
 */
public interface ApplicationViewDao {
    public List<ApplicationModel> getAllApplicationDetailsFromDb();
    public List<ApplicationModel> getSingleApplicationDetailsByIdFromDb(int id);
}
