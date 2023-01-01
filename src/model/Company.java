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

    private String company_name;
    private String addresss;
    private String email;
    private String phone;

    public Company(String company_name, String addresss, String email, String phone) {
        this.company_name = company_name;
        this.addresss = addresss;
        this.email = email;
        this.phone = phone;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getAddresss() {
        return addresss;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
