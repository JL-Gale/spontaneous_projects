package com.jlgale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConector {
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String password = "4588";

    public Connection conexion() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url,user,password);
    }
}
