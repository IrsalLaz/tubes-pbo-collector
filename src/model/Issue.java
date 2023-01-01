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
    private int stacks;
    private String issue_description;
    private Item item;
    private Employee employee;

    public Issue(int stacks, String issue_description, Item item, Employee employee) {
        this.stacks = stacks;
        this.issue_description = issue_description;
        this.item = item;
        this.employee = employee;
    }

    public int getStacks() {
        return stacks;
    }

    public String getIssue_description() {
        return issue_description;
    }

    public Item getItem() {
        return item;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setStacks(int stacks) {
        this.stacks = stacks;
    }

    public void setIssue_description(String issue_description) {
        this.issue_description = issue_description;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
