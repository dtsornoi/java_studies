package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getDBConnection(){
        Connection connection = null;

        String dbUrl = "jdbc:mysql://localhost:3306/jdbc_movies?serverTimezone=UTC";
        String driverJDBC = "com.mysql.cj.jdbc.Driver";
        String userDB = "root";
        String passwordDB = "";

        try {
            Class.forName(driverJDBC);
            if (connection == null || connection.isClosed()) connection = DriverManager.getConnection(dbUrl, userDB, passwordDB);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;
    }
}
