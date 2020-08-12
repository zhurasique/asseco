import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@192.168.0.234:1521:xe", "system", "admin");
            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Jobs.job_title FROM Job_history INNER JOIN Jobs ON Job_history.job_id = Jobs.job_id");
            while(rs.next()){
                String last = rs.getString("job_title");

                System.out.println(last);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
