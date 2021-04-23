package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public static Connection getDBConnection() {
        Connection connection = null;
        // JDBC driver name and database URL
        String dbUrl = "jdbc:mysql://localhost:3306/sda_jdbc?serverTimezone=UTC" ;
        String driverJDBC = "com.mysql.cj.jdbc.Driver" ;
        // Database credentials
        String userDB = "root";
        String passwordDB = "dwmwh6x8xt477cpf";

        try {
            // Register JDBC driver
            Class.forName(driverJDBC);
            // Connect to database
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(dbUrl, userDB, passwordDB);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * This is an example how to close a connection, but it is not practical
     * Because you would have to open and close a lot, which will create problems
     * There is a better way, there has to be connection pool for a single user
     */

//    public static void closeConnection(){
//        try {
//            if (!getDBConnection().isClosed()) getDBConnection().close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
}
