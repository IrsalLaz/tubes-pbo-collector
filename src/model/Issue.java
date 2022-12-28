/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author panji
 */
public class Issue {
    private String issue_by;
    private String quantity;

    public Issue(String issue_by, String quantity) {
        this.issue_by = issue_by;
        this.quantity = quantity;
    }

    public String getIssue_by() {
        return issue_by;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setIssue_by(String issue_by) {
        this.issue_by = issue_by;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
