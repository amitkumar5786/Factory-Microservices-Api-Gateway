package com.factory.factorydeletedetails.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Author: Amit
 * Date: 03-01-2020
 */

@Repository
public class ApplicationDeleteDaoImpl implements ApplicationDeleteDao {
    
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int getDeleteAllApplicationFromDb() {
        return jdbcTemplate.update("delete from applications");
    }

    @Override
    public int getDeleteApplicationByIdFromDb(int id) {
        Object[] params = {id};
        return jdbcTemplate.update("delete from applications where id=?", params);
    }
}
