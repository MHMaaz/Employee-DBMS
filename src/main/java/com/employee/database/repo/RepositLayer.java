package com.employee.database.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.employee.database.model.EmployeeRegisterar;

@Repository
public class RepositLayer {
    JdbcTemplate jdbc = new JdbcTemplate();

    public void Save(EmployeeRegisterar employData){
        String sql = "insert into EmployeeRegisterar(employee_id, employee_name, employee_salary, employee_on_site) values (?,?,?,?)";
        jdbc.update(sql, employData.getEmployee_id(), employData.getEmployee_name(), employData.getEmployee_salary(), employData.getEmployee_on_site());
    }

    public List getRows(){
        RowMapper<EmployeeRegisterar> rowMapper = new RowMapper<>() {
            @Override
            public EmployeeRegisterar mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                EmployeeRegisterar ed = new EmployeeRegisterar();
                ed.setEmployee_id(rs.getInt(1));
                ed.setEmployee_name(rs.getString(2));
                ed.setEmployee_salary(rs.getInt(3));
                ed.setEmployee_on_site(rs.getString(4));
                return ed;
            }
        };
        String sql = "select * from EmployeeRegisterar";
        List<EmployeeRegisterar> foundRows = jdbc.query(sql, rowMapper);
        return foundRows;
    }

    
    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
}
