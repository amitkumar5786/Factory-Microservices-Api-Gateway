package com.factory.factoryinsertdetails.dao;

import com.factory.factoryinsertdetails.model.ApplicationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Author: Amit
 * Date: 02-01-2020
 */

@Repository
public class ApplicationInsertDaoImpl implements ApplicationInsertDao {
    
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertApplicationDetailsInDb(ApplicationModel applicationModel) {
        int id = applicationModel.getId();
        String appName = applicationModel.getApplicationName();
        String appType = applicationModel.getApplicationType();
        String appDescription = applicationModel.getApplicationDescription();
        String createdDate = applicationModel.getCreatedDate();
        Object[] params = {id, appName, appType, appDescription, createdDate};
        String query = "insert into applications (id, application_name, application_type, application_description, created_date) values (?,?,?,?,?)";
        return jdbcTemplate.update(query, params);
    }
}
