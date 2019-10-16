package mx.itesm.testing.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConnection {
	public static Connection getConnection(String dbName) throws SQLException{
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String ipAddress = "localhost",port = "3306",user  = "root" ,password  = "";
            connection = DriverManager.getConnection("jdbc:mysql://".concat(ipAddress).concat(":").concat(port).concat("/").concat(dbName).concat("?useSSL=false"), user, password);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
	public static Connection getConnection(String dbName, String user, String password) throws SQLException{
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String ipAddress = "localhost",port = "3306";
            connection = DriverManager.getConnection("jdbc:mysql://".concat(ipAddress).concat(":").concat(port).concat("/").concat(dbName).concat("?useSSL=false"), user, password);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
