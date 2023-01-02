/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author panji
 */
public class Department {
    protected int id;
    protected String department_name;

    public Department(int id, String department_name) {
        this.id = id;
        this.department_name = department_name;
    }

    public int getId() {
        return id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
}
