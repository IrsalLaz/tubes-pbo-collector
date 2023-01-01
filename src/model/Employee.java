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
    protected String employee_name;
    protected String nip;

    public Employee(String employee_name, String nip, String department_name) {
        super(department_name);
        this.employee_name = employee_name;
        this.nip = nip;
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

    @Override
    public String getDepartment_name() {
        return super.getDepartment_name();
    }

    @Override
    public void setDepartment_name(String department_name) {
        super.setDepartment_name(department_name);
    }
}