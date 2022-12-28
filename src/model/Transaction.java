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
    private String quantity;
    private String action;

    public Transaction(String quantity, String action) {
        this.quantity = quantity;
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
