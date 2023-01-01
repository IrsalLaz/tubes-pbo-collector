package controller;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Category;

public class CategoryController {
    private static final ArrayList<Category> categoryList = new ArrayList<>();
    private Connection conn;
    private final DBConnection db = new DBConnection();
    
    public ArrayList<Category> getCategory() {
        return categoryList;
    }
    
    public void loadComboBoxItemCategory() {
        try {
            conn = db.dbConn();
            String query = "SELECT * FROM categories";
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) {
                String categoryName = rs.getString("category_name");
                
                addCategory(new Category(
                        categoryName
                ));
            }
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void addCategory(Category category) {
        categoryList.add(category);
    }
}
