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
    private int company_id;

    public Item(
            String item_name, 
            int quantity, 
            int low_stock_level, 
            int company_id,
            String category_name
    ) {
        super(category_name);
        this.item_name = item_name;
        this.quantity = quantity;
        this.low_stock_level = low_stock_level;
        this.company_id = company_id;
    }

    public int getLow_stock_level() {
        return low_stock_level;
    }

    public String getItemName() {
        return item_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public void setLow_stock_level(int low_stock_level) {
        this.low_stock_level = low_stock_level;
    }

    public void setItemName(String name) {
        this.item_name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String getCategory_name() {
        return super.getCategory_name();
    }
}
