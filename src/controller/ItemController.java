/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.util.ArrayList;
import model.Item;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

/**
 *
 * @author panji
 */
public class ItemController {

    private static final MysqlDataSource dataSource = new MysqlDataSource();
    private static final ArrayList<Item> itemList = new ArrayList<>();

    public ItemController() {
        DBConnection conn = new DBConnection();
        conn.dbConn(dataSource);
    }

    public void addItemData(
            Component parentComponent,
            String textName,
            int textCategoryId,
            int textCompanyId,
            int textQty,
            int textLowStock,
            DefaultTableModel tableModel
    ) {
        try {
            // TODO: add check if the qty or lowstock input less than 0
            String name = "", category = "";
            int qty = 0, lowStock = 0;
            Connection conn = dataSource.getConnection();

            if (!itemList.isEmpty()) {
                String query = "SELECT * FROM items";

                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);

                if (rs.next()) {
                    name = rs.getString("name");
                    qty = rs.getInt("quantity");
                    lowStock = rs.getInt("low_stack_level");
                }

                if (textName.equalsIgnoreCase(name)) {
                    JOptionPane.showMessageDialog(
                            parentComponent,
                            "Data Item Sudah Ada",
                            "Add Item",
                            JOptionPane.WARNING_MESSAGE
                    );
                } else {
                    String insertQuery = "INSERT INTO items("
                            + "name, "
                            + "quantity, "
                            + "low_stock_level, "
                            + "category_id, "
                            + "company_id) "
                            + "VALUES(?,?,?,?,?)";

                    PreparedStatement ps = conn.prepareStatement(insertQuery);
                    ps.setString(1, textName);
                    ps.setInt(2, textQty);
                    ps.setInt(3, textLowStock);
                    ps.setInt(4, textCategoryId);
                    ps.setInt(5, textCompanyId);
                    ps.executeUpdate();

                    switch (textCategoryId) {
                        case 1 -> {
                            category = "Primer";
                        }
                        case 2 -> {
                            category = "Sekunder";
                        }
                        case 3 -> {
                            category = "Tersier";
                        }
                        default ->
                            throw new AssertionError();
                    }

                    addItem(new Item(
                            textName,
                            textQty,
                            textLowStock,
                            textCompanyId,
                            category
                    ));

                    int index = itemList.size() - 1;

                    tableModel.addRow(new Object[]{
                        itemList.get(index).getItemName(),
                        itemList.get(index).getQuantity(),
                        itemList.get(index).getLow_stock_level(),
                        itemList.get(index).getCategory_name(),
                        itemList.get(index).getCompany_id()
                    });

                    JOptionPane.showMessageDialog(
                            parentComponent,
                            "Produk berhasil ditambahkan!",
                            "Add Item Page",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            } else {
                String insertQuery = "INSERT INTO items("
                        + "name, "
                        + "quantity, "
                        + "low_stock_quantity, "
                        + "category_id, "
                        + "company_id) "
                        + "VALUES(?,?,?,?,?)";

                PreparedStatement ps = conn.prepareStatement(insertQuery);
                ps.setString(1, textName);
                ps.setInt(2, textQty);
                ps.setInt(3, textLowStock);
                ps.setInt(4, textCategoryId);
                ps.setInt(5, textCompanyId);
                ps.executeUpdate();

                switch (textCategoryId) {
                    case 1 -> {
                        category = "Primer";
                    }
                    case 2 -> {
                        category = "Sekunder";
                    }
                    case 3 -> {
                        category = "Tersier";
                    }
                    default ->
                        throw new AssertionError();
                }

                addItem(new Item(
                        textName,
                        textQty,
                        textLowStock,
                        textCompanyId,
                        category
                ));

                int index = itemList.size() - 1;

                tableModel.addRow(new Object[]{
                    itemList.get(index).getItemName(),
                    itemList.get(index).getQuantity(),
                    itemList.get(index).getLow_stock_level(),
                    itemList.get(index).getCategory_name(),
                    itemList.get(index).getCompany_id()
                });

                JOptionPane.showMessageDialog(
                        parentComponent,
                        "Produk berhasil ditambahkan!",
                        "Add Item Page",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(
                    parentComponent,
                    "Gagal menambahkan item baru! Periksa lagi koneksi Anda!",
                    "Add Item Page",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    public void updateItem(
            Component parentComponent,
            String getEditName,
            int getEditCategoryId,
            int getEditCompanyId,
            int getEditQty,
            int getEditLowStock,
            DefaultTableModel tableModel,
            String oldItemName
    ) {
        try {
            Connection conn = dataSource.getConnection();
            String setQuery = "UPDATE items "
                    + "SET name=?, "
                    + "quantity=?, "
                    + "low_stock_level=?, "
                    + "category_id=?, "
                    + "company_id=? "
                    + "WHERE name=?";

            PreparedStatement psUpdate = conn.prepareStatement(setQuery);

            psUpdate.setString(1, getEditName);
            psUpdate.setInt(2, getEditQty);
            psUpdate.setInt(3, getEditLowStock);
            psUpdate.setInt(4, getEditCategoryId);
            psUpdate.setInt(5, getEditCompanyId);
            psUpdate.setString(6, oldItemName);

            psUpdate.executeUpdate();
            itemList.clear();

            tableModel.setRowCount(0);
            tableModel.fireTableRowsDeleted(0, itemList.size());
            loadItemData(tableModel);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(
                    parentComponent,
                    "Gagal melakukan perubahan! Periksa lagi koneksi Anda!",
                    "Edit Item Page",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void deleteItem(
            Component parentComponent,
            DefaultTableModel tableModel,
            String oldItemName
    ) {
        try {
            Connection conn = dataSource.getConnection();
            String setQuery = "DELETE FROM items WHERE name = ?";

            PreparedStatement psDelete = conn.prepareStatement(setQuery);

            psDelete.setString(1, oldItemName);

            psDelete.executeUpdate();
            itemList.clear();

            tableModel.setRowCount(0);
            tableModel.fireTableRowsDeleted(0, itemList.size());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(
                    parentComponent,
                    "Gagal melakukan penghapusan! Periksa lagi koneksi Anda!",
                    "Delete Item Page",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void loadItemData(DefaultTableModel tableModel) {
        try {
            Connection conn = dataSource.getConnection();
            String query = "SELECT * FROM items";

            Statement state = conn.createStatement();
            ResultSet rset = state.executeQuery(query);

            while (rset.next()) {
                String itemName = rset.getString("name");
                int qty = rset.getInt("quantity");
                int lowStockLevel = rset.getInt("low_stock_level");
                int categoryId = rset.getInt("category_id");
                int companyId = rset.getInt("company_id");

                String category = "";
                switch (categoryId) {
                    case 1 -> {
                        category = "Primer";
                    }
                    case 2 -> {
                        category = "Sekunder";
                    }
                    case 3 -> {
                        category = "Tersier";
                    }
                    default ->
                        throw new AssertionError();
                }

                addItem(new Item(
                        itemName,
                        qty,
                        lowStockLevel,
                        companyId,
                        category
                ));
                int index = itemList.size() - 1;

                tableModel.addRow(new Object[]{
                    itemList.get(index).getItemName(),
                    itemList.get(index).getQuantity(),
                    itemList.get(index).getLow_stock_level(),
                    itemList.get(index).getCategory_name(),
                    itemList.get(index).getCompany_id()
                });
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
