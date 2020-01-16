package com.factory.factoryinsertdetails.service;

import com.factory.factoryinsertdetails.dao.ApplicationInsertDao;
import com.factory.factoryinsertdetails.model.ApplicationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: Amit
 * Date: 02-01-2020
 */

@Service
public class ApplicationInsertServiceImpl implements ApplicationInsertService {
    
    @Autowired
    ApplicationInsertDao applicationInsertDao;
    
    @Override
    public int insertApplicationDetails(ApplicationModel applicationModel) {
        return applicationInsertDao.insertApplicationDetailsInDb(applicationModel);
    }
}
