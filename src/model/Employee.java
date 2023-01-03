/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author panji
 */
public class Employee extends Department {
    protected int status;
    protected String employee_name;
    protected String nip;

    public Employee(int status, String employee_name, String nip, int id, String department_name) {
        super(id, department_name);
        this.status = status;
        this.employee_name = employee_name;
        this.nip = nip;
    }

    public int getStatus() {
        return status;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public String getNip() {
        return nip;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }
    
    public void setNip(String nip) {
        this.nip = nip;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getDepartment_name() {
        return super.getDepartment_name();
    }

    @Override
    public int getId() {
        return super.getId(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setId(int id) {
        super.setId(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setDepartment_name(String department_name) {
        super.setDepartment_name(department_name);
    }
}