package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Department;

public class DepartmentController {
    private static final ArrayList<Department> departmentList = new ArrayList<>();
    private Connection conn;
    private final DBConnection db = new DBConnection();
    
    public ArrayList<Department> getDepartmentList() {
        return departmentList;
    }
    
    public void loadComboBoxItemDepartment() {
        try {
            conn = db.dbConn();
            String query = "SELECT * FROM departments";
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            departmentList.clear();
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String departmentName = rs.getString("department_name");
                
                addDeparment(new Department(
                        id,
                        departmentName
                ));
            }
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void addDeparment(Department department) {
        departmentList.add(department);
    }
}
