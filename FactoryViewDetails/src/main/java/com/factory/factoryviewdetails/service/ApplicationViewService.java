package com.factory.factoryviewdetails.service;

import com.factory.factoryviewdetails.model.ApplicationModel;

import java.util.List;

/**
 * Author: Amit
 * Date: 02-01-2020
 */
public interface ApplicationViewService {
    public List<ApplicationModel> getAllApplicationDetails();
    public List<ApplicationModel> getSingleApplicationDetailsById(int id);
}
