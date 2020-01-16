package com.factory.factoryinsertdetails.dao;

import com.factory.factoryinsertdetails.model.ApplicationModel;

/**
 * Author: Amit
 * Date: 02-01-2020
 */
public interface ApplicationInsertDao {
    public int insertApplicationDetailsInDb(ApplicationModel applicationModel);
}
