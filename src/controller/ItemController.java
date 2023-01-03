/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Item;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import model.Category;

/**
 *
 * @author panji
 */
public class ItemController {

    private static final ArrayList<Item> itemList = new ArrayList<>();
    private final CategoryController categoryController = new CategoryController();
    private Connection conn;
    private final DBConnection db = new DBConnection();

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    // Create
    public void insertItem(
            Component parentComponent,
            String textCategory,
            String textName,
            int textQuantity,
            String textDescription,
            DefaultTableModel tableModel
    ) {
        try {
            conn = db.dbConn();
            String name, id;

            if (!itemList.isEmpty()) {
                String itemID = generateID(textCategory);
                String check = "SELECT * FROM items";

                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(check);

                while (rs.next()) {
                    id = rs.getString("item_id");
                    name = rs.getString("item_name");

                    if (textName.equalsIgnoreCase(name) || itemID.equals(id)) {
                        JOptionPane.showMessageDialog(
                                parentComponent,
                                "Item sudah terdaftar",
                                "Item Page",
                                JOptionPane.WARNING_MESSAGE
                        );

                        return;
                    }
                }

                int categoryID = getCategoryID(textCategory);
                int lowStockLvl = getLowStockLevel(textQuantity);

                String insertQuery = "INSERT INTO items("
                        + "item_id, "
                        + "category_id, "
                        + "item_name, "
                        + "quantity, "
                        + "low_stock_level, "
                        + "description, "
                        + "created_at, "
                        + "updated_at) "
                        + "VALUES(?,?,?,?,?,?,?,?)";

                PreparedStatement ps = conn.prepareStatement(insertQuery);
                ps.setString(1, itemID);
                ps.setInt(2, categoryID);
                ps.setString(3, textName);
                ps.setInt(4, textQuantity);
                ps.setInt(5, lowStockLvl);
                ps.setString(6, textDescription);

                Timestamp tmp = new Timestamp(System.currentTimeMillis());

                ps.setTimestamp(7, tmp);
                ps.setTimestamp(8, tmp);
                ps.executeUpdate();

                addItem(new Item(
                        itemID,
                        textName,
                        textQuantity,
                        lowStockLvl,
                        textDescription,
                        categoryID,
                        textCategory
                ));

                int index = itemList.size() - 1;
                tableModel.addRow(new Object[]{
                    itemList.get(index).getItem_id(),
                    itemList.get(index).getItem_name(),
                    itemList.get(index).getCategory_name(),
                    itemList.get(index).getQuantity(),
                    itemList.get(index).getLow_stock_level(),
                    itemList.get(index).getDescription(),});

                JOptionPane.showMessageDialog(
                        parentComponent,
                        "Item berhasil ditambahkan!",
                        "Item Page",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                String itemID = generateID(textCategory);
                int categoryID = getCategoryID(textCategory);
                int lowStockLvl = getLowStockLevel(textQuantity);

                String insertQuery = "INSERT INTO items("
                        + "item_id, "
                        + "category_id, "
                        + "item_name, "
                        + "quantity, "
                        + "low_stock_level, "
                        + "description, "
                        + "created_at, "
                        + "updated_at) "
                        + "VALUES(?,?,?,?,?,?,?,?)";

                PreparedStatement ps = conn.prepareStatement(insertQuery);
                ps.setString(1, itemID);
                ps.setInt(2, categoryID);
                ps.setString(3, textName);
                ps.setInt(4, textQuantity);
                ps.setInt(5, lowStockLvl);
                ps.setString(6, textDescription);

                Timestamp tmp = new Timestamp(System.currentTimeMillis());

                ps.setTimestamp(7, tmp);
                ps.setTimestamp(8, tmp);
                ps.executeUpdate();

                addItem(new Item(
                        itemID,
                        textName,
                        textQuantity,
                        lowStockLvl,
                        textDescription,
                        categoryID,
                        textCategory
                ));

                int index = itemList.size() - 1;
                tableModel.addRow(new Object[]{
                    itemList.get(index).getItem_id(),
                    itemList.get(index).getItem_name(),
                    itemList.get(index).getCategory_name(),
                    itemList.get(index).getQuantity(),
                    itemList.get(index).getLow_stock_level(),
                    itemList.get(index).getDescription(),});

                JOptionPane.showMessageDialog(
                        parentComponent,
                        "Item berhasil ditambahkan!",
                        "Item Page",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(
                    parentComponent,
                    "Gagal menambahkan item baru, periksa koneksi anda",
                    "Item Page",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // Update
    public void updateItem(
            Component parentComponent,
            String textCategory,
            String textName,
            int textQuantity,
            String textDescription,
            DefaultTableModel tableModel,
            String textOldItemID
    ) {
        try {
            conn = db.dbConn();

            String itemID = updateID(textCategory);
            int categoryID = getCategoryID(textCategory);
            int lowStockLvl = getLowStockLevel(textQuantity);

            String updateQuery = "UPDATE items"
                    + "SET item_id=?, "
                    + "category_id=?, "
                    + "item_name=?, "
                    + "quantity=?, "
                    + "low_stock_level=?, "
                    + "description=?, "
                    + "updated_at=? "
                    + "WHERE item_id=?";

            PreparedStatement updatePs = conn.prepareStatement(updateQuery);
            updatePs.setString(1, itemID);
            updatePs.setInt(2, categoryID);
            updatePs.setString(3, textName);
            updatePs.setInt(4, textQuantity);
            updatePs.setInt(5, lowStockLvl);
            updatePs.setString(6, textDescription);

            Timestamp tmp = new Timestamp(System.currentTimeMillis());

            updatePs.setTimestamp(7, tmp);
            updatePs.setString(8, textOldItemID);

            int rowAffected = updatePs.executeUpdate();

            if (rowAffected > 0) {
                JOptionPane.showMessageDialog(
                        parentComponent,
                        "Update data Success",
                        "Update Item",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

            itemList.clear();

            tableModel.setRowCount(0);
            tableModel.fireTableRowsDeleted(0, itemList.size());
            loadItem(tableModel);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(
                    parentComponent,
                    "Gagal memperbarui data",
                    "Item Page",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // Delete
    public void deleteItem(
            Component parentComponent,
            DefaultTableModel tableModel,
            String textOldItemID
    ) {
        try {
            conn = db.dbConn();
            String deleteQuery = "DELETE FROM items WHERE item_id = ?";

            PreparedStatement deletePs = conn.prepareStatement(deleteQuery);
            deletePs.setString(1, textOldItemID);

            int rowAffected = deletePs.executeUpdate();

            if (rowAffected > 0) {
                JOptionPane.showMessageDialog(
                        parentComponent,
                        "Delete data Success",
                        "Update Company",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

            itemList.clear();

            tableModel.setRowCount(0);
            tableModel.fireTableRowsDeleted(0, itemList.size());
            loadItem(tableModel);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(
                    parentComponent,
                    "Gagal menghapus karyawan dengan ID " + textOldItemID,
                    "Item Page",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // Search
    public void searchItem(
            Component parentComponent,
            String search,
            DefaultTableModel tableModel,
            JTextField inputCariItem,
            JButton btnHapusPencarianItem,
            JButton btnCariItem
    ) {
        try {
            conn = db.dbConn();
            String searchQuery = "SELECT * FROM items i "
                    + "JOIN  categories c "
                    + "ON i.category_id = c.id "
                    + "WHERE LOWER(employee_name) LIKE ? OR "
                    + "LOWER(item_id) = ? OR "
                    + "LOWER(c.category_name) LIKE ?";

            PreparedStatement ps = conn.prepareStatement(searchQuery);
            ps.setString(1, "%" + search.toLowerCase() + "%");
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(parentComponent,
                        "Item yang anda cari tidak ada",
                        "Search Data",
                        JOptionPane.INFORMATION_MESSAGE
                );

                inputCariItem.setText("");

                return;
            } else {
                itemList.clear();

                tableModel.setRowCount(0);
                tableModel.fireTableRowsDeleted(0, itemList.size());

                do {
                    String id = rs.getString("item_id");
                    String name = rs.getString("item_name");
                    int qty = rs.getInt("quantity");
                    int lowStockLvl = rs.getInt("low_stock_level");
                    String desc = rs.getString("description");
                    int categoryID = rs.getInt("category_id");

                    String categoryName = getCategoryName(categoryID);

                    addItem(new Item(
                            id,
                            name,
                            qty,
                            lowStockLvl,
                            desc,
                            categoryID,
                            categoryName
                    ));

                    int index = itemList.size() - 1;
                    tableModel.addRow(new Object[]{
                        itemList.get(index).getItem_id(),
                        itemList.get(index).getItem_name(),
                        itemList.get(index).getCategory_name(),
                        itemList.get(index).getQuantity(),
                        itemList.get(index).getLow_stock_level(),
                        itemList.get(index).getDescription(),});
                } while (rs.next());
            }
            btnHapusPencarianItem.setVisible(true);
            btnCariItem.setVisible(false);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(
                    parentComponent,
                    "Gagal Mencari Data, periksa koneksi anda",
                    "Cari Item",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    public void checkSameItem(
            Component parentComponent,
            String itemID
    ) {
        try {
            String id;
            String check = "SELECT * FROM items";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(check);

            while (rs.next()) {
                id = rs.getString("item_id");

                if (itemID.equals(id)) {
                    JOptionPane.showMessageDialog(
                            parentComponent,
                            "Item sudah terdaftar",
                            "Item Page",
                            JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Read
    public void loadItem(DefaultTableModel tableModel) {
        try {
            conn = db.dbConn();
            String query = "SELECT * FROM items";

            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(query);

            itemList.clear();

            tableModel.setRowCount(0);
            tableModel.fireTableRowsDeleted(0, itemList.size());

            while (rs.next()) {
                String id = rs.getString("item_id");
                String name = rs.getString("item_name");
                int qty = rs.getInt("quantity");
                int lowStockLvl = rs.getInt("low_stock_level");
                String desc = rs.getString("description");
                int categoryID = rs.getInt("category_id");

                String categoryName = getCategoryName(categoryID);

                addItem(new Item(
                        id,
                        name,
                        qty,
                        lowStockLvl,
                        desc,
                        categoryID,
                        categoryName
                ));

                int index = itemList.size() - 1;
                tableModel.addRow(new Object[]{
                    itemList.get(index).getItem_id(),
                    itemList.get(index).getItem_name(),
                    itemList.get(index).getCategory_name(),
                    itemList.get(index).getQuantity(),
                    itemList.get(index).getLow_stock_level(),
                    itemList.get(index).getDescription(),});
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

            itemList.clear();

            while (rs.next()) {
                String id = rs.getString("item_id");
                String name = rs.getString("item_name");
                int qty = rs.getInt("quantity");
                int lowStockLvl = rs.getInt("low_stock_level");
                String desc = rs.getString("description");
                int categoryID = rs.getInt("category_id");

                String categoryName = getCategoryName(categoryID);

                addItem(new Item(
                        id,
                        name,
                        qty,
                        lowStockLvl,
                        desc,
                        categoryID,
                        categoryName
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private int getCategoryID(String category) {
        ArrayList<Category> ctList = categoryController.getCategoryList();
        int id = 0;

        for (Category c : ctList) {
            if (c.getCategory_name().equals(category)) {
                id = c.getCategory_id();
                break;
            }
        }

        return id;
    }

    private void addItem(Item item) {
        itemList.add(item);
    }

    private String getCategoryName(int category_id) {
        ArrayList<Category> ctList = categoryController.getCategoryList();
        String name = "";

        for (Category c : ctList) {
            if (c.getCategory_id() == category_id) {
                name = c.getCategory_name();
                break;
            }
        }

        return name;
    }

    private String generateID(String textCategory) {
        char category = 0;

        switch (textCategory) {
            case "Consumer" -> {
                category = 'C';
                break;
            }
            case "Non-Durable" -> {
                category = 'D';
                break;
            }
            case "Necessities" -> {
                category = 'N';
                break;
            }
            case "Industrial" -> {
                category = 'I';
                break;
            }
            case "Agricultural" -> {
                category = 'A';
                break;
            }
        }

        String id = IDGenerator.generateID(category);

        return id;
    }

    private int getLowStockLevel(int textQuantity) {
        int lowStockLevel = (int) (textQuantity * 0.02);

        return lowStockLevel;
    }

    private String updateID(String textCategory) {
        char category = 0;

        switch (textCategory) {
            case "Consumer" -> {
                category = 'C';
                break;
            }
            case "Non-Durable" -> {
                category = 'D';
                break;
            }
            case "Necessities" -> {
                category = 'N';
                break;
            }
            case "Industrial" -> {
                category = 'I';
                break;
            }
            case "Agricultural" -> {
                category = 'A';
                break;
            }
        }

        String id = IDGenerator.updateID(category);

        return id;
    }

    public void setQuantity(
            Component parentComponent,
            String textKodeBarang, 
            int textAmount,
            DefaultTableModel tableModel
    ) {
        try {
            conn = db.dbConn();
            int newQty = 0;
            String updateQtyQuery = "UPDATE items "
                    + "SET quantity = ?, "
                    + "updated_at = ? "
                    + "WHERE item_id = ?";
            
            for (Item item : itemList) {
                if(item.getItem_id().equals(textKodeBarang)) {
                    newQty = item.getQuantity();
                }
            }
            
            newQty -= textAmount;
            
            PreparedStatement ps = conn.prepareStatement(updateQtyQuery);
            ps.setInt(1, newQty);
            
            Timestamp tmp = new Timestamp(System.currentTimeMillis());
            
            ps.setTimestamp(2, tmp);
            ps.setString(3, textKodeBarang);
            
            int rowAffected = ps.executeUpdate();

            if (rowAffected > 0) {
                JOptionPane.showMessageDialog(
                        parentComponent,
                        "Update data Success",
                        "Update Item",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

            itemList.clear();

            tableModel.setRowCount(0);
            tableModel.fireTableRowsDeleted(0, itemList.size());
            loadItem(tableModel);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
