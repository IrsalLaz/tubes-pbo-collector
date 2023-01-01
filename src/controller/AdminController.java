package controller;

import java.sql.*;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.util.ArrayList;
import model.Admin;
//import view.auth.Login;
import javax.swing.*;
import java.awt.*;
import view.auth.Login;
//import java.sql.Timestamp;
import view.main.Home;

public class AdminController {

    private static final ArrayList<Admin> adminList = new ArrayList<>();
    private Connection conn;
    private final DBConnection db = new DBConnection();

    public void login(
            JFrame jFrame,
            Component parentComponent,
            String textName,
            String textPass
    ) {
        try {
            conn = db.dbConn();
            String query = ""
                    + "SELECT a.password, e.employee_name FROM admins a "
                    + "JOIN employees e ON  e.nip = a.nip "
                    + "WHERE e.employee_name=?";
            String employee_name = "";
            String pass = "";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, textName);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                employee_name = rs.getString("employee_name");
                pass = rs.getString("password");
            }

            if (!textName.equals(employee_name) || !textPass.equals(pass)) {
                String message = "Pastikan username dan password yang anda masukan benar";
                validation(parentComponent, message);
            } else if (textName.equals("")
                    || textName.equals("Silahkan masukan nama...")
                    || textPass.equals("")
                    || textPass.equals("Silahkan masukan password...")) {
                String message = "Silahkan isi data anda dengan benar";
                validation(parentComponent, message);
            } else {
                JOptionPane.showMessageDialog(
                        parentComponent,
                        "Hello, " + employee_name,
                        "Login",
                        JOptionPane.INFORMATION_MESSAGE
                );

                goToHome(jFrame);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void logout(
            JFrame jFrame,
            Component parentComponent,
            String current_user
    ) {
        JOptionPane.showMessageDialog(
                parentComponent, 
                current_user + " Berhasil logout",
                "Login Page",
                1
        );
        
        goToLogin(jFrame);
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
    
    // editable size frame
    private void goToHome(JFrame jFrame) {
        Home home = new Home();

        jFrame.dispose();
        home.setSize(972, 632);
        home.setVisible(true);
    }

    public void addAdmin(Admin admin) {
        adminList.add(admin);
    }

    public ArrayList<Admin> getAdminList() {
        return adminList;
    }
    
    // editable size frame
    private void goToLogin(JFrame jFrame) {
        Login login = new Login();
        
        jFrame.dispose();
        login.setSize(972, 632);
        login.setVisible(true);
    }
}
