/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author panji
 */
public class Item extends Category {
    private String item_name;
    private int quantity;
    private int low_stock_level;
    private int description;

    public Item(String item_name, int quantity, int low_stock_level, int description, String category_name) {
        super(category_name);
        this.item_name = item_name;
        this.quantity = quantity;
        this.low_stock_level = low_stock_level;
        this.description = description;
    }

    public String getItem_name() {
        return item_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getLow_stock_level() {
        return low_stock_level;
    }

    public int getDescription() {
        return description;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setLow_stock_level(int low_stock_level) {
        this.low_stock_level = low_stock_level;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    @Override
    public String getCategory_name() {
        return super.getCategory_name();
    }

    @Override
    public void setCategory_name(String category_name) {
        super.setCategory_name(category_name);
    }
    
    
}
