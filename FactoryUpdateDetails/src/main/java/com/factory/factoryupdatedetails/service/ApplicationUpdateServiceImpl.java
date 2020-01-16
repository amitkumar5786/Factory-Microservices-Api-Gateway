package com.factory.factoryupdatedetails.service;

import com.factory.factoryupdatedetails.dao.ApplicationUpdateDao;
import com.factory.factoryupdatedetails.model.ApplicationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: Amit
 * Date: 03-01-2020
 */

@Service
public class ApplicationUpdateServiceImpl implements ApplicationUpdateService {
    
    @Autowired
    ApplicationUpdateDao applicationUpdateDao;
    
    @Override
    public int getUpdateApplicationDetailsById(ApplicationModel applicationModel) {
        return applicationUpdateDao.getUpdateApplicationDetailsByIdInDb(applicationModel);
    }
}
