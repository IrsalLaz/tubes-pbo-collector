/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author panji
 */
public class Employee {
    private String epf_number;
    private String name;
    private String nip;
    private String model;
    private int department_id;

    public Employee(String epf_number, String name, String nip, String model, int department_id) {
        this.epf_number = epf_number;
        this.name = name;
        this.nip = nip;
        this.model = model;
        this.department_id = department_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public String getEpf_number() {
        return epf_number;
    }

    public String getName() {
        return name;
    }

    public String getNip() {
        return nip;
    }

    public String getModel() {
        return model;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public void setEpf_number(String epf_number) {
        this.epf_number = epf_number;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }   
}