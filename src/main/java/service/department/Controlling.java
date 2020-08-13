package service.department;

import service.DbRequest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controlling implements DbRequest {
    public void getData(Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery(
                "SELECT DISTINCT Departments.department_name " +
                        "FROM Job_history " +
                        "INNER JOIN Departments ON Job_history.department_id = Departments.department_id " +
                        "INNER JOIN Employees ON Job_history.employee_id = Employees.employee_id " +
                        "INNER JOIN Jobs ON Job_history.job_id = Jobs.job_id " +
                        "WHERE (Employees.last_name = 'Kowalski' OR Employees.last_name = 'Nowak') " +
                        "AND Employees.salary < Jobs.max_salary - (Jobs.max_salary * 25 / 100) " +
                        "ORDER BY Departments.department_name ASC");

        while(rs.next()){
            String departmentName = rs.getString("department_name");
            System.out.println(departmentName);
        }
    }
}
