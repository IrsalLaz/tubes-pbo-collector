/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author panji
 */
public class DBConnection {
    public Connection dbConn() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        String DB_URL = "jdbc:mysql://localhost:3306/collector";
        String username = "root";
        String password = "";

        dataSource.setURL(DB_URL);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        
        Connection conn = dataSource.getConnection();
        return conn;
    }
}
