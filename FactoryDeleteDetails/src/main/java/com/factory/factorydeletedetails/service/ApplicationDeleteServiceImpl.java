package com.factory.factorydeletedetails.service;

import com.factory.factorydeletedetails.dao.ApplicationDeleteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: Amit
 * Date: 03-01-2020
 */

@Service
public class ApplicationDeleteServiceImpl implements ApplicationDeleteService {
    
    @Autowired
    ApplicationDeleteDao applicationDeleteDao;
    
    @Override
    public int getDeleteAllApplication() {
        return applicationDeleteDao.getDeleteAllApplicationFromDb();
    }

    @Override
    public int getDeleteApplicationById(int id) {
        return applicationDeleteDao.getDeleteApplicationByIdFromDb(id);
    }
}
