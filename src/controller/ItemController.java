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
            String name = "";
            int qty = 0, lowStock = 0;
            Connection conn = dataSource.getConnection();
            
            if(!itemList.isEmpty()) {
                String query = "SELECT * FROM items";
                
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                
                if(rs.next()) {
                    name = rs.getString("name");
                    qty = rs.getInt("quantity");
                    lowStock = rs.getInt("low_stack_level");
                }
                
                if(textName.equals(name)) {
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
                    
                    addItem(new Item(
                            textName,
                            textQty,
                            textLowStock,
                            textCategoryId,
                            textCompanyId
                    ));
                    
                    int index = itemList.size() - 1;
                    
                    tableModel.addRow(new Object[] {
                        itemList.get(index).getName(),
                        itemList.get(index).getQuantity(),
                        itemList.get(index).getLow_stock_level(),
                        itemList.get(index).getCategory_id(),
                        itemList.get(index).getCompany_id()
                    });
                }
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void addItem(Item item) {
        itemList.add(item);
    }
}
