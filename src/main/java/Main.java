import dbconfig.JDBCConnection;
import service.department.BookKeeping;
import service.department.Controlling;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(JDBCConnection.URL, JDBCConnection.user, JDBCConnection.password);
            Statement statement = conn.createStatement();

            BookKeeping bookKeeping = new BookKeeping();
            bookKeeping.getData(statement);

            Controlling controlling = new Controlling();
            controlling.getData(statement);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
