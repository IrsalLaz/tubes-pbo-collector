package controller;

import java.sql.*;
import java.util.ArrayList;
import model.Category;

public class CategoryController {
    private static final ArrayList<Category> categoryList = new ArrayList<>();
    private Connection conn;
    private final DBConnection db = new DBConnection();
    
    public ArrayList<Category> getCategoryList() {
        return categoryList;
    }
    
    public void loadComboBoxItemCategory() {
        try {
            conn = db.dbConn();
            String query = "SELECT * FROM categories";
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            categoryList.clear();
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String categoryName = rs.getString("category_name");
                
                addCategory(new Category(
                        id,
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
