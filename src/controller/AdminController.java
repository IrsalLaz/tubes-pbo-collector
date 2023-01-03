package controller;

import java.sql.*;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.util.ArrayList;
import model.Admin;
//import view.auth.Login;
import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import view.auth.Login;
//import java.sql.Timestamp;
import view.main.Home;

public class AdminController {

    private static final ArrayList<Admin> adminList = new ArrayList<>();
    private Connection conn;
    private final DBConnection db = new DBConnection();

    public void insertAdmin(
            String textPassword,
            int textStatus,
            String textName,
            String textNip,
            int textIdDepartment,
            String textDepartmentName
    ) {
        try {
            conn = db.dbConn();
            String insertQuery = "INSERT INTO admins("
                    + "nip, "
                    + "password, "
                    + "created_at, "
                    + "updated_at) "
                    + "VALUES(?,?,?,?)";

            PreparedStatement psAdmin = conn.prepareStatement(insertQuery);
            psAdmin.setString(1, textNip);
            psAdmin.setString(2, hashPassword(textPassword));

            Timestamp tmpAdmin = new Timestamp(System.currentTimeMillis());

            psAdmin.setTimestamp(3, tmpAdmin);
            psAdmin.setTimestamp(4, tmpAdmin);
            psAdmin.executeUpdate();

            addAdmin(new Admin(
                    textPassword,
                    textStatus,
                    textName,
                    textNip,
                    textIdDepartment,
                    textDepartmentName
            ));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

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
            String employee_name;
            String pass;
            String password = hashPassword(textPass);

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, textName);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                employee_name = rs.getString("employee_name");
                pass = rs.getString("password");

                if (!textName.equals(employee_name) || !password.equals(pass)) {
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
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void logout(
            JFrame jFrame,
            Component parentComponent
    ) {
        JOptionPane.showMessageDialog(
                parentComponent,
                "Berhasil logout",
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
        home.setTitle("Collector");
        home.setSize(990, 720);
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

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

            // bytes to hex
            StringBuilder sb = new StringBuilder();
            for (byte b : hashInBytes) {
                sb.append(String.format("%02x", b));
            }
            
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
