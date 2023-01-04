/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author panji
 */
public class Admin extends Employee {
    private String password;

    public Admin(String password, int status, String employee_name, String nip, int id, String department_name) {
        super(status, employee_name, nip, id, department_name);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int getStatus() {
        return super.getStatus();
    }

    @Override
    public String getEmployee_name() {
        return super.getEmployee_name();
    }

    @Override
    public String getNip() {
        return super.getNip();
    }

    @Override
    public String getDepartment_name() {
        return super.getDepartment_name();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setEmployee_name(String employee_name) {
        super.setEmployee_name(employee_name);
    }

    @Override
    public void setNip(String nip) {
        super.setNip(nip);
    }

    @Override
    public void setDepartment_name(String department_name) {
        super.setDepartment_name(department_name);
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public void setStatus(int status) {
        super.setStatus(status);
    }
}