/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.*;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.util.ArrayList;
import model.Admin;
//import view.auth.Login;
import javax.swing.*;
import java.awt.*;
//import java.sql.Timestamp;
import view.main.Home;

/**
 *
 * @author panji
 */
public class AdminController {

    private static final MysqlDataSource dataSource = new MysqlDataSource();
    private static final ArrayList<Admin> userList = new ArrayList<>();

    public AdminController() {
        DBConnection conn = new DBConnection();
        conn.dbConn(dataSource);
    }

    public void login(
            JFrame jFrame,
            Component parentComponent,
            String textName,
            String textPass
    ) {
        try {
            Connection conn = dataSource.getConnection();
            String query = "SELECT * FROM users WHERE username=?";
            String username = "";
            String pass = "";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, textName);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                username = rs.getString("username");
                pass = rs.getString("password");
            }

            if (!textName.equals(username) || !textPass.equals(pass)) {
                String message = "Pastikan username dan password yang anda masukan benar";
                validation(parentComponent, message);
            } else if (textName.equals("")
                    || textName.equals("Silahkan masukan nama...")
                    || textPass.equals("")
                    || textPass.equals("Pass")) {
                String message = "Silahkan isi data anda dengan benar";
                validation(parentComponent, message);
            } else {
                JOptionPane.showMessageDialog(
                        parentComponent,
                        "Hello, " + username,
                        "Login",
                        JOptionPane.INFORMATION_MESSAGE
                );

                goToHome(jFrame);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void validation(Component parentComponent, String message) {
        System.out.println("Debug message: " + message);
        JOptionPane.showMessageDialog(
                parentComponent,
                message,
                "Login",
                JOptionPane.ERROR_MESSAGE
        );
    }

    private void goToHome(JFrame jFrame) {
        Home home = new Home();

        jFrame.dispose();
        home.setSize(1920, 1080);
        home.setVisible(true);
    }

    public void addAdmin(Admin admin) {
        userList.add(admin);
    }

    public ArrayList<Admin> getUserList() {
        return userList;
    }
}
