package com.factory.factoryviewdetails.dao;

import com.factory.factoryviewdetails.model.ApplicationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Author: Amit
 * Date: 02-01-2020
 */

@Repository
public class ApplicationViewDaoImpl implements ApplicationViewDao {
    
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ApplicationModel> getAllApplicationDetailsFromDb() {
        String query = "select * from applications";
        return jdbcTemplate.query(query, new RowMapper<ApplicationModel>() {
            @Override
            public ApplicationModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                ApplicationModel applicationModel = new ApplicationModel();
                applicationModel.setId(rs.getInt("id"));
                applicationModel.setApplicationName(rs.getString("application_name"));
                applicationModel.setApplicationType(rs.getString("application_type"));
                applicationModel.setApplicationDescription(rs.getString("application_description"));
                applicationModel.setCreatedDate(rs.getString("created_date"));
                return applicationModel;
            }
        });
    }

    @Override
    public List<ApplicationModel> getSingleApplicationDetailsByIdFromDb(int id) {
        String query = "select * from applications where id=?";
        Object[] param = {id};
        return jdbcTemplate.query(query, param, new RowMapper<ApplicationModel>() {
            @Override
            public ApplicationModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                ApplicationModel applicationModel = new ApplicationModel();
                applicationModel.setId(rs.getInt("id"));
                applicationModel.setApplicationName(rs.getString("application_name"));
                applicationModel.setApplicationType(rs.getString("application_type"));
                applicationModel.setApplicationDescription(rs.getString("application_description"));
                applicationModel.setCreatedDate(rs.getString("created_date"));
                return applicationModel;
            }
        });
    }
}
