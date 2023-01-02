package controller;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Company;

public class CompanyController {

    private static final ArrayList<Company> companyList = new ArrayList<>();
    private Connection conn;
    private final DBConnection db = new DBConnection();

    public ArrayList<Company> getCompanyList() {
        return companyList;
    }

    // Create
    public void insertCompany(
            Component parentComponent,
            String textName,
            String textEmail,
            String textTelepon,
            String textAlamat,
            DefaultTableModel tableModel
    ) {
        try {
            conn = db.dbConn();
            String name = "";

            if (!companyList.isEmpty()) {
                String check = "SELECT * FROM companies";

                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(check);

                if (rs.next()) {
                    name = rs.getString("company_name");
                }

                if (textName.equalsIgnoreCase(name)) {
                    JOptionPane.showMessageDialog(
                            parentComponent,
                            "Suplier sudah terdaftar",
                            "Suplier Page",
                            JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                boolean checkEmail = isValidEmailAddress(textEmail);

                if (!checkEmail) {
                    JOptionPane.showMessageDialog(
                            parentComponent,
                            "Alamat email tidak valid",
                            "Suplier Page",
                            JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                boolean checkPhone = isValidPhoneNumber(textTelepon);

                if (!checkPhone) {
                    JOptionPane.showMessageDialog(
                            parentComponent,
                            "Nomor telepon tidak valid",
                            "Suplier Page",
                            JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                String insertQuery = "INSERT INTO companies("
                        + "company_name, "
                        + "email, "
                        + "phone, "
                        + "address, "
                        + "created_at, "
                        + "updated_at) "
                        + "VALUES(?,?,?,?,?,?)";

                PreparedStatement ps = conn.prepareStatement(insertQuery);
                ps.setString(1, textName);
                ps.setString(2, textEmail);
                ps.setString(3, textTelepon);
                ps.setString(4, textAlamat);

                Timestamp tmp = new Timestamp(System.currentTimeMillis());

                ps.setTimestamp(5, tmp);
                ps.setTimestamp(6, tmp);
                ps.executeUpdate();

                addCompany(new Company(
                        textName,
                        textAlamat,
                        textEmail,
                        textTelepon
                ));

                int index = companyList.size() - 1;
                tableModel.addRow(new Object[]{
                    companyList.get(index).getCompany_name(),
                    companyList.get(index).getEmail(),
                    companyList.get(index).getPhone(),
                    companyList.get(index).getAddresss()
                });

                JOptionPane.showMessageDialog(
                        parentComponent,
                        "Company berhasil ditambahkan!",
                        "Suplier Page",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                boolean checkEmail = isValidEmailAddress(textEmail);

                if (!checkEmail) {
                    JOptionPane.showMessageDialog(
                            parentComponent,
                            "Alamat email tidak valid",
                            "Suplier Page",
                            JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                boolean checkPhone = isValidPhoneNumber(textTelepon);

                if (!checkPhone) {
                    JOptionPane.showMessageDialog(
                            parentComponent,
                            "Nomor telepon tidak valid",
                            "Suplier Page",
                            JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                String insertQuery = "INSERT INTO companies("
                        + "company_name, "
                        + "email, "
                        + "phone, "
                        + "address, "
                        + "created_at, "
                        + "updated_at) "
                        + "VALUES(?,?,?,?,?,?)";

                PreparedStatement ps = conn.prepareStatement(insertQuery);
                ps.setString(1, textName);
                ps.setString(2, textEmail);
                ps.setString(3, textTelepon);
                ps.setString(4, textAlamat);

                Timestamp tmp = new Timestamp(System.currentTimeMillis());

                ps.setTimestamp(5, tmp);
                ps.setTimestamp(6, tmp);
                ps.executeUpdate();

                addCompany(new Company(
                        textName,
                        textAlamat,
                        textEmail,
                        textTelepon
                ));

                int index = companyList.size() - 1;
                tableModel.addRow(new Object[]{
                    companyList.get(index).getCompany_name(),
                    companyList.get(index).getEmail(),
                    companyList.get(index).getPhone(),
                    companyList.get(index).getAddresss()
                });

                JOptionPane.showMessageDialog(
                        parentComponent,
                        "Company berhasil ditambahkan!",
                        "Suplier Page",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(
                    parentComponent,
                    "Gagal menambahkan company baru, periksa koneksi anda",
                    "Suplier Page",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // Update
    public void updateCompany(
            Component parentComponent,
            String textName,
            String textEmail,
            String texttelepon,
            String textAlamat,
            DefaultTableModel tableModel,
            String textOldName
    ) {
        try {
            conn = db.dbConn();
            String checkId = "SELECT id, company_name, email, address FROM companies WHERE company_name=?";

            PreparedStatement ps = conn.prepareStatement(checkId);
            ps.setString(1, textOldName);
            ResultSet rs = ps.executeQuery();

            String options = "";
            int i = 1;
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("company_name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                options += i + ". ID: " + id + ", Name: " + name + ", Email: " + email + ", Alamat: " + address + "\n";
                i++;
            }

            String input = JOptionPane.showInputDialog(
                    "Masukan id company yang ingin kamu edit:\n" + options
            );

            int id = Integer.parseInt(input);

            String updateQuery = "UPDATE companies "
                    + "SET company_name=?, email=?, phone=?, address=?, updated_at=? "
                    + "WHERE id=?";

            PreparedStatement updatePs = conn.prepareStatement(updateQuery);
            updatePs.setString(1, textName);
            updatePs.setString(2, textEmail);
            updatePs.setString(3, texttelepon);
            updatePs.setString(4, textAlamat);

            Timestamp tmp = new Timestamp(System.currentTimeMillis());

            updatePs.setTimestamp(5, tmp);
            updatePs.setInt(6, id);

            int rowAffected = updatePs.executeUpdate();

            if (rowAffected > 0) {
                JOptionPane.showMessageDialog(
                        parentComponent,
                        "Update data Success",
                        "Update Company",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

            companyList.clear();

            tableModel.setRowCount(0);
            tableModel.fireTableRowsDeleted(0, companyList.size());
            loadCompany(tableModel);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(
                    parentComponent,
                    "Gagal memperbarui company " + textName,
                    "Company Page",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // Delete
    public void deleteCompany(
            Component parentComponent,
            DefaultTableModel tableModel,
            String textOldName
    ) {
        try {
            conn = db.dbConn();
            String checkId = "SELECT id, company_name, email, address FROM companies WHERE company_name=?";

            PreparedStatement ps = conn.prepareStatement(checkId);
            ps.setString(1, textOldName);
            ResultSet rs = ps.executeQuery();

            String options = "";
            int i = 1;
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("company_name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                options += i + ". ID: " + id + ", Name: " + name + ", Email: " + email + ", Alamat: " + address + "\n";
                i++;
            }

            String input = JOptionPane.showInputDialog(
                    "Masukan id company yang ingin kamu edit:\n" + options
            );

            int id = Integer.parseInt(input);

            String deleteQuery = "DELETE FROM companies WHERE id = ?";

            PreparedStatement updatePs = conn.prepareStatement(deleteQuery);
            updatePs.setInt(1, id);

            int rowAffected = updatePs.executeUpdate();

            if (rowAffected > 0) {
                JOptionPane.showMessageDialog(
                        parentComponent,
                        "Delete data Success",
                        "Update Company",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

            companyList.clear();

            tableModel.setRowCount(0);
            tableModel.fireTableRowsDeleted(0, companyList.size());
            loadCompany(tableModel);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(
                    parentComponent,
                    "Gagal menghapus company " + textOldName,
                    "Company Page",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // Search
    public void searchCompany(
            Component parentComponent,
            String search,
            DefaultTableModel tableModel,
            JTextField inputCariPerusahaan,
            JButton btnHapusPencarian,
            JButton btnCariSuplier
    ) {
        try {
            conn = db.dbConn();
            String searchQuery = "SELECT * FROM companies WHERE LOWER(company_name) LIKE ?";

            PreparedStatement ps = conn.prepareStatement(searchQuery);
            ps.setString(1, "%" + search.toLowerCase() + "%");
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);

            if (!rs.next()) {
                JOptionPane.showMessageDialog(parentComponent,
                        "Tiidak ada perusahaan yang bernama " + search,
                        "Search Data",
                        JOptionPane.INFORMATION_MESSAGE
                );

                inputCariPerusahaan.setText("");

                return;
            } else {
                companyList.clear();

                tableModel.setRowCount(0);
                tableModel.fireTableRowsDeleted(0, companyList.size());

                do {
                    System.out.println("test");
                    String name = rs.getString("company_name");
                    String address = rs.getString("address");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");

                    addCompany(new Company(
                            name,
                            address,
                            email,
                            phone
                    ));

                    int index = companyList.size() - 1;
                    tableModel.addRow(new Object[]{
                        companyList.get(index).getCompany_name(),
                        companyList.get(index).getEmail(),
                        companyList.get(index).getPhone(),
                        companyList.get(index).getAddresss()
                    });
                } while (rs.next());
            }
            btnHapusPencarian.setVisible(true);
            btnCariSuplier.setVisible(false);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(
                    parentComponent,
                    "Gagal Mencari Data, periksa koneksi anda",
                    "Cari Perusahaan",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // Read
    public void loadCompany(DefaultTableModel tableModel) {
        try {
            conn = db.dbConn();
            String query = "SELECT * FROM companies";

            Statement state = conn.createStatement();
            ResultSet rset = state.executeQuery(query);

            companyList.clear();

            tableModel.setRowCount(0);
            tableModel.fireTableRowsDeleted(0, companyList.size());

            while (rset.next()) {
                String companyName = rset.getString("company_name");
                String email = rset.getString("email");
                String phone = rset.getString("phone");
                String alamat = rset.getString("address");

                addCompany(new Company(
                        companyName,
                        alamat,
                        email,
                        phone
                ));

                int index = companyList.size() - 1;

                tableModel.addRow(new Object[]{
                    companyList.get(index).getCompany_name(),
                    companyList.get(index).getEmail(),
                    companyList.get(index).getPhone(),
                    companyList.get(index).getAddresss(),});
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void loadComboBoxItemCompany() {
        try {
            conn = db.dbConn();
            String query = "SELECT * FROM companies";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            companyList.clear();

            while (rs.next()) {
                String companyName = rs.getString("company_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String alamat = rs.getString("address");

                addCompany(new Company(
                        companyName,
                        alamat,
                        email,
                        phone
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isValidEmailAddress(String email) {
        // Regular Expression
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        // Compile the regular expression
        Pattern pattern = Pattern.compile(regex);

        // Check if the email address matches the regular expression
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidPhoneNumber(String telepon) {
        String regex = "^[\\d\\-\\(\\)\\s]{10,12}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(telepon);
        return matcher.matches();
    }

    private void addCompany(Company company) {
        companyList.add(company);
    }
}
