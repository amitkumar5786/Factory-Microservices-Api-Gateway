package com.factory.factoryviewdetails.service;

import com.factory.factoryviewdetails.dao.ApplicationViewDao;
import com.factory.factoryviewdetails.model.ApplicationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Amit
 * Date: 02-01-2020
 */

@Service
public class ApplicationViewServiceImpl implements ApplicationViewService {
    
    @Autowired
    ApplicationViewDao applicationViewDao;
    
    @Override
    public List<ApplicationModel> getAllApplicationDetails() {
        return applicationViewDao.getAllApplicationDetailsFromDb();
    }

    @Override
    public List<ApplicationModel> getSingleApplicationDetailsById(int id) {
        return applicationViewDao.getSingleApplicationDetailsByIdFromDb(id);
    }
}
