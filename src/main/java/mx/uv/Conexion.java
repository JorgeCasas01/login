package mx.uv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static String url = "jdbc:mysql://127.0.0.1:3306/ejemplo80688";
    private static String driverName = "com.mysql.jdbc.Driver"; // com.mysql.cj.jdbc.Driver
    private static String username = "root";
    private static String password = "";
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(" SQL:" + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver:" + e);
        }
        return connection;
    }
}
