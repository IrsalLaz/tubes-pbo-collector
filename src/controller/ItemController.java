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
    
    public void addItem(
            Component parentComponent, 
            String textName, 
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
                    String insertQuery = "INSERT INTO items(name, quantity, low_stock_quantity) VALUES(?,?,?)";
                }
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
