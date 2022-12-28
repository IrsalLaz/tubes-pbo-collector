/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author panji
 */
public class Company {

    private String name;
    private String addresss;
    private String email;
    private String phone;
    private String designation;

    public Company(String name, String addresss, String email, String phone, String designation) {
        this.name = name;
        this.addresss = addresss;
        this.email = email;
        this.phone = phone;
        this.designation = designation;
    }

    public String getAddresss() {
        return addresss;
    }

    public String getDesignation() {
        return designation;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Company() {
    }

    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }
    
    
}
