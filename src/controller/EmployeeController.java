/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Component;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Department;
import model.Employee;

/**
 *
 * @author panji
 */
public class EmployeeController {

    private static final ArrayList<Employee> employeeList = new ArrayList<>();
    private final DepartmentController departmentController = new DepartmentController();
    private Connection conn;
    private final DBConnection db = new DBConnection();

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    // Create
    public void insertEmployee(
            Component parentComponent,
            String textNip,
            String textName,
            String textDepartment,
            DefaultTableModel tableModel
    ) {
        try {
            conn = db.dbConn();
            String name = "", nip = "";

            if (!employeeList.isEmpty()) {
                String check = "SELECT * FROM employees";

                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(check);

                if (rs.next()) {
                    nip = rs.getString("nip");
                    name = rs.getString("employee_name");

                    if (textName.equalsIgnoreCase(name) || textNip.equals(nip)) {
                        JOptionPane.showMessageDialog(
                                parentComponent,
                                "Karyawan sudah terdaftar",
                                "Employee Page",
                                JOptionPane.WARNING_MESSAGE
                        );

                        return;
                    }
                }

                boolean checkNip = isValidNip(textNip);

                if (!checkNip) {
                    JOptionPane.showMessageDialog(
                            parentComponent,
                            "NIP tidak valid",
                            "Employee Page",
                            JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                int idDepartment = getDepartmentID(textDepartment);

                String insertQuery = "INSERT INTO employees("
                        + "nip, "
                        + "employee_name, "
                        + "created_at, "
                        + "updated_at, "
                        + "department_id) "
                        + "VALUES(?,?,?,?,?)";

                PreparedStatement ps = conn.prepareStatement(insertQuery);
                ps.setString(1, textNip);
                ps.setString(2, textName);

                Timestamp tmp = new Timestamp(System.currentTimeMillis());

                ps.setTimestamp(3, tmp);
                ps.setTimestamp(4, tmp);
                ps.setInt(5, idDepartment);
                ps.executeUpdate();

                addEmployee(new Employee(
                        textName,
                        textNip,
                        textDepartment,
                        idDepartment
                ));

                int index = employeeList.size() - 1;
                tableModel.addRow(new Object[]{
                    employeeList.get(index).getNip(),
                    employeeList.get(index).getEmployee_name(),
                    employeeList.get(index).getDepartment_name(),});

                JOptionPane.showMessageDialog(
                        parentComponent,
                        "Karyawan berhasil ditambahkan!",
                        "Karyawan Page",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                boolean checkNip = isValidNip(textNip);

                if (!checkNip) {
                    JOptionPane.showMessageDialog(
                            parentComponent,
                            "NIP tidak valid",
                            "Employee Page",
                            JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                int idDepartment = getDepartmentID(textDepartment);

                String insertQuery = "INSERT INTO employees("
                        + "nip, "
                        + "employee_name, "
                        + "created_at, "
                        + "updated_at, "
                        + "department_id) "
                        + "VALUES(?,?,?,?,?)";

                PreparedStatement ps = conn.prepareStatement(insertQuery);
                ps.setString(1, textNip);
                ps.setString(2, textName);

                Timestamp tmp = new Timestamp(System.currentTimeMillis());

                ps.setTimestamp(3, tmp);
                ps.setTimestamp(4, tmp);
                ps.setInt(5, idDepartment);
                ps.executeUpdate();

                addEmployee(new Employee(
                        textName,
                        textNip,
                        textDepartment,
                        idDepartment
                ));

                int index = employeeList.size() - 1;
                tableModel.addRow(new Object[]{
                    employeeList.get(index).getNip(),
                    employeeList.get(index).getEmployee_name(),
                    employeeList.get(index).getDepartment_name(),});

                JOptionPane.showMessageDialog(
                        parentComponent,
                        "Karyawan berhasil ditambahkan!",
                        "Karyawan Page",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(
                    parentComponent,
                    "Gagal menambahkan karyawan baru, periksa koneksi anda",
                    "Suplier Page",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // Update
    public void updateEmployee(
            Component parentComponent,
            String textNip,
            String textName,
            String textDepartment,
            DefaultTableModel tableModel,
            String textOldNip
    ) {
        try {
            conn = db.dbConn();

            int id = getDepartmentID(textDepartment);

            String updateQuery = "UPDATE employees "
                    + "SET nip=?, employee_name=?, department_id=?, updated_at=? "
                    + "WHERE nip=?";

            PreparedStatement updatePs = conn.prepareStatement(updateQuery);
            updatePs.setString(1, textNip);
            updatePs.setString(2, textName);
            updatePs.setInt(3, id);

            Timestamp tmp = new Timestamp(System.currentTimeMillis());

            updatePs.setTimestamp(4, tmp);
            updatePs.setString(5, textOldNip);

            int rowAffected = updatePs.executeUpdate();

            if (rowAffected > 0) {
                JOptionPane.showMessageDialog(
                        parentComponent,
                        "Update data Success",
                        "Update Company",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

            employeeList.clear();

            tableModel.setRowCount(0);
            tableModel.fireTableRowsDeleted(0, employeeList.size());
            loadEmployee(tableModel);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(
                    parentComponent,
                    "Gagal memperbarui karyawan " + textName,
                    "Karyawan Page",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // Delete
    public void deleteEmployee(
            Component parentComponent,
            DefaultTableModel tableModel,
            String textOldNip
    ) {
        try {
            conn = db.dbConn();
            String deleteQuery = "DELETE FROM employees WHERE nip = ?";

            PreparedStatement updatePs = conn.prepareStatement(deleteQuery);
            updatePs.setString(1, textOldNip);

            int rowAffected = updatePs.executeUpdate();

            if (rowAffected > 0) {
                JOptionPane.showMessageDialog(
                        parentComponent,
                        "Delete data Success",
                        "Update Company",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

            employeeList.clear();

            tableModel.setRowCount(0);
            tableModel.fireTableRowsDeleted(0, employeeList.size());
            loadEmployee(tableModel);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(
                    parentComponent,
                    "Gagal menghapus karyawan dengan nip " + textOldNip,
                    "Company Page",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // Search
    public void searchEmployee(
            Component parentComponent,
            String search,
            DefaultTableModel tableModel,
            JTextField inputCariKaryawan,
            JButton btnHapusPencarian,
            JButton btnCariKaryawan
    ) {
        try {
            conn = db.dbConn();
            String searchQuery = "SELECT * FROM employees WHERE LOWER(employee_name) LIKE ?";

            PreparedStatement ps = conn.prepareStatement(searchQuery);
            ps.setString(1, "%" + search.toLowerCase() + "%");
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(parentComponent,
                        "Tiidak ada karyawan yang bernama " + search,
                        "Search Data",
                        JOptionPane.INFORMATION_MESSAGE
                );

                inputCariKaryawan.setText("");

                return;
            } else {
                employeeList.clear();

                tableModel.setRowCount(0);
                tableModel.fireTableRowsDeleted(0, employeeList.size());

                do {
                    String nip = rs.getString("nip");
                    String name = rs.getString("employee_name");
                    int departmentID = rs.getInt("department_id");

                    String departmentName = getDepartmentName(departmentID);

                    addEmployee(new Employee(
                            name,
                            nip,
                            departmentName,
                            departmentID
                    ));

                    int index = employeeList.size() - 1;
                    tableModel.addRow(new Object[]{
                        employeeList.get(index).getNip(),
                        employeeList.get(index).getEmployee_name(),
                        employeeList.get(index).getDepartment_name(),});
                } while (rs.next());
            }
            btnHapusPencarian.setVisible(true);
            btnCariKaryawan.setVisible(false);
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
    public void loadEmployee(DefaultTableModel tableModel) {
        try {
            conn = db.dbConn();
            String query = "SELECT * FROM employees";

            Statement state = conn.createStatement();
            ResultSet rset = state.executeQuery(query);

            employeeList.clear();

            tableModel.setRowCount(0);
            tableModel.fireTableRowsDeleted(0, employeeList.size());

            while (rset.next()) {
                String nip = rset.getString("nip");
                String name = rset.getString("employee_name");
                int department_id = rset.getInt("department_id");

                String departmentName = getDepartmentName(department_id);

                addEmployee(new Employee(
                        name,
                        nip,
                        departmentName,
                        department_id
                ));

                int index = employeeList.size() - 1;

                tableModel.addRow(new Object[]{
                    employeeList.get(index).getNip(),
                    employeeList.get(index).getEmployee_name(),
                    employeeList.get(index).getDepartment_name(),});
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void loadComboBoxItemCompany() {
        try {
            conn = db.dbConn();
            String query = "SELECT * FROM employees";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            employeeList.clear();

            while (rs.next()) {
                String employeeName = rs.getString("employee_name");
                String nip = rs.getString("nip");
                int departmentID = rs.getInt("department_id");

                String departmentName = getDepartmentName(departmentID);

                addEmployee(new Employee(
                        employeeName,
                        nip,
                        departmentName,
                        departmentID
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isValidNip(String nip) {
        Calendar calendar = Calendar.getInstance();
        // Tahun sekaranga
        int currentYear = calendar.get(Calendar.YEAR);

        // Bulan dimulai dari 0
        int currentMonth = calendar.get(Calendar.MONTH) + 1;

        // Hari ini
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        // Regular Expression
        Pattern pattern = Pattern.compile("(\\d{8})(\\d{6})(\\d)(\\d{3})");

        // check jika nip match dengan regular expression
        Matcher matcher = pattern.matcher(nip);

        // jika hasil check true maka lakukan pada tahun, bulan, dan tanggal lahir yang terdapat pada nip
        if (matcher.matches()) {
            int birthYear = Integer.parseInt(matcher.group(1).substring(0, 4));
            int birthMonth = Integer.parseInt(matcher.group(1).substring(4, 6));
            int birthDay = Integer.parseInt(matcher.group(1).substring(6, 8));

            return birthYear < currentYear || (birthYear == currentYear && (birthMonth < currentMonth || (birthMonth == currentMonth && birthDay <= currentDay)));
        } else {
            return false;
        }
    }

    private int getDepartmentID(String department) {
        ArrayList<Department> dpList = departmentController.getDepartmentList();
        int id = 0;

        for (Department dp : dpList) {
            if (dp.getDepartment_name().equals(department)) {
                id = dp.getId();
                break;
            }
        }

        return id;
    }

    private void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    private String getDepartmentName(int department_id) {
        ArrayList<Department> dpList = departmentController.getDepartmentList();
        String name = "";

        for (Department dp : dpList) {
            if (dp.getId() == department_id) {
                name = dp.getDepartment_name();
                break;
            }
        }

        return name;
    }
}
