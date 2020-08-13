package service.department;

import service.DbRequest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookKeeping implements DbRequest {
    public void getData(Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery(
                "SELECT Employees.last_name " +
                        "FROM Job_history " +
                        "INNER JOIN(SELECT * FROM Employees) Employees ON Job_history.employee_id = Employees.employee_id " +
                        "INNER JOIN Departments ON Job_history.department_id = Departments.department_id " +
                        "WHERE Departments.department_name = 'DRK' " +
                        "GROUP BY Employees.last_name, Employees.first_name " +
                        "ORDER BY Employees.last_name ASC, Employees.first_name ASC");

        while(rs.next()){
            String lastName = rs.getString("last_name");
            System.out.println(lastName);
        }
    }
}
