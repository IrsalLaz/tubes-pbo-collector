package view.main;

import controller.AdminController;
import controller.CategoryController;
import controller.CompanyController;
import controller.DepartmentController;
import controller.EmployeeController;
import controller.IDGenerator;
import controller.IssueController;
import controller.ItemController;
import controller.TransactionController;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableModel;
import model.Category;
import model.Company;
import model.Department;
import model.Employee;
import model.Item;

public class Home extends javax.swing.JFrame {

    // Controller
    private final CompanyController companyController = new CompanyController();
    private final DepartmentController departmentController = new DepartmentController();
    private final EmployeeController employeeController = new EmployeeController();
    private final AdminController admin = new AdminController();
    private final ItemController itemController = new ItemController();
    private final TransactionController transactionController = new TransactionController();
    private final CategoryController categoryController = new CategoryController();
    private final IssueController issueController = new IssueController();

    // Table
    private final DefaultTableModel modelSuplier = new DefaultTableModel();
    private final DefaultTableModel modelKaryawan = new DefaultTableModel();
    private final DefaultTableModel modelItem = new DefaultTableModel();
    private final DefaultTableModel modelTransaction = new DefaultTableModel();
    private final DefaultTableModel modelIssue = new DefaultTableModel();

    // ID Generator
    private final IDGenerator idGenereator = new IDGenerator();

    // Image
    ImageIcon logoImg = new ImageIcon("logo.png");

    // Layout
    CardLayout cardLayout;

    public Home() {
        initComponents();

        idGenereator.readLastNumber();
        idGenereator.readUsedID();

        addItemComboBox();
        setupTable();
        setupButton();

        Component[] components = this.getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                ((JButton) component).setUI(new BasicButtonUI());
                ((JButton) component).setFocusPainted(false);
            }
        }

        cardLayout = (CardLayout) (panelPages.getLayout());
    }

    private void setupButton() {
        // Company
        btnUpdateSuplier1.setVisible(false);
        btnDeleteSuplier2.setVisible(false);
        btnResetSuplier3.setVisible(false);
        btnHapusPencarianCompany.setVisible(false);

        // Employee
        btnUpdateKaryawan.setVisible(false);
        btnDeleteKaryawan.setVisible(false);
        btnResetKaryawan.setVisible(false);
        btnHapusPencarianKaryawan.setVisible(false);

        // Admin
        PassFieldNewAdmin.setVisible(false);
        labelPassNewAdmin.setVisible(false);

        // Stok Barang
        inputNBarangEdit.setEnabled(false);
        inputJumlahEdit.setEnabled(false);
        cbKategoriEdit.setEnabled(false);
        taDeskripsiEdit.setEnabled(false);
        btnHapusBarangEdit.setVisible(false);
        btnResetBarangEdit.setVisible(false);
        btnHapusPencarianBarang.setVisible(false);

        // Transaction
        labelDisabledNBarang.setEnabled(false);
        inputDisabledNBarang.setEnabled(false);

        // Issue
        btnUpdateLaporan.setVisible(false);
        btnHapusLaporan2.setVisible(false);
        btnResetLaporan.setVisible(false);
        btnHapusPencarianLaporan.setVisible(false);
        labelNBarangLapor.setEnabled(false);
        inputNBarangLapor.setEnabled(false);
    }

    private void setupTable() {
        // Company
        modelSuplier.addColumn("company name");
        modelSuplier.addColumn("email");
        modelSuplier.addColumn("phone");
        modelSuplier.addColumn("address");

        tableSuplier.setModel(modelSuplier);
        companyController.loadCompany(modelSuplier);

        // Karyawan
        modelKaryawan.addColumn("NIP");
        modelKaryawan.addColumn("Nama");
        modelKaryawan.addColumn("Department");

        tableKaryawan.setModel(modelKaryawan);
        employeeController.loadEmployee(modelKaryawan);

        // Item
        modelItem.addColumn("ID");
        modelItem.addColumn("Item Name");
        modelItem.addColumn("Category");
        modelItem.addColumn("Quantity");
        modelItem.addColumn("Low Stock Level");
        modelItem.addColumn("Description");

        tableStokBarang.setModel(modelItem);
        itemController.loadItem(modelItem);

        // Transaction
        modelTransaction.addColumn("Item Name");
        modelTransaction.addColumn("Company");
        modelTransaction.addColumn("Amount");
        modelTransaction.addColumn("Action");

        tableTransaksi.setModel(modelTransaction);
        transactionController.loadTransaction(modelTransaction);

        // Issue
        modelIssue.addColumn("issue id");
        modelIssue.addColumn("item name");
        modelIssue.addColumn("employee name");
        modelIssue.addColumn("stacks");
        modelIssue.addColumn("description");

        tableLaporkan.setModel(modelIssue);
        issueController.loadIssue(modelIssue);
    }

    private void addItemComboBox() {
        // Company
        cbPerusahaan.removeAllItems();
        cbPerusahaanJual.removeAllItems();
        cbPerusahaan.addItem("Select Perusahaan");
        cbPerusahaanJual.addItem("Select Perusahaan");
        companyController.loadComboBoxItemCompany();
        ArrayList<Company> company = companyController.getCompanyList();

        for (Company c : company) {
            cbPerusahaan.addItem(c.getCompany_name());
            cbPerusahaanJual.addItem(c.getCompany_name());
        }

        // Department
        cbDepartemen.removeAllItems();
        cbDepartemen.addItem("Select Department");
        departmentController.loadComboBoxItemDepartment();
        ArrayList<Department> department = departmentController.getDepartmentList();

        for (Department d : department) {
            cbDepartemen.addItem(d.getDepartment_name());
        }

        // Item
        cbKodeBarangJual.removeAllItems();
        cbKodeBarangLapor.removeAllItems();
        cbKodeBarangLapor.addItem("Select Kode Barang");
        cbKodeBarangJual.addItem("Select Kode Barang");
        itemController.loadComboBoxItemItem();
        ArrayList<Item> item = itemController.getItemList();

        for (Item it : item) {
            cbKodeBarangJual.addItem(it.getItem_id());
            cbKodeBarangLapor.addItem(it.getItem_id());
        }

        // Employee
        cbPelapor.removeAllItems();
        cbPelapor.addItem("Select Karyawan");
        employeeController.loadComboBoxItemCompany();
        ArrayList<Employee> employee = employeeController.getEmployeeList();

        for (Employee em : employee) {
            cbPelapor.addItem(em.getEmployee_name());
        }

        // Category
        cbKategori.removeAllItems();
        cbKategoriEdit.removeAllItems();
        cbKategori.addItem("Select Kategori");
        cbKategoriEdit.addItem("Select Kategori");
        categoryController.loadComboBoxItemCategory();
        ArrayList<Category> category = categoryController.getCategoryList();

        for (Category c : category) {
            cbKategori.addItem(c.getCategory_name());
            cbKategoriEdit.addItem(c.getCategory_name());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane10 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jSpinner1 = new javax.swing.JSpinner();
        jSplitPane1 = new javax.swing.JSplitPane();
        Sidebar = new javax.swing.JPanel();
        btnLogo = new javax.swing.JButton();
        btnTransaksi = new javax.swing.JButton();
        btnLaporBarang = new javax.swing.JButton();
        btnStok = new javax.swing.JButton();
        btnKaryawan = new javax.swing.JButton();
        btnSuplier = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        panelPages = new javax.swing.JPanel();
        transaksiPage = new javax.swing.JPanel();
        header = new javax.swing.JDesktopPane();
        title = new javax.swing.JLabel();
        labelKodeBarangBeli = new javax.swing.JLabel();
        inputKBarangBeli = new javax.swing.JTextField();
        inputNBarang = new javax.swing.JTextField();
        labelNamaBarang = new javax.swing.JLabel();
        labelSuplierBeli = new javax.swing.JLabel();
        labelJumlahPembelian = new javax.swing.JLabel();
        inputJumlahPembelian = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTransaksi = new javax.swing.JTable();
        labelPembelian = new javax.swing.JLabel();
        btnCariBarang1 = new javax.swing.JButton();
        inputCariBarang1 = new javax.swing.JTextField();
        labelDeskripsi = new javax.swing.JLabel();
        cbPerusahaan = new javax.swing.JComboBox<>();
        btnTambahPembelian = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        inputDeskripsiBarang = new javax.swing.JTextArea();
        labelPembelian1 = new javax.swing.JLabel();
        labelKodeBarangBeliJual = new javax.swing.JLabel();
        cbKodeBarangJual = new javax.swing.JComboBox<>();
        labelPerusahaanJual = new javax.swing.JLabel();
        cbPerusahaanJual = new javax.swing.JComboBox<>();
        labelJumlahPenjualan = new javax.swing.JLabel();
        inputJumlahPenjualan = new javax.swing.JTextField();
        btnTambahPenjualan = new javax.swing.JButton();
        labelKategori = new javax.swing.JLabel();
        cbKategori = new javax.swing.JComboBox<>();
        inputDisabledNBarang = new javax.swing.JTextField();
        labelDisabledNBarang = new javax.swing.JLabel();
        laporBarangPage = new javax.swing.JPanel();
        header4 = new javax.swing.JDesktopPane();
        title4 = new javax.swing.JLabel();
        labelKodeBarangLapor = new javax.swing.JLabel();
        inputNBarangLapor = new javax.swing.JTextField();
        labelNBarangLapor = new javax.swing.JLabel();
        labelNPelapor = new javax.swing.JLabel();
        btnSimpanLaporan = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableLaporkan = new javax.swing.JTable();
        btnCariLaporan = new javax.swing.JButton();
        inputCariLaporan = new javax.swing.JTextField();
        lableKeteranganLapor = new javax.swing.JLabel();
        cbKodeBarangLapor = new javax.swing.JComboBox<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        taKeterangan = new javax.swing.JTextArea();
        cbPelapor = new javax.swing.JComboBox<>();
        inputJmlBarangLapor1 = new javax.swing.JTextField();
        labelJmlBarangLapor1 = new javax.swing.JLabel();
        btnUpdateLaporan = new javax.swing.JButton();
        btnHapusLaporan2 = new javax.swing.JButton();
        btnResetLaporan = new javax.swing.JButton();
        btnHapusPencarianLaporan = new javax.swing.JButton();
        stokPage = new javax.swing.JPanel();
        header2 = new javax.swing.JDesktopPane();
        title2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableStokBarang = new javax.swing.JTable();
        btnCariBarang = new javax.swing.JButton();
        inputPencarianBarang = new javax.swing.JTextField();
        labelPembelian2 = new javax.swing.JLabel();
        labelJumlahEdit = new javax.swing.JLabel();
        labelNamaBarangEdit = new javax.swing.JLabel();
        labelDeskripsiEdit = new javax.swing.JLabel();
        inputNBarangEdit = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        taDeskripsiEdit = new javax.swing.JTextArea();
        labelKategoriEdit1 = new javax.swing.JLabel();
        cbKategoriEdit = new javax.swing.JComboBox<>();
        inputJumlahEdit = new javax.swing.JTextField();
        btnUpdateBarangEdit = new javax.swing.JButton();
        btnHapusBarangEdit = new javax.swing.JButton();
        btnResetBarangEdit = new javax.swing.JButton();
        btnHapusPencarianBarang = new javax.swing.JButton();
        karyawanPage = new javax.swing.JPanel();
        header1 = new javax.swing.JDesktopPane();
        title1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelNIP = new javax.swing.JLabel();
        inputNIP = new javax.swing.JTextField();
        labelNamaKaryawan = new javax.swing.JLabel();
        labelDepartemen = new javax.swing.JLabel();
        inputNKaryawan1 = new javax.swing.JTextField();
        cbDepartemen = new javax.swing.JComboBox<>();
        btnUpdateKaryawan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableKaryawan = new javax.swing.JTable();
        btnCariKaryawan = new javax.swing.JButton();
        inputCariKaryawan = new javax.swing.JTextField();
        btnDeleteKaryawan = new javax.swing.JButton();
        btnTambahKaryawan = new javax.swing.JButton();
        btnResetKaryawan = new javax.swing.JButton();
        btnHapusPencarianKaryawan = new javax.swing.JButton();
        labelStatus = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox<>();
        labelPassNewAdmin = new javax.swing.JLabel();
        PassFieldNewAdmin = new javax.swing.JPasswordField();
        suplierPage = new javax.swing.JPanel();
        header3 = new javax.swing.JDesktopPane();
        title3 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputNPerusahaan = new javax.swing.JTextField();
        labelNPerusahaan = new javax.swing.JLabel();
        inputEmail = new javax.swing.JTextField();
        labelEmail = new javax.swing.JLabel();
        inputTelepon = new javax.swing.JTextField();
        labelTelepon = new javax.swing.JLabel();
        labelAlamat = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        taAlamat = new javax.swing.JTextArea();
        btnTambahSuplier = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableSuplier = new javax.swing.JTable();
        btnCariSuplier = new javax.swing.JButton();
        inputCariPerusahaan = new javax.swing.JTextField();
        btnUpdateSuplier1 = new javax.swing.JButton();
        btnDeleteSuplier2 = new javax.swing.JButton();
        btnResetSuplier3 = new javax.swing.JButton();
        btnHapusPencarianCompany = new javax.swing.JButton();

        jScrollPane10.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setPreferredSize(new java.awt.Dimension(960, 638));

        Sidebar.setBackground(new java.awt.Color(153, 153, 153));
        Sidebar.setMaximumSize(new java.awt.Dimension(190, 64));
        Sidebar.setMinimumSize(new java.awt.Dimension(190, 64));
        Sidebar.setPreferredSize(new java.awt.Dimension(190, 59));
        Sidebar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 10));

        btnLogo.setBackground(new java.awt.Color(38, 38, 38));
        btnLogo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnLogo.setForeground(new java.awt.Color(255, 255, 255));
        btnLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N
        btnLogo.setToolTipText("");
        btnLogo.setFocusable(false);
        btnLogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogo.setMaximumSize(new java.awt.Dimension(177, 39));
        btnLogo.setMinimumSize(new java.awt.Dimension(177, 39));
        btnLogo.setPreferredSize(new java.awt.Dimension(190, 100));
        btnLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoActionPerformed(evt);
            }
        });
        Sidebar.add(btnLogo);

        btnTransaksi.setBackground(new java.awt.Color(0, 0, 0));
        btnTransaksi.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        btnTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/default.png"))); // NOI18N
        btnTransaksi.setText("Transaksi");
        btnTransaksi.setToolTipText("");
        btnTransaksi.setFocusable(false);
        btnTransaksi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTransaksi.setMaximumSize(new java.awt.Dimension(177, 39));
        btnTransaksi.setMinimumSize(new java.awt.Dimension(177, 39));
        btnTransaksi.setPreferredSize(new java.awt.Dimension(177, 39));
        btnTransaksi.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/hover.png"))); // NOI18N
        btnTransaksi.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/active.png"))); // NOI18N
        btnTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaksiActionPerformed(evt);
            }
        });
        Sidebar.add(btnTransaksi);

        btnLaporBarang.setBackground(new java.awt.Color(0, 0, 0));
        btnLaporBarang.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnLaporBarang.setForeground(new java.awt.Color(255, 255, 255));
        btnLaporBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/default.png"))); // NOI18N
        btnLaporBarang.setText("Laporkan Barang");
        btnLaporBarang.setToolTipText("");
        btnLaporBarang.setFocusable(false);
        btnLaporBarang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLaporBarang.setMaximumSize(new java.awt.Dimension(177, 39));
        btnLaporBarang.setMinimumSize(new java.awt.Dimension(177, 39));
        btnLaporBarang.setPreferredSize(new java.awt.Dimension(177, 39));
        btnLaporBarang.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/hover.png"))); // NOI18N
        btnLaporBarang.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/active.png"))); // NOI18N
        btnLaporBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaporBarangActionPerformed(evt);
            }
        });
        Sidebar.add(btnLaporBarang);

        btnStok.setBackground(new java.awt.Color(0, 0, 0));
        btnStok.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnStok.setForeground(new java.awt.Color(255, 255, 255));
        btnStok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/default.png"))); // NOI18N
        btnStok.setText("Stok Barang");
        btnStok.setToolTipText("");
        btnStok.setFocusable(false);
        btnStok.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStok.setMaximumSize(new java.awt.Dimension(177, 39));
        btnStok.setMinimumSize(new java.awt.Dimension(177, 39));
        btnStok.setPreferredSize(new java.awt.Dimension(177, 39));
        btnStok.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/hover.png"))); // NOI18N
        btnStok.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/active.png"))); // NOI18N
        btnStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStokActionPerformed(evt);
            }
        });
        Sidebar.add(btnStok);

        btnKaryawan.setBackground(new java.awt.Color(0, 0, 0));
        btnKaryawan.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        btnKaryawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/default.png"))); // NOI18N
        btnKaryawan.setText("Karyawan");
        btnKaryawan.setToolTipText("");
        btnKaryawan.setFocusable(false);
        btnKaryawan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKaryawan.setMaximumSize(new java.awt.Dimension(177, 39));
        btnKaryawan.setMinimumSize(new java.awt.Dimension(177, 39));
        btnKaryawan.setPreferredSize(new java.awt.Dimension(177, 39));
        btnKaryawan.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/hover.png"))); // NOI18N
        btnKaryawan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/active.png"))); // NOI18N
        btnKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaryawanActionPerformed(evt);
            }
        });
        Sidebar.add(btnKaryawan);

        btnSuplier.setBackground(new java.awt.Color(0, 0, 0));
        btnSuplier.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnSuplier.setForeground(new java.awt.Color(255, 255, 255));
        btnSuplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/default.png"))); // NOI18N
        btnSuplier.setText("Perusahaan");
        btnSuplier.setToolTipText("");
        btnSuplier.setFocusable(false);
        btnSuplier.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSuplier.setMaximumSize(new java.awt.Dimension(177, 39));
        btnSuplier.setMinimumSize(new java.awt.Dimension(177, 39));
        btnSuplier.setPreferredSize(new java.awt.Dimension(177, 39));
        btnSuplier.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/hover.png"))); // NOI18N
        btnSuplier.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/active.png"))); // NOI18N
        btnSuplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuplierActionPerformed(evt);
            }
        });
        Sidebar.add(btnSuplier);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 250));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        Sidebar.add(jPanel1);

        btnLogout.setBackground(new java.awt.Color(123, 31, 31));
        btnLogout.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Logout");
        btnLogout.setToolTipText("");
        btnLogout.setFocusable(false);
        btnLogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogout.setMaximumSize(new java.awt.Dimension(177, 39));
        btnLogout.setMinimumSize(new java.awt.Dimension(177, 39));
        btnLogout.setPreferredSize(new java.awt.Dimension(177, 39));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        Sidebar.add(btnLogout);

        jSplitPane1.setLeftComponent(Sidebar);

        panelPages.setBackground(new java.awt.Color(0, 153, 153));
        panelPages.setPreferredSize(new java.awt.Dimension(765, 684));
        panelPages.setLayout(new java.awt.CardLayout());

        transaksiPage.setBackground(new java.awt.Color(255, 255, 255));

        title.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Transaksi");

        header.setLayer(title, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        labelKodeBarangBeli.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelKodeBarangBeli.setForeground(new java.awt.Color(51, 51, 51));
        labelKodeBarangBeli.setLabelFor(inputKBarangBeli);
        labelKodeBarangBeli.setText("Kode barang: ");

        inputNBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNBarangActionPerformed(evt);
            }
        });

        labelNamaBarang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelNamaBarang.setForeground(new java.awt.Color(51, 51, 51));
        labelNamaBarang.setLabelFor(inputNBarang);
        labelNamaBarang.setText("Nama barang: ");

        labelSuplierBeli.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelSuplierBeli.setForeground(new java.awt.Color(51, 51, 51));
        labelSuplierBeli.setLabelFor(cbPerusahaan);
        labelSuplierBeli.setText("Perusahaan:");

        labelJumlahPembelian.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelJumlahPembelian.setForeground(new java.awt.Color(51, 51, 51));
        labelJumlahPembelian.setLabelFor(inputJumlahPembelian);
        labelJumlahPembelian.setText("Jumlah :");

        tableTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "item name", "company", "amount", "action"
            }
        ));
        tableTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableTransaksi);

        labelPembelian.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        labelPembelian.setForeground(new java.awt.Color(51, 51, 51));
        labelPembelian.setText("Pembelian");

        btnCariBarang1.setBackground(new java.awt.Color(22, 103, 15));
        btnCariBarang1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnCariBarang1.setForeground(new java.awt.Color(255, 255, 255));
        btnCariBarang1.setText("Cari");
        btnCariBarang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariBarang1ActionPerformed(evt);
            }
        });

        labelDeskripsi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDeskripsi.setForeground(new java.awt.Color(51, 51, 51));
        labelDeskripsi.setLabelFor(inputDeskripsiBarang);
        labelDeskripsi.setText("Deskripsi");

        cbPerusahaan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Perusahaan" }));
        cbPerusahaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPerusahaanActionPerformed(evt);
            }
        });

        btnTambahPembelian.setBackground(new java.awt.Color(22, 103, 15));
        btnTambahPembelian.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnTambahPembelian.setForeground(new java.awt.Color(255, 255, 255));
        btnTambahPembelian.setText("Tambah");
        btnTambahPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahPembelianActionPerformed(evt);
            }
        });

        inputDeskripsiBarang.setColumns(20);
        inputDeskripsiBarang.setRows(5);
        jScrollPane9.setViewportView(inputDeskripsiBarang);

        labelPembelian1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        labelPembelian1.setForeground(new java.awt.Color(51, 51, 51));
        labelPembelian1.setText("Penjualan");

        labelKodeBarangBeliJual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelKodeBarangBeliJual.setForeground(new java.awt.Color(51, 51, 51));
        labelKodeBarangBeliJual.setText("Kode barang: ");

        cbKodeBarangJual.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Kode Barang" }));
        cbKodeBarangJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKodeBarangJualActionPerformed(evt);
            }
        });

        labelPerusahaanJual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelPerusahaanJual.setForeground(new java.awt.Color(51, 51, 51));
        labelPerusahaanJual.setText("Perusahaan");

        cbPerusahaanJual.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Perusahaan" }));
        cbPerusahaanJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPerusahaanJualActionPerformed(evt);
            }
        });

        labelJumlahPenjualan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelJumlahPenjualan.setForeground(new java.awt.Color(51, 51, 51));
        labelJumlahPenjualan.setText("Jumlah :");

        btnTambahPenjualan.setBackground(new java.awt.Color(22, 103, 15));
        btnTambahPenjualan.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnTambahPenjualan.setForeground(new java.awt.Color(255, 255, 255));
        btnTambahPenjualan.setText("Tambah");
        btnTambahPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahPenjualanActionPerformed(evt);
            }
        });

        labelKategori.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelKategori.setForeground(new java.awt.Color(51, 51, 51));
        labelKategori.setText("Kategori:");

        cbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Kategori" }));
        cbKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKategoriActionPerformed(evt);
            }
        });

        inputDisabledNBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDisabledNBarangActionPerformed(evt);
            }
        });

        labelDisabledNBarang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDisabledNBarang.setForeground(new java.awt.Color(51, 51, 51));
        labelDisabledNBarang.setText("Nama barang:");

        javax.swing.GroupLayout transaksiPageLayout = new javax.swing.GroupLayout(transaksiPage);
        transaksiPage.setLayout(transaksiPageLayout);
        transaksiPageLayout.setHorizontalGroup(
            transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header)
            .addGroup(transaksiPageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transaksiPageLayout.createSequentialGroup()
                        .addComponent(inputCariBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCariBarang1)
                        .addGap(12, 12, 12))
                    .addComponent(jScrollPane1)
                    .addGroup(transaksiPageLayout.createSequentialGroup()
                        .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTambahPembelian)
                            .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labelPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(transaksiPageLayout.createSequentialGroup()
                                    .addComponent(labelDeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(transaksiPageLayout.createSequentialGroup()
                                    .addComponent(labelNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(inputNBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(transaksiPageLayout.createSequentialGroup()
                                    .addComponent(labelSuplierBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbPerusahaan, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(transaksiPageLayout.createSequentialGroup()
                                    .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(labelJumlahPembelian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelKategori, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(inputJumlahPembelian)))))
                        .addGap(18, 18, 18)
                        .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(transaksiPageLayout.createSequentialGroup()
                                .addComponent(labelPembelian1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(258, 570, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transaksiPageLayout.createSequentialGroup()
                                .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(transaksiPageLayout.createSequentialGroup()
                                        .addComponent(labelKodeBarangBeliJual, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbKodeBarangJual, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(transaksiPageLayout.createSequentialGroup()
                                        .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(labelJumlahPenjualan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(labelPerusahaanJual, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                            .addComponent(labelDisabledNBarang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbPerusahaanJual, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(inputJumlahPenjualan)
                                            .addComponent(inputDisabledNBarang)))
                                    .addGroup(transaksiPageLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnTambahPenjualan)))
                                .addGap(36, 36, 36))))))
        );
        transaksiPageLayout.setVerticalGroup(
            transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiPageLayout.createSequentialGroup()
                .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(transaksiPageLayout.createSequentialGroup()
                        .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPembelian1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelPembelian, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(47, 47, 47)
                        .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelSuplierBeli)
                            .addComponent(cbPerusahaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelKategori)
                            .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelJumlahPembelian)
                            .addComponent(inputJumlahPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDeskripsi)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(transaksiPageLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelKodeBarangBeliJual)
                            .addComponent(cbKodeBarangJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNamaBarang)
                            .addComponent(inputNBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPerusahaanJual)
                            .addComponent(cbPerusahaanJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputJumlahPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelJumlahPenjualan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputDisabledNBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDisabledNBarang))
                        .addGap(10, 10, 10)
                        .addComponent(btnTambahPenjualan)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTambahPembelian)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputCariBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCariBarang1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        panelPages.add(transaksiPage, "transaksiPage");
        transaksiPage.getAccessibleContext().setAccessibleName("");

        laporBarangPage.setBackground(new java.awt.Color(255, 255, 255));

        title4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        title4.setForeground(new java.awt.Color(255, 255, 255));
        title4.setText("Laporkan Barang");

        header4.setLayer(title4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout header4Layout = new javax.swing.GroupLayout(header4);
        header4.setLayout(header4Layout);
        header4Layout.setHorizontalGroup(
            header4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(title4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        header4Layout.setVerticalGroup(
            header4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(title4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        labelKodeBarangLapor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelKodeBarangLapor.setForeground(new java.awt.Color(51, 51, 51));
        labelKodeBarangLapor.setText("Kode barang");

        inputNBarangLapor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNBarangLaporActionPerformed(evt);
            }
        });

        labelNBarangLapor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelNBarangLapor.setForeground(new java.awt.Color(51, 51, 51));
        labelNBarangLapor.setText("Nama Barang");

        labelNPelapor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelNPelapor.setForeground(new java.awt.Color(51, 51, 51));
        labelNPelapor.setText("Pelapor");

        btnSimpanLaporan.setBackground(new java.awt.Color(22, 103, 15));
        btnSimpanLaporan.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnSimpanLaporan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpanLaporan.setText("Simpan");
        btnSimpanLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanLaporanActionPerformed(evt);
            }
        });

        tableLaporkan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "issue id", "item name", "employee name", "stacks", "description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableLaporkan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLaporkanMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tableLaporkan);

        btnCariLaporan.setBackground(new java.awt.Color(22, 103, 15));
        btnCariLaporan.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnCariLaporan.setForeground(new java.awt.Color(255, 255, 255));
        btnCariLaporan.setText("Cari");
        btnCariLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariLaporanActionPerformed(evt);
            }
        });

        lableKeteranganLapor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lableKeteranganLapor.setForeground(new java.awt.Color(51, 51, 51));
        lableKeteranganLapor.setText("Keterangan");

        cbKodeBarangLapor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Kode Barang" }));
        cbKodeBarangLapor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKodeBarangLaporActionPerformed(evt);
            }
        });

        taKeterangan.setColumns(20);
        taKeterangan.setRows(5);
        jScrollPane7.setViewportView(taKeterangan);

        cbPelapor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Karyawan" }));

        inputJmlBarangLapor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputJmlBarangLapor1ActionPerformed(evt);
            }
        });

        labelJmlBarangLapor1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelJmlBarangLapor1.setForeground(new java.awt.Color(51, 51, 51));
        labelJmlBarangLapor1.setText("Jumlah");

        btnUpdateLaporan.setBackground(new java.awt.Color(22, 103, 15));
        btnUpdateLaporan.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnUpdateLaporan.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateLaporan.setText("Update");
        btnUpdateLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateLaporanActionPerformed(evt);
            }
        });

        btnHapusLaporan2.setBackground(new java.awt.Color(123, 31, 31));
        btnHapusLaporan2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnHapusLaporan2.setForeground(new java.awt.Color(255, 255, 255));
        btnHapusLaporan2.setText("Hapus");
        btnHapusLaporan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusLaporan2ActionPerformed(evt);
            }
        });

        btnResetLaporan.setBackground(new java.awt.Color(115, 114, 114));
        btnResetLaporan.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnResetLaporan.setForeground(new java.awt.Color(255, 255, 255));
        btnResetLaporan.setText("Reset");
        btnResetLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetLaporanActionPerformed(evt);
            }
        });

        btnHapusPencarianLaporan.setBackground(new java.awt.Color(115, 114, 114));
        btnHapusPencarianLaporan.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnHapusPencarianLaporan.setForeground(new java.awt.Color(255, 255, 255));
        btnHapusPencarianLaporan.setText("Hapus Pencarian");
        btnHapusPencarianLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusPencarianLaporanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout laporBarangPageLayout = new javax.swing.GroupLayout(laporBarangPage);
        laporBarangPage.setLayout(laporBarangPageLayout);
        laporBarangPageLayout.setHorizontalGroup(
            laporBarangPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header4)
            .addGroup(laporBarangPageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(laporBarangPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(laporBarangPageLayout.createSequentialGroup()
                        .addGroup(laporBarangPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, laporBarangPageLayout.createSequentialGroup()
                                .addComponent(labelKodeBarangLapor, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbKodeBarangLapor, 0, 923, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, laporBarangPageLayout.createSequentialGroup()
                                .addComponent(labelNBarangLapor, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputNBarangLapor))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, laporBarangPageLayout.createSequentialGroup()
                                .addGroup(laporBarangPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNPelapor, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelJmlBarangLapor1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(laporBarangPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputJmlBarangLapor1)
                                    .addComponent(cbPelapor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(laporBarangPageLayout.createSequentialGroup()
                        .addComponent(lableKeteranganLapor, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, laporBarangPageLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(laporBarangPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, laporBarangPageLayout.createSequentialGroup()
                                .addComponent(inputCariLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapusPencarianLaporan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCariLaporan))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, laporBarangPageLayout.createSequentialGroup()
                                .addComponent(btnResetLaporan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapusLaporan2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdateLaporan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSimpanLaporan)))))
                .addContainerGap())
        );
        laporBarangPageLayout.setVerticalGroup(
            laporBarangPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laporBarangPageLayout.createSequentialGroup()
                .addComponent(header4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(laporBarangPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelKodeBarangLapor)
                    .addComponent(cbKodeBarangLapor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(laporBarangPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNBarangLapor)
                    .addComponent(inputNBarangLapor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(laporBarangPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputJmlBarangLapor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelJmlBarangLapor1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(laporBarangPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNPelapor)
                    .addComponent(cbPelapor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(laporBarangPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lableKeteranganLapor)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(laporBarangPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpanLaporan)
                    .addComponent(btnUpdateLaporan)
                    .addComponent(btnHapusLaporan2)
                    .addComponent(btnResetLaporan))
                .addGap(18, 18, 18)
                .addGroup(laporBarangPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCariLaporan)
                    .addComponent(inputCariLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapusPencarianLaporan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        panelPages.add(laporBarangPage, "laporBarangPage");

        stokPage.setBackground(new java.awt.Color(255, 255, 255));

        title2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        title2.setForeground(new java.awt.Color(255, 255, 255));
        title2.setText("Stok Barang");

        header2.setLayer(title2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout header2Layout = new javax.swing.GroupLayout(header2);
        header2.setLayout(header2Layout);
        header2Layout.setHorizontalGroup(
            header2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(title2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        header2Layout.setVerticalGroup(
            header2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(title2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        tableStokBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "item_name", "category", "quantity", "low_stock_level", "description"
            }
        ));
        tableStokBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableStokBarangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableStokBarang);

        btnCariBarang.setBackground(new java.awt.Color(22, 103, 15));
        btnCariBarang.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnCariBarang.setForeground(new java.awt.Color(255, 255, 255));
        btnCariBarang.setText("Cari");
        btnCariBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariBarangActionPerformed(evt);
            }
        });

        labelPembelian2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        labelPembelian2.setForeground(new java.awt.Color(51, 51, 51));
        labelPembelian2.setText("Edit Data Barang");

        labelJumlahEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelJumlahEdit.setForeground(new java.awt.Color(51, 51, 51));
        labelJumlahEdit.setText("Jumlah: ");

        labelNamaBarangEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelNamaBarangEdit.setForeground(new java.awt.Color(51, 51, 51));
        labelNamaBarangEdit.setText("Nama barang: ");

        labelDeskripsiEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDeskripsiEdit.setForeground(new java.awt.Color(51, 51, 51));
        labelDeskripsiEdit.setText("Deskripsi");

        inputNBarangEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNBarangEditActionPerformed(evt);
            }
        });

        taDeskripsiEdit.setColumns(20);
        taDeskripsiEdit.setRows(5);
        jScrollPane8.setViewportView(taDeskripsiEdit);

        labelKategoriEdit1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelKategoriEdit1.setForeground(new java.awt.Color(51, 51, 51));
        labelKategoriEdit1.setText("Kategori");

        cbKategoriEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category" }));
        cbKategoriEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKategoriEditActionPerformed(evt);
            }
        });

        inputJumlahEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputJumlahEditActionPerformed(evt);
            }
        });

        btnUpdateBarangEdit.setBackground(new java.awt.Color(22, 103, 15));
        btnUpdateBarangEdit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnUpdateBarangEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateBarangEdit.setText("Update");
        btnUpdateBarangEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateBarangEditActionPerformed(evt);
            }
        });

        btnHapusBarangEdit.setBackground(new java.awt.Color(123, 31, 31));
        btnHapusBarangEdit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnHapusBarangEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnHapusBarangEdit.setText("Hapus");
        btnHapusBarangEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusBarangEditActionPerformed(evt);
            }
        });

        btnResetBarangEdit.setBackground(new java.awt.Color(115, 114, 114));
        btnResetBarangEdit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnResetBarangEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnResetBarangEdit.setText("Reset");
        btnResetBarangEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetBarangEditActionPerformed(evt);
            }
        });

        btnHapusPencarianBarang.setBackground(new java.awt.Color(115, 114, 114));
        btnHapusPencarianBarang.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnHapusPencarianBarang.setForeground(new java.awt.Color(255, 255, 255));
        btnHapusPencarianBarang.setText("Hapus Pencarian");
        btnHapusPencarianBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusPencarianBarangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout stokPageLayout = new javax.swing.GroupLayout(stokPage);
        stokPage.setLayout(stokPageLayout);
        stokPageLayout.setHorizontalGroup(
            stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stokPageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(stokPageLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnResetBarangEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapusBarangEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateBarangEdit))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, stokPageLayout.createSequentialGroup()
                        .addGroup(stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelNamaBarangEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(labelJumlahEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputNBarangEdit)
                            .addComponent(inputJumlahEdit, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, stokPageLayout.createSequentialGroup()
                        .addComponent(labelKategoriEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbKategoriEdit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, stokPageLayout.createSequentialGroup()
                        .addComponent(labelDeskripsiEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, stokPageLayout.createSequentialGroup()
                        .addGroup(stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPembelian2)
                            .addGroup(stokPageLayout.createSequentialGroup()
                                .addGap(390, 390, 390)
                                .addComponent(inputPencarianBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapusPencarianBarang)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCariBarang)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        stokPageLayout.setVerticalGroup(
            stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stokPageLayout.createSequentialGroup()
                .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelPembelian2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelNamaBarangEdit)
                    .addComponent(inputNBarangEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelJumlahEdit)
                    .addComponent(inputJumlahEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelKategoriEdit1)
                    .addComponent(cbKategoriEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDeskripsiEdit)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateBarangEdit)
                    .addComponent(btnHapusBarangEdit)
                    .addComponent(btnResetBarangEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCariBarang)
                    .addComponent(inputPencarianBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapusPencarianBarang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        panelPages.add(stokPage, "stokPage");

        karyawanPage.setBackground(new java.awt.Color(255, 255, 255));

        title1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        title1.setForeground(new java.awt.Color(255, 255, 255));
        title1.setText("Data Karyawan");

        header1.setLayer(title1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout header1Layout = new javax.swing.GroupLayout(header1);
        header1.setLayout(header1Layout);
        header1Layout.setHorizontalGroup(
            header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(892, Short.MAX_VALUE))
        );
        header1Layout.setVerticalGroup(
            header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Tambah Data Karyawan");

        labelNIP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelNIP.setForeground(new java.awt.Color(51, 51, 51));
        labelNIP.setText("NIP");

        inputNIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNIPActionPerformed(evt);
            }
        });

        labelNamaKaryawan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelNamaKaryawan.setForeground(new java.awt.Color(51, 51, 51));
        labelNamaKaryawan.setText("Nama Karyawan");

        labelDepartemen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDepartemen.setForeground(new java.awt.Color(51, 51, 51));
        labelDepartemen.setText("Department");

        inputNKaryawan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNKaryawan1ActionPerformed(evt);
            }
        });

        cbDepartemen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Department" }));
        cbDepartemen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDepartemenActionPerformed(evt);
            }
        });

        btnUpdateKaryawan.setBackground(new java.awt.Color(22, 103, 15));
        btnUpdateKaryawan.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnUpdateKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateKaryawan.setText("Update");
        btnUpdateKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateKaryawanActionPerformed(evt);
            }
        });

        tableKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NIP", "Nama", "Department"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKaryawanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableKaryawan);

        btnCariKaryawan.setBackground(new java.awt.Color(22, 103, 15));
        btnCariKaryawan.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnCariKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        btnCariKaryawan.setText("Cari");
        btnCariKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariKaryawanActionPerformed(evt);
            }
        });

        btnDeleteKaryawan.setBackground(new java.awt.Color(123, 31, 31));
        btnDeleteKaryawan.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnDeleteKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteKaryawan.setText("Delete");
        btnDeleteKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteKaryawanActionPerformed(evt);
            }
        });

        btnTambahKaryawan.setBackground(new java.awt.Color(22, 103, 15));
        btnTambahKaryawan.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnTambahKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        btnTambahKaryawan.setText("Tambah");
        btnTambahKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahKaryawanActionPerformed(evt);
            }
        });

        btnResetKaryawan.setBackground(new java.awt.Color(115, 114, 114));
        btnResetKaryawan.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnResetKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        btnResetKaryawan.setText("Reset");
        btnResetKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetKaryawanActionPerformed(evt);
            }
        });

        btnHapusPencarianKaryawan.setBackground(new java.awt.Color(115, 114, 114));
        btnHapusPencarianKaryawan.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnHapusPencarianKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        btnHapusPencarianKaryawan.setText("Hapus Pencarian");
        btnHapusPencarianKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusPencarianKaryawanActionPerformed(evt);
            }
        });

        labelStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelStatus.setForeground(new java.awt.Color(51, 51, 51));
        labelStatus.setText("Status");

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Status", "Employee", "Admin" }));
        cbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusActionPerformed(evt);
            }
        });

        labelPassNewAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelPassNewAdmin.setForeground(new java.awt.Color(51, 51, 51));
        labelPassNewAdmin.setText("Password");

        PassFieldNewAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PassFieldNewAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout karyawanPageLayout = new javax.swing.GroupLayout(karyawanPage);
        karyawanPage.setLayout(karyawanPageLayout);
        karyawanPageLayout.setHorizontalGroup(
            karyawanPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, karyawanPageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(karyawanPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, karyawanPageLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, karyawanPageLayout.createSequentialGroup()
                        .addGroup(karyawanPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(karyawanPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(labelNIP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelNamaKaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(labelDepartemen, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPassNewAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(karyawanPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbDepartemen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inputNKaryawan1)
                            .addComponent(inputNIP)
                            .addComponent(cbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PassFieldNewAdmin)))
                    .addGroup(karyawanPageLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(karyawanPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(karyawanPageLayout.createSequentialGroup()
                                .addComponent(btnTambahKaryawan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnResetKaryawan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeleteKaryawan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdateKaryawan))
                            .addGroup(karyawanPageLayout.createSequentialGroup()
                                .addComponent(inputCariKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapusPencarianKaryawan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCariKaryawan)))))
                .addGap(22, 22, 22))
        );
        karyawanPageLayout.setVerticalGroup(
            karyawanPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(karyawanPageLayout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(karyawanPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputNIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNIP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(karyawanPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNamaKaryawan)
                    .addComponent(inputNKaryawan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(karyawanPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDepartemen)
                    .addComponent(cbDepartemen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(karyawanPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStatus)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(karyawanPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPassNewAdmin)
                    .addComponent(PassFieldNewAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(karyawanPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateKaryawan)
                    .addComponent(btnDeleteKaryawan)
                    .addComponent(btnTambahKaryawan)
                    .addComponent(btnResetKaryawan))
                .addGap(45, 45, 45)
                .addGroup(karyawanPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCariKaryawan)
                    .addComponent(inputCariKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapusPencarianKaryawan))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelPages.add(karyawanPage, "karyawanPage");

        suplierPage.setBackground(new java.awt.Color(255, 255, 255));

        title3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        title3.setForeground(new java.awt.Color(255, 255, 255));
        title3.setText("Data Perusahaan");

        header3.setLayer(title3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout header3Layout = new javax.swing.GroupLayout(header3);
        header3.setLayout(header3Layout);
        header3Layout.setHorizontalGroup(
            header3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(title3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(892, Short.MAX_VALUE))
        );
        header3Layout.setVerticalGroup(
            header3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(title3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Tambah Data Perusahaan");

        inputNPerusahaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNPerusahaanActionPerformed(evt);
            }
        });

        labelNPerusahaan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelNPerusahaan.setForeground(new java.awt.Color(51, 51, 51));
        labelNPerusahaan.setText("Nama Perusahaan: ");

        inputEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEmailActionPerformed(evt);
            }
        });

        labelEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelEmail.setForeground(new java.awt.Color(51, 51, 51));
        labelEmail.setText("Email:");

        inputTelepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTeleponActionPerformed(evt);
            }
        });

        labelTelepon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTelepon.setForeground(new java.awt.Color(51, 51, 51));
        labelTelepon.setText("Telepon");

        labelAlamat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelAlamat.setForeground(new java.awt.Color(51, 51, 51));
        labelAlamat.setText("Alamat:");

        taAlamat.setColumns(20);
        taAlamat.setRows(5);
        jScrollPane4.setViewportView(taAlamat);

        btnTambahSuplier.setBackground(new java.awt.Color(22, 103, 15));
        btnTambahSuplier.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnTambahSuplier.setForeground(new java.awt.Color(255, 255, 255));
        btnTambahSuplier.setText("Tambah");
        btnTambahSuplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahSuplierActionPerformed(evt);
            }
        });

        tableSuplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama Perusahaan", "Email", "Phone", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSuplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSuplierMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableSuplier);

        btnCariSuplier.setBackground(new java.awt.Color(22, 103, 15));
        btnCariSuplier.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnCariSuplier.setForeground(new java.awt.Color(255, 255, 255));
        btnCariSuplier.setText("Cari");
        btnCariSuplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariSuplierActionPerformed(evt);
            }
        });

        btnUpdateSuplier1.setBackground(new java.awt.Color(22, 103, 15));
        btnUpdateSuplier1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnUpdateSuplier1.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateSuplier1.setText("Update");
        btnUpdateSuplier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSuplier1ActionPerformed(evt);
            }
        });

        btnDeleteSuplier2.setBackground(new java.awt.Color(123, 31, 31));
        btnDeleteSuplier2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnDeleteSuplier2.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteSuplier2.setText("Delete");
        btnDeleteSuplier2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSuplier2ActionPerformed(evt);
            }
        });

        btnResetSuplier3.setBackground(new java.awt.Color(115, 114, 114));
        btnResetSuplier3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnResetSuplier3.setForeground(new java.awt.Color(255, 255, 255));
        btnResetSuplier3.setText("Reset");
        btnResetSuplier3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetSuplier3ActionPerformed(evt);
            }
        });

        btnHapusPencarianCompany.setBackground(new java.awt.Color(115, 114, 114));
        btnHapusPencarianCompany.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnHapusPencarianCompany.setForeground(new java.awt.Color(255, 255, 255));
        btnHapusPencarianCompany.setText("Hapus Pencarian");
        btnHapusPencarianCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusPencarianCompanyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout suplierPageLayout = new javax.swing.GroupLayout(suplierPage);
        suplierPage.setLayout(suplierPageLayout);
        suplierPageLayout.setHorizontalGroup(
            suplierPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header3)
            .addGroup(suplierPageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(suplierPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(suplierPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(suplierPageLayout.createSequentialGroup()
                            .addComponent(labelNPerusahaan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(inputNPerusahaan))
                        .addGroup(suplierPageLayout.createSequentialGroup()
                            .addComponent(labelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(inputEmail))
                        .addGroup(suplierPageLayout.createSequentialGroup()
                            .addComponent(labelTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(inputTelepon))
                        .addGroup(suplierPageLayout.createSequentialGroup()
                            .addComponent(labelAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, suplierPageLayout.createSequentialGroup()
                            .addComponent(btnTambahSuplier)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnResetSuplier3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDeleteSuplier2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnUpdateSuplier1)))
                    .addComponent(jScrollPane5)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, suplierPageLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(inputCariPerusahaan, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapusPencarianCompany)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCariSuplier)))
                .addContainerGap())
        );
        suplierPageLayout.setVerticalGroup(
            suplierPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suplierPageLayout.createSequentialGroup()
                .addComponent(header3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(suplierPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNPerusahaan)
                    .addComponent(inputNPerusahaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(suplierPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmail)
                    .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(suplierPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelepon)
                    .addComponent(inputTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(suplierPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAlamat)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(suplierPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambahSuplier)
                    .addComponent(btnUpdateSuplier1)
                    .addComponent(btnDeleteSuplier2)
                    .addComponent(btnResetSuplier3))
                .addGap(15, 15, 15)
                .addGroup(suplierPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCariSuplier)
                    .addComponent(inputCariPerusahaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapusPencarianCompany))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 99, Short.MAX_VALUE))
        );

        panelPages.add(suplierPage, "suplierPage");

        jSplitPane1.setRightComponent(panelPages);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusActionPerformed
        // TODO add your handling code here:
        String status = cbStatus.getSelectedItem().toString();
        if (status.equals("Admin")) {
            labelPassNewAdmin.setVisible(true);
            PassFieldNewAdmin.setVisible(true);
        } else if (status.equals("Employee") || status.equals("Select Status")) {
            labelPassNewAdmin.setVisible(false);
            PassFieldNewAdmin.setVisible(false);
        }
    }//GEN-LAST:event_cbStatusActionPerformed

    private void PassFieldNewAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PassFieldNewAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PassFieldNewAdminActionPerformed

    private void inputNBarangLaporActionPerformed(java.awt.event.ActionEvent ect) {
        // TODO add yout handling code here:
    }

    private void btnTambahPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahPembelianActionPerformed
        // TODO add your handling code here:
        try {
            String name = inputNBarang.getText();
            String category = cbKategori.getSelectedItem().toString();
            String company = cbPerusahaan.getSelectedItem().toString();
            int amount = Integer.parseInt(inputJumlahPembelian.getText());
            String desc = inputDeskripsiBarang.getText();

            transactionController.insertTransactionBeli(
                    this,
                    name,
                    company,
                    category,
                    "Pembelian",
                    amount,
                    desc,
                    modelTransaction,
                    modelItem);

            inputNBarang.setText("");
            cbKategori.setSelectedIndex(0);
            cbPerusahaan.setSelectedIndex(0);
            inputJumlahPembelian.setText("");
            inputDeskripsiBarang.setText("");

            addItemComboBox();
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnTambahPembelianActionPerformed

    private void btnTambahPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahPenjualanActionPerformed
        // TODO add your handling code here:
        try {
            String kodeBarang = cbKodeBarangJual.getSelectedItem().toString();
            String company = cbPerusahaanJual.getSelectedItem().toString();
            int amount = Integer.parseInt(inputJumlahPenjualan.getText());

            transactionController.insertTransactionJual(
                    this,
                    kodeBarang,
                    company,
                    amount,
                    "Penjualan",
                    modelTransaction,
                    modelItem
            );

            cbKodeBarangJual.setSelectedIndex(0);
            cbPerusahaanJual.setSelectedIndex(0);
            inputJumlahPenjualan.setText("");
            inputDisabledNBarang.setText("");
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnTambahPenjualanActionPerformed

    private void inputDisabledNBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDisabledNBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputDisabledNBarangActionPerformed

    private void tableStokBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableStokBarangMouseClicked
        // TODO add your handling code here:
        inputNBarangEdit.setEnabled(true);
        inputJumlahEdit.setEnabled(true);
        cbKategoriEdit.setEnabled(true);
        taDeskripsiEdit.setEnabled(true);

        int row = tableStokBarang.getSelectedRow();

        String name = itemController.getItemList().get(row).getItem_name();
        String category = itemController.getItemList().get(row).getCategory_name();
        int quantity = itemController.getItemList().get(row).getQuantity();
        String description = itemController.getItemList().get(row).getDescription();

        inputNBarangEdit.setText(name);
        inputJumlahEdit.setText(String.valueOf(quantity));
        cbKategoriEdit.setSelectedItem(category);
        taDeskripsiEdit.setText(description);

        btnHapusBarangEdit.setVisible(true);
        btnResetBarangEdit.setVisible(true);
    }//GEN-LAST:event_tableStokBarangMouseClicked

    private void inputJumlahEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputJumlahEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputJumlahEditActionPerformed

    private void btnUpdateBarangEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateBarangEditActionPerformed
        // TODO add your handling code here:
        try {
            int row = tableStokBarang.getSelectedRow();

            String name = inputNBarangEdit.getText();
            int quantity = Integer.parseInt(inputJumlahEdit.getText());
            String category = cbKategoriEdit.getSelectedItem().toString();
            String description = taDeskripsiEdit.getText();

            String oldID = itemController.getItemList().get(row).getItem_id();

            itemController.updateItem(
                    this,
                    category,
                    name,
                    quantity,
                    description,
                    modelItem,
                    oldID
            );

            inputNBarangEdit.setText("");
            inputJumlahEdit.setText("");
            cbKategoriEdit.setSelectedIndex(0);
            taDeskripsiEdit.setText("");

            addItemComboBox();
            inputNBarangEdit.setEnabled(false);
            inputJumlahEdit.setEnabled(false);
            cbKategoriEdit.setEnabled(false);
            taDeskripsiEdit.setEnabled(false);
            btnHapusBarangEdit.setVisible(false);
            btnResetBarangEdit.setVisible(false);
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnUpdateBarangEditActionPerformed

    private void btnHapusBarangEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusBarangEditActionPerformed
        // TODO add your handling code here:
        try {
            int row = tableStokBarang.getSelectedRow();

            String oldID = itemController.getItemList().get(row).getItem_id();

            itemController.deleteItem(
                    this,
                    modelItem,
                    modelTransaction,
                    oldID);

            inputNBarangEdit.setText("");
            inputJumlahEdit.setText("");
            cbKategoriEdit.setSelectedIndex(0);
            taDeskripsiEdit.setText("");

            inputNBarangEdit.setEnabled(false);
            inputJumlahEdit.setEnabled(false);
            cbKategoriEdit.setEnabled(false);
            taDeskripsiEdit.setEnabled(false);
            btnHapusBarangEdit.setVisible(false);
            btnResetBarangEdit.setVisible(false);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnHapusBarangEditActionPerformed

    private void btnResetBarangEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetBarangEditActionPerformed
        // TODO add your handling code here:
        inputNBarangEdit.setText("");
        inputJumlahEdit.setText("");
        cbKategoriEdit.setSelectedIndex(0);
        taDeskripsiEdit.setText("");

        inputNBarangEdit.setEnabled(false);
        inputJumlahEdit.setEnabled(false);
        cbKategoriEdit.setEnabled(false);
        taDeskripsiEdit.setEnabled(false);
        btnHapusBarangEdit.setVisible(false);
        btnResetBarangEdit.setVisible(false);
    }//GEN-LAST:event_btnResetBarangEditActionPerformed

    private void btnHapusPencarianBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusPencarianBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHapusPencarianBarangActionPerformed

    private void inputJmlBarangLapor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputJmlBarangLapor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputJmlBarangLapor1ActionPerformed

    private void btnUpdateLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateLaporanActionPerformed
        // TODO add your handling code here:
        try {

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnUpdateLaporanActionPerformed

    private void btnHapusLaporan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusLaporan2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHapusLaporan2ActionPerformed

    private void btnResetLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetLaporanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetLaporanActionPerformed

    private void btnHapusPencarianLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusPencarianLaporanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHapusPencarianLaporanActionPerformed

    private void tableLaporkanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLaporkanMouseClicked
        // TODO add your handling code here:
        int row = tableLaporkan.getSelectedRow();

        String kodeBarang = issueController.getTransactionList().get(row).getItem().getItem_id();
        String stacks = String.valueOf(issueController.getTransactionList().get(row).getStacks());
        String employee = issueController.getTransactionList().get(row).getEmployee().getEmployee_name();
        String description = issueController.getTransactionList().get(row).getIssue_description();

        cbKodeBarangLapor.setSelectedItem(kodeBarang);
        inputJmlBarangLapor1.setText(stacks);
        cbPelapor.setSelectedItem(employee);
        taKeterangan.setText(description);

        btnSimpanLaporan.setVisible(false);
        btnUpdateLaporan.setVisible(true);
        btnHapusLaporan2.setVisible(true);
        btnResetLaporan.setVisible(true);
    }//GEN-LAST:event_tableLaporkanMouseClicked

    private void cbKodeBarangLaporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKodeBarangLaporActionPerformed
        // TODO add your handling code here:
        cbKodeBarangLapor.addActionListener(event -> {
            Object selectedItem = cbKodeBarangLapor.getSelectedItem();

            if (selectedItem != null) {
                itemController.getItemList().forEach(action -> {
                    if (selectedItem.toString().equals(action.getItem_id())) {
                        inputNBarangLapor.setText(action.getItem_name());
                    } else if (selectedItem.toString().equals("Select Kode Barang")) {
                        inputNBarangLapor.setText("");
                    }
                });
            } else {
                inputNBarangLapor.setText("");
            }

        });
    }//GEN-LAST:event_cbKodeBarangLaporActionPerformed

    private void cbKategoriActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void cbKodeBarangJualActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        cbKodeBarangJual.addActionListener(event -> {
            Object selectedItem = cbKodeBarangJual.getSelectedItem();

            if (selectedItem != null) {
                itemController.getItemList().forEach(action -> {
                    if (selectedItem.toString().equals(action.getItem_id())) {
                        inputDisabledNBarang.setText(action.getItem_name());
                    } else if (selectedItem.toString().equals("Select Kode Barang")) {
                        inputDisabledNBarang.setText("");
                    }
                });
            } else {
                inputDisabledNBarang.setText("");
            }

        });
    }

    private void cbPerusahaanActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void cbCompanyEditActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnTransaksiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTransaksiActionPerformed
        cardLayout.show(panelPages, "transaksiPage");
    }// GEN-LAST:event_btnTransaksiActionPerformed

    private void btnLaporBarangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLaporBarangActionPerformed
        cardLayout.show(panelPages, "laporBarangPage");
    }// GEN-LAST:event_btnLaporBarangActionPerformed

    private void btnStokActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnStokActionPerformed
        cardLayout.show(panelPages, "stokPage");
    }// GEN-LAST:event_btnStokActionPerformed

    private void btnKaryawanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnKaryawanActionPerformed
        cardLayout.show(panelPages, "karyawanPage");
    }// GEN-LAST:event_btnKaryawanActionPerformed

    private void btnLogoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLogoActionPerformed
        cardLayout.show(panelPages, "tambahTransaksi");
    }// GEN-LAST:event_btnLogoActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        try {
            admin.logout(this, this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }// GEN-LAST:event_btnLogoutActionPerformed

    private void btnCariBarangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCariBarangActionPerformed
        // TODO add your handling code here:
        try {
            String search = inputPencarianBarang.getText();

            itemController.searchItem(
                    this,
                    search,
                    modelItem,
                    inputPencarianBarang,
                    btnHapusPencarianBarang,
                    btnCariBarang
            );
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }// GEN-LAST:event_btnCariBarangActionPerformed

    private void btnSuplierActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSuplierActionPerformed
        cardLayout.show(panelPages, "suplierPage");
    }// GEN-LAST:event_btnSuplierActionPerformed

    private void inputNIPActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_inputNIPActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_inputNIPActionPerformed

    private void inputNKaryawan1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_inputNKaryawan1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_inputNKaryawan1ActionPerformed

    private void inputNPerusahaanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_inputNPerusahaanActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_inputNPerusahaanActionPerformed

    private void inputEmailActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_inputEmailActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_inputEmailActionPerformed

    private void inputTeleponActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_inputTeleponActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_inputTeleponActionPerformed

    private void inputJmlBarangLaporActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_inputJmlBarangLaporActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_inputJmlBarangLaporActionPerformed

    private void btnSimpanLaporanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSimpanLaporanActionPerformed
        // TODO add your handling code here:
        try {
            String kodeBarang = cbKodeBarangLapor.getSelectedItem().toString();
            int stacks = Integer.parseInt(inputJmlBarangLapor1.getText());
            String employee = cbPelapor.getSelectedItem().toString();
            String description = taKeterangan.getText();

            issueController.insertIssue(
                    this,
                    kodeBarang,
                    stacks,
                    employee,
                    description,
                    modelIssue,
                    modelItem
            );

            cbKodeBarangLapor.setSelectedIndex(0);
            inputJmlBarangLapor1.setText("");
            cbPelapor.setSelectedIndex(0);
            taKeterangan.setText("");
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }// GEN-LAST:event_btnSimpanLaporanActionPerformed

    private void btnCariLaporanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCariLaporanActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnCariLaporanActionPerformed

    private void btnCariKaryawanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCariKaryawanActionPerformed
        // TODO add your handling code here:
        try {
            String searchItem = inputCariKaryawan.getText();

            employeeController.searchEmployee(
                    this,
                    searchItem,
                    modelKaryawan,
                    inputCariKaryawan,
                    btnHapusPencarianKaryawan,
                    btnCariKaryawan);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }// GEN-LAST:event_btnCariKaryawanActionPerformed

    private void btnCariSuplierActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCariSuplierActionPerformed
        // TODO add your handling code here:
        try {
            String searchItem = inputCariPerusahaan.getText();

            companyController.searchCompany(this,
                    searchItem,
                    modelSuplier,
                    inputCariPerusahaan,
                    btnHapusPencarianCompany,
                    btnCariSuplier);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }// GEN-LAST:event_btnCariSuplierActionPerformed

    private void btnCariBarang1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCariBarang1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnCariBarang1ActionPerformed

    private void inputNBarangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_inputNBarangActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_inputNBarangActionPerformed

    private void cbSuplierBeliActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbSuplierBeliActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_cbSuplierBeliActionPerformed

    private void cbKategoriEditActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbKategoriEditActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_cbKategoriEditActionPerformed

    private void inputNBarangEditActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_inputNBarangEditActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_inputNBarangEditActionPerformed

    private void cbKodeBarangEditActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbKodeBarangEditActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_cbKodeBarangEditActionPerformed

    private void cbKodeBarangBeliJualActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbKodeBarangBeliJualActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_cbKodeBarangBeliJualActionPerformed

    private void cbPerusahaanJualActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbPerusahaanJualActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_cbPerusahaanJualActionPerformed

    private void btnSimpanBarangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSimpanBarangActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnSimpanBarangActionPerformed

    private void btnTambahSuplierActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTambahSuplierActionPerformed
        // TODO add your handling code here:
        try {
            String name = inputNPerusahaan.getText();
            String email = inputEmail.getText();
            String phone = inputTelepon.getText();
            String address = taAlamat.getText();

            companyController.insertCompany(
                    this,
                    name,
                    email,
                    phone,
                    address,
                    modelSuplier);

            inputNPerusahaan.setText("");
            inputEmail.setText("");
            inputTelepon.setText("");
            taAlamat.setText("");

            addItemComboBox();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }// GEN-LAST:event_btnTambahSuplierActionPerformed

    private void tableTransaksiMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tableTransaksiMouseClicked
        // TODO add your handling code here:
    }// GEN-LAST:event_tableTransaksiMouseClicked

    private void tableSuplierMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tableSuplierMouseClicked
        // TODO add your handling code here:
        int row = tableSuplier.getSelectedRow();

        String name = companyController.getCompanyList().get(row).getCompany_name();
        String email = companyController.getCompanyList().get(row).getEmail();
        String phone = companyController.getCompanyList().get(row).getPhone();
        String alamat = companyController.getCompanyList().get(row).getAddresss();

        inputNPerusahaan.setText(name);
        inputEmail.setText(email);
        inputTelepon.setText(phone);
        taAlamat.setText(alamat);

        btnTambahSuplier.setVisible(false);
        btnUpdateSuplier1.setVisible(true);
        btnDeleteSuplier2.setVisible(true);
        btnResetSuplier3.setVisible(true);
    }// GEN-LAST:event_tableSuplierMouseClicked

    private void btnUpdateSuplier1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdateSuplier1ActionPerformed
        // TODO add your handling code here:
        try {
            int row = tableSuplier.getSelectedRow();

            String name = inputNPerusahaan.getText();
            String email = inputEmail.getText();
            String phone = inputTelepon.getText();
            String address = taAlamat.getText();

            String oldName = companyController.getCompanyList().get(row).getCompany_name();

            companyController.updateCompany(
                    this,
                    name,
                    email,
                    phone,
                    address,
                    modelSuplier,
                    oldName);

            inputNPerusahaan.setText("");
            inputEmail.setText("");
            inputTelepon.setText("");
            taAlamat.setText("");

            addItemComboBox();
            btnTambahSuplier.setVisible(true);
            btnUpdateSuplier1.setVisible(false);
            btnDeleteSuplier2.setVisible(false);
            btnResetSuplier3.setVisible(false);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }// GEN-LAST:event_btnUpdateSuplier1ActionPerformed

    private void btnDeleteSuplier2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteSuplier2ActionPerformed
        // TODO add your handling code here:
        try {
            int row = tableSuplier.getSelectedRow();

            String oldName = companyController.getCompanyList().get(row).getCompany_name();

            companyController.deleteCompany(
                    this,
                    modelSuplier,
                    oldName);

            inputNPerusahaan.setText("");
            inputEmail.setText("");
            inputTelepon.setText("");
            taAlamat.setText("");

            addItemComboBox();
            btnTambahSuplier.setVisible(true);
            btnUpdateSuplier1.setVisible(false);
            btnDeleteSuplier2.setVisible(false);
            btnResetSuplier3.setVisible(false);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }// GEN-LAST:event_btnDeleteSuplier2ActionPerformed

    private void btnResetSuplier3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnResetSuplier3ActionPerformed
        // TODO add your handling code here:
        inputNPerusahaan.setText("");
        inputEmail.setText("");
        inputTelepon.setText("");
        taAlamat.setText("");

        btnTambahSuplier.setVisible(true);
        btnUpdateSuplier1.setVisible(false);
        btnDeleteSuplier2.setVisible(false);
        btnResetSuplier3.setVisible(false);
    }// GEN-LAST:event_btnResetSuplier3ActionPerformed

    private void btnUpdateKaryawanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdateKaryawanActionPerformed
        // TODO add your handling code here:
        try {
            int row = tableKaryawan.getSelectedRow();

            String nip = inputNIP.getText();
            String name = inputNKaryawan1.getText();
            String department_name = cbDepartemen.getSelectedItem().toString();

            String oldNip = employeeController.getEmployeeList().get(row).getNip();

            employeeController.updateEmployee(
                    this,
                    nip,
                    name,
                    department_name,
                    modelKaryawan,
                    oldNip);

            inputNKaryawan1.setText("");
            inputNIP.setText("");
            cbDepartemen.setSelectedIndex(0);

            addItemComboBox();
            btnTambahKaryawan.setVisible(true);
            btnUpdateKaryawan.setVisible(false);
            btnDeleteKaryawan.setVisible(false);
            btnResetKaryawan.setVisible(false);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }// GEN-LAST:event_btnUpdateKaryawanActionPerformed

    private void btnDeleteKaryawanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteKaryawanActionPerformed
        // TODO add your handling code here:
        try {
            int row = tableKaryawan.getSelectedRow();

            String oldNip = employeeController.getEmployeeList().get(row).getNip();

            employeeController.deleteEmployee(
                    this,
                    modelKaryawan,
                    oldNip);

            inputNKaryawan1.setText("");
            inputNIP.setText("");
            cbDepartemen.setSelectedIndex(0);

            addItemComboBox();
            btnTambahKaryawan.setVisible(true);
            btnUpdateKaryawan.setVisible(false);
            btnDeleteKaryawan.setVisible(false);
            btnResetKaryawan.setVisible(false);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }// GEN-LAST:event_btnDeleteKaryawanActionPerformed

    private void btnResetKaryawanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnResetKaryawanActionPerformed
        // TODO add your handling code here:
        inputNKaryawan1.setText("");
        inputNIP.setText("");
        cbDepartemen.setSelectedIndex(0);

        btnTambahKaryawan.setVisible(true);
        btnUpdateKaryawan.setVisible(false);
        btnDeleteKaryawan.setVisible(false);
        btnResetKaryawan.setVisible(false);
    }// GEN-LAST:event_btnResetKaryawanActionPerformed

    private void btnTambahKaryawanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTambahKaryawanActionPerformed
        // TODO add your handling code here:
        try {
            String nip = inputNIP.getText();
            String name = inputNKaryawan1.getText();
            String status = cbStatus.getSelectedItem().toString();
            char[] pass = PassFieldNewAdmin.getPassword();
            String password = new String(pass);
            String department = cbDepartemen.getSelectedItem().toString();

            employeeController.insertEmployee(
                    this,
                    nip,
                    name,
                    department,
                    status,
                    password,
                    modelKaryawan);

            inputNIP.setText("");
            inputNKaryawan1.setText("");
            cbStatus.setSelectedIndex(0);
            PassFieldNewAdmin.setText("");
            cbDepartemen.setSelectedIndex(0);

            addItemComboBox();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }// GEN-LAST:event_btnTambahKaryawanActionPerformed

    private void btnHapusPencarianCompanyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHapusPencarianCompanyActionPerformed
        // TODO add your handling code here:
        try {
            inputCariPerusahaan.setText("");

            companyController.loadCompany(modelSuplier);

            btnCariSuplier.setVisible(true);
            btnHapusPencarianCompany.setVisible(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }// GEN-LAST:event_btnHapusPencarianCompanyActionPerformed

    private void cbDepartemenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbDepartemenActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_cbDepartemenActionPerformed

    private void tableKaryawanMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tableKaryawanMouseClicked
        // TODO add your handling code here:
        int row = tableKaryawan.getSelectedRow();

        String nip = employeeController.getEmployeeList().get(row).getNip();
        String name = employeeController.getEmployeeList().get(row).getEmployee_name();
        String departmentName = employeeController.getEmployeeList().get(row).getDepartment_name();

        inputNIP.setText(nip);
        inputNKaryawan1.setText(name);
        cbDepartemen.setSelectedItem(departmentName);

        btnTambahKaryawan.setVisible(false);
        btnUpdateKaryawan.setVisible(true);
        btnDeleteKaryawan.setVisible(true);
        btnResetKaryawan.setVisible(true);
    }// GEN-LAST:event_tableKaryawanMouseClicked

    private void btnHapusPencarianKaryawanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHapusPencarianKaryawanActionPerformed
        // TODO add your handling code here:
        try {
            inputCariKaryawan.setText("");

            employeeController.loadEmployee(modelKaryawan);

            btnCariKaryawan.setVisible(true);
            btnHapusPencarianKaryawan.setVisible(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }// GEN-LAST:event_btnHapusPencarianKaryawanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Home().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PassFieldNewAdmin;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JButton btnCariBarang;
    private javax.swing.JButton btnCariBarang1;
    private javax.swing.JButton btnCariKaryawan;
    private javax.swing.JButton btnCariLaporan;
    private javax.swing.JButton btnCariSuplier;
    private javax.swing.JButton btnDeleteKaryawan;
    private javax.swing.JButton btnDeleteSuplier2;
    private javax.swing.JButton btnHapusBarangEdit;
    private javax.swing.JButton btnHapusLaporan2;
    private javax.swing.JButton btnHapusPencarianBarang;
    private javax.swing.JButton btnHapusPencarianCompany;
    private javax.swing.JButton btnHapusPencarianKaryawan;
    private javax.swing.JButton btnHapusPencarianLaporan;
    private javax.swing.JButton btnKaryawan;
    private javax.swing.JButton btnLaporBarang;
    private javax.swing.JButton btnLogo;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnResetBarangEdit;
    private javax.swing.JButton btnResetKaryawan;
    private javax.swing.JButton btnResetLaporan;
    private javax.swing.JButton btnResetSuplier3;
    private javax.swing.JButton btnSimpanLaporan;
    private javax.swing.JButton btnStok;
    private javax.swing.JButton btnSuplier;
    private javax.swing.JButton btnTambahKaryawan;
    private javax.swing.JButton btnTambahPembelian;
    private javax.swing.JButton btnTambahPenjualan;
    private javax.swing.JButton btnTambahSuplier;
    private javax.swing.JButton btnTransaksi;
    private javax.swing.JButton btnUpdateBarangEdit;
    private javax.swing.JButton btnUpdateKaryawan;
    private javax.swing.JButton btnUpdateLaporan;
    private javax.swing.JButton btnUpdateSuplier1;
    private javax.swing.JComboBox<String> cbDepartemen;
    private javax.swing.JComboBox<String> cbKategori;
    private javax.swing.JComboBox<String> cbKategoriEdit;
    private javax.swing.JComboBox<String> cbKodeBarangJual;
    private javax.swing.JComboBox<String> cbKodeBarangLapor;
    private javax.swing.JComboBox<String> cbPelapor;
    private javax.swing.JComboBox<String> cbPerusahaan;
    private javax.swing.JComboBox<String> cbPerusahaanJual;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JDesktopPane header;
    private javax.swing.JDesktopPane header1;
    private javax.swing.JDesktopPane header2;
    private javax.swing.JDesktopPane header3;
    private javax.swing.JDesktopPane header4;
    private javax.swing.JTextField inputCariBarang1;
    private javax.swing.JTextField inputCariKaryawan;
    private javax.swing.JTextField inputCariLaporan;
    private javax.swing.JTextField inputCariPerusahaan;
    private javax.swing.JTextArea inputDeskripsiBarang;
    private javax.swing.JTextField inputDisabledNBarang;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JTextField inputJmlBarangLapor1;
    private javax.swing.JTextField inputJumlahEdit;
    private javax.swing.JTextField inputJumlahPembelian;
    private javax.swing.JTextField inputJumlahPenjualan;
    private javax.swing.JTextField inputKBarangBeli;
    private javax.swing.JTextField inputNBarang;
    private javax.swing.JTextField inputNBarangEdit;
    private javax.swing.JTextField inputNBarangLapor;
    private javax.swing.JTextField inputNIP;
    private javax.swing.JTextField inputNKaryawan1;
    private javax.swing.JTextField inputNPerusahaan;
    private javax.swing.JTextField inputPencarianBarang;
    private javax.swing.JTextField inputTelepon;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel karyawanPage;
    private javax.swing.JLabel labelAlamat;
    private javax.swing.JLabel labelDepartemen;
    private javax.swing.JLabel labelDeskripsi;
    private javax.swing.JLabel labelDeskripsiEdit;
    private javax.swing.JLabel labelDisabledNBarang;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelJmlBarangLapor1;
    private javax.swing.JLabel labelJumlahEdit;
    private javax.swing.JLabel labelJumlahPembelian;
    private javax.swing.JLabel labelJumlahPenjualan;
    private javax.swing.JLabel labelKategori;
    private javax.swing.JLabel labelKategoriEdit1;
    private javax.swing.JLabel labelKodeBarangBeli;
    private javax.swing.JLabel labelKodeBarangBeliJual;
    private javax.swing.JLabel labelKodeBarangLapor;
    private javax.swing.JLabel labelNBarangLapor;
    private javax.swing.JLabel labelNIP;
    private javax.swing.JLabel labelNPelapor;
    private javax.swing.JLabel labelNPerusahaan;
    private javax.swing.JLabel labelNamaBarang;
    private javax.swing.JLabel labelNamaBarangEdit;
    private javax.swing.JLabel labelNamaKaryawan;
    private javax.swing.JLabel labelPassNewAdmin;
    private javax.swing.JLabel labelPembelian;
    private javax.swing.JLabel labelPembelian1;
    private javax.swing.JLabel labelPembelian2;
    private javax.swing.JLabel labelPerusahaanJual;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelSuplierBeli;
    private javax.swing.JLabel labelTelepon;
    private javax.swing.JLabel lableKeteranganLapor;
    private javax.swing.JPanel laporBarangPage;
    private javax.swing.JPanel panelPages;
    private javax.swing.JPanel stokPage;
    private javax.swing.JPanel suplierPage;
    private javax.swing.JTextArea taAlamat;
    private javax.swing.JTextArea taDeskripsiEdit;
    private javax.swing.JTextArea taKeterangan;
    private javax.swing.JTable tableKaryawan;
    private javax.swing.JTable tableLaporkan;
    private javax.swing.JTable tableStokBarang;
    private javax.swing.JTable tableSuplier;
    private javax.swing.JTable tableTransaksi;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title3;
    private javax.swing.JLabel title4;
    private javax.swing.JPanel transaksiPage;
    // End of variables declaration//GEN-END:variables
}
