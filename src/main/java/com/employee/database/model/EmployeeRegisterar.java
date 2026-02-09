package com.employee.database.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class EmployeeRegisterar {
    private int employee_id; // gotta be primary key
    private String employee_name;
    private int employee_salary;
    private String employee_on_site;
    public int getEmployee_id() {
        return employee_id;
    }
    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }
    public String getEmployee_name() {
        return employee_name;
    }
    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }
    public int getEmployee_salary() {
        return employee_salary;
    }
    public void setEmployee_salary(int employee_salary) {
        this.employee_salary = employee_salary;
    }
    public String getEmployee_on_site() {
        return employee_on_site;
    }
    public void setEmployee_on_site(String employee_on_site) {
        this.employee_on_site = employee_on_site;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" employee_id = ").append(employee_id);
        sb.append(" employee_name = ").append(employee_name);
        sb.append(" employee_salary = ").append(employee_salary);
        sb.append(" employee_on_site = ").append(employee_on_site);
        // sb.append('}');
        sb.append("\n");
        return sb.toString();
    } // to string is needed for data to be selected from the database otherwise, it'll print only the memory location which is the package name
    
}
