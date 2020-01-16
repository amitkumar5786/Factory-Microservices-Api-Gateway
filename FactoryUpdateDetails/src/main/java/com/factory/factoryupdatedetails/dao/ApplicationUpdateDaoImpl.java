package com.factory.factoryupdatedetails.dao;

import com.factory.factoryupdatedetails.model.ApplicationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Author: Amit
 * Date: 03-01-2020
 */

@Repository
public class ApplicationUpdateDaoImpl implements ApplicationUpdateDao {
    
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int getUpdateApplicationDetailsByIdInDb(ApplicationModel applicationModel) {
        int id = applicationModel.getId();
        String appName = applicationModel.getApplicationName();
        String appType = applicationModel.getApplicationType();
        String appDescription = applicationModel.getApplicationDescription();
        String createdDate = applicationModel.getCreatedDate();
        Object[] params = {appName, appType, appDescription, createdDate, id};
        String query = "update applications set application_name=?, application_type=?, application_description=?, created_date=? where id=?";
        return jdbcTemplate.update(query, params);
    }
}
