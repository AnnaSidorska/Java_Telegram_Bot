package Core;

import java.sql.*;

public class DataBase {
    private static final String url = "jdbc:mysql://localhost/AAAAAAAAA";
    private static final String user = "root";
    private static final String password = "password";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

//    public static Connection getCon() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            con = DriverManager.getConnection(url, user, password);
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
//            e.printStackTrace();
//        }
//        return con;
//    }
}
