package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface DbRequest {
    public void getData(Statement statement) throws SQLException;
}
