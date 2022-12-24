/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.ResultSet;

/**
 *
 * @author otnas
 */
public class Collector {

    private static final MysqlDataSource dataSource = new MysqlDataSource();
    
    public Collector() {
        DBConnection conn = new DBConnection();
        conn.dbConn(dataSource);
    }
    
    public static void main(String[] args) {
        try {
            Connection conn = dataSource.getConnection();
            System.out.println("Koneksi berhasil");

            // User
            System.out.println("User");
            insertIntoUsers(conn);

            // COMPANIES
            System.out.println("Company");
            insertIntoCompanies(conn);

            // DEPARTEMENTS
            System.out.println("Department");
            insertIntoDepartement(conn);

            // Category
            System.out.println("Category");
            insertIntoCategory(conn);

            // Item
            System.out.println("Item");
            insertIntoItems(conn);

            // Employees
            System.out.println("Employee");
            insertIntoEmployees(conn);

            // Issues
            System.out.println("Issue");
            insertIntoIssues(conn);
            
            // Transaction
            System.out.println("Transaction");
            insertIntoTransaction(conn);
        } catch (SQLException ex) {
            System.out.println("Eksepsi akses data: " + ex.getMessage());
        }
    }

    private static void insertIntoUsers(Connection conn) throws SQLException {
        String kueri = "INSERT INTO users("
                + "username, "
                + "password, "
                + "created_at, "
                + "updated_at) "
                + "VALUES(?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setString(1, "Panji Dwi Satrio");
        ps.setString(2, "panjidwi123");

        Timestamp tmp = new Timestamp(System.currentTimeMillis());

        ps.setTimestamp(3, tmp);
        ps.setTimestamp(4, tmp);

        int rowAffected = ps.executeUpdate();

        if (rowAffected > 0) {
            System.out.println("Insert Success");
        } else {
            System.out.println("Insert Failed");
        }
        
        ps.close();
    }

    private static void insertIntoCategory(Connection conn) throws SQLException {
        String kueri = "INSERT INTO categories("
                + "name, "
                + "created_at, "
                + "updated_at) "
                + "VALUES (?,?,?)";
        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setString(1, "Alat Makan");

        Timestamp tmp = new Timestamp(System.currentTimeMillis());

        ps.setTimestamp(2, tmp);
        ps.setTimestamp(3, tmp);

        int rowAffected = ps.executeUpdate();

        if (rowAffected > 0) {
            System.out.println("Insert Success");
        } else {
            System.out.println("Insert Failed");
        }

        ps.close();
    }

    private static void insertIntoCompanies(Connection conn) throws SQLException {
        String kueri = "INSERT INTO companies("
                + "name, "
                + "address, "
                + "email, "
                + "phone, "
                + "created_at, "
                + "updated_at) "
                + "VALUES(?,?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setString(1, "PT. Jaya mandiri");
        ps.setString(2, "Bandung");
        ps.setString(3, "jaya@mandiri.com");
        ps.setString(4, "080808080");

        Timestamp tmp = new Timestamp(System.currentTimeMillis());

        ps.setTimestamp(5, tmp);
        ps.setTimestamp(6, tmp);

        int rowAffected = ps.executeUpdate();

        if (rowAffected > 0) {
            System.out.println("Insert Success");
        } else {
            System.out.println("Insert Failed");
        }
        
        ps.close();
    }

    private static void insertIntoDepartement(Connection conn) throws SQLException {
        String kueri = "INSERT INTO departments("
                + "name, "
                + "created_at, "
                + "updated_at) "
                + "VALUES(?,?,?)";

        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setString(1, "Marketing");

        Timestamp tmp = new Timestamp(System.currentTimeMillis());

        ps.setTimestamp(2, tmp);
        ps.setTimestamp(3, tmp);

        int rowAffected = ps.executeUpdate();

        if (rowAffected > 0) {
            System.out.println("Insert Success");
        } else {
            System.out.println("Insert Failed");
        }
        
        ps.close();
    }

    private static void insertIntoItems(Connection conn) throws SQLException {
        String kueri = "INSERT INTO items("
                + "item_code, "
                + "category_id, "
                + "name, "
                + "company_id, "
                + "quantity, "
                + "low_stock_level, "
                + "created_at, "
                + "updated_at) "
                + "VALUES(?,?,?,?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setString(1, "B001");
        ps.setInt(2, 1);
        ps.setString(3, "Indomie");
        ps.setInt(4, 2);
        ps.setInt(5, 100);
        ps.setInt(6, 10);

        Timestamp tmp = new Timestamp(System.currentTimeMillis());

        ps.setTimestamp(7, tmp);
        ps.setTimestamp(8, tmp);

        int rowAffected = ps.executeUpdate();

        if (rowAffected > 0) {
            System.out.println("Insert Success");
        } else {
            System.out.println("Insert Failed");
        }
        
        ps.close();
    }

    private static void insertIntoIssues(Connection conn) throws SQLException {
        String kueri = "INSERT INTO issues("
                + "item_id, "
                + "employee_id, "
                + "issue_by, "
                + "quantity, "
                + "created_at, "
                + "updated_at) "
                + "VALUES(?,?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setInt(1, 1);
        ps.setInt(2, 1);
        ps.setString(3, "Andi");
        ps.setInt(4, 10);

        Timestamp tmp = new Timestamp(System.currentTimeMillis());

        ps.setTimestamp(5, tmp);
        ps.setTimestamp(6, tmp);

        int rowAffected = ps.executeUpdate();

        if (rowAffected > 0) {
            System.out.println("Insert Success");
        } else {
            System.out.println("Insert Failed");
        }
        
        ps.close();
    }

    private static void insertIntoEmployees(Connection conn) throws SQLException {
        String kueri = "INSERT INTO issues("
                + "nik, "
                + "name, "
                + "department_id, "
                + "created_at, "
                + "updated_at) "
                + "VALUES(?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setString(1, "123456789");
        ps.setString(2, "Agus");
        ps.setInt(3, 1);

        Timestamp tmp = new Timestamp(System.currentTimeMillis());

        ps.setTimestamp(4, tmp);
        ps.setTimestamp(5, tmp);

        int rowAffected = ps.executeUpdate();

        if (rowAffected > 0) {
            System.out.println("Insert Success");
        } else {
            System.out.println("Insert Failed");
        }
        
        ps.close();
    }

    private static void insertIntoTransaction(Connection conn) throws SQLException {
        String kueri = "INSERT INTO transactions("
                + "quantity, "
                + "item_id, "
                + "action, "
                + "company_id, "
                + "created_at, "
                + "updated_at) "
                + "VALUES(?,?,?,?,?,?)";
        
        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setInt(1, 10);
        ps.setInt(2, 1);
        ps.setString(3, "Menjual");
        ps.setInt(4, 1);
        
        Timestamp tmp = new Timestamp(System.currentTimeMillis());
        
        ps.setTimestamp(5, tmp);
        ps.setTimestamp(6, tmp);
    }
}
