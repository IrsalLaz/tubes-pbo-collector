/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tubes.pbo.collector;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author otnas
 */
public class TubesPboCollector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MysqlDataSource dataSource = new MysqlDataSource();

        String DB_URL = "jdbc:mysql://localhost:3306/collector";
        String username = "root";
        String password = "";

        dataSource.setURL(DB_URL);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        
        try {
            Connection conn = dataSource.getConnection();
            System.out.println("Koneksi berhasil");

            // COMPANIES
            // insertIntoCompanies(conn);

            // DEPARTEMENTS
            // insertIntoDepartement(conn);

            // ITEMS
//            insertIntoItems(conn);
            
            // Issues
//            insertIntoIssues(conn);
            
            // Employees
//            insertIntoEmployees(conn);

        } catch (SQLException ex) {
            System.out.println("Eksepsi akses data: " + ex.getMessage());
        }
    }
    
     private static void insertIntoCompanies(Connection conn) throws SQLException {
        String kueri = "INSERT INTO companies(id, name, address, email, phone, created_at, updated_at) VALUES(?,?,?,?,?,?,?)";
        
        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setInt(1, 1);
        ps.setString(2, "PT. Jaya mandiri");
        ps.setString(3, "Bandung");
        ps.setString(4, "jaya@mandiri.com");
        ps.setString(5, "080808080");

        Timestamp tmp = new Timestamp(System.currentTimeMillis());

        ps.setTimestamp(6, tmp);
        ps.setTimestamp(7, tmp);

        int rowAffected = ps.executeUpdate();
    }

    private static void insertIntoDepartement(Connection conn) throws SQLException {
        String kueri = "INSERT INTO departments(id, name, created_at, updated_at) VALUES(?,?,?,?)";
        
        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setInt(1, 1);
        ps.setString(2, "Marketing");

        Timestamp tmp = new Timestamp(System.currentTimeMillis());

        ps.setTimestamp(3, tmp);
        ps.setTimestamp(4, tmp);

        int rowAffected = ps.executeUpdate();

    }

    private static void insertIntoItems(Connection conn) throws SQLException {
        String kueri = "INSERT INTO items(id, item_code, category_id, name, company_id, quantity, low_stock_level, created_at, updated_at) VALUES(?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setInt(1, 1);
        ps.setString(2, "B001");
        ps.setInt(3, 1);
        ps.setString(4, "Indomie");
        ps.setInt(5, 2);
        ps.setInt(6, 100);
        ps.setInt(7, 10);

        Timestamp tmp = new Timestamp(System.currentTimeMillis());

        ps.setTimestamp(8, tmp);
        ps.setTimestamp(9, tmp);

        int rowAffected = ps.executeUpdate();
    }
    
    private static void insertIntoIssues(Connection conn) throws SQLException {
        String kueri = "INSERT INTO issues(id, item_id, employee_id, issue_by, quantity, created_at, updated_at) VALUES(?,?,?,?,?,?,?)";
        
        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setInt(1, 1);
        ps.setInt(2, 1);
        ps.setInt(3, 1);
        ps.setString(4, "Andi");
        ps.setInt(5, 10);
        
        Timestamp tmp = new Timestamp(System.currentTimeMillis());

        ps.setTimestamp(6, tmp);
        ps.setTimestamp(7, tmp);

        int rowAffected = ps.executeUpdate();
    }
    
    private static void insertIntoEmployees(Connection conn) throws SQLException {
        String kueri = "INSERT INTO issues(id, nik, name, department_id, created_at, updated_at) VALUES(?,?,?,?,?,?)";
        
        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setInt(1, 1);
        ps.setString(2, "123456789");
        ps.setString(3, "Agus");
        ps.setInt(4, 1);
        
        Timestamp tmp = new Timestamp(System.currentTimeMillis());

        ps.setTimestamp(5, tmp);
        ps.setTimestamp(6, tmp);

        int rowAffected = ps.executeUpdate();
    }
}
