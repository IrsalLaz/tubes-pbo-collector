package model;

public class Transaction {
    private int amount;
    private String action;
    private Item item;
    private Company company;
    private String tanggal_transaksi;

    public Transaction(int amount, String action, Item item, Company company, String tanggal_transaksi) {
        this.amount = amount;
        this.action = action;
        this.item = item;
        this.company = company;
        this.tanggal_transaksi = tanggal_transaksi;
    }

    public int getAmount() {
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

    public String getTanggal_transaksi() {
        return tanggal_transaksi;
    }

    public void setAmount(int amount) {
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

    public void setTanggal_transaksi(String tanggal_transaksi) {
        this.tanggal_transaksi = tanggal_transaksi;
    }
}
