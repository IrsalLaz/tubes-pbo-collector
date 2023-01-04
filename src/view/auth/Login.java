package view.auth;

import controller.AdminController;
import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Login extends JFrame {

    private final AdminController admin = new AdminController();

    public Login() {
        initComponents();
        Image icon = new ImageIcon(this.getClass().getResource("/assets/iconApp.png")).getImage();
        this.setIconImage(icon);
        this.setTitle("Collector | login");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        labelUsername = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        labelPassword = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        tfPassword = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        labelUsername.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        labelUsername.setLabelFor(labelUsername);
        labelUsername.setText("Name");

        labelPassword.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        labelPassword.setText("Password");

        btnLogin.setBackground(new java.awt.Color(38, 38, 38));
        btnLogin.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        tfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(labelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfName, javax.swing.GroupLayout.DEFAULT_SIZE, 372,
                                                Short.MAX_VALUE)
                                        .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfPassword))
                                .addContainerGap(76, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(249, 249, 249)
                                .addComponent(labelUsername)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelPassword)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btnLogin)
                                .addContainerGap(264, Short.MAX_VALUE)));

        jPanel1.setBackground(new java.awt.Color(38, 38, 38));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo big.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(258, 258, 258)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(307, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfPasswordActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfPasswordActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tfPasswordActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String name = tfName.getText();
        // String pass = tfPassword.getText();
        char[] password = tfPassword.getPassword();
        String pass = new String(password);

        try {
            admin.login(this, this, name, pass);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }// GEN-LAST:event_btnLoginActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JTextField tfName;
    private javax.swing.JPasswordField tfPassword;
    // End of variables declaration//GEN-END:variables
}
