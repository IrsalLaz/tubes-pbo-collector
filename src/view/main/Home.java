package view.main;

import controller.CompanyController;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableModel;
import model.Company;

public class Home extends javax.swing.JFrame {

    private final CompanyController companyController = new CompanyController();
    private final DefaultTableModel modelSuplier = new DefaultTableModel();
    ImageIcon logoImg = new ImageIcon("logo.png");

    CardLayout cardLayout;

    public Home() {
        initComponents();

        addItemComboBox();

        modelSuplier.addColumn("company name");
        modelSuplier.addColumn("email");
        modelSuplier.addColumn("phone");
        modelSuplier.addColumn("address");

        tableSuplier.setModel(modelSuplier);

        Component[] components = this.getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                ((JButton) component).setUI(new BasicButtonUI());
                ((JButton) component).setFocusPainted(false);
            }
        }

        cardLayout = (CardLayout) (panelPages.getLayout());
        companyController.loadCompany(modelSuplier);
        btnUpdateSuplier1.setVisible(false);
        btnDeleteSuplier2.setVisible(false);
        btnResetSuplier3.setVisible(false);
        btnUpdateKaryawan.setVisible(false);
        btnDeleteKaryawan.setVisible(false);
        btnResetKaryawan.setVisible(false);
        btnHapusPencarian.setVisible(false);
    }

    private void addItemComboBox() {
        // Company
        companyController.loadComboBoxItemCompany();
        ArrayList<Company> company = companyController.getCompanyList();

        for (Company c : company) {
            cbSuplierBeli.addItem(c.getCompany_name());
        }
        
        // Category
        
    }

    @SuppressWarnings("unchecked")
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
        cbSuplierBeli = new javax.swing.JComboBox<>();
        btnTambahPembelian = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        inputDeskripsiBarang = new javax.swing.JTextArea();
        labelPembelian1 = new javax.swing.JLabel();
        labelKodeBarangBeliJual = new javax.swing.JLabel();
        cbKodeBarangBeliJual = new javax.swing.JComboBox<>();
        labelPerusahaanJual = new javax.swing.JLabel();
        cbPerusahaanJual = new javax.swing.JComboBox<>();
        labelJumlahPenjualan = new javax.swing.JLabel();
        inputJumlahPenjualan = new javax.swing.JTextField();
        btnTambahPenjualan = new javax.swing.JButton();
        laporBarangPage = new javax.swing.JPanel();
        header4 = new javax.swing.JDesktopPane();
        title4 = new javax.swing.JLabel();
        labelKodeBarangLapor = new javax.swing.JLabel();
        inputJmlBarangLapor = new javax.swing.JTextField();
        labelJmlBarangLapor = new javax.swing.JLabel();
        inputNPelapor = new javax.swing.JTextField();
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
        stokPage = new javax.swing.JPanel();
        header2 = new javax.swing.JDesktopPane();
        title2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableStokBarang = new javax.swing.JTable();
        btnCariBarang = new javax.swing.JButton();
        inputPencarianBarang = new javax.swing.JTextField();
        labelPembelian2 = new javax.swing.JLabel();
        labelKodeBarangEdit = new javax.swing.JLabel();
        labelNamaBarangEdit = new javax.swing.JLabel();
        labelDeskripsiEdit = new javax.swing.JLabel();
        labelKategoriEdit = new javax.swing.JLabel();
        cbKategoriEdit = new javax.swing.JComboBox<>();
        inputNBarangEdit = new javax.swing.JTextField();
        cbKodeBarangEdit = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        taDeskripsiEdit = new javax.swing.JTextArea();
        btnSimpanBarang = new javax.swing.JButton();
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
        btnHapusPencarian = new javax.swing.JButton();

        jScrollPane10.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setPreferredSize(new java.awt.Dimension(960, 684));

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
        labelSuplierBeli.setLabelFor(cbSuplierBeli);
        labelSuplierBeli.setText("Perusahaan:");

        labelJumlahPembelian.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelJumlahPembelian.setForeground(new java.awt.Color(51, 51, 51));
        labelJumlahPembelian.setLabelFor(inputJumlahPembelian);
        labelJumlahPembelian.setText("Jumlah :");

        tableTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "transaction_id", "item name", "company", "amount", "action"
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

        cbSuplierBeli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Company" }));
        cbSuplierBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSuplierBeliActionPerformed(evt);
            }
        });

        btnTambahPembelian.setBackground(new java.awt.Color(22, 103, 15));
        btnTambahPembelian.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnTambahPembelian.setForeground(new java.awt.Color(255, 255, 255));
        btnTambahPembelian.setText("Tambah");

        inputDeskripsiBarang.setColumns(20);
        inputDeskripsiBarang.setRows(5);
        jScrollPane9.setViewportView(inputDeskripsiBarang);

        labelPembelian1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        labelPembelian1.setForeground(new java.awt.Color(51, 51, 51));
        labelPembelian1.setText("Penjualan");

        labelKodeBarangBeliJual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelKodeBarangBeliJual.setForeground(new java.awt.Color(51, 51, 51));
        labelKodeBarangBeliJual.setText("Kode barang: ");

        cbKodeBarangBeliJual.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbKodeBarangBeliJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKodeBarangBeliJualActionPerformed(evt);
            }
        });

        labelPerusahaanJual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelPerusahaanJual.setForeground(new java.awt.Color(51, 51, 51));
        labelPerusahaanJual.setText("Perusahaan");

        cbPerusahaanJual.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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
                        .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelKodeBarangBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(transaksiPageLayout.createSequentialGroup()
                                .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(transaksiPageLayout.createSequentialGroup()
                                        .addComponent(labelJumlahPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transaksiPageLayout.createSequentialGroup()
                                        .addComponent(labelDeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnTambahPembelian)
                                        .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cbSuplierBeli, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(inputJumlahPembelian, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.LEADING)))
                                    .addComponent(inputKBarangBeli)
                                    .addComponent(inputNBarang)))
                            .addComponent(labelNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelSuplierBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(transaksiPageLayout.createSequentialGroup()
                                .addComponent(labelPembelian1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(258, 329, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transaksiPageLayout.createSequentialGroup()
                                .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(transaksiPageLayout.createSequentialGroup()
                                        .addComponent(labelKodeBarangBeliJual, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbKodeBarangBeliJual, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(transaksiPageLayout.createSequentialGroup()
                                        .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(labelJumlahPenjualan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(labelPerusahaanJual, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbPerusahaanJual, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(inputJumlahPenjualan)))
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
                        .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(transaksiPageLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transaksiPageLayout.createSequentialGroup()
                                        .addComponent(labelSuplierBeli)
                                        .addGap(8, 8, 8))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transaksiPageLayout.createSequentialGroup()
                                        .addComponent(labelNamaBarang)
                                        .addGap(37, 37, 37)))
                                .addComponent(labelJumlahPembelian)
                                .addGap(7, 7, 7))
                            .addGroup(transaksiPageLayout.createSequentialGroup()
                                .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(transaksiPageLayout.createSequentialGroup()
                                        .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(transaksiPageLayout.createSequentialGroup()
                                                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(labelPembelian1, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(labelPembelian, javax.swing.GroupLayout.Alignment.TRAILING)))
                                            .addGroup(transaksiPageLayout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(inputKBarangBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(labelKodeBarangBeli))))
                                        .addGap(57, 57, 57))
                                    .addGroup(transaksiPageLayout.createSequentialGroup()
                                        .addGap(187, 187, 187)
                                        .addComponent(cbSuplierBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputJumlahPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(transaksiPageLayout.createSequentialGroup()
                                .addComponent(labelDeskripsi)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTambahPembelian))
                    .addGroup(transaksiPageLayout.createSequentialGroup()
                        .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(transaksiPageLayout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(inputNBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(transaksiPageLayout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelKodeBarangBeliJual)
                                    .addComponent(cbKodeBarangBeliJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelPerusahaanJual)
                                    .addComponent(cbPerusahaanJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(transaksiPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(transaksiPageLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(inputJumlahPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(labelJumlahPenjualan))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTambahPenjualan)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
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
                .addContainerGap(601, Short.MAX_VALUE))
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

        inputJmlBarangLapor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputJmlBarangLaporActionPerformed(evt);
            }
        });

        labelJmlBarangLapor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelJmlBarangLapor.setForeground(new java.awt.Color(51, 51, 51));
        labelJmlBarangLapor.setText("Jumlah");

        inputNPelapor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNPelaporActionPerformed(evt);
            }
        });

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
                "issue_id", "item_id", "employee_id", "quantity", "description"
            }
        ));
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

        cbKodeBarangLapor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        taKeterangan.setColumns(20);
        taKeterangan.setRows(5);
        jScrollPane7.setViewportView(taKeterangan);

        javax.swing.GroupLayout laporBarangPageLayout = new javax.swing.GroupLayout(laporBarangPage);
        laporBarangPage.setLayout(laporBarangPageLayout);
        laporBarangPageLayout.setHorizontalGroup(
            laporBarangPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header4)
            .addGroup(laporBarangPageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(laporBarangPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, laporBarangPageLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(inputCariLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCariLaporan))
                    .addGroup(laporBarangPageLayout.createSequentialGroup()
                        .addGroup(laporBarangPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(laporBarangPageLayout.createSequentialGroup()
                                .addComponent(labelKodeBarangLapor, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbKodeBarangLapor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, laporBarangPageLayout.createSequentialGroup()
                                .addComponent(labelNPelapor, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputNPelapor))
                            .addGroup(laporBarangPageLayout.createSequentialGroup()
                                .addComponent(lableKeteranganLapor, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7))
                            .addGroup(laporBarangPageLayout.createSequentialGroup()
                                .addComponent(labelJmlBarangLapor, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputJmlBarangLapor, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSimpanLaporan, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(labelJmlBarangLapor)
                    .addComponent(inputJmlBarangLapor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(laporBarangPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNPelapor)
                    .addComponent(inputNPelapor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(laporBarangPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lableKeteranganLapor)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSimpanLaporan)
                .addGap(7, 7, 7)
                .addGroup(laporBarangPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCariLaporan)
                    .addComponent(inputCariLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
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

        labelKodeBarangEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelKodeBarangEdit.setForeground(new java.awt.Color(51, 51, 51));
        labelKodeBarangEdit.setText("Kode barang: ");

        labelNamaBarangEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelNamaBarangEdit.setForeground(new java.awt.Color(51, 51, 51));
        labelNamaBarangEdit.setText("Nama barang: ");

        labelDeskripsiEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDeskripsiEdit.setForeground(new java.awt.Color(51, 51, 51));
        labelDeskripsiEdit.setText("Deskripsi");

        labelKategoriEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelKategoriEdit.setForeground(new java.awt.Color(51, 51, 51));
        labelKategoriEdit.setText("Perusahaan:");

        cbKategoriEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbKategoriEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKategoriEditActionPerformed(evt);
            }
        });

        inputNBarangEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNBarangEditActionPerformed(evt);
            }
        });

        cbKodeBarangEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbKodeBarangEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKodeBarangEditActionPerformed(evt);
            }
        });

        taDeskripsiEdit.setColumns(20);
        taDeskripsiEdit.setRows(5);
        jScrollPane8.setViewportView(taDeskripsiEdit);

        btnSimpanBarang.setBackground(new java.awt.Color(22, 103, 15));
        btnSimpanBarang.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnSimpanBarang.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpanBarang.setText("Simpan");
        btnSimpanBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanBarangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout stokPageLayout = new javax.swing.GroupLayout(stokPage);
        stokPage.setLayout(stokPageLayout);
        stokPageLayout.setHorizontalGroup(
            stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header2)
            .addGroup(stokPageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(stokPageLayout.createSequentialGroup()
                        .addGroup(stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSimpanBarang)
                            .addGroup(stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(stokPageLayout.createSequentialGroup()
                                    .addComponent(labelKategoriEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbKategoriEdit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(labelPembelian2)
                                .addGroup(stokPageLayout.createSequentialGroup()
                                    .addComponent(labelDeskripsiEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(stokPageLayout.createSequentialGroup()
                                    .addGroup(stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(labelNamaBarangEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                        .addComponent(labelKodeBarangEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(inputNBarangEdit)
                                        .addComponent(cbKodeBarangEdit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stokPageLayout.createSequentialGroup()
                        .addGroup(stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(stokPageLayout.createSequentialGroup()
                                .addGap(384, 384, 384)
                                .addComponent(inputPencarianBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCariBarang)))
                        .addContainerGap())))
        );
        stokPageLayout.setVerticalGroup(
            stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stokPageLayout.createSequentialGroup()
                .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelPembelian2)
                .addGap(14, 14, 14)
                .addGroup(stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelKodeBarangEdit)
                    .addComponent(cbKodeBarangEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelNamaBarangEdit)
                    .addComponent(inputNBarangEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelKategoriEdit)
                    .addComponent(cbKategoriEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDeskripsiEdit)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSimpanBarang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(stokPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCariBarang)
                    .addComponent(inputPencarianBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(601, Short.MAX_VALUE))
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
        labelNIP.setText("NIP:");

        inputNIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNIPActionPerformed(evt);
            }
        });

        labelNamaKaryawan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelNamaKaryawan.setForeground(new java.awt.Color(51, 51, 51));
        labelNamaKaryawan.setText("Nama Karyawan: ");

        labelDepartemen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDepartemen.setForeground(new java.awt.Color(51, 51, 51));
        labelDepartemen.setText("Department:");

        inputNKaryawan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNKaryawan1ActionPerformed(evt);
            }
        });

        cbDepartemen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                "NIP", "Nama", "Departemen"
            }
        ));
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
                            .addComponent(labelDepartemen, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(karyawanPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbDepartemen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inputNKaryawan1)
                            .addComponent(inputNIP)))
                    .addGroup(karyawanPageLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(karyawanPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(karyawanPageLayout.createSequentialGroup()
                                .addComponent(inputCariKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCariKaryawan))
                            .addGroup(karyawanPageLayout.createSequentialGroup()
                                .addComponent(btnTambahKaryawan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnResetKaryawan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeleteKaryawan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdateKaryawan)))))
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
                    .addComponent(btnUpdateKaryawan)
                    .addComponent(btnDeleteKaryawan)
                    .addComponent(btnTambahKaryawan)
                    .addComponent(btnResetKaryawan))
                .addGap(45, 45, 45)
                .addGroup(karyawanPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCariKaryawan)
                    .addComponent(inputCariKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 46, Short.MAX_VALUE))
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
                .addContainerGap(601, Short.MAX_VALUE))
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

        btnHapusPencarian.setBackground(new java.awt.Color(115, 114, 114));
        btnHapusPencarian.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnHapusPencarian.setForeground(new java.awt.Color(255, 255, 255));
        btnHapusPencarian.setText("Hapus Pencarian");
        btnHapusPencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusPencarianActionPerformed(evt);
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
                    .addGroup(suplierPageLayout.createSequentialGroup()
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
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, suplierPageLayout.createSequentialGroup()
                                .addComponent(btnTambahSuplier)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnResetSuplier3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeleteSuplier2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdateSuplier1)))
                        .addGap(0, 420, Short.MAX_VALUE))
                    .addComponent(jScrollPane5)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, suplierPageLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(inputCariPerusahaan, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapusPencarian)
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
                    .addComponent(btnHapusPencarian))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
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
            .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaksiActionPerformed
        cardLayout.show(panelPages, "transaksiPage");
    }//GEN-LAST:event_btnTransaksiActionPerformed

    private void btnLaporBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaporBarangActionPerformed
        cardLayout.show(panelPages, "laporBarangPage");
    }//GEN-LAST:event_btnLaporBarangActionPerformed

    private void btnStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStokActionPerformed
        cardLayout.show(panelPages, "stokPage");
    }//GEN-LAST:event_btnStokActionPerformed

    private void btnKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaryawanActionPerformed
        cardLayout.show(panelPages, "karyawanPage");
    }//GEN-LAST:event_btnKaryawanActionPerformed

    private void btnLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoActionPerformed
        cardLayout.show(panelPages, "tambahTransaksi");
    }//GEN-LAST:event_btnLogoActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnCariBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCariBarangActionPerformed

    private void btnSuplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuplierActionPerformed
        cardLayout.show(panelPages, "suplierPage");
    }//GEN-LAST:event_btnSuplierActionPerformed

    private void inputNIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNIPActionPerformed

    private void inputNKaryawan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNKaryawan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNKaryawan1ActionPerformed

    private void inputNPerusahaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNPerusahaanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNPerusahaanActionPerformed

    private void inputEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputEmailActionPerformed

    private void inputTeleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTeleponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTeleponActionPerformed

    private void inputJmlBarangLaporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputJmlBarangLaporActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputJmlBarangLaporActionPerformed

    private void inputNPelaporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNPelaporActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNPelaporActionPerformed

    private void btnSimpanLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanLaporanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSimpanLaporanActionPerformed

    private void btnCariLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariLaporanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCariLaporanActionPerformed

    private void btnCariKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCariKaryawanActionPerformed

    private void btnCariSuplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariSuplierActionPerformed
        // TODO add your handling code here:
        String searchItem = inputCariPerusahaan.getText();
        
        companyController.searchCompany(
                this,
                searchItem,
                modelSuplier,
                inputCariPerusahaan,
                btnHapusPencarian,
                btnCariSuplier
        );
    }//GEN-LAST:event_btnCariSuplierActionPerformed

    private void btnCariBarang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariBarang1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCariBarang1ActionPerformed

    private void inputNBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNBarangActionPerformed

    private void cbSuplierBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSuplierBeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSuplierBeliActionPerformed

    private void cbKategoriEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKategoriEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbKategoriEditActionPerformed

    private void inputNBarangEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNBarangEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNBarangEditActionPerformed

    private void cbKodeBarangEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKodeBarangEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbKodeBarangEditActionPerformed

    private void cbKodeBarangBeliJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKodeBarangBeliJualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbKodeBarangBeliJualActionPerformed

    private void cbPerusahaanJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPerusahaanJualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPerusahaanJualActionPerformed

    private void btnSimpanBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSimpanBarangActionPerformed

    private void btnTambahSuplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahSuplierActionPerformed
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
                    modelSuplier
            );

            inputNPerusahaan.setText("");
            inputEmail.setText("");
            inputTelepon.setText("");
            taAlamat.setText("");

            addItemComboBox();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnTambahSuplierActionPerformed

    private void tableTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTransaksiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableTransaksiMouseClicked

    private void tableSuplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSuplierMouseClicked
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
    }//GEN-LAST:event_tableSuplierMouseClicked

    private void btnUpdateSuplier1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSuplier1ActionPerformed
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
                    oldName
            );

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
    }//GEN-LAST:event_btnUpdateSuplier1ActionPerformed

    private void btnDeleteSuplier2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSuplier2ActionPerformed
        // TODO add your handling code here:
        try {
            int row = tableSuplier.getSelectedRow();

            String oldName = companyController.getCompanyList().get(row).getCompany_name();

            companyController.deleteCompany(
                    this,
                    modelSuplier,
                    oldName
            );

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
    }//GEN-LAST:event_btnDeleteSuplier2ActionPerformed

    private void btnResetSuplier3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetSuplier3ActionPerformed
        // TODO add your handling code here:
        inputNPerusahaan.setText("");
        inputEmail.setText("");
        inputTelepon.setText("");
        taAlamat.setText("");

        btnTambahSuplier.setVisible(true);
        btnUpdateSuplier1.setVisible(false);
        btnDeleteSuplier2.setVisible(false);
        btnResetSuplier3.setVisible(false);
    }//GEN-LAST:event_btnResetSuplier3ActionPerformed

    private void btnUpdateKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateKaryawanActionPerformed

    private void btnDeleteKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteKaryawanActionPerformed

    private void btnResetKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetKaryawanActionPerformed

    private void btnTambahKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTambahKaryawanActionPerformed

    private void btnHapusPencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusPencarianActionPerformed
        // TODO add your handling code here:
        inputCariPerusahaan.setText("");
        
        companyController.loadCompany(modelSuplier);
        
        btnCariSuplier.setVisible(true);
        btnHapusPencarian.setVisible(false);
    }//GEN-LAST:event_btnHapusPencarianActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
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
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Home().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Sidebar;
    private javax.swing.JButton btnCariBarang;
    private javax.swing.JButton btnCariBarang1;
    private javax.swing.JButton btnCariKaryawan;
    private javax.swing.JButton btnCariLaporan;
    private javax.swing.JButton btnCariSuplier;
    private javax.swing.JButton btnDeleteKaryawan;
    private javax.swing.JButton btnDeleteSuplier2;
    private javax.swing.JButton btnHapusPencarian;
    private javax.swing.JButton btnKaryawan;
    private javax.swing.JButton btnLaporBarang;
    private javax.swing.JButton btnLogo;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnResetKaryawan;
    private javax.swing.JButton btnResetSuplier3;
    private javax.swing.JButton btnSimpanBarang;
    private javax.swing.JButton btnSimpanLaporan;
    private javax.swing.JButton btnStok;
    private javax.swing.JButton btnSuplier;
    private javax.swing.JButton btnTambahKaryawan;
    private javax.swing.JButton btnTambahPembelian;
    private javax.swing.JButton btnTambahPenjualan;
    private javax.swing.JButton btnTambahSuplier;
    private javax.swing.JButton btnTransaksi;
    private javax.swing.JButton btnUpdateKaryawan;
    private javax.swing.JButton btnUpdateSuplier1;
    private javax.swing.JComboBox<String> cbDepartemen;
    private javax.swing.JComboBox<String> cbKategoriEdit;
    private javax.swing.JComboBox<String> cbKodeBarangBeliJual;
    private javax.swing.JComboBox<String> cbKodeBarangEdit;
    private javax.swing.JComboBox<String> cbKodeBarangLapor;
    private javax.swing.JComboBox<String> cbPerusahaanJual;
    private javax.swing.JComboBox<String> cbSuplierBeli;
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
    private javax.swing.JTextField inputEmail;
    private javax.swing.JTextField inputJmlBarangLapor;
    private javax.swing.JTextField inputJumlahPembelian;
    private javax.swing.JTextField inputJumlahPenjualan;
    private javax.swing.JTextField inputKBarangBeli;
    private javax.swing.JTextField inputNBarang;
    private javax.swing.JTextField inputNBarangEdit;
    private javax.swing.JTextField inputNIP;
    private javax.swing.JTextField inputNKaryawan1;
    private javax.swing.JTextField inputNPelapor;
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
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelJmlBarangLapor;
    private javax.swing.JLabel labelJumlahPembelian;
    private javax.swing.JLabel labelJumlahPenjualan;
    private javax.swing.JLabel labelKategoriEdit;
    private javax.swing.JLabel labelKodeBarangBeli;
    private javax.swing.JLabel labelKodeBarangBeliJual;
    private javax.swing.JLabel labelKodeBarangEdit;
    private javax.swing.JLabel labelKodeBarangLapor;
    private javax.swing.JLabel labelNIP;
    private javax.swing.JLabel labelNPelapor;
    private javax.swing.JLabel labelNPerusahaan;
    private javax.swing.JLabel labelNamaBarang;
    private javax.swing.JLabel labelNamaBarangEdit;
    private javax.swing.JLabel labelNamaKaryawan;
    private javax.swing.JLabel labelPembelian;
    private javax.swing.JLabel labelPembelian1;
    private javax.swing.JLabel labelPembelian2;
    private javax.swing.JLabel labelPerusahaanJual;
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
