package com.hbm.reserva;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    public String driver = "com.mysql.jdbc.Driver";
    public String url = "jdbc:mysql://localhost/hotel";
    public String usuario = "root";
    public String senha = "BtRhEk10!";

    public Connection getConnectionFactory () throws SQLException {

        Connection conn = DriverManager.getConnection (url,usuario,senha);
        return conn;
    }
}