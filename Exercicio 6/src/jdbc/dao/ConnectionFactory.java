package jdbc.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {
        try {
            var conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/vendased?zeroDateTimeBehavior=CONVERT_TO_NULL&useTimezone=true&serverTimezone=UTC", "root", "usbw");
            return conn;

        }
        catch(Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
}