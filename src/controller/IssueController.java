package controller;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Employee;
import model.Issue;
import model.Item;

public class IssueController {

    private static final ArrayList<Issue> issueList = new ArrayList<>();
    private static final ItemController itemController = new ItemController();
    private static final EmployeeController employeeController = new EmployeeController();
    private Connection conn;
    private final DBConnection db = new DBConnection();

    public ArrayList<Issue> getTransactionList() {
        return issueList;
    }

    public void insertIssue(
            Component parentComponent,
            String textKodeBarang,
            int textStacks,
            String textEmployee,
            String textDeskripsi,
            DefaultTableModel tableModelIssue,
            DefaultTableModel tableModelItem
    ) {
        try {
            conn = db.dbConn();

            int result = JOptionPane.showConfirmDialog(
                    parentComponent,
                    "Apakah anda yakin barang tersebut bermasalah?",
                    "Issue Page",
                    JOptionPane.YES_NO_OPTION
            );

            if (result == JOptionPane.YES_OPTION) {
                int id = getIssueIDIncremental();
                Item item = getItem(textKodeBarang);
                Employee employee = getEmployee(textEmployee);
                String employeeID = employee.getNip();

                String insertQuery = "INSERT INTO issues("
                        + "item_id, "
                        + "nip, "
                        + "stacks, "
                        + "description, "
                        + "created_at, "
                        + "updated_at) "
                        + "VALUES(?,?,?,?,?,?)";

                PreparedStatement ps = conn.prepareStatement(insertQuery);
                ps.setString(1, textKodeBarang);
                ps.setString(2, employeeID);
                ps.setInt(3, textStacks);
                ps.setString(4, textDeskripsi);

                Timestamp tmp = new Timestamp(System.currentTimeMillis());

                ps.setTimestamp(5, tmp);
                ps.setTimestamp(6, tmp);
                ps.executeUpdate();

                itemController.setQuantity(
                        parentComponent,
                        textKodeBarang,
                        textStacks,
                        tableModelItem
                );

                addIssue(new Issue(
                        id,
                        textStacks,
                        textDeskripsi,
                        item,
                        employee
                ));

                int index = issueList.size() - 1;
                tableModelIssue.addRow(new Object[]{
                    issueList.get(index).getId(),
                    issueList.get(index).getItem().getItem_name(),
                    issueList.get(index).getEmployee().getEmployee_name(),
                    issueList.get(index).getStacks(),
                    issueList.get(index).getIssue_description()
                });

                JOptionPane.showMessageDialog(
                        parentComponent,
                        "Berhasil menambah barang yang bermasalah",
                        "Issue Page",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                // Kosong
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateIssue(
            Component parentComponent,
            int textId,
            String textKodeBarang,
            int textStacks,
            String textEmployee,
            String textDeskripsi,
            int oldStacks,
            DefaultTableModel tableModelIssue,
            DefaultTableModel tableModelItem
    ) {
        try {
            conn = db.dbConn();
            String updateQuery = "UPDATE issues "
                    + "SET item_id = ?, "
                    + "nip = ?, "
                    + "stacks = ?, "
                    + "description = ?, "
                    + "updated_at = ? WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(updateQuery);
            ps.setString(1, textKodeBarang);
            ps.setString(2, textEmployee);

            if (textStacks != oldStacks) {
                itemController.setQuantity(
                        parentComponent,
                        textKodeBarang,
                        textStacks,
                        tableModelItem
                );

                ps.setInt(3, textStacks);
            } else {
                ps.setInt(3, oldStacks);
            }

            ps.setString(4, textDeskripsi);

            Timestamp tmp = new Timestamp(System.currentTimeMillis());

            ps.setTimestamp(5, tmp);

            int rowAffected = ps.executeUpdate();

            if (rowAffected > 0) {
                JOptionPane.showMessageDialog(
                        parentComponent,
                        "Update data success",
                        "Update Issue",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

            issueList.clear();

            tableModelIssue.setRowCount(0);
            tableModelIssue.fireTableRowsDeleted(0, issueList.size() - 1);
            loadIssue(tableModelIssue);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteIssue(
            Component parentComponent,
            int oldID,
            DefaultTableModel tableModelIssue,
            DefaultTableModel tableModelItem
    ) {
        try {
            conn = db.dbConn();
            String query = "DELETE FROM issues WHERE id =? ";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, oldID);
            
            int rowAffected = ps.executeUpdate();
            
            if(rowAffected > 0) {
                JOptionPane.showMessageDialog(
                        parentComponent, 
                        "Delete data success", 
                        "Delete Issues", 
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
            
            issueList.clear();
            
            tableModelIssue.setRowCount(0);
            tableModelIssue.fireTableRowsDeleted(0, issueList.size());
            loadIssue(tableModelIssue);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void loadIssue(DefaultTableModel tableModel) {
        try {
            conn = db.dbConn();
            String query = "SELECT * FROM issues";

            Statement state = conn.createStatement();
            ResultSet rset = state.executeQuery(query);

            issueList.clear();

            tableModel.setRowCount(0);
            tableModel.fireTableRowsDeleted(0, issueList.size());

            while (rset.next()) {
                int issueId = rset.getInt("id");
                String itemId = rset.getString("item_id");
                String nip = rset.getString("nip");
                int stacks = rset.getInt("stacks");
                String description = rset.getString("description");

                Item item = getItem(itemId);
                Employee employee = getEmployee(nip);

                addIssue(new Issue(
                        issueId,
                        stacks,
                        description,
                        item,
                        employee
                ));

                int index = issueList.size() - 1;

                tableModel.addRow(new Object[]{
                    issueList.get(index).getId(),
                    issueList.get(index).getItem().getItem_name(),
                    issueList.get(index).getEmployee().getEmployee_name(),
                    issueList.get(index).getStacks()
                });
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void addIssue(Issue issue) {
        issueList.add(issue);
    }

    private Item getItem(String itemId) {
        ArrayList<Item> itList = itemController.getItemList();

        for (Item it : itList) {
            if (it.getItem_id().equals(itemId)) {
                return new Item(
                        it.getItem_id(),
                        it.getItem_name(),
                        it.getQuantity(),
                        it.getLow_stock_level(),
                        it.getDescription(),
                        it.getCategory_id(),
                        it.getCategory_name()
                );
            }
        }

        return null;
    }

    private Employee getEmployee(String name) {
        ArrayList<Employee> emList = employeeController.getEmployeeList();

        for (Employee em : emList) {
            if (em.getEmployee_name().equals(name)) {
                return new Employee(
                        em.getStatus(),
                        em.getEmployee_name(),
                        em.getNip(),
                        em.getId(),
                        em.getDepartment_name()
                );
            }
        }

        return null;
    }

    private int getIssueIDIncremental() {
        int id = 0;

        for (Issue is : issueList) {
            id = is.getId();
        }

        id += 1;

        return id;
    }
}
