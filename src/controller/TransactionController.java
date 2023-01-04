package controller;

import java.awt.Component;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Company;
import model.Item;
import model.Transaction;

public class TransactionController {

    private static final ArrayList<Transaction> transactionList = new ArrayList<>();
    private static final ItemController itemController = new ItemController();
    private static final CompanyController companyController = new CompanyController();
    private Connection conn;
    private final DBConnection db = new DBConnection();

    public ArrayList<Transaction> getTransactionList() {
        return transactionList;
    }

    // Create
    public void insertTransactionBeli(
            Component parentComponent,
            String textNamaBarang,
            String textNamaPerusahaan,
            String textCategory,
            String textAction,
            int textQuantity,
            String textDescription,
            DefaultTableModel tableModelTransaction,
            DefaultTableModel tableModelItem
    ) {
        try {
            conn = db.dbConn();

            int result = JOptionPane.showConfirmDialog(
                    parentComponent,
                    "Apakah anda yakin ingin menambahkan transaksi beli?",
                    "Pembelian",
                    JOptionPane.YES_NO_OPTION
            );

            if (result == JOptionPane.YES_OPTION) {
                itemController.insertItem(
                        parentComponent,
                        textCategory,
                        textNamaBarang,
                        textQuantity,
                        textDescription,
                        tableModelItem
                );

                String idBarang = getItemID(textNamaBarang);
                int idCompany = getCompanyID(textNamaPerusahaan);
                Company getCompany = getCompany(textNamaPerusahaan);

                Item item = new Item(
                        idBarang,
                        textNamaBarang,
                        textQuantity,
                        idCompany,
                        textDescription,
                        idCompany,
                        textCategory
                );

                String insertQuery = "INSERT INTO transactions("
                        + "item_id, "
                        + "company_id, "
                        + "amount, "
                        + "action, "
                        + "created_at, "
                        + "updated_at) "
                        + "VALUES(?,?,?,?,?,?)";

                PreparedStatement ps = conn.prepareStatement(insertQuery);
                ps.setString(1, idBarang);
                ps.setInt(2, idCompany);
                ps.setInt(3, textQuantity);
                ps.setString(4, textAction);

                Timestamp tmp = new Timestamp(System.currentTimeMillis());

                ps.setTimestamp(5, tmp);
                ps.setTimestamp(6, tmp);
                ps.executeUpdate();

                Date date = new Date(tmp.getTime());
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = formatter.format(date);

                addTransaction(new Transaction(
                        textQuantity,
                        textAction,
                        item,
                        getCompany,
                        formattedDate
                ));

                int index = transactionList.size() - 1;
                tableModelTransaction.addRow(new Object[]{
                    transactionList.get(index).getItem().getItem_name(),
                    transactionList.get(index).getCompany().getCompany_name(),
                    transactionList.get(index).getAmount(),
                    transactionList.get(index).getAction(),
                    transactionList.get(index).getTanggal_transaksi()
                });

                JOptionPane.showMessageDialog(
                        parentComponent,
                        "Transaksi berhasil dilakukan!",
                        "Item Page",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                // Kosong
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(
                    parentComponent,
                    "Gagal menambahkan transaksi baru, periksa koneksi anda",
                    "Item Page",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    public void insertTransactionJual(
            Component parentComponent,
            String textKodeBarang,
            String textCompany,
            int textAmount,
            String textAction,
            DefaultTableModel tableModelTransaction,
            DefaultTableModel tableModelItem
    ) {
        try {
            conn = db.dbConn();

            int result = JOptionPane.showConfirmDialog(
                    parentComponent,
                    "Apakah anda yakin ingin menambahkan transaksi jual?",
                    "Penjualan",
                    JOptionPane.YES_NO_OPTION
            );

            if (result == JOptionPane.YES_OPTION) {
                int idCompany = getCompanyID(textCompany);
                Company getCompany = getCompany(textCompany);
                Item getItem = getItem(textKodeBarang);

                String insertQuery = "INSERT INTO transactions("
                        + "item_id, "
                        + "company_id, "
                        + "amount, "
                        + "action, "
                        + "created_at, "
                        + "updated_at) "
                        + "VALUES(?,?,?,?,?,?)";

                PreparedStatement ps = conn.prepareStatement(insertQuery);
                ps.setString(1, textKodeBarang);
                ps.setInt(2, idCompany);
                ps.setInt(3, textAmount);
                ps.setString(4, textAction);

                Timestamp tmp = new Timestamp(System.currentTimeMillis());

                ps.setTimestamp(5, tmp);
                ps.setTimestamp(6, tmp);
                ps.executeUpdate();

                Date date = new Date(tmp.getTime());
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = formatter.format(date);

                addTransaction(new Transaction(
                        textAmount,
                        textAction,
                        getItem,
                        getCompany,
                        formattedDate
                ));

                itemController.setQuantity(
                        parentComponent,
                        textKodeBarang,
                        textAmount,
                        tableModelItem
                );

                int index = transactionList.size() - 1;
                tableModelTransaction.addRow(new Object[]{
                    transactionList.get(index).getItem().getItem_name(),
                    transactionList.get(index).getCompany().getCompany_name(),
                    transactionList.get(index).getAmount(),
                    transactionList.get(index).getAction(),
                    transactionList.get(index).getTanggal_transaksi()
                });

                JOptionPane.showMessageDialog(
                        parentComponent,
                        "Transaksi berhasil dilakukan!",
                        "Item Page",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                // Kosong
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(
                    parentComponent,
                    "Gagal menambahkan transaksi baru, periksa koneksi anda",
                    "Item Page",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // Search
    public void searchTransaction(
            Component parentComponent,
            String search,
            DefaultTableModel tableModel,
            JTextField inputCariTransaction,
            JButton btnHapusPencarianTransaction,
            JButton btnCariTransaction
    ) {
        try {
            conn = db.dbConn();
            String searchQuery = "SELECT * FROM transactions tr "
                    + "JOIN items it ON it.item_id = tr.item_id "
                    + "JOIN companies co ON co.id = tr.company_id "
                    + "WHERE LOWER(it.item_name) LIKE ? OR "
                    + "LOWER(co.company_name) LIKE ? OR "
                    + "LOWER(tr.action) LIKE ? OR "
                    + "LOWER(tr.created_at) LIKE ?";

            PreparedStatement ps = conn.prepareStatement(searchQuery);
            ps.setString(1, "%" + search.toLowerCase() + "%");
            ps.setString(2, "%" + search.toLowerCase() + "%");
            ps.setString(3, "%" + search.toLowerCase() + "%");
            ps.setString(4, "%" + search.toLowerCase() + "%");
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(parentComponent,
                        "Transaksi yang anda cari tidak ada",
                        "Search Data",
                        JOptionPane.INFORMATION_MESSAGE
                );

                inputCariTransaction.setText("");

                return;
            } else {
                transactionList.clear();

                tableModel.setRowCount(0);
                tableModel.fireTableRowsDeleted(0, transactionList.size());

                do {
                    String itemID = rs.getString("item_id");
                    int companyID = rs.getInt("company_id");
                    int amount = rs.getInt("amount");
                    String action = rs.getString("action");
                    Timestamp tmp = rs.getTimestamp("created_at");

                    Item item = getItem(itemID);
                    Company company = getCompany(companyID);

                    Date date = new Date(tmp.getTime());
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String formattedDate = formatter.format(date);

                    addTransaction(new Transaction(
                            amount,
                            action,
                            item,
                            company,
                            formattedDate
                    ));

                    int index = transactionList.size() - 1;

                    tableModel.addRow(new Object[]{
                        transactionList.get(index).getItem().getItem_name(),
                        transactionList.get(index).getCompany().getCompany_name(),
                        transactionList.get(index).getAmount(),
                        transactionList.get(index).getAction(),
                        transactionList.get(index).getTanggal_transaksi()
                    });
                } while (rs.next());
            }
            btnHapusPencarianTransaction.setVisible(true);
            btnCariTransaction.setVisible(false);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(
                    parentComponent,
                    "Gagal Mencari Data, periksa koneksi anda",
                    "Cari Item",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    private void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    private String getItemID(String textNamaBarang) {
        ArrayList<Item> itList = itemController.getItemList();
        String id = "";

        for (Item it : itList) {
            if (it.getItem_name().equals(textNamaBarang)) {
                id = it.getItem_id();
            }
        }

        return id;
    }

    private int getCompanyID(String textNamaPerusahaan) {
        return companyController.getID(textNamaPerusahaan);
    }

    private Company getCompany(String textNamaPerusahaan) {
        return companyController.getObject(textNamaPerusahaan);
    }

    private Company getCompany(int textIdPerusahaan) {
        try {
            conn = db.dbConn();
            String getName = "SELECT * FROM companies WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(getName);
            ps.setInt(1, textIdPerusahaan);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getInt("id") == textIdPerusahaan) {
                    String name = rs.getString("company_name");
                    String address = rs.getString("address");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");

                    return new Company(
                            name,
                            address,
                            email,
                            phone
                    );
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    private Item getItem(String textKodeBarang) {
        ArrayList<Item> itList = itemController.getItemList();

        for (Item it : itList) {
            if (it.getItem_id().equals(textKodeBarang)) {
                return new Item(
                        it.getItem_id(),
                        it.getItem_name(),
                        it.getQuantity(),
                        it.getLow_stock_level(),
                        it.getDescription(),
                        it.getCategory_id(),
                        it.getCategory_name()
                );
            }
        }
        return null;
    }

    public void loadTransaction(DefaultTableModel tableModel) {
        try {
            conn = db.dbConn();
            String query = "SELECT * FROM transactions";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            transactionList.clear();

            tableModel.setRowCount(0);
            tableModel.fireTableRowsDeleted(0, transactionList.size());

            while (rs.next()) {
                String itemID = rs.getString("item_id");
                int companyID = rs.getInt("company_id");
                int amount = rs.getInt("amount");
                String action = rs.getString("action");
                Timestamp tmp = rs.getTimestamp("created_at");

                Item item = getItem(itemID);
                Company company = getCompany(companyID);

                Date date = new Date(tmp.getTime());
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = formatter.format(date);

                addTransaction(new Transaction(
                        amount,
                        action,
                        item,
                        company,
                        formattedDate
                ));

                int index = transactionList.size() - 1;

                tableModel.addRow(new Object[]{
                    transactionList.get(index).getItem().getItem_name(),
                    transactionList.get(index).getCompany().getCompany_name(),
                    transactionList.get(index).getAmount(),
                    transactionList.get(index).getAction(),
                    transactionList.get(index).getTanggal_transaksi()
                });
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
