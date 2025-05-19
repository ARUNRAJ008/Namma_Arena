package com.project.test.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.test.DTO.UserLoginDTO;

@Repository
public class UserLoginRepository 
{
	@Autowired
    private JdbcTemplate jdbcTemplate;

    public List<UserLoginDTO> getAllUsers() 
    {
        String sql = "SELECT username, password FROM userlogin";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new UserLoginDTO(rs.getString("username"), rs.getString("password"))
        );
    }
    
    public int updateUser(UserLoginDTO user) {
        String sql = "INSERT into userlogin values(?,?)";
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
    }
}
