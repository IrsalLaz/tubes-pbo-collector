/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author panji
 */
public class Transaction {
    private String amount;
    private String action;
    private Item item;
    private Company company;

    public Transaction(String amount, String action, Item item, Company company) {
        this.amount = amount;
        this.action = action;
        this.item = item;
        this.company = company;
    }

    public String getAmount() {
        return amount;
    }

    public String getAction() {
        return action;
    }

    public Item getItem() {
        return item;
    }

    public Company getCompany() {
        return company;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setCompany(Company company) {
        this.company = company;
    }    
}
