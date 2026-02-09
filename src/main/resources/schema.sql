create table EmployeeRegisterar (
    employee_id int primary key,
    employee_name varchar(80),
    employee_salary int,
    employee_on_site enum('Yes', 'No') default 'No'
);