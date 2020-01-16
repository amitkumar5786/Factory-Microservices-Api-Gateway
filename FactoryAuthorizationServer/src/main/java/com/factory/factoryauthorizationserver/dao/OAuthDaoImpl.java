package com.factory.factoryauthorizationserver.dao;

import com.factory.factoryauthorizationserver.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Author: Amit
 * Date: 02-01-2020
 */

@Repository
public class OAuthDaoImpl implements OAuthDao {
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Override
    public UserModel getUserDetails(String emailId) {
        Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
        
        List<UserModel> list = jdbcTemplate.query("SELECT * FROM users WHERE emailid=?", new String[]{emailId}, new RowMapper<UserModel>() {
                    @Override
                    public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                        UserModel userModel = new UserModel();
                        userModel.setEmailId(emailId);
                        userModel.setId(rs.getInt("id"));
                        userModel.setName(rs.getString("user_name"));
                        userModel.setPassword(rs.getString("password"));
                        return userModel;
                    }
                }
        );

        if(!list.isEmpty()){
            UserModel userModel = list.get(0);
            List<String> permissionList = jdbcTemplate.query("SELECT DISTINCT P.permission_name FROM permission P\n" +
                    "INNER JOIN assign_permission_to_role P_R ON P.ID=P_R.permission_id\n" +
                    "INNER JOIN role R ON R.ID=P_R.role_id\n" +
                    "INNER JOIN assign_users_to_role U_R ON U_R.role_id=R.id\n" +
                    "INNER JOIN users U ON U.id=U_R.user_id\n" +
                    "WHERE U.emailid=?", new String[]{emailId}, new RowMapper<String>() {
                @Override
                public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return "ROLE_"+rs.getString("permission_name");
                }
            });

            if(permissionList != null && !permissionList.isEmpty()){
                for(String permission: permissionList){
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission);
                    grantedAuthoritiesList.add(grantedAuthority);
                    userModel.setGrantedAuthoritiesList(grantedAuthoritiesList);
                }
            }
            return userModel;
        }
        return null;
    }
}
