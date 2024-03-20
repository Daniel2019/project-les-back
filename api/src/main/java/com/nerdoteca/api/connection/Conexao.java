package com.nerdoteca.api.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static Connection getConnection() throws Exception{
        Connection con = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fatec", "root", "usbw");
        con.setAutoCommit(false);
        return con;
    }

}
