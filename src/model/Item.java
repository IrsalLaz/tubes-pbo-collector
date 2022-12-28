/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author panji
 */
public class Item {
    private String name;
    private int quantity;
    private int low_stock_level;
    private int category_id;
    private int company_id;

    public Item(String name, int quantity, int low_stock_level, int category_id, int company_id) {
        this.name = name;
        this.quantity = quantity;
        this.low_stock_level = low_stock_level;
        this.category_id = category_id;
        this.company_id = company_id;
    }

    public int getLow_stock_level() {
        return low_stock_level;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCategory_id() {
        return category_id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public void setLow_stock_level(int low_stock_level) {
        this.low_stock_level = low_stock_level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
